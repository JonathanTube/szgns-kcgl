package com.kxm.kcgl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kxm.kcgl.domain.Right;
import com.kxm.kcgl.mapper.RightMapper;

/**
 *
 * @author kongxm
 * @date 2015 2015年7月26日 上午8:57:44
 */
@Service
public class RightService {
	@Autowired
	private RightMapper rightMapper;

	public List<Right> queryAllRight() {
		return rightMapper.selectSelective();
	}
}
