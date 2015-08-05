package com.kxm.kcgl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kxm.kcgl.domain.Price;
import com.kxm.kcgl.mapper.PriceMapper;

/**
 *
 * @author kongxm
 * @date 2015 2015年7月27日 上午10:00:55
 */
@Service
public class PriceService {

	@Autowired
	private PriceMapper priceMapper;

	public List<Price> queryByProductNo(String productNo) {
		Price condition = new Price();
		condition.setProductNo(productNo);
		List<Price> list = priceMapper.selectSelective(condition);
		return list;
	}

	public List<Price> queryByProductId(int productId) {
		Price condition = new Price();
		condition.setProductId(productId);
		List<Price> list = priceMapper.selectSelective(condition);
		return list;
	}
}
