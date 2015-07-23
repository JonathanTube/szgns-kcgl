package com.kxm.kcgl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.kxm.kcgl.dao.BrandDao;
import com.kxm.kcgl.domain.BrandBean;

@Service
public class BrandService {
	@Autowired
	private BrandDao brandDao;
	@Transactional
	public String addNewBrand(String name) {
		if (StringUtils.isEmpty(name)) {
			return "品牌不能为空";
		}
		int count = brandDao.count(name);
		if (count > 0) {
			brandDao.update(name);
		}

		BrandBean param = new BrandBean();
		param.setName(name.trim());
		// TODO:where is user?
		param.setCreate_user(11);
		int size = brandDao.insert(param);
		return size > 0 ? "品牌" + name + "添加成功" : "品牌" + name + "添加失败";
	}

	public List<BrandBean> queryAllBrand() {
		return brandDao.query();
	}

	public void deleteBrand(int id) {
		brandDao.delete(id);
	}
}
