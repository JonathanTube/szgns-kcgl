package com.kxm.kcgl.view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.hyjd.frame.psm.datamodel.PaginationDataModel;
import com.kxm.kcgl.domain.BrandBean;
import com.kxm.kcgl.domain.Product;
import com.kxm.kcgl.domain.TechBean;
import com.kxm.kcgl.domain.ThicknessBean;
import com.kxm.kcgl.service.BrandService;
import com.kxm.kcgl.service.TechService;
import com.kxm.kcgl.service.ThicknessService;

@Component
@Scope("view")
public class QueryTimesView implements Serializable {

	private static final long serialVersionUID = 1L;
	private Product condition = new Product();
	private PaginationDataModel<Product> productDataModel;

	@Autowired
	private BrandService brandService;
	private List<BrandBean> brandList;

	@Autowired
	private TechService techService;
	private List<TechBean> techList;

	@Autowired
	private ThicknessService thicknessService;
	private List<ThicknessBean> thicknessList;

	@PostConstruct
	public void init() {
		initQuery();
		initBrandList();
		initTechList();
		initThicknessList();
	}

	public void initBrandList() {
		brandList = brandService.queryAllBrand();
	}

	public void initTechList() {
		techList = techService.queryAllTech();
	}
	
	public void initThicknessList() {
		thicknessList = thicknessService.queryAllThickness();
	}
	
	public void initQuery() {
		productDataModel = new PaginationDataModel<Product>("com.kxm.kcgl.mapper.ProductMapper.selectSelective", condition);
	}

	public PaginationDataModel<Product> getProductDataModel() {
		return productDataModel;
	}

	public void setProductDataModel(PaginationDataModel<Product> productDataModel) {
		this.productDataModel = productDataModel;
	}

	public Product getCondition() {
		return condition;
	}

	public void setCondition(Product condition) {
		this.condition = condition;
	}

	public List<BrandBean> getBrandList() {
		return brandList;
	}

	public void setBrandList(List<BrandBean> brandList) {
		this.brandList = brandList;
	}

	public List<TechBean> getTechList() {
		return techList;
	}

	public void setTechList(List<TechBean> techList) {
		this.techList = techList;
	}

	public List<ThicknessBean> getThicknessList() {
		return thicknessList;
	}

	public void setThicknessList(List<ThicknessBean> thicknessList) {
		this.thicknessList = thicknessList;
	}

}