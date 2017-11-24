package com.gmcc.pboss.business.sales.orderresdet;

import java.io.Serializable;

import com.sunrise.jop.infrastructure.db.BaseVO;

public class VOrderresdetVO extends BaseVO implements Serializable {
	
	
	 /** nullable persistent field */
    private String emptyno;
    
    /** nullable persistent field */
    private String orderstate;
	
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
    private String comcategory;

    
    
	public VOrderresdetVO() {
		super();
		// TODO Auto-generated constructor stub
	}



	public VOrderresdetVO(String emptyno, String orderstate, String countyid,
			String svccode, String mareacode, String orderid, String wayid,
			String wayname, Short starlevel, String comcategory) {
		super();
		this.emptyno = emptyno;
		this.orderstate = orderstate;
		this.countyid = countyid;
		this.svccode = svccode;
		this.mareacode = mareacode;
		this.orderid = orderid;
		this.wayid = wayid;
		this.wayname = wayname;
		this.starlevel = starlevel;
		this.comcategory = comcategory;
	}



	public String getEmptyno() {
		return emptyno;
	}



	public void setEmptyno(String emptyno) {
		this.emptyno = emptyno;
	}



	public String getOrderstate() {
		return orderstate;
	}



	public void setOrderstate(String orderstate) {
		this.orderstate = orderstate;
	}



	public String getCountyid() {
		return countyid;
	}



	public void setCountyid(String countyid) {
		this.countyid = countyid;
	}



	public String getSvccode() {
		return svccode;
	}



	public void setSvccode(String svccode) {
		this.svccode = svccode;
	}



	public String getMareacode() {
		return mareacode;
	}



	public void setMareacode(String mareacode) {
		this.mareacode = mareacode;
	}



	public String getOrderid() {
		return orderid;
	}



	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}



	public String getWayid() {
		return wayid;
	}



	public void setWayid(String wayid) {
		this.wayid = wayid;
	}



	public String getWayname() {
		return wayname;
	}



	public void setWayname(String wayname) {
		this.wayname = wayname;
	}



	public Short getStarlevel() {
		return starlevel;
	}



	public void setStarlevel(Short starlevel) {
		this.starlevel = starlevel;
	}



	public String getComcategory() {
		return comcategory;
	}



	public void setComcategory(String comcategory) {
		this.comcategory = comcategory;
	}
	
	
    
    
	
}
