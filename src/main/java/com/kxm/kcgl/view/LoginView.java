package com.kxm.kcgl.view;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.hyjd.frame.psm.base.LoginSession;
import com.hyjd.frame.psm.utils.MsgTool;
import com.kxm.kcgl.domain.Func;
import com.kxm.kcgl.domain.User;
import com.kxm.kcgl.service.FuncService;
import com.kxm.kcgl.service.UserService;

@Component
@Scope("request")
public class LoginView implements Serializable {
	private static final long serialVersionUID = 1L;

	@Autowired
	private UserService userService;

	private User user = new User();

	@Autowired
	private LoginSession loginSession;
	
	@Autowired
	private FuncService funcService;

	public String doLogin() throws Exception {
		if(StringUtils.isEmpty(user.getUsername())){
			MsgTool.addWarningMsg("用户名不能为空");
			return null;
		}
		if(StringUtils.isEmpty(user.getPassword())){
			MsgTool.addWarningMsg("密码不能为空");
			return null;
		}
		List<User> users = userService.queryUser(user);
		if (users == null || users.size() == 0) {
			MsgTool.addWarningMsg("用户名或密码不正确");
		} else {
			User user = users.get(0);
			user.setFuncList(initFuncList(user.getId()));
			loginSession.setSesionObj(user);
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.getExternalContext().redirect("pc/main.xhtml");
		}
		return null;
	}
	
	private List<Func> initFuncList(int userId){
		 return funcService.queryFuncListByUserId(userId);
	}

	public String doLogout() throws IOException {
		loginSession.setSesionObj(null);
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
		session.invalidate();
		String contextName = facesContext.getExternalContext().getRequestContextPath();
		facesContext.getExternalContext().redirect(contextName + "/login.xhtml");
		return null;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public LoginSession getLoginSession() {
		return loginSession;
	}
}
