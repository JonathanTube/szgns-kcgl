package com.kxm.kcgl.view;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.lang.StringUtils;
import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.hyjd.frame.psm.base.LoginSession;
import com.hyjd.frame.psm.datamodel.PaginationDataModel;
import com.hyjd.frame.psm.utils.MsgTool;
import com.kxm.kcgl.LogicException;
import com.kxm.kcgl.domain.Product;
import com.kxm.kcgl.domain.ProductIn;
import com.kxm.kcgl.domain.User;
import com.kxm.kcgl.service.ProductInService;
import com.kxm.kcgl.service.ProductService;

@Component
@Scope("view")
public class ProductInView implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private LoginSession loginSession;
	@Autowired
	private ProductInService productInService;

	private ProductIn condition = new ProductIn();

	/**
	 * 采集bean
	 */
	private ProductIn productIn = new ProductIn();

	private PaginationDataModel<ProductIn> productInModel;

	@Autowired
	private ProductService productService;

	private List<ProductIn> productInList = new LinkedList<ProductIn>();

	private String keywords;

	@PostConstruct
	public void init() {
		query();
	}

	public void query() {
		productInModel = new PaginationDataModel<ProductIn>("com.kxm.kcgl.mapper.ProductInMapper.selectSelective", condition);
	}

	public void addNotExist() {
		try {
			User user = (User) loginSession.getSesionObj();
			productIn.setCreateUserId(user.getId());
			productInService.addNotExist(productIn);
			MsgTool.addInfoMsg("入库成功");
			RequestContext.getCurrentInstance().execute("PF('product_in_not_exist_dlg').hide()");
		} catch (LogicException e) {
			MsgTool.addWarningMsg(e.getMessage());
		}
	}

	/**
	 * 已有产品入库
	 */
	public void addExist() {
		User user = (User) loginSession.getSesionObj();
		if (productInList.size() == 0) {
			MsgTool.addWarningMsg("请选择需要入库的产品");
			return;
		}
		try {
			productInService.addExist(productInList, user.getId());
		} catch (LogicException e) {
			MsgTool.addInfoMsg(e.getMessage());
			return;
		}
		productInList.clear();
		MsgTool.addInfoMsg("入库成功");
	}

	/**
	 * 已有产品入库
	 * 
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	public void addExistTemp() throws IllegalAccessException, InvocationTargetException {
		//参数检查
		try {
			productInService.checkParam(productIn);
		} catch (LogicException e) {
			MsgTool.addWarningMsg(e.getMessage());
			return;
		}
		
		// 如果已经存在就移除，兼容更新操作
		if(productInList.contains(productIn)){
			productInList.remove(productIn);
		}

		productInList.add(productIn);
		RequestContext.getCurrentInstance().execute("PF('edit_exist_dlg').hide()");
	}

	public void editExistTemp(ProductIn productIn) {
		this.productIn = productIn;
		RequestContext.getCurrentInstance().execute("PF('edit_exist_dlg').show()");
	}

	public void delExistTemp(ProductIn productIn) {
		productInList.remove(productIn);
	}

	public void addExistProducts() {
		if (StringUtils.isEmpty(keywords)) {
			MsgTool.addErrorMsg("请填写产品编号或产品名称");
			return;
		}
		Product condition = new Product();
		condition.setProductName(keywords);
		List<Product> products = productService.search(condition);
		if (products.size() == 0) {
			MsgTool.addErrorMsg("未找到该型号的产品");
			return;
		}
		for (Product selectedProduct : products) {
			productIn = new ProductIn();
			productIn.setBrandId(selectedProduct.getBrandId());
			productIn.setBrandName(selectedProduct.getBrandName());
			productIn.setProductId(selectedProduct.getId());
			productIn.setProductName(selectedProduct.getProductName());
			productIn.setTechId(selectedProduct.getTechId());
			productIn.setTechName(selectedProduct.getTechName());
			productIn.setProductNo(selectedProduct.getProductNo());
			productIn.setThicknessId(selectedProduct.getThicknessId());
			productIn.setThicknessName(selectedProduct.getThicknessName());
			productIn.setManufactorId(selectedProduct.getManufactorId());
			productIn.setManufactorName(selectedProduct.getManufactorName());
			productIn.setQuantityId(selectedProduct.getQuantityId());
			productIn.setQuantityName(selectedProduct.getQuantityName());
			productIn.setIdentifyId(selectedProduct.getIdentifyId());
			productIn.setIdentifyName(selectedProduct.getIdentifyName());
			productIn.setPrice(selectedProduct.getPrice());
			// 没有才添加进去
			if(!productInList.contains(productIn)){
				productInList.add(productIn);
			}else{
				MsgTool.addWarningMsg(productIn.getProductName() + "已存在,请勿重复添加");
			}
		}
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

	public List<ProductIn> getProductInList() {
		return productInList;
	}

	public void setProductInList(List<ProductIn> productInList) {
		this.productInList = productInList;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
}