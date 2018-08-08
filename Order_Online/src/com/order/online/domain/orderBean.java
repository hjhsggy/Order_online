package com.order.online.domain;

public class orderBean {
	public String OID;
	public String CID;
	public String username;
	public int PID;
	public String AID;
	public String Otime;
	public String Owish;
	public float Ocount;
	public String Oarrival;
	public String Ostatue;
	public String Oinfo;
	public String Opingjia;
	
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
	public float getOcount() {
		return Ocount;
	}
	public void setOcount(float ocount) {
		Ocount = ocount;
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
	
	public orderBean(String oID, String cID, String username, int pID, String aID, String otime, String owish,
			float ocount, String oarrival, String ostatue, String oinfo, String opingjia) {
		OID = oID;
		CID = cID;
		this.username = username;
		PID = pID;
		AID = aID;
		Otime = otime;
		Owish = owish;
		Ocount = ocount;
		Oarrival = oarrival;
		Ostatue = ostatue;
		Oinfo = oinfo;
		Opingjia = opingjia;
	}

	public orderBean(String Ostatue)
	{
		this.Ostatue = Ostatue;
	}
	public orderBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
