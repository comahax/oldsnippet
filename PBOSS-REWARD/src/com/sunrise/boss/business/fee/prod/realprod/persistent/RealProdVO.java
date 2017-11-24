package com.sunrise.boss.business.fee.prod.realprod.persistent;

import java.io.Serializable;

/** @author Hibernate CodeGenerator */
public class RealProdVO implements Serializable {

    /** identifier field */
    private String brand;

    /** identifier field */
    private String prodid;

    /** nullable persistent field */
    private String servnumambit;
    
    private Short dealtype;
    
    private String memo;

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Short getDealtype() {
		return dealtype;
	}

	public void setDealtype(Short dealtype) {
		this.dealtype = dealtype;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getProdid() {
		return prodid;
	}

	public void setProdid(String prodid) {
		this.prodid = prodid;
	}

	public String getServnumambit() {
		return servnumambit;
	}

	public void setServnumambit(String servnumambit) {
		this.servnumambit = servnumambit;
	}

  
    

}
