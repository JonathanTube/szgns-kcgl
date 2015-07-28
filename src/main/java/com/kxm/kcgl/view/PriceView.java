package com.kxm.kcgl.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.kxm.kcgl.domain.Product;
import com.kxm.kcgl.service.ProductService;

@Component
@Scope("view")
public class PriceView implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Product> priceList = new ArrayList<Product>();

	@Autowired
	private ProductService productService;

	@PostConstruct
	public void init() {
		queryPrice();
	}

	public void queryPrice() {
		priceList = productService.queryAll();
	}

	public List<Product> getPriceList() {
		return priceList;
	}

	public void setPriceList(List<Product> priceList) {
		this.priceList = priceList;
	}
}