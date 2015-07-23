package com.kxm.kcgl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kxm.kcgl.domain.MessageResult;
import com.kxm.kcgl.domain.ProductBean;
import com.kxm.kcgl.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping("/addNewProduct")
	public MessageResult addNewBrand(@RequestParam(value = "name") String name,
			@RequestParam(value = "brandId") String brandId) {
		String msg = productService.addNewProduct(name, brandId);
		return new MessageResult(msg);
	}

	@RequestMapping("/queryAllProduct")
	public List<ProductBean> queryAllProduct(
			@RequestParam(value = "brandId", required = false) String brandId) {
		return productService.queryAllProduct(brandId);
	}

	@RequestMapping("/deleteProduct")
	public void deleteProduct(@RequestParam(value = "id") int id) {
		productService.deleteProduct(id);
	}
}
