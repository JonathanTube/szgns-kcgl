package com.kxm.kcgl.mapper;

import java.util.List;

import com.kxm.kcgl.domain.ProductQueryTimes;

/**
 *
 * @author kongxm
 * @date 2015 2015年7月26日 下午4:31:58
 */
public interface ProductQueryTimesMapper {

	List<ProductQueryTimes> selectSelective(ProductQueryTimes pqt);

	int insert(ProductQueryTimes ptq);
}
