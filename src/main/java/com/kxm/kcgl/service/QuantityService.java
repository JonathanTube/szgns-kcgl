package com.kxm.kcgl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kxm.kcgl.LogicException;
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

	public String add(String name) throws LogicException {
		Quantity quantity = new Quantity();
		quantity.setName(name.trim());
		int count = quantityMapper.countBySelective(quantity);
		if (count > 0) {
			throw new LogicException(name + "已存在");
		}

		int i = quantityMapper.insert(quantity);
		return i > 0 ? name + "添加成功" : name + "添加失败";
	}

	public List<Quantity> selectSelective(Quantity quantity) {
		return quantityMapper.selectSelective(quantity);
	}

}
