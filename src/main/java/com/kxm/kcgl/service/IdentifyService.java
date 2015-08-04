package com.kxm.kcgl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kxm.kcgl.LogicException;
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

	public String add(String name) throws LogicException {
		Identify identify = new Identify();
		identify.setName(name.trim());
		int count = identifyMapper.countBySelective(identify);
		if (count > 0) {
			throw new LogicException(name + "已存在");
		}

		int result = identifyMapper.insert(identify);
		if (result > 0) {
			return name + "添加成功";
		} else {
			return name + "添加失败";
		}
	}

	public List<Identify> selectSelective(Identify identify) {
		return identifyMapper.selectSelective(identify);
	}

}
