package com.sunrise.boss.business.cms.operationlog.persistent;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;



/** @author Hibernate CodeGenerator */
public class OperationlogVO implements Serializable {

    /** identifier field */
    private Long logid;
    /** nullable persistent field */
    private java.util.Date optime;
    /** nullable persistent field */
    private String oprcode;
    /** nullable persistent field */
    private String success;
    /** nullable persistent field */
    private String oprtype;
    /** identifier field */
    private String opnid;
    private String parentid;
    private String name;
    private Short state;
    private String remark;
    private Date startdate;
    private Date enddate;
    private Short isbusi;
    private Short opnlevel;
    private Short busikind;
    private String busibelong;
    private Short sflag;
    private String approveid;

    public String getOprtype() {
		return oprtype;
	}

	public void setOprtype(String oprtype) {
		this.oprtype = oprtype;
	}

	/** full constructor */
    public OperationlogVO(java.util.Date optime, java.lang.String oprcode, java.lang.String success, java.lang.String opnid, java.lang.String name ,java.lang.String parentid,  java.lang.String remark,
    						java.util.Date startdate, java.util.Date enddate, java.lang.Short isbusi, java.lang.Short opnlevel, java.lang.Short busikind, java.lang.String busibelong,
    						java.lang.Short state,java.lang.Long logid ,java.lang.String oprtype) {
        this.opnid = opnid;
        this.parentid = parentid;
        this.name = name;
        this.state = state;
        this.remark = remark;
        this.startdate = startdate;
        this.enddate = enddate;
        this.isbusi = isbusi;
        this.opnlevel = opnlevel;
        this.busikind = busikind;
        this.busibelong = busibelong;
        
        this.logid = logid;
    	this.optime = optime;
        this.oprcode = oprcode;
        this.success = success;
        this.oprtype = oprtype;
    }

    /** default constructor */
    public OperationlogVO() {
    }

    public java.lang.Long getLogid() {
        return this.logid;
    }

    public void setLogid(java.lang.Long logid) {
        this.logid = logid;
    }

    public java.util.Date getOptime() {
        return this.optime;
    }

    public void setOptime(java.util.Date optime) {
        this.optime = optime;
    }

    public java.lang.String getOprcode() {
        return this.oprcode;
    }

    public void setOprcode(java.lang.String oprcode) {
        this.oprcode = oprcode;
    }

    public java.lang.String getSuccess() {
        return this.success;
    }

    public void setSuccess(java.lang.String success) {
        this.success = success;
    }


    public java.lang.String getName() {
        return this.name;
    }

    public void setName(java.lang.String name) {
        this.name = name;
    }

    public java.lang.String getRemark() {
        return this.remark;
    }

    public void setRemark(java.lang.String remark) {
        this.remark = remark;
    }

	public String toString() {
        return new ToStringBuilder(this)
            .append("logid", getLogid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof OperationlogVO) ) return false;
        OperationlogVO castOther = (OperationlogVO) other;
        return new EqualsBuilder()
            .append(this.getLogid(), castOther.getLogid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getLogid())
            .toHashCode();
    }

	public String getParentid() {
		return parentid;
	}

	public void setParentid(String parentid) {
		this.parentid = parentid;
	}

	public Short getState() {
		return state;
	}

	public void setState(Short state) {
		this.state = state;
	}

	public void setOpnid(String opnid) {
		this.opnid = opnid;
	}

	public String getOpnid() {
		return opnid;
	}

	public String getBusibelong() {
		return busibelong;
	}

	public void setBusibelong(String busibelong) {
		this.busibelong = busibelong;
	}

	public Short getBusikind() {
		return busikind;
	}

	public void setBusikind(Short busikind) {
		this.busikind = busikind;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public Short getIsbusi() {
		return isbusi;
	}

	public void setIsbusi(Short isbusi) {
		this.isbusi = isbusi;
	}

	public Short getOpnlevel() {
		return opnlevel;
	}

	public void setOpnlevel(Short opnlevel) {
		this.opnlevel = opnlevel;
	}

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Short getSflag() {
		return sflag;
	}

	public void setSflag(Short sflag) {
		this.sflag = sflag;
	}

	public String getApproveid() {
		return approveid;
	}

	public void setApproveid(String approveid) {
		this.approveid = approveid;
	}

}
