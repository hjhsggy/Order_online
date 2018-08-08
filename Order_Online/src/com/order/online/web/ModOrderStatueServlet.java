package com.order.online.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.order.online.dao.IorderDao;
import com.order.online.dao.impl.orderDaoImpl;
import com.order.online.domain.orderBean;
import com.order.online.service.IorderService;
import com.order.online.service.impl.orderServiceImpl;

/**
 * Servlet implementation class ModOrderStatueServlet
 */
@WebServlet("/ModOrderStatueServlet")
public class ModOrderStatueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModOrderStatueServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charaset=utf-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        IorderDao orderdao = new orderDaoImpl();
        IorderService orderservice = new orderServiceImpl(orderdao);
        String id = request.getParameter("id");
        orderBean order = orderservice.getObject(id);
        request.setAttribute("Order",order);

        request.getRequestDispatcher("mod_orderstatue.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charaset=utf-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        IorderDao orderdao = new orderDaoImpl();
        IorderService orderservice = new orderServiceImpl(orderdao);
        
        String Ostatue = request.getParameter("Ostatue");

        orderBean order = new orderBean(Ostatue);
        orderservice.ModOrder(order);
        response.sendRedirect("people_order_right");
	}

}
