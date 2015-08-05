package com.kxm.kcgl.mapper;

import java.util.List;

import com.kxm.kcgl.domain.Price;
import com.kxm.kcgl.domain.ProductIn;

/**
 *
 * @author kongxm
 * @date 2015 2015年7月26日 下午4:31:58
 */
public interface PriceMapper {

	int insert(Price record);

	void update(Price price);

	List<Price> selectSelective(Price price);

	int countBySelective(Price record);
}
