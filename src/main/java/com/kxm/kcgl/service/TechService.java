package com.kxm.kcgl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.kxm.kcgl.dao.BrandDao;
import com.kxm.kcgl.dao.TechDao;
import com.kxm.kcgl.domain.BrandBean;
import com.kxm.kcgl.domain.TechBean;

@Service
public class TechService {
	@Autowired
	private TechDao techDao;
	@Transactional
	public String addNewTech(String name) {
		if (StringUtils.isEmpty(name)) {
			return "工艺不能为空";
		}
		int count = techDao.count(name);
		if (count > 0) {
			techDao.update(name);
		}

		TechBean param = new TechBean();
		param.setName(name.trim());
		// TODO:where is user?
		param.setCreate_user(11);
		int size = techDao.insert(param);
		return size > 0 ? "工艺" + name + "添加成功" : "工艺" + name + "添加失败";
	}

	public List<TechBean> queryAllTech() {
		return techDao.query();
	}

	public void deleteTech(int id) {
		techDao.delete(id);
	}
}
