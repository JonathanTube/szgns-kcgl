package com.kxm.kcgl.view;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.hyjd.frame.psm.base.LoginSession;
import com.hyjd.frame.psm.datamodel.PaginationDataModel;
import com.kxm.kcgl.domain.Product;
import com.kxm.kcgl.domain.User;
import com.kxm.kcgl.service.ProductService;

@Component
@Scope("view")
public class PriceView {
	@Autowired
	private ProductService productService;
	
	private PaginationDataModel<Product> priceModel;
	
	@Autowired
	private LoginSession loginSession;

	@PostConstruct
	public void init() {
		User user = (User) loginSession.getSesionObj();
		Product condition = new Product();
		condition.setManufactorId(user.getManufactorId());
		priceModel = new PaginationDataModel<Product>("com.kxm.kcgl.mapper.ProductMapper.selectSelective", condition);
	}

	public PaginationDataModel<Product> getPriceModel() {
		return priceModel;
	}

	public void setPriceModel(PaginationDataModel<Product> priceModel) {
		this.priceModel = priceModel;
	}
}
