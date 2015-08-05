package com.kxm.kcgl.domain;

import java.util.Date;

public class Product {
	private Integer id;
	private String productNo;
	private String productName;
	private Integer brandId;
	private String brandName;
	private Integer techId;
	private String techName;
	private Integer thicknessId;
	private String thicknessName;
	private Integer queryTimes;
	private Integer createUserId;
	private String createUsername;
	private Date createTime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getProductNo() {
		return productNo;
	}
	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Integer getBrandId() {
		return brandId;
	}
	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public Integer getTechId() {
		return techId;
	}
	public void setTechId(Integer techId) {
		this.techId = techId;
	}
	public String getTechName() {
		return techName;
	}
	public void setTechName(String techName) {
		this.techName = techName;
	}
	public Integer getThicknessId() {
		return thicknessId;
	}
	public void setThicknessId(Integer thicknessId) {
		this.thicknessId = thicknessId;
	}
	public String getThicknessName() {
		return thicknessName;
	}
	public void setThicknessName(String thicknessName) {
		this.thicknessName = thicknessName;
	}
	public Integer getQueryTimes() {
		return queryTimes;
	}
	public void setQueryTimes(Integer queryTimes) {
		this.queryTimes = queryTimes;
	}
	public Integer getCreateUserId() {
		return createUserId;
	}
	public void setCreateUserId(Integer createUserId) {
		this.createUserId = createUserId;
	}
	public String getCreateUsername() {
		return createUsername;
	}
	public void setCreateUsername(String createUsername) {
		this.createUsername = createUsername;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
