package com.kxm.kcgl.domain;

import java.util.Date;

public class Product {
	private Integer id;
	private String productNo;
	private String productName;
	private int brandId;
	private String brandName;
	private int techId;
	private String techName;
	private int thicknessId;
	private String thicknessName;
	private int identifyId;
	private String identifyName;
	private double price;
	private int amount;
	private int queryTimes;
	private int createUserId;
	private String createUsername;
	private Date createTime;

	public Integer getId() {
		return id;
	}

	public String getProductNo() {
		return productNo;
	}

	public String getProductName() {
		return productName;
	}

	public int getBrandId() {
		return brandId;
	}

	public String getBrandName() {
		return brandName;
	}

	public int getTechId() {
		return techId;
	}

	public String getTechName() {
		return techName;
	}

	public int getThicknessId() {
		return thicknessId;
	}

	public String getThicknessName() {
		return thicknessName;
	}

	public double getPrice() {
		return price;
	}

	public int getQueryTimes() {
		return queryTimes;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public void setTechId(int techId) {
		this.techId = techId;
	}

	public void setTechName(String techName) {
		this.techName = techName;
	}

	public void setThicknessId(int thicknessId) {
		this.thicknessId = thicknessId;
	}

	public void setThicknessName(String thicknessName) {
		this.thicknessName = thicknessName;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setQueryTimes(int queryTimes) {
		this.queryTimes = queryTimes;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public int getIdentifyId() {
		return identifyId;
	}

	public String getIdentifyName() {
		return identifyName;
	}

	public void setIdentifyId(int identifyId) {
		this.identifyId = identifyId;
	}

	public void setIdentifyName(String identifyName) {
		this.identifyName = identifyName;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getCreateUserId() {
		return createUserId;
	}

	public String getCreateUsername() {
		return createUsername;
	}

	public void setCreateUserId(int createUserId) {
		this.createUserId = createUserId;
	}

	public void setCreateUsername(String createUsername) {
		this.createUsername = createUsername;
	}
}
