package com.kxm.kcgl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kxm.kcgl.dao.StockDao;
import com.kxm.kcgl.domain.StockBean;

@Service
public class StockService {

	@Autowired
	private StockDao storeDao;
	
	
	public List<StockBean> queryAll() {
		return storeDao.queryAll();
	}

}
