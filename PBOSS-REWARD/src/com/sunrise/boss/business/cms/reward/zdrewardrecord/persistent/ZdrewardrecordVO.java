package com.sunrise.boss.business.cms.reward.zdrewardrecord.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class ZdrewardrecordVO implements Serializable {

    /** identifier field */
    private Long seq;

    /** nullable persistent field */
    private String calcmonth;

    /** nullable persistent field */
    private String opnid;

    /** nullable persistent field */
    private String name;

    /** nullable persistent field */
    private String wayid;

    /** nullable persistent field */
    private String wayname;

    /** nullable persistent field */
    private String oprcode;

    /** nullable persistent field */
    private String mobile;

    /** nullable persistent field */
    private java.util.Date oprtime;

    /** nullable persistent field */
    private java.util.Date runtime;

    /** nullable persistent field */
    private String ruleid;

    /** nullable persistent field */
    private String resultflag;

    /** nullable persistent field */
    private Short adtflag;

    /** nullable persistent field */
    private String adtcode;

    /** nullable persistent field */
    private String adtremark;

    /** nullable persistent field */
    private String rewardtype;

    /** nullable persistent field */
    private Short rewardflag;

    /** nullable persistent field */
    private String repairmonth;

    /** nullable persistent field */
    private String batchno;

    /** nullable persistent field */
    private String bakinfo;

    /** nullable persistent field */
    private String bakinfo2;

    /** nullable persistent field */
    private Double bakinfo3;

    /** nullable persistent field */
    private Double wrapfee;

    /** nullable persistent field */
    private Short noncyc;

    /** nullable persistent field */
    private Double totalsum;

    /** nullable persistent field */
    private Double paysum;

    /** nullable persistent field */
    private Double paymoney1;

    /** nullable persistent field */
    private Double assegrade2;
    /** nullable persistent field */
    private String prodid;
    /** nullable persistent field */
    private Double bakinfo4;
    /** nullable persistent field */
    private Double bakinfo5;
    /** nullable persistent field */
    private String bakinfo6;
    /** nullable persistent field */
    private String bakinfo7;
    /** nullable persistent field */
    private String bakinfo8;
    /** nullable persistent field */
    private String bakinfo9;
    /** nullable persistent field */
    private String bakinfo10;
    /** full constructor */
    public ZdrewardrecordVO(java.lang.Long seq, java.lang.String calcmonth, java.lang.String opnid, java.lang.String name, java.lang.String wayid, java.lang.String wayname, java.lang.String oprcode, java.lang.String mobile, java.util.Date oprtime, java.util.Date runtime, java.lang.String ruleid, java.lang.String resultflag, java.lang.Short adtflag, java.lang.String adtcode, java.lang.String adtremark, java.lang.String rewardtype, java.lang.Short rewardflag, java.lang.String repairmonth, java.lang.String batchno, java.lang.String bakinfo, java.lang.String bakinfo2, java.lang.Double bakinfo3, java.lang.Double wrapfee, java.lang.Short noncyc, java.lang.Double totalsum, java.lang.Double paysum, java.lang.Double paymoney1,
    		java.lang.Double assegrade2,java.lang.String prodid,java.lang.Double bakinfo4,java.lang.Double bakinfo5,java.lang.String bakinfo6,java.lang.String bakinfo7,java.lang.String bakinfo8,java.lang.String bakinfo9,java.lang.String bakinfo10) {
        this.seq = seq;
        this.calcmonth = calcmonth;
        this.opnid = opnid;
        this.name = name;
        this.wayid = wayid;
        this.wayname = wayname;
        this.oprcode = oprcode;
        this.mobile = mobile;
        this.oprtime = oprtime;
        this.runtime = runtime;
        this.ruleid = ruleid;
        this.resultflag = resultflag;
        this.adtflag = adtflag;
        this.adtcode = adtcode;
        this.adtremark = adtremark;
        this.rewardtype = rewardtype;
        this.rewardflag = rewardflag;
        this.repairmonth = repairmonth;
        this.batchno = batchno;
        this.bakinfo = bakinfo;
        this.bakinfo2 = bakinfo2;
        this.bakinfo3 = bakinfo3;
        this.wrapfee = wrapfee;
        this.noncyc = noncyc;
        this.totalsum = totalsum;
        this.paysum = paysum;
        this.paymoney1 = paymoney1;
        this.bakinfo4 = bakinfo4;
        this.bakinfo5 = bakinfo5;
        this.bakinfo6 = bakinfo6;
        this.bakinfo7 = bakinfo7;
        this.bakinfo8 = bakinfo8;
        this.bakinfo9 = bakinfo9;
        this.bakinfo10 = bakinfo10;
        this.assegrade2 = assegrade2;
        this.prodid = prodid;
    }

    /** default constructor */
    public ZdrewardrecordVO() {
    }

    /** minimal constructor */
    public ZdrewardrecordVO(java.lang.Long seq) {
        this.seq = seq;
    }

    public java.lang.Long getSeq() {
        return this.seq;
    }

    public void setSeq(java.lang.Long seq) {
        this.seq = seq;
    }

    public java.lang.String getCalcmonth() {
        return this.calcmonth;
    }

    public void setCalcmonth(java.lang.String calcmonth) {
        this.calcmonth = calcmonth;
    }

    public java.lang.String getOpnid() {
        return this.opnid;
    }

    public void setOpnid(java.lang.String opnid) {
        this.opnid = opnid;
    }

    public java.lang.String getName() {
        return this.name;
    }

    public void setName(java.lang.String name) {
        this.name = name;
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.String getWayname() {
        return this.wayname;
    }

    public void setWayname(java.lang.String wayname) {
        this.wayname = wayname;
    }

    public java.lang.String getOprcode() {
        return this.oprcode;
    }

    public void setOprcode(java.lang.String oprcode) {
        this.oprcode = oprcode;
    }

    public java.lang.String getMobile() {
        return this.mobile;
    }

    public void setMobile(java.lang.String mobile) {
        this.mobile = mobile;
    }

    public java.util.Date getOprtime() {
        return this.oprtime;
    }

    public void setOprtime(java.util.Date oprtime) {
        this.oprtime = oprtime;
    }

    public java.util.Date getRuntime() {
        return this.runtime;
    }

    public void setRuntime(java.util.Date runtime) {
        this.runtime = runtime;
    }

    public java.lang.String getRuleid() {
        return this.ruleid;
    }

    public void setRuleid(java.lang.String ruleid) {
        this.ruleid = ruleid;
    }

    public java.lang.String getResultflag() {
        return this.resultflag;
    }

    public void setResultflag(java.lang.String resultflag) {
        this.resultflag = resultflag;
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

    public java.lang.String getRewardtype() {
        return this.rewardtype;
    }

    public void setRewardtype(java.lang.String rewardtype) {
        this.rewardtype = rewardtype;
    }

    public java.lang.Short getRewardflag() {
        return this.rewardflag;
    }

    public void setRewardflag(java.lang.Short rewardflag) {
        this.rewardflag = rewardflag;
    }

    public java.lang.String getRepairmonth() {
        return this.repairmonth;
    }

    public void setRepairmonth(java.lang.String repairmonth) {
        this.repairmonth = repairmonth;
    }

    public java.lang.String getBatchno() {
        return this.batchno;
    }

    public void setBatchno(java.lang.String batchno) {
        this.batchno = batchno;
    }

    public java.lang.String getBakinfo() {
        return this.bakinfo;
    }

    public void setBakinfo(java.lang.String bakinfo) {
        this.bakinfo = bakinfo;
    }

    public java.lang.String getBakinfo2() {
        return this.bakinfo2;
    }

    public void setBakinfo2(java.lang.String bakinfo2) {
        this.bakinfo2 = bakinfo2;
    }

    public java.lang.Double getBakinfo3() {
        return this.bakinfo3;
    }

    public void setBakinfo3(java.lang.Double bakinfo3) {
        this.bakinfo3 = bakinfo3;
    }

    public java.lang.Double getWrapfee() {
        return this.wrapfee;
    }

    public void setWrapfee(java.lang.Double wrapfee) {
        this.wrapfee = wrapfee;
    }

    public java.lang.Short getNoncyc() {
        return this.noncyc;
    }

    public void setNoncyc(java.lang.Short noncyc) {
        this.noncyc = noncyc;
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

    public java.lang.Double getPaymoney1() {
        return this.paymoney1;
    }

    public void setPaymoney1(java.lang.Double paymoney1) {
        this.paymoney1 = paymoney1;
    }

	public String getProdid() {
		return prodid;
	}

	public void setProdid(String prodid) {
		this.prodid = prodid;
	}

	public Double getAssegrade2() {
		return assegrade2;
	}

	public void setAssegrade2(Double assegrade2) {
		this.assegrade2 = assegrade2;
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

	public String toString() {
        return new ToStringBuilder(this)
            .append("seq", getSeq())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ZdrewardrecordVO) ) return false;
        ZdrewardrecordVO castOther = (ZdrewardrecordVO) other;
        return new EqualsBuilder()
            .append(this.getSeq(), castOther.getSeq())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getSeq())
            .toHashCode();
    }

}
