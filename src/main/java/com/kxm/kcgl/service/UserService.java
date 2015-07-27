package com.kxm.kcgl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kxm.kcgl.domain.User;
import com.kxm.kcgl.mapper.UserMapper;

/**
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 */

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;

	/**
	 * @return
	 */
	public List<User> queryAll() {
		return userMapper.selectSelective(new User());
	}

	public boolean insertUser(User entity) {
		if (entity != null) {
			userMapper.insert(entity);
			return true;
		}

		return false;
	}

	public boolean updateUser(User entity) {
		if (entity != null) {
			int i = userMapper.updateSelectiveByPk(entity);
			return i > 0 ? true : false;
		}

		return false;
	}
}
