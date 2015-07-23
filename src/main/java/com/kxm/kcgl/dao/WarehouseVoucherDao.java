package com.kxm.kcgl.dao;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kxm.kcgl.domain.WarehouseVoucherBean;

@Repository
public class WarehouseVoucherDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<WarehouseVoucherBean> query(Date date) {
		String sql = "SELECT s.id,b.id brandId,b.name brandName,p.id productId,p.name productName,t.id techId,t.name techName,n.id thicknessId,n.name thicknessName, DATE_FORMAT(s.create_time,'%y-%m-%d') create_time, SUM(s.amount) amount FROM t_warehouse_voucher s,t_brand b,t_product p,t_tech t,t_thickness n WHERE s.brand_id = b.id AND s.product_id = p.id AND s.tech_id = t.id AND s.thickness_id = n.id GROUP BY b.id,p.id,t.id,n.id, DATE_FORMAT(s.create_time,'%y-%m-%d')";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper(WarehouseVoucherBean.class));
	}
}
