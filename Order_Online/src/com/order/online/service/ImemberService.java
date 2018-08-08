package com.order.online.service;

import java.util.List;

import com.order.online.domain.memberBean;

public interface ImemberService {
	public List<memberBean> GetMember();
	
	public memberBean getObject(String id);
	
	public int AddMember(memberBean member);
	
	public int ModMember(memberBean member);
	
	public int DelMember(memberBean member);
}
