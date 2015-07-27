package com.kxm.kcgl.mapper;

import java.util.List;

import com.kxm.kcgl.domain.Right;

/**
 *
 * @author kongxm
 * @date 2015 2015年7月26日 上午9:15:35
 */
public interface RightMapper {

	public List<Right> selectSelective();
	
	int insert(Right record);
}
