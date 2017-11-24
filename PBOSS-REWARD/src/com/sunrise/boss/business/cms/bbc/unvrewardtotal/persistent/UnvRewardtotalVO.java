package com.sunrise.boss.business.cms.bbc.unvrewardtotal.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class UnvRewardtotalVO implements Serializable {

    /** identifier field */
    private Long totalid;

    /** nullable persistent field */
    private Double paymoney;

    /** nullable persistent field */
    private Short rewardtype;

    /** nullable persistent field */
    private String rewardmonth;

    /** nullable persistent field */
    private String wayid;

    /** nullable persistent field */
    private Short ossrc;
    
    /** identifier field */
    private String rcid;

    /** nullable persistent field */
    private String rcno;

    /** nullable persistent field */
    private String rcname;

    /** nullable persistent field */
    private java.util.Date regdate;

    /** nullable persistent field */
    private Short rcstate;
    
    private String batchno;

    /** full constructor */
    public UnvRewardtotalVO(java.lang.Long totalid, java.lang.Double paymoney, java.lang.Short rewardtype, java.lang.String rewardmonth, java.lang.String wayid, java.lang.Short ossrc,java.lang.String rcid, java.lang.String rcno, java.lang.String rcname, java.util.Date regdate, java.lang.Short rcstate, java.lang.String batchno) {
        this.totalid = totalid;
        this.paymoney = paymoney;
        this.rewardtype = rewardtype;
        this.rewardmonth = rewardmonth;
        this.wayid = wayid;
        this.ossrc = ossrc;
        this.rcid = rcid;
        this.rcno = rcno;
        this.rcname = rcname;
        this.regdate = regdate;
        this.rcstate = rcstate;
        this.batchno = batchno;
    }

    /** default constructor */
    public UnvRewardtotalVO() {
    }

    /** minimal constructor */
    public UnvRewardtotalVO(java.lang.Long totalid) {
        this.totalid = totalid;
    }

    public java.lang.Long getTotalid() {
        return this.totalid;
    }

    public void setTotalid(java.lang.Long totalid) {
        this.totalid = totalid;
    }

    public java.lang.Double getPaymoney() {
        return this.paymoney;
    }

    public void setPaymoney(java.lang.Double paymoney) {
        this.paymoney = paymoney;
    }

    public java.lang.Short getRewardtype() {
        return this.rewardtype;
    }

    public void setRewardtype(java.lang.Short rewardtype) {
        this.rewardtype = rewardtype;
    }

    public java.lang.String getRewardmonth() {
        return this.rewardmonth;
    }

    public void setRewardmonth(java.lang.String rewardmonth) {
        this.rewardmonth = rewardmonth;
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.Short getOssrc() {
        return this.ossrc;
    }

    public void setOssrc(java.lang.Short ossrc) {
        this.ossrc = ossrc;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("totalid", getTotalid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof UnvRewardtotalVO) ) return false;
        UnvRewardtotalVO castOther = (UnvRewardtotalVO) other;
        return new EqualsBuilder()
            .append(this.getTotalid(), castOther.getTotalid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getTotalid())
            .toHashCode();
    }

	public String getRcid() {
		return rcid;
	}

	public void setRcid(String rcid) {
		this.rcid = rcid;
	}

	public String getRcno() {
		return rcno;
	}

	public void setRcno(String rcno) {
		this.rcno = rcno;
	}

	public String getRcname() {
		return rcname;
	}

	public void setRcname(String rcname) {
		this.rcname = rcname;
	}

	public java.util.Date getRegdate() {
		return regdate;
	}

	public void setRegdate(java.util.Date regdate) {
		this.regdate = regdate;
	}

	public Short getRcstate() {
		return rcstate;
	}

	public void setRcstate(Short rcstate) {
		this.rcstate = rcstate;
	}

	public String getBatchno() {
		return batchno;
	}

	public void setBatchno(String batchno) {
		this.batchno = batchno;
	}

}
