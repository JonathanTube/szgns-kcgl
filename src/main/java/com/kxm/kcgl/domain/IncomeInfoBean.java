package com.kxm.kcgl.domain;

public class IncomeInfoBean {
	private int id;
	private int brandId;
	private int productId;
	private int techId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBrandId() {
		return brandId;
	}
	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getTechId() {
		return techId;
	}
	public void setTechId(int techId) {
		this.techId = techId;
	}
	public int getThicknessId() {
		return thicknessId;
	}
	public void setThicknessId(int thicknessId) {
		this.thicknessId = thicknessId;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	private int thicknessId;
	private int amount;
}
