package com.order.online.service.impl;

import java.util.List;

import com.order.online.dao.ImemberDao;
import com.order.online.domain.memberBean;
import com.order.online.service.ImemberService;

public class memberServiceImpl implements ImemberService {
	//memberDao
	private ImemberDao imember;
	public memberServiceImpl(ImemberDao imember)
	{
		this.imember = imember;
	}
	@Override
	public List<memberBean> GetMember() {
		// TODO Auto-generated method stub
		return imember.GetMember();
	}

	@Override
	public memberBean getObject(String id) {
		// TODO Auto-generated method stub
		return imember.getObject(id);
	}

	@Override
	public int AddMember(memberBean member) {
		// TODO Auto-generated method stub
		return imember.AddMember(member);
	}

	@Override
	public int ModMember(memberBean member) {
		// TODO Auto-generated method stub
		return imember.ModMember(member);
	}

	@Override
	public int DelMember(memberBean member) {
		// TODO Auto-generated method stub
		return imember.DelMember(member);
	}

}
