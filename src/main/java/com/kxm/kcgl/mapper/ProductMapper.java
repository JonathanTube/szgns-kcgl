package com.kxm.kcgl.mapper;

import java.util.List;

import com.kxm.kcgl.domain.Product;

/**
 *
 * @author kongxm
 * @date 2015 2015年7月26日 上午9:39:55
 */
public interface ProductMapper {
	/**
	 * 根据传入的对象条件查找对象列表
	 */
	List<Product> selectSelective(Product record);

	/**
	 * 根据条件查询总记录数
	 * 
	 * @return
	 */
	int countBySelective(Product record);

	int insert(Product record);

	void updateAmount(Product product);
}
