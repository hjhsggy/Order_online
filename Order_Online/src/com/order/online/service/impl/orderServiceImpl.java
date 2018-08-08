package com.order.online.service.impl;

import java.util.List;

import com.order.online.dao.IorderDao;
import com.order.online.domain.orderBean;
import com.order.online.service.IorderService;

public class orderServiceImpl implements IorderService {
	
	private IorderDao iorder;
	public orderServiceImpl(IorderDao iorder)
	{
		this.iorder = iorder;
	}
	
	@Override
	public List<orderBean> GetOrder() {
		// TODO Auto-generated method stub
		return iorder.GetOrder();
	}

	@Override
	public orderBean getObject(String id) {
		// TODO Auto-generated method stub
		return iorder.getObject(id);
	}

	@Override
	public int AddOrder(orderBean order) {
		// TODO Auto-generated method stub
		return iorder.AddOrder(order);
	}

	@Override
	public int ModOrder(orderBean order) {
		// TODO Auto-generated method stub
		return iorder.ModOrder(order);
	}

	@Override
	public int DelOrder(orderBean order) {
		// TODO Auto-generated method stub
		return iorder.DelOrder(order);
	}

	@Override
	public int ModOrderStatue(orderBean order) {
		// TODO Auto-generated method stub
		return iorder.ModOrderStatue(order);
	}

}
