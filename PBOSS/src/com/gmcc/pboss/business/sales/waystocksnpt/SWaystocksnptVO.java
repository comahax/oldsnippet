package com.gmcc.pboss.business.sales.waystocksnpt;

import java.io.Serializable;

import com.sunrise.jop.infrastructure.db.BaseVO;

/** @author Hibernate CodeGenerator */
public class SWaystocksnptVO extends BaseVO implements Serializable {

    /** nullable persistent field */
    private String countyid;

    /** nullable persistent field */
    private String svccode;

    /** nullable persistent field */
    private String mareacode;

    /** nullable persistent field */
    private String orderid;

    /** nullable persistent field */
    private String wayid;

    /** nullable persistent field */
    private String wayname;

    /** nullable persistent field */
    private Short starlevel;

    /** nullable persistent field */
    private String brand;

    /** nullable persistent field */
    private String comcategory;

    /** nullable persistent field */
    private java.lang.Long stocknum;

    private Double actrate;
    
    private String upperwayid;
    private String waymagcode;

    /** full constructor */
    public SWaystocksnptVO(java.lang.String countyid, java.lang.String svccode, java.lang.String mareacode, java.lang.String orderid, 
    		java.lang.String wayid, java.lang.String wayname, java.lang.Short starlevel, java.lang.String brand, java.lang.String comcategory, 
    		java.lang.Long stocknum, java.lang.Double actrate,java.lang.String upperwayid,java.lang.String waymagcode) {
        this.countyid = countyid;
        this.svccode = svccode;
        this.mareacode = mareacode;
        this.orderid = orderid;
        this.wayid = wayid;
        this.wayname = wayname;
        this.starlevel = starlevel;
        this.brand = brand;
        this.comcategory = comcategory;
        this.stocknum = stocknum;
        this.actrate = actrate;
        this.upperwayid = upperwayid;
        this.waymagcode = waymagcode;
    }

    /** default constructor */
    public SWaystocksnptVO() {
    }

    public java.lang.String getCountyid() {
        return this.countyid;
    }

    public void setCountyid(java.lang.String countyid) {
        this.countyid = countyid;
    }

    public java.lang.String getSvccode() {
        return this.svccode;
    }

    public void setSvccode(java.lang.String svccode) {
        this.svccode = svccode;
    }

    public java.lang.String getMareacode() {
        return this.mareacode;
    }

    public void setMareacode(java.lang.String mareacode) {
        this.mareacode = mareacode;
    }

    public java.lang.String getOrderid() {
        return this.orderid;
    }

    public void setOrderid(java.lang.String orderid) {
        this.orderid = orderid;
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.String getWayname() {
        return this.wayname;
    }

    public void setWayname(java.lang.String wayname) {
        this.wayname = wayname;
    }

    public java.lang.Short getStarlevel() {
        return this.starlevel;
    }

    public void setStarlevel(java.lang.Short starlevel) {
        this.starlevel = starlevel;
    }

    public java.lang.String getBrand() {
        return this.brand;
    }

    public void setBrand(java.lang.String brand) {
        this.brand = brand;
    }

    public java.lang.String getComcategory() {
        return this.comcategory;
    }

    public void setComcategory(java.lang.String comcategory) {
        this.comcategory = comcategory;
    }

    public java.lang.Long getStocknum() {
        return this.stocknum;
    }

    public void setStocknum(java.lang.Long stocknum) {
        this.stocknum = stocknum;
    }

	public Double getActrate() {
		return actrate;
	}

	public void setActrate(Double actrate) {
		this.actrate = actrate;
	}

	public String getUpperwayid() {
		return upperwayid;
	}

	public void setUpperwayid(String upperwayid) {
		this.upperwayid = upperwayid;
	}

	public String getWaymagcode() {
		return waymagcode;
	}

	public void setWaymagcode(String waymagcode) {
		this.waymagcode = waymagcode;
	}
    
    
}
