package com.kxm.kcgl.view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.hyjd.frame.psm.base.LoginSession;
import com.hyjd.frame.psm.datamodel.PaginationDataModel;
import com.hyjd.frame.psm.utils.MsgTool;
import com.kxm.kcgl.LogicException;
import com.kxm.kcgl.domain.PreProductOut;
import com.kxm.kcgl.domain.Product;
import com.kxm.kcgl.domain.ProductQueryTimes;
import com.kxm.kcgl.domain.User;
import com.kxm.kcgl.service.PreProductOutService;
import com.kxm.kcgl.service.ProductQueryTimesService;
import com.kxm.kcgl.service.ProductService;

@Component
@Scope("view")
public class MainView implements Serializable {
	private static final long serialVersionUID = -3617720788091260172L;

	@Autowired
	private LoginSession loginSession;

	@Autowired
	private ProductService productService;

	@Autowired
	private ProductQueryTimesService productQueryTimesService;

	@Autowired
	private PreProductOutService preProductOutService;

	private PreProductOut preProductOut = new PreProductOut();

	private Product selectedStock = new Product();

	private PaginationDataModel<Product> stockModel;
	
	private Product condition = new Product();

	@PostConstruct
	public void init() {
		initStockList();
	}

	public void search() {
		User user = (User) loginSession.getSesionObj();
		condition.setManufactorId(user.getManufactorId());
		List<Product> products = productService.search(condition);
		for (Product product : products) {
			// 插入查询次数表
			ProductQueryTimes pqt = new ProductQueryTimes();
			pqt.setProductId(product.getId());
			pqt.setCreateUserId(user.getId());
			productQueryTimesService.insert(pqt);
		}
		stockModel = new PaginationDataModel<Product>("com.kxm.kcgl.mapper.ProductMapper.search", condition);
	}

	public void initStockList() {
		condition = new Product();
		User user = (User) loginSession.getSesionObj();
		condition.setManufactorId(user.getManufactorId());
		stockModel = new PaginationDataModel<Product>("com.kxm.kcgl.mapper.ProductMapper.selectSelective",condition);
	}

	public void showPreProductOut(Integer productId) {
		Product condition = new Product();
		condition.setId(productId);
		List<Product> stocks = productService.selectSelective(condition);
		if (stocks.size() <= 0) {
			MsgTool.addWarningMsg("库存不足");
			return;
		} else {
			selectedStock = stocks.get(0);
		}
	}

	public void preProductOut() {
		try {
			User user = (User) loginSession.getSesionObj();
			preProductOut.setCreateUserId(user.getId());
			boolean isOk = preProductOutService.insert(selectedStock, preProductOut);
			if (isOk) {
				MsgTool.addInfoMsg("预出货成功");
				RequestContext.getCurrentInstance().execute("PF('pre_product_out').hide()");
			} else {
				MsgTool.addWarningMsg("预出货失败");
			}
		} catch (LogicException e) {
			MsgTool.addWarningMsg(e.getMessage());
			e.printStackTrace();
		}
	}

	public PaginationDataModel<Product> getStockModel() {
		return stockModel;
	}

	public void setStockModel(PaginationDataModel<Product> stockModel) {
		this.stockModel = stockModel;
	}

	public PreProductOut getPreProductOut() {
		return preProductOut;
	}

	public void setPreProductOut(PreProductOut preProductOut) {
		this.preProductOut = preProductOut;
	}

	public Product getSelectedStock() {
		return selectedStock;
	}

	public void setSelectedStock(Product selectedStock) {
		this.selectedStock = selectedStock;
	}

	public Product getCondition() {
		return condition;
	}

	public void setCondition(Product condition) {
		this.condition = condition;
	}
}