package com.kxm.kcgl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kxm.kcgl.domain.ProductQueryTimes;
import com.kxm.kcgl.mapper.ProductQueryTimesMapper;

@Service
public class ProductQueryTimesService {
	@Autowired
	private ProductQueryTimesMapper productQueryTimesMapper;

	@Transactional
	public int insert(ProductQueryTimes productQueryTimes) {
		return productQueryTimesMapper.insert(productQueryTimes);
	}
}
