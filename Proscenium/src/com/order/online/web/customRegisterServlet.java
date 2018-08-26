package com.order.online.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.order.online.domain.addressBean;
import com.order.online.domain.customBean;
import com.order.online.domain.questionBean;
import com.order.online.service.IcustomService;
import com.order.online.service.impl.customServiceImpl;
import com.order.online.util.AddID;

public class customRegisterServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
		
        PrintWriter out = response.getWriter();
        
        IcustomService customservice = new customServiceImpl();
		String username = request.getParameter("username");
		customBean custombean = new customBean();
		custombean.setusername(username);
         customservice.confirmation(custombean);
         
		customBean cu = customservice.confirmation(custombean);
        //response.sendRedirect("GetFacilitiesServlet");
		out.print(cu.getusername());

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
        String password = request.getParameter("password");
        int question = Integer.parseInt(request.getParameter("question"));
        String answer = request.getParameter("answer");
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        String Atel = request.getParameter("tel");
        String Aaddress = request.getParameter("address");
        AddID add=new AddID();
        String CID=add.SetID("C","CID","custom");
        String AID=add.SetID("A","AID","address");
        customBean custombean = new customBean();
        addressBean addressbean =new addressBean();
        custombean.setCID(CID);
        custombean.setusername(username);
        custombean.setpassword(password);
        custombean.setqID(question);
        custombean.setanswer(answer);
        custombean.setname(name);
        custombean.setsex(sex);
        
        addressbean.setAID(AID);
        addressbean.setCID(CID);
        addressbean.setusername(username);
        addressbean.setAtel(Atel);
        addressbean.setAaddress(Aaddress);
        
        IcustomService customservice = new customServiceImpl();
        customservice.register(custombean, addressbean);
        
        HttpSession session = request.getSession();
        session.setAttribute("customistrator", custombean);
		response.sendRedirect("index.html");

	}

}
