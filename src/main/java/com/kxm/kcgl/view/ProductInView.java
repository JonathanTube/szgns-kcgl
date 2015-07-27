package com.kxm.kcgl.view;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.hyjd.frame.psm.datamodel.PaginationDataModel;
import com.hyjd.frame.psm.utils.MsgTool;
import com.kxm.kcgl.domain.BrandBean;
import com.kxm.kcgl.domain.Identify;
import com.kxm.kcgl.domain.Manufactor;
import com.kxm.kcgl.domain.Product;
import com.kxm.kcgl.domain.ProductIn;
import com.kxm.kcgl.domain.TechBean;
import com.kxm.kcgl.domain.ThicknessBean;
import com.kxm.kcgl.service.BrandService;
import com.kxm.kcgl.service.IdentifyService;
import com.kxm.kcgl.service.ManufactorService;
import com.kxm.kcgl.service.ProductInService;
import com.kxm.kcgl.service.ProductService;
import com.kxm.kcgl.service.TechService;
import com.kxm.kcgl.service.ThicknessService;

@Component
@Scope("view")
public class ProductInView implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private ProductInService productInService;

	private ProductIn condition = new ProductIn();

	/**
	 * 采集bean
	 */
	private ProductIn productIn = new ProductIn();

	private PaginationDataModel<ProductIn> productInModel;

	@Autowired
	private BrandService brandService;
	private List<BrandBean> brandList;
	private String brandName;

	@Autowired
	private TechService techService;
	private List<TechBean> techList;
	private String techName;

	@Autowired
	private ThicknessService thicknessService;
	private List<ThicknessBean> thicknessList;
	private String thicknessName;

	@Autowired
	private ManufactorService manufactorService;
	private List<Manufactor> manufactorList;
	private String manufactorName;

	@Autowired
	private IdentifyService identifyService;
	private List<Identify> identifyList;
	private String identifyName;

	@Autowired
	private ProductService productService;
	private List<Product> productList;
	
	private List<ProductIn> productInList = new LinkedList<ProductIn>();
	
	private int productId;
	private String productNo;

	@PostConstruct
	public void init() {
		query();
		initBrandList();
		initTechList();
		initThicknessList();
		initManufactorList();
		initIdentifyList();

		initProductList();
	}

	public void initProductList(){
		productList = productService.queryAll();
	}
	
	
	public void query() {
		productInModel = new PaginationDataModel<ProductIn>("com.kxm.kcgl.mapper.ProductInMapper.selectSelective", condition);
	}

	public void addNotExist() {
		productInService.addNotExist(productIn);
	}
	
	public void addExist(){
		
	}

	public void initBrandList() {
		brandList = brandService.queryAllBrand();
	}

	public void addBrand() {
		String msg = brandService.addNewBrand(brandName);
		MsgTool.addInfoMsg(msg);
		initBrandList();
	}

	public void initTechList() {
		techList = techService.queryAllTech();
	}

	public void addTech() {
		String msg = techService.addNewTech(techName);
		MsgTool.addInfoMsg(msg);
		initTechList();
	}

	public void initIdentifyList() {
		identifyList = identifyService.queryAll();
	}

	public void addIdentify() {
		String msg = identifyService.addNew(identifyName);
		MsgTool.addInfoMsg(msg);
		initIdentifyList();
	}

	public void initManufactorList() {
		manufactorList = manufactorService.queryAll();
	}

	public void addManufactor() {
		String msg = manufactorService.addNew(manufactorName);
		MsgTool.addInfoMsg(msg);
		initManufactorList();
	}

	public void initThicknessList() {
		thicknessList = thicknessService.queryAllThickness();
	}

	public void addThickness() {
		String msg = thicknessService.addNewThickness(thicknessName);
		MsgTool.addInfoMsg(msg);
		initThicknessList();
	}

	public void addExistProduct(ActionEvent event){
		String id = event.getComponent().getId();
		Product	product = null;
		if("btn_productId".equals(id)){
			product = productService.queryByProductId(productId);	
		}else{
			product = productService.queryByProductNo(productNo);
		}
		
		if(product == null){
			MsgTool.addErrorMsg("未找到该型号的产品");
			return;
		}
		productIn = new ProductIn();
		productIn.setBrandId(product.getBrandId());
		productIn.setBrandName(product.getBrandName());
		productIn.setProductId(product.getId());
		productIn.setProductName(product.getProductName());
		productIn.setTechId(product.getTechId());
		productIn.setTechName(product.getTechName());
		productIn.setProductNo(product.getProductNo());
		productIn.setThicknessId(product.getThicknessId());
		productIn.setThicknessName(product.getThicknessName());
		productInList.add(productIn);
	}
	
	public PaginationDataModel<ProductIn> getProductInModel() {
		return productInModel;
	}

	public void setProductInModel(PaginationDataModel<ProductIn> productInModel) {
		this.productInModel = productInModel;
	}

	public ProductIn getCondition() {
		return condition;
	}

	public void setCondition(ProductIn condition) {
		this.condition = condition;
	}

	public ProductIn getProductIn() {
		return productIn;
	}

	public void setProductIn(ProductIn productIn) {
		this.productIn = productIn;
	}

	public List<BrandBean> getBrandList() {
		return brandList;
	}

	public void setBrandList(List<BrandBean> brandList) {
		this.brandList = brandList;
	}

	public List<TechBean> getTechList() {
		return techList;
	}

	public void setTechList(List<TechBean> techList) {
		this.techList = techList;
	}

	public List<ThicknessBean> getThicknessList() {
		return thicknessList;
	}

	public void setThicknessList(List<ThicknessBean> thicknessList) {
		this.thicknessList = thicknessList;
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

	public String getThicknessName() {
		return thicknessName;
	}

	public void setThicknessName(String thicknessName) {
		this.thicknessName = thicknessName;
	}

	public List<Manufactor> getManufactorList() {
		return manufactorList;
	}

	public List<Identify> getIdentifyList() {
		return identifyList;
	}

	public void setManufactorList(List<Manufactor> manufactorList) {
		this.manufactorList = manufactorList;
	}

	public void setIdentifyList(List<Identify> identifyList) {
		this.identifyList = identifyList;
	}

	public String getManufactorName() {
		return manufactorName;
	}

	public String getIdentifyName() {
		return identifyName;
	}

	public void setManufactorName(String manufactorName) {
		this.manufactorName = manufactorName;
	}

	public void setIdentifyName(String identifyName) {
		this.identifyName = identifyName;
	}

	public List<ProductIn> getProductInList() {
		return productInList;
	}

	public void setProductInList(List<ProductIn> productInList) {
		this.productInList = productInList;
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductNo() {
		return productNo;
	}

	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}
}