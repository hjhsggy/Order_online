package com.order.online.domain;

public class memberBean {
	
	public String CID;
	public String username;
	public int qID;
	public String password;
	public String name;
	public String sex;
	public String answer;
	public int VIP;
	
	public memberBean() {
		super();
	}
	
	public memberBean(String CID, String username, int qID, String password,String name, String sex, String answer, int VIP){
		this.CID = CID;
		this.username = username;
		this.qID = qID;
		this.password = password;
		this.name = name;
		this.sex = sex;
		this.answer = answer;
		this.VIP = VIP;
	}
	
	public String getCID() {
		return CID;
	}
	public void setCID(String cID) {
		CID = cID;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getqID() {
		return qID;
	}
	public void setqID(int qID) {
		this.qID = qID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public int getVIP() {
		return VIP;
	}
	public void setVIP(int vIP) {
		VIP = vIP;
	}
}
