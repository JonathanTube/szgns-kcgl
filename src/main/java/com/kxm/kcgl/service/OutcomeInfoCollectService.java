package com.kxm.kcgl.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kxm.kcgl.dao.BillDao;
import com.kxm.kcgl.dao.OutcomeInfoCollectDao;
import com.kxm.kcgl.dao.StockDao;
import com.kxm.kcgl.domain.Bill;
import com.kxm.kcgl.domain.OutcomeInfoBean;
import com.kxm.kcgl.domain.Stock;

@Service
public class OutcomeInfoCollectService {
	private static Gson gson = new Gson();

	@Autowired
	private OutcomeInfoCollectDao outcomeInfoCollectDao;

	@Autowired
	private StockDao stockDao;

	@Autowired
	private BillDao billDao;

	@Transactional
	public String addOutcomeInfos(String json, String userName) {
		if (StringUtils.isEmpty(userName)) {
			return "出货信息保存失败。";
		}
		// 添加单据主表
		String seq = "S";
		if ("szgns".equals(userName)) {
			seq += "S";
		} else if ("dgsy".equals(userName)) {
			seq += "D";
		}
		String time = new SimpleDateFormat("yyyyMMdd").format(new Date());
		seq += time;
		int count = billDao.countByDate(seq);

		if (count > 0) {
			String existSeq = billDao.queryByDate(seq);
			int suffix = Integer.parseInt(existSeq.substring(9));
			suffix += 1;
			seq += String.format("%04d", suffix);
		} else {
			seq += "0000";
		}

		Bill billBean = new Bill();
		billBean.setSeq(seq);
		billDao.insert(billBean);

		List<OutcomeInfoBean> retList = gson.fromJson(json, new TypeToken<List<OutcomeInfoBean>>() {
		}.getType());
		int size = 0;
		for (OutcomeInfoBean b : retList) {
			b.setSeq(seq);
			outcomeInfoCollectDao.add(b);
			size++;

			Stock stockBean = new Stock();
			stockBean.setBrandId(b.getBrandId());
			stockBean.setProductId(b.getProductId());
			stockBean.setTechId(b.getTechId());
			stockBean.setThicknessId(b.getThicknessId());
			stockBean.setAmount(b.getAmount());

			if (stockDao.hasAmount(stockBean)) {
				stockBean.setAmount(b.getAmount() * -1);
				stockDao.update(stockBean);
			} else {
				throw new RuntimeException("第" + size + "条记录，库存不足。");
			}
		}
		return size + "条记录保存成功。";

	}

	public static void main(String[] args) {
		System.out.println(String.format("%04d", 23));
	}
}
