package com.kxm.kcgl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kxm.kcgl.dao.IncomeInfoCollectDao;
import com.kxm.kcgl.dao.StockDao;
import com.kxm.kcgl.domain.IncomeInfoBean;
import com.kxm.kcgl.domain.Stock;

@Service
public class IncomeInfoCollectService {
	private static Gson gson = new Gson();

	@Autowired
	private IncomeInfoCollectDao incomeInfoCollectDao;

	@Autowired
	private StockDao stockDao;
	
	@Transactional
	public int addIncomeInfos(String json) {
		List<IncomeInfoBean> retList = gson.fromJson(json,
				new TypeToken<List<IncomeInfoBean>>() {
				}.getType());
		int size = 0;
		for (IncomeInfoBean b : retList) {
			incomeInfoCollectDao.add(b);
			size ++;
			Stock stockBean = new Stock();
			stockBean.setBrandId(b.getBrandId());
			stockBean.setProductId(b.getProductId());
			stockBean.setTechId(b.getTechId());
			stockBean.setThicknessId(b.getThicknessId());
			stockBean.setAmount(b.getAmount());
			if (stockDao.isRecordExist(stockBean)) {
				stockDao.update(stockBean);
			} else {
				stockDao.insert(stockBean);
			}
		}
		return size;
	}

}
