package com.order.online.dao;

import java.util.List;

import com.order.online.domain.memberBean;

public interface ImemberDao {
	
	public List<memberBean> GetMember();
	
	public memberBean getObject(String id);
	
	public int AddMember(memberBean member);
	
	public int ModMember(memberBean member);
	
	public int DelMember(memberBean member);
}
