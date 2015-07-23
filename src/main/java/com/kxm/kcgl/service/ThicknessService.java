package com.kxm.kcgl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.kxm.kcgl.dao.BrandDao;
import com.kxm.kcgl.dao.ThicknessDao;
import com.kxm.kcgl.domain.BrandBean;
import com.kxm.kcgl.domain.ThicknessBean;

@Service
public class ThicknessService {
	@Autowired
	private ThicknessDao thicknessDao;
	@Transactional
	public String addNewThickness(String name) {
		if (StringUtils.isEmpty(name)) {
			return "厚度不能为空";
		}
		int count = thicknessDao.count(name);
		if (count > 0) {
			thicknessDao.update(name);;
		}

		ThicknessBean param = new ThicknessBean();
		param.setName(name.trim());
		// TODO:where is user?
		param.setCreate_user(11);
		int size = thicknessDao.insert(param);
		return size > 0 ? "厚度" + name + "添加成功" : "厚度" + name + "添加失败";
	}

	public List<ThicknessBean> queryAllThickness() {
		return thicknessDao.query();
	}

	public void deleteThickness(int id) {
		thicknessDao.delete(id);
	}
}
