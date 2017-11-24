package com.sunrise.boss.business.cms.reward.creditstd3glog.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class Creditstd3glogVO implements Serializable {

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

    /** nullable persistent field */
    private Short cityid;

    /** nullable persistent field */
    private String wayattr;

    /** nullable persistent field */
    private Double rewardstd;

    /** nullable persistent field */
    private Double creditstd;

    /** nullable persistent field */
    private Double terminalstd;

    /** nullable persistent field */
    private Double zcterminalstd;

    /** nullable persistent field */
    private Short intvmonth;
    
	//专营奖励酬金标准
    private Double zyrewardstd;
    //积分奖励酬金标准（门店补贴下限）
    private Double jfrewardstd;
    //积分下限值
    private Double jfcreditstd;
    //全球通开户保底要求
    private Double gtnstd;

    /** full constructor */
    public Creditstd3glogVO(java.util.Date optime, java.lang.String oprcode, java.lang.String oprtype, java.lang.String success, java.lang.Short cityid, java.lang.String wayattr, java.lang.Double rewardstd, java.lang.Double creditstd, java.lang.Double terminalstd, java.lang.Double zcterminalstd, java.lang.Short intvmonth) {
        this.optime = optime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
        this.success = success;
        this.cityid = cityid;
        this.wayattr = wayattr;
        this.rewardstd = rewardstd;
        this.creditstd = creditstd;
        this.terminalstd = terminalstd;
        this.zcterminalstd = zcterminalstd;
        this.intvmonth = intvmonth;
    }

    /** default constructor */
    public Creditstd3glogVO() {
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

    public java.lang.Short getCityid() {
        return this.cityid;
    }

    public void setCityid(java.lang.Short cityid) {
        this.cityid = cityid;
    }

    public java.lang.String getWayattr() {
        return this.wayattr;
    }

    public void setWayattr(java.lang.String wayattr) {
        this.wayattr = wayattr;
    }

    public java.lang.Double getRewardstd() {
        return this.rewardstd;
    }

    public void setRewardstd(java.lang.Double rewardstd) {
        this.rewardstd = rewardstd;
    }

    public java.lang.Double getCreditstd() {
        return this.creditstd;
    }

    public void setCreditstd(java.lang.Double creditstd) {
        this.creditstd = creditstd;
    }

    public java.lang.Double getTerminalstd() {
        return this.terminalstd;
    }

    public void setTerminalstd(java.lang.Double terminalstd) {
        this.terminalstd = terminalstd;
    }

    public java.lang.Double getZcterminalstd() {
        return this.zcterminalstd;
    }

    public void setZcterminalstd(java.lang.Double zcterminalstd) {
        this.zcterminalstd = zcterminalstd;
    }

    public java.lang.Short getIntvmonth() {
        return this.intvmonth;
    }

    public void setIntvmonth(java.lang.Short intvmonth) {
        this.intvmonth = intvmonth;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("logid", getLogid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof Creditstd3glogVO) ) return false;
        Creditstd3glogVO castOther = (Creditstd3glogVO) other;
        return new EqualsBuilder()
            .append(this.getLogid(), castOther.getLogid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getLogid())
            .toHashCode();
    }

	public Double getZyrewardstd() {
		return zyrewardstd;
	}

	public void setZyrewardstd(Double zyrewardstd) {
		this.zyrewardstd = zyrewardstd;
	}

	public Double getJfrewardstd() {
		return jfrewardstd;
	}

	public void setJfrewardstd(Double jfrewardstd) {
		this.jfrewardstd = jfrewardstd;
	}

	public Double getJfcreditstd() {
		return jfcreditstd;
	}

	public void setJfcreditstd(Double jfcreditstd) {
		this.jfcreditstd = jfcreditstd;
	}

	public Double getGtnstd() {
		return gtnstd;
	}

	public void setGtnstd(Double gtnstd) {
		this.gtnstd = gtnstd;
	}

}
