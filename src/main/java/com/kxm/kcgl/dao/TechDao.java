package com.kxm.kcgl.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kxm.kcgl.domain.TechBean;

@Repository
public class TechDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int insert(TechBean techBean) {
		String sql = "insert into t_tech(name,create_user) values(?,?)";
		return jdbcTemplate.update(sql, techBean.getName(), techBean.getCreate_user());
	}

	public void delete(int id) {
		String sql = "update t_tech set flag = 0 where id  = ?";
		jdbcTemplate.update(sql, id);
	}

	public void update(String name) {
		String sql = "update t_tech set flag = 1 where name  = ?";
		jdbcTemplate.update(sql, name);
	}

	public List<TechBean> query() {
		String sql = "select id,name,create_time createTime,create_user createUser from t_tech where flag = 1";
		List<TechBean> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper(TechBean.class));
		return list;
	}
	
	public int count(String name) {
		String sql = "select count(*) from t_tech where name = '" + name + "' and flag = 1";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}
}
