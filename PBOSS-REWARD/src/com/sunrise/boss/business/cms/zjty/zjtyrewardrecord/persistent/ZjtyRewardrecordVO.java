package com.sunrise.boss.business.cms.zjty.zjtyrewardrecord.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class ZjtyRewardrecordVO implements Serializable {

    /** identifier field */
    private Long rewardlistid;

    /** persistent field */
    private Long operseq;

    /** nullable persistent field */
    private String opnid;

    /** nullable persistent field */
    private String wayid;

    /** nullable persistent field */
    private String wayoprcode;

    /** nullable persistent field */
    private Double totalsum;

    /** nullable persistent field */
    private Double paysum;

    /** nullable persistent field */
    private Float coef1;

    /** nullable persistent field */
    private Float coef2;

    /** nullable persistent field */
    private Float coef3;

    /** nullable persistent field */
    private Float coef4;

    /** nullable persistent field */
    private String batchno;

    /** nullable persistent field */
    private java.util.Date runtime;

    /** persistent field */
    private String mobile;

    /** nullable persistent field */
    private String oid;

    /** persistent field */
    private String ruleid;

    /** nullable persistent field */
    private Long rewardid;

    /** nullable persistent field */
    private Short rewardtype;

    /** nullable persistent field */
    private Double rewardstd;

    /** nullable persistent field */
    private String rewardmonth;

    /** nullable persistent field */
    private Short isbudget;

    /** nullable persistent field */
    private String paymonth1;

    /** nullable persistent field */
    private Double paymoney1;

    /** nullable persistent field */
    private String paymonth2;

    /** nullable persistent field */
    private Double paymoney2;

    /** nullable persistent field */
    private String paymonth3;

    /** nullable persistent field */
    private Double paymoney3;

    /** nullable persistent field */
    private Short acctype;

    /** nullable persistent field */
    private Float assegrade;

    /** nullable persistent field */
    private java.util.Date oprtime;

    /** nullable persistent field */
    private Double busivalue;

    /** nullable persistent field */
    private Short rewardflag;

    /** nullable persistent field */
    private Short noncyc;
    
    private String bakinfo;
    
    private String bakinfo2;
    
    private Double bakinfo3;
    
    private Double wrapfee;
    
    private Double assegrade2;
    
    private Short adtflag;
    
    private String prodid;
    private Double bakinfo4;
    private Double bakinfo5;
    private String bakinfo6;
    private String bakinfo7;
    private String bakinfo8;
    private String bakinfo9;
    private String bakinfo10;  

    /** full constructor */
    public ZjtyRewardrecordVO(java.lang.Long rewardlistid, java.lang.Long operseq, java.lang.String opnid, java.lang.String wayid, java.lang.String wayoprcode, java.lang.Double totalsum, java.lang.Double paysum, java.lang.Float coef1, java.lang.Float coef2, java.lang.Float coef3, java.lang.Float coef4, java.lang.String batchno, java.util.Date runtime, java.lang.String mobile, java.lang.String oid, java.lang.String ruleid, java.lang.Long rewardid, java.lang.Short rewardtype, java.lang.Double rewardstd, java.lang.String rewardmonth, java.lang.Short isbudget, java.lang.String paymonth1, java.lang.Double paymoney1, java.lang.String paymonth2, java.lang.Double paymoney2, java.lang.String paymonth3, java.lang.Double paymoney3, java.lang.Short acctype, java.lang.Float assegrade, java.util.Date oprtime, java.lang.Double busivalue, java.lang.Short rewardflag, java.lang.Short noncyc, java.lang.String bakinfo, java.lang.String bakinfo2, java.lang.Double bakinfo3, java.lang.Double wrapfee, Double assegrade2, Short adtflag, String prodid,
Double bakinfo4, Double bakinfo5,String bakinfo6, String bakinfo7, String bakinfo8, String bakinfo9, String bakinfo10) {
        this.rewardlistid = rewardlistid;
        this.operseq = operseq;
        this.opnid = opnid;
        this.wayid = wayid;
        this.wayoprcode = wayoprcode;
        this.totalsum = totalsum;
        this.paysum = paysum;
        this.coef1 = coef1;
        this.coef2 = coef2;
        this.coef3 = coef3;
        this.coef4 = coef4;
        this.batchno = batchno;
        this.runtime = runtime;
        this.mobile = mobile;
        this.oid = oid;
        this.ruleid = ruleid;
        this.rewardid = rewardid;
        this.rewardtype = rewardtype;
        this.rewardstd = rewardstd;
        this.rewardmonth = rewardmonth;
        this.isbudget = isbudget;
        this.paymonth1 = paymonth1;
        this.paymoney1 = paymoney1;
        this.paymonth2 = paymonth2;
        this.paymoney2 = paymoney2;
        this.paymonth3 = paymonth3;
        this.paymoney3 = paymoney3;
        this.acctype = acctype;
        this.assegrade = assegrade;
        this.oprtime = oprtime;
        this.busivalue = busivalue;
        this.rewardflag = rewardflag;
        this.noncyc = noncyc;
        this.bakinfo = bakinfo;
        this.bakinfo2 = bakinfo2;
        this.bakinfo3 = bakinfo3;
        this.wrapfee = wrapfee;
        this.assegrade2 = assegrade2;
        this.adtflag = adtflag;
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
    public ZjtyRewardrecordVO() {
    }

    /** minimal constructor */
    public ZjtyRewardrecordVO(java.lang.Long rewardlistid, java.lang.Long operseq, java.lang.String mobile, java.lang.String ruleid) {
        this.rewardlistid = rewardlistid;
        this.operseq = operseq;
        this.mobile = mobile;
        this.ruleid = ruleid;
    }

    public java.lang.Long getRewardlistid() {
        return this.rewardlistid;
    }

    public void setRewardlistid(java.lang.Long rewardlistid) {
        this.rewardlistid = rewardlistid;
    }

    public java.lang.Long getOperseq() {
        return this.operseq;
    }

    public void setOperseq(java.lang.Long operseq) {
        this.operseq = operseq;
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

    public java.lang.String getWayoprcode() {
        return this.wayoprcode;
    }

    public void setWayoprcode(java.lang.String wayoprcode) {
        this.wayoprcode = wayoprcode;
    }

    public java.lang.Double getTotalsum() {
        return this.totalsum;
    }

    public void setTotalsum(java.lang.Double totalsum) {
        this.totalsum = totalsum;
    }

    public java.lang.Double getPaysum() {
        return this.paysum;
    }

    public void setPaysum(java.lang.Double paysum) {
        this.paysum = paysum;
    }

    public java.lang.Float getCoef1() {
        return this.coef1;
    }

    public void setCoef1(java.lang.Float coef1) {
        this.coef1 = coef1;
    }

    public java.lang.Float getCoef2() {
        return this.coef2;
    }

    public void setCoef2(java.lang.Float coef2) {
        this.coef2 = coef2;
    }

    public java.lang.Float getCoef3() {
        return this.coef3;
    }

    public void setCoef3(java.lang.Float coef3) {
        this.coef3 = coef3;
    }

    public java.lang.Float getCoef4() {
        return this.coef4;
    }

    public void setCoef4(java.lang.Float coef4) {
        this.coef4 = coef4;
    }

    public java.lang.String getBatchno() {
        return this.batchno;
    }

    public void setBatchno(java.lang.String batchno) {
        this.batchno = batchno;
    }

    public java.util.Date getRuntime() {
        return this.runtime;
    }

    public void setRuntime(java.util.Date runtime) {
        this.runtime = runtime;
    }

    public java.lang.String getMobile() {
        return this.mobile;
    }

    public void setMobile(java.lang.String mobile) {
        this.mobile = mobile;
    }

    public java.lang.String getOid() {
        return this.oid;
    }

    public void setOid(java.lang.String oid) {
        this.oid = oid;
    }

    public java.lang.String getRuleid() {
        return this.ruleid;
    }

    public void setRuleid(java.lang.String ruleid) {
        this.ruleid = ruleid;
    }

    public java.lang.Long getRewardid() {
        return this.rewardid;
    }

    public void setRewardid(java.lang.Long rewardid) {
        this.rewardid = rewardid;
    }

    public java.lang.Short getRewardtype() {
        return this.rewardtype;
    }

    public void setRewardtype(java.lang.Short rewardtype) {
        this.rewardtype = rewardtype;
    }

    public java.lang.Double getRewardstd() {
        return this.rewardstd;
    }

    public void setRewardstd(java.lang.Double rewardstd) {
        this.rewardstd = rewardstd;
    }

    public java.lang.String getRewardmonth() {
        return this.rewardmonth;
    }

    public void setRewardmonth(java.lang.String rewardmonth) {
        this.rewardmonth = rewardmonth;
    }

    public java.lang.Short getIsbudget() {
        return this.isbudget;
    }

    public void setIsbudget(java.lang.Short isbudget) {
        this.isbudget = isbudget;
    }

    public java.lang.String getPaymonth1() {
        return this.paymonth1;
    }

    public void setPaymonth1(java.lang.String paymonth1) {
        this.paymonth1 = paymonth1;
    }

    public java.lang.Double getPaymoney1() {
        return this.paymoney1;
    }

    public void setPaymoney1(java.lang.Double paymoney1) {
        this.paymoney1 = paymoney1;
    }

    public java.lang.String getPaymonth2() {
        return this.paymonth2;
    }

    public void setPaymonth2(java.lang.String paymonth2) {
        this.paymonth2 = paymonth2;
    }

    public java.lang.Double getPaymoney2() {
        return this.paymoney2;
    }

    public void setPaymoney2(java.lang.Double paymoney2) {
        this.paymoney2 = paymoney2;
    }

    public java.lang.String getPaymonth3() {
        return this.paymonth3;
    }

    public void setPaymonth3(java.lang.String paymonth3) {
        this.paymonth3 = paymonth3;
    }

    public java.lang.Double getPaymoney3() {
        return this.paymoney3;
    }

    public void setPaymoney3(java.lang.Double paymoney3) {
        this.paymoney3 = paymoney3;
    }

    public java.lang.Short getAcctype() {
        return this.acctype;
    }

    public void setAcctype(java.lang.Short acctype) {
        this.acctype = acctype;
    }

    public java.lang.Float getAssegrade() {
        return this.assegrade;
    }

    public void setAssegrade(java.lang.Float assegrade) {
        this.assegrade = assegrade;
    }

    public java.util.Date getOprtime() {
        return this.oprtime;
    }

    public void setOprtime(java.util.Date oprtime) {
        this.oprtime = oprtime;
    }

    public java.lang.Double getBusivalue() {
        return this.busivalue;
    }

    public void setBusivalue(java.lang.Double busivalue) {
        this.busivalue = busivalue;
    }

    public java.lang.Short getRewardflag() {
        return this.rewardflag;
    }

    public void setRewardflag(java.lang.Short rewardflag) {
        this.rewardflag = rewardflag;
    }

    public java.lang.Short getNoncyc() {
        return this.noncyc;
    }

    public void setNoncyc(java.lang.Short noncyc) {
        this.noncyc = noncyc;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("rewardlistid", getRewardlistid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ZjtyRewardrecordVO) ) return false;
        ZjtyRewardrecordVO castOther = (ZjtyRewardrecordVO) other;
        return new EqualsBuilder()
            .append(this.getRewardlistid(), castOther.getRewardlistid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getRewardlistid())
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

	public Double getWrapfee() {
		return wrapfee;
	}

	public void setWrapfee(Double wrapfee) {
		this.wrapfee = wrapfee;
	}

	public Double getAssegrade2() {
		return assegrade2;
	}

	public void setAssegrade2(Double assegrade2) {
		this.assegrade2 = assegrade2;
	}

	public Short getAdtflag() {
		return adtflag;
	}

	public void setAdtflag(Short adtflag) {
		this.adtflag = adtflag;
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
