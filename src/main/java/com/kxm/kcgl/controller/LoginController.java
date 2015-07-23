package com.kxm.kcgl.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.util.StringUtils;

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		String userName = request.getParameter("userName");
		String password = request.getParameter("password");

		if (StringUtils.isEmpty(userName)) {
			return;
		}
		if (StringUtils.isEmpty(password)) {
			return;
		}

		String result = "fail";

		if ("admin".equals(userName) && "admin007".equals(password)) {
			session.setAttribute("userName", "admin");
			result = "ok";
		} else if ("szgns".equals(userName) && "szgns007".equals(password)) {
			session.setAttribute("userName", "szgns");
			result = "ok";
		} else if ("dgsy".equals(userName) && "dgsy007".equals(password)) {
			session.setAttribute("userName", "dgsy");
			result = "ok";
		} else if ("vip".equals(userName) && "vip007".equals(password)) {
			session.setAttribute("userName", "vip");
			result = "ok";
		}
		PrintWriter out = response.getWriter();
		out.print(result);
		out.flush();
		out.close();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String str = request.getParameter("logout");
		if ("true".equals(str)) {
			request.getSession().removeAttribute("userName");
		}
	}
}
