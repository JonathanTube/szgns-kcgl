package com.kxm.kcgl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kxm.kcgl.domain.MessageResult;
import com.kxm.kcgl.domain.TechBean;
import com.kxm.kcgl.domain.ThicknessBean;
import com.kxm.kcgl.service.TechService;
import com.kxm.kcgl.service.ThicknessService;

@RestController
public class ThicknessController {

	@Autowired
	private ThicknessService thicknessService;

	@RequestMapping("/addNewThickness")
	public MessageResult addNewBrand(@RequestParam(value = "name") String name) {
		String msg = thicknessService.addNewThickness(name);
		return new MessageResult(msg);
	}

	@RequestMapping("/queryAllThickness")
	public List<ThicknessBean> queryAllTech() {
		return thicknessService.queryAllThickness();
	}
	
	@RequestMapping("/deleteThickness")
	public void deleteThickness(@RequestParam(value="id") int id){
		thicknessService.deleteThickness(id);
	}
}
