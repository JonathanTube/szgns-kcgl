package com.kxm.kcgl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hyjd.frame.psm.base.LoginSession;
import com.kxm.kcgl.LogicException;
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

	@Autowired
	private LoginSession loginSession;

	public boolean insertUser(User entity) throws LogicException {
		if (entity != null) {
			User record = new User();
			record.setUsername(entity.getUsername());
			int size = userMapper.countBySelective(record);
			if (size > 0) {
				throw new LogicException("用户名已存在");
			}
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

	public List<User> queryUser(User record) {
		return userMapper.selectSelective(record);
	}

	public int changePassword(Integer userId, String oldPassword,
			String newPassword1, String newPassword2) throws LogicException {
		User user = userMapper.selectByPk(userId);
		if(user!=null && !user.getPassword().equals(oldPassword)){
			throw new LogicException("原密码不正确");
		}
		if (!newPassword1.equals(newPassword2)) {
			throw new LogicException("两次密码不一致");
		}
		User condition = new User();
		condition.setId(userId);
		condition.setPassword(newPassword1);
		return userMapper.updateSelectiveByPk(condition);
	}

	public List<User> selectSelective(User user) {
		return userMapper.selectSelective(user);
	}

}
