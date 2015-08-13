package com.kxm.kcgl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyjd.frame.psm.utils.MsgTool;
import com.kxm.kcgl.LogicException;
import com.kxm.kcgl.domain.Product;
import com.kxm.kcgl.domain.ProductIn;
import com.kxm.kcgl.mapper.ProductInMapper;
import com.kxm.kcgl.mapper.ProductMapper;

/**
 *
 * @author kongxm
 * @date 2015 2015年7月26日 下午2:25:19
 */
@Service
public class ProductInService {

	@Autowired
	private ProductInMapper productInMapper;

	@Autowired
	private ProductMapper productMapper;

	@Transactional(rollbackFor = Exception.class)
	public void addNotExist(ProductIn record) throws LogicException {
		// 判断是否未添加过,产品编号不能重复
		Product p1 = new Product();
		p1.setProductNo(record.getProductNo());
		List<Product> p1_list = productMapper.selectSelective(p1);
		if (p1_list.size() > 0) {
			throw new LogicException("产品编号已存在");
		}
		// 产品名称(型号不能重复)
		Product p2 = new Product();
		p2.setProductName(record.getProductName());
		List<Product> p2_list = productMapper.selectSelective(p2);
		if (p2_list.size() > 0) {
			throw new LogicException("产品名称已存在");
		}
		// 插入产品
		Product product = new Product();
		product.setProductNo(record.getProductNo());
		product.setProductName(record.getProductName());
		product.setBrandId(record.getBrandId());
		product.setTechId(record.getTechId());
		product.setThicknessId(record.getThicknessId());
		product.setManufactorId(record.getManufactorId());
		product.setIdentifyId(record.getIdentifyId());
		product.setQuantityId(record.getQuantityId());
		product.setPrice(record.getPrice());
		product.setCreateUserId(record.getCreateUserId());
		product.setAmount(record.getAmount());
		product.setPrice(record.getPrice());
		productMapper.insert(product);
		// 插入库存
		record.setProductId(product.getId());
		productInMapper.insert(record);
	}

	@Transactional(rollbackFor = Exception.class)
	public void addExist(List<ProductIn> productInList, int userId) throws LogicException {
		for (ProductIn productIn : productInList) {
			//参数检查
			checkParam(productIn);
			// init param
			Product product = new Product();
			product.setId(productIn.getProductId());
			product.setAmount(productIn.getAmount());
			product.setPrice(productIn.getPrice());//入库可以调价
			// 判断库存是否存在
			int size = productMapper.countBySelective(product);
			if (size > 0) {
				// 更新产品库存数
				productMapper.update(product);
			} else {
				throw new LogicException("该产品不存在");
			}
			// 插入入库日志
			productIn.setCreateUserId(userId);
			productInMapper.insert(productIn);
		}
	}
	
	public void checkParam(ProductIn productIn) throws LogicException{
		if(productIn.getPrice() <= 0){
			throw new LogicException("产品" + productIn.getProductNo() + "-价格请填写大0的数字");
		}
		//参数检查
		if(productIn.getAmount() == null || productIn.getAmount() <= 0){
			throw new LogicException("产品" + productIn.getProductNo() + "-数量请输入大于0的整数");
		}
		if(productIn.getInTypeId() == null){
			throw new LogicException("产品" + productIn.getProductNo() + "-请填写入库类型");
		}
	}
}
