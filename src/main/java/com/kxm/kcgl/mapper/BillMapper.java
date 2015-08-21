package com.kxm.kcgl.mapper;

import java.util.List;

import com.kxm.kcgl.domain.Bill;

/**
 *
 * @author kongxm
 * @date 2015 2015年7月26日 下午4:31:58
 */
public interface BillMapper {

	List<Bill> selectSelective(Bill bill);

	int insert(Bill bill);

	int countBySelective(Bill bill);

	int update(Bill bill);
	
	int deleteByPk(Integer billId);
}
