package com.order.online.service;

import java.util.List;

import com.order.online.domain.orderformBean;

public interface IMessegeService {

	public orderformBean getorder(orderformBean orderform) ;
	
    public List<orderformBean> getorder1() ;
	
	public List<orderformBean> getorder2() ;
	
	public List<orderformBean> getorder3() ;
	
	public List<orderformBean> getorder4() ;
	
	public List<orderformBean> getorder5() ;
	
	public void delorder(orderformBean orderform);
	
	public void updorder(orderformBean orderform);
}
