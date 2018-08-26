package com.order.online.domain;

public class customBean {
	private String CID;
	private String username;
	private String password;
	private String name;
	private String sex;
	private int qID;
	private String question;
	private String answer;
	private int VIP;
	public customBean(){
		super();
	}
	
	public customBean(String username,String password){
		super();
		this.username = username;
		this.password = password;
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
	
	public String getpassword(){
		return password;
	}
	
	public void setpassword(String password){
		this.password = password;
	}
	
	public String getname(){
		return name;
	}
	
	public void setname(String name){
		this.name = name;
	}
	
	public String getsex(){
		return sex;
	}
	
	public void setsex(String sex){
		this.sex = sex;
	}
	
	public int getqID(){
		return qID;
	}
	
	public void setqID(int qID){
		this.qID = qID;
	}
	
	public String getanswer(){
		return answer;
	}
	
	public void setanswer(String answer){
		this.answer = answer;
	}
	
	public String getquestion(){
		return question;
	}
	
	public void setquestion(String question){
		this.question = question;
	}
	public int getVIP(){
		return VIP;
	}
	
	public void setVIP(int VIP){
		this.VIP = VIP;
	}

	@Override
	public String toString() {
		return "customBean [CID=" + CID + ", username=" + username
				+ ", password=" + password + ", name=" + name + ", sex=" + sex
				+ ", qID=" + qID + ", question=" + question + ", answer="
				+ answer + ", VIP=" + VIP + "]";
	}
	
}
