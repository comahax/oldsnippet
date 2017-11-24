package com.sunrise.boss.business.cms.provagent.chpdrewardrecord.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class ChPdRewardrecordVO implements Serializable {

    /** identifier field */
    private Long rewardid;

    /** nullable persistent field */
    private String provagentid;

    /** nullable persistent field */
    private String prodno;

    /** nullable persistent field */
    private String custid;

    /** nullable persistent field */
    private String custname;

    /** nullable persistent field */
    private String cityid;

    /** nullable persistent field */
    private String rewardmonth;

    /** nullable persistent field */
    private Double rewardmoney;

    /** nullable persistent field */
    private Short phase;

    /** nullable persistent field */
    private String feemonth;

    /** nullable persistent field */
    private String version;

    /** nullable persistent field */
    private String ruledesc;

    /** nullable persistent field */
    private java.util.Date caltime;

    /** nullable persistent field */
    private String inbossmonth;

    /** nullable persistent field */
    private Long adcrewardid;

    /** nullable persistent field */
    private String recalmonth;

    /** nullable persistent field */
    private String memo; 
     
    private String prodid;
    
    private String prodname;
    /** full constructor */
    public ChPdRewardrecordVO(java.lang.Long rewardid, java.lang.String provagentid, java.lang.String prodno, java.lang.String custid,
    		java.lang.String custname, java.lang.String cityid, java.lang.String rewardmonth, java.lang.Double rewardmoney, 
    		java.lang.Short phase, java.lang.String feemonth, java.lang.String version, java.lang.String ruledesc,
    		java.util.Date caltime, java.lang.String inbossmonth, java.lang.Long adcrewardid, java.lang.String recalmonth, 
    		java.lang.String memo,java.lang.String prodid,java.lang.String prodname) {
        this.rewardid = rewardid;
        this.provagentid = provagentid;
        this.prodno = prodno;
        this.custid = custid;
        this.custname = custname;
        this.cityid = cityid;
        this.rewardmonth = rewardmonth;
        this.rewardmoney = rewardmoney;
        this.phase = phase;
        this.feemonth = feemonth;
        this.version = version;
        this.ruledesc = ruledesc;
        this.caltime = caltime;
        this.inbossmonth = inbossmonth;
        this.adcrewardid = adcrewardid;
        this.recalmonth = recalmonth;
        this.memo = memo;
        this.prodid = prodid;
        this.prodname = prodname;
    }

    /** default constructor */
    public ChPdRewardrecordVO() {
    }

    /** minimal constructor */
    public ChPdRewardrecordVO(java.lang.Long rewardid) {
        this.rewardid = rewardid;
    }

    public java.lang.Long getRewardid() {
        return this.rewardid;
    }

    public void setRewardid(java.lang.Long rewardid) {
        this.rewardid = rewardid;
    }

    public java.lang.String getProvagentid() {
        return this.provagentid;
    }

    public void setProvagentid(java.lang.String provagentid) {
        this.provagentid = provagentid;
    }

    public java.lang.String getProdno() {
        return this.prodno;
    }

    public void setProdno(java.lang.String prodno) {
        this.prodno = prodno;
    }

    public java.lang.String getCustid() {
        return this.custid;
    }

    public void setCustid(java.lang.String custid) {
        this.custid = custid;
    }

    public java.lang.String getCustname() {
        return this.custname;
    }

    public void setCustname(java.lang.String custname) {
        this.custname = custname;
    }

    public java.lang.String getCityid() {
        return this.cityid;
    }

    public void setCityid(java.lang.String cityid) {
        this.cityid = cityid;
    }

    public java.lang.String getRewardmonth() {
        return this.rewardmonth;
    }

    public void setRewardmonth(java.lang.String rewardmonth) {
        this.rewardmonth = rewardmonth;
    }

    public java.lang.Double getRewardmoney() {
        return this.rewardmoney;
    }

    public void setRewardmoney(java.lang.Double rewardmoney) {
        this.rewardmoney = rewardmoney;
    }

    public java.lang.Short getPhase() {
        return this.phase;
    }

    public void setPhase(java.lang.Short phase) {
        this.phase = phase;
    }

    public java.lang.String getFeemonth() {
        return this.feemonth;
    }

    public void setFeemonth(java.lang.String feemonth) {
        this.feemonth = feemonth;
    }

    public java.lang.String getVersion() {
        return this.version;
    }

    public void setVersion(java.lang.String version) {
        this.version = version;
    }

    public java.lang.String getRuledesc() {
        return this.ruledesc;
    }

    public void setRuledesc(java.lang.String ruledesc) {
        this.ruledesc = ruledesc;
    }

    public java.util.Date getCaltime() {
        return this.caltime;
    }

    public void setCaltime(java.util.Date caltime) {
        this.caltime = caltime;
    }

    public java.lang.String getInbossmonth() {
        return this.inbossmonth;
    }

    public void setInbossmonth(java.lang.String inbossmonth) {
        this.inbossmonth = inbossmonth;
    }

    public java.lang.Long getAdcrewardid() {
        return this.adcrewardid;
    }

    public void setAdcrewardid(java.lang.Long adcrewardid) {
        this.adcrewardid = adcrewardid;
    }

    public java.lang.String getRecalmonth() {
        return this.recalmonth;
    }

    public void setRecalmonth(java.lang.String recalmonth) {
        this.recalmonth = recalmonth;
    }

    public java.lang.String getMemo() {
        return this.memo;
    }

    public void setMemo(java.lang.String memo) {
        this.memo = memo;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("rewardid", getRewardid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ChPdRewardrecordVO) ) return false;
        ChPdRewardrecordVO castOther = (ChPdRewardrecordVO) other;
        return new EqualsBuilder()
            .append(this.getRewardid(), castOther.getRewardid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getRewardid())
            .toHashCode();
    }

	public String getProdid() {
		return prodid;
	}

	public void setProdid(String prodid) {
		this.prodid = prodid;
	}

	public String getProdname() {
		return prodname;
	}

	public void setProdname(String prodname) {
		this.prodname = prodname;
	}

}
