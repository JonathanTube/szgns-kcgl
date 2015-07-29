package com.kxm.kcgl.mapper;

import java.util.List;

import com.kxm.kcgl.domain.InType;

/**
 *
 * @author kongxm
 * @date 2015 2015年7月26日 下午4:31:58
 */
public interface InTypeMapper {

	List<InType> selectSelective(InType inType); 

	int insert(String record);
}
