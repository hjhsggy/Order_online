package com.order.online.service.impl;

import java.util.List;

import com.order.online.dao.IcustomDao;
import com.order.online.dao.impl.customDaoImpl;
import com.order.online.domain.addressBean;
import com.order.online.domain.customBean;
import com.order.online.domain.leave_feedbackBean;
import com.order.online.domain.questionBean;
import com.order.online.service.IcustomService;

public class customServiceImpl implements IcustomService {

	public customBean login(customBean custom) {
		IcustomDao customdao = new customDaoImpl();
		return customdao.login(custom);
	}
	
	public List<questionBean> getquestionid(){
		IcustomDao customdao = new customDaoImpl();
		return customdao.getquestionid();
	}
	
	public customBean confirmation(customBean custom){
		IcustomDao customdao = new customDaoImpl();
		return customdao.confirmation(custom);
	}
	
	public int register(customBean custom,addressBean address) {
		IcustomDao customdao = new customDaoImpl();
		return customdao.register(custom,address);
	}
	
	public void updatename(customBean custom){
		IcustomDao customdao = new customDaoImpl();
		customdao.updatename(custom);	
	}
	
	public void updatepassword(customBean custom){
		IcustomDao customdao = new customDaoImpl();
		customdao.updatepassword(custom);
	}
	
	public List<addressBean> getaddress(String a){
		IcustomDao customdao = new customDaoImpl();
		return customdao.getaddress(a);
	}
	
	public addressBean getaddress1(String a) {
		IcustomDao customdao = new customDaoImpl();
		return customdao.getaddress1(a);
	}
	
    public void addaddress(addressBean address){
    	IcustomDao customdao = new customDaoImpl();
		customdao.addaddress(address);	
    }
	
	public void updateaddress(addressBean address){
    	IcustomDao customdao = new customDaoImpl();
		customdao.updateaddress(address);	
    }
	
	public void deladdress(addressBean address){
        IcustomDao customdao = new customDaoImpl();
        customdao.deladdress(address);	
    }
	
	public void liuyan(leave_feedbackBean leave){
        IcustomDao customdao = new customDaoImpl();
        customdao.liuyan(leave);	
    }
	
	public List<leave_feedbackBean> getliuyan(customBean custom){
		IcustomDao customdao = new customDaoImpl();
		return customdao.getliuyan(custom);
	}
	
}
