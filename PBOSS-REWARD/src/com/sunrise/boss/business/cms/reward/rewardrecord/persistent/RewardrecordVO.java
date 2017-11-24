package com.sunrise.boss.business.cms.reward.rewardrecord.persistent;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class RewardrecordVO implements Serializable {

	
    /** identifier field */
    private Long rewardlistid;

    /** nullable persistent field */
    private Long operseq;

    /** nullable persistent field */
    private String opnid;

    /** nullable persistent field */
    private String wayid;

    /** nullable persistent field */
    private String wayoprcode;

    /** nullable persistent field */
    private Short slv;

    /** nullable persistent field */
    private Long rewardid;

    /** nullable persistent field */
    private Short rewardtype;

    /** nullable persistent field */
    private String rewardmonth;

    /** nullable persistent field */
    private Short isbudget;

    /** nullable persistent field */
    private Double totalsum;

    /** nullable persistent field */
    private Double paysum;

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
    private java.util.Date runtime;
    
    /** nullable persistent field */
    private Short acctype;
    
    /** nullable persistent field */
    private String mobile;
    
    /** nullable persistent field */
    private Double rewardstd;
    
    private String rewardstdnew;
    
    private Double assegrade;
    
    private String opermobile;
    
    private Date oprtime;
    
    private Double busivalue;
    
    private Short rewardflag;
    
    private String repairmonth;
    
    private Long relateid;
    
    private String batchno;
    
    private Short noncyc;
    
    private String  ruleid;
    
    private String bakinfo;
    
    private String bakinfo2;
    
    private Double bakinfo3;
    
	/** identifier field */
    private Long seqid;

    /** nullable persistent field */
    private Double sumbusivalue;

    /** nullable persistent field */
    private Double sumpaysum;

    /** nullable persistent field */
    private Double sumpaymoney;

    private String rewardtypename;
    
    private Double wrapfee;
    
    private String adjustkind;
    
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
    
    public Double getWrapfee() {
		return wrapfee;
	}

	public void setWrapfee(Double wrapfee) {
		this.wrapfee = wrapfee;
	}
    
	public Long getSeqid() {
		return seqid;
	}

	public void setSeqid(Long seqid) {
		this.seqid = seqid;
	}

	public Double getSumbusivalue() {
		return sumbusivalue;
	}

	public void setSumbusivalue(Double sumbusivalue) {
		this.sumbusivalue = sumbusivalue;
	}

	public Double getSumpaysum() {
		return sumpaysum;
	}

	public void setSumpaysum(Double sumpaysum) {
		this.sumpaysum = sumpaysum;
	}

	public Double getSumpaymoney() {
		return sumpaymoney;
	}

	public void setSumpaymoney(Double sumpaymoney) {
		this.sumpaymoney = sumpaymoney;
	}

	public String getRewardtypename() {
		return rewardtypename;
	}

	public void setRewardtypename(String rewardtypename) {
		this.rewardtypename = rewardtypename;
	}

	public String getBakinfo() {
		return bakinfo;
	}

	public void setBakinfo(String bakinfo) {
		this.bakinfo = bakinfo;
	}

	public Double getAssegrade() {
		return assegrade;
	}

	public Date getOprtime() {
		return oprtime;
	}

	public void setOprtime(Date oprtime) {
		this.oprtime = oprtime;
	}

	public Double getBusivalue() {
		return busivalue;
	}

	public void setBusivalue(Double busivalue) {
		this.busivalue = busivalue;
	}

	public Short getRewardflag() {
		return rewardflag;
	}

	public void setRewardflag(Short rewardflag) {
		this.rewardflag = rewardflag;
	}

	public String getRepairmonth() {
		return repairmonth;
	}

	public void setRepairmonth(String repairmonth) {
		this.repairmonth = repairmonth;
	}

	public Long getRelateid() {
		return relateid;
	}

	public void setRelateid(Long relateid) {
		this.relateid = relateid;
	}

	public String getBatchno() {
		return batchno;
	}

	public void setBatchno(String batchno) {
		this.batchno = batchno;
	}

	public void setAssegrade(Double assegrade) {
		this.assegrade = assegrade;
	}

	public String getOpermobile() {
		return opermobile;
	}

	public void setOpermobile(String opermobile) {
		this.opermobile = opermobile;
	}

	public String getRewardstdnew() {
		return rewardstdnew;
	}

	public void setRewardstdnew(String rewardstdnew) {
		this.rewardstdnew = rewardstdnew;
	}

	/** full constructor */
    public RewardrecordVO(java.lang.Long rewardlistid, java.lang.Long operseq, java.lang.String opnid, java.lang.String wayid, java.lang.String wayoprcode, java.lang.Short slv, java.lang.Long rewardid, java.lang.Short rewardtype, java.lang.String rewardmonth, java.lang.Short isbudget, java.lang.Double totalsum, java.lang.Double paysum, java.lang.String paymonth1, java.lang.Double paymoney1, java.lang.String paymonth2, java.lang.Double paymoney2, java.lang.String paymonth3, java.lang.Double paymoney3, java.util.Date runtime,java.lang.String mobile,java.lang.Double rewardstd,java.lang.Double assegrade,java.lang.String opermobile,Date oprtime,Double busivalue,Short rewardflag,String repairmonth,Long relateid,String batchno,String rewardstdnew,
    		String bakinfo2,Double bakinfo3,Double wrapfee, String adjustkind, Double assegrade2, Short adtflag ,String prodid,
    		Double bakinfo4, Double bakinfo5,String bakinfo6, String bakinfo7, String bakinfo8, String bakinfo9, String bakinfo10,String ruleid) {
        this.rewardlistid = rewardlistid;
        this.operseq = operseq;
        this.opnid = opnid;
        this.wayid = wayid;
        this.wayoprcode = wayoprcode;
        this.slv = slv;
        this.rewardid = rewardid;
        this.rewardtype = rewardtype;
        this.rewardmonth = rewardmonth;
        this.isbudget = isbudget;
        this.totalsum = totalsum;
        this.paysum = paysum;
        this.paymonth1 = paymonth1;
        this.paymoney1 = paymoney1;
        this.paymonth2 = paymonth2;
        this.paymoney2 = paymoney2;
        this.paymonth3 = paymonth3;
        this.paymoney3 = paymoney3;
        this.runtime = runtime;
        this.mobile=mobile;
        this.rewardstd=rewardstd;
        this.assegrade=assegrade;
        this.opermobile=opermobile;
        this.oprtime=oprtime;
        this.busivalue=busivalue;
        this.rewardflag=rewardflag;
        this.repairmonth=repairmonth;
        this.relateid=relateid;
        this.batchno=batchno;
        this.rewardstdnew = rewardstdnew;
        this.bakinfo2 = bakinfo2;
        this.bakinfo3 = bakinfo3;
        this.wrapfee = wrapfee;
        this.adjustkind = adjustkind;
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
        this.ruleid= ruleid;
    }

    /** default constructor */
    public RewardrecordVO() {
    }

    /** minimal constructor */
    public RewardrecordVO(java.lang.Long rewardlistid) {
        this.rewardlistid = rewardlistid;
    }

    public java.lang.Long getRewardlistid() {
        return this.rewardlistid;
    }

    public Double getRewardstd() {
		return rewardstd;
	}

	public void setRewardstd(Double rewardstd) {
		this.rewardstd = rewardstd;
	}
    
    public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
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

    public java.lang.Short getSlv() {
        return this.slv;
    }

    public void setSlv(java.lang.Short slv) {
        this.slv = slv;
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

    public java.util.Date getRuntime() {
        return this.runtime;
    }

    public void setRuntime(java.util.Date runtime) {
        this.runtime = runtime;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("rewardlistid", getRewardlistid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof RewardrecordVO) ) return false;
        RewardrecordVO castOther = (RewardrecordVO) other;
        return new EqualsBuilder()
            .append(this.getRewardlistid(), castOther.getRewardlistid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getRewardlistid())
            .toHashCode();
    }

	public Short getAcctype() {
		return acctype;
	}

	public void setAcctype(Short acctype) {
		this.acctype = acctype;
	}

	public Short getNoncyc() {
		return noncyc;
	}

	public void setNoncyc(Short noncyc) {
		this.noncyc = noncyc;
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

	public String getAdjustkind() {
		return adjustkind;
	}

	public void setAdjustkind(String adjustkind) {
		this.adjustkind = adjustkind;
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

	public String getRuleid() {
		return ruleid;
	}

	public void setRuleid(String ruleid) {
		this.ruleid = ruleid;
	}


	
}
