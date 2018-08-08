package com.order.online.web;

import java.io.IOException;
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
 * Servlet implementation class DelMemberServlet
 */
@WebServlet("/DelMemberServlet")
public class DelMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelMemberServlet() {
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

        /*String CID = request.getParameter("CID");
        String username = request.getParameter("username");
        String qID = request.getParameter("qID");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        String answer = request.getParameter("answer");
        String VIP = request.getParameter("VIP");*/  

        //memberBean member = new memberBean(CID,username,Integer.parseInt(qID),password,name,sex,answer,Integer.parseInt(VIP));
        
        memberBean member = new memberBean();
        String id = request.getParameter("id");
        System.out.println(id);
        member.setCID(id);
        memberservice.DelMember(member);
        request.getRequestDispatcher("GetMemberServlet").forward(request,response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
