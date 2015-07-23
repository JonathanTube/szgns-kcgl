package com.kxm.kcgl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kxm.kcgl.service.OutcomeInfoCollectService;

@RestController
public class OutcomeInfoCollectController {
	@Autowired
	private OutcomeInfoCollectService outcomeInfoCollectService;

	@RequestMapping("/addOutcomeInfos")
	public String addOutcomeInfo(@RequestParam(value = "json") String json,@RequestParam(value="userName") String userName) {
		try{
			return outcomeInfoCollectService.addOutcomeInfos(json,userName);
		}catch(Exception e){
			e.printStackTrace();
			return e.getMessage();
		}
	}
}
