package com.order.online.test;

import org.junit.Test;

import com.order.online.domain.adminBean;
import com.order.online.service.IadminService;
import com.order.online.service.impl.adminServiceImpl;

public class logintest {
	

	@Test
	public void test2(){
		//IadminDao cusI=new adminDaoImpl();
		IadminService cusI=new adminServiceImpl();
		adminBean cus=new adminBean("liuchunlin","00000000");
		cus = cusI.login(cus);
		//System.out.println(cus.getadminID());
		System.out.println(cus.getusername());
		System.out.println(cus.getpassword());
		System.out.println(cus.getlevel());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
