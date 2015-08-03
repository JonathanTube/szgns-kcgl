package com.kxm.kcgl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kxm.kcgl.LogicException;
import com.kxm.kcgl.domain.Tech;
import com.kxm.kcgl.mapper.TechMapper;

@Service
public class TechService {
	@Autowired
	private TechMapper techMapper;

	@Transactional
	public int add(String name) throws LogicException {
		Tech tech = new Tech();
		tech.setName(name.trim());
		int count = techMapper.countBySelective(tech);
		if (count > 0) {
			throw new LogicException(name + "已存在");
		}

		return techMapper.insert(tech);
	}

	public List<Tech> selectSelective(Tech tech) {
		return techMapper.selectSelective(tech);
	}
}
