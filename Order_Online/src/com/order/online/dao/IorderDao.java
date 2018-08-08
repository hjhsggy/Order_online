package com.order.online.dao;

import java.util.List;

import com.order.online.domain.orderBean;

public interface IorderDao {

	public List<orderBean> GetOrder();
	
	public orderBean getObject(String id);
	
	public int AddOrder(orderBean order);
	
	public int ModOrder(orderBean order);
	
	public int DelOrder(orderBean order);
	
	public int ModOrderStatue(orderBean order);
	
}
