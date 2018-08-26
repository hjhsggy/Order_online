package com.order.online.test;

import org.junit.Test;

import com.order.online.dao.IorderDao;
import com.order.online.dao.impl.orderDaoImpl;
import com.order.online.domain.orderBean;
import com.order.online.service.IorderService;
import com.order.online.service.impl.orderServiceImpl;


public class order {
	@Test
	public void getorder()
	{
		IorderDao orderdao = new orderDaoImpl();
        IorderService orderservice = new orderServiceImpl(orderdao);
        System.out.println(orderservice.GetOrder().size());
	}
	
	@Test
	public void addorder()
	{
		IorderDao orderdao = new orderDaoImpl();
        IorderService orderservice = new orderServiceImpl(orderdao);
        orderBean order = new orderBean("4","4","4",4,"4","4","4",4,"4","4","4","4");
        System.out.println(orderservice.AddOrder(order));
	}
	
	@Test
	public void getobject()
	{
		IorderDao orderdao = new orderDaoImpl();
        IorderService orderservice = new orderServiceImpl(orderdao);
        orderBean order = orderservice.getObject("4");
        if(order != null)
        {
            System.out.print(order.getOID());
        }
	}
	
	@Test
	public void modorder()
	{
		IorderDao orderdao = new orderDaoImpl();
        IorderService orderservice = new orderServiceImpl(orderdao);
        orderBean order = new orderBean();
        int count = orderservice.ModOrder(order);
        System.out.print(count);
	}
	

	@Test
	public void delorder()
	{
		IorderDao orderdao = new orderDaoImpl();
        IorderService orderservice = new orderServiceImpl(orderdao);
        orderBean order = new orderBean();
        int count = orderservice.DelOrder(order);
        System.out.print(count);
	}
}
