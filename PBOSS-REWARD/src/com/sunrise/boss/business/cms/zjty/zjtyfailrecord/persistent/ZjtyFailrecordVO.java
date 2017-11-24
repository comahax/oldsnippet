package com.sunrise.boss.business.cms.zjty.zjtyfailrecord.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class ZjtyFailrecordVO implements Serializable {

    /** identifier field */
    private Long seq;

    /** nullable persistent field */
    private String srcseq;

    /** nullable persistent field */
    private String cityid;

    /** persistent field */
    private String opnid;

    /** persistent field */
    private String wayid;

    /** nullable persistent field */
    private String oprcode;

    /** nullable persistent field */
    private java.util.Date oprtime;

    /** persistent field */
    private String mobile;

    /** nullable persistent field */
    private Double busivalue;

    /** nullable persistent field */
    private Short brand;

    /** persistent field */
    private java.util.Date creattime;

    /** nullable persistent field */
    private String src;

    /** persistent field */
    private String ruleid;

    /** persistent field */
    private String ruleitemid;

    /** nullable persistent field */
    private String adtcode;

    /** nullable persistent field */
    private String adtremark;

    /** nullable persistent field */
    private String oid;

    /** nullable persistent field */
    private Short noncyc;

    /** nullable persistent field */
    private String batchno;

    /** nullable persistent field */
    private String calcopnid;

    /** nullable persistent field */
    private String calcmonth;

    /** nullable persistent field */
    private java.util.Date adtttime;

    /** nullable persistent field */
    private Short adtflag;
    
    private Short rewardtype;

    private String bakinfo;
    
    private String bakinfo2;
    
    private Double bakinfo3;
    
    private Double wrapfee;
    private String prodid;
    private Double bakinfo4;
    private Double bakinfo5;
    private String bakinfo6;
    private String bakinfo7;
    private String bakinfo8;
    private String bakinfo9;
    private String bakinfo10;  
    
    /** full constructor */
    public ZjtyFailrecordVO(java.lang.Long seq, java.lang.String srcseq, java.lang.String cityid, java.lang.String opnid, java.lang.String wayid, java.lang.String oprcode, java.util.Date oprtime, java.lang.String mobile, java.lang.Double busivalue, java.lang.Short brand, java.util.Date creattime, java.lang.String src, java.lang.String ruleid, java.lang.String ruleitemid, java.lang.String adtcode, java.lang.String adtremark, java.lang.String oid, java.lang.Short noncyc, java.lang.String batchno, java.lang.String calcopnid, java.lang.String calcmonth, java.util.Date adtttime, java.lang.Short adtflag, java.lang.Short rewardtype, java.lang.String bakinfo, java.lang.String bakinfo2, java.lang.Double bakinfo3, java.lang.Double wrapfee,String prodid,
    		Double bakinfo4, Double bakinfo5,String bakinfo6, String bakinfo7, String bakinfo8, String bakinfo9, String bakinfo10) {
        this.seq = seq;
        this.srcseq = srcseq;
        this.cityid = cityid;
        this.opnid = opnid;
        this.wayid = wayid;
        this.oprcode = oprcode;
        this.oprtime = oprtime;
        this.mobile = mobile;
        this.busivalue = busivalue;
        this.brand = brand;
        this.creattime = creattime;
        this.src = src;
        this.ruleid = ruleid;
        this.ruleitemid = ruleitemid;
        this.adtcode = adtcode;
        this.adtremark = adtremark;
        this.oid = oid;
        this.noncyc = noncyc;
        this.batchno = batchno;
        this.calcopnid = calcopnid;
        this.calcmonth = calcmonth;
        this.adtttime = adtttime;
        this.adtflag = adtflag;
        this.rewardtype = rewardtype;
        this.bakinfo = bakinfo;
        this.bakinfo2 = bakinfo2;
        this.bakinfo3 = bakinfo3;
        this.wrapfee = wrapfee;
        this.prodid = prodid;
        this.bakinfo4 = bakinfo4;
        this.bakinfo5 = bakinfo5;
        this.bakinfo6 = bakinfo6;
        this.bakinfo7 = bakinfo7;
        this.bakinfo8 = bakinfo8;
        this.bakinfo9 = bakinfo9;
        this.bakinfo10 = bakinfo10;
    }

    /** default constructor */
    public ZjtyFailrecordVO() {
    }

    /** minimal constructor */
    public ZjtyFailrecordVO(java.lang.Long seq, java.lang.String opnid, java.lang.String wayid, java.lang.String mobile, java.util.Date creattime, java.lang.String ruleid, java.lang.String ruleitemid) {
        this.seq = seq;
        this.opnid = opnid;
        this.wayid = wayid;
        this.mobile = mobile;
        this.creattime = creattime;
        this.ruleid = ruleid;
        this.ruleitemid = ruleitemid;
    }

    public java.lang.Long getSeq() {
        return this.seq;
    }

    public void setSeq(java.lang.Long seq) {
        this.seq = seq;
    }

    public java.lang.String getSrcseq() {
        return this.srcseq;
    }

    public void setSrcseq(java.lang.String srcseq) {
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

    public java.lang.Short getBrand() {
        return this.brand;
    }

    public void setBrand(java.lang.Short brand) {
        this.brand = brand;
    }

    public java.util.Date getCreattime() {
        return this.creattime;
    }

    public void setCreattime(java.util.Date creattime) {
        this.creattime = creattime;
    }

    public java.lang.String getSrc() {
        return this.src;
    }

    public void setSrc(java.lang.String src) {
        this.src = src;
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

    public java.lang.String getOid() {
        return this.oid;
    }

    public void setOid(java.lang.String oid) {
        this.oid = oid;
    }

    public java.lang.Short getNoncyc() {
        return this.noncyc;
    }

    public void setNoncyc(java.lang.Short noncyc) {
        this.noncyc = noncyc;
    }

    public java.lang.String getBatchno() {
        return this.batchno;
    }

    public void setBatchno(java.lang.String batchno) {
        this.batchno = batchno;
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

    public java.util.Date getAdtttime() {
        return this.adtttime;
    }

    public void setAdtttime(java.util.Date adtttime) {
        this.adtttime = adtttime;
    }

    public java.lang.Short getAdtflag() {
        return this.adtflag;
    }

    public void setAdtflag(java.lang.Short adtflag) {
        this.adtflag = adtflag;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("seq", getSeq())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ZjtyFailrecordVO) ) return false;
        ZjtyFailrecordVO castOther = (ZjtyFailrecordVO) other;
        return new EqualsBuilder()
            .append(this.getSeq(), castOther.getSeq())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getSeq())
            .toHashCode();
    }

	public String getBakinfo() {
		return bakinfo;
	}

	public void setBakinfo(String bakinfo) {
		this.bakinfo = bakinfo;
	}

	public String getBakinfo2() {
		return bakinfo2;
	}

	public void setBakinfo2(String bakinfo2) {
		this.bakinfo2 = bakinfo2;
	}

	public Double getBakinfo3() {
		return bakinfo3;
	}

	public void setBakinfo3(Double bakinfo3) {
		this.bakinfo3 = bakinfo3;
	}

	public Short getRewardtype() {
		return rewardtype;
	}

	public void setRewardtype(Short rewardtype) {
		this.rewardtype = rewardtype;
	}

	public Double getWrapfee() {
		return wrapfee;
	}

	public void setWrapfee(Double wrapfee) {
		this.wrapfee = wrapfee;
	}

	public String getProdid() {
		return prodid;
	}

	public void setProdid(String prodid) {
		this.prodid = prodid;
	}

	public Double getBakinfo4() {
		return bakinfo4;
	}

	public void setBakinfo4(Double bakinfo4) {
		this.bakinfo4 = bakinfo4;
	}

	public Double getBakinfo5() {
		return bakinfo5;
	}

	public void setBakinfo5(Double bakinfo5) {
		this.bakinfo5 = bakinfo5;
	}

	public String getBakinfo6() {
		return bakinfo6;
	}

	public void setBakinfo6(String bakinfo6) {
		this.bakinfo6 = bakinfo6;
	}

	public String getBakinfo7() {
		return bakinfo7;
	}

	public void setBakinfo7(String bakinfo7) {
		this.bakinfo7 = bakinfo7;
	}

	public String getBakinfo8() {
		return bakinfo8;
	}

	public void setBakinfo8(String bakinfo8) {
		this.bakinfo8 = bakinfo8;
	}

	public String getBakinfo9() {
		return bakinfo9;
	}

	public void setBakinfo9(String bakinfo9) {
		this.bakinfo9 = bakinfo9;
	}

	public String getBakinfo10() {
		return bakinfo10;
	}

	public void setBakinfo10(String bakinfo10) {
		this.bakinfo10 = bakinfo10;
	}

}
