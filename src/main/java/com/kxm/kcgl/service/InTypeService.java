package com.kxm.kcgl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kxm.kcgl.LogicException;
import com.kxm.kcgl.domain.InType;
import com.kxm.kcgl.mapper.InTypeMapper;

/**
 *
 * @author kongxm
 * @date 2015 2015年7月26日 下午4:27:48
 */
@Service
public class InTypeService {
	@Autowired
	private InTypeMapper inTypeMapper;

	public String add(String name) throws LogicException {
		InType inType = new InType();
		inType.setName(name.trim());
		int count = inTypeMapper.countBySelective(inType);
		if (count > 0) {
			throw new LogicException(name + "已存在");
		}
		
		int i = inTypeMapper.insert(inType);
		return i > 0 ? name + "添加成功" : name + "添加失败";
	}

	public List<InType> selectSelective(InType inType) {
		return inTypeMapper.selectSelective(inType);
	}

}
