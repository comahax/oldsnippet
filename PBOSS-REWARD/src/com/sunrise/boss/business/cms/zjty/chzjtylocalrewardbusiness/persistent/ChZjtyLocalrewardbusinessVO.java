package com.sunrise.boss.business.cms.zjty.chzjtylocalrewardbusiness.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class ChZjtyLocalrewardbusinessVO implements Serializable {

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
    private Double qqtxzfh;

    /** nullable persistent field */
    private Double yffzqqt;

    /** nullable persistent field */
    private Double dgddtkxs;

    /** nullable persistent field */
    private Double szxtkxs;

    /** nullable persistent field */
    private Double czyw;

    /** nullable persistent field */
    private Double dzzd;

    /** nullable persistent field */
    private Double zhyw;

    /** nullable persistent field */
    private Double zzyw;

    /** nullable persistent field */
    private Double dgddwlk;

    /** nullable persistent field */
    private Double jtkdkh;

    /** nullable persistent field */
    private Double sjyw;

    /** nullable persistent field */
    private Double jtyw;

    /** nullable persistent field */
    private Double dsgsyxzdlyw;

    /** nullable persistent field */
    private Double total;

    /** nullable persistent field */
    private String rewardreporttime;

    /** full constructor */
    public ChZjtyLocalrewardbusinessVO(java.lang.Long recid, java.lang.String wayname, java.lang.String companytype, java.lang.String cityid, java.lang.String zjtyname, java.lang.Double qqtxzfh, java.lang.Double yffzqqt, java.lang.Double dgddtkxs, java.lang.Double szxtkxs, java.lang.Double czyw, java.lang.Double dzzd, java.lang.Double zhyw, java.lang.Double zzyw, java.lang.Double dgddwlk, java.lang.Double jtkdkh, java.lang.Double sjyw, java.lang.Double jtyw, java.lang.Double dsgsyxzdlyw, java.lang.Double total, java.lang.String rewardreporttime) {
        this.recid = recid;
        this.wayname = wayname;
        this.companytype = companytype;
        this.cityid = cityid;
        this.zjtyname = zjtyname;
        this.qqtxzfh = qqtxzfh;
        this.yffzqqt = yffzqqt;
        this.dgddtkxs = dgddtkxs;
        this.szxtkxs = szxtkxs;
        this.czyw = czyw;
        this.dzzd = dzzd;
        this.zhyw = zhyw;
        this.zzyw = zzyw;
        this.dgddwlk = dgddwlk;
        this.jtkdkh = jtkdkh;
        this.sjyw = sjyw;
        this.jtyw = jtyw;
        this.dsgsyxzdlyw = dsgsyxzdlyw;
        this.total = total;
        this.rewardreporttime = rewardreporttime;
    }

    /** default constructor */
    public ChZjtyLocalrewardbusinessVO() {
    }

    /** minimal constructor */
    public ChZjtyLocalrewardbusinessVO(java.lang.Long recid) {
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

    public java.lang.Double getQqtxzfh() {
        return this.qqtxzfh;
    }

    public void setQqtxzfh(java.lang.Double qqtxzfh) {
        this.qqtxzfh = qqtxzfh;
    }

    public java.lang.Double getYffzqqt() {
        return this.yffzqqt;
    }

    public void setYffzqqt(java.lang.Double yffzqqt) {
        this.yffzqqt = yffzqqt;
    }

    public java.lang.Double getDgddtkxs() {
        return this.dgddtkxs;
    }

    public void setDgddtkxs(java.lang.Double dgddtkxs) {
        this.dgddtkxs = dgddtkxs;
    }

    public java.lang.Double getSzxtkxs() {
        return this.szxtkxs;
    }

    public void setSzxtkxs(java.lang.Double szxtkxs) {
        this.szxtkxs = szxtkxs;
    }

    public java.lang.Double getCzyw() {
        return this.czyw;
    }

    public void setCzyw(java.lang.Double czyw) {
        this.czyw = czyw;
    }

    public java.lang.Double getDzzd() {
        return this.dzzd;
    }

    public void setDzzd(java.lang.Double dzzd) {
        this.dzzd = dzzd;
    }

    public java.lang.Double getZhyw() {
        return this.zhyw;
    }

    public void setZhyw(java.lang.Double zhyw) {
        this.zhyw = zhyw;
    }

    public java.lang.Double getZzyw() {
        return this.zzyw;
    }

    public void setZzyw(java.lang.Double zzyw) {
        this.zzyw = zzyw;
    }

    public java.lang.Double getDgddwlk() {
        return this.dgddwlk;
    }

    public void setDgddwlk(java.lang.Double dgddwlk) {
        this.dgddwlk = dgddwlk;
    }

    public java.lang.Double getJtkdkh() {
        return this.jtkdkh;
    }

    public void setJtkdkh(java.lang.Double jtkdkh) {
        this.jtkdkh = jtkdkh;
    }

    public java.lang.Double getSjyw() {
        return this.sjyw;
    }

    public void setSjyw(java.lang.Double sjyw) {
        this.sjyw = sjyw;
    }

    public java.lang.Double getJtyw() {
        return this.jtyw;
    }

    public void setJtyw(java.lang.Double jtyw) {
        this.jtyw = jtyw;
    }

    public java.lang.Double getDsgsyxzdlyw() {
        return this.dsgsyxzdlyw;
    }

    public void setDsgsyxzdlyw(java.lang.Double dsgsyxzdlyw) {
        this.dsgsyxzdlyw = dsgsyxzdlyw;
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
        if ( !(other instanceof ChZjtyLocalrewardbusinessVO) ) return false;
        ChZjtyLocalrewardbusinessVO castOther = (ChZjtyLocalrewardbusinessVO) other;
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
