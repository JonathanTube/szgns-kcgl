package com.kxm.kcgl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.kxm.kcgl.dao.ProductDao;
import com.kxm.kcgl.domain.ProductBean;

@Service
public class ProductService {
	@Autowired
	private ProductDao productDao;

	public String addNewProduct(String name, String brandId) {
		if (StringUtils.isEmpty(name)) {
			return "产品不能为空";
		}
		if (StringUtils.isEmpty(brandId)) {
			return "品牌不能为空";
		}
		int count = productDao.count(name);
		if (count > 0) {
			productDao.update(name);
			return "产品" + name + "添加成功";
		}

		ProductBean param = new ProductBean();
		param.setName(name.trim());
		param.setBrandId(Integer.parseInt(brandId));
		// TODO:where is user?
		param.setCreate_user(0);
		int size = productDao.insert(param);
		return size > 0 ? "产品" + name + "添加成功" : "产品" + name + "添加失败";
	}

	public List<ProductBean> queryAllProduct(String brandId) {
		if(StringUtils.isEmpty(brandId)){
			return productDao.query();	
		}else{
			return productDao.query(Integer.parseInt(brandId));
		}
		
	}

	public void deleteProduct(int id) {
		productDao.delete(id);
	}

}
