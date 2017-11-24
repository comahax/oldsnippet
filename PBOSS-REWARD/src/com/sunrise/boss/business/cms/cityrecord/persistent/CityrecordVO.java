package com.sunrise.boss.business.cms.cityrecord.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class CityrecordVO implements Serializable {

    /** identifier field */
    private Long recordid;

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
    
 
    private String accountoprcode;
    private String adjustoprcode;
    private String paymentoprcode;
    private String batchno;
    private java.util.Date accountoptime;
    private java.util.Date adjustoptime;
    private java.util.Date paymentoptime;
    private Long brand;
    
    private String opnid1;
    private String opnid2;
    private String dictname;
    private String oprmonth;
    private String sumbusivalue;
    private String sumpaymoney;
    private String sumconfirmmoney;
    private String sumnotconfirmmoney;
    private String sumpaysum;
    
  //模拟设置一下，到后面一条处理的就是3条
    private String threedelegate;
    
    private  java.lang.Long dcordid;
    private String  paymonth;
	public String getSumpaysum() {
		return sumpaysum;
	}

	public void setSumpaysum(String sumpaysum) {
		this.sumpaysum = sumpaysum;
	}

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

	public String getSumbusivalue() {
		return sumbusivalue;
	}

	public void setSumbusivalue(String sumbusivalue) {
		this.sumbusivalue = sumbusivalue;
	}

	public String getSumpaymoney() {
		return sumpaymoney;
	}

	public void setSumpaymoney(String sumpaymoney) {
		this.sumpaymoney = sumpaymoney;
	}

	public String getSumconfirmmoney() {
		return sumconfirmmoney;
	}

	public void setSumconfirmmoney(String sumconfirmmoney) {
		this.sumconfirmmoney = sumconfirmmoney;
	}

	public String getSumnotconfirmmoney() {
		return sumnotconfirmmoney;
	}

	public void setSumnotconfirmmoney(String sumnotconfirmmoney) {
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
    public CityrecordVO(java.lang.String opnid, java.lang.String wayid, java.lang.Short rewardtype, java.lang.String rewardmonth, java.lang.String mobile, java.util.Date oprtime, java.lang.Double busivalue, java.lang.Double paysum, java.lang.Double paymoney, java.lang.String approveid, java.lang.Short isflag, java.lang.String oprcode, java.util.Date optime, java.lang.Short systemflag, java.lang.Long rewardlistid,java.lang.String rewardtypename) {
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
    
 
    public CityrecordVO(java.lang.String opnid, java.lang.String wayid, java.lang.Short rewardtype, java.lang.String rewardmonth, java.lang.String mobile, java.util.Date oprtime, java.lang.Double busivalue, java.lang.Double paysum, java.lang.Double paymoney, java.lang.String approveid, java.lang.Short isflag, java.lang.String oprcode, java.util.Date optime, java.lang.Short systemflag, java.lang.Long rewardlistid,java.lang.String rewardtypename
    	,java.lang.String accountoprcode,java.lang.String adjustoprcode,java.lang.String paymentoprcode,java.lang.String batchno,java.util.Date accountoptime,java.util.Date adjustoptime,java.util.Date paymentoptime,java.lang.Long brand ) {
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
        this.accountoprcode = accountoprcode;
        this.adjustoprcode = adjustoprcode;
        this.paymentoprcode = paymentoprcode;
        this.batchno = batchno;
        this.accountoptime = accountoptime;
        this.adjustoptime = adjustoptime;
        this.paymentoptime = paymentoptime;
        this.brand = brand;
    }

    /** default constructor */
    public CityrecordVO() {
    }

    public java.lang.Long getRecordid() {
        return this.recordid;
    }

    public void setRecordid(java.lang.Long recordid) {
        this.recordid = recordid;
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
            .append("recordid", getRecordid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CityrecordVO) ) return false;
        CityrecordVO castOther = (CityrecordVO) other;
        return new EqualsBuilder()
            .append(this.getRecordid(), castOther.getRecordid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getRecordid())
            .toHashCode();
    }

	public String getAccountoprcode() {
		return accountoprcode;
	}

	public void setAccountoprcode(String accountoprcode) {
		this.accountoprcode = accountoprcode;
	}

	public String getAdjustoprcode() {
		return adjustoprcode;
	}

	public void setAdjustoprcode(String adjustoprcode) {
		this.adjustoprcode = adjustoprcode;
	}

	public String getPaymentoprcode() {
		return paymentoprcode;
	}

	public void setPaymentoprcode(String paymentoprcode) {
		this.paymentoprcode = paymentoprcode;
	}

	public String getBatchno() {
		return batchno;
	}

	public void setBatchno(String batchno) {
		this.batchno = batchno;
	}

	public java.util.Date getAccountoptime() {
		return accountoptime;
	}

	public void setAccountoptime(java.util.Date accountoptime) {
		this.accountoptime = accountoptime;
	}

	public java.util.Date getAdjustoptime() {
		return adjustoptime;
	}

	public void setAdjustoptime(java.util.Date adjustoptime) {
		this.adjustoptime = adjustoptime;
	}

	public java.util.Date getPaymentoptime() {
		return paymentoptime;
	}

	public void setPaymentoptime(java.util.Date paymentoptime) {
		this.paymentoptime = paymentoptime;
	}

	public Long getBrand() {
		return brand;
	}

	public void setBrand(Long brand) {
		this.brand = brand;
	}

	public java.lang.Long getDcordid() {
		return dcordid;
	}

	public void setDcordid(java.lang.Long dcordid) {
		this.dcordid = dcordid;
	}

	public String getPaymonth() {
		return paymonth;
	}

	public void setPaymonth(String paymonth) {
		this.paymonth = paymonth;
	} 

}
