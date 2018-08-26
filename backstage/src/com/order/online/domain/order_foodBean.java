package com.order.online.domain;

public class order_foodBean {
	private int number;
	private String OID;
	private String FID;
	private String Fname;
	private String Fcount;
	public order_foodBean() {
		super();
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getOID() {
		return OID;
	}

	public void setOID(String oID) {
		OID = oID;
	}

	public String getFID() {
		return FID;
	}

	public void setFID(String fID) {
		FID = fID;
	}

	public String getFname() {
		return Fname;
	}

	public void setFname(String fname) {
		Fname = fname;
	}
	
	public String getFcount() {
		return Fcount;
	}

	public void setFcount(String Fcount) {
		this.Fcount = Fcount;
	}

	@Override
	public String toString() {
		return "order_foodBean [number=" + number + ", OID=" + OID + ", FID="
				+ FID + ", Fname=" + Fname + ", Fcount=" + Fcount + "]";
	}
	
	

}
