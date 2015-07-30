package com.kxm.kcgl.domain;

import java.util.Date;

public class ProductIn {
	private Integer id;
	private String productNo;
	private Integer brandId;
	private String brandName;
	private Integer productId;
	private String productName;
	private Integer techId;
	private String techName;
	private Integer thicknessId;
	private String thicknessName;
	private Integer amount;
	private double price;
	private Integer manufactorId;
	private String manufactorName;
	private Integer identifyType;
	private Integer identifyId;
	private String identifyName;
	private Integer inTypeId;
	private String inTypeName;
	private Integer createUserId;
	private String createUsername;
	private Date createTime;

	private Date productInStartDate;
	private Date productInEndDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
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

	public Integer getManufactorId() {
		return manufactorId;
	}

	public void setManufactorId(Integer manufactorId) {
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

	public void setIdentifyId(Integer identifyId) {
		this.identifyId = identifyId;
	}

	public void setIdentifyName(String identifyName) {
		this.identifyName = identifyName;
	}

	public Integer getIdentifyId() {
		return identifyId;
	}

	public Integer getCreateUserId() {
		return createUserId;
	}

	public String getCreateUsername() {
		return createUsername;
	}

	public void setCreateUserId(Integer createUserId) {
		this.createUserId = createUserId;
	}

	public void setCreateUsername(String createUsername) {
		this.createUsername = createUsername;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Integer getIdentifyType() {
		return identifyType;
	}

	public void setIdentifyType(Integer identifyType) {
		this.identifyType = identifyType;
	}

	public Integer getInTypeId() {
		return inTypeId;
	}

	public String getInTypeName() {
		return inTypeName;
	}

	public void setInTypeId(Integer inTypeId) {
		this.inTypeId = inTypeId;
	}

	public void setInTypeName(String inTypeName) {
		this.inTypeName = inTypeName;
	}

	public Date getProductInStartDate() {
		return productInStartDate;
	}

	public Date getProductInEndDate() {
		return productInEndDate;
	}

	public void setProductInStartDate(Date productInStartDate) {
		this.productInStartDate = productInStartDate;
	}

	public void setProductInEndDate(Date productInEndDate) {
		this.productInEndDate = productInEndDate;
	}
}
