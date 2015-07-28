package com.kxm.kcgl.mapper;

import java.util.List;

import com.kxm.kcgl.domain.UserRight;

/**
 *
 *@author kongxm
 *@date 2015 2015年7月26日 上午9:39:55
 */
public interface UserRightMapper {
	public List<UserRight> selectSelective(UserRight userRight);

	public void deleteByRightId(int rightId);
	
	public void insert(UserRight userRight);
}
