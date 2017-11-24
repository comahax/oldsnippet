package com.gmcc.pboss.business.sales.waystocksnpt;

import java.io.Serializable; 
import com.sunrise.jop.infrastructure.db.BaseVO;

/** @author Hibernate CodeGenerator */
public class RWaystocksnptVO extends BaseVO implements Serializable {

    /** identifier field */
    private Long recid;

    /** nullable persistent field */
    private String comresid;

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
    private java.util.Date stocktime;
    
    private java.util.Date acttime;
    
    private String iccid ;
    
    private String upperwayid;
    
    private String waymagcode;
    
    private String emptyno;
    
    private java.util.Date changetime;
    
    private String state;

    public String getIccid() {
		return iccid;
	}

	public void setIccid(String iccid) {
		this.iccid = iccid;
	}

	/** full constructor */
    public RWaystocksnptVO(java.lang.String comresid,java.lang.String countyid, java.lang.String svccode, java.lang.String mareacode, java.lang.String orderid, java.lang.String wayid, java.lang.String wayname, java.lang.Short starlevel, java.lang.String brand, java.lang.String comcategory,
    		java.util.Date stocktime, java.util.Date acttime,java.lang.String upperwayid,java.lang.String waymagcode) {
        this.comresid = comresid;
    	this.countyid = countyid;
        this.svccode = svccode;
        this.mareacode = mareacode;
        this.orderid = orderid;
        this.wayid = wayid;
        this.wayname = wayname;
        this.starlevel = starlevel;
        this.brand = brand;
        this.comcategory = comcategory;
        this.stocktime = stocktime;
        this.acttime = acttime;
        this.upperwayid = upperwayid;
        this.waymagcode = waymagcode;
    }

    /** default constructor */
    public RWaystocksnptVO() {
    }

    public java.lang.String getComresid() {
        return this.comresid;
    }

    public void setComresid(java.lang.String comresid) {
        this.comresid = comresid;
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

    public java.util.Date getStocktime() {
        return this.stocktime;
    }

    public void setStocktime(java.util.Date stocktime) {
        this.stocktime = stocktime;
    }

	public java.util.Date getActtime() {
		return acttime;
	}

	public void setActtime(java.util.Date acttime) {
		this.acttime = acttime;
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

	public String getEmptyno() {
		return emptyno;
	}

	public void setEmptyno(String emptyno) {
		this.emptyno = emptyno;
	}

	public java.util.Date getChangetime() {
		return changetime;
	}

	public void setChangetime(java.util.Date changetime) {
		this.changetime = changetime;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Long getRecid() {
		return recid;
	}

	public void setRecid(Long recid) {
		this.recid = recid;
	}
}
