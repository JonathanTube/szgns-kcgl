package com.kxm.kcgl.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyjd.frame.psm.utils.MsgTool;
import com.kxm.kcgl.LogicException;
import com.kxm.kcgl.domain.Bill;
import com.kxm.kcgl.domain.PreProductOut;
import com.kxm.kcgl.domain.Product;
import com.kxm.kcgl.domain.ProductOut;
import com.kxm.kcgl.domain.User;
import com.kxm.kcgl.mapper.BillMapper;
import com.kxm.kcgl.mapper.PreProductOutMapper;
import com.kxm.kcgl.mapper.ProductMapper;
import com.kxm.kcgl.mapper.ProductOutMapper;

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
	private BillMapper billMapper;

	@Autowired
	private ProductMapper productMapper;
	
	@Autowired
	private PreProductOutMapper preProductOutMapper;
	
	public void insert(ProductOut productOut) {
		productOutMapper.insert(productOut);
	}

	@Transactional(rollbackFor = Exception.class)
	public void productOut(List<ProductOut> productOutList, Integer createUserId, Integer custId) throws LogicException {
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
			Product product = new Product();
			product.setId(productOut.getProductId());
			product.setCreateUserId(createUserId);//这里将登陆用户的id借用产品的create_user_id传递到后台，用来查询产品的时候，剔除掉自己的与出货部分
			// 校验库存数量
			checkStockAndPrice(productOut, product);
			// 校验数量
			checkParam(productOut);
			// 减去库存数量
			product.setAmount(productOut.getAmount() * -1);
			productMapper.update(product);
			// 记录出货日志
			productOut.setBillId(bill.getId());
			double money = productOut.getAmount() * productOut.getPrice();
			productOut.setMoney(money);
			productOut.setCustId(custId);
			productOutMapper.insert(productOut);
			
			
			//将自己预出货记录失效掉(简单处理)
			PreProductOut condition = new PreProductOut();
			condition.setProductId(productOut.getProductId());
			condition.setCreateUserId(createUserId);
			condition.setStatus(1);
			preProductOutMapper.update(condition);
			
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

	private void checkStockAndPrice(ProductOut productOut, Product product) throws LogicException {
		// 需要查找一下,防止库存不足,和价格调价
		String productName = productOut.getProductName();
		Product exist = productMapper.selectCanOutProduct(product);
		// 出货量不能为0
		if (productOut.getAmount() <= 0) {
			throw new LogicException("产品:" + productName + ",出货量必须是大于0的整数");
		}
		// 库存量校验
		if (productOut.getAmount() > exist.getAmount()) {
			productOut.setStockAmount(exist.getAmount());
			throw new LogicException("产品:" + productName + ",库存已变化，出货量不能大于库存量");
		}
		// 价格校验
		if (productOut.getPrice() < exist.getPrice()) {
			productOut.setStockPrice(exist.getPrice());
			throw new LogicException("产品:" + productName + ",产品被调价,销售价格不能低于出厂价格");
		}
	}

	private void checkParam(ProductOut productOut) throws LogicException {
		// 参数校验
		String productName = productOut.getProductName();
		if (productOut.getStockAmount() == 0) {
			throw new LogicException("产品:" + productName + ",库存不足,不能出货");
		}
		if (productOut.getAmount() > productOut.getStockAmount()) {
			throw new LogicException("产品:" + productName + ",出货量不能大于库存量");
		}
		if (productOut.getPrice() < productOut.getStockPrice()) {
			throw new LogicException("产品:" + productName + ",销售价格不能小于出厂价");
		}
	}

	public void addProductOut(List<Product> productList, List<ProductOut> productOutList, User user) throws LogicException {
		if (productList == null || productList.size() == 0) {
			MsgTool.addInfoMsg("未查询到产品库存");
			return;
		}
		for (Product product : productList) {
			ProductOut productOut = assembProductOut(product, user);

			// 判断是否已经添加过
			if (productOutList.contains(productOut)) {
				throw new LogicException("请勿重复添加已存在的出货产品");
			} else {
				productOutList.add(productOut);
			}
		}
	}

	public ProductOut getProductOut(Integer productId ,User user){
		Product condition = new Product();
		condition.setId(productId);
		Product product = productMapper.selectCanOutProduct(condition);
		return assembProductOut(product,user);
	}

	private ProductOut assembProductOut(Product product,User user) {
		ProductOut productOut = new ProductOut();
		productOut.setBrandId(product.getBrandId());
		productOut.setBrandName(product.getBrandName());
		productOut.setProductId(product.getId());
		productOut.setProductName(product.getProductName());
		productOut.setTechId(product.getTechId());
		productOut.setTechName(product.getTechName());
		productOut.setProductNo(product.getProductNo());
		productOut.setThicknessId(product.getThicknessId());
		productOut.setThicknessName(product.getThicknessName());
		productOut.setManufactorId(product.getManufactorId());
		productOut.setManufactorName(product.getManufactorName());
		productOut.setIdentifyId(product.getIdentifyId());
		productOut.setIdentifyName(product.getIdentifyName());
		productOut.setQuantityId(product.getQuantityId());
		productOut.setQuantityName(product.getQuantityName());
		productOut.setStockAmount(product.getAmount());
		productOut.setStockPrice(product.getPrice());
		productOut.setCreateUserId(user.getId());
		productOut.setCreateUserName(user.getRealname());
		productOut.setPrice(product.getPrice());//默认显示出货价格==产品价格
		return productOut;
	}
	
	public static String getSeq() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMddHHmmssSSS");
		return sdf.format(date) + RandomStringUtils.randomNumeric(3);
	}
}
