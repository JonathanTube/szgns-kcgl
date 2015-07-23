package com.kxm.kcgl.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kxm.kcgl.domain.ThicknessBean;

@Repository
public class ThicknessDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int insert(ThicknessBean thicknessBean) {
		String sql = "insert into t_thickness(name,create_user) values(?,?)";
		return jdbcTemplate.update(sql, thicknessBean.getName(), thicknessBean.getCreate_user());
	}

	public void delete(int id) {
		String sql = "update t_thickness set flag = 0 where id = ?";
		jdbcTemplate.update(sql, id);
	}

	public void update(String name) {
		String sql = "update t_thickness set flag = 1 where name = ?";
		jdbcTemplate.update(sql, name);
	}

	public List<ThicknessBean> query() {
		String sql = "select id,name,create_time createTime,create_user createUser from t_thickness where flag = 1";
		List<ThicknessBean> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper(
				ThicknessBean.class));
		return list;
	}

	public int count(String name) {
		String sql = "select count(*) from t_thickness where name = '" + name + "' and flag = 1";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}
}
