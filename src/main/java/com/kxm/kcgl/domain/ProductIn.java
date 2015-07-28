package com.kxm.kcgl.domain;

import java.util.Date;

public class ProductIn {
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
	private double price;
	private int manufactorId;
	private String manufactorName;
	private int identifyId;
	private String identifyName;
	private int createUserId;
	private String createUsername;
	private Date createTime;

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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getManufactorId() {
		return manufactorId;
	}

	public void setManufactorId(int manufactorId) {
		this.manufactorId = manufactorId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getManufactorName() {
		return manufactorName;
	}

	public String getIdentifyName() {
		return identifyName;
	}

	public void setManufactorName(String manufactorName) {
		this.manufactorName = manufactorName;
	}

	public void setIdentifyId(int identifyId) {
		this.identifyId = identifyId;
	}

	public void setIdentifyName(String identifyName) {
		this.identifyName = identifyName;
	}

	public int getIdentifyId() {
		return identifyId;
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
