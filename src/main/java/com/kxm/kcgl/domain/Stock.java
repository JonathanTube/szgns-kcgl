package com.kxm.kcgl.domain;

import java.util.Date;

public class Stock {
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
	private Double price;
	private Integer identifyType;
	private Integer identifyId;
	private String identifyName;
	private Integer quantityId;
	private String quantityName;
	private Integer manufactorId;
	private String manufactorName;
	private Integer queryTimes;

	private Date queryTimesStartDate;
	private Date queryTimesEndDate;

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

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getIdentifyId() {
		return identifyId;
	}

	public void setIdentifyId(Integer identifyId) {
		this.identifyId = identifyId;
	}

	public String getIdentifyName() {
		return identifyName;
	}

	public void setIdentifyName(String identifyName) {
		this.identifyName = identifyName;
	}

	public Integer getQueryTimes() {
		return queryTimes;
	}

	public void setQueryTimes(Integer queryTimes) {
		this.queryTimes = queryTimes;
	}

	public Integer getIdentifyType() {
		return identifyType;
	}

	public void setIdentifyType(Integer identifyType) {
		this.identifyType = identifyType;
	}

	public Integer getManufactorId() {
		return manufactorId;
	}

	public String getManufactorName() {
		return manufactorName;
	}

	public void setManufactorId(Integer manufactorId) {
		this.manufactorId = manufactorId;
	}

	public void setManufactorName(String manufactorName) {
		this.manufactorName = manufactorName;
	}

	public Date getQueryTimesStartDate() {
		return queryTimesStartDate;
	}

	public void setQueryTimesStartDate(Date queryTimesStartDate) {
		this.queryTimesStartDate = queryTimesStartDate;
	}

	public Date getQueryTimesEndDate() {
		return queryTimesEndDate;
	}

	public void setQueryTimesEndDate(Date queryTimesEndDate) {
		this.queryTimesEndDate = queryTimesEndDate;
	}

	public Integer getQuantityId() {
		return quantityId;
	}

	public void setQuantityId(Integer quantityId) {
		this.quantityId = quantityId;
	}

	public String getQuantityName() {
		return quantityName;
	}

	public void setQuantityName(String quantityName) {
		this.quantityName = quantityName;
	}
}
