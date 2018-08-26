package com.order.online.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.order.online.domain.addressBean;
import com.order.online.domain.customBean;
import com.order.online.service.IcustomService;
import com.order.online.service.impl.customServiceImpl;

public class people_updaddressServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String AID = request.getParameter("AID");
		IcustomService customservice = new customServiceImpl();
		addressBean address=customservice.getaddress1(AID);
		request.setAttribute("address", address);
		request.getRequestDispatcher("modaddaddress.jsp").forward(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String Aaddress = request.getParameter("Aaddress");
		String Atel = request.getParameter("Atel");
		String AID =request.getParameter("AID");
		customBean cu = (customBean) request.getSession().getAttribute("customistrator");
		addressBean address=new addressBean();
		address.setAID(AID);
		address.setCID(cu.getCID());
		address.setusername(cu.getusername());
		address.setAaddress(Aaddress);
		address.setAtel(Atel);
		IcustomService customservice = new customServiceImpl();
		customservice.updateaddress(address);
		response.sendRedirect("modaddress");
		
		
	}

}
