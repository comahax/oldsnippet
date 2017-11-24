package com.sunrise.boss.business.cms.chadtbusitoapprove.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class ChAdtBusitoapproveVO implements Serializable {

    /** identifier field */
    private String approveid;

    /** nullable persistent field */
    private String batchid;

    /** nullable persistent field */
    private String opnid;

    /** nullable persistent field */
    private String opnname;

    /** nullable persistent field */
    private String rewardtype;

    /** nullable persistent field */
    private String region;

    /** nullable persistent field */
    private String isslv;

    /** nullable persistent field */
    private String slv;

    /** nullable persistent field */
    private java.util.Date startdate;

    /** nullable persistent field */
    private java.util.Date enddate;

    /** nullable persistent field */
    private String acctype;

    /** nullable persistent field */
    private Double rewardstd;

    /** nullable persistent field */
    private Integer intvmonth;

    /** nullable persistent field */
    private String isprov;

    /** nullable persistent field */
    private String ruleinfo;

    /** nullable persistent field */
    private String ruledesc;

    /** nullable persistent field */
    private Short isslvlev;

    /** nullable persistent field */
    private Short slvlev;

    /** nullable persistent field */
    private Double citystd;

    /** nullable persistent field */
    private Double countrystd;

    /** nullable persistent field */
    private Double cityaccountlimit;

    /** nullable persistent field */
    private Double countyaccountlimit;

    /** nullable persistent field */
    private Double citycorelimit;

    /** nullable persistent field */
    private Double countycorelimit;

    /** nullable persistent field */
    private Short percentage;

    /** nullable persistent field */
    private Short years;

    /** nullable persistent field */
    private java.util.Date apptime;

    /** nullable persistent field */
    private java.util.Date systemdate;

    /** nullable persistent field */
    private java.util.Date addopntime;

    /** full constructor */
    public ChAdtBusitoapproveVO(java.lang.String approveid, java.lang.String batchid, java.lang.String opnid, java.lang.String opnname, java.lang.String rewardtype, java.lang.String region, java.lang.String isslv, java.lang.String slv, java.util.Date startdate, java.util.Date enddate, java.lang.String acctype, java.lang.Double rewardstd, java.lang.Integer intvmonth, java.lang.String isprov, java.lang.String ruleinfo, java.lang.String ruledesc, java.lang.Short isslvlev, java.lang.Short slvlev, java.lang.Double citystd, java.lang.Double countrystd, java.lang.Double cityaccountlimit, java.lang.Double countyaccountlimit, java.lang.Double citycorelimit, java.lang.Double countycorelimit, java.lang.Short percentage, java.lang.Short years, java.util.Date apptime, java.util.Date systemdate, java.util.Date addopntime) {
        this.approveid = approveid;
        this.batchid = batchid;
        this.opnid = opnid;
        this.opnname = opnname;
        this.rewardtype = rewardtype;
        this.region = region;
        this.isslv = isslv;
        this.slv = slv;
        this.startdate = startdate;
        this.enddate = enddate;
        this.acctype = acctype;
        this.rewardstd = rewardstd;
        this.intvmonth = intvmonth;
        this.isprov = isprov;
        this.ruleinfo = ruleinfo;
        this.ruledesc = ruledesc;
        this.isslvlev = isslvlev;
        this.slvlev = slvlev;
        this.citystd = citystd;
        this.countrystd = countrystd;
        this.cityaccountlimit = cityaccountlimit;
        this.countyaccountlimit = countyaccountlimit;
        this.citycorelimit = citycorelimit;
        this.countycorelimit = countycorelimit;
        this.percentage = percentage;
        this.years = years;
        this.apptime = apptime;
        this.systemdate = systemdate;
        this.addopntime = addopntime;
    }

    /** default constructor */
    public ChAdtBusitoapproveVO() {
    }

    /** minimal constructor */
    public ChAdtBusitoapproveVO(java.lang.String approveid) {
        this.approveid = approveid;
    }

    public java.lang.String getApproveid() {
        return this.approveid;
    }

    public void setApproveid(java.lang.String approveid) {
        this.approveid = approveid;
    }

    public java.lang.String getBatchid() {
        return this.batchid;
    }

    public void setBatchid(java.lang.String batchid) {
        this.batchid = batchid;
    }

    public java.lang.String getOpnid() {
        return this.opnid;
    }

    public void setOpnid(java.lang.String opnid) {
        this.opnid = opnid;
    }

    public java.lang.String getOpnname() {
        return this.opnname;
    }

    public void setOpnname(java.lang.String opnname) {
        this.opnname = opnname;
    }

    public java.lang.String getRewardtype() {
        return this.rewardtype;
    }

    public void setRewardtype(java.lang.String rewardtype) {
        this.rewardtype = rewardtype;
    }

    public java.lang.String getRegion() {
        return this.region;
    }

    public void setRegion(java.lang.String region) {
        this.region = region;
    }

    public java.lang.String getIsslv() {
        return this.isslv;
    }

    public void setIsslv(java.lang.String isslv) {
        this.isslv = isslv;
    }

    public java.lang.String getSlv() {
        return this.slv;
    }

    public void setSlv(java.lang.String slv) {
        this.slv = slv;
    }

    public java.util.Date getStartdate() {
        return this.startdate;
    }

    public void setStartdate(java.util.Date startdate) {
        this.startdate = startdate;
    }

    public java.util.Date getEnddate() {
        return this.enddate;
    }

    public void setEnddate(java.util.Date enddate) {
        this.enddate = enddate;
    }

    public java.lang.String getAcctype() {
        return this.acctype;
    }

    public void setAcctype(java.lang.String acctype) {
        this.acctype = acctype;
    }

    public java.lang.Double getRewardstd() {
        return this.rewardstd;
    }

    public void setRewardstd(java.lang.Double rewardstd) {
        this.rewardstd = rewardstd;
    }

    public java.lang.Integer getIntvmonth() {
        return this.intvmonth;
    }

    public void setIntvmonth(java.lang.Integer intvmonth) {
        this.intvmonth = intvmonth;
    }

    public java.lang.String getIsprov() {
        return this.isprov;
    }

    public void setIsprov(java.lang.String isprov) {
        this.isprov = isprov;
    }

    public java.lang.String getRuleinfo() {
        return this.ruleinfo;
    }

    public void setRuleinfo(java.lang.String ruleinfo) {
        this.ruleinfo = ruleinfo;
    }

    public java.lang.String getRuledesc() {
        return this.ruledesc;
    }

    public void setRuledesc(java.lang.String ruledesc) {
        this.ruledesc = ruledesc;
    }

    public java.lang.Short getIsslvlev() {
        return this.isslvlev;
    }

    public void setIsslvlev(java.lang.Short isslvlev) {
        this.isslvlev = isslvlev;
    }

    public java.lang.Short getSlvlev() {
        return this.slvlev;
    }

    public void setSlvlev(java.lang.Short slvlev) {
        this.slvlev = slvlev;
    }

    public java.lang.Double getCitystd() {
        return this.citystd;
    }

    public void setCitystd(java.lang.Double citystd) {
        this.citystd = citystd;
    }

    public java.lang.Double getCountrystd() {
        return this.countrystd;
    }

    public void setCountrystd(java.lang.Double countrystd) {
        this.countrystd = countrystd;
    }

    public java.lang.Double getCityaccountlimit() {
        return this.cityaccountlimit;
    }

    public void setCityaccountlimit(java.lang.Double cityaccountlimit) {
        this.cityaccountlimit = cityaccountlimit;
    }

    public java.lang.Double getCountyaccountlimit() {
        return this.countyaccountlimit;
    }

    public void setCountyaccountlimit(java.lang.Double countyaccountlimit) {
        this.countyaccountlimit = countyaccountlimit;
    }

    public java.lang.Double getCitycorelimit() {
        return this.citycorelimit;
    }

    public void setCitycorelimit(java.lang.Double citycorelimit) {
        this.citycorelimit = citycorelimit;
    }

    public java.lang.Double getCountycorelimit() {
        return this.countycorelimit;
    }

    public void setCountycorelimit(java.lang.Double countycorelimit) {
        this.countycorelimit = countycorelimit;
    }

    public java.lang.Short getPercentage() {
        return this.percentage;
    }

    public void setPercentage(java.lang.Short percentage) {
        this.percentage = percentage;
    }

    public java.lang.Short getYears() {
        return this.years;
    }

    public void setYears(java.lang.Short years) {
        this.years = years;
    }

    public java.util.Date getApptime() {
        return this.apptime;
    }

    public void setApptime(java.util.Date apptime) {
        this.apptime = apptime;
    }

    public java.util.Date getSystemdate() {
        return this.systemdate;
    }

    public void setSystemdate(java.util.Date systemdate) {
        this.systemdate = systemdate;
    }

    public java.util.Date getAddopntime() {
        return this.addopntime;
    }

    public void setAddopntime(java.util.Date addopntime) {
        this.addopntime = addopntime;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("approveid", getApproveid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ChAdtBusitoapproveVO) ) return false;
        ChAdtBusitoapproveVO castOther = (ChAdtBusitoapproveVO) other;
        return new EqualsBuilder()
            .append(this.getApproveid(), castOther.getApproveid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getApproveid())
            .toHashCode();
    }

}
