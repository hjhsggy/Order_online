package com.order.online.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.order.online.domain.orderformBean;
import com.order.online.service.IMessegeService;
import com.order.online.service.impl.MessegeServiceImpl;

@SuppressWarnings("serial")
public class order_rightServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		IMessegeService Messegeservice=new MessegeServiceImpl();
		List<orderformBean> list=Messegeservice.getorder1();
		request.setAttribute("orderformlists1", list);
		request.getRequestDispatcher("unidentified.jsp").forward(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}
}
