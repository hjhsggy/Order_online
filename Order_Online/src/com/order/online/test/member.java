package com.order.online.test;

import org.junit.Test;

import com.order.online.dao.ImemberDao;
import com.order.online.dao.impl.memberDaoImpl;
import com.order.online.domain.memberBean;
import com.order.online.service.ImemberService;
import com.order.online.service.impl.memberServiceImpl;

public class member {

	@Test
	public void getmember()
	{
		ImemberDao memberdao = new memberDaoImpl();
        ImemberService memberservice = new memberServiceImpl(memberdao);
        System.out.println(memberservice.GetMember().size());
	}
	
	@Test
	public void addmember()
	{
		ImemberDao memberdao = new memberDaoImpl();
        ImemberService memberservice = new memberServiceImpl(memberdao);
        memberBean member = new memberBean("4","4",4,"4","4","4","4",4);
        System.out.println(memberservice.AddMember(member));
	}
	
	@Test
	public void getobject()
	{
		ImemberDao memberdao = new memberDaoImpl();
        ImemberService memberservice = new memberServiceImpl(memberdao);
        memberBean member = memberservice.getObject("4");
        if(member != null)
        {
            System.out.print(member.getCID());
        }
	}
	
	@Test
	public void modmember()
	{
		ImemberDao memberdao = new memberDaoImpl();
        ImemberService memberservice = new memberServiceImpl(memberdao);
        memberBean member = new memberBean("4","4",4,"4","4","4","4",4);
        int count = memberservice.ModMember(member);
        System.out.print(count);
	}
	

	@Test
	public void delmember()
	{
		ImemberDao memberdao = new memberDaoImpl();
        ImemberService memberservice = new memberServiceImpl(memberdao);
        memberBean member = new memberBean("4","4",4,"4","4","4","4",4);
        int count = memberservice.DelMember(member);
        System.out.print(count);
	}
}
