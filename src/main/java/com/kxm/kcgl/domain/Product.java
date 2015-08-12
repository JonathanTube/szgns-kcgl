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
	private Integer identifyId;
	private String identifyName;
	private Integer quantityId;
	private String quantityName;
	private Integer manufactorId;
	private String manufactorName;
	private Integer amount;
	private Double price;
	private Integer queryTimes;
	private Integer createUserId;
	private String createUsername;
	private Date createTime;
	
	private Double avgSalePrice;
	
	private Date queryTimesStartDate;
	private Date queryTimesEndDate;
	

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

	public Integer getIdentifyId() {
		return identifyId;
	}

	public String getIdentifyName() {
		return identifyName;
	}

	public Integer getQuantityId() {
		return quantityId;
	}

	public String getQuantityName() {
		return quantityName;
	}

	public Integer getManufactorId() {
		return manufactorId;
	}

	public String getManufactorName() {
		return manufactorName;
	}

	public Double getPrice() {
		return price;
	}

	public void setIdentifyId(Integer identifyId) {
		this.identifyId = identifyId;
	}

	public void setIdentifyName(String identifyName) {
		this.identifyName = identifyName;
	}

	public void setQuantityId(Integer quantityId) {
		this.quantityId = quantityId;
	}

	public void setQuantityName(String quantityName) {
		this.quantityName = quantityName;
	}

	public void setManufactorId(Integer manufactorId) {
		this.manufactorId = manufactorId;
	}

	public void setManufactorName(String manufactorName) {
		this.manufactorName = manufactorName;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Date getQueryTimesStartDate() {
		return queryTimesStartDate;
	}

	public Date getQueryTimesEndDate() {
		return queryTimesEndDate;
	}

	public void setQueryTimesStartDate(Date queryTimesStartDate) {
		this.queryTimesStartDate = queryTimesStartDate;
	}

	public void setQueryTimesEndDate(Date queryTimesEndDate) {
		this.queryTimesEndDate = queryTimesEndDate;
	}

	public Double getAvgSalePrice() {
		return avgSalePrice;
	}

	public void setAvgSalePrice(Double avgSalePrice) {
		this.avgSalePrice = avgSalePrice;
	}
}
