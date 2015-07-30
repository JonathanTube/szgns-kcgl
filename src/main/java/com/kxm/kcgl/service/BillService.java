package com.kxm.kcgl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kxm.kcgl.domain.Bill;
import com.kxm.kcgl.mapper.BillMapper;

/**
 *
 * @author kongxm
 * @date 2015 2015年7月30日 上午11:03:12
 */
@Service
public class BillService {
	@Autowired
	private BillMapper billMapper;

	public List<Bill> selectSelective(Bill bill) {
		return billMapper.selectSelective(bill);
	}
}
