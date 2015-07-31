package com.kxm.kcgl.mapper;

import java.util.List;

import com.kxm.kcgl.domain.PriceAdjust;

/**
 *
 * @author kongxm
 * @date 2015 2015年7月26日 上午9:39:55
 */
public interface PriceAdjustMapper {
	List<PriceAdjust> selectSelective(PriceAdjust record);

	int countBySelective(PriceAdjust record);

	int insert(PriceAdjust record);
}
