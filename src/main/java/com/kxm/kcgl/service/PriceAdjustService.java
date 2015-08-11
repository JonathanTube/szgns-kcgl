package com.kxm.kcgl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kxm.kcgl.LogicException;
import com.kxm.kcgl.domain.PriceAdjust;
import com.kxm.kcgl.domain.Product;
import com.kxm.kcgl.mapper.PriceAdjustMapper;
import com.kxm.kcgl.mapper.ProductMapper;

@Service
public class PriceAdjustService {
	@Autowired
	private PriceAdjustMapper priceAdjustMapper;
	@Autowired
	private ProductMapper productMapper;

	public void priceAdjust(List<PriceAdjust> tempList, Integer createUserId) throws LogicException {
		for (PriceAdjust priceAdjust : tempList) {
			priceAdjust.setCreateUserId(createUserId);
			// 记录调价日志
			priceAdjustMapper.insert(priceAdjust);
			// 产品调价
			Product product = new Product();
			product.setId(priceAdjust.getProductId());
			product.setPrice(priceAdjust.getAdjustPrice());
			int size = productMapper.countBySelective(product);
			if (size > 0) {
				productMapper.update(product);
			} else {
				throw new LogicException("待调价产品不存在");
			}
		}
	}

}
