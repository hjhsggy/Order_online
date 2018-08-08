package com.order.online.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.order.online.domain.adminBean;
import com.order.online.service.IadminService;
import com.order.online.service.impl.adminServiceImpl;

@SuppressWarnings("serial")
public class adminloginServlet extends HttpServlet {

	public adminloginServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String level = request.getParameter("level");
		IadminService adminservice = new adminServiceImpl();

		if (username.equals("")) {
			request.setAttribute("error", "未输入用户名");
			request.setAttribute("username", username);
			request.setAttribute("password", password);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} else if (password.equals("")) {
			request.setAttribute("error", "未输入密码");
			request.setAttribute("username", username);
			request.setAttribute("password", password);
			request.getRequestDispatcher("login.jsp").forward(request, response);

		} else {
			adminBean adminbean = new adminBean(username, password);
			adminBean admin = adminservice.login(adminbean);
			if (level.equals("2")) {
            
				if (admin == null) {

					request.setAttribute("error", "用户名或密码错误");
					request.setAttribute("username", username);
					request.setAttribute("password", password);
					request.getRequestDispatcher("login.jsp").forward(request, response);

				} else {
					HttpSession session = request.getSession();
					session.setAttribute("administrator", admin);
					response.sendRedirect("unidentified.jsp");
				} // 后台登陆
			} else {
				if (admin == null) {

					request.setAttribute("error", "用户名或密码错误");
					request.setAttribute("username", username);
					request.setAttribute("password", password);
					request.getRequestDispatcher("login.jsp").forward(request, response);

				} else {
					HttpSession session = request.getSession();
					session.setAttribute("administrator", admin);
					response.sendRedirect("GetSpecialtyServlet");
				} // 管理员登陆
			}
		}
	}
}
