package com.gmcc.pboss.business.reward.cardrewdet;

import com.gmcc.pboss.business.channel.employeelog.EmployeelogVO;
import com.gmcc.pboss.business.reward.cardrewdetlog.CardrewdetlogVO;
import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import com.sunrise.jop.infrastructure.sysadmin.BusinessLog;

/** @author Hibernate CodeGenerator */
public class CardrewdetVO extends BaseVO implements BusinessLog {

    /** identifier field */
    private Long seqid;

    /** nullable persistent field */
    private String wayid;

    /** nullable persistent field */
    private String mobile;

    /** nullable persistent field */
    private java.util.Date activetime;

    /** nullable persistent field */
    private Double rechargenum;

    /** nullable persistent field */
    private java.util.Date rechargetime;

    /** nullable persistent field */
    private Double rewardnum;

    /** nullable persistent field */
    private String cmonth;
    
    private Long rewardtype;

    /** full constructor */
    public CardrewdetVO(java.lang.String wayid, java.lang.String mobile, java.util.Date activetime, java.lang.Double rechargenum, java.util.Date rechargetime, java.lang.Double rewardnum, java.lang.String cmonth) {
        this.wayid = wayid;
        this.mobile = mobile;
        this.activetime = activetime;
        this.rechargenum = rechargenum;
        this.rechargetime = rechargetime;
        this.rewardnum = rewardnum;
        this.cmonth = cmonth;
    }
    

    public Long getRewardtype() {
		return rewardtype;
	}



	public void setRewardtype(Long rewardtype) {
		this.rewardtype = rewardtype;
	}



	/** default constructor */
    public CardrewdetVO() {
    }

    public java.lang.Long getSeqid() {
        return this.seqid;
    }

    public void setSeqid(java.lang.Long seqid) {
        this.seqid = seqid;
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.String getMobile() {
        return this.mobile;
    }

    public void setMobile(java.lang.String mobile) {
        this.mobile = mobile;
    }

    public java.util.Date getActivetime() {
        return this.activetime;
    }

    public void setActivetime(java.util.Date activetime) {
        this.activetime = activetime;
    }

    public java.lang.Double getRechargenum() {
        return this.rechargenum;
    }

    public void setRechargenum(java.lang.Double rechargenum) {
        this.rechargenum = rechargenum;
    }

    public java.util.Date getRechargetime() {
        return this.rechargetime;
    }

    public void setRechargetime(java.util.Date rechargetime) {
        this.rechargetime = rechargetime;
    }

    public java.lang.Double getRewardnum() {
        return this.rewardnum;
    }

    public void setRewardnum(java.lang.Double rewardnum) {
        this.rewardnum = rewardnum;
    }

    public java.lang.String getCmonth() {
        return this.cmonth;
    }

    public void setCmonth(java.lang.String cmonth) {
        this.cmonth = cmonth;
    }
    
    public Class logVOClass() {
		// TODO Auto-generated method stub
		return CardrewdetlogVO.class;
	}

    public String toString() {
        return new ToStringBuilder(this)
            .append("seqid", getSeqid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CardrewdetVO) ) return false;
        CardrewdetVO castOther = (CardrewdetVO) other;
        return new EqualsBuilder()
            .append(this.getSeqid(), castOther.getSeqid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getSeqid())
            .toHashCode();
    }

}
