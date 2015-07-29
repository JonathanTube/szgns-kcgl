package com.kxm.kcgl.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.kxm.kcgl.domain.Stock;
import com.kxm.kcgl.service.StockService;

@Component
@Scope("view")
public class StockView implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Stock> stockList = new ArrayList<Stock>();

	@Autowired
	private StockService stockService;
	
	private Stock condition = new Stock();

	@PostConstruct
	public void init() {
		queryStock();
	}

	public void queryStock() {
		stockList = stockService.selectSelective(condition);
	}

	public Stock getCondition() {
		return condition;
	}

	public void setCondition(Stock condition) {
		this.condition = condition;
	}

	public List<Stock> getStockList() {
		return stockList;
	}

	public void setStockList(List<Stock> stockList) {
		this.stockList = stockList;
	}
}