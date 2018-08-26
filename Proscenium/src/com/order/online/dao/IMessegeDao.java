package com.order.online.dao;

import java.util.List;

import com.order.online.domain.customBean;
import com.order.online.domain.order_foodBean;
import com.order.online.domain.orderformBean;

public interface IMessegeDao {

	public orderformBean getorder(orderformBean orderform) ;
	
	public List<orderformBean> getorder1(customBean custom);
	
	public List<orderformBean> getorder2(customBean custom);
	
	public List<orderformBean> getorder3(customBean custom);
	
	public List<orderformBean> getorder4(customBean custom);
	
	public List<orderformBean> getorder5(customBean custom);
	
	public List<order_foodBean> getorderfood(orderformBean orderform);
	
	public orderformBean getorderpeople(orderformBean orderform);
	
	public orderformBean getorderaddress(orderformBean orderform);
	
	public void delorder(orderformBean orderform);
	
	public void updorder(orderformBean orderform);
}
