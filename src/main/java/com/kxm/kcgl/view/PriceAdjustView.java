package com.kxm.kcgl.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.hyjd.frame.psm.base.LoginSession;
import com.hyjd.frame.psm.datamodel.PaginationDataModel;
import com.hyjd.frame.psm.utils.MsgTool;
import com.kxm.kcgl.LogicException;
import com.kxm.kcgl.domain.PriceAdjust;
import com.kxm.kcgl.domain.Product;
import com.kxm.kcgl.domain.User;
import com.kxm.kcgl.mapper.ProductMapper;
import com.kxm.kcgl.service.PriceAdjustService;

@Component
@Scope("view")
public class PriceAdjustView implements Serializable {

	private static final long serialVersionUID = 1L;

	private PaginationDataModel<PriceAdjust> priceAdjustModel;

	private PriceAdjust condition = new PriceAdjust();

	private List<PriceAdjust> tempList = new ArrayList<PriceAdjust>();

	@Autowired
	private LoginSession loginSession;

	@Autowired
	private PriceAdjustService priceAdjustService;

	@Autowired
	private ProductMapper productMapper;

	private String keywords;
	@PostConstruct
	public void init() {
		initPriceAdjust();
	}

	public void initPriceAdjust() {
		priceAdjustModel = new PaginationDataModel<PriceAdjust>("com.kxm.kcgl.mapper.PriceAdjustMapper.selectSelective", condition);
	}

	public void addByProductNoOrName() {
		Product condition = new Product();
		condition.setProductName(keywords);
		List<Product> productList = productMapper.search(condition);
		addTemp(productList);
	}

	private void addTemp(List<Product> productList) {
		if (productList == null || productList.size() == 0) {
			MsgTool.addInfoMsg("未查询到该产品，或该产品没有定价");
			return;
		}

		for (Product product : productList) {
			PriceAdjust priceAdjust = new PriceAdjust();
			priceAdjust.setBrandId(product.getBrandId());
			priceAdjust.setBrandName(product.getBrandName());
			priceAdjust.setProductId(product.getId());
			priceAdjust.setProductName(product.getProductName());
			priceAdjust.setTechId(product.getTechId());
			priceAdjust.setTechName(product.getTechName());
			priceAdjust.setProductNo(product.getProductNo());
			priceAdjust.setThicknessId(product.getThicknessId());
			priceAdjust.setThicknessName(product.getThicknessName());
			priceAdjust.setQuantityId(product.getQuantityId());
			priceAdjust.setQuantityName(product.getQuantityName());
			priceAdjust.setPrice(product.getPrice());
			priceAdjust.setAdjustPrice(product.getPrice());
			User user = (User) loginSession.getSesionObj();
			priceAdjust.setCreateUserId(user.getId());
			priceAdjust.setCreateUserName(user.getRealname());
			if(!tempList.contains(priceAdjust)){
				tempList.add(priceAdjust);
			}
		}
	}

	public void priceAdjust() {
		User user = (User) loginSession.getSesionObj();
		try {
			priceAdjustService.priceAdjust(tempList, user.getId());
		} catch (LogicException e) {
			MsgTool.addWarningMsg(e.getMessage());
			return;
		}
		tempList.clear();
		MsgTool.addInfoMsg("调价完毕");

		RequestContext.getCurrentInstance().execute("PF('price_adjust_dlg').hide()");
	}

	public void delExistTemp(PriceAdjust pa) {
		tempList.remove(pa);
	}

	public PaginationDataModel<PriceAdjust> getPriceAdjustModel() {
		return priceAdjustModel;
	}

	public void setPriceAdjustModel(PaginationDataModel<PriceAdjust> priceAdjustModel) {
		this.priceAdjustModel = priceAdjustModel;
	}

	public List<PriceAdjust> getTempList() {
		return tempList;
	}

	public void setTempList(List<PriceAdjust> tempList) {
		this.tempList = tempList;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
}