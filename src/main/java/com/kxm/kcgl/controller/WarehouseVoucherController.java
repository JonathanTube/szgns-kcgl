package com.kxm.kcgl.controller;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kxm.kcgl.service.WarehouseVoucherService;

@RestController
public class WarehouseVoucherController {

	@Autowired
	private WarehouseVoucherService warehouseVoucherService;

	@RequestMapping("/queryIncomeDaily")
	public Map<String, Object> queryIncomeDaily() {
		return warehouseVoucherService.query(new Date());
	}
}
