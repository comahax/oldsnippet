package com.gmcc.pboss.business.sales.disformprint;

import java.io.Serializable;

public class ComIccInfo implements Serializable {
	private String comid;//商品标识
	private String starticc;//起始编号,套卡记录ICCID,充值卡记录COMRESID
	private String endicc;//终止编号,套卡记录ICCID,充值卡记录COMRESID
	private int quantity;//数量 
	private double comSMP_price;  //套卡总金额
	private double comCard_price; //充值卡总金额
	
	public ComIccInfo(String comid, String starticc, String endicc, int quantity,double comSMP_price,double comCard_price ) {
		super();
		this.comid = comid;
		this.starticc = starticc;
		this.endicc = endicc;
		this.quantity = quantity;
		this.comCard_price = comCard_price;
		this.comSMP_price = comSMP_price;
	} 
	public ComIccInfo(String comid, String starticc, String endicc, int quantity) {
		super();
		this.comid = comid;
		this.starticc = starticc;
		this.endicc = endicc;
		this.quantity = quantity; 
	} 

	public String getComid() {
		return comid;
	}

	public void setComid(String comid) {
		this.comid = comid;
	}

	public String getStarticc() {
		return starticc;
	}

	public void setStarticc(String starticc) {
		this.starticc = starticc;
	}

	public String getEndicc() {
		return endicc;
	}

	public void setEndicc(String endicc) {
		this.endicc = endicc;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public double getComSMP_price() {
		return comSMP_price;
	}
	public void setComSMP_price(double comSMP_price) {
		this.comSMP_price = comSMP_price;
	}
	public double getComCard_price() {
		return comCard_price;
	}
	public void setComCard_price(double comCard_price) {
		this.comCard_price = comCard_price;
	}
 
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comid == null) ? 0 : comid.hashCode());
		result = prime * result + ((endicc == null) ? 0 : endicc.hashCode());
		result = prime * result
				+ ((starticc == null) ? 0 : starticc.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ComIccInfo other = (ComIccInfo) obj;
		if (comid == null) {
			if (other.comid != null)
				return false;
		} else if (!comid.equals(other.comid))
			return false;
		if (endicc == null) {
			if (other.endicc != null)
				return false;
		} else if (!endicc.equals(other.endicc))
			return false;
		if (starticc == null) {
			if (other.starticc != null)
				return false;
		} else if (!starticc.equals(other.starticc))
			return false; 
		return true;
	} 
}
