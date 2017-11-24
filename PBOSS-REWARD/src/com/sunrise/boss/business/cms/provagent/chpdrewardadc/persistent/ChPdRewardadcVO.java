package com.sunrise.boss.business.cms.provagent.chpdrewardadc.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class ChPdRewardadcVO implements Serializable {

    /** identifier field */
    private Long rewardid;

    /** nullable persistent field */
    private String cityid;

    /** nullable persistent field */
    private String provagentid;

    /** nullable persistent field */
    private String prodid;

    /** nullable persistent field */
    private String custid;

    /** nullable persistent field */
    private String custname;

    /** nullable persistent field */
    private String prodno;

    /** nullable persistent field */
    private Double rewardmoney;

    /** nullable persistent field */
    private Short phase;

    /** nullable persistent field */
    private Double supplemoney;

    /** nullable persistent field */
    private Double rpmoney;

    /** nullable persistent field */
    private String inbossmonth;

    /** nullable persistent field */
    private String rewardmonth;

    /** nullable persistent field */
    private String reason;

    /** nullable persistent field */
    private String version;

    /** nullable persistent field */
    private String ruledesc;

    /** nullable persistent field */
    private Byte isreleaseadc;

    /** full constructor */
    public ChPdRewardadcVO(java.lang.Long rewardid, java.lang.String cityid, java.lang.String provagentid, java.lang.String prodid, java.lang.String custid, java.lang.String custname, java.lang.String prodno, java.lang.Double rewardmoney, java.lang.Short phase, java.lang.Double supplemoney, java.lang.Double rpmoney, java.lang.String inbossmonth, java.lang.String rewardmonth, java.lang.String reason, java.lang.String version, java.lang.String ruledesc, java.lang.Byte isreleaseadc) {
        this.rewardid = rewardid;
        this.cityid = cityid;
        this.provagentid = provagentid;
        this.prodid = prodid;
        this.custid = custid;
        this.custname = custname;
        this.prodno = prodno;
        this.rewardmoney = rewardmoney;
        this.phase = phase;
        this.supplemoney = supplemoney;
        this.rpmoney = rpmoney;
        this.inbossmonth = inbossmonth;
        this.rewardmonth = rewardmonth;
        this.reason = reason;
        this.version = version;
        this.ruledesc = ruledesc;
        this.isreleaseadc = isreleaseadc;
    }

    /** default constructor */
    public ChPdRewardadcVO() {
    }

    /** minimal constructor */
    public ChPdRewardadcVO(java.lang.Long rewardid) {
        this.rewardid = rewardid;
    }

    public java.lang.Long getRewardid() {
        return this.rewardid;
    }

    public void setRewardid(java.lang.Long rewardid) {
        this.rewardid = rewardid;
    }

    public java.lang.String getCityid() {
        return this.cityid;
    }

    public void setCityid(java.lang.String cityid) {
        this.cityid = cityid;
    }

    public java.lang.String getProvagentid() {
        return this.provagentid;
    }

    public void setProvagentid(java.lang.String provagentid) {
        this.provagentid = provagentid;
    }

    public java.lang.String getProdid() {
        return this.prodid;
    }

    public void setProdid(java.lang.String prodid) {
        this.prodid = prodid;
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

    public java.lang.String getProdno() {
        return this.prodno;
    }

    public void setProdno(java.lang.String prodno) {
        this.prodno = prodno;
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

    public java.lang.Double getSupplemoney() {
        return this.supplemoney;
    }

    public void setSupplemoney(java.lang.Double supplemoney) {
        this.supplemoney = supplemoney;
    }

    public java.lang.Double getRpmoney() {
        return this.rpmoney;
    }

    public void setRpmoney(java.lang.Double rpmoney) {
        this.rpmoney = rpmoney;
    }

    public java.lang.String getInbossmonth() {
        return this.inbossmonth;
    }

    public void setInbossmonth(java.lang.String inbossmonth) {
        this.inbossmonth = inbossmonth;
    }

    public java.lang.String getRewardmonth() {
        return this.rewardmonth;
    }

    public void setRewardmonth(java.lang.String rewardmonth) {
        this.rewardmonth = rewardmonth;
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

    public java.lang.Byte getIsreleaseadc() {
        return this.isreleaseadc;
    }

    public void setIsreleaseadc(java.lang.Byte isreleaseadc) {
        this.isreleaseadc = isreleaseadc;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("rewardid", getRewardid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ChPdRewardadcVO) ) return false;
        ChPdRewardadcVO castOther = (ChPdRewardadcVO) other;
        return new EqualsBuilder()
            .append(this.getRewardid(), castOther.getRewardid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getRewardid())
            .toHashCode();
    }

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	} 

}
