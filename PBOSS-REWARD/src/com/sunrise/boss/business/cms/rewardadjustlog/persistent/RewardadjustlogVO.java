package com.sunrise.boss.business.cms.rewardadjustlog.persistent;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class RewardadjustlogVO implements Serializable {

	private Long logid;

    /** nullable persistent field */
    private java.util.Date optime;

    /** nullable persistent field */
    private String oprcode;

    /** nullable persistent field */
    private String oprtype;

    /** nullable persistent field */
    private String success;
	
    private Long seq;

    /** nullable persistent field */
    private String adjustkind;

    /** nullable persistent field */
    private String wayid;

    /** nullable persistent field */
    private String eftmonth;

    /** nullable persistent field */
    private Double adjmoney;

    /** nullable persistent field */
    private String adjusttype;

    /** nullable persistent field */
    private String reasontype;

    /** nullable persistent field */
    private String remark;

    /** nullable persistent field */
    private String createoprcode;

    /** nullable persistent field */
    private java.util.Date createtime;

    /** nullable persistent field */
    private String updateoprcode;

    /** nullable persistent field */
    private java.util.Date updatetime;

    /** nullable persistent field */
    private Long relateseq;

    /** nullable persistent field */
    private Double actualmoney;

    /** nullable persistent field */
    private Short rewardtype;

    /** nullable persistent field */
    private Short islock;

	private String adtoprcode;
	private java.util.Date adttime;
	private String srcmonth;

	private String  adjsrc;
	    
	private Long adjsrcseq;
	    
    public String getAdtoprcode() {
		return adtoprcode;
	}


	public void setAdtoprcode(String adtoprcode) {
		this.adtoprcode = adtoprcode;
	}


	public java.util.Date getAdttime() {
		return adttime;
	}


	public void setAdttime(java.util.Date adttime) {
		this.adttime = adttime;
	}


	public String getSrcmonth() {
		return srcmonth;
	}


	public void setSrcmonth(String srcmonth) {
		this.srcmonth = srcmonth;
	}


	/** default constructor */
    public RewardadjustlogVO() {
    }


    public java.lang.Long getSeq() {
        return this.seq;
    }

    public void setSeq(java.lang.Long seq) {
        this.seq = seq;
    }

    public java.lang.String getAdjustkind() {
        return this.adjustkind;
    }

    public void setAdjustkind(java.lang.String adjustkind) {
        this.adjustkind = adjustkind;
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.String getEftmonth() {
        return this.eftmonth;
    }

    public void setEftmonth(java.lang.String eftmonth) {
        this.eftmonth = eftmonth;
    }

    public java.lang.Double getAdjmoney() {
        return this.adjmoney;
    }

    public void setAdjmoney(java.lang.Double adjmoney) {
        this.adjmoney = adjmoney;
    }

    public java.lang.String getAdjusttype() {
        return this.adjusttype;
    }

    public void setAdjusttype(java.lang.String adjusttype) {
        this.adjusttype = adjusttype;
    }

    public java.lang.String getReasontype() {
        return this.reasontype;
    }

    public void setReasontype(java.lang.String reasontype) {
        this.reasontype = reasontype;
    }

    public java.lang.String getRemark() {
        return this.remark;
    }

    public void setRemark(java.lang.String remark) {
        this.remark = remark;
    }

    public java.lang.String getCreateoprcode() {
        return this.createoprcode;
    }

    public void setCreateoprcode(java.lang.String createoprcode) {
        this.createoprcode = createoprcode;
    }

    public java.util.Date getCreatetime() {
        return this.createtime;
    }

    public void setCreatetime(java.util.Date createtime) {
        this.createtime = createtime;
    }

    public java.lang.String getUpdateoprcode() {
        return this.updateoprcode;
    }

    public void setUpdateoprcode(java.lang.String updateoprcode) {
        this.updateoprcode = updateoprcode;
    }

    public java.util.Date getUpdatetime() {
        return this.updatetime;
    }

    public void setUpdatetime(java.util.Date updatetime) {
        this.updatetime = updatetime;
    }

    public java.lang.Long getRelateseq() {
        return this.relateseq;
    }

    public void setRelateseq(java.lang.Long relateseq) {
        this.relateseq = relateseq;
    }

    public java.lang.Double getActualmoney() {
        return this.actualmoney;
    }

    public void setActualmoney(java.lang.Double actualmoney) {
        this.actualmoney = actualmoney;
    }

    public java.lang.Short getRewardtype() {
        return this.rewardtype;
    }

    public void setRewardtype(java.lang.Short rewardtype) {
        this.rewardtype = rewardtype;
    }

    public java.lang.Short getIslock() {
        return this.islock;
    }

    public void setIslock(java.lang.Short islock) {
        this.islock = islock;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("seq", getSeq())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof RewardadjustlogVO) ) return false;
        RewardadjustlogVO castOther = (RewardadjustlogVO) other;
        return new EqualsBuilder()
            .append(this.getSeq(), castOther.getSeq())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getSeq())
            .toHashCode();
    }

	public Class logVOClass() {
		// TODO Auto-generated method stub
		return RewardadjustlogVO.class;
	}


	public Long getLogid() {
		return logid;
	}


	public void setLogid(Long logid) {
		this.logid = logid;
	}


	public java.util.Date getOptime() {
		return optime;
	}


	public void setOptime(java.util.Date optime) {
		this.optime = optime;
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


	public String getSuccess() {
		return success;
	}


	public void setSuccess(String success) {
		this.success = success;
	}


	public String getAdjsrc() {
		return adjsrc;
	}


	public void setAdjsrc(String adjsrc) {
		this.adjsrc = adjsrc;
	}


	public Long getAdjsrcseq() {
		return adjsrcseq;
	}


	public void setAdjsrcseq(Long adjsrcseq) {
		this.adjsrcseq = adjsrcseq;
	}

}
