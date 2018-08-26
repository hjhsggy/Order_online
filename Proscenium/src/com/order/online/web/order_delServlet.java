package com.order.online.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.order.online.domain.orderformBean;
import com.order.online.service.IMessegeService;
import com.order.online.service.impl.MessegeServiceImpl;

public class order_delServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String OID = request.getParameter("OID");
		IMessegeService messegeservice=new MessegeServiceImpl();
		orderformBean orderformbean=new orderformBean();
		orderformbean.setOID(OID);
		messegeservice.delorder(orderformbean);
		response.sendRedirect("people_order_right");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
