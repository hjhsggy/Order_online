package com.order.online.web;
import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class GetSpecialtyServlet
 */
@WebServlet("/GetSpecialtyServlet")
public class GetSpecialtyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetSpecialtyServlet() {
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

        //service
        IspecialtyDao specialtydao = new specialtyDaoImpl();
        IspecialtyService specialtyservice = new specialtyServiceImpl(specialtydao);
        List<specialtyBean> Lists = specialtyservice.GetSpecialty();
        request.setAttribute("lists", Lists);

        request.getRequestDispatcher("special.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doGet(request, response);
	}

}
