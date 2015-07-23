package com.kxm.kcgl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kxm.kcgl.domain.MessageResult;
import com.kxm.kcgl.domain.TechBean;
import com.kxm.kcgl.service.TechService;

@RestController
public class TechController {

	@Autowired
	private TechService techService;

	@RequestMapping("/addNewTech")
	public MessageResult addNewBrand(@RequestParam(value = "name") String name) {
		String msg = techService.addNewTech(name);
		return new MessageResult(msg);
	}

	@RequestMapping("/queryAllTech")
	public List<TechBean> queryAllTech() {
		return techService.queryAllTech();
	}
	
	@RequestMapping("/deleteTech")
	public void deleteTech(@RequestParam(value="id") int id){
		techService.deleteTech(id);
	}
}
