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

public class order_pingjiaServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
         String OID=request.getParameter("OID");
         IMessegeService messegeservice=new MessegeServiceImpl();
 		orderformBean orderformbean=new orderformBean();
 		orderformbean.setOID(OID);
 		orderformbean=messegeservice.getorder(orderformbean);
 		request.setAttribute("orderform",orderformbean);
 		request.getRequestDispatcher("order_pingjia.jsp").forward(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		IMessegeService messegeservice=new MessegeServiceImpl();
		orderformBean orderformbean=new orderformBean();
		String OID=request.getParameter("OID");
		String OPingjia=request.getParameter("OPingjia");
		orderformbean.setOID(OID);
		orderformbean.setOpingjia(OPingjia);
		messegeservice.updorder(orderformbean);
		response.sendRedirect("people_order_ok");

	}

}
