package com.sunrise.boss.business.cms.zjty.zjtydataquery.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class ZjtyDataqueryVO implements Serializable {

    /** identifier field */
    private Long seq;

    /** nullable persistent field */
    private Long srcseq;

    /** nullable persistent field */
    private String cityid;

    /** nullable persistent field */
    private String opnid;

    /** nullable persistent field */
    private String wayid;

    /** nullable persistent field */
    private String oprcode;

    /** nullable persistent field */
    private java.util.Date oprtime;

    /** nullable persistent field */
    private String mobile;

    /** nullable persistent field */
    private Double busivalue;
    
    private Double wrapfee;
    
    private Short noncyc;
    
    private Short rewardtype;
    
    private Short calcflag;
    
    private String calcremark;
    
    private java.util.Date createtime;
    
    private java.util.Date wadttime;
    
    private java.util.Date updatetime;
    
    /** nullable persistent field */
    private Byte brand;

    /** nullable persistent field */
    private java.util.Date creattime;

    /** nullable persistent field */
    private java.util.Date adttime;
    //  ±ÊÎó×Ö¶ÎÐ£Õý
    private java.util.Date adtttime;

    /** nullable persistent field */
    private String src;

    /** nullable persistent field */
    private String calcopnid;

    /** nullable persistent field */
    private String calcmonth;

    /** nullable persistent field */
    private String ruleid;

    /** nullable persistent field */
    private String ruleitemid;

    /** nullable persistent field */
    private Short adtflag;

    /** nullable persistent field */
    private String adtcode;

    /** nullable persistent field */
    private String adtremark;

    /** full constructor */
    public ZjtyDataqueryVO(java.lang.Long srcseq, java.lang.String cityid, java.lang.String opnid, java.lang.String wayid, java.lang.String oprcode, java.util.Date oprtime, java.lang.String mobile, java.lang.Double busivalue, java.lang.Double wrapfee, java.lang.Short noncyc, java.lang.Short rewardtype, java.lang.Short calcflag, java.lang.String calcremark, java.util.Date createtime, java.util.Date wadttime, java.util.Date updatetime, java.lang.Byte brand, java.util.Date creattime, java.util.Date adttime, java.lang.String src, java.lang.String calcopnid, java.lang.String calcmonth, java.lang.String ruleid, java.lang.String ruleitemid, java.lang.Short adtflag, java.lang.String adtcode, java.lang.String adtremark) {
        this.srcseq = srcseq;
        this.cityid = cityid;
        this.opnid = opnid;
        this.wayid = wayid;
        this.oprcode = oprcode;
        this.oprtime = oprtime;
        this.mobile = mobile;
        this.busivalue = busivalue;
        this.wrapfee = wrapfee;
        this.noncyc = noncyc;
        this.rewardtype = rewardtype;
        this.calcflag = calcflag;
        this.calcremark = calcremark;
        this.createtime = createtime;
        this.wadttime = wadttime;
        this.updatetime = updatetime;
        this.brand = brand;
        this.creattime = creattime;
        this.adttime = adttime;
        this.src = src;
        this.calcopnid = calcopnid;
        this.calcmonth = calcmonth;
        this.ruleid = ruleid;
        this.ruleitemid = ruleitemid;
        this.adtflag = adtflag;
        this.adtcode = adtcode;
        this.adtremark = adtremark;
    }

    /** default constructor */
    public ZjtyDataqueryVO() {
    }

    public java.lang.Long getSeq() {
        return this.seq;
    }

    public void setSeq(java.lang.Long seq) {
        this.seq = seq;
    }

    public java.lang.Long getSrcseq() {
        return this.srcseq;
    }

    public void setSrcseq(java.lang.Long srcseq) {
        this.srcseq = srcseq;
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

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.String getOprcode() {
        return this.oprcode;
    }

    public void setOprcode(java.lang.String oprcode) {
        this.oprcode = oprcode;
    }

    public java.util.Date getOprtime() {
        return this.oprtime;
    }

    public void setOprtime(java.util.Date oprtime) {
        this.oprtime = oprtime;
    }

    public java.lang.String getMobile() {
        return this.mobile;
    }

    public void setMobile(java.lang.String mobile) {
        this.mobile = mobile;
    }

    public java.lang.Double getBusivalue() {
        return this.busivalue;
    }

    public void setBusivalue(java.lang.Double busivalue) {
        this.busivalue = busivalue;
    }

    public java.lang.Byte getBrand() {
        return this.brand;
    }

    public void setBrand(java.lang.Byte brand) {
        this.brand = brand;
    }

    public java.util.Date getCreattime() {
        return this.creattime;
    }

    public void setCreattime(java.util.Date creattime) {
        this.creattime = creattime;
    }

    public java.util.Date getAdttime() {
        return this.adttime;
    }

    public void setAdttime(java.util.Date adttime) {
        this.adttime = adttime;
    }

    public java.lang.String getSrc() {
        return this.src;
    }

    public void setSrc(java.lang.String src) {
        this.src = src;
    }

    public java.lang.String getCalcopnid() {
        return this.calcopnid;
    }

    public void setCalcopnid(java.lang.String calcopnid) {
        this.calcopnid = calcopnid;
    }

    public java.lang.String getCalcmonth() {
        return this.calcmonth;
    }

    public void setCalcmonth(java.lang.String calcmonth) {
        this.calcmonth = calcmonth;
    }

    public java.lang.String getRuleid() {
        return this.ruleid;
    }

    public void setRuleid(java.lang.String ruleid) {
        this.ruleid = ruleid;
    }

    public java.lang.String getRuleitemid() {
        return this.ruleitemid;
    }

    public void setRuleitemid(java.lang.String ruleitemid) {
        this.ruleitemid = ruleitemid;
    }

    public java.lang.Short getAdtflag() {
        return this.adtflag;
    }

    public void setAdtflag(java.lang.Short adtflag) {
        this.adtflag = adtflag;
    }

    public java.lang.String getAdtcode() {
        return this.adtcode;
    }

    public void setAdtcode(java.lang.String adtcode) {
        this.adtcode = adtcode;
    }

    public java.lang.String getAdtremark() {
        return this.adtremark;
    }

    public void setAdtremark(java.lang.String adtremark) {
        this.adtremark = adtremark;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("seq", getSeq())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ZjtyDataqueryVO) ) return false;
        ZjtyDataqueryVO castOther = (ZjtyDataqueryVO) other;
        return new EqualsBuilder()
            .append(this.getSeq(), castOther.getSeq())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getSeq())
            .toHashCode();
    }

	public java.util.Date getAdtttime() {
		return adtttime;
	}

	public void setAdtttime(java.util.Date adtttime) {
		this.adtttime = adtttime;
	}

	public Short getCalcflag() {
		return calcflag;
	}

	public void setCalcflag(Short calcflag) {
		this.calcflag = calcflag;
	}

	public String getCalcremark() {
		return calcremark;
	}

	public void setCalcremark(String calcremark) {
		this.calcremark = calcremark;
	}

	public java.util.Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(java.util.Date createtime) {
		this.createtime = createtime;
	}

	public Short getNoncyc() {
		return noncyc;
	}

	public void setNoncyc(Short noncyc) {
		this.noncyc = noncyc;
	}

	public Short getRewardtype() {
		return rewardtype;
	}

	public void setRewardtype(Short rewardtype) {
		this.rewardtype = rewardtype;
	}

	public java.util.Date getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(java.util.Date updatetime) {
		this.updatetime = updatetime;
	}

	public java.util.Date getWadttime() {
		return wadttime;
	}

	public void setWadttime(java.util.Date wadttime) {
		this.wadttime = wadttime;
	}

	public Double getWrapfee() {
		return wrapfee;
	}

	public void setWrapfee(Double wrapfee) {
		this.wrapfee = wrapfee;
	}

}
