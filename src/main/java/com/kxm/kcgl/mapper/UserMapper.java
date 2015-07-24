package com.kxm.kcgl.mapper;

import java.util.List;

import com.kxm.kcgl.domain.User;
/**
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 */

public interface UserMapper {
	/**
	 *
	 * 插入完整数据对象
	 * 
	 * @return
	 * 
	 */
	int insert(User record);

	/**
	 * 
	 * 根据插入对象的值是否为空,选择性插进入数据
	 * 
	 * @return
	 */
	int insertSelective(User record);
	
	/**
	 * 
	 * 根据主键删除数据
	 * 
	 * @param id 表格的主键
	 * 
	 * @return
	 */
	int deleteByPk(String id);
	
	/**
	 * 
	 * 根据非空条件删除数据
	 * 
	 * @return
	 */
	int deleteBySelective(User record);
	
	/**
	 * 
	 * 将对象属性中不为空的值根据主键更新
	 * 
	 * @return
	 */
	int updateSelectiveByPk(User record);

	/**
	 * 将对象中的所有属性根据主键更新
	 * 
	 * @return
	 */
	int updateByPk(User record);

	/**
	 * 根据主键查找对象
	 */
	User selectByPk(String id);
	
	/**
	 * 根据传入的对象条件查找对象列表
	 */
	List<User> selectSelective(User record);
	
	/**
	 * 根据条件查询总记录数
	 * 
	 * @return
	 */
	int countBySelective(User record);
}