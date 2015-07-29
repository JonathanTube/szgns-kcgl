package com.kxm.kcgl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kxm.kcgl.domain.Stock;
import com.kxm.kcgl.mapper.StockMapper;

@Service
public class StockService {

	@Autowired
	private StockMapper stockMapper;

	public List<Stock> selectSelective(Stock stock) {
		return stockMapper.selectSelective(stock);
	}
}
