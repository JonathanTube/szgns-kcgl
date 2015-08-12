package com.kxm.kcgl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kxm.kcgl.domain.Product;
import com.kxm.kcgl.mapper.ProductMapper;

/**
 *
 * @author kongxm
 * @date 2015 2015年7月27日 上午10:00:55
 */
@Service
public class ProductService {

	@Autowired
	private ProductMapper productMapper;

	public Product queryByProductNo(String productNo) {
		Product condition = new Product();
		condition.setProductNo(productNo);
		List<Product> list = productMapper.selectSelective(condition);
		if (list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	public Product queryByProductId(int productId) {
		Product condition = new Product();
		condition.setId(productId);
		List<Product> list = productMapper.selectSelective(condition);
		if (list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	public Product queryByProductName(String productName) {
		Product condition = new Product();
		condition.setProductName(productName);
		List<Product> list = productMapper.selectSelective(condition);
		if (list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	public List<Product> search(Product product) {
		return productMapper.search(product);
	}

	public List<Product> selectSelective(Product product) {
		return productMapper.selectSelective(product);
	}

}
