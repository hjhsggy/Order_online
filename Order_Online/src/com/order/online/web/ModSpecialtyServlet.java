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
 * Servlet implementation class ModSpecialtyServlet
 */
@WebServlet("/ModSpecialtyServlet")
public class ModSpecialtyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModSpecialtyServlet() {
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

        IspecialtyDao specialtydao = new specialtyDaoImpl();
        IspecialtyService specialtyservice = new specialtyServiceImpl(specialtydao);
        String id = request.getParameter("id");
        specialtyBean specialty = specialtyservice.getObject(id);
        request.setAttribute("Specialty",specialty);

        request.getRequestDispatcher("mod_special.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charaset=utf-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        IspecialtyDao specialtydao = new specialtyDaoImpl();
        IspecialtyService specialtyservice = new specialtyServiceImpl(specialtydao);

        String FID = request.getParameter("FID");
        String Fname = request.getParameter("Fname");
        String Finfo = request.getParameter("Finfo");
        String Fcount = request.getParameter("Fcount");
        String Fpicture = request.getParameter("Fpicture");
        String Fother = request.getParameter("Fother");

        specialtyBean specialty = new specialtyBean(FID,Fname,Finfo,Float.parseFloat(Fcount),Fpicture,Fother);
        specialtyservice.ModSpecialty(specialty);
        
        response.sendRedirect("GetSpecialtyServlet");
		//doGet(request, response);
	}

}
