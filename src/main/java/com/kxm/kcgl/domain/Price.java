package com.kxm.kcgl.domain;

public class Price {
	private Integer id;
	private Integer productId;
	private Integer quantityId;
	private Double price;

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
}
