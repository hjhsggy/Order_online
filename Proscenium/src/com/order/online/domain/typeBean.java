package com.order.online.domain;

public class typeBean {
	private int tID;
	private String Ftype;
	public typeBean(){
		super();
	}
	
	public int gettID(){
		return tID;
	}
	
	public void settID(int tID){
		this.tID = tID;
	}
	
	public String getFtype(){
		return Ftype;
	}
	
	public void setFtype(String Ftype){
		this.Ftype = Ftype;
	}
}
