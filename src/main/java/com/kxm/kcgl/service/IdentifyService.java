package com.kxm.kcgl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kxm.kcgl.domain.Identify;
import com.kxm.kcgl.mapper.IdentifyMapper;

/**
 *
 * @author kongxm
 * @date 2015 2015年7月26日 下午4:27:48
 */
@Service
public class IdentifyService {
	@Autowired
	private IdentifyMapper identifyMapper;

	public List<Identify> queryAll() {
		return identifyMapper.selectSelective(new Identify());
	}

	public String addNew(String identifyName) {
		int i = identifyMapper.insert(identifyName);
		return i > 0 ? identifyName + "添加成功" : identifyName + "添加失败";
	}

}
