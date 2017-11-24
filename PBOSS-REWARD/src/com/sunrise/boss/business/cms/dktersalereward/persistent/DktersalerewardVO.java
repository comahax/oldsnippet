package com.sunrise.boss.business.cms.dktersalereward.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class DktersalerewardVO implements Serializable {

    /** identifier field */
    private Long recid;

    /** nullable persistent field */
    private String month;

    /** nullable persistent field */
    private String ecpoperator;

    /** nullable persistent field */
    private String wayname;

    /** nullable persistent field */
    private Long salesuc;

    /** nullable persistent field */
    private Long examinesuc;

    /** nullable persistent field */
    private Double foundreward;

    /** nullable persistent field */
    private Double examinereward;

    /** nullable persistent field */
    private Short cityid;

    /** full constructor */
    public DktersalerewardVO(java.lang.Long recid, java.lang.String month, java.lang.String ecpoperator, java.lang.String wayname, java.lang.Long salesuc, java.lang.Long examinesuc, java.lang.Double foundreward, java.lang.Double examinereward, java.lang.Short cityid) {
        this.recid = recid;
        this.month = month;
        this.ecpoperator = ecpoperator;
        this.wayname = wayname;
        this.salesuc = salesuc;
        this.examinesuc = examinesuc;
        this.foundreward = foundreward;
        this.examinereward = examinereward;
        this.cityid = cityid;
    }

    /** default constructor */
    public DktersalerewardVO() {
    }

    /** minimal constructor */
    public DktersalerewardVO(java.lang.Long recid) {
        this.recid = recid;
    }

    public java.lang.Long getRecid() {
        return this.recid;
    }

    public void setRecid(java.lang.Long recid) {
        this.recid = recid;
    }

    public java.lang.String getMonth() {
        return this.month;
    }

    public void setMonth(java.lang.String month) {
        this.month = month;
    }

    public java.lang.String getEcpoperator() {
        return this.ecpoperator;
    }

    public void setEcpoperator(java.lang.String ecpoperator) {
        this.ecpoperator = ecpoperator;
    }

    public java.lang.String getWayname() {
        return this.wayname;
    }

    public void setWayname(java.lang.String wayname) {
        this.wayname = wayname;
    }

    public java.lang.Long getSalesuc() {
        return this.salesuc;
    }

    public void setSalesuc(java.lang.Long salesuc) {
        this.salesuc = salesuc;
    }

    public java.lang.Long getExaminesuc() {
        return this.examinesuc;
    }

    public void setExaminesuc(java.lang.Long examinesuc) {
        this.examinesuc = examinesuc;
    }

    public java.lang.Double getFoundreward() {
        return this.foundreward;
    }

    public void setFoundreward(java.lang.Double foundreward) {
        this.foundreward = foundreward;
    }

    public java.lang.Double getExaminereward() {
        return this.examinereward;
    }

    public void setExaminereward(java.lang.Double examinereward) {
        this.examinereward = examinereward;
    }

    public java.lang.Short getCityid() {
        return this.cityid;
    }

    public void setCityid(java.lang.Short cityid) {
        this.cityid = cityid;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("recid", getRecid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof DktersalerewardVO) ) return false;
        DktersalerewardVO castOther = (DktersalerewardVO) other;
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
