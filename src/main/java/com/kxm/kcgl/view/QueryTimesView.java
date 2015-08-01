package com.kxm.kcgl.view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.hyjd.frame.psm.datamodel.PaginationDataModel;
import com.kxm.kcgl.domain.BrandBean;
import com.kxm.kcgl.domain.Stock;
import com.kxm.kcgl.domain.TechBean;
import com.kxm.kcgl.domain.ThicknessBean;
import com.kxm.kcgl.service.BrandService;
import com.kxm.kcgl.service.TechService;
import com.kxm.kcgl.service.ThicknessService;

@Component
@Scope("view")
public class QueryTimesView implements Serializable {

	private static final long serialVersionUID = 1L;
	private Stock condition = new Stock();
	private PaginationDataModel<Stock> stockDataModel;

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
		stockDataModel = new PaginationDataModel<Stock>(
				"com.kxm.kcgl.mapper.StockMapper.selectSelective", condition);
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

	public PaginationDataModel<Stock> getStockDataModel() {
		return stockDataModel;
	}

	public void setStockDataModel(PaginationDataModel<Stock> stockDataModel) {
		this.stockDataModel = stockDataModel;
	}

	public Stock getCondition() {
		return condition;
	}

	public void setCondition(Stock condition) {
		this.condition = condition;
	}

}