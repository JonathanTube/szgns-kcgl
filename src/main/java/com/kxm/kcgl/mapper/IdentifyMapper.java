package com.kxm.kcgl.mapper;

import java.util.List;

import com.kxm.kcgl.domain.Identify;

/**
 *
 * @author kongxm
 * @date 2015 2015年7月26日 下午4:31:58
 */
public interface IdentifyMapper {

	List<Identify> selectSelective(Identify identify); 

	int insert(Identify identify);

	int countBySelective(Identify identify);
}
