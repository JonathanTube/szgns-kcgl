package com.kxm.kcgl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kxm.kcgl.domain.Func;
import com.kxm.kcgl.mapper.FuncMapper;

/**
 *
 * @author kongxm
 * @date 2015 2015年7月26日 上午9:38:42
 */
@Service
public class FuncService {

	@Autowired
	private FuncMapper funcMapper;

	public List<Func> queryAll() {
		return funcMapper.selectSelective();
	}
}
