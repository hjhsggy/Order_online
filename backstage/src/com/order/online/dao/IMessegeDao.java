package com.order.online.dao;

import java.util.List;

import com.order.online.domain.order_foodBean;
import com.order.online.domain.orderformBean;

public interface IMessegeDao {

	public orderformBean getorder(orderformBean orderform) ;
	
	public List<orderformBean> getorder1();
	
	public List<orderformBean> getorder2();
	
	public List<orderformBean> getorder3();
	
	public List<orderformBean> getorder4();
	
	public List<orderformBean> getorder5();
	
	public List<order_foodBean> getorderfood(orderformBean orderform);
	
	public orderformBean getorderpeople(orderformBean orderform);
	
	public orderformBean getorderaddress(orderformBean orderform);
	
	public void delorder(orderformBean orderform);
	
	public void updorder(orderformBean orderform);
}
