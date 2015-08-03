package com.kxm.kcgl.mapper;

import java.util.List;

import com.kxm.kcgl.domain.Brand;

/**
 *
 * @author kongxm
 * @date 2015 2015年7月26日 下午4:31:58
 */
public interface BrandMapper {

	List<Brand> selectSelective(Brand bean);

	int insert(Brand record);
	
	int countBySelective(Brand record);
}
