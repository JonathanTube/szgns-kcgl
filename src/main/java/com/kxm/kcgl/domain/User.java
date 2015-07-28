package com.kxm.kcgl.domain;

import java.util.Date;
import java.util.List;

public class User implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String username;
	private String password;
	private Integer status;
	private String realname;
	private Date createTime;
	private Date updateTime;

	private List<Func> funcList;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public List<Func> getFuncList() {
		return funcList;
	}

	public void setFuncList(List<Func> funcList) {
		this.funcList = funcList;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
