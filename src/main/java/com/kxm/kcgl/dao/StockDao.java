package com.kxm.kcgl.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kxm.kcgl.domain.StockBean;

@Repository
public class StockDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<StockBean> queryAll() {
		String sql = "SELECT s.id,b.id brandId,b.name brandName,p.id productId,p.name productName,t.id techId,t.name techName,n.id thicknessId,n.name thicknessName,s.amount FROM t_stock s,t_brand b,t_product p,t_tech t,t_thickness n WHERE s.brand_id = b.id AND s.product_id = p.id AND s.tech_id = t.id AND s.thickness_id = n.id";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper(StockBean.class));
	}

	public synchronized void insert(StockBean stockBean) {
		String sql = "insert t_stock(brand_id,product_id,tech_id,thickness_id,amount) values("
				+ stockBean.getBrandId() + ", " + stockBean.getProductId() + ","
				+ stockBean.getTechId() + "," + stockBean.getThicknessId() + ","
				+ stockBean.getAmount() + ")";
		jdbcTemplate.update(sql);
	}

	public synchronized boolean hasAmount(StockBean stockBean) {
		String sql = "SELECT IFNULL(sum(amount),0) FROM t_stock WHERE brand_id = " + stockBean.getBrandId()
				+ " AND product_id = " + stockBean.getProductId() + " AND tech_id = "
				+ stockBean.getTechId() + " AND thickness_id = " + stockBean.getThicknessId();
		int count = jdbcTemplate.queryForObject(sql, Integer.class);
		return count >= stockBean.getAmount();
	}
	
	public synchronized boolean isRecordExist(StockBean stockBean) {
		String sql = "SELECT count(*) FROM t_stock WHERE brand_id = " + stockBean.getBrandId()
				+ " AND product_id = " + stockBean.getProductId() + " AND tech_id = "
				+ stockBean.getTechId() + " AND thickness_id = " + stockBean.getThicknessId();
		int count = jdbcTemplate.queryForObject(sql, Integer.class);
		return count > 0;
	}

	public synchronized void update(StockBean stockBean) {
		String sql = "UPDATE t_stock s SET s.amount = s.amount + " + stockBean.getAmount()
				+ " WHERE s.brand_id = " + stockBean.getBrandId() + " AND s.product_id = "
				+ stockBean.getProductId() + " AND s.tech_id = " + stockBean.getTechId()
				+ " AND s.thickness_id = " + stockBean.getThicknessId();
		jdbcTemplate.update(sql);
	}

}
