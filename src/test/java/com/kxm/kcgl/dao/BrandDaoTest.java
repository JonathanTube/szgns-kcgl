package com.kxm.kcgl.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kxm.kcgl.domain.BrandBean;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class BrandDaoTest {

	@Autowired
	private BrandDao brandDao;

	@Test
	public void testInsert() {
		
	}

	@Test
	public void testDelete() {
	}

	@Test
	public void testUpdate() {
	}

	@Test
	public void testQuery() {
		try {
			List<BrandBean> list = brandDao.query();
			System.out.println(list.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
