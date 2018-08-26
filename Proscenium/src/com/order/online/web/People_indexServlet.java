package com.order.online.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.order.online.domain.customBean;
import com.order.online.domain.order_foodBean;
import com.order.online.domain.orderformBean;
import com.order.online.service.IMessegeService;
import com.order.online.service.impl.MessegeServiceImpl;
import com.order.online.service.impl.foodServiceImpl;

public class People_indexServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");	
		IMessegeService Messegeservice=new MessegeServiceImpl();
		customBean cu = (customBean) request.getSession().getAttribute("customistrator");
		List<orderformBean> list=Messegeservice.getorder4(cu);
		request.setAttribute("orderformlists", list);
		request.getRequestDispatcher("people_index.jsp").forward(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);

	}

}
