package com.kxm.kcgl.mapper;

import java.util.List;

import com.kxm.kcgl.domain.ProductIn;

/**
 *
 * @author kongxm
 * @date 2015 2015年7月26日 上午9:39:55
 */
public interface ProductInMapper {
	List<ProductIn> selectSelective(ProductIn record);

	int countBySelective(ProductIn record);

	int insert(ProductIn record);
}
