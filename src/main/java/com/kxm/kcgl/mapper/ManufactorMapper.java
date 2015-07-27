package com.kxm.kcgl.mapper;

import java.util.List;

import com.kxm.kcgl.domain.Manufactor;

/**
 *
 * @author kongxm
 * @date 2015 2015年7月26日 下午4:31:58
 */
public interface ManufactorMapper {

	List<Manufactor> selectSelective(Manufactor bean);

	int insert(String record);
}
