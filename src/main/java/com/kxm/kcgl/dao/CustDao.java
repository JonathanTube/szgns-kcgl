package com.kxm.kcgl.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kxm.kcgl.domain.CustBean;

@Repository
public class CustDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int insert(CustBean custBean) {
		String sql = "insert into t_cust(name,create_user) values(?,?)";
		return jdbcTemplate.update(sql, custBean.getName(), custBean.getCreate_user());
	}

	public void delete(int id) {
		String sql = "update t_cust set flag = 0 where id = ?";
		jdbcTemplate.update(sql, id);
	}

	public void update(String name) {
		String sql = "update t_cust set flag = 1 where name = ?";
		jdbcTemplate.update(sql, name);
	}

	public List<CustBean> query() {
		String sql = "select id,name,create_time createTime,create_user createUser from t_cust where flag = 1";
		List<CustBean> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper(CustBean.class));
		return list;
	}

	public int count(String name) {
		String sql = "select count(*) from t_cust where name = '" + name + "' and flag = 1";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}
}
