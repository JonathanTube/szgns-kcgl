package com.kxm.kcgl.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kxm.kcgl.LogicException;
import com.kxm.kcgl.domain.Bill;
import com.kxm.kcgl.domain.ProductOut;
import com.kxm.kcgl.domain.Stock;
import com.kxm.kcgl.mapper.BillMapper;
import com.kxm.kcgl.mapper.ProductOutMapper;
import com.kxm.kcgl.mapper.StockMapper;

/**
 *
 * @author kongxm
 * @date 2015 2015年7月27日 下午4:27:43
 */
@Service
public class ProductOutService {
	@Autowired
	private ProductOutMapper productOutMapper;

	@Autowired
	private StockMapper stockMapper;

	@Autowired
	private BillMapper billMapper;

	public void insert(ProductOut productOut) {
		productOutMapper.insert(productOut);
	}

	@Transactional(rollbackFor = Exception.class)
	public void productOut(List<ProductOut> productOutList,
			Integer createUserId, Integer custId) throws LogicException {
		if (productOutList.size() == 0) {
			throw new LogicException("请填写出货单");
		}
		if (custId == null || custId < 0) {
			throw new LogicException("请填写客户");
		}
		// 记录出货单
		Bill bill = new Bill();
		bill.setSeq(getSeq());
		bill.setCreateUserId(createUserId);
		bill.setCustId(custId);
		billMapper.insert(bill);
		int totalAmount = 0;
		double totalPrice = 0D;
		double totalMoney = 0D;
		for (ProductOut productOut : productOutList) {
			Stock stock = new Stock();
			stock.setProductId(productOut.getProductId());
			stock.setIdentifyType(productOut.getIdentifyType());
			stock.setIdentifyId(productOut.getIdentifyId());
			stock.setManufactorId(productOut.getManufactorId());
			// 校验库存数量
			checkStockAndPrice(productOut, stock);
			// 校验数量
			checkParam(productOut);
			// 减去库存数量
			stock.setAmount(productOut.getAmount() * -1);
			stockMapper.update(stock);
			// 记录出货日志
			productOut.setBillId(bill.getId());
			double money = productOut.getAmount() * productOut.getPrice();
			productOut.setMoney(money);
			productOutMapper.insert(productOut);

			// 累加
			totalAmount += productOut.getAmount();
			totalPrice += productOut.getPrice();
			totalMoney += money;
		}
		// 更新出货单统计数据
		bill.setTotalAmount(totalAmount);
		bill.setTotalMoney(totalMoney);
		bill.setTotalPrice(totalPrice);
		billMapper.update(bill);
	}

	public List<ProductOut> selectSelective(ProductOut po) {
		return productOutMapper.selectSelective(po);
	}

	private void checkStockAndPrice(ProductOut productOut, Stock stock)
			throws LogicException {
		// 需要查找一下,防止库存不足,和价格调价
		String productName = productOut.getProductName();
		List<Stock> stocks = stockMapper.selectSelective(stock);
		if (stocks.size() > 0) {
			Stock exist = stocks.get(0);
			// 库存量校验
			if (productOut.getAmount() > exist.getAmount()) {
				productOut.setStockAmount(exist.getAmount());
				throw new LogicException(productName + ",库存已变化，出货量不能大于库存量");
			}
			// 价格校验
			if (productOut.getPrice() < exist.getPrice()) {
				productOut.setStockPrice(exist.getPrice());
				throw new LogicException(productName + ",产品被调价,销售价格不能低于出厂价格");
			}
		}
	}

	private void checkParam(ProductOut productOut) throws LogicException {
		// 参数校验
		String productName = productOut.getProductName();
		if (productOut.getStockAmount() == 0) {
			throw new LogicException(productName + ",库存不足,不能出货");
		}
		if (productOut.getAmount() > productOut.getStockAmount()) {
			throw new LogicException(productName + ",出货量不能大于库存量");
		}
		if (productOut.getPrice() < productOut.getStockPrice()) {
			throw new LogicException(productName + ",销售价格不能小于出厂价");
		}
	}

	public static String getSeq() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMddHHmmssSSS");
		return sdf.format(date) + RandomStringUtils.randomNumeric(3);
	}
}
