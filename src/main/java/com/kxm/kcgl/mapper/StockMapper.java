package com.kxm.kcgl.mapper;

import java.util.List;

import com.kxm.kcgl.domain.Stock;

/**
 *
 * @author kongxm
 * @date 2015 2015年7月26日 上午9:39:55
 */
public interface StockMapper {
	/**
	 * 根据传入的对象条件查找对象列表
	 */
	List<Stock> selectSelective(Stock record);

	/**
	 * 根据条件查询总记录数
	 * 
	 * @return
	 */
	int countBySelective(Stock record);
	
	int insert(Stock record);
	
	int update(Stock record);
}
