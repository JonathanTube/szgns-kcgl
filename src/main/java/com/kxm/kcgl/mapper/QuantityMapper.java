package com.kxm.kcgl.mapper;

import java.util.List;

import com.kxm.kcgl.domain.Quantity;

/**
 *
 * @author kongxm
 * @date 2015 2015年7月26日 下午4:31:58
 */
public interface QuantityMapper {

	List<Quantity> selectSelective(Quantity bean);

	int insert(Quantity record);

	int countBySelective(Quantity quantity);
}
