package com.kxm.kcgl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kxm.kcgl.LogicException;
import com.kxm.kcgl.domain.Product;
import com.kxm.kcgl.domain.ProductIn;
import com.kxm.kcgl.mapper.ProductInMapper;
import com.kxm.kcgl.mapper.ProductMapper;

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

	@Transactional(rollbackFor = Exception.class)
	public void addNotExist(ProductIn record) throws LogicException {
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
		product.setBrandId(record.getBrandId());
		product.setPrice(record.getPrice());
		product.setProductNo(record.getProductNo());
		product.setProductName(record.getProductName());
		product.setTechId(record.getTechId());
		product.setAmount(record.getInAmount());
		product.setThicknessId(record.getThicknessId());
		product.setIdentifyId(record.getIdentifyId());
		productMapper.insert(product);
		// 插入库日志
		record.setProductId(product.getId());
		productInMapper.insert(record);
	}

	@Transactional(rollbackFor = Exception.class)
	public void addExist(List<ProductIn> productInList,int userId) {
		for (ProductIn productIn : productInList) {
			productIn.setCreateUserId(userId);
			productInMapper.insert(productIn);
			//更新产品库存数
			Product product = new Product();
			product.setId(productIn.getProductId());
			product.setAmount(productIn.getInAmount());
			product.setPrice(productIn.getPrice());
			productMapper.updateAmount(product);
		}
	}
}
