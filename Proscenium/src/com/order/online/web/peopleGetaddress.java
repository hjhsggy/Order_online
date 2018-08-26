package com.order.online.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.order.online.domain.addressBean;
import com.order.online.domain.customBean;
import com.order.online.domain.orderformBean;
import com.order.online.service.IcustomService;
import com.order.online.service.impl.customServiceImpl;

public class peopleGetaddress extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");	
		IcustomService customservice=new customServiceImpl();
		customBean cu = (customBean) request.getSession().getAttribute("customistrator");
		String CID=cu.getCID();
		List<addressBean> list=customservice.getaddress(CID);
		request.setAttribute("addresslists", list);
		request.getRequestDispatcher("modadress.jsp").forward(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
