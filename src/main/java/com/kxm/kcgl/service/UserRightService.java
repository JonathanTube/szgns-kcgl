package com.kxm.kcgl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kxm.kcgl.domain.UserRight;
import com.kxm.kcgl.mapper.UserRightMapper;

/**
 *
 * @author kongxm
 * @date 2015 2015年7月28日 上午10:23:01
 */
@Service
public class UserRightService {

	@Autowired
	private UserRightMapper userRightMapper;

	public int[] queryUserIdByRightId(int rightId) {
		UserRight condition = new UserRight();
		condition.setRightId(rightId);
		List<UserRight> list = userRightMapper.selectSelective(condition);
		int[] s = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			s[i] = list.get(i).getUserId();
		}
		return s;
	}

	@Transactional(rollbackFor = Exception.class)
	public void saveUserRight(int rightId, int[] userId) {
		userRightMapper.deleteByRightId(rightId);
		for (int i = 0; i < userId.length; i++) {
			UserRight ur = new UserRight();
			ur.setRightId(rightId);
			ur.setUserId(userId[i]);
			userRightMapper.insert(ur);
		}
	}
}
