package com.kxm.kcgl.view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.hyjd.frame.psm.utils.MsgTool;
import com.kxm.kcgl.domain.Func;
import com.kxm.kcgl.domain.Right;
import com.kxm.kcgl.service.FuncService;
import com.kxm.kcgl.service.RightFuncService;
import com.kxm.kcgl.service.RightService;
import com.kxm.kcgl.service.UserRightService;
import com.kxm.kcgl.service.UserService;

@Component
@Scope("view")
public class RightView implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private RightService rightService;

	@Autowired
	private UserService userService;

	@Autowired
	private FuncService funcService;

	private List<Right> rights;

	private List<Func> funcs;

	private int selectedRightId;

	private int[] selectedUserId;

	private int[] selectedFuncId;

	@Autowired
	private UserRightService userRightService;

	@Autowired
	private RightFuncService rightFuncService;

	@PostConstruct
	public void init() {
		initRight();
		initFunc();
	}

	public void initRight() {
		rights = rightService.queryAllRight();
	}

	public void initFunc() {
		funcs = funcService.query(new Func());
	}

	public void onRightChange() {
		selectedUserId = userRightService.queryUserIdByRightId(selectedRightId);
		selectedFuncId = rightFuncService.queryFuncIdByRightId(selectedRightId);
	}

	public void onUserChange() {
		userRightService.saveUserRight(selectedRightId, selectedUserId);
		MsgTool.addInfoMsg("修改成功");
	}

	public void onFuncChange() {
		rightFuncService.saveRightFunc(selectedFuncId, selectedRightId);
		MsgTool.addInfoMsg("修改成功");
	}

	public List<Right> getRights() {
		return rights;
	}

	public void setRights(List<Right> rights) {
		this.rights = rights;
	}

	public List<Func> getFuncs() {
		return funcs;
	}

	public void setFuncs(List<Func> funcs) {
		this.funcs = funcs;
	}

	public int getSelectedRightId() {
		return selectedRightId;
	}

	public int[] getSelectedUserId() {
		return selectedUserId;
	}

	public int[] getSelectedFuncId() {
		return selectedFuncId;
	}

	public void setSelectedRightId(int selectedRightId) {
		this.selectedRightId = selectedRightId;
	}

	public void setSelectedUserId(int[] selectedUserId) {
		this.selectedUserId = selectedUserId;
	}

	public void setSelectedFuncId(int[] selectedFuncId) {
		this.selectedFuncId = selectedFuncId;
	}
}