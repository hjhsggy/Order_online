package com.order.online.service.impl;

import java.util.List;

import com.order.online.dao.IMessegeDao;
import com.order.online.dao.impl.MessegeDaoImpl;
import com.order.online.domain.orderformBean;
import com.order.online.service.IMessegeService;

public class MessegeServiceImpl implements IMessegeService{

	public orderformBean getorder(orderformBean orderform) {
		IMessegeDao messegedao=new MessegeDaoImpl();
		return messegedao.getorder(orderform);
		
	}
	
    public List<orderformBean> getorder1(){
		IMessegeDao messegedao=new MessegeDaoImpl();
		return messegedao.getorder1();
	}
	
	public List<orderformBean> getorder2(){
		IMessegeDao messegedao=new MessegeDaoImpl();
		return messegedao.getorder2();
	}
	
	public List<orderformBean> getorder3(){
		IMessegeDao messegedao=new MessegeDaoImpl();
		return messegedao.getorder3();
	}
	
	public List<orderformBean> getorder4(){
		IMessegeDao messegedao=new MessegeDaoImpl();
		return messegedao.getorder4();
	}
	
	public List<orderformBean> getorder5(){
		IMessegeDao messegedao=new MessegeDaoImpl();
		return messegedao.getorder5();
	}
	
	public void delorder(orderformBean orderform){
		IMessegeDao messegedao=new MessegeDaoImpl();
		messegedao.delorder(orderform);
	}
	
	public void updorder(orderformBean orderform){
		IMessegeDao messegedao=new MessegeDaoImpl();
		messegedao.updorder(orderform);
	}
}
