package com.kxm.kcgl.mapper;

import java.util.List;

import com.kxm.kcgl.domain.User;
/**
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 */

public interface UserMapper {
	int insert(User record);

	int deleteByPk(String id);
	
	int deleteBySelective(User record);
	
	int updateSelectiveByPk(User record);

	User selectByPk(Integer id);
	
	List<User> selectSelective(User record);
	
	int countBySelective(User record);

}