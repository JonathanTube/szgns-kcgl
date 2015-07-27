package com.kxm.kcgl.view;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.hyjd.frame.psm.datamodel.PaginationDataModel;
import com.hyjd.frame.psm.utils.MsgTool;
import com.kxm.kcgl.domain.Product;
import com.kxm.kcgl.domain.ProductOut;
import com.kxm.kcgl.service.ProductOutService;
import com.kxm.kcgl.service.ProductService;

@Component
@Scope("view")
public class ProductOutView implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private ProductOutService productOutService;
	@Autowired
	private ProductService productService;

	private PaginationDataModel<ProductOut> productOutModel;

	private List<ProductOut> productOutList = new LinkedList<ProductOut>();

	private List<Product> productList;

	private int productId;
	private String productNo;

	@PostConstruct
	public void init() {
		query();
		initProductList();
	}

	public void initProductList() {
		productList = productService.queryAll();
	}

	public void query() {
		productOutModel = new PaginationDataModel<ProductOut>("com.kxm.kcgl.mapper.ProductOutMapper.selectSelective");
	}

	public void addProductOut(ActionEvent event) {
		String id = event.getComponent().getId();
		Product product = null;
		if (id.contains("btn_productNo")) {
			product = productService.queryByProductNo(productNo);
		} else {
			product = productService.queryByProductId(productId);
		}
		if (product == null) {
			MsgTool.addInfoMsg("未查询到产品");
			return;
		}
		ProductOut productOut = new ProductOut();
		productOut.setBrandId(product.getBrandId());
		productOut.setBrandName(product.getBrandName());
		productOut.setProductId(product.getId());
		productOut.setProductName(product.getProductName());
		productOut.setTechId(product.getTechId());
		productOut.setTechName(product.getTechName());
		productOut.setProductNo(product.getProductNo());
		productOut.setThicknessId(product.getThicknessId());
		productOut.setThicknessName(product.getThicknessName());
		productOut.setIdentifyId(product.getIdentifyId());
		productOut.setIdentifyName(product.getIdentifyName());
		productOutList.add(productOut);
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

	public void setProductOutModel(PaginationDataModel<ProductOut> productOutModel) {
		this.productOutModel = productOutModel;
	}

	public void setProductOutList(List<ProductOut> productOutList) {
		this.productOutList = productOutList;
	}
}