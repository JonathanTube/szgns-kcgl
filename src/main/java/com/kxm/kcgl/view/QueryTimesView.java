package com.kxm.kcgl.view;

import java.io.Serializable;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.hyjd.frame.psm.datamodel.PaginationDataModel;
import com.kxm.kcgl.domain.Product;

@Component
@Scope("view")
public class QueryTimesView implements Serializable {

	private static final long serialVersionUID = 1L;
	private Product condition = new Product();
	private PaginationDataModel<Product> productDataModel;

	@PostConstruct
	public void init() {
		queryStock();
	}

	public void queryStock() {
		productDataModel = new PaginationDataModel<Product>("com.kxm.kcgl.mapper.ProductMapper.selectSelective", condition);
	}

	public PaginationDataModel<Product> getProductDataModel() {
		return productDataModel;
	}

	public void setProductDataModel(PaginationDataModel<Product> productDataModel) {
		this.productDataModel = productDataModel;
	}

	public Product getCondition() {
		return condition;
	}

	public void setCondition(Product condition) {
		this.condition = condition;
	}

}