package com.kxm.kcgl.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kxm.kcgl.domain.ProductBean;

@Repository
public class ProductDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int insert(ProductBean productBean) {
		String sql = "insert into t_product(name,brand_id,create_user) values(?,?,?)";
		return jdbcTemplate.update(sql, productBean.getName(), productBean.getBrandId(),
				productBean.getCreate_user());
	}

	public void delete(int id) {
		String sql = "update t_product set flag = 0 where id = ?";
		jdbcTemplate.update(sql, id);
	}

	public void update(String name) {
		String sql = "update t_product set flag = 1 where name = ?";
		jdbcTemplate.update(sql, name);
	}

	public List<ProductBean> query() {
		String sql = "select id,name,create_time createTime,create_user createUser from t_product where flag=1";
		List<ProductBean> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper(
				ProductBean.class));
		return list;
	}

	public int count(String name) {
		String sql = "select count(*) from t_product where name = '" + name + "' and flag = 1";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

	public List<ProductBean> query(int brandId) {
		String sql = "select id,name,create_time createTime,create_user createUser from t_product where flag=1 and brand_id=" + brandId;
		List<ProductBean> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper(
				ProductBean.class));
		return list;
	}
}
