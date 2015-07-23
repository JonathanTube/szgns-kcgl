package com.kxm.kcgl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kxm.kcgl.domain.CustBean;
import com.kxm.kcgl.domain.MessageResult;
import com.kxm.kcgl.service.CustService;

@RestController
public class CustController {

	@Autowired
	private CustService custService;

	@RequestMapping("/addNewCust")
	public MessageResult addNewCust(@RequestParam(value = "name") String name) {
		String msg = custService.addNewCust(name);
		return new MessageResult(msg);
	}

	@RequestMapping("/queryAllCust")
	public List<CustBean> queryAllCust() {
		return custService.queryAllCust();
	}
	
	@RequestMapping("/deleteCust")
	public void deleteCust(@RequestParam(value="id") int id){
		custService.deleteCust(id);
	}
}
