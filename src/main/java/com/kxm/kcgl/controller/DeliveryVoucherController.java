package com.kxm.kcgl.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kxm.kcgl.domain.DeliveryVoucherBean;
import com.kxm.kcgl.service.DeliveryVoucherService;

@RestController
public class DeliveryVoucherController {

	@Autowired
	private DeliveryVoucherService deliveryVoucherService;

	@RequestMapping("/queryOutcomeDaily")
	public Map<String, Object> queryOutcomeDaily() {
		return deliveryVoucherService.query(new Date());
	}

	@RequestMapping("queryOutcomeDailyDetail")
	public List<DeliveryVoucherBean> queryOutcomeDailyDetail(
			@RequestParam(required = false, value = "dateTime") String dateTime,
			@RequestParam(required = false, value = "day") String day,
			@RequestParam(required = false, value = "custId") String custId)
			throws ParseException {
		Date d = null;
		if (!StringUtils.isEmpty(dateTime)) {
			d = new SimpleDateFormat("yyyyMMdd").parse(dateTime);
		} else if (!StringUtils.isEmpty(day)) {
			if (day.length() == 1) {
				day += "0" + day;
			}
			String _date = new SimpleDateFormat("yyyyMM").format(new Date())
					+ day;
			d = new SimpleDateFormat("yyyyMMdd").parse(_date);
		}
		return deliveryVoucherService.queryDetail(d,custId);
	}
}
