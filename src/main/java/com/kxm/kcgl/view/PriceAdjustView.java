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
import com.kxm.kcgl.domain.Price;
import com.kxm.kcgl.domain.PriceAdjust;
import com.kxm.kcgl.domain.User;
import com.kxm.kcgl.service.PriceAdjustService;
import com.kxm.kcgl.service.PriceService;

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
	private PriceService priceService;

	@Autowired
	private PriceAdjustService priceAdjustService;

	private int productId;

	private String productNo;

	@PostConstruct
	public void init() {
		initPriceAdjust();
	}

	public void initPriceAdjust() {
		priceAdjustModel = new PaginationDataModel<PriceAdjust>("com.kxm.kcgl.mapper.PriceAdjustMapper.selectSelective", condition);
	}

	public void addByProductId() {
		// 判断是否已经添加过
		for (PriceAdjust pa : tempList) {
			if (pa.getProductId().equals(productId)) {
				MsgTool.addInfoMsg("请不要重复添加调价的产品");
				return;
			}
		}
		List<Price> priceList = priceService.queryByProductId(productId);
		addTemp(priceList);
	}

	public void addByProductNo() {
		// 判断是否已经添加过
		for (PriceAdjust pa : tempList) {
			if (pa.getProductNo().equals(productNo)) {
				MsgTool.addInfoMsg("请不要重复添加调价的产品");
				return;
			}
		}
		List<Price> priceList = priceService.queryByProductNo(productNo);
		addTemp(priceList);
	}

	private void addTemp(List<Price> priceList) {
		if (priceList == null || priceList.size() == 0) {
			MsgTool.addInfoMsg("未查询到该产品，或该产品没有定价");
			return;
		}

		for (Price price : priceList) {
			PriceAdjust priceAdjust = new PriceAdjust();
			priceAdjust.setBrandId(price.getBrandId());
			priceAdjust.setBrandName(price.getBrandName());
			priceAdjust.setProductId(price.getId());
			priceAdjust.setProductName(price.getProductName());
			priceAdjust.setTechId(price.getTechId());
			priceAdjust.setTechName(price.getTechName());
			priceAdjust.setProductNo(price.getProductNo());
			priceAdjust.setThicknessId(price.getThicknessId());
			priceAdjust.setThicknessName(price.getThicknessName());
			priceAdjust.setQuantityId(price.getQuantityId());
			priceAdjust.setQuantityName(price.getQuantityName());
			priceAdjust.setPrice(price.getPrice());
			priceAdjust.setAdjustPrice(price.getPrice());
			User user = (User) loginSession.getSesionObj();
			priceAdjust.setCreateUserId(user.getId());
			priceAdjust.setCreateUserName(user.getRealname());
			tempList.add(priceAdjust);
		}
	}

	public void priceAdjust() {
		User user = (User) loginSession.getSesionObj();
		priceAdjustService.priceAdjust(tempList, user.getId());
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

	public List<PriceAdjust> getTempList() {
		return tempList;
	}

	public void setTempList(List<PriceAdjust> tempList) {
		this.tempList = tempList;
	}

}