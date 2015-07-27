package com.kxm.kcgl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	public List<Manufactor> queryAll() {
		return manufactoryMapper.selectSelective(new Manufactor());
	}

	public String addNew(String manufactorName) {
		int i = manufactoryMapper.insert(manufactorName);
		return i > 0 ? manufactorName + "添加成功" : manufactorName + "添加失败";
	}

}
