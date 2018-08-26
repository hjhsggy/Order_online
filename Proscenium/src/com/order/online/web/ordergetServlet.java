package com.order.online.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


import com.order.online.domain.customBean;
import com.order.online.domain.food_typeBean;
import com.order.online.domain.order_foodBean;
import com.order.online.domain.orderformBean;
import com.order.online.service.IfoodService;
import com.order.online.service.impl.foodServiceImpl;
import com.order.online.util.random;

public class ordergetServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		customBean cu = (customBean) request.getSession().getAttribute("customistrator");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
        String OTime=df.format(System.currentTimeMillis());
        String JFID = request.getParameter("JFID");
        String JFnumber = request.getParameter("JFnumber");
        List<String> list2=(List<String>)JSONArray.toList(JSONArray.fromObject(JFID), String.class);
        List<String> list3=(List<String>)JSONArray.toList(JSONArray.fromObject(JFnumber), String.class);
        String Aaddress = request.getParameter("Aaddress");
        String Oinfo = request.getParameter("Oinfo");
        String Omoney = request.getParameter("Omoney");
        String a = request.getParameter("a");
        order_foodBean order_food=null;
        orderformBean orderform=new orderformBean();
        orderform.setOID(random.createRandomCharData(20));
        String OID=orderform.getOID();
        orderform.setCID(cu.getCID());
        orderform.setUsername(cu.getusername());
        orderform.setAID(Aaddress);
        orderform.setOtime(OTime);
        orderform.setOwish(OTime);
        orderform.setOcount(Float.parseFloat(Omoney));
        orderform.setOstatue("1");
        orderform.setOinfo(Oinfo);
        IfoodService foodservice=new foodServiceImpl();
        foodservice.setfoodorder(orderform);
        for(int i=0;i<list2.size();i++){
        	
        	order_food=new order_foodBean();
        	order_food.setOID(OID);
        	order_food.setFID(list2.get(i));
        	order_food.setNumber(Integer.parseInt(list3.get(i)));
        	System.out.println(order_food);
        	foodservice.setfood(order_food);
        }
        request.getRequestDispatcher("people_order_right").forward(request,response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
