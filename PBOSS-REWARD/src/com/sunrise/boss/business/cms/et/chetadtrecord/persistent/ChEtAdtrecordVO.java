package com.sunrise.boss.business.cms.et.chetadtrecord.persistent;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class ChEtAdtrecordVO implements Serializable {

    /** identifier field */
    private Long seq;

    /** identifier field */
    private Long srcseq;

    /** nullable persistent field */
    private Long oid;

    /** persistent field */
    private String opnid;

    /** persistent field */
    private String calcmonth;

    /** persistent field */
    private String wayid;

    /** nullable persistent field */
    private String oprcode;

    /** nullable persistent field */
    private java.util.Date oprtime;

    /** persistent field */
    private String mobile;

    /** persistent field */
    private Long subsid;

    /** nullable persistent field */
    private String brand;

    /** nullable persistent field */
    private Long yxplanid;
    
    /** nullable persistent field */
    private java.util.Date startdate;

    /** persistent field */
    private String ruleid;

    /** nullable persistent field */
    private String ruleitemid;
    
    /** nullable persistent field */
    private Short noncyc;
    
    /** nullable persistent field */
    private Long batchno;
    
    /** nullable persistent field */
    private String adtcode;
    
    /** nullable persistent field */
    private String adtremark;
    
    /** nullable persistent field */
    private String src;
    
    /** nullable persistent field */
    private Short adtflag;
    
    /** nullable persistent field */
    private java.util.Date createtime;
    
    /** nullable persistent field */
    private String bakinfo;
    
    private String texe1;
    private String texe2;
    private String texe3;
    private String texe4;
    private String texe5;
    private String texe6;
    private String texe7;
    private String texe8;
    
	/** full constructor */
    /*public ChEtAdtrecordVO(java.lang.Long seq, java.lang.Long srcseq, java.lang.Long oid,
    		java.lang.String opnid, java.lang.String calcmonth, java.lang.String wayid, 
    		java.lang.String oprcode, java.util.Date oprtime, java.lang.String mobile, 
    		java.lang.Long subsid, java.lang.String brand, java.lang.Integer busivalue, java.lang.Long yxplanid, java.lang.Double wrapfee,
    		java.util.Date startdate, java.lang.String ruleid, java.lang.String ruleitemid, java.lang.Short rewardtype, java.lang.Double rewardstd,
    		java.lang.Short noncyc, java.lang.Long batchno, java.lang.String adtcode, java.lang.String adtremark, java.lang.String dsrc, java.lang.String bakinfo, java.lang.String bakinfo2, java.lang.String bakinfo3, java.lang.Short adtflag, java.util.Date createtime, java.lang.Long rewardid, java.lang.Short acctype, java.lang.Float assegrade, java.lang.Double totalsum, java.lang.Double paysum, java.lang.String paymonth1, java.lang.Double paymoney1, java.lang.String paymonth2, java.lang.Double paymoney2, java.lang.String paymonth3, 
    		java.lang.Double paymoney3,java.lang.Long isbudget,java.lang.String src) {
        this.seq = seq;
        this.srcseq = srcseq;
        this.oid = oid;
        this.opnid = opnid;
        this.calcmonth = calcmonth;
        this.wayid = wayid;
        this.oprcode = oprcode;
        this.oprtime = oprtime;
        this.mobile = mobile;
        this.subsid = subsid;
        this.brand = brand;
        this.busivalue = busivalue;
        this.yxplanid = yxplanid;
        this.wrapfee = wrapfee;
        this.startdate = startdate;
        this.ruleid = ruleid;
        this.ruleitemid = ruleitemid;
        this.rewardtype = rewardtype;
        this.rewardstd = rewardstd;
        this.noncyc = noncyc;
        this.batchno = batchno;
        this.adtcode = adtcode;
        this.adtremark = adtremark; 
        this.dsrc = dsrc;
        this.bakinfo = bakinfo;
        this.bakinfo2 = bakinfo2;
        this.bakinfo3 = bakinfo3;
        this.adtflag = adtflag;
        this.createtime = createtime;
        this.rewardid = rewardid;
        this.acctype = acctype;
        this.assegrade = assegrade;
        this.totalsum = totalsum;
        this.paysum = paysum;
        this.paymonth1 = paymonth1;
        this.paymoney1 = paymoney1;
        this.paymonth2 = paymonth2;
        this.paymoney2 = paymoney2;
        this.paymonth3 = paymonth3;
        this.paymoney3 = paymoney3;
        this.isbudget = isbudget;
        this.src = src;
    }*/

    /** default constructor */
    public ChEtAdtrecordVO() {
    }

    /** minimal constructor */
    public ChEtAdtrecordVO(java.lang.Long seq, java.lang.Long srcseq, java.lang.String opnid, java.lang.String calcmonth, java.lang.String wayid, 
    		java.lang.String mobile, java.lang.Long subsid, java.lang.String ruleid) {
        this.seq = seq;
        this.srcseq = srcseq;
        this.opnid = opnid;
        this.calcmonth = calcmonth;
        this.wayid = wayid;
        this.mobile = mobile;
        this.subsid = subsid;
        this.ruleid = ruleid;
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

    public java.lang.Long getOid() {
        return this.oid;
    }

    public void setOid(java.lang.Long oid) {
        this.oid = oid;
    }

    public java.lang.String getOpnid() {
        return this.opnid;
    }

    public void setOpnid(java.lang.String opnid) {
        this.opnid = opnid;
    }

    public java.lang.String getCalcmonth() {
        return this.calcmonth;
    }

    public void setCalcmonth(java.lang.String calcmonth) {
        this.calcmonth = calcmonth;
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

    public java.lang.Long getSubsid() {
        return this.subsid;
    }

    public void setSubsid(java.lang.Long subsid) {
        this.subsid = subsid;
    }

    public java.lang.String getBrand() {
        return this.brand;
    }

    public void setBrand(java.lang.String brand) {
        this.brand = brand;
    }

    public java.lang.Long getYxplanid() {
        return this.yxplanid;
    }

    public void setYxplanid(java.lang.Long yxplanid) {
        this.yxplanid = yxplanid;
    }

    public java.util.Date getStartdate() {
        return this.startdate;
    }

    public void setStartdate(java.util.Date startdate) {
        this.startdate = startdate;
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

    public java.lang.Short getNoncyc() {
        return this.noncyc;
    }

    public void setNoncyc(java.lang.Short noncyc) {
        this.noncyc = noncyc;
    }

    public java.lang.Long getBatchno() {
        return this.batchno;
    }

    public void setBatchno(java.lang.Long batchno) {
        this.batchno = batchno;
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

    public java.lang.String getBakinfo() {
        return this.bakinfo;
    }

    public void setBakinfo(java.lang.String bakinfo) {
        this.bakinfo = bakinfo;
    }

    public java.lang.Short getAdtflag() {
        return this.adtflag;
    }

    public void setAdtflag(java.lang.Short adtflag) {
        this.adtflag = adtflag;
    }

    public java.util.Date getCreatetime() {
        return this.createtime;
    }

    public void setCreatetime(java.util.Date createtime) {
        this.createtime = createtime;
    }

    public String toString() {
    	return new ToStringBuilder(this)
        .append("seq", getSeq())
        .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ChEtAdtrecordVO) ) return false;
        ChEtAdtrecordVO castOther = (ChEtAdtrecordVO) other;
        return new EqualsBuilder()
            .append(this.getSeq(), castOther.getSeq())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getSeq())
            .toHashCode();
    }

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	public String getTexe1() {
		return texe1;
	}

	public void setTexe1(String texe1) {
		this.texe1 = texe1;
	}

	public String getTexe2() {
		return texe2;
	}

	public void setTexe2(String texe2) {
		this.texe2 = texe2;
	}

	public String getTexe3() {
		return texe3;
	}

	public void setTexe3(String texe3) {
		this.texe3 = texe3;
	}

	public String getTexe4() {
		return texe4;
	}

	public void setTexe4(String texe4) {
		this.texe4 = texe4;
	}

	public String getTexe5() {
		return texe5;
	}

	public void setTexe5(String texe5) {
		this.texe5 = texe5;
	}

	public String getTexe6() {
		return texe6;
	}

	public void setTexe6(String texe6) {
		this.texe6 = texe6;
	}

	public String getTexe7() {
		return texe7;
	}

	public void setTexe7(String texe7) {
		this.texe7 = texe7;
	}

	public String getTexe8() {
		return texe8;
	}

	public void setTexe8(String texe8) {
		this.texe8 = texe8;
	}

}
