package com.kxm.kcgl.mapper;

import java.util.List;

import com.kxm.kcgl.domain.RightFunc;

/**
 *
 *@author kongxm
 *@date 2015 2015年7月26日 上午9:39:55
 */
public interface RightFuncMapper {
	public List<RightFunc> selectSelective(RightFunc condition);

	public void deleteByRightId(int rightId);

	public void insert(RightFunc rf);
	
	
}
