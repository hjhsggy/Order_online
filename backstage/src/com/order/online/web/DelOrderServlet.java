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
 * Servlet implementation class DelOrderServlet
 */
@WebServlet("/DelOrderServlet")
public class DelOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelOrderServlet() {
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

        /*String OID = request.getParameter("OID");
        String CID = request.getParameter("CID");
        String username = request.getParameter("username");
        String PID = request.getParameter("PID");
        String AID = request.getParameter("AID");
        String Otime = request.getParameter("Otime");
        String Owish = request.getParameter("Owish");
        String Ocount = request.getParameter("Ocount");
        String Oarrival = request.getParameter("Oarrival");
        String Ostatue = request.getParameter("Ostatue");
        String Oinfo = request.getParameter("Oinfo");
        String Opingjia = request.getParameter("Opingjia");*/

        //orderBean specialty = new orderBean(OID,CID,username,Integer.parseInt(PID),AID,Otime,Owish,Float.parseFloat(Ocount),Oarrival,Ostatue,Oinfo,Opingjia);
        orderBean order = new orderBean();
        String id = request.getParameter("id");
        order.setOID(id);
        orderservice.DelOrder(order);
        request.getRequestDispatcher("GetOrderServlet").forward(request,response);
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
