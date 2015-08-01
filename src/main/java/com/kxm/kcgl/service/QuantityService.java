package com.kxm.kcgl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kxm.kcgl.domain.Manufactor;
import com.kxm.kcgl.domain.Quantity;
import com.kxm.kcgl.mapper.QuantityMapper;

/**
 *
 * @author kongxm
 * @date 2015 2015年7月26日 下午4:27:28
 */
@Service
public class QuantityService {

	@Autowired
	private QuantityMapper quantityMapper;

	public List<Quantity> queryAll() {
		return quantityMapper.selectSelective(new Quantity());
	}

	public String addNew(String quantityName) {
		int i = quantityMapper.insert(quantityName);
		return i > 0 ? quantityName + "添加成功" : quantityName + "添加失败";
	}

}
