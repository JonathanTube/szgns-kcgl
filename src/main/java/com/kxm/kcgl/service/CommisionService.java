package com.kxm.kcgl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kxm.kcgl.domain.Commision;
import com.kxm.kcgl.domain.CommisionDetail;
import com.kxm.kcgl.mapper.CommisionDetailMapper;

@Service
public class CommisionService {

	@Autowired
	private CommisionDetailMapper commisionDetailMapper;

	public List<CommisionDetail> queryCommisionDetail(Commision commision) {
		CommisionDetail detail = new CommisionDetail();
		detail.setCreatTime(commision.getCreateTime());
		detail.setUserId(commision.getUserId());
		return commisionDetailMapper.selectSelective(detail);
	}

}
