package com.order.online.service;

import java.util.List;

import com.order.online.domain.addressBean;
import com.order.online.domain.customBean;
import com.order.online.domain.leave_feedbackBean;
import com.order.online.domain.questionBean;

public interface IcustomService {
	
	public customBean login(customBean custom);

	public List<questionBean> getquestionid();
	
	public customBean confirmation(customBean custom);
	
	public int register(customBean custom,addressBean address);
	
	public void updatename(customBean custom);
	
	public void updatepassword(customBean custom);
	
	public List<addressBean> getaddress(String a);
	
	public addressBean getaddress1(String a) ;
	
    public void addaddress(addressBean address);
	
	public void updateaddress(addressBean address);
	
	public void deladdress(addressBean address);
	
	public void liuyan(leave_feedbackBean leave);
	
	public List<leave_feedbackBean> getliuyan(customBean custom);
	
}
