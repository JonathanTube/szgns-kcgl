package com.kxm.kcgl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kxm.kcgl.domain.RightFunc;
import com.kxm.kcgl.mapper.RightFuncMapper;

/**
 *
 * @author kongxm
 * @date 2015 2015年7月28日 上午10:23:38
 */
@Service
public class RightFuncService {
	@Autowired
	private RightFuncMapper rightFuncMapper;

	public int[] queryFuncIdByRightId(int rightId) {
		RightFunc condition = new RightFunc();
		condition.setRightId(rightId);
		List<RightFunc> list = rightFuncMapper.selectSelective(condition);
		int[] s = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			s[i] = list.get(i).getFuncId();
		}
		return s;
	}

	@Transactional(rollbackFor = Exception.class)
	public void saveRightFunc(int[] funcId, int rightId) {
		rightFuncMapper.deleteByRightId(rightId);
		for (int i = 0; i < funcId.length; i++) {
			RightFunc rf = new RightFunc();
			rf.setRightId(rightId);
			rf.setFuncId(funcId[i]);
			rightFuncMapper.insert(rf);
		}
	
	}
}
