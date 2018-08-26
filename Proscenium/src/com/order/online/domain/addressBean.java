package com.order.online.domain;

public class addressBean {
	private String AID;
	private String CID;
	private String username;
	private String Aaddress;
	private String Atel;
	public addressBean(){
		super();
	}
	public addressBean(String username){
		super();
		this.username = username;
	}
	
	public String getAID(){
		return AID;
	}
	
	public void setAID(String AID){
		this.AID = AID;
	}
	
	public String getCID(){
		return CID;
	}
	
	public void setCID(String CID){
		this.CID = CID;
	}
	
	public String getusername(){
		return username;
	}
	
	public void setusername(String username){
		this.username = username;
	}
	
	public String getAaddress(){
		return Aaddress;
	}
	
	public void setAaddress(String Aaddress){
		this.Aaddress = Aaddress;
	}
	
	public String getAtel(){
		return Atel;
	}
	
	public void setAtel(String Atel){
		this.Atel = Atel;
	}
	
}
