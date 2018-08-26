package com.order.online.domain;

public class food_typeBean {
	private int tID;
	private String FID;
	private int number;
	public food_typeBean(){
		super();
	}
	
	public int getnumber(){
		return number;
	}
	
	public void setnumber(int number){
		this.number = number;
	}
	
	public int gettID(){
		return tID;
	}
	
	public void settID(int tID){
		this.tID = tID;
	}
	
	public String getFID(){
		return FID;
	}
	
	public void setFID(String FID){
		this.FID = FID;
	}
}
