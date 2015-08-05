package com.kxm.kcgl.domain;

public class Price {
	private Integer id;
	private Integer productId;
	private String productNo;
	private String productName;
	private Integer brandId;
	private String brandName;
	private Integer techId;
	private String techName;
	private Integer thicknessId;
	private String thicknessName;
	private Integer quantityId;
	private String quantityName;
	private Double price;
	private Double avgSalePrice;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getQuantityId() {
		return quantityId;
	}

	public void setQuantityId(Integer quantityId) {
		this.quantityId = quantityId;
	}

	public String getProductNo() {
		return productNo;
	}

	public String getProductName() {
		return productName;
	}

	public Integer getBrandId() {
		return brandId;
	}

	public String getBrandName() {
		return brandName;
	}

	public Integer getTechId() {
		return techId;
	}

	public String getTechName() {
		return techName;
	}

	public Integer getThicknessId() {
		return thicknessId;
	}

	public String getThicknessName() {
		return thicknessName;
	}

	public String getQuantityName() {
		return quantityName;
	}

	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public void setTechId(Integer techId) {
		this.techId = techId;
	}

	public void setTechName(String techName) {
		this.techName = techName;
	}

	public void setThicknessId(Integer thicknessId) {
		this.thicknessId = thicknessId;
	}

	public void setThicknessName(String thicknessName) {
		this.thicknessName = thicknessName;
	}

	public void setQuantityName(String quantityName) {
		this.quantityName = quantityName;
	}

	public Double getAvgSalePrice() {
		return avgSalePrice;
	}

	public void setAvgSalePrice(Double avgSalePrice) {
		this.avgSalePrice = avgSalePrice;
	}
}
