package com.sunrise.boss.business.cms.cityrecord.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class VCityrecordVO implements Serializable {

    /** identifier field */
    private Long seqid;

    /** nullable persistent field */
    private String opnid;

    /** nullable persistent field */
    private String wayid;

    /** nullable persistent field */
    private Short rewardtype;

    /** nullable persistent field */
    private String rewardmonth;

    /** nullable persistent field */
    private String mobile;

    /** nullable persistent field */
    private java.util.Date oprtime;

    /** nullable persistent field */
    private Double busivalue;

    /** nullable persistent field */
    private Double paysum;
    
    private Double paymoney;

    /** nullable persistent field */
    private String approveid;

    /** nullable persistent field */
    private Short isflag;

    /** nullable persistent field */
    private String oprcode;

    /** nullable persistent field */
    private java.util.Date optime;

    /** nullable persistent field */
    private Short systemflag;

    /** nullable persistent field */
    private Long rewardlistid;
    
    private String rewardtypename;
    
    private Long taskid;
    
    private String opnid1;
    private String opnid2;
    private String dictname;
    private String oprmonth;
    private Double sumbusivalue;
    private Double sumpaymoney;
    private Double sumconfirmmoney;
    private Double sumnotconfirmmoney;
    
  //模拟设置一下，到后面一条处理的就是3条
    private String threedelegate;
    

	public String getOpnid1() {
		return opnid1;
	}

	public void setOpnid1(String opnid1) {
		this.opnid1 = opnid1;
	}

	public String getOpnid2() {
		return opnid2;
	}

	public void setOpnid2(String opnid2) {
		this.opnid2 = opnid2;
	}

	public String getDictname() {
		return dictname;
	}

	public void setDictname(String dictname) {
		this.dictname = dictname;
	}

	public String getOprmonth() {
		return oprmonth;
	}

	public void setOprmonth(String oprmonth) {
		this.oprmonth = oprmonth;
	}

	public Double getSumbusivalue() {
		return sumbusivalue;
	}

	public void setSumbusivalue(Double sumbusivalue) {
		this.sumbusivalue = sumbusivalue;
	}

	public Double getSumpaymoney() {
		return sumpaymoney;
	}

	public void setSumpaymoney(Double sumpaymoney) {
		this.sumpaymoney = sumpaymoney;
	}

	public Double getSumconfirmmoney() {
		return sumconfirmmoney;
	}

	public void setSumconfirmmoney(Double sumconfirmmoney) {
		this.sumconfirmmoney = sumconfirmmoney;
	}

	public Double getSumnotconfirmmoney() {
		return sumnotconfirmmoney;
	}

	public void setSumnotconfirmmoney(Double sumnotconfirmmoney) {
		this.sumnotconfirmmoney = sumnotconfirmmoney;
	}

	public String getThreedelegate() {
		return threedelegate;
	}

	public void setThreedelegate(String threedelegate) {
		this.threedelegate = threedelegate;
	}

	public Long getTaskid() {
		return taskid;
	}

	public void setTaskid(Long taskid) {
		this.taskid = taskid;
	}

	/** full constructor */
    public VCityrecordVO(java.lang.String opnid, java.lang.String wayid, java.lang.Short rewardtype, java.lang.String rewardmonth, java.lang.String mobile, java.util.Date oprtime, java.lang.Double busivalue, java.lang.Double paysum, java.lang.Double paymoney, java.lang.String approveid, java.lang.Short isflag, java.lang.String oprcode, java.util.Date optime, java.lang.Short systemflag, java.lang.Long rewardlistid,java.lang.String rewardtypename) {
        this.opnid = opnid;
        this.wayid = wayid;
        this.rewardtype = rewardtype;
        this.rewardmonth = rewardmonth;
        this.mobile = mobile;
        this.oprtime = oprtime;
        this.busivalue = busivalue;
        this.paysum = paysum;
        this.paymoney = paymoney;
        this.approveid = approveid;
        this.isflag = isflag;
        this.oprcode = oprcode;
        this.optime = optime;
        this.systemflag = systemflag;
        this.rewardlistid = rewardlistid;
        this.rewardtypename = rewardtypename;
    }

    public Long getSeqid() {
		return seqid;
	}

	public void setSeqid(Long seqid) {
		this.seqid = seqid;
	}

	/** default constructor */
    public VCityrecordVO() {
    }

//    public java.lang.Long getRecordid() {
//        return this.recordid;
//    }
//
//    public void setRecordid(java.lang.Long recordid) {
//        this.recordid = recordid;
//    }

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

    public java.lang.Double getBusivalue() {
        return this.busivalue;
    }

    public void setBusivalue(java.lang.Double busivalue) {
        this.busivalue = busivalue;
    }

    public java.lang.Double getPaysum() {
        return this.paysum;
    }

    public void setPaysum(java.lang.Double paysum) {
        this.paysum = paysum;
    }

    public Double getPaymoney() {
		return paymoney;
	}

	public void setPaymoney(Double paymoney) {
		this.paymoney = paymoney;
	}

	public java.lang.String getApproveid() {
        return this.approveid;
    }

    public void setApproveid(java.lang.String approveid) {
        this.approveid = approveid;
    }

    public java.lang.Short getIsflag() {
        return this.isflag;
    }

    public void setIsflag(java.lang.Short isflag) {
        this.isflag = isflag;
    }

    public java.lang.String getOprcode() {
        return this.oprcode;
    }

    public void setOprcode(java.lang.String oprcode) {
        this.oprcode = oprcode;
    }

    public java.util.Date getOptime() {
        return this.optime;
    }

    public void setOptime(java.util.Date optime) {
        this.optime = optime;
    }

    public java.lang.Short getSystemflag() {
        return this.systemflag;
    }

    public void setSystemflag(java.lang.Short systemflag) {
        this.systemflag = systemflag;
    }

    public java.lang.Long getRewardlistid() {
        return this.rewardlistid;
    }

    public void setRewardlistid(java.lang.Long rewardlistid) {
        this.rewardlistid = rewardlistid;
    }

    public String getRewardtypename() {
		return rewardtypename;
	}

	public void setRewardtypename(String rewardtypename) {
		this.rewardtypename = rewardtypename;
	}

	public String toString() {
        return new ToStringBuilder(this)
            .append("seqid", getSeqid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof VCityrecordVO) ) return false;
        VCityrecordVO castOther = (VCityrecordVO) other;
        return new EqualsBuilder()
            .append(this.getSeqid(), castOther.getSeqid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getSeqid())
            .toHashCode();
    }

}
