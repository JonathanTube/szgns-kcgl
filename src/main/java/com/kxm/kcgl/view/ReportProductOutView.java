package com.kxm.kcgl.view;

import java.io.Serializable;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.hyjd.frame.psm.datamodel.PaginationDataModel;
import com.kxm.kcgl.domain.ProductOut;

@Component
@Scope("view")
public class ReportProductOutView implements Serializable {

	private static final long serialVersionUID = 1L;

	private PaginationDataModel<ProductOut> productOutDataModel;

	private ProductOut condition = new ProductOut();

	@PostConstruct
	public void init() {
		initProductOutList();
	}

	public void initProductOutList() {
		productOutDataModel = new PaginationDataModel<ProductOut>("com.kxm.kcgl.mapper.ProductOutMapper.selectSelective", condition);
	}

	public PaginationDataModel<ProductOut> getProductOutDataModel() {
		return productOutDataModel;
	}

	public void setProductOutDataModel(PaginationDataModel<ProductOut> productOutDataModel) {
		this.productOutDataModel = productOutDataModel;
	}

	public ProductOut getCondition() {
		return condition;
	}

	public void setCondition(ProductOut condition) {
		this.condition = condition;
	}

}