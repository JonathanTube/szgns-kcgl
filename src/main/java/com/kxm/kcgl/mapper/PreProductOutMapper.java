package com.kxm.kcgl.mapper;

import java.util.List;

import com.kxm.kcgl.domain.PreProductOut;

/**
 *
 * @author kongxm
 * @date 2015 2015年7月26日 上午9:39:55
 */
public interface PreProductOutMapper {
	List<PreProductOut> selectSelective(PreProductOut record);

	int insert(PreProductOut record);
}
