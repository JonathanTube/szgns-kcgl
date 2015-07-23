package com.kxm.kcgl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kxm.kcgl.domain.BrandBean;
import com.kxm.kcgl.domain.MessageResult;
import com.kxm.kcgl.domain.StockBean;
import com.kxm.kcgl.service.BrandService;
import com.kxm.kcgl.service.StockService;

@RestController
public class StockController {

	@Autowired
	private StockService stockService;

	@RequestMapping("/queryStock")
	public List<StockBean> queryStock() {
		return stockService.queryAll();
	}
}
