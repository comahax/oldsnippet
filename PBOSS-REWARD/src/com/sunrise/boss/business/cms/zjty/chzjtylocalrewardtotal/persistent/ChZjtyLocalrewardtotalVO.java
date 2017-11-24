package com.sunrise.boss.business.cms.zjty.chzjtylocalrewardtotal.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class ChZjtyLocalrewardtotalVO implements Serializable {

    /** identifier field */
    private Long recid;

    /** nullable persistent field */
    private String wayname;

    /** nullable persistent field */
    private String companytype;

    /** nullable persistent field */
    private String cityid;

    /** nullable persistent field */
    private String zjtyname;

    /** nullable persistent field */
    private String wayid;

    /** nullable persistent field */
    private Double gdreward;

    /** nullable persistent field */
    private Double jjreward;

    /** nullable persistent field */
    private Double cereward;

    /** nullable persistent field */
    private Double ywkj;

    /** nullable persistent field */
    private Double total;

    /** nullable persistent field */
    private String rewardreporttime;

    /** full constructor */
    public ChZjtyLocalrewardtotalVO(java.lang.Long recid, java.lang.String wayname, java.lang.String companytype, java.lang.String cityid, java.lang.String zjtyname, java.lang.String wayid, java.lang.Double gdreward, java.lang.Double jjreward, java.lang.Double cereward, java.lang.Double ywkj, java.lang.Double total, java.lang.String rewardreporttime) {
        this.recid = recid;
        this.wayname = wayname;
        this.companytype = companytype;
        this.cityid = cityid;
        this.zjtyname = zjtyname;
        this.wayid = wayid;
        this.gdreward = gdreward;
        this.jjreward = jjreward;
        this.cereward = cereward;
        this.ywkj = ywkj;
        this.total = total;
        this.rewardreporttime = rewardreporttime;
    }

    /** default constructor */
    public ChZjtyLocalrewardtotalVO() {
    }

    /** minimal constructor */
    public ChZjtyLocalrewardtotalVO(java.lang.Long recid) {
        this.recid = recid;
    }

    public java.lang.Long getRecid() {
        return this.recid;
    }

    public void setRecid(java.lang.Long recid) {
        this.recid = recid;
    }

    public java.lang.String getWayname() {
        return this.wayname;
    }

    public void setWayname(java.lang.String wayname) {
        this.wayname = wayname;
    }

    public java.lang.String getCompanytype() {
        return this.companytype;
    }

    public void setCompanytype(java.lang.String companytype) {
        this.companytype = companytype;
    }

    public java.lang.String getCityid() {
        return this.cityid;
    }

    public void setCityid(java.lang.String cityid) {
        this.cityid = cityid;
    }

    public java.lang.String getZjtyname() {
        return this.zjtyname;
    }

    public void setZjtyname(java.lang.String zjtyname) {
        this.zjtyname = zjtyname;
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.Double getGdreward() {
        return this.gdreward;
    }

    public void setGdreward(java.lang.Double gdreward) {
        this.gdreward = gdreward;
    }

    public java.lang.Double getJjreward() {
        return this.jjreward;
    }

    public void setJjreward(java.lang.Double jjreward) {
        this.jjreward = jjreward;
    }

    public java.lang.Double getCereward() {
        return this.cereward;
    }

    public void setCereward(java.lang.Double cereward) {
        this.cereward = cereward;
    }

    public java.lang.Double getYwkj() {
        return this.ywkj;
    }

    public void setYwkj(java.lang.Double ywkj) {
        this.ywkj = ywkj;
    }

    public java.lang.Double getTotal() {
        return this.total;
    }

    public void setTotal(java.lang.Double total) {
        this.total = total;
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
        if ( !(other instanceof ChZjtyLocalrewardtotalVO) ) return false;
        ChZjtyLocalrewardtotalVO castOther = (ChZjtyLocalrewardtotalVO) other;
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
