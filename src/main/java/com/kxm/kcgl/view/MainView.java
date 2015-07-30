package com.kxm.kcgl.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.kxm.kcgl.domain.Product;
import com.kxm.kcgl.domain.Stock;
import com.kxm.kcgl.service.ProductService;
import com.kxm.kcgl.service.StockService;

@Component
@Scope("view")
public class MainView implements Serializable {
	private static final long serialVersionUID = -3617720788091260172L;

	@Autowired
	private StockService stockService;

	@Autowired
	private ProductService productService;

	private Product selectedProduct = new Product();

	private List<Stock> stockList;
	
	public List<Product> completeProduct(String keywords) {
		List<Product> list = new ArrayList<Product>();
		if (StringUtils.isEmpty(keywords))
			return list;
		list = productService.search(keywords);
		return list;
	}

	public void onItemSelect() {
		Stock condition = new Stock();
		condition.setProductId(selectedProduct.getId());		
		stockList = stockService.selectSelective(condition);
	}

	public Product getSelectedProduct() {
		return selectedProduct;
	}

	public void setSelectedProduct(Product selectedProduct) {
		this.selectedProduct = selectedProduct;
	}
	
	public List<Stock> getStockList() {
		return stockList;
	}

	public void setStockList(List<Stock> stockList) {
		this.stockList = stockList;
	}
}