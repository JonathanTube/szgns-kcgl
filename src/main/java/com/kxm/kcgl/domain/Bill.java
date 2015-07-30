package com.kxm.kcgl.domain;

import java.util.Date;

public class Bill {
	private Integer id;
	private String seq;
	private Integer custId;
	private String custName;
	private Integer totalAmount;
	private double totalPrice;
	private double totalMoney;
	private Integer createUserId;
	private String createUserName;
	private Date createTime;

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCustId() {
		return custId;
	}

	public Integer getTotalAmount() {
		return totalAmount;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public double getTotalMoney() {
		return totalMoney;
	}

	public Integer getCreateUserId() {
		return createUserId;
	}

	public String getCreateUserName() {
		return createUserName;
	}

	public void setCustId(Integer custId) {
		this.custId = custId;
	}

	public void setTotalAmount(Integer totalAmount) {
		this.totalAmount = totalAmount;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public void setTotalMoney(double totalMoney) {
		this.totalMoney = totalMoney;
	}

	public void setCreateUserId(Integer createUserId) {
		this.createUserId = createUserId;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}
}
