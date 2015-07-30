package com.kxm.kcgl.mapper;

import java.util.List;

import com.kxm.kcgl.domain.Cust;

/**
 *
 * @author kongxm
 * @date 2015 2015年7月26日 下午4:31:58
 */
public interface CustMapper {

	List<Cust> selectSelective(Cust cust); 

	int insert(Cust cust);
	
	int countBySelective(Cust cust);
}
