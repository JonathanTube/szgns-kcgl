package com.kxm.kcgl.domain;

import java.util.Date;

/**
 * @author kongxm
 * @date 2015 2015年7月27日 下午4:28:23
 */
public class ProductOut {
	private Integer id;
	private String productNo;
	private Integer productId;
	private String productName;
	private Integer brandId;
	private String brandName;
	private Integer techId;
	private String techName;
	private Integer thicknessId;
	private String thicknessName;
	private Integer identifyType;
	private Integer identifyId;
	private String identifyName;
	private Integer manufactorId;
	private String manufactorName;
	private Integer custId;
	private String custName;
	private Integer billId;
	private int stockAmount;
	private int amount;
	private double stockPrice;
	private double price;
	private double money;
	private Integer quantityId;
	private String quantityName;
	private Integer createUserId;
	private String createUserName;
	private String createTime;

	private Date productOutStartDate;
	private Date productOutEndDate;

	public Integer getId() {
		return id;
	}

	public String getProductNo() {
		return productNo;
	}

	public Integer getProductId() {
		return productId;
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

	public double getPrice() {
		return price;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
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

	public void setPrice(double price) {
		this.price = price;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Integer getIdentifyId() {
		return identifyId;
	}

	public String getIdentifyName() {
		return identifyName;
	}

	public void setIdentifyId(Integer identifyId) {
		this.identifyId = identifyId;
	}

	public void setIdentifyName(String identifyName) {
		this.identifyName = identifyName;
	}

	public Integer getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(Integer createUserId) {
		this.createUserId = createUserId;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getCreateUserName() {
		return createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}

	public int getStockAmount() {
		return stockAmount;
	}

	public void setStockAmount(int stockAmount) {
		this.stockAmount = stockAmount;
	}

	public Integer getIdentifyType() {
		return identifyType;
	}

	public void setIdentifyType(Integer identifyType) {
		this.identifyType = identifyType;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public Integer getCustId() {
		return custId;
	}

	public void setCustId(Integer custId) {
		this.custId = custId;
	}

	public double getStockPrice() {
		return stockPrice;
	}

	public void setStockPrice(double stockPrice) {
		this.stockPrice = stockPrice;
	}

	public Integer getManufactorId() {
		return manufactorId;
	}

	public void setManufactorId(Integer manufactorId) {
		this.manufactorId = manufactorId;
	}

	public String getManufactorName() {
		return manufactorName;
	}

	public void setManufactorName(String manufactorName) {
		this.manufactorName = manufactorName;
	}

	public Integer getBillId() {
		return billId;
	}

	public void setBillId(Integer billId) {
		this.billId = billId;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public Date getProductOutStartDate() {
		return productOutStartDate;
	}

	public Date getProductOutEndDate() {
		return productOutEndDate;
	}

	public void setProductOutStartDate(Date productOutStartDate) {
		this.productOutStartDate = productOutStartDate;
	}

	public void setProductOutEndDate(Date productOutEndDate) {
		this.productOutEndDate = productOutEndDate;
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
