package com.order.online.test;

import java.util.List;

import net.sf.json.JSONArray;

import org.junit.Test;

import com.order.online.domain.addressBean;
import com.order.online.domain.customBean;
import com.order.online.domain.foodBean;
import com.order.online.domain.order_foodBean;
import com.order.online.domain.orderformBean;
import com.order.online.domain.questionBean;
import com.order.online.service.IMessegeService;
import com.order.online.service.IcustomService;
import com.order.online.service.IfoodService;
import com.order.online.service.impl.MessegeServiceImpl;
import com.order.online.service.impl.customServiceImpl;
import com.order.online.service.impl.foodServiceImpl;
import com.order.online.util.random;

public class logintest {
	
	@Test
	public void test1(){
		//IcustomDao cusI=new customDaoImpl();
		IcustomService cusI=new customServiceImpl();
		customBean cus=new customBean("liuchunlin","00000000");
		cus = cusI.login(cus);
		System.out.println(cus);
		System.out.println(cus.getusername());
		System.out.println(cus.getpassword());
		System.out.println(cus.getname());
		System.out.println(cus.getsex());
		System.out.println(cus.getqID());
		System.out.println(cus.getanswer());
		System.out.println(cus.getVIP());
	}
	@Test
	public void test2(){
		//IcustomDao cusI=new customDaoImpl();
		IcustomService cusI=new customServiceImpl();
		List<questionBean> qus=cusI.getquestionid();
		for (int i = 0; i < qus.size(); i++) {
			System.out.println(qus.get(i).getqID());
			System.out.println(qus.get(i).getquestion());
		}

	}
	
	@Test
	public void test4(){
		//IcustomDao cusI=new customDaoImpl();
		IcustomService cusI=new customServiceImpl();
		customBean cus=new customBean("zhangweidong","00000000");
		cus.setCID("10082");
		cus.setname("张伟东");
		cus.setqID(1);
		cus.setanswer("刘椿霖");
		cus.setVIP(1);
		addressBean ads=new addressBean();
		ads.setAID("asd");
		ads.setCID("10082");
		ads.setusername("zhangweidong");
		ads.setAtel("15091111115");
		int a= cusI.register(cus, ads);
		System.out.println(a);
	}
	
	@Test
	public void test5(){
		//IcustomDao cusI=new customDaoImpl();
		IfoodService fooI=new foodServiceImpl();
		List<foodBean> qus=fooI.getfoodorder(1);
		for (int i = 0; i < qus.size(); i++) {
			System.out.println(qus.get(i).getFID());
			System.out.println(qus.get(i).getFname());
			System.out.println(qus.get(i).getFinfo());
			System.out.println(qus.get(i).getFcount());
			System.out.println(qus.get(i).getFpicture());
			System.out.println(qus.get(i).getFother());
		}
	}
	
	@Test
	public void test6(){
		//IcustomDao cusI=new customDaoImpl();
		System.out.println(random.createRandomCharData(20));
		System.out.println(random.createRandomCharData(20));
		System.out.println(random.createRandomCharData(20));
		System.out.println(random.createRandomCharData(20));
	}
	@Test
	public void test7(){
		//IcustomDao cusI=new customDaoImpl();
		IMessegeService MesI=new MessegeServiceImpl();
		customBean cus=new customBean();
		cus.setCID("C00001");
		List<orderformBean> Mes=MesI.getorder1(cus);
		System.out.println(Mes);
		Mes=MesI.getorder3(cus);
		System.out.println(Mes);
		Mes=MesI.getorder5(cus);
		System.out.println(Mes);
	}
	@Test
	public void test8(){
		//IcustomDao cusI=new customDaoImpl();
		IMessegeService MesI=new MessegeServiceImpl();
		orderformBean orderform=new orderformBean();
		orderform.setOID("1");
		MesI.delorder(orderform);
	}
	@Test
	public void test9(){
		//IcustomDao cusI=new customDaoImpl();
		IMessegeService MesI=new MessegeServiceImpl();
		orderformBean orderform=new orderformBean();
		orderform.setOID("1");
		orderform.setOpingjia("美味");
		MesI.updorder(orderform);
	}
	@Test
	public void test19(){
		//IcustomDao cusI=new customDaoImpl();
		IMessegeService MesI=new MessegeServiceImpl();
		orderformBean orderform=new orderformBean();
		orderform.setOID("1");
		System.out.println((MesI.getorder(orderform)).toString());
	}
	@Test
	public void test18(){
		//IcustomDao cusI=new customDaoImpl();
		String JFID="[\"F00009\",\"F00050\"]";
		System.out.println(JFID);
		List<String> list2=(List<String>)JSONArray.toList(JSONArray.fromObject(JFID), String.class);
	    System.out.println(list2);
	    System.out.println(list2.get(0));
	    System.out.println(list2.get(1));
	}

	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
