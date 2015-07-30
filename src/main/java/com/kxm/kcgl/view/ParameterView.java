package com.kxm.kcgl.view;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.hyjd.frame.psm.base.LoginSession;
import com.hyjd.frame.psm.utils.MsgTool;
import com.kxm.kcgl.LogicException;
import com.kxm.kcgl.domain.BrandBean;
import com.kxm.kcgl.domain.Cust;
import com.kxm.kcgl.domain.Identify;
import com.kxm.kcgl.domain.InType;
import com.kxm.kcgl.domain.Manufactor;
import com.kxm.kcgl.domain.Product;
import com.kxm.kcgl.domain.TechBean;
import com.kxm.kcgl.domain.ThicknessBean;
import com.kxm.kcgl.domain.User;
import com.kxm.kcgl.service.BrandService;
import com.kxm.kcgl.service.CustService;
import com.kxm.kcgl.service.IdentifyService;
import com.kxm.kcgl.service.InTypeService;
import com.kxm.kcgl.service.ManufactorService;
import com.kxm.kcgl.service.ProductService;
import com.kxm.kcgl.service.TechService;
import com.kxm.kcgl.service.ThicknessService;
import com.kxm.kcgl.service.UserService;

@Component
@Scope("view")
public class ParameterView implements Serializable {
	private static final long serialVersionUID = -3617720788091260172L;
	@Autowired
	private LoginSession loginSession;

	@Autowired
	private BrandService brandService;

	@Autowired
	private TechService techService;

	@Autowired
	private ThicknessService thicknessService;

	@Autowired
	private ManufactorService manufactorService;

	@Autowired
	private IdentifyService identifyService;

	@Autowired
	private CustService custService;

	@Autowired
	private UserService userService;

	@Autowired
	private ProductService productService;

	@Autowired
	private InTypeService inTypeService;

	public List<BrandBean> getBrandList() {
		return brandService.queryAllBrand();
	}

	public List<TechBean> getTechList() {
		return techService.queryAllTech();
	}

	public List<ThicknessBean> getThicknessList() {
		return thicknessService.queryAllThickness();
	}

	public List<Manufactor> getManufactorList() {
		return manufactorService.queryAll();
	}

	public List<Cust> getCustList() {
		return custService.selectSelective(new Cust());
	}

	public List<Cust> getOwnerCustList() {
		Cust cust = new Cust();
		User user = (User) loginSession.getSesionObj();
		cust.setUserId(user.getId());
		// 只查询自己的客户
		return custService.selectSelective(cust);
	}

	public List<User> getUserList() {
		return userService.queryAll();
	}

	public List<Identify> getIdentifyList() {
		return identifyService.queryAll();
	}

	public List<Product> getProductList() {
		return productService.queryAll();
	}

	public List<InType> getInTypeList() {
		return inTypeService.queryAll();
	}

	public void addBrand(String brandName) {
		String msg = brandService.addNewBrand(brandName);
		MsgTool.addInfoMsg(msg);
	}

	public void addIdentify(String identifyName) {
		String msg = identifyService.addNew(identifyName);
		MsgTool.addInfoMsg(msg);
	}

	public void addTech(String techName) {
		String msg = techService.addNewTech(techName);
		MsgTool.addInfoMsg(msg);
	}

	public void addInType(String inTypeName) {
		String msg = inTypeService.addNew(inTypeName);
		MsgTool.addInfoMsg(msg);
	}

	public void addManufactor(String manufactorName) {
		String msg = manufactorService.addNew(manufactorName);
		MsgTool.addInfoMsg(msg);
	}

	public void addThickness(String thicknessName) {
		String msg = thicknessService.addNewThickness(thicknessName);
		MsgTool.addInfoMsg(msg);
	}

	public void addCust(String custName) {
		String msg;
		try {
			User user = (User) loginSession.getSesionObj();
			msg = custService.addNew(custName, user.getId());
			MsgTool.addInfoMsg(msg);
		} catch (LogicException e) {
			MsgTool.addInfoMsg(e.getMessage());
		}
	}

}