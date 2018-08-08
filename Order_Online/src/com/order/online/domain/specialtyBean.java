package com.order.online.domain;

public class specialtyBean {
	private String FID;
	private String Fname;
	private String Finfo;
	private float Fcount;
	private String Fpicture;
	private String Fother;
	
	public specialtyBean() {
		super();
	}
	
	public specialtyBean(String FID, String Fname, String Finfo, float Fcount, String Fpicture, String Fother){
		this.FID = FID;
		this.Fname = Fname;
		this.Finfo = Finfo;
		this.Fcount = Fcount;
		this.Fpicture = Fpicture;
		this.Fother = Fother;
	}
	
	public String getFID() {
		return FID;
	}
	public void setFID(String FID) {
		this.FID = FID;
	}
	public String getFname() {
		return Fname;
	}
	public void setFname(String Fname) {
		this.Fname = Fname;
	}
	public String getFinfo() {
		return Finfo;
	}
	public void setFinfo(String Finfo) {
		this.Finfo = Finfo;
	}
	public float getFcount() {
		return Fcount;
	}
	public void setFcount(float Fcount) {
		this.Fcount = Fcount;
	}
	public String getFpicture() {
		return Fpicture;
	}
	public void setFpicture(String Fpicture) {
		this.Fpicture = Fpicture;
	}
	public String getFother() {
		return Fother;
	}
	public void setFother(String Fother) {
		this.Fother = Fother;
	}
	
}
