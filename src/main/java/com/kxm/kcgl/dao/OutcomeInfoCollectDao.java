package com.kxm.kcgl.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kxm.kcgl.domain.OutcomeInfoBean;

@Repository
public class OutcomeInfoCollectDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void add(OutcomeInfoBean b) {
		String sql = "INSERT t_delivery_voucher(brand_id,seq,product_id,tech_id,thickness_id,cust_id,amount,unit_price,total_price)"
				+ " VALUES("
				+ b.getBrandId()
				+ ",'"
				+ b.getSeq()
				+ "',"
				+ b.getProductId()
				+ ","
				+ b.getTechId()
				+ ","
				+ b.getThicknessId()
				+ ","
				+ b.getCustId()
				+ ","
				+ b.getAmount()
				+ ","
				+ b.getUnitPrice()
				+ ","
				+ b.getTotalPrice() + ")";
		jdbcTemplate.update(sql);
	}

}
