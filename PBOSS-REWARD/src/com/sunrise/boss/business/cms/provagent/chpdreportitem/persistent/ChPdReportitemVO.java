package com.sunrise.boss.business.cms.provagent.chpdreportitem.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class ChPdReportitemVO implements Serializable {

    /** identifier field */
    private Long itemid;

    /** nullable persistent field */
    private String rewardmonth;

    /** nullable persistent field */
    private String provagentid;

    /** nullable persistent field */
    private String cityid;

    /** nullable persistent field */
    private String columncode;

    /** nullable persistent field */
    private String columnname;

    /** nullable persistent field */
    private Double rewardsum;

    /** full constructor */
    public ChPdReportitemVO(java.lang.Long itemid, java.lang.String rewardmonth, java.lang.String provagentid, java.lang.String cityid, java.lang.String columncode, java.lang.String columnname, java.lang.Double rewardsum) {
        this.itemid = itemid;
        this.rewardmonth = rewardmonth;
        this.provagentid = provagentid;
        this.cityid = cityid;
        this.columncode = columncode;
        this.columnname = columnname;
        this.rewardsum = rewardsum;
    }

    /** default constructor */
    public ChPdReportitemVO() {
    }

    /** minimal constructor */
    public ChPdReportitemVO(java.lang.Long itemid) {
        this.itemid = itemid;
    }

    public java.lang.Long getItemid() {
        return this.itemid;
    }

    public void setItemid(java.lang.Long itemid) {
        this.itemid = itemid;
    }

    public java.lang.String getRewardmonth() {
        return this.rewardmonth;
    }

    public void setRewardmonth(java.lang.String rewardmonth) {
        this.rewardmonth = rewardmonth;
    }

    public java.lang.String getProvagentid() {
        return this.provagentid;
    }

    public void setProvagentid(java.lang.String provagentid) {
        this.provagentid = provagentid;
    }

    public java.lang.String getCityid() {
        return this.cityid;
    }

    public void setCityid(java.lang.String cityid) {
        this.cityid = cityid;
    }

    public java.lang.String getColumncode() {
        return this.columncode;
    }

    public void setColumncode(java.lang.String columncode) {
        this.columncode = columncode;
    }

    public java.lang.String getColumnname() {
        return this.columnname;
    }

    public void setColumnname(java.lang.String columnname) {
        this.columnname = columnname;
    }

    public java.lang.Double getRewardsum() {
        return this.rewardsum;
    }

    public void setRewardsum(java.lang.Double rewardsum) {
        this.rewardsum = rewardsum;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("itemid", getItemid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ChPdReportitemVO) ) return false;
        ChPdReportitemVO castOther = (ChPdReportitemVO) other;
        return new EqualsBuilder()
            .append(this.getItemid(), castOther.getItemid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getItemid())
            .toHashCode();
    }

}
