package com.kxm.kcgl.view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.hyjd.frame.psm.base.LoginSession;
import com.hyjd.frame.psm.utils.MsgTool;
import com.kxm.kcgl.LogicException;
import com.kxm.kcgl.domain.Brand;
import com.kxm.kcgl.domain.Cust;
import com.kxm.kcgl.domain.Identify;
import com.kxm.kcgl.domain.InType;
import com.kxm.kcgl.domain.Manufactor;
import com.kxm.kcgl.domain.Product;
import com.kxm.kcgl.domain.Quantity;
import com.kxm.kcgl.domain.Tech;
import com.kxm.kcgl.domain.Thickness;
import com.kxm.kcgl.domain.User;
import com.kxm.kcgl.service.BrandService;
import com.kxm.kcgl.service.CustService;
import com.kxm.kcgl.service.IdentifyService;
import com.kxm.kcgl.service.InTypeService;
import com.kxm.kcgl.service.ManufactorService;
import com.kxm.kcgl.service.ProductService;
import com.kxm.kcgl.service.QuantityService;
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

	@Autowired
	private QuantityService quantityService;

	private String thicknessName;
	private String manufactorName;
	private String inTypeName;
	private String brandName;
	private String techName;
	private String identifyName;
	private String custName;
	private String quantityName;

	private List<Brand> brandList;
	private List<Tech> techList;
	private List<Thickness> thicknessList;
	private List<Manufactor> manufactorList;
	private List<Quantity> quantityList;
	private List<Cust> custList;
	private List<Identify> identifyList;
	private List<User> userList;
	private List<Product> productList;
	private List<InType> inTypeList;

	@PostConstruct
	public void init() {
		initBrandList();
		initTechList();
		initThicknessList();
		initManufactorList();
		initQuantityList();
		initIdentifyList();
		initProductList();
		initInTypeList();
		initUserList();
	}

	public void initBrandList() {
		brandList = brandService.selectSelective(new Brand());
	}

	public void initTechList() {
		techList = techService.selectSelective(new Tech());
	}

	public void initThicknessList() {
		thicknessList = thicknessService.selectSelective(new Thickness());
	}

	public void initManufactorList() {
		manufactorList = manufactorService.selectSelective(new Manufactor());
	}

	public void initQuantityList() {
		quantityList = quantityService.selectSelective(new Quantity());
	}

	public void initIdentifyList() {
		identifyList = identifyService.selectSelective(new Identify());
	}

	public void initUserList() {
		User u = new User();
		u.setStatus(0);
		userList = userService.selectSelective(u);
	}

	public void initCustList() {
		custList = custService.selectSelective(new Cust());
	}

	public void initProductList() {
		Product condition = new Product();
		User user = (User) loginSession.getSesionObj();
		condition.setManufactorId(user.getManufactorId());
		productList = productService.selectSelective(condition);
	}

	public void initInTypeList() {
		inTypeList = inTypeService.selectSelective(new InType());
	}

	public List<Brand> getBrandList() {
		return this.brandList;
	}

	public List<Tech> getTechList() {
		return this.techList;
	}

	public List<Thickness> getThicknessList() {
		return this.thicknessList;
	}

	public List<Manufactor> getManufactorList() {
		return this.manufactorList;
	}

	public List<Quantity> getQuantityList() {
		return this.quantityList;
	}

	public List<Cust> getCustList() {
		return this.custList;
	}

	public List<Cust> getOwnerCustList() {
		Cust cust = new Cust();
		User user = (User) loginSession.getSesionObj();
		cust.setUserId(user.getId());
		// 只查询自己的客户
		return custService.selectSelective(cust);
	}

	public List<User> getUserList() {
		return this.userList;
	}

	public List<Identify> getIdentifyList() {
		return this.identifyList;
	}

	public List<Product> getProductList() {
		return this.productList;
	}

	public List<InType> getInTypeList() {
		return this.inTypeList;
	}

	public void addBrand() {
		try {
			String msg = brandService.add(brandName);
			MsgTool.addInfoMsg(msg);
			initBrandList();
		} catch (LogicException e) {
			MsgTool.addErrorMsg(e.getMessage());
		}
	}

	public void addIdentify() {
		try {
			String msg = identifyService.add(identifyName);
			MsgTool.addInfoMsg(msg);
			initIdentifyList();
		} catch (LogicException e) {
			MsgTool.addErrorMsg(e.getMessage());
		}
	}

	public void addTech() {
		try {
			String msg = techService.add(techName);
			MsgTool.addInfoMsg(msg);
			initTechList();
		} catch (LogicException e) {
			MsgTool.addErrorMsg(e.getMessage());
		}
	}

	public void addInType() {
		try {
			String msg = inTypeService.add(inTypeName);
			MsgTool.addInfoMsg(msg);
			initInTypeList();
		} catch (LogicException e) {
			MsgTool.addErrorMsg(e.getMessage());
		}
	}

	public void addManufactor() {
		try {
			String msg = manufactorService.add(manufactorName);
			MsgTool.addInfoMsg(msg);
			initManufactorList();
		} catch (LogicException e) {
			MsgTool.addErrorMsg(e.getMessage());
		}
	}

	public void addQuantity() {
		try {
			String msg = quantityService.add(quantityName);
			MsgTool.addInfoMsg(msg);
			initQuantityList();
		} catch (LogicException e) {
			MsgTool.addErrorMsg(e.getMessage());
		}

	}

	public void addThickness() {
		try {
			String msg = thicknessService.add(thicknessName);
			MsgTool.addInfoMsg(msg);
			initThicknessList();
		} catch (LogicException e) {
			MsgTool.addErrorMsg(e.getMessage());
		}
	}

	public void addCust() {
		String msg;
		try {
			User user = (User) loginSession.getSesionObj();
			msg = custService.addNew(custName, user.getId());
			MsgTool.addInfoMsg(msg);
			initCustList();
		} catch (LogicException e) {
			MsgTool.addErrorMsg(e.getMessage());
		}
	}
	
	public String getManufactorNameById(Integer id){
		for (Manufactor manufactor : manufactorList) {
			if(manufactor.getId() == id){
				return manufactor.getName();
			}
		}
		return "";
	}
	
	public String getInTypeNameById(Integer id){
		for (InType inType : inTypeList) {
			if(inType.getId() == id){
				return inType.getName();
			}
		}
		return "";
	}
	
	public String getQuantityNameById(Integer id){
		for (Quantity quantity : quantityList) {
			if(quantity.getId() == id){
				return quantity.getName();
			}
		}
		return "";
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getThicknessName() {
		return thicknessName;
	}

	public void setThicknessName(String thicknessName) {
		this.thicknessName = thicknessName;
	}

	public String getManufactorName() {
		return manufactorName;
	}

	public void setManufactorName(String manufactorName) {
		this.manufactorName = manufactorName;
	}

	public String getInTypeName() {
		return inTypeName;
	}

	public void setInTypeName(String inTypeName) {
		this.inTypeName = inTypeName;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getTechName() {
		return techName;
	}

	public void setTechName(String techName) {
		this.techName = techName;
	}

	public String getIdentifyName() {
		return identifyName;
	}

	public void setIdentifyName(String identifyName) {
		this.identifyName = identifyName;
	}

	public String getQuantityName() {
		return quantityName;
	}

	public void setQuantityName(String quantityName) {
		this.quantityName = quantityName;
	}

}