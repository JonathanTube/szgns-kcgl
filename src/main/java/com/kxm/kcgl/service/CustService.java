package com.kxm.kcgl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kxm.kcgl.domain.Cust;
import com.kxm.kcgl.mapper.CustMapper;

@Service
public class CustService {
	@Autowired
	private CustMapper custMapper;

	public List<Cust> selectSelective(Cust cust) {
		return custMapper.selectSelective(cust);
	}

	public String addNew(String name) {
		int i = custMapper.insert(name);
		return i > 0 ? name + "添加成功" : name + "添加失败";
	}
}
