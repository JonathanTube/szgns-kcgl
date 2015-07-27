package com.kxm.kcgl.mapper;

import java.util.List;

import com.kxm.kcgl.domain.ProductIn;

/**
 *
 * @author kongxm
 * @date 2015 2015年7月26日 上午9:39:55
 */
public interface ProductInMapper {
	/**
	 * 根据传入的对象条件查找对象列表
	 */
	List<ProductIn> selectSelective(ProductIn record);

	/**
	 * 根据条件查询总记录数
	 * 
	 * @return
	 */
	int countBySelective(ProductIn record);

	int insert(ProductIn record);
}
