package com.sunrise.boss.business.cms.dcord.persistent;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class VDcordVO implements Serializable {

    /** identifier field */
    private Long id;

    /** nullable persistent field */
    private String countyid;

    /** nullable persistent field */
    private String wayid;

    /** nullable persistent field */
    private String wayname;

    /** nullable persistent field */
    private Short starlevel;

    /** nullable persistent field */
    private String opnid;

    /** nullable persistent field */
    private String upperopnid;

    /** nullable persistent field */
    private String subopnid;

    /** nullable persistent field */
    private String oprmonth;

    /** nullable persistent field */
    private Short rewardtype;

    /** nullable persistent field */
    private String rewardmonth;

    /** nullable persistent field */
    private Long gotonebusivalue;

    /** nullable persistent field */
    private Double gotonemoney;

    /** nullable persistent field */
    private Long szxbusivalue;

    /** nullable persistent field */
    private Double szxmoney;

    /** nullable persistent field */
    private Long mzonebusivalue;

    /** nullable persistent field */
    private Double mzonemoney;

    /** nullable persistent field */
    private Long tdbusivalue;

    /** nullable persistent field */
    private Double tdmoney;

    /** nullable persistent field */
    private Long otherbusivalue;

    /** nullable persistent field */
    private Double othermoney;

    /** nullable persistent field */
    private Long busivaluesum;

    /** nullable persistent field */
    private Double moneysum;

    /** nullable persistent field */
    private Short isflag;

    /** nullable persistent field */
    private String adjustoprcode;

    /** nullable persistent field */
    private java.util.Date adjustoptime;

    /** nullable persistent field */
    private String paymentoprcode;

    /** nullable persistent field */
    private java.util.Date paymentoptime;

    /** nullable persistent field */
    private String batchno;

    private String abatchno;
    
    private String paymonth;
    
    /** full constructor */
    public VDcordVO(java.lang.Long id, java.lang.String countyid, java.lang.String wayid, java.lang.String wayname, 
    		java.lang.Short starlevel, java.lang.String opnid, java.lang.String upperopnid, java.lang.String subopnid,
    		java.lang.String oprmonth, java.lang.Short rewardtype, java.lang.String rewardmonth, java.lang.Long gotonebusivalue, 
    		java.lang.Double gotonemoney, java.lang.Long szxbusivalue, java.lang.Double szxmoney, java.lang.Long mzonebusivalue,
    		java.lang.Double mzonemoney, java.lang.Long tdbusivalue, java.lang.Double tdmoney, java.lang.Long otherbusivalue,
    		java.lang.Double othermoney, java.lang.Long busivaluesum, java.lang.Double moneysum, java.lang.Short isflag,
    		java.lang.String adjustoprcode, java.util.Date adjustoptime, java.lang.String paymentoprcode, 
    		java.util.Date paymentoptime, java.lang.String batchno, java.lang.String abatchno) {
        this.id = id;
        this.countyid = countyid;
        this.wayid = wayid;
        this.wayname = wayname;
        this.starlevel = starlevel;
        this.opnid = opnid;
        this.upperopnid = upperopnid;
        this.subopnid = subopnid;
        this.oprmonth = oprmonth;
        this.rewardtype = rewardtype;
        this.rewardmonth = rewardmonth;
        this.gotonebusivalue = gotonebusivalue;
        this.gotonemoney = gotonemoney;
        this.szxbusivalue = szxbusivalue;
        this.szxmoney = szxmoney;
        this.mzonebusivalue = mzonebusivalue;
        this.mzonemoney = mzonemoney;
        this.tdbusivalue = tdbusivalue;
        this.tdmoney = tdmoney;
        this.otherbusivalue = otherbusivalue;
        this.othermoney = othermoney;
        this.busivaluesum = busivaluesum;
        this.moneysum = moneysum;
        this.isflag = isflag;
        this.adjustoprcode = adjustoprcode;
        this.adjustoptime = adjustoptime;
        this.paymentoprcode = paymentoprcode;
        this.paymentoptime = paymentoptime;
        this.batchno = batchno;
        this.abatchno = abatchno;
    }

    public VDcordVO(Long id, String countyid, String wayid, String wayname,
			Short starlevel, String opnid, String upperopnid, String subopnid,
			String oprmonth, Short rewardtype, String rewardmonth,
			Long gotonebusivalue, Double gotonemoney, Long szxbusivalue,
			Double szxmoney, Long mzonebusivalue, Double mzonemoney,
			Long tdbusivalue, Double tdmoney, Long otherbusivalue,
			Double othermoney, Long busivaluesum, Double moneysum,
			Short isflag, String adjustoprcode, Date adjustoptime,
			String paymentoprcode, Date paymentoptime, String batchno,
			String abatchno, String paymonth) {
		super();
		this.id = id;
		this.countyid = countyid;
		this.wayid = wayid;
		this.wayname = wayname;
		this.starlevel = starlevel;
		this.opnid = opnid;
		this.upperopnid = upperopnid;
		this.subopnid = subopnid;
		this.oprmonth = oprmonth;
		this.rewardtype = rewardtype;
		this.rewardmonth = rewardmonth;
		this.gotonebusivalue = gotonebusivalue;
		this.gotonemoney = gotonemoney;
		this.szxbusivalue = szxbusivalue;
		this.szxmoney = szxmoney;
		this.mzonebusivalue = mzonebusivalue;
		this.mzonemoney = mzonemoney;
		this.tdbusivalue = tdbusivalue;
		this.tdmoney = tdmoney;
		this.otherbusivalue = otherbusivalue;
		this.othermoney = othermoney;
		this.busivaluesum = busivaluesum;
		this.moneysum = moneysum;
		this.isflag = isflag;
		this.adjustoprcode = adjustoprcode;
		this.adjustoptime = adjustoptime;
		this.paymentoprcode = paymentoprcode;
		this.paymentoptime = paymentoptime;
		this.batchno = batchno;
		this.abatchno = abatchno;
		this.paymonth = paymonth;
	}

	/** default constructor */
    public VDcordVO() {
    }

    public String getPaymonth() {
		return paymonth;
	}

	public void setPaymonth(String paymonth) {
		this.paymonth = paymonth;
	}

	public String getAbatchno() {
		return abatchno;
	}

	public void setAbatchno(String abatchno) {
		this.abatchno = abatchno;
	}

	/** minimal constructor */
    public VDcordVO(java.lang.Long id) {
        this.id = id;
    }

    public java.lang.Long getId() {
        return this.id;
    }

    public void setId(java.lang.Long id) {
        this.id = id;
    }

    public java.lang.String getCountyid() {
        return this.countyid;
    }

    public void setCountyid(java.lang.String countyid) {
        this.countyid = countyid;
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

    public java.lang.Short getStarlevel() {
        return this.starlevel;
    }

    public void setStarlevel(java.lang.Short starlevel) {
        this.starlevel = starlevel;
    }

    public java.lang.String getOpnid() {
        return this.opnid;
    }

    public void setOpnid(java.lang.String opnid) {
        this.opnid = opnid;
    }

    public java.lang.String getUpperopnid() {
        return this.upperopnid;
    }

    public void setUpperopnid(java.lang.String upperopnid) {
        this.upperopnid = upperopnid;
    }

    public java.lang.String getSubopnid() {
        return this.subopnid;
    }

    public void setSubopnid(java.lang.String subopnid) {
        this.subopnid = subopnid;
    }

    public java.lang.String getOprmonth() {
        return this.oprmonth;
    }

    public void setOprmonth(java.lang.String oprmonth) {
        this.oprmonth = oprmonth;
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

    public java.lang.Long getGotonebusivalue() {
        return this.gotonebusivalue;
    }

    public void setGotonebusivalue(java.lang.Long gotonebusivalue) {
        this.gotonebusivalue = gotonebusivalue;
    }

    public java.lang.Double getGotonemoney() {
        return this.gotonemoney;
    }

    public void setGotonemoney(java.lang.Double gotonemoney) {
        this.gotonemoney = gotonemoney;
    }

    public java.lang.Long getSzxbusivalue() {
        return this.szxbusivalue;
    }

    public void setSzxbusivalue(java.lang.Long szxbusivalue) {
        this.szxbusivalue = szxbusivalue;
    }

    public java.lang.Double getSzxmoney() {
        return this.szxmoney;
    }

    public void setSzxmoney(java.lang.Double szxmoney) {
        this.szxmoney = szxmoney;
    }

    public java.lang.Long getMzonebusivalue() {
        return this.mzonebusivalue;
    }

    public void setMzonebusivalue(java.lang.Long mzonebusivalue) {
        this.mzonebusivalue = mzonebusivalue;
    }

    public java.lang.Double getMzonemoney() {
        return this.mzonemoney;
    }

    public void setMzonemoney(java.lang.Double mzonemoney) {
        this.mzonemoney = mzonemoney;
    }

    public java.lang.Long getTdbusivalue() {
        return this.tdbusivalue;
    }

    public void setTdbusivalue(java.lang.Long tdbusivalue) {
        this.tdbusivalue = tdbusivalue;
    }

    public java.lang.Double getTdmoney() {
        return this.tdmoney;
    }

    public void setTdmoney(java.lang.Double tdmoney) {
        this.tdmoney = tdmoney;
    }

    public java.lang.Long getOtherbusivalue() {
        return this.otherbusivalue;
    }

    public void setOtherbusivalue(java.lang.Long otherbusivalue) {
        this.otherbusivalue = otherbusivalue;
    }

    public java.lang.Double getOthermoney() {
        return this.othermoney;
    }

    public void setOthermoney(java.lang.Double othermoney) {
        this.othermoney = othermoney;
    }

    public java.lang.Long getBusivaluesum() {
        return this.busivaluesum;
    }

    public void setBusivaluesum(java.lang.Long busivaluesum) {
        this.busivaluesum = busivaluesum;
    }

    public java.lang.Double getMoneysum() {
        return this.moneysum;
    }

    public void setMoneysum(java.lang.Double moneysum) {
        this.moneysum = moneysum;
    }

    public java.lang.Short getIsflag() {
        return this.isflag;
    }

    public void setIsflag(java.lang.Short isflag) {
        this.isflag = isflag;
    }

    public java.lang.String getAdjustoprcode() {
        return this.adjustoprcode;
    }

    public void setAdjustoprcode(java.lang.String adjustoprcode) {
        this.adjustoprcode = adjustoprcode;
    }

    public java.util.Date getAdjustoptime() {
        return this.adjustoptime;
    }

    public void setAdjustoptime(java.util.Date adjustoptime) {
        this.adjustoptime = adjustoptime;
    }

    public java.lang.String getPaymentoprcode() {
        return this.paymentoprcode;
    }

    public void setPaymentoprcode(java.lang.String paymentoprcode) {
        this.paymentoprcode = paymentoprcode;
    }

    public java.util.Date getPaymentoptime() {
        return this.paymentoptime;
    }

    public void setPaymentoptime(java.util.Date paymentoptime) {
        this.paymentoptime = paymentoptime;
    }

    public java.lang.String getBatchno() {
        return this.batchno;
    }

    public void setBatchno(java.lang.String batchno) {
        this.batchno = batchno;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("id", getId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof VDcordVO) ) return false;
        VDcordVO castOther = (VDcordVO) other;
        return new EqualsBuilder()
            .append(this.getId(), castOther.getId())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getId())
            .toHashCode();
    }

}
