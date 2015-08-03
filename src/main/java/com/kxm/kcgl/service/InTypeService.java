package com.kxm.kcgl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	public String addNew(String inTypeName) {
		int i = inTypeMapper.insert(inTypeName);
		return i > 0 ? inTypeName + "添加成功" : inTypeName + "添加失败";
	}

	public List<InType> selectSelective(InType inType) {
		return inTypeMapper.selectSelective(inType);
	}

}
