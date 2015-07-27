package com.kxm.kcgl.view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.kxm.kcgl.domain.Func;
import com.kxm.kcgl.domain.Right;
import com.kxm.kcgl.domain.User;
import com.kxm.kcgl.service.FuncService;
import com.kxm.kcgl.service.RightService;
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
	
	private List<User> users;
	
	private List<Func> funcs;

	private Long selectedRightId;
	
	private Long[] selectedUserId;
	
	private Long[] selectedFuncId;
	
	@PostConstruct
	public void init() {
		initRight();
		initUser();
		initFunc();
	}
	
	public void initRight(){
		rights = rightService.queryAllRight();
	}
	
	public void initUser(){
		users = userService.queryAll();
	}
	
	public void initFunc(){
		funcs = funcService.queryAll();
	}

	public List<Right> getRights() {
		return rights;
	}

	public void setRights(List<Right> rights) {
		this.rights = rights;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public Long getSelectedRightId() {
		return selectedRightId;
	}

	public void setSelectedRightId(Long selectedRightId) {
		this.selectedRightId = selectedRightId;
	}

	public Long[] getSelectedUserId() {
		return selectedUserId;
	}

	public void setSelectedUserId(Long[] selectedUserId) {
		this.selectedUserId = selectedUserId;
	}

	public List<Func> getFuncs() {
		return funcs;
	}

	public void setFuncs(List<Func> funcs) {
		this.funcs = funcs;
	}

	public Long[] getSelectedFuncId() {
		return selectedFuncId;
	}

	public void setSelectedFuncId(Long[] selectedFuncId) {
		this.selectedFuncId = selectedFuncId;
	}
}