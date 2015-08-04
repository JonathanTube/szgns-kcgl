package com.kxm.kcgl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kxm.kcgl.LogicException;
import com.kxm.kcgl.domain.Manufactor;
import com.kxm.kcgl.mapper.ManufactorMapper;

/**
 *
 * @author kongxm
 * @date 2015 2015年7月26日 下午4:27:28
 */
@Service
public class ManufactorService {

	@Autowired
	private ManufactorMapper manufactoryMapper;

	public String add(String name) throws LogicException {
		Manufactor manufactor = new Manufactor();
		manufactor.setName(name.trim());
		int count = manufactoryMapper.countBySelective(manufactor);
		if (count > 0) {
			throw new LogicException(name + "已存在");
		}
		
		int i = manufactoryMapper.insert(manufactor);
		return i > 0 ? name + "添加成功" : name + "添加失败";
	}

	public List<Manufactor> selectSelective(Manufactor manufactor) {
		return manufactoryMapper.selectSelective(manufactor);
	}

}
