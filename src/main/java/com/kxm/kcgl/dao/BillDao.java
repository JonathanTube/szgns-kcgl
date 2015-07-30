package com.kxm.kcgl.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kxm.kcgl.domain.Bill;

@Repository
public class BillDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int insert(Bill billBean) {
		String sql = "insert into t_bill(seq) values(?)";
		return jdbcTemplate.update(sql, billBean.getSeq());
	}

	public void delete() {

	}

	public void update() {

	}

	public List<Bill> query() {
		String sql = "select id,seq,create_time createTime from t_bill order by create_time desc";
		List<Bill> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Bill.class));
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
