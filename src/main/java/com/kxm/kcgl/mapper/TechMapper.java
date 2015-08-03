package com.kxm.kcgl.mapper;

import java.util.List;

import com.kxm.kcgl.domain.Tech;

/**
 *
 * @author kongxm
 * @date 2015 2015年7月26日 下午4:31:58
 */
public interface TechMapper {

	List<Tech> selectSelective(Tech bean);

	int insert(Tech record);
	
	int countBySelective(Tech record);
}
