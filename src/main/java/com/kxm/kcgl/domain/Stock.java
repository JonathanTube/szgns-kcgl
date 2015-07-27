package com.kxm.kcgl.domain;

public class Stock {
	private int id;
	private String productNo;
	private int brandId;
	private String brandName;
	private int productId;
	private String productName;
	private int techId;
	private String techName;
	private int thicknessId;
	private String thicknessName;
	private int amount;
	private Double price;
	private int identifyId;
	private String identifyName;
	private int queryTimes;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getTechId() {
		return techId;
	}

	public void setTechId(int techId) {
		this.techId = techId;
	}

	public String getTechName() {
		return techName;
	}

	public void setTechName(String techName) {
		this.techName = techName;
	}

	public int getThicknessId() {
		return thicknessId;
	}

	public void setThicknessId(int thicknessId) {
		this.thicknessId = thicknessId;
	}

	public String getThicknessName() {
		return thicknessName;
	}

	public void setThicknessName(String thicknessName) {
		this.thicknessName = thicknessName;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getBrandId() {
		return brandId;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getProductNo() {
		return productNo;
	}

	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public int getIdentifyId() {
		return identifyId;
	}

	public void setIdentifyId(int identifyId) {
		this.identifyId = identifyId;
	}

	public String getIdentifyName() {
		return identifyName;
	}

	public void setIdentifyName(String identifyName) {
		this.identifyName = identifyName;
	}

	public int getQueryTimes() {
		return queryTimes;
	}

	public void setQueryTimes(int queryTimes) {
		this.queryTimes = queryTimes;
	}
}
