package com.sunrise.boss.business.fee.persistent.creditchgreqtt;

import java.io.Serializable;
import java.util.Date;


public class CreditChgReqTTVO implements Serializable {

   
    private Long creditreqid;
    private Long subsid;
    private Long eboxid; 
    private Short reqtype;
    private Short reqsource;
    private Date reqtime; 
    private Short dealstate;
    private String opercode;
    

    
   


    public java.lang.Long getCreditreqid() {
        return this.creditreqid;
    }

    public void setCreditreqid(java.lang.Long creditreqid) {
        this.creditreqid = creditreqid;
    }

    public java.lang.Long getSubsid() {
        return this.subsid;
    }

    public void setSubsid(java.lang.Long subsid) {
        this.subsid = subsid;
    }

    public java.lang.Long getEboxid() {
        return this.eboxid;
    }

    public void setEboxid(java.lang.Long eboxid) {
        this.eboxid = eboxid;
    }

    public java.lang.Short getReqtype() {
        return this.reqtype;
    }

    public void setReqtype(java.lang.Short reqtype) {
        this.reqtype = reqtype;
    }

    public Date getReqtime() {
        return this.reqtime;
    }

    public void setReqtime(Date reqtime) {
        this.reqtime = reqtime;
    }

    public java.lang.Short getDealstate() {
        return this.dealstate;
    }

    public void setDealstate(java.lang.Short dealstate) {
        this.dealstate = dealstate;
    }


	public Short getReqsource() {
		return reqsource;
	}

	public void setReqsource(Short reqsource) {
		this.reqsource = reqsource;
	}

	public String getOpercode() {
		return opercode;
	}

	public void setOpercode(String opercode) {
		this.opercode = opercode;
	}



}
