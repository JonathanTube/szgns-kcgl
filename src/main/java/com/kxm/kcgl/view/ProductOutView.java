package com.kxm.kcgl.view;

import java.io.Serializable;
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
import com.kxm.kcgl.domain.Cust;
import com.kxm.kcgl.domain.Product;
import com.kxm.kcgl.domain.ProductOut;
import com.kxm.kcgl.domain.Stock;
import com.kxm.kcgl.domain.User;
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

	private PaginationDataModel<ProductOut> productOutModel;

	private List<ProductOut> productOutList = new LinkedList<ProductOut>();

	private List<Product> productList;

	private List<Cust> custList;
	@Autowired
	private CustService custService;
	private String custName;

	private ProductOut productOut = new ProductOut();

	@Autowired
	private LoginSession loginSession;

	private int productId;
	private String productNo;

	@PostConstruct
	public void init() {
		query();
		initCustList();
		initProductList();
	}

	public void initCustList() {
		custList = custService.selectSelective(new Cust());
	}

	public void addCust() {
		String msg = custService.addNew(custName);
		MsgTool.addInfoMsg(msg);
		initCustList();
	}

	public void initProductList() {
		productList = productService.queryAll();
	}

	public void query() {
		productOutModel = new PaginationDataModel<ProductOut>(
				"com.kxm.kcgl.mapper.ProductOutMapper.selectSelective");
	}

	public void editExistTemp(ProductOut productOut) {
		this.productOut = productOut;
		RequestContext.getCurrentInstance().execute("PF('edit_dlg').show()");
	}

	public void addProductOut(ActionEvent event) {
		// 判断是否已经添加过
		for (ProductOut productOut : productOutList) {
			if (productOut.getProductId().equals(productId)
					|| productOut.getProductNo().equals(productNo)) {
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
			productOutList.add(productOut);
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

	public String getCustName(int custId) {
		for (Cust cust : custList) {
			if (cust.getId() == custId) {
				return cust.getName();
			}
		}
		return "";
	}

	public void productOut() {
		productOutService.productOut(productOutList);
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

	public PaginationDataModel<ProductOut> getProductOutModel() {
		return productOutModel;
	}

	public List<ProductOut> getProductOutList() {
		return productOutList;
	}

	public void setProductOutModel(
			PaginationDataModel<ProductOut> productOutModel) {
		this.productOutModel = productOutModel;
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
}