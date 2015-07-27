package com.kxm.kcgl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kxm.kcgl.dao.StockDao;
import com.kxm.kcgl.domain.Stock;

@Service
public class StockService {

	@Autowired
	private StockDao storeDao;
	
	
	public List<Stock> queryAll() {
		return storeDao.queryAll();
	}

}
