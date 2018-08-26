package com.order.online.service;

import java.util.List;

import com.order.online.domain.foodBean;
import com.order.online.domain.order_foodBean;
import com.order.online.domain.orderformBean;

public interface IfoodService {

	
	public List<foodBean> getfoodorder(int tID);
	
	public void setfoodorder(orderformBean orderform);
	
	public void setfood(order_foodBean order_food);
}
