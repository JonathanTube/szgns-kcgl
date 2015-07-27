package com.kxm.kcgl.view;

/**
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 */
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.hyjd.frame.psm.datamodel.PaginationDataModel;
import com.hyjd.frame.psm.utils.MsgTool;
import com.kxm.kcgl.domain.Stock;
import com.kxm.kcgl.domain.User;
import com.kxm.kcgl.service.StockService;
import com.kxm.kcgl.service.UserService;

@Component
@Scope("view")
public class StockView implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private StockService stockService;

	private Stock condition = new Stock();
	
	private PaginationDataModel<Stock> stockDataModel;

	@PostConstruct
	public void init() {
		queryStock();
	}

	public void queryStock(){
		stockDataModel = new PaginationDataModel<Stock>("com.kxm.kcgl.mapper.StockMapper.selectSelective",condition);
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