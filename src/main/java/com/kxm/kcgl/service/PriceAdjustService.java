package com.kxm.kcgl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kxm.kcgl.domain.Price;
import com.kxm.kcgl.domain.PriceAdjust;
import com.kxm.kcgl.mapper.PriceAdjustMapper;
import com.kxm.kcgl.mapper.PriceMapper;

@Service
public class PriceAdjustService {
	@Autowired
	private PriceAdjustMapper priceAdjustMapper;
	@Autowired
	private PriceMapper priceMapper;

	public void priceAdjust(List<PriceAdjust> tempList, Integer createUserId) {
		for (PriceAdjust priceAdjust : tempList) {
			priceAdjust.setCreateUserId(createUserId);
			// 记录调价日志
			priceAdjustMapper.insert(priceAdjust);
			// 产品调价
			Price price = new Price();
			price.setProductId(priceAdjust.getProductId());
			price.setQuantityId(priceAdjust.getQuantityId());
			price.setPrice(priceAdjust.getAdjustPrice());
			int size = priceMapper.countBySelective(price);
			if (size > 0) {
				priceMapper.update(price);
			} else {
				priceMapper.insert(price);
			}
		}
	}

}
