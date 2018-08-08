package com.order.online.domain;

public class adminBean {
	private int adminID;
	private String username;
	private String password;
	private String level;
	public adminBean(){
		super();
	}
	
	public adminBean(String username,String password){
		super();
		this.username = username;
		this.password = password;
	}
	
	public int getadminID(){
		return adminID;
	}
	
	public void setadminID(int adminID){
		this.adminID = adminID;
	}

	public String getusername(){
		return username;
	}
	
	public void setusername(String username){
		this.username = username;
	}
	
	public String getpassword(){
		return password;
	}
	
	public void setpassword(String password){
		this.password = password;
	}
	
	public String getlevel(){
		return level;
	}
	public void setlevel(String level){
		this.level = level;
	}
}
