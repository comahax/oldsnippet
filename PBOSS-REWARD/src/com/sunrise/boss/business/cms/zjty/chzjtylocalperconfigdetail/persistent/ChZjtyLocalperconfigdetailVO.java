package com.sunrise.boss.business.cms.zjty.chzjtylocalperconfigdetail.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class ChZjtyLocalperconfigdetailVO implements Serializable {

    /** identifier field */
    private Long recid;

    /** nullable persistent field */
    private String upperwayname;

    /** nullable persistent field */
    private String cityid;

    /** nullable persistent field */
    private String countyid;

    /** nullable persistent field */
    private String wayid;

    /** nullable persistent field */
    private String wayname;

    /** nullable persistent field */
    private String zjtypersonname;

    /** nullable persistent field */
    private String station;

    /** nullable persistent field */
    private String oprcode;

    /** nullable persistent field */
    private java.util.Date regdate;

    /** nullable persistent field */
    private String certification;

    /** nullable persistent field */
    private Long tel;

    /** nullable persistent field */
    private String rewardreporttime;

    /** full constructor */
    public ChZjtyLocalperconfigdetailVO(java.lang.Long recid, java.lang.String upperwayname, java.lang.String cityid, java.lang.String countyid, java.lang.String wayid, java.lang.String wayname, java.lang.String zjtypersonname, java.lang.String station, java.lang.String oprcode, java.util.Date regdate, java.lang.String certification, java.lang.Long tel, java.lang.String rewardreporttime) {
        this.recid = recid;
        this.upperwayname = upperwayname;
        this.cityid = cityid;
        this.countyid = countyid;
        this.wayid = wayid;
        this.wayname = wayname;
        this.zjtypersonname = zjtypersonname;
        this.station = station;
        this.oprcode = oprcode;
        this.regdate = regdate;
        this.certification = certification;
        this.tel = tel;
        this.rewardreporttime = rewardreporttime;
    }

    /** default constructor */
    public ChZjtyLocalperconfigdetailVO() {
    }

    /** minimal constructor */
    public ChZjtyLocalperconfigdetailVO(java.lang.Long recid) {
        this.recid = recid;
    }

    public java.lang.Long getRecid() {
        return this.recid;
    }

    public void setRecid(java.lang.Long recid) {
        this.recid = recid;
    }

    public java.lang.String getUpperwayname() {
        return this.upperwayname;
    }

    public void setUpperwayname(java.lang.String upperwayname) {
        this.upperwayname = upperwayname;
    }

    public java.lang.String getCityid() {
        return this.cityid;
    }

    public void setCityid(java.lang.String cityid) {
        this.cityid = cityid;
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

    public java.lang.String getZjtypersonname() {
        return this.zjtypersonname;
    }

    public void setZjtypersonname(java.lang.String zjtypersonname) {
        this.zjtypersonname = zjtypersonname;
    }

    public java.lang.String getStation() {
        return this.station;
    }

    public void setStation(java.lang.String station) {
        this.station = station;
    }

    public java.lang.String getOprcode() {
        return this.oprcode;
    }

    public void setOprcode(java.lang.String oprcode) {
        this.oprcode = oprcode;
    }

    public java.util.Date getRegdate() {
        return this.regdate;
    }

    public void setRegdate(java.util.Date regdate) {
        this.regdate = regdate;
    }

    public java.lang.String getCertification() {
        return this.certification;
    }

    public void setCertification(java.lang.String certification) {
        this.certification = certification;
    }

    public java.lang.Long getTel() {
        return this.tel;
    }

    public void setTel(java.lang.Long tel) {
        this.tel = tel;
    }

    public java.lang.String getRewardreporttime() {
        return this.rewardreporttime;
    }

    public void setRewardreporttime(java.lang.String rewardreporttime) {
        this.rewardreporttime = rewardreporttime;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("recid", getRecid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ChZjtyLocalperconfigdetailVO) ) return false;
        ChZjtyLocalperconfigdetailVO castOther = (ChZjtyLocalperconfigdetailVO) other;
        return new EqualsBuilder()
            .append(this.getRecid(), castOther.getRecid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getRecid())
            .toHashCode();
    }

}
