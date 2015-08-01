package com.kxm.kcgl.view;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.lang.time.DateUtils;
import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.hyjd.frame.psm.datamodel.PaginationDataModel;
import com.kxm.kcgl.domain.Commision;
import com.kxm.kcgl.domain.CommisionDetail;
import com.kxm.kcgl.service.CommisionService;

@Component
@Scope("view")
public class CommisionView implements Serializable {

	private static final long serialVersionUID = -976674734344859401L;

	private PaginationDataModel<Commision> commisionModel;

	private Commision condition = new Commision();

	private List<CommisionDetail> detailList;
	
	private Commision selectedCommision;

	@Autowired
	private CommisionService commisionService;

	private Integer year;
	private Integer month;

	@PostConstruct
	public void init() {
		initCommision();
	}

	public void initCommision() {
		if (year != null && month != null) {
			Date d = new Date();
			DateUtils.setYears(d, year);
			DateUtils.setMonths(d, month);

			condition.setCreateTime(d);
		}
		commisionModel = new PaginationDataModel<Commision>(
				"com.kxm.kcgl.mapper.CommisionMapper.selectSelective",
				condition);
	}

	public void showDetail(Commision commision) {
		this.selectedCommision = commision;
		detailList = commisionService.queryCommisionDetail(commision);
		RequestContext.getCurrentInstance().execute("PF('detail_dlg').show()");
	}

	public PaginationDataModel<Commision> getCommisionModel() {
		return commisionModel;
	}

	public void setCommisionModel(PaginationDataModel<Commision> commisionModel) {
		this.commisionModel = commisionModel;
	}

	public Commision getCondition() {
		return condition;
	}

	public void setCondition(Commision condition) {
		this.condition = condition;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public List<CommisionDetail> getDetailList() {
		return detailList;
	}

	public void setDetailList(List<CommisionDetail> detailList) {
		this.detailList = detailList;
	}

	public Commision getSelectedCommision() {
		return selectedCommision;
	}

	public void setSelectedCommision(Commision selectedCommision) {
		this.selectedCommision = selectedCommision;
	}
}