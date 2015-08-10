package com.kxm.kcgl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kxm.kcgl.LogicException;
import com.kxm.kcgl.domain.PreProductOut;
import com.kxm.kcgl.domain.Stock;
import com.kxm.kcgl.mapper.PreProductOutMapper;

/**
 *
 * @author kongxm
 * @date 2015 2015年7月27日 下午4:27:43
 */
@Service
public class PreProductOutService {

	@Autowired
	private PreProductOutMapper preProductOutMapper;

	public boolean insert(Stock stock,PreProductOut preProductOut) throws LogicException {
		if (stock.getAmount() < preProductOut.getPreAmount()) {
			throw new LogicException("库存不足");
		}
		if (stock.getPrice() < preProductOut.getPrePrice()) {
			throw new LogicException("销售价格不能高于出厂价");
		}
		preProductOut.setStockId(stock.getId());
		int size = preProductOutMapper.insert(preProductOut);
		if (size > 0) {
			return true;
		} else {
			throw new LogicException("预出货失败");
		}
	}
}
