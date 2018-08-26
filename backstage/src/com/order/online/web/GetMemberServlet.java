package com.order.online.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.order.online.dao.ImemberDao;
import com.order.online.dao.impl.memberDaoImpl;
import com.order.online.domain.memberBean;
import com.order.online.service.ImemberService;
import com.order.online.service.impl.memberServiceImpl;

/**
 * Servlet implementation class GetMemberServlet
 */
@WebServlet("/GetMemberServlet")
public class GetMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetMemberServlet() {
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

        ImemberDao memberdao = new memberDaoImpl();
        ImemberService memberservice = new memberServiceImpl(memberdao);
        List<memberBean> Lists = memberservice.GetMember();

        request.setAttribute("lists", Lists);

        request.getRequestDispatcher("member.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
