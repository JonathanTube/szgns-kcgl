package com.kxm.kcgl.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kxm.kcgl.domain.BillBean;

@Repository
public class BillDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int insert(BillBean billBean) {
		String sql = "insert into t_bill(seq) values(?)";
		return jdbcTemplate.update(sql, billBean.getSeq());
	}

	public void delete() {

	}

	public void update() {

	}

	public List<BillBean> query() {
		String sql = "select id,seq,create_time createTime from t_bill order by create_time desc";
		List<BillBean> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper(BillBean.class));
		return list;
	}
	
	public int countByDate(String nYearMonthDay) {
		String sql = "select count(*) from t_bill where seq like '" + nYearMonthDay + "%'";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}
	
	public String queryByDate(String nYearMonthDay){
		String sql = "select seq from t_bill where seq like '" + nYearMonthDay + "%' order by create_time desc limit 1";
		return jdbcTemplate.queryForObject(sql, String.class);
	}
}
