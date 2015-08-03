package com.kxm.kcgl.mapper;

import java.util.List;

import com.kxm.kcgl.domain.Thickness;

/**
 *
 * @author kongxm
 * @date 2015 2015年7月26日 下午4:31:58
 */
public interface ThicknessMapper {

	List<Thickness> selectSelective(Thickness bean);

	int insert(Thickness record);
	
	int countBySelective(Thickness record);
}
