package com.sunrise.boss.business.cms.zjty.chzjtylocaljjrewardtotal.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class ChZjtyLocaljjrewardtotalVO implements Serializable {

    /** identifier field */
    private Long recid;

    /** nullable persistent field */
    private String wayname;

    /** nullable persistent field */
    private String companytype;

    /** nullable persistent field */
    private String cityid;

    /** nullable persistent field */
    private String zjtywayname;

    /** nullable persistent field */
    private Double qqtxzfhcj;

    /** nullable persistent field */
    private Double yffzqqtcj;

    /** nullable persistent field */
    private Double dgddtkxscj;

    /** nullable persistent field */
    private Double szxtkxscj;

    /** nullable persistent field */
    private Double czywcj;

    /** nullable persistent field */
    private Double dzzdcj;

    /** nullable persistent field */
    private Double zhywcj;

    /** nullable persistent field */
    private Double zzywcj;

    /** nullable persistent field */
    private Double dgddwlk;

    /** nullable persistent field */
    private Double jtkdkhcj;

    /** nullable persistent field */
    private Double sjywcj;

    /** nullable persistent field */
    private Double jtywcj;

    /** nullable persistent field */
    private Double dsgsyxzd;

    /** nullable persistent field */
    private Double qqtffcjkj;

    /** nullable persistent field */
    private Double total;

    /** nullable persistent field */
    private String rewardreporttime;

    /** full constructor */
    public ChZjtyLocaljjrewardtotalVO(java.lang.Long recid, java.lang.String wayname, java.lang.String companytype, java.lang.String cityid, java.lang.String zjtywayname, java.lang.Double qqtxzfhcj, java.lang.Double yffzqqtcj, java.lang.Double dgddtkxscj, java.lang.Double szxtkxscj, java.lang.Double czywcj, java.lang.Double dzzdcj, java.lang.Double zhywcj, java.lang.Double zzywcj, java.lang.Double dgddwlk, java.lang.Double jtkdkhcj, java.lang.Double sjywcj, java.lang.Double jtywcj, java.lang.Double dsgsyxzd, java.lang.Double qqtffcjkj, java.lang.Double total, java.lang.String rewardreporttime) {
        this.recid = recid;
        this.wayname = wayname;
        this.companytype = companytype;
        this.cityid = cityid;
        this.zjtywayname = zjtywayname;
        this.qqtxzfhcj = qqtxzfhcj;
        this.yffzqqtcj = yffzqqtcj;
        this.dgddtkxscj = dgddtkxscj;
        this.szxtkxscj = szxtkxscj;
        this.czywcj = czywcj;
        this.dzzdcj = dzzdcj;
        this.zhywcj = zhywcj;
        this.zzywcj = zzywcj;
        this.dgddwlk = dgddwlk;
        this.jtkdkhcj = jtkdkhcj;
        this.sjywcj = sjywcj;
        this.jtywcj = jtywcj;
        this.dsgsyxzd = dsgsyxzd;
        this.qqtffcjkj = qqtffcjkj;
        this.total = total;
        this.rewardreporttime = rewardreporttime;
    }

    /** default constructor */
    public ChZjtyLocaljjrewardtotalVO() {
    }

    /** minimal constructor */
    public ChZjtyLocaljjrewardtotalVO(java.lang.Long recid) {
        this.recid = recid;
    }

    public java.lang.Long getRecid() {
        return this.recid;
    }

    public void setRecid(java.lang.Long recid) {
        this.recid = recid;
    }

    public java.lang.String getCityid() {
        return this.cityid;
    }

    public void setCityid(java.lang.String cityid) {
        this.cityid = cityid;
    }

    public java.lang.String getWayname() {
        return this.wayname;
    }

    public void setWayname(java.lang.String wayname) {
        this.wayname = wayname;
    }

    public java.lang.Double getQqtxzfhcj() {
        return this.qqtxzfhcj;
    }

    public void setQqtxzfhcj(java.lang.Double qqtxzfhcj) {
        this.qqtxzfhcj = qqtxzfhcj;
    }

    public java.lang.Double getYffzqqtcj() {
        return this.yffzqqtcj;
    }

    public void setYffzqqtcj(java.lang.Double yffzqqtcj) {
        this.yffzqqtcj = yffzqqtcj;
    }

    public java.lang.Double getDgddtkxscj() {
        return this.dgddtkxscj;
    }

    public void setDgddtkxscj(java.lang.Double dgddtkxscj) {
        this.dgddtkxscj = dgddtkxscj;
    }

    public java.lang.Double getSzxtkxscj() {
        return this.szxtkxscj;
    }

    public void setSzxtkxscj(java.lang.Double szxtkxscj) {
        this.szxtkxscj = szxtkxscj;
    }

    public java.lang.Double getCzywcj() {
        return this.czywcj;
    }

    public void setCzywcj(java.lang.Double czywcj) {
        this.czywcj = czywcj;
    }

    public java.lang.Double getDzzdcj() {
        return this.dzzdcj;
    }

    public void setDzzdcj(java.lang.Double dzzdcj) {
        this.dzzdcj = dzzdcj;
    }

    public java.lang.Double getZhywcj() {
        return this.zhywcj;
    }

    public void setZhywcj(java.lang.Double zhywcj) {
        this.zhywcj = zhywcj;
    }

    public java.lang.Double getZzywcj() {
        return this.zzywcj;
    }

    public void setZzywcj(java.lang.Double zzywcj) {
        this.zzywcj = zzywcj;
    }

    public java.lang.Double getDgddwlk() {
        return this.dgddwlk;
    }

    public void setDgddwlk(java.lang.Double dgddwlk) {
        this.dgddwlk = dgddwlk;
    }

    public java.lang.Double getJtkdkhcj() {
        return this.jtkdkhcj;
    }

    public void setJtkdkhcj(java.lang.Double jtkdkhcj) {
        this.jtkdkhcj = jtkdkhcj;
    }

    public java.lang.Double getSjywcj() {
        return this.sjywcj;
    }

    public void setSjywcj(java.lang.Double sjywcj) {
        this.sjywcj = sjywcj;
    }

    public java.lang.Double getJtywcj() {
        return this.jtywcj;
    }

    public void setJtywcj(java.lang.Double jtywcj) {
        this.jtywcj = jtywcj;
    }

    public java.lang.Double getDsgsyxzd() {
        return this.dsgsyxzd;
    }

    public void setDsgsyxzd(java.lang.Double dsgsyxzd) {
        this.dsgsyxzd = dsgsyxzd;
    }

    public java.lang.Double getQqtffcjkj() {
        return this.qqtffcjkj;
    }

    public void setQqtffcjkj(java.lang.Double qqtffcjkj) {
        this.qqtffcjkj = qqtffcjkj;
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

    public String getCompanytype() {
        return companytype;
    }

    public void setCompanytype(String companytype) {
        this.companytype = companytype;
    }

    public String getZjtywayname() {
        return zjtywayname;
    }

    public void setZjtywayname(String zjtywayname) {
        this.zjtywayname = zjtywayname;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("recid", getRecid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ChZjtyLocaljjrewardtotalVO) ) return false;
        ChZjtyLocaljjrewardtotalVO castOther = (ChZjtyLocaljjrewardtotalVO) other;
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
