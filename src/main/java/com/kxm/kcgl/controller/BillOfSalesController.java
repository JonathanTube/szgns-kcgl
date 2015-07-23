package com.kxm.kcgl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kxm.kcgl.dao.BillDao;
import com.kxm.kcgl.dao.DeliveryVoucherDao;
import com.kxm.kcgl.domain.BillBean;
import com.kxm.kcgl.domain.DeliveryVoucherBean;

@RestController
public class BillOfSalesController {

	@Autowired
	private BillDao billDao;

	@Autowired
	private DeliveryVoucherDao deliveryVoucherDao;

	@RequestMapping("/queryAllBill")
	public List<BillBean> queryAllBill() {
		return billDao.query();
	}

	@RequestMapping("/queryBillBySeq")
	public List<DeliveryVoucherBean> queryBillBySeq(@RequestParam(value = "seq") String seq) {
		return deliveryVoucherDao.queryBySeq(seq);
	}

	@RequestMapping("/deleteBill")
	public String deleteBill(@RequestParam(value = "seq") String seq) {
		deliveryVoucherDao.deleteBill(seq);
		return "删除成功";
	}
}
