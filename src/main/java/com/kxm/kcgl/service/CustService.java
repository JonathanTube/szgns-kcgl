package com.kxm.kcgl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.kxm.kcgl.dao.CustDao;
import com.kxm.kcgl.domain.CustBean;

@Service
public class CustService {
	@Autowired
	private CustDao custDao;
	@Transactional
	public String addNewCust(String name) {
		if (StringUtils.isEmpty(name)) {
			return "客户名称不能为空";
		}
		int count = custDao.count(name);
		if (count > 0) {
			custDao.update(name);
		}

		CustBean param = new CustBean();
		param.setName(name.trim());
		// TODO:where is user?
		param.setCreate_user(11);
		int size = custDao.insert(param);
		return size > 0 ? "客户名称" + name + "添加成功" : "客户名称" + name + "添加失败";
	}

	public List<CustBean> queryAllCust() {
		return custDao.query();
	}

	public void deleteCust(int id) {
		custDao.delete(id);
	}
}
