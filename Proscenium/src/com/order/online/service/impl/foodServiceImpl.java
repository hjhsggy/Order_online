package com.order.online.service.impl;

import java.util.List;

import com.order.online.dao.IfoodDao;
import com.order.online.dao.impl.foodDaoImpl;
import com.order.online.domain.foodBean;
import com.order.online.domain.order_foodBean;
import com.order.online.domain.orderformBean;
import com.order.online.service.IfoodService;

public class foodServiceImpl implements IfoodService{

	
	public List<foodBean> getfoodorder(int tID){
		IfoodDao fooddao = new foodDaoImpl();
		return fooddao.getfoodorder(tID);
	}
	
	public void setfoodorder(orderformBean orderform){
		IfoodDao fooddao = new foodDaoImpl();
		fooddao.setfoodorder(orderform);
	}
	
	public void setfood(order_foodBean order_food){
		IfoodDao fooddao = new foodDaoImpl();
		fooddao.setfood(order_food);
	}
}
