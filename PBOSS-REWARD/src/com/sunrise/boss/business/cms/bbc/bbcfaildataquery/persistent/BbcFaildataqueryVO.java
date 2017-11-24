package com.sunrise.boss.business.cms.bbc.bbcfaildataquery.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class BbcFaildataqueryVO implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** identifier field */
    private Long seq;
 
    /** nullable persistent field */
    private String cityid;

    /** nullable persistent field */
    private String opnid;
    
    private String name;

    /** nullable persistent field */
    private String wayid;
    
    private String wayname;

    /** nullable persistent field */
    private String oprcode;

    /** nullable persistent field */
    private java.util.Date oprtime;

    /** nullable persistent field */
    private String mobile;

    /** nullable persistent field */
    private Double busivalue;

    /** nullable persistent field */
    private java.util.Date creattime;

    /** nullable persistent field */
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
    private Short adtflag;

    /** nullable persistent field */
    private String adtcode;

    /** nullable persistent field */
    private String adtremark;

    /** nullable persistent field */
    private String srcseq;
    
    private String rewardtype;
    
	private Integer ossrc;
	
	private String batchno;

    public String getBatchno() {
		return batchno;
	}

	public void setBatchno(String batchno) {
		this.batchno = batchno;
	}

	public String getRewardtype() {
		return rewardtype;
	}

	public void setRewardtype(String rewardtype) {
		this.rewardtype = rewardtype;
	}

	/** full constructor */
    public BbcFaildataqueryVO(java.lang.Long seq, java.lang.String oprcode, java.util.Date oprtime, java.lang.String cityid, java.lang.Double busivalue, java.lang.Short adtflag, java.lang.String adtcode, java.lang.String adtremark, java.util.Date adtttime, java.lang.String calcopnid, java.lang.String calcmonth, java.lang.Byte brand, java.util.Date creattime, java.lang.String src, java.lang.String ruleid, java.lang.String ruleitemid, java.lang.String opnid, java.lang.String name, java.lang.String mobile, java.lang.String wayid, java.lang.String wayname, java.lang.String srcseq, java.lang.String rewardtype, java.lang.Integer ossrc) {
        this.seq = seq; 
        this.cityid = cityid;
        this.opnid = opnid;
        this.name = name;
        this.wayid = wayid;
        this.wayname = wayname;
        this.oprcode = oprcode;
        this.oprtime = oprtime;
        this.mobile = mobile;
        this.busivalue = busivalue;
        this.creattime = creattime;
        this.adtttime = adtttime;
        this.src = src;
        this.calcopnid = calcopnid;
        this.calcmonth = calcmonth;
        this.ruleid = ruleid;
        this.adtflag = adtflag;
        this.adtcode = adtcode;
        this.adtremark = adtremark;
        this.srcseq = srcseq;
        this.rewardtype = rewardtype;
        this.ossrc = ossrc;
    }

    /** default constructor */
    public BbcFaildataqueryVO() {
    }

    /** minimal constructor */
    public BbcFaildataqueryVO(java.lang.Long seq) {
        this.seq = seq;
    }

    public java.lang.Long getSeq() {
        return this.seq;
    }

    public void setSeq(java.lang.Long seq) {
        this.seq = seq;
    }


    public String getAdtcode() {
		return adtcode;
	}

	public void setAdtcode(String adtcode) {
		this.adtcode = adtcode;
	}

	public Short getAdtflag() {
		return adtflag;
	}

	public void setAdtflag(Short adtflag) {
		this.adtflag = adtflag;
	}

	public String getAdtremark() {
		return adtremark;
	}

	public void setAdtremark(String adtremark) {
		this.adtremark = adtremark;
	}

	public java.util.Date getAdtttime() {
		return adtttime;
	}

	public void setAdtttime(java.util.Date adtttime) {
		this.adtttime = adtttime;
	}

	public Double getBusivalue() {
		return busivalue;
	}

	public void setBusivalue(Double busivalue) {
		this.busivalue = busivalue;
	}

	public String getCalcmonth() {
		return calcmonth;
	}

	public void setCalcmonth(String calcmonth) {
		this.calcmonth = calcmonth;
	}

	public String getCalcopnid() {
		return calcopnid;
	}

	public void setCalcopnid(String calcopnid) {
		this.calcopnid = calcopnid;
	}

	public String getCityid() {
		return cityid;
	}

	public void setCityid(String cityid) {
		this.cityid = cityid;
	}

	public java.util.Date getCreattime() {
		return creattime;
	}

	public void setCreattime(java.util.Date creattime) {
		this.creattime = creattime;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getOpnid() {
		return opnid;
	}

	public void setOpnid(String opnid) {
		this.opnid = opnid;
	}

	public String getOprcode() {
		return oprcode;
	}

	public void setOprcode(String oprcode) {
		this.oprcode = oprcode;
	}

	public java.util.Date getOprtime() {
		return oprtime;
	}

	public void setOprtime(java.util.Date oprtime) {
		this.oprtime = oprtime;
	}

	public String getRuleid() {
		return ruleid;
	}

	public void setRuleid(String ruleid) {
		this.ruleid = ruleid;
	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	public String getSrcseq() {
		return srcseq;
	}

	public void setSrcseq(String srcseq) {
		this.srcseq = srcseq;
	}

	public String getWayid() {
		return wayid;
	}

	public void setWayid(String wayid) {
		this.wayid = wayid;
	}

	public String toString() {
        return new ToStringBuilder(this)
            .append("seq", getSeq())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof BbcFaildataqueryVO) ) return false;
        BbcFaildataqueryVO castOther = (BbcFaildataqueryVO) other;
        return new EqualsBuilder()
            .append(this.getSeq(), castOther.getSeq())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getSeq())
            .toHashCode();
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWayname() {
		return wayname;
	}

	public void setWayname(String wayname) {
		this.wayname = wayname;
	}

	public Integer getOssrc() {
		return ossrc;
	}

	public void setOssrc(Integer ossrc) {
		this.ossrc = ossrc;
	}

}
