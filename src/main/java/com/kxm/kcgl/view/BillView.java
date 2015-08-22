package com.kxm.kcgl.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.kxm.kcgl.domain.Bill;
import com.kxm.kcgl.domain.ProductOut;
import com.kxm.kcgl.service.BillService;
import com.kxm.kcgl.service.ProductOutService;

@Component
@Scope("view")
public class BillView implements Serializable {

	private static final long serialVersionUID = -8468036824170194530L;

	@Autowired
	private ProductOutService productOutService;
	@Autowired
	private BillService billService;

	private Bill bill = new Bill();

	private List<ProductOut> productOutList = new ArrayList<ProductOut>();

	@PostConstruct
	public void init() {
		Object billId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("billId");
		if (billId != null) {
			Integer _billId = Integer.valueOf(billId.toString());
			initBill(_billId);
			initProductOutList(_billId);
		}
	}

	private void initBill(Integer billId) {
		bill.setId(billId);
		List<Bill> bills = billService.selectSelective(bill);
		if (bills.size() > 0) {
			bill = bills.get(0);
		}
	}

	private void initProductOutList(Integer billId) {
		ProductOut condition = new ProductOut();
		condition.setBillId(billId);
		productOutList = productOutService.selectSelective(condition);
	}

	public List<ProductOut> getProductOutList() {
		return productOutList;
	}

	public void setProductOutList(List<ProductOut> productOutList) {
		this.productOutList = productOutList;
	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}
}