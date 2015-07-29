package com.kxm.kcgl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kxm.kcgl.LogicException;
import com.kxm.kcgl.domain.Product;
import com.kxm.kcgl.domain.ProductIn;
import com.kxm.kcgl.domain.Stock;
import com.kxm.kcgl.mapper.ProductInMapper;
import com.kxm.kcgl.mapper.ProductMapper;
import com.kxm.kcgl.mapper.StockMapper;

/**
 *
 * @author kongxm
 * @date 2015 2015年7月26日 下午2:25:19
 */
@Service
public class ProductInService {

	@Autowired
	private ProductInMapper productInMapper;

	@Autowired
	private ProductMapper productMapper;

	@Autowired
	private StockMapper stockMapper;

	@Transactional(rollbackFor = Exception.class)
	public void addNotExist(ProductIn record) throws LogicException {
		// 插入库日志
		if (record.getIdentifyType() == 0) {// 中性标
			record.setIdentifyId(null);
		} else if (record.getIdentifyId() == -1) {
			throw new LogicException("请选择客户标名称");
		}

		// 判断是否未添加过,产品编号不能重复
		Product p1 = new Product();
		p1.setProductNo(record.getProductNo());
		List<Product> p1_list = productMapper.selectSelective(p1);
		if (p1_list.size() > 0) {
			throw new LogicException("产品编号已存在");
		}
		// 产品名称(型号不能重复)
		Product p2 = new Product();
		p2.setProductName(record.getProductName());
		List<Product> p2_list = productMapper.selectSelective(p2);
		if (p2_list.size() > 0) {
			throw new LogicException("产品名称已存在");
		}
		// 插入产品
		Product product = new Product();
		product.setProductNo(record.getProductNo());
		product.setProductName(record.getProductName());
		product.setBrandId(record.getBrandId());
		product.setTechId(record.getTechId());
		product.setThicknessId(record.getThicknessId());
		product.setPrice(record.getPrice());
		product.setCreateUserId(record.getCreateUserId());
		productMapper.insert(product);
		// 插入库存
		Stock stock = new Stock();
		stock.setProductId(product.getId());
		stock.setIdentifyType(record.getIdentifyType());
		stock.setIdentifyId(record.getIdentifyId());
		stock.setManufactorId(record.getManufactorId());
		stock.setAmount(record.getAmount());
		stockMapper.insert(stock);
		record.setProductId(product.getId());
		productInMapper.insert(record);
	}

	@Transactional(rollbackFor = Exception.class)
	public void addExist(List<ProductIn> productInList, int userId) {
		for (ProductIn productIn : productInList) {
			// init param
			Stock stock = new Stock();
			stock.setProductId(productIn.getProductId());
			stock.setIdentifyType(productIn.getIdentifyType());
			stock.setIdentifyId(productIn.getIdentifyId());
			stock.setManufactorId(productIn.getManufactorId());
			stock.setAmount(productIn.getAmount());
			// 判断库存是否存在
			int size = stockMapper.countBySelective(stock);
			if (size > 0) {
				// 更新产品库存数
				stockMapper.update(stock);
			} else {
				// insert
				stockMapper.insert(stock);
			}

			// 更新价格(入库时进行调价)
			Product product = new Product();
			product.setId(productIn.getProductId());
			product.setPrice(productIn.getPrice());
			productMapper.update(product);

			// 插入入库日志
			productIn.setCreateUserId(userId);
			productInMapper.insert(productIn);
		}
	}
}
