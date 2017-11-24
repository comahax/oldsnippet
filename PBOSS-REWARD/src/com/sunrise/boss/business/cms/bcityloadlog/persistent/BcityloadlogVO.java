package com.sunrise.boss.business.cms.bcityloadlog.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class BcityloadlogVO implements Serializable {

    /** identifier field */
    private Long logid;

    /** nullable persistent field */
    private java.util.Date optime;

    /** nullable persistent field */
    private String oprcode;

    /** nullable persistent field */
    private String oprtype;

    /** nullable persistent field */
    private String success;

    /** persistent field */
    private String opnid;

    /** persistent field */
    private String cityid;

    /** nullable persistent field */
    private String simcode;

    /** nullable persistent field */
    private Short showorder;

    /** nullable persistent field */
    private java.util.Date createtime;

    /** nullable persistent field */
    private Short state;

    /** nullable persistent field */
    private Short calcflag;

    /** nullable persistent field */
    private String remark;
    
    private String waytype;

	private Integer inuse;

	private String infocustomer;

	private String infoemployee;

    /** full constructor */
    public BcityloadlogVO(java.lang.Long logid, java.util.Date optime, java.lang.String oprcode, java.lang.String oprtype, java.lang.String success, java.lang.String opnid, java.lang.String cityid, java.lang.String simcode, java.lang.Short showorder, java.util.Date createtime, java.lang.Short state, java.lang.Short calcflag, java.lang.String remark) {
        this.logid = logid;
        this.optime = optime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
        this.success = success;
        this.opnid = opnid;
        this.cityid = cityid;
        this.simcode = simcode;
        this.showorder = showorder;
        this.createtime = createtime;
        this.state = state;
        this.calcflag = calcflag;
        this.remark = remark;
    }
    
    /** default constructor */
    public BcityloadlogVO() {
    }

    /** minimal constructor */
    public BcityloadlogVO(java.lang.Long logid, java.lang.String opnid, java.lang.String cityid) {
        this.logid = logid;
        this.opnid = opnid;
        this.cityid = cityid;
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

    public java.lang.String getOprtype() {
        return this.oprtype;
    }

    public void setOprtype(java.lang.String oprtype) {
        this.oprtype = oprtype;
    }

    public java.lang.String getSuccess() {
        return this.success;
    }

    public void setSuccess(java.lang.String success) {
        this.success = success;
    }

    public java.lang.String getOpnid() {
        return this.opnid;
    }

    public void setOpnid(java.lang.String opnid) {
        this.opnid = opnid;
    }

    public java.lang.String getCityid() {
        return this.cityid;
    }

    public void setCityid(java.lang.String cityid) {
        this.cityid = cityid;
    }

    public java.lang.String getSimcode() {
        return this.simcode;
    }

    public void setSimcode(java.lang.String simcode) {
        this.simcode = simcode;
    }

    public java.lang.Short getShoworder() {
        return this.showorder;
    }

    public void setShoworder(java.lang.Short showorder) {
        this.showorder = showorder;
    }

    public java.util.Date getCreatetime() {
        return this.createtime;
    }

    public void setCreatetime(java.util.Date createtime) {
        this.createtime = createtime;
    }

    public java.lang.Short getState() {
        return this.state;
    }

    public void setState(java.lang.Short state) {
        this.state = state;
    }

    public java.lang.Short getCalcflag() {
        return this.calcflag;
    }

    public void setCalcflag(java.lang.Short calcflag) {
        this.calcflag = calcflag;
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
        if ( !(other instanceof BcityloadlogVO) ) return false;
        BcityloadlogVO castOther = (BcityloadlogVO) other;
        return new EqualsBuilder()
            .append(this.getLogid(), castOther.getLogid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getLogid())
            .toHashCode();
    }

	public String getInfocustomer() {
		return infocustomer;
	}

	public void setInfocustomer(String infocustomer) {
		this.infocustomer = infocustomer;
	}

	public String getInfoemployee() {
		return infoemployee;
	}

	public void setInfoemployee(String infoemployee) {
		this.infoemployee = infoemployee;
	}

	public Integer getInuse() {
		return inuse;
	}

	public void setInuse(Integer inuse) {
		this.inuse = inuse;
	}

	public String getWaytype() {
		return waytype;
	}

	public void setWaytype(String waytype) {
		this.waytype = waytype;
	}

}
