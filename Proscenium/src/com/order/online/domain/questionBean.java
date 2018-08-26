package com.order.online.domain;

public class questionBean {
	private int qID;
	private String question;
	public questionBean(){
		super();
	}
	
	public int getqID(){
		return qID;
	}
	
	public void setqID(int qID){
		this.qID = qID;
	}
	
	public String getquestion(){
		return question;
	}
	
	public void setquestion(String question){
		this.question = question;
	}
}
