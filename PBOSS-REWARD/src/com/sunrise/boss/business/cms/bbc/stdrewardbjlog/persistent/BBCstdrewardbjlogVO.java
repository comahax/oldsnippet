package com.sunrise.boss.business.cms.bbc.stdrewardbjlog.persistent;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class BBCstdrewardbjlogVO implements Serializable {

	private Long logid;
	private Date optime;
	private String oprcode;
	private String oprtype;
	private String success;
    /** identifier field */
    private String region;

    /** identifier field */
    private Long rewardid;

    /** persistent field */
    private String opnid;

    /** nullable persistent field */
    private Short acctype;

    /** nullable persistent field */
    private Double rewardstd;

    /** nullable persistent field */
    private Integer intvmonth;

    /** nullable persistent field */
    private String ruleid;
    
	/** nullable persistent field */
	private Short ossrc;

    public BBCstdrewardbjlogVO(java.lang.Long logid ) {
        this.logid = logid;
    }

    /** default constructor */
    public BBCstdrewardbjlogVO() {
    }

    public java.lang.String getRegion() {
        return this.region;
    }

    public void setRegion(java.lang.String region) {
        this.region = region;
    }

    public java.lang.Long getRewardid() {
        return this.rewardid;
    }

    public void setRewardid(java.lang.Long rewardid) {
        this.rewardid = rewardid;
    }

    public java.lang.String getOpnid() {
        return this.opnid;
    }

    public void setOpnid(java.lang.String opnid) {
        this.opnid = opnid;
    }

    public java.lang.Short getAcctype() {
        return this.acctype;
    }

    public void setAcctype(java.lang.Short acctype) {
        this.acctype = acctype;
    }

    public java.lang.Double getRewardstd() {
        return this.rewardstd;
    }

    public void setRewardstd(java.lang.Double rewardstd) {
        this.rewardstd = rewardstd;
    }

    public java.lang.Integer getIntvmonth() {
        return this.intvmonth;
    }

    public void setIntvmonth(java.lang.Integer intvmonth) {
        this.intvmonth = intvmonth;
    }

    public java.lang.String getRuleid() {
        return this.ruleid;
    }

    public void setRuleid(java.lang.String ruleid) {
        this.ruleid = ruleid;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append(getLogid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof BBCstdrewardbjlogVO) ) return false;
        BBCstdrewardbjlogVO castOther = (BBCstdrewardbjlogVO) other;
        return new EqualsBuilder()
            .append(this.getLogid(), castOther.getLogid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getLogid())
            .toHashCode();
    }

	public Long getLogid() {
		return logid;
	}

	public void setLogid(Long logid) {
		this.logid = logid;
	}

	public String getOprcode() {
		return oprcode;
	}

	public void setOprcode(String oprcode) {
		this.oprcode = oprcode;
	}

	public String getOprtype() {
		return oprtype;
	}

	public void setOprtype(String oprtype) {
		this.oprtype = oprtype;
	}

	public Date getOptime() {
		return optime;
	}

	public void setOptime(Date optime) {
		this.optime = optime;
	}

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public Short getOssrc() {
		return ossrc;
	}

	public void setOssrc(Short ossrc) {
		this.ossrc = ossrc;
	}

}
