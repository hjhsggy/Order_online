package com.order.online.service.impl;

import com.order.online.dao.IadminDao;
import com.order.online.dao.impl.adminDaoImpl;
import com.order.online.domain.adminBean;
import com.order.online.service.IadminService;

public class adminServiceImpl implements IadminService{
	
	
	public adminBean login(adminBean admin){
	IadminDao admindao=new adminDaoImpl();
	return admindao.login(admin);
	}
	
}
