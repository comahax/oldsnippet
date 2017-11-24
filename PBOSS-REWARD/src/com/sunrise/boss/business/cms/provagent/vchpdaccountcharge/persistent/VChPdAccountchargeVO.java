package com.sunrise.boss.business.cms.provagent.vchpdaccountcharge.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class VChPdAccountchargeVO implements Serializable {

    /** identifier field */
    private Long chargeid;

    /** nullable persistent field */
    private String cityid;

    /** nullable persistent field */
    private String prodno;

    /** persistent field */
    private String provagentid;

    /** nullable persistent field */
    private String prodid;

    /** nullable persistent field */
    private String custname;

    /** nullable persistent field */
    private Double chargemoney;

    /** nullable persistent field */
    private String feemonth;

    /** nullable persistent field */
    private java.util.Date incomstime;

    /** nullable persistent field */
    private Short phase;

    /** nullable persistent field */
    private String srcfile;

    /** nullable persistent field */
    private Long rewardid;

    /** full constructor */
    public VChPdAccountchargeVO(java.lang.Long chargeid, java.lang.String cityid, java.lang.String prodno, java.lang.String provagentid, java.lang.String prodid, java.lang.String custname, java.lang.Double chargemoney, java.lang.String feemonth, java.util.Date incomstime, java.lang.Short phase, java.lang.String srcfile, java.lang.Long rewardid) {
        this.chargeid = chargeid;
        this.cityid = cityid;
        this.prodno = prodno;
        this.provagentid = provagentid;
        this.prodid = prodid;
        this.custname = custname;
        this.chargemoney = chargemoney;
        this.feemonth = feemonth;
        this.incomstime = incomstime;
        this.phase = phase;
        this.srcfile = srcfile;
        this.rewardid = rewardid;
    }

    /** default constructor */
    public VChPdAccountchargeVO() {
    }

    /** minimal constructor */
    public VChPdAccountchargeVO(java.lang.Long chargeid, java.lang.String provagentid) {
        this.chargeid = chargeid;
        this.provagentid = provagentid;
    }

    public java.lang.Long getChargeid() {
        return this.chargeid;
    }

    public void setChargeid(java.lang.Long chargeid) {
        this.chargeid = chargeid;
    }

    public java.lang.String getCityid() {
        return this.cityid;
    }

    public void setCityid(java.lang.String cityid) {
        this.cityid = cityid;
    }

    public java.lang.String getProdno() {
        return this.prodno;
    }

    public void setProdno(java.lang.String prodno) {
        this.prodno = prodno;
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

    public java.lang.String getCustname() {
        return this.custname;
    }

    public void setCustname(java.lang.String custname) {
        this.custname = custname;
    }

    public java.lang.Double getChargemoney() {
        return this.chargemoney;
    }

    public void setChargemoney(java.lang.Double chargemoney) {
        this.chargemoney = chargemoney;
    }

    public java.lang.String getFeemonth() {
        return this.feemonth;
    }

    public void setFeemonth(java.lang.String feemonth) {
        this.feemonth = feemonth;
    }

    public java.util.Date getIncomstime() {
        return this.incomstime;
    }

    public void setIncomstime(java.util.Date incomstime) {
        this.incomstime = incomstime;
    }

    public java.lang.Short getPhase() {
        return this.phase;
    }

    public void setPhase(java.lang.Short phase) {
        this.phase = phase;
    }

    public java.lang.String getSrcfile() {
        return this.srcfile;
    }

    public void setSrcfile(java.lang.String srcfile) {
        this.srcfile = srcfile;
    }

    public java.lang.Long getRewardid() {
        return this.rewardid;
    }

    public void setRewardid(java.lang.Long rewardid) {
        this.rewardid = rewardid;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("chargeid", getChargeid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof VChPdAccountchargeVO) ) return false;
        VChPdAccountchargeVO castOther = (VChPdAccountchargeVO) other;
        return new EqualsBuilder()
            .append(this.getChargeid(), castOther.getChargeid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getChargeid())
            .toHashCode();
    }

}
