package com.kxm.kcgl.view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.hyjd.frame.psm.datamodel.PaginationDataModel;
import com.kxm.kcgl.domain.Commision;
import com.kxm.kcgl.domain.CommisionDetail;

@Component
@Scope("view")
public class CommisionView implements Serializable {

	private static final long serialVersionUID = -976674734344859401L;

	private PaginationDataModel<Commision> commisionModel;

	private Commision condition = new Commision();

	private List<CommisionDetail> detailList;

	@PostConstruct
	public void init() {
		initCommision();
	}

	public void initCommision() {
		commisionModel = new PaginationDataModel<Commision>(
				"com.kxm.kcgl.mapper.CommisionMapper.selectSelective",
				condition);
	}

	public void showDetail(Integer userId) {

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
}