package com.order.online.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.order.online.dao.IspecialtyDao;
import com.order.online.dao.impl.specialtyDaoImpl;
import com.order.online.domain.specialtyBean;
import com.order.online.service.IspecialtyService;
import com.order.online.service.impl.specialtyServiceImpl;

/**
 * Servlet implementation class DelSpecialtyServlet
 */
@WebServlet("/DelSpecialtyServlet")
public class DelSpecialtyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelSpecialtyServlet() {
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
        String id = request.getParameter("id");
        IspecialtyDao specialtydao = new specialtyDaoImpl();
        IspecialtyService specialtyservice = new specialtyServiceImpl(specialtydao);
        specialtyBean specialty = new specialtyBean();
        specialty.setFID(id);
        specialtyservice.DelSpecialty(specialty);
        
        request.getRequestDispatcher("GetSpecialtyServlet").forward(request,response);
        }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
