package com.kxm.kcgl.domain;

import java.util.Date;

public class ProductQueryTimes {
	private Integer id;
	private Integer productId;
	private Integer createUserId;
	private Date createTime;

	public Integer getId() {
		return id;
	}

	public Integer getProductId() {
		return productId;
	}

	public Integer getCreateUserId() {
		return createUserId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public void setCreateUserId(Integer createUserId) {
		this.createUserId = createUserId;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
