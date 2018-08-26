package com.order.online.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.order.online.domain.customBean;
import com.order.online.domain.leave_feedbackBean;
import com.order.online.service.IcustomService;
import com.order.online.service.impl.customServiceImpl;
import com.order.online.util.AddID;

public class people_addmessageServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		IcustomService customservice=new customServiceImpl();
		leave_feedbackBean leave=new leave_feedbackBean();
		customBean cu = (customBean) request.getSession().getAttribute("customistrator");
		String L = request.getParameter("content");
        int flag = Integer.parseInt(request.getParameter("question"));
        AddID add=new AddID();
        String LID=add.SetID("L","LID","leave_feedback");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
        String LTime=df.format(System.currentTimeMillis());
        leave.setLID(LID);
        leave.setCID(cu.getCID());
        leave.setUsername(cu.getusername());
        leave.setL(L);
        leave.setFlag(flag);
        leave.setLTime(LTime);
        customservice.liuyan(leave);
		request.getRequestDispatcher("people_message").forward(request,response);
	}

}
