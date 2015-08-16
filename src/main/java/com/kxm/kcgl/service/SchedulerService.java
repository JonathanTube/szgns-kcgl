package com.kxm.kcgl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.kxm.kcgl.domain.PreProductOut;
import com.kxm.kcgl.mapper.PreProductOutMapper;

@Service
public class SchedulerService {
	@Autowired
	private PreProductOutMapper preProductOutMapper;

	/**
	 * 重置预出货状态
	 */
	@Scheduled(fixedRate=60 * 1000)
	public void resetPreProductOut() {
		PreProductOut condition = new PreProductOut();
		condition.setStatus(0);
		List<PreProductOut> list =  preProductOutMapper.selectSelective(condition);
		for (PreProductOut preProductOut : list) {
			Long time = System.currentTimeMillis() - preProductOut.getCreateTime().getTime();//当前时间减去创建时间得到毫秒数
			int hour24 = 24 * 60 * 60 * 1000;//一天总计毫秒数
			if(time >= hour24){//超过了一天
				PreProductOut out = new PreProductOut();
				out.setStatus(1);
				out.setId(preProductOut.getId());
				preProductOutMapper.update(out);
			}
		}
	}
}
