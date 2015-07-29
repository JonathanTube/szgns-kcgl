package com.kxm.kcgl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kxm.kcgl.domain.ProductOut;
import com.kxm.kcgl.domain.Stock;
import com.kxm.kcgl.mapper.ProductOutMapper;
import com.kxm.kcgl.mapper.StockMapper;

/**
 *
 * @author kongxm
 * @date 2015 2015年7月27日 下午4:27:43
 */
@Service
public class ProductOutService {
	@Autowired
	private ProductOutMapper productOutMapper;

	@Autowired
	private StockMapper stockMapper;

	public void insert(ProductOut productOut) {
		productOutMapper.insert(productOut);
	}

	public void productOut(List<ProductOut> productOutList) {
		for (ProductOut productOut : productOutList) {
			// 记录出货日志
			productOutMapper.insert(productOut);
			// 减去库存数量
			// TODO:需要查找一下防止库存不足
			Stock stock = new Stock();
			stock.setProductId(productOut.getProductId());
			stock.setIdentifyType(productOut.getIdentifyType());
			stock.setIdentifyId(productOut.getIdentifyId());
			stock.setManufactorId(productOut.getManufactorId());
			stock.setAmount(productOut.getAmount() * -1);
			stockMapper.update(stock);
		}
	}

}
