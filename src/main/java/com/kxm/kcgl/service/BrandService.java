package com.kxm.kcgl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kxm.kcgl.LogicException;
import com.kxm.kcgl.domain.Brand;
import com.kxm.kcgl.mapper.BrandMapper;

@Service
public class BrandService {
	@Autowired
	private BrandMapper brandMapper;

	@Transactional
	public int add(String name) throws LogicException {
		Brand brand = new Brand();
		brand.setName(name.trim());
		int count = brandMapper.countBySelective(brand);
		if (count > 0) {
			throw new LogicException(name + "已存在");
		}

		return brandMapper.insert(brand);
	}

	public List<Brand> selectSelective(Brand brand) {
		return brandMapper.selectSelective(brand);
	}
}
