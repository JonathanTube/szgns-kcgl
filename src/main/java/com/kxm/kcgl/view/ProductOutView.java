package com.kxm.kcgl.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;

import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.hyjd.frame.psm.base.LoginSession;
import com.hyjd.frame.psm.datamodel.PaginationDataModel;
import com.hyjd.frame.psm.utils.MsgTool;
import com.kxm.kcgl.LogicException;
import com.kxm.kcgl.domain.Bill;
import com.kxm.kcgl.domain.Cust;
import com.kxm.kcgl.domain.Product;
import com.kxm.kcgl.domain.ProductOut;
import com.kxm.kcgl.domain.Stock;
import com.kxm.kcgl.domain.User;
import com.kxm.kcgl.service.BillService;
import com.kxm.kcgl.service.CustService;
import com.kxm.kcgl.service.ProductOutService;
import com.kxm.kcgl.service.ProductService;
import com.kxm.kcgl.service.StockService;

@Component
@Scope("view")
public class ProductOutView implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private ProductOutService productOutService;
	@Autowired
	private ProductService productService;

	@Autowired
	private StockService stockService;

	private List<ProductOut> productOutList = new ArrayList<ProductOut>();

	private Bill billCondition = new Bill();
	@Autowired
	private BillService billService;
	private PaginationDataModel<Bill> billDataModel;
	private Bill selectedBill = new Bill();

	private List<ProductOut> tempProductOutList = new LinkedList<ProductOut>();

	private List<Product> productList;

	private List<Cust> custList;
	@Autowired
	private CustService custService;
	private Integer custId;
	private String custName;

	private ProductOut productOut = new ProductOut();

	@Autowired
	private LoginSession loginSession;

	private int productId;
	private String productNo;

	@PostConstruct
	public void init() {
		initCustList();
		initProductList();
		initBillList();
	}

	public void initBillList() {
		billDataModel = new PaginationDataModel<Bill>("com.kxm.kcgl.mapper.BillMapper.selectSelective", billCondition);
	}

	public void initCustList() {
		Cust cust = new Cust();
		User user = (User) loginSession.getSesionObj();
		cust.setUserId(user.getId());
		// 只查询自己的客户
		custList = custService.selectSelective(cust);
	}

	public void addCust() {
		String msg;
		try {
			User user = (User) loginSession.getSesionObj();
			msg = custService.addNew(custName, user.getId());
			MsgTool.addInfoMsg(msg);
		} catch (LogicException e) {
			MsgTool.addInfoMsg(e.getMessage());
		}

		initCustList();
	}

	public void showBillDetail(Bill bill) {
		initProductOutList(bill.getId());
		selectedBill = bill;
		RequestContext.getCurrentInstance().execute("PF('bill_dlg').show()");
	}

	public void initProductList() {
		productList = productService.queryAll();
	}

	private void initProductOutList(Integer billId) {
		ProductOut condition = new ProductOut();
		condition.setBillId(billId);
		productOutList = productOutService.selectSelective(condition);
	}

	public void editExistTemp(ProductOut productOut) {
		this.productOut = productOut;
		RequestContext.getCurrentInstance().execute("PF('edit_dlg').show()");
	}

	public void delExistTemp(ProductOut productOut) {
		tempProductOutList.remove(productOut);
	}

	public void addProductOut(ActionEvent event) {
		// 判断是否已经添加过
		for (ProductOut productOut : productOutList) {
			if (productOut.getProductId().equals(productId) || productOut.getProductNo().equals(productNo)) {
				MsgTool.addInfoMsg("请不要重复添加出货的产品");
				return;
			}
		}
		String id = event.getComponent().getId();
		List<Stock> stockList = null;
		if ("btn_productId".equals(id)) {
			Stock condition = new Stock();
			condition.setProductId(productId);
			stockList = stockService.selectSelective(condition);
		} else {
			Stock condition = new Stock();
			condition.setProductNo(productNo);
			stockList = stockService.selectSelective(condition);
		}
		if (stockList == null || stockList.size() == 0) {
			MsgTool.addInfoMsg("未查询到产品库存");
			return;
		}
		for (Stock stock : stockList) {
			ProductOut productOut = new ProductOut();
			productOut.setBrandId(stock.getBrandId());
			productOut.setBrandName(stock.getBrandName());
			productOut.setProductId(stock.getProductId());
			productOut.setProductName(stock.getProductName());
			productOut.setTechId(stock.getTechId());
			productOut.setTechName(stock.getTechName());
			productOut.setProductNo(stock.getProductNo());
			productOut.setThicknessId(stock.getThicknessId());
			productOut.setThicknessName(stock.getThicknessName());
			productOut.setManufactorId(stock.getManufactorId());
			productOut.setManufactorName(stock.getManufactorName());
			productOut.setIdentifyType(stock.getIdentifyType());
			productOut.setIdentifyId(stock.getIdentifyId());
			productOut.setIdentifyName(stock.getIdentifyName());
			productOut.setStockAmount(stock.getAmount());
			productOut.setStockPrice(stock.getPrice());
			User user = (User) loginSession.getSesionObj();
			productOut.setCreateUserId(user.getId());
			productOut.setCreateUserName(user.getRealname());
			tempProductOutList.add(productOut);
		}
	}

	public void editExistTemp() {
		for (ProductOut p : productOutList) {
			if (productOut.getProductNo().equals(p.getProductNo())) {
				productOutList.remove(p);
			}
		}
		productOutList.add(productOut);
		RequestContext.getCurrentInstance().execute("PF('edit_dlg').hide()");
	}

	public String getCustName(Integer custId) {
		if (custId == null)
			return "";
		for (Cust cust : custList) {
			if (cust.getId() == custId) {
				return cust.getName();
			}
		}
		return "";
	}

	public void productOut() {
		try {
			User user = (User) loginSession.getSesionObj();
			productOutService.productOut(tempProductOutList, user.getId(), custId);
			tempProductOutList.clear();
			MsgTool.addInfoMsg("出货成功");
		} catch (LogicException e) {
			MsgTool.addInfoMsg(e.getMessage());
		}
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductNo() {
		return productNo;
	}

	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}

	public List<ProductOut> getProductOutList() {
		return productOutList;
	}

	public void setProductOutList(List<ProductOut> productOutList) {
		this.productOutList = productOutList;
	}

	public ProductOut getProductOut() {
		return productOut;
	}

	public void setProductOut(ProductOut productOut) {
		this.productOut = productOut;
	}

	public List<Cust> getCustList() {
		return custList;
	}

	public void setCustList(List<Cust> custList) {
		this.custList = custList;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public PaginationDataModel<Bill> getBillDataModel() {
		return billDataModel;
	}

	public void setBillDataModel(PaginationDataModel<Bill> billDataModel) {
		this.billDataModel = billDataModel;
	}

	public Bill getBillCondition() {
		return billCondition;
	}

	public void setBillCondition(Bill billCondition) {
		this.billCondition = billCondition;
	}

	public List<ProductOut> getTempProductOutList() {
		return tempProductOutList;
	}

	public void setTempProductOutList(List<ProductOut> tempProductOutList) {
		this.tempProductOutList = tempProductOutList;
	}

	public Integer getCustId() {
		return custId;
	}

	public void setCustId(Integer custId) {
		this.custId = custId;
	}

	public Bill getSelectedBill() {
		return selectedBill;
	}

	public void setSelectedBill(Bill selectedBill) {
		this.selectedBill = selectedBill;
	}
}