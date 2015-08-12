package com.kxm.kcgl.view;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.hyjd.frame.psm.base.LoginSession;
import com.kxm.kcgl.domain.Product;
import com.kxm.kcgl.domain.User;
import com.kxm.kcgl.service.ProductService;

@Component
@Scope("view")
public class StockView {
	@Autowired
	private ProductService productService;
	private List<Product> productList = new ArrayList<Product>();
	
	@Autowired
	private LoginSession loginSession;

	@PostConstruct
	public void init() {
		User user = (User) loginSession.getSesionObj();
		Product condition = new Product();
		condition.setManufactorId(user.getManufactorId());
		productList = productService.selectSelective(condition);
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

}
