package com.sunrise.boss.business.cms.zjty.chzjtylocalzdsalereward.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class ChZjtyLocalzdsalerewardVO implements Serializable {

    /** identifier field */
    private Long recid;

    /** nullable persistent field */
    private String wayname;

    /** nullable persistent field */
    private String cityid;

    /** nullable persistent field */
    private String zjtyname;

    /** nullable persistent field */
    private String rewardreporttime;

    /** nullable persistent field */
    private Long dzzdxlhyj;

    /** nullable persistent field */
    private Long dzzdxllhy;

    /** nullable persistent field */
    private Long dzzdxllj;

    /** nullable persistent field */
    private Long dzzdxlhj;

    /** nullable persistent field */
    private Long ysrgdzzdxlhyj;

    /** nullable persistent field */
    private Long ysrgdzzdxllhy;

    /** nullable persistent field */
    private Long ysrgdzzdxllj;

    /** nullable persistent field */
    private Long ysrgdzzdxlhj;

    /** nullable persistent field */
    private Double dzzdcjhyj;

    /** nullable persistent field */
    private Double dzzdcjlhy;

    /** nullable persistent field */
    private Double dzzdcjlj;

    /** nullable persistent field */
    private Double dzzdcjhj;

    /** nullable persistent field */
    private Double ysrgdzzdcjhyj;

    /** nullable persistent field */
    private Double ysrgdzzdcjlhy;

    /** nullable persistent field */
    private Double ysrgdzzdcjlj;

    /** nullable persistent field */
    private Double ysrgdzzdcjhj;

    /** full constructor */
    public ChZjtyLocalzdsalerewardVO(java.lang.Long recid, java.lang.String wayname, java.lang.String cityid, java.lang.String zjtyname, java.lang.String rewardreporttime, java.lang.Long dzzdxlhyj, java.lang.Long dzzdxllhy, java.lang.Long dzzdxllj, java.lang.Long dzzdxlhj, java.lang.Long ysrgdzzdxlhyj, java.lang.Long ysrgdzzdxllhy, java.lang.Long ysrgdzzdxllj, java.lang.Long ysrgdzzdxlhj, java.lang.Double dzzdcjhyj, java.lang.Double dzzdcjlhy, java.lang.Double dzzdcjlj, java.lang.Double dzzdcjhj, java.lang.Double ysrgdzzdcjhyj, java.lang.Double ysrgdzzdcjlhy, java.lang.Double ysrgdzzdcjlj, java.lang.Double ysrgdzzdcjhj) {
        this.recid = recid;
        this.wayname = wayname;
        this.cityid = cityid;
        this.zjtyname = zjtyname;
        this.rewardreporttime = rewardreporttime;
        this.dzzdxlhyj = dzzdxlhyj;
        this.dzzdxllhy = dzzdxllhy;
        this.dzzdxllj = dzzdxllj;
        this.dzzdxlhj = dzzdxlhj;
        this.ysrgdzzdxlhyj = ysrgdzzdxlhyj;
        this.ysrgdzzdxllhy = ysrgdzzdxllhy;
        this.ysrgdzzdxllj = ysrgdzzdxllj;
        this.ysrgdzzdxlhj = ysrgdzzdxlhj;
        this.dzzdcjhyj = dzzdcjhyj;
        this.dzzdcjlhy = dzzdcjlhy;
        this.dzzdcjlj = dzzdcjlj;
        this.dzzdcjhj = dzzdcjhj;
        this.ysrgdzzdcjhyj = ysrgdzzdcjhyj;
        this.ysrgdzzdcjlhy = ysrgdzzdcjlhy;
        this.ysrgdzzdcjlj = ysrgdzzdcjlj;
        this.ysrgdzzdcjhj = ysrgdzzdcjhj;
    }

    /** default constructor */
    public ChZjtyLocalzdsalerewardVO() {
    }

    /** minimal constructor */
    public ChZjtyLocalzdsalerewardVO(java.lang.Long recid) {
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

    public java.lang.String getRewardreporttime() {
        return this.rewardreporttime;
    }

    public void setRewardreporttime(java.lang.String rewardreporttime) {
        this.rewardreporttime = rewardreporttime;
    }

    public java.lang.Long getDzzdxlhyj() {
        return this.dzzdxlhyj;
    }

    public void setDzzdxlhyj(java.lang.Long dzzdxlhyj) {
        this.dzzdxlhyj = dzzdxlhyj;
    }

    public java.lang.Long getDzzdxllhy() {
        return this.dzzdxllhy;
    }

    public void setDzzdxllhy(java.lang.Long dzzdxllhy) {
        this.dzzdxllhy = dzzdxllhy;
    }

    public java.lang.Long getDzzdxllj() {
        return this.dzzdxllj;
    }

    public void setDzzdxllj(java.lang.Long dzzdxllj) {
        this.dzzdxllj = dzzdxllj;
    }

    public java.lang.Long getDzzdxlhj() {
        return this.dzzdxlhj;
    }

    public void setDzzdxlhj(java.lang.Long dzzdxlhj) {
        this.dzzdxlhj = dzzdxlhj;
    }

    public java.lang.Long getYsrgdzzdxlhyj() {
        return this.ysrgdzzdxlhyj;
    }

    public void setYsrgdzzdxlhyj(java.lang.Long ysrgdzzdxlhyj) {
        this.ysrgdzzdxlhyj = ysrgdzzdxlhyj;
    }

    public java.lang.Long getYsrgdzzdxllhy() {
        return this.ysrgdzzdxllhy;
    }

    public void setYsrgdzzdxllhy(java.lang.Long ysrgdzzdxllhy) {
        this.ysrgdzzdxllhy = ysrgdzzdxllhy;
    }

    public java.lang.Long getYsrgdzzdxllj() {
        return this.ysrgdzzdxllj;
    }

    public void setYsrgdzzdxllj(java.lang.Long ysrgdzzdxllj) {
        this.ysrgdzzdxllj = ysrgdzzdxllj;
    }

    public java.lang.Long getYsrgdzzdxlhj() {
        return this.ysrgdzzdxlhj;
    }

    public void setYsrgdzzdxlhj(java.lang.Long ysrgdzzdxlhj) {
        this.ysrgdzzdxlhj = ysrgdzzdxlhj;
    }

    public java.lang.Double getDzzdcjhyj() {
        return this.dzzdcjhyj;
    }

    public void setDzzdcjhyj(java.lang.Double dzzdcjhyj) {
        this.dzzdcjhyj = dzzdcjhyj;
    }

    public java.lang.Double getDzzdcjlhy() {
        return this.dzzdcjlhy;
    }

    public void setDzzdcjlhy(java.lang.Double dzzdcjlhy) {
        this.dzzdcjlhy = dzzdcjlhy;
    }

    public java.lang.Double getDzzdcjlj() {
        return this.dzzdcjlj;
    }

    public void setDzzdcjlj(java.lang.Double dzzdcjlj) {
        this.dzzdcjlj = dzzdcjlj;
    }

    public java.lang.Double getDzzdcjhj() {
        return this.dzzdcjhj;
    }

    public void setDzzdcjhj(java.lang.Double dzzdcjhj) {
        this.dzzdcjhj = dzzdcjhj;
    }

    public java.lang.Double getYsrgdzzdcjhyj() {
        return this.ysrgdzzdcjhyj;
    }

    public void setYsrgdzzdcjhyj(java.lang.Double ysrgdzzdcjhyj) {
        this.ysrgdzzdcjhyj = ysrgdzzdcjhyj;
    }

    public java.lang.Double getYsrgdzzdcjlhy() {
        return this.ysrgdzzdcjlhy;
    }

    public void setYsrgdzzdcjlhy(java.lang.Double ysrgdzzdcjlhy) {
        this.ysrgdzzdcjlhy = ysrgdzzdcjlhy;
    }

    public java.lang.Double getYsrgdzzdcjlj() {
        return this.ysrgdzzdcjlj;
    }

    public void setYsrgdzzdcjlj(java.lang.Double ysrgdzzdcjlj) {
        this.ysrgdzzdcjlj = ysrgdzzdcjlj;
    }

    public java.lang.Double getYsrgdzzdcjhj() {
        return this.ysrgdzzdcjhj;
    }

    public void setYsrgdzzdcjhj(java.lang.Double ysrgdzzdcjhj) {
        this.ysrgdzzdcjhj = ysrgdzzdcjhj;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("recid", getRecid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ChZjtyLocalzdsalerewardVO) ) return false;
        ChZjtyLocalzdsalerewardVO castOther = (ChZjtyLocalzdsalerewardVO) other;
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
