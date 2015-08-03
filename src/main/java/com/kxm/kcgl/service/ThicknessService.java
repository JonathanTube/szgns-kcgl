package com.kxm.kcgl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kxm.kcgl.LogicException;
import com.kxm.kcgl.domain.Thickness;
import com.kxm.kcgl.mapper.ThicknessMapper;

@Service
public class ThicknessService {
	@Autowired
	private ThicknessMapper thicknessMapper;

	@Transactional
	public int add(String name) throws LogicException {
		Thickness thickness = new Thickness();
		thickness.setName(name.trim());
		int count = thicknessMapper.countBySelective(thickness);
		if (count > 0) {
			throw new LogicException(name + "已存在");
		}

		return thicknessMapper.insert(thickness);
	}

	public List<Thickness> selectSelective(Thickness thickness) {
		return thicknessMapper.selectSelective(thickness);
	}
}
