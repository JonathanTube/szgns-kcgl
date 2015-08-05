package com.kxm.kcgl.view;

import java.io.Serializable;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.hyjd.frame.psm.datamodel.PaginationDataModel;
import com.kxm.kcgl.domain.Price;
import com.kxm.kcgl.service.ProductService;

@Component
@Scope("view")
public class PriceView implements Serializable {

	private static final long serialVersionUID = 1L;

	private PaginationDataModel<Price> priceModel;

	@Autowired
	private ProductService productService;

	@PostConstruct
	public void init() {
		queryPrice();
	}

	public void queryPrice() {
		priceModel = new PaginationDataModel<Price>("com.kxm.kcgl.mapper.PriceMapper.selectSelective");
	}

	public PaginationDataModel<Price> getPriceModel() {
		return priceModel;
	}

	public void setPriceModel(PaginationDataModel<Price> priceModel) {
		this.priceModel = priceModel;
	}
}