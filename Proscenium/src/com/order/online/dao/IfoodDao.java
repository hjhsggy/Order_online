package com.order.online.dao;

import java.util.List;

import com.order.online.domain.foodBean;
import com.order.online.domain.order_foodBean;
import com.order.online.domain.orderformBean;

public interface IfoodDao {

	public List<foodBean> getfoodorder(int tID);
	
	public void setfoodorder(orderformBean orderform);
	
	public void setfood(order_foodBean order_food);
}
