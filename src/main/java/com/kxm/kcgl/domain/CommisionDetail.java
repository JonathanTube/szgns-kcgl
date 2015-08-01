package com.kxm.kcgl.domain;

import java.util.Date;

public class CommisionDetail {
	private Integer userId;
	private String productNo;
	private String brandName;
	private String techName;
	private String thicknessName;
	private Integer sale_amount;
	private Double total_cost;
	private Double sale_price;
	private Float scale;
	private Double commision;
	private Date creatTime;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getProductNo() {
		return productNo;
	}
	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getTechName() {
		return techName;
	}
	public void setTechName(String techName) {
		this.techName = techName;
	}
	public String getThicknessName() {
		return thicknessName;
	}
	public void setThicknessName(String thicknessName) {
		this.thicknessName = thicknessName;
	}
	public Integer getSale_amount() {
		return sale_amount;
	}
	public void setSale_amount(Integer sale_amount) {
		this.sale_amount = sale_amount;
	}
	public Double getTotal_cost() {
		return total_cost;
	}
	public void setTotal_cost(Double total_cost) {
		this.total_cost = total_cost;
	}
	public Double getSale_price() {
		return sale_price;
	}
	public void setSale_price(Double sale_price) {
		this.sale_price = sale_price;
	}
	public Float getScale() {
		return scale;
	}
	public void setScale(Float scale) {
		this.scale = scale;
	}
	public Double getCommision() {
		return commision;
	}
	public void setCommision(Double commision) {
		this.commision = commision;
	}
	public Date getCreatTime() {
		return creatTime;
	}
	public void setCreatTime(Date creatTime) {
		this.creatTime = creatTime;
	}
}
