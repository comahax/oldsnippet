package com.gmcc.pboss.business.cms.examine.exmnrslt.persistent;


import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.jop.infrastructure.db.BaseVO;

/** @author Hibernate CodeGenerator */
public class ExmnrsltVO  extends BaseVO implements Serializable {

    /** identifier field */
    private Integer exmnid;

    /** identifier field */
    private String exmnperiod;

    /** identifier field */
    private String wayid;

    /** nullable persistent field */
    private Double exmnmark;

    /** full constructor */
    public ExmnrsltVO(java.lang.Integer exmnid, java.lang.String exmnperiod, java.lang.String wayid, java.lang.Double exmnmark) {
        this.exmnid = exmnid;
        this.exmnperiod = exmnperiod;
        this.wayid = wayid;
        this.exmnmark = exmnmark;
    }

    /** default constructor */
    public ExmnrsltVO() {
    }

    /** minimal constructor */
    public ExmnrsltVO(java.lang.Integer exmnid, java.lang.String exmnperiod, java.lang.String wayid) {
        this.exmnid = exmnid;
        this.exmnperiod = exmnperiod;
        this.wayid = wayid;
    }

    public java.lang.Integer getExmnid() {
        return this.exmnid;
    }

    public void setExmnid(java.lang.Integer exmnid) {
        this.exmnid = exmnid;
    }

    public java.lang.String getExmnperiod() {
        return this.exmnperiod;
    }

    public void setExmnperiod(java.lang.String exmnperiod) {
        this.exmnperiod = exmnperiod;
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.Double getExmnmark() {
        return this.exmnmark;
    }

    public void setExmnmark(java.lang.Double exmnmark) {
        this.exmnmark = exmnmark;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("exmnid", getExmnid())
            .append("exmnperiod", getExmnperiod())
            .append("wayid", getWayid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ExmnrsltVO) ) return false;
        ExmnrsltVO castOther = (ExmnrsltVO) other;
        return new EqualsBuilder()
            .append(this.getExmnid(), castOther.getExmnid())
            .append(this.getExmnperiod(), castOther.getExmnperiod())
            .append(this.getWayid(), castOther.getWayid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getExmnid())
            .append(getExmnperiod())
            .append(getWayid())
            .toHashCode();
    }

}
