package com.kxm.kcgl.view;

import java.io.Serializable;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.hyjd.frame.psm.datamodel.PaginationDataModel;
import com.kxm.kcgl.domain.Stock;

@Component
@Scope("view")
public class QueryTimesView implements Serializable {

	private static final long serialVersionUID = 1L;
	private Stock condition = new Stock();
	private PaginationDataModel<Stock> stockDataModel;

	@PostConstruct
	public void init() {
		initQuery();
	}

	public void initQuery() {
		stockDataModel = new PaginationDataModel<Stock>(
				"com.kxm.kcgl.mapper.StockMapper.selectSelective", condition);
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