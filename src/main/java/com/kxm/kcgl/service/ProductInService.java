package com.kxm.kcgl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	public void addNotExist(ProductIn record) {
		// TODO：判断是否未添加过

		Product product = new Product();
		product.setBrandId(record.getBrandId());
		product.setPrice(record.getPrice());
		product.setProductNo(record.getProductNo());
		product.setProductName(record.getProductName());
		product.setTechId(record.getTechId());
		product.setThicknessId(record.getThicknessId());
		product.setIdentifyId(record.getIdentifyId());
		productMapper.insert(product);
		// 插入
		record.setProductId(product.getId());
		productInMapper.insert(record);
	}
}
