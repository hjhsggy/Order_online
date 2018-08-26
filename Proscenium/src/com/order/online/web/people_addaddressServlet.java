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
import com.order.online.util.AddID;

public class people_addaddressServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
       doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		customBean cu = (customBean) request.getSession().getAttribute("customistrator");
		addressBean addressbean=new addressBean();
		String Aaddress = request.getParameter("Aaddress");
        String Atel = request.getParameter("Atel");
		AddID add=new AddID();
		String AID=add.SetID("A","AID","address");
		addressbean.setAID(AID);
		addressbean.setCID(cu.getCID());
		addressbean.setusername(cu.getusername());
		addressbean.setAaddress(Aaddress);
		addressbean.setAtel(Atel);
		
		IcustomService customservice = new customServiceImpl();
        customservice.addaddress(addressbean);
        response.sendRedirect("modaddress");
	}
}
