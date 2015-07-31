package com.kxm.kcgl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kxm.kcgl.domain.PriceAdjust;
import com.kxm.kcgl.domain.Product;
import com.kxm.kcgl.mapper.PriceAdjustMapper;
import com.kxm.kcgl.mapper.ProductMapper;

@Service
public class PriceAdjustService {
	@Autowired
	private PriceAdjustMapper priceAdjustMapper;
	@Autowired
	private ProductMapper produtMapper;

	public void insert(List<PriceAdjust> tempList, Integer createUserId) {
		for (PriceAdjust priceAdjust : tempList) {
			priceAdjust.setCreateUserId(createUserId);
			// 记录调价日志
			priceAdjustMapper.insert(priceAdjust);
			// 产品调价
			Product product = new Product();
			product.setId(priceAdjust.getProductId());
			product.setPrice(priceAdjust.getAdjustPrice());
			produtMapper.update(product);
		}
	}

}
