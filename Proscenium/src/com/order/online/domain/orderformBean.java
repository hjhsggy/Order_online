package com.order.online.domain;

import java.util.List;

public class orderformBean {
	private String OID;
	private String CID;
	private String username;
	private int PID;
	private String AID;
	private float Ocount;
	private String Otime;
	private String Owish;
	private String Oarrival;
	private String Ostatue;
	private String Oinfo;
	private String Opingjia;
	private String Pname;
	private String Ptel;
	private String Aaddress;
	private List<order_foodBean> orderfood;
	public orderformBean(){
		super();
	}
	public String getOID() {
		return OID;
	}
	public void setOID(String oID) {
		OID = oID;
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
	public int getPID() {
		return PID;
	}
	public void setPID(int pID) {
		PID = pID;
	}
	public String getAID() {
		return AID;
	}
	public void setAID(String aID) {
		AID = aID;
	}
	public float getOcount() {
		return Ocount;
	}
	public void setOcount(float ocount) {
		Ocount = ocount;
	}
	public String getOtime() {
		return Otime;
	}
	public void setOtime(String otime) {
		Otime = otime;
	}
	public String getOwish() {
		return Owish;
	}
	public void setOwish(String owish) {
		Owish = owish;
	}
	public String getOarrival() {
		return Oarrival;
	}
	public void setOarrival(String oarrival) {
		Oarrival = oarrival;
	}
	public String getOstatue() {
		return Ostatue;
	}
	public void setOstatue(String ostatue) {
		Ostatue = ostatue;
	}
	public String getOinfo() {
		return Oinfo;
	}
	public void setOinfo(String oinfo) {
		Oinfo = oinfo;
	}
	public String getOpingjia() {
		return Opingjia;
	}
	public void setOpingjia(String opingjia) {
		Opingjia = opingjia;
	}

	public List<order_foodBean> getorderfood() {
		return orderfood;
	}
	public void setorderfood(List<order_foodBean> orderfood) {
		this.orderfood = orderfood;
	}
	
	public String getPname() {
		return Pname;
	}
	public void setPname(String pname) {
		Pname = pname;
	}
	public String getPtel() {
		return Ptel;
	}
	public void setPtel(String ptel) {
		Ptel = ptel;
	}
	
	public String getAaddress(){
		return Aaddress;
	}
	
	public void setAaddress(String Aaddress){
		this.Aaddress = Aaddress;
	}
	
}
