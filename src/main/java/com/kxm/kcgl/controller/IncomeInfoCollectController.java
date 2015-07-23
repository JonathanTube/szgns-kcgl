package com.kxm.kcgl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kxm.kcgl.service.IncomeInfoCollectService;

@RestController
public class IncomeInfoCollectController {
	@Autowired
	private IncomeInfoCollectService incomeInfoCollectService;

	@RequestMapping("/addIncomeInfos")
	public String addIncomeInfo(@RequestParam(value = "json") String json) {
		int size = incomeInfoCollectService.addIncomeInfos(json);
		return size + "条记录添加成功";
	}
}
