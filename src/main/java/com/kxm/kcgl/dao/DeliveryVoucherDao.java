package com.kxm.kcgl.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.kxm.kcgl.domain.DeliveryVoucherBean;
import com.kxm.kcgl.domain.StockBean;

@Repository
public class DeliveryVoucherDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private IncomeInfoCollectDao incomeInfoCollectDao;
	
	@Autowired
	private StockDao stockDao;

	public List<DeliveryVoucherBean> query(Date d) {
		String sql = "SELECT s.id,b.id brandId,b.name brandName,p.id productId,p.name productName,t.id techId,"
				+ "t.name techName,n.id thicknessId,n.name thicknessName, "
				+ "DATE_FORMAT(s.create_time,'%y-%m-%d') createTime, SUM(s.amount) amount "
				+ "FROM t_delivery_voucher s,t_brand b,t_product p,t_tech t,t_thickness n "
				+ "WHERE s.brand_id = b.id AND s.product_id = p.id AND s.tech_id = t.id AND s.thickness_id = n.id "
				+ "GROUP BY b.id,p.id,t.id,n.id, DATE_FORMAT(s.create_time,'%y-%m-%d')";

		return jdbcTemplate.query(sql, new BeanPropertyRowMapper(DeliveryVoucherBean.class));
	}

	public List<DeliveryVoucherBean> queryByDate(Date d, String custId) {
		String sql = "SELECT s.id,b.id brandId,b.name brandName,p.id productId,p.name productName,t.id techId,"
				+ "t.name techName,n.id thicknessId,n.name thicknessName,c.id custId,c.name custName, "
				+ "DATE_FORMAT(s.create_time,'%y-%m-%d') createTime, SUM(s.amount) amount, s.unit_price unitPrice, s.total_price totalPrice "
				+ "FROM t_delivery_voucher s,t_brand b,t_product p,t_tech t,t_thickness n,t_cust c "
				+ "WHERE s.brand_id = b.id AND s.product_id = p.id AND s.tech_id = t.id AND s.thickness_id = n.id AND s.cust_id = c.id ";
		if (StringUtils.isEmpty(custId) == false) {
			sql += "AND s.cust_id=" + custId;
		}
		if (d != null) {
			String dd = new SimpleDateFormat("yy-MM-dd").format(d);
			sql += "AND DATE_FORMAT(s.create_time,'%y-%m-%d') = '" + dd + "'";
		}
		sql += " GROUP BY b.id,p.id,t.id,n.id, DATE_FORMAT(s.create_time,'%y-%m-%d')";
		System.out.println(sql);
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper(DeliveryVoucherBean.class));
	}

	public List<DeliveryVoucherBean> queryBySeq(String seq) {
		String sql = "SELECT s.id,b.id brandId,b.name brandName,p.id productId,p.name productName,t.id techId,"
				+ "t.name techName,n.id thicknessId,n.name thicknessName,c.id custId,c.name custName, "
				+ "DATE_FORMAT(s.create_time,'%y-%m-%d') createTime, s.amount amount, s.unit_price unitPrice, s.total_price totalPrice "
				+ "FROM t_delivery_voucher s,t_brand b,t_product p,t_tech t,t_thickness n,t_cust c "
				+ "WHERE s.brand_id = b.id AND s.product_id = p.id AND s.tech_id = t.id AND s.thickness_id = n.id AND s.cust_id = c.id "
				+ "AND seq='" + seq + "'";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper(DeliveryVoucherBean.class));
	}

	public void deleteBill(String seq) {
		// 根据单号查询出货明细记录
		String sql = "SELECT id,brand_id brandId,product_id productId, tech_id techId, thickness_id thicknessId,cust_id custId,"
				+ "DATE_FORMAT(create_time,'%y-%m-%d') createTime, amount, unit_price unitPrice, total_price totalPrice "
				+ "FROM t_delivery_voucher " + "WHERE seq='" + seq + "'";
		List<DeliveryVoucherBean> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper(
				DeliveryVoucherBean.class));
		for (DeliveryVoucherBean b : list) {
			StockBean stockBean = new StockBean();
			stockBean.setBrandId(b.getBrandId());
			stockBean.setProductId(b.getProductId());
			stockBean.setTechId(b.getTechId());
			stockBean.setThicknessId(b.getThicknessId());
			stockBean.setAmount(b.getAmount());
			if (stockDao.isRecordExist(stockBean)) {
				stockDao.update(stockBean);
			} else {
				stockDao.insert(stockBean);
			}
		}
		
		sql = "delete from t_delivery_voucher where seq = ?";
		jdbcTemplate.update(sql, seq);
		
		sql = "delete from t_bill where seq = ?";
		jdbcTemplate.update(sql,seq);
	}
}
