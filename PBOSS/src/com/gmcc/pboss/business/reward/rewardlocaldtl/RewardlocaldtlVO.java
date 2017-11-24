package com.gmcc.pboss.business.reward.rewardlocaldtl;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class RewardlocaldtlVO extends BaseVO implements Serializable {

	private Long id;
    /** identifier field */
    private String rewardmonth;

    /** persistent field */
    private String wayid;

    /** nullable persistent field */
    private String mobleno;

    /** nullable persistent field */
    private String type;
    
    private Double paymoney; 
    
    private String failureexplain;

    /** full constructor */
    public RewardlocaldtlVO(Long id,java.lang.String rewardmonth, java.lang.String wayid, java.lang.String mobleno, java.lang.String type,Double paymoney,String failureexplain) {
    	this.id = id;
        this.rewardmonth = rewardmonth;
        this.wayid = wayid;
        this.mobleno = mobleno;
        this.type = type;
        this.paymoney = paymoney;
        this.failureexplain=failureexplain;
    }

    /** default constructor */
    public RewardlocaldtlVO() {
    }

    /** minimal constructor */
    public RewardlocaldtlVO(java.lang.String rewardmonth, java.lang.String wayid) {
        this.rewardmonth = rewardmonth;
        this.wayid = wayid;
    }

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

    public java.lang.String getMobleno() {
        return this.mobleno;
    }

    public void setMobleno(java.lang.String mobleno) {
        this.mobleno = mobleno;
    }

    public java.lang.String getType() {
        return this.type;
    }

    public void setType(java.lang.String type) {
        this.type = type;
    }

    public Double getPaymoney() {
		return paymoney;
	}
    

	public String getFailureexplain() {
		return failureexplain;
	}

	public void setFailureexplain(String failureexplain) {
		this.failureexplain = failureexplain;
	}

	public void setPaymoney(Double paymoney) {
		this.paymoney = paymoney;
	}

	public String toString() {
        return new ToStringBuilder(this)
            .append("id", getId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof RewardlocaldtlVO) ) return false;
        RewardlocaldtlVO castOther = (RewardlocaldtlVO) other;
        return new EqualsBuilder()
            .append(this.getId(), castOther.getId())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getId())
            .toHashCode();
    }

}
