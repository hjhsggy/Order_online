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

public class customloginServlet extends HttpServlet {

	public customloginServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
         
        PrintWriter out = response.getWriter();
		customBean cu = (customBean) request.getSession().getAttribute("customistrator");
        //response.sendRedirect("GetFacilitiesServlet");
		out.print(cu.getname());
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
         
        PrintWriter out = response.getWriter();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		IcustomService customservice = new customServiceImpl();

		customBean custombean = new customBean(username, password);
		customBean custom = customservice.login(custombean);
		if (custom == null) {
			request.setAttribute("error", "用户名或密码错误");
			request.setAttribute("username", username);
			request.setAttribute("password", password);
			out.print("error");
			//request.getRequestDispatcher("index.html").forward(request,response);

		} else {
			HttpSession session = request.getSession();
			session.setAttribute("customistrator", custom);
			customBean cu = (customBean) request.getSession().getAttribute("customistrator");
            //response.sendRedirect("GetFacilitiesServlet");
			out.print(cu.getname());
		}
		out.flush();
        out.close();
	}
}
