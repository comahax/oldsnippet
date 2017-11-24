package com.sunrise.boss.business.cms.bbc.unvfaildataquery.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class UnvFaildataqueryVO implements Serializable {

    /** identifier field */
    private Long failid;

    /** nullable persistent field */
    private String rcno;

    /** nullable persistent field */
    private String mobileno;

    /** nullable persistent field */
    private String opnid;

    /** nullable persistent field */
    private String rcmonth;

    /** nullable persistent field */
    private java.util.Date rcdate;

    /** nullable persistent field */
    private String reason;

    /** nullable persistent field */
    private Short ossrc;
    
    private String adtcode;
    
    private String wayid;
    
    private String mobile;
    
    private String calcmonth;
    
    private String employeeid;
    
    private String wayname;
    
    private String batchno;
    
    private java.util.Date oprtime;
    
    private String status;

    public String getBatchno() {
		return batchno;
	}

	public void setBatchno(String batchno) {
		this.batchno = batchno;
	}

	public String getWayname() {
		return wayname;
	}

	public void setWayname(String wayname) {
		this.wayname = wayname;
	}

	public String getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(String employeeid) {
		this.employeeid = employeeid;
	}

	public String getCalcmonth() {
		return calcmonth;
	}

	public void setCalcmonth(String calcmonth) {
		this.calcmonth = calcmonth;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/** full constructor */
    public UnvFaildataqueryVO(java.lang.Long failid, java.lang.String rcno, java.lang.String mobileno, java.lang.String opnid, java.lang.String rcmonth, java.util.Date rcdate, java.lang.String reason, java.lang.Short ossrc, java.lang.String adtcode, java.lang.String wayid, java.lang.String calcmonth, java.lang.String mobile, java.lang.String employeeid, java.lang.String status, java.util.Date oprtime) {
        this.failid = failid;
        this.rcno = rcno;
        this.mobileno = mobileno;
        this.opnid = opnid;
        this.rcmonth = rcmonth;
        this.rcdate = rcdate;
        this.reason = reason;
        this.ossrc = ossrc;
        this.adtcode = adtcode;
        this.wayid = wayid;
        this.mobile = mobile;
        this.calcmonth = calcmonth;
        this.employeeid = employeeid;
        this.status = status;
        this.oprtime = oprtime;
    }

    /** default constructor */
    public UnvFaildataqueryVO() {
    }

    /** minimal constructor */
    public UnvFaildataqueryVO(java.lang.Long failid, java.lang.String employeeid) {
        this.failid = failid;
        this.employeeid = employeeid;
    }

    public java.lang.Long getFailid() {
        return this.failid;
    }

    public void setFailid(java.lang.Long failid) {
        this.failid = failid;
    }

    public java.lang.String getRcno() {
        return this.rcno;
    }

    public void setRcno(java.lang.String rcno) {
        this.rcno = rcno;
    }

    public java.lang.String getMobileno() {
        return this.mobileno;
    }

    public void setMobileno(java.lang.String mobileno) {
        this.mobileno = mobileno;
    }

    public java.lang.String getOpnid() {
        return this.opnid;
    }

    public void setOpnid(java.lang.String opnid) {
        this.opnid = opnid;
    }

    public java.lang.String getRcmonth() {
        return this.rcmonth;
    }

    public void setRcmonth(java.lang.String rcmonth) {
        this.rcmonth = rcmonth;
    }

    public java.util.Date getRcdate() {
        return this.rcdate;
    }

    public void setRcdate(java.util.Date rcdate) {
        this.rcdate = rcdate;
    }

    public java.lang.String getReason() {
        return this.reason;
    }

    public void setReason(java.lang.String reason) {
        this.reason = reason;
    }

    public java.lang.Short getOssrc() {
        return this.ossrc;
    }

    public void setOssrc(java.lang.Short ossrc) {
        this.ossrc = ossrc;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("failid", getFailid())
            .append("employeeid",getEmployeeid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof UnvFaildataqueryVO) ) return false;
        UnvFaildataqueryVO castOther = (UnvFaildataqueryVO) other;
        return new EqualsBuilder()
            .append(this.getFailid(), castOther.getFailid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getFailid())
            .toHashCode();
    }

	public String getAdtcode() {
		return adtcode;
	}

	public void setAdtcode(String adtcode) {
		this.adtcode = adtcode;
	}

	public String getWayid() {
		return wayid;
	}

	public void setWayid(String wayid) {
		this.wayid = wayid;
	}

	public java.util.Date getOprtime() {
		return oprtime;
	}

	public void setOprtime(java.util.Date oprtime) {
		this.oprtime = oprtime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
