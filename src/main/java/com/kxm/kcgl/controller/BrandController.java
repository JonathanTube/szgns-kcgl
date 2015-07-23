package com.kxm.kcgl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kxm.kcgl.domain.BrandBean;
import com.kxm.kcgl.domain.MessageResult;
import com.kxm.kcgl.service.BrandService;

@RestController
public class BrandController {

	@Autowired
	private BrandService brandService;

	@RequestMapping("/addNewBrand")
	public MessageResult addNewBrand(@RequestParam(value = "name") String name) {
		String msg = brandService.addNewBrand(name);
		return new MessageResult(msg);
	}

	@RequestMapping("/queryAllBrand")
	public List<BrandBean> queryAllBrand() {
		return brandService.queryAllBrand();
	}
	

	@RequestMapping("/deleteBrand")
	public void deleteBrand(@RequestParam(value="id") int id){
		brandService.deleteBrand(id);
	}
}
