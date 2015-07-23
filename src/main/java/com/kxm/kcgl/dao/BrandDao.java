package com.kxm.kcgl.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kxm.kcgl.domain.BrandBean;

@Repository
public class BrandDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int insert(BrandBean brandBean) {
		String sql = "insert into t_brand(name,create_user) values(?,?)";
		return jdbcTemplate.update(sql, brandBean.getName(), brandBean.getCreate_user());
	}

	public void delete(int id) {
		String sql = "update t_brand set flag = 0 where id = ?";
		jdbcTemplate.update(sql, id);
	}

	public void update(String name) {
		String sql = "update t_brand set flag = 1 where name = ?";
		jdbcTemplate.update(sql, name);
	}

	public List<BrandBean> query() {
		String sql = "select id,name,create_time createTime,create_user createUser from t_brand where flag = 1";
		List<BrandBean> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper(BrandBean.class));
		return list;
	}

	public int count(String name) {
		String sql = "select count(*) from t_brand where name = '" + name + "' and flag = 1";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}
}
