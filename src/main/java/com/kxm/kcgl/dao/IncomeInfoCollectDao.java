package com.kxm.kcgl.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kxm.kcgl.domain.IncomeInfoBean;

@Repository
public class IncomeInfoCollectDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void add(IncomeInfoBean bean) {
		String sql = "insert into t_warehouse_voucher(brand_id,product_id,tech_id,thickness_id,amount) values("
				+ bean.getBrandId()
				+ ","
				+ bean.getProductId()
				+ ","
				+ bean.getTechId()
				+ ","
				+ bean.getThicknessId() + "," + bean.getAmount() + ")";

		jdbcTemplate.update(sql);
	}
}
