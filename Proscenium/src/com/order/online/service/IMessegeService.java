package com.order.online.service;

import java.util.List;

import com.order.online.domain.customBean;
import com.order.online.domain.order_foodBean;
import com.order.online.domain.orderformBean;

public interface IMessegeService {

	public orderformBean getorder(orderformBean orderform) ;
	
    public List<orderformBean> getorder1(customBean custom) ;
	
	public List<orderformBean> getorder2(customBean custom) ;
	
	public List<orderformBean> getorder3(customBean custom) ;
	
	public List<orderformBean> getorder4(customBean custom) ;
	
	public List<orderformBean> getorder5(customBean custom) ;
	
	public void delorder(orderformBean orderform);
	
	public void updorder(orderformBean orderform);
}
