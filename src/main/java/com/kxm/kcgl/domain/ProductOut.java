package com.kxm.kcgl.domain;

/**
 * @author kongxm
 * @date 2015 2015年7月27日 下午4:28:23
 */
public class ProductOut {
	private Integer id;
	private String productNo;
	private int productId;
	private String productName;
	private int brandId;
	private String brandName;
	private int techId;
	private String techName;
	private int thicknessId;
	private String thicknessName;
	private int identifyId;
	private String identifyName;
	private int amount;
	private double price;
	private double salePrice;
	private String custName;
	private int createUser;
	private String createTime;
	private String userId;
	
	public Integer getId() {
		return id;
	}
	public String getProductNo() {
		return productNo;
	}
	public int getProductId() {
		return productId;
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
	public double getSalePrice() {
		return salePrice;
	}
	public String getCustName() {
		return custName;
	}
	public String getCreateTime() {
		return createTime;
	}
	public String getUserId() {
		return userId;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}
	public void setProductId(int productId) {
		this.productId = productId;
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
	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getCreateUser() {
		return createUser;
	}
	public void setCreateUser(int createUser) {
		this.createUser = createUser;
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
}
