package com.kxm.kcgl.domain;

import java.util.Date;

public class CommisionDetail {
	private Integer userId;
	private String productNo;
	private String productName;
	private String brandName;
	private String techName;
	private String thicknessName;
	private Integer saleAmount;
	private Double totalCost;
	private Double salePrice;
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

	public Integer getSaleAmount() {
		return saleAmount;
	}

	public void setSaleAmount(Integer saleAmount) {
		this.saleAmount = saleAmount;
	}

	public Double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;
	}

	public Double getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(Double salePrice) {
		this.salePrice = salePrice;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
}
