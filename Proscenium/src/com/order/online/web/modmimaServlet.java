package com.order.online.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.order.online.domain.customBean;
import com.order.online.service.IcustomService;
import com.order.online.service.impl.customServiceImpl;

public class modmimaServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		customBean cu = (customBean) request.getSession().getAttribute("customistrator");
		customBean custombean=new customBean();
		IcustomService customservice = new customServiceImpl();
		custombean.setCID(cu.getCID());
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		custombean.setname(name);
		custombean.setsex(sex);
		customservice.updatepassword(custombean);
		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect("index.html");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		customBean cu = (customBean) request.getSession().getAttribute("customistrator");
		customBean custombean=new customBean();
		IcustomService customservice = new customServiceImpl();
		custombean.setCID(cu.getCID());
		String password = request.getParameter("newpass");
		custombean.setpassword(password);
		customservice.updatepassword(custombean);
		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect("index.html");
	}

}
