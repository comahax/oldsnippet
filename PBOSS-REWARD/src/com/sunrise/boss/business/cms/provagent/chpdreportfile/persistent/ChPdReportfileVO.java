package com.sunrise.boss.business.cms.provagent.chpdreportfile.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class ChPdReportfileVO implements Serializable {

    /** identifier field */
    private Long fileid;

    /** nullable persistent field */
    private String rewardmonth;

    /** nullable persistent field */
    private String provagentid;

    /** nullable persistent field */
    private String pathname;

    /** full constructor */
    public ChPdReportfileVO(java.lang.Long fileid, java.lang.String rewardmonth, java.lang.String provagentid, java.lang.String pathname) {
        this.fileid = fileid;
        this.rewardmonth = rewardmonth;
        this.provagentid = provagentid;
        this.pathname = pathname;
    }

    /** default constructor */
    public ChPdReportfileVO() {
    }

    /** minimal constructor */
    public ChPdReportfileVO(java.lang.Long fileid) {
        this.fileid = fileid;
    }

    public java.lang.Long getFileid() {
        return this.fileid;
    }

    public void setFileid(java.lang.Long fileid) {
        this.fileid = fileid;
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

    public java.lang.String getPathname() {
        return this.pathname;
    }

    public void setPathname(java.lang.String pathname) {
        this.pathname = pathname;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("fileid", getFileid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ChPdReportfileVO) ) return false;
        ChPdReportfileVO castOther = (ChPdReportfileVO) other;
        return new EqualsBuilder()
            .append(this.getFileid(), castOther.getFileid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getFileid())
            .toHashCode();
    }

}
