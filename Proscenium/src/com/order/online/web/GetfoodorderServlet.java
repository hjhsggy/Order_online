package com.order.online.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.order.online.domain.foodBean;
import com.order.online.service.IfoodService;
import com.order.online.service.impl.foodServiceImpl;

public class GetfoodorderServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		IfoodService foodservice=new foodServiceImpl();
		String tID=request.getParameter("tID");
		List<foodBean> list=foodservice.getfoodorder(Integer.parseInt(tID));
		request.setAttribute("lists", list);
		request.getRequestDispatcher("menus.jsp").forward(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
