package com.kxm.kcgl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kxm.kcgl.LogicException;
import com.kxm.kcgl.domain.Cust;
import com.kxm.kcgl.mapper.CustMapper;

@Service
public class CustService {
	@Autowired
	private CustMapper custMapper;

	public List<Cust> selectSelective(Cust cust) {
		return custMapper.selectSelective(cust);
	}

	public String addNew(String name, Integer userId) throws LogicException {
		Cust condition = new Cust();
		condition.setName(name);
		int size = custMapper.countBySelective(condition);
		if (size > 0) {
			throw new LogicException(name + "已存在");
		}
		Cust cust = new Cust();
		cust.setName(name);
		cust.setUserId(userId);
		int i = custMapper.insert(cust);
		return i > 0 ? name + "添加成功" : name + "添加失败";
	}
}
