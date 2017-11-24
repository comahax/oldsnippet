package com.sunrise.boss.business.cms.busicityload.persistent;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.boss.business.cms.bcityloadlog.persistent.BcityloadlogVO;
import com.sunrise.boss.business.common.dblog.OperationLog;

/** @author Hibernate CodeGenerator */
public class BusicityloadVO implements OperationLog {

    /** identifier field */
    private String cityid;

    /** identifier field */
    private String opnid;

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
    public BusicityloadVO(java.lang.String cityid, java.lang.String opnid, java.lang.String simcode, java.lang.Short showorder, java.util.Date createtime, java.lang.Short state, java.lang.Short calcflag, java.lang.String remark) {
        this.cityid = cityid;
        this.opnid = opnid;
        this.simcode = simcode;
        this.showorder = showorder;
        this.createtime = createtime;
        this.state = state;
        this.calcflag = calcflag;
        this.remark = remark;
    }

    /** default constructor */
    public BusicityloadVO() {
    }

    /** minimal constructor */
    public BusicityloadVO(java.lang.String cityid, java.lang.String opnid) {
        this.cityid = cityid;
        this.opnid = opnid;
    }

    public java.lang.String getCityid() {
        return this.cityid;
    }

    public void setCityid(java.lang.String cityid) {
        this.cityid = cityid;
    }

    public java.lang.String getOpnid() {
        return this.opnid;
    }

    public void setOpnid(java.lang.String opnid) {
        this.opnid = opnid;
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
            .append("cityid", getCityid())
            .append("opnid", getOpnid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof BusicityloadVO) ) return false;
        BusicityloadVO castOther = (BusicityloadVO) other;
        return new EqualsBuilder()
            .append(this.getCityid(), castOther.getCityid())
            .append(this.getOpnid(), castOther.getOpnid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCityid())
            .append(getOpnid())
            .toHashCode();
    }

	public Class logVOClass() {
		// TODO Auto-generated method stub
		return BcityloadlogVO.class;
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
