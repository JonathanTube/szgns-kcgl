package com.kxm.kcgl.mapper;

import java.util.List;

import com.kxm.kcgl.domain.ProductOut;

/**
 *
 * @author kongxm
 * @date 2015 2015年7月26日 上午9:39:55
 */
public interface ProductOutMapper {
	List<ProductOut> selectSelective(ProductOut record);

	int countBySelective(ProductOut record);

	int insert(ProductOut record);
	
	int deleteByPk(Integer id);
}
