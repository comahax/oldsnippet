package com.gmcc.pboss.business.sales.smpextramid;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class SmpextramidVO extends BaseVO implements Serializable {

    /** identifier field */
    private Long recid;

    /** nullable persistent field */
    private String wayid;

    /** nullable persistent field */
    private String comcategory;

    /** nullable persistent field */
    private String batchno;

    /** nullable persistent field */
    private String boxnum;

    /** nullable persistent field */
    private java.util.Date extratime;

    /** nullable persistent field */
    private Short validflag;

    /** full constructor */
    public SmpextramidVO(java.lang.Long recid, java.lang.String wayid, java.lang.String comcategory, java.lang.String batchno, java.lang.String boxnum, java.util.Date extratime, java.lang.Short validflag) {
        this.recid = recid;
        this.wayid = wayid;
        this.comcategory = comcategory;
        this.batchno = batchno;
        this.boxnum = boxnum;
        this.extratime = extratime;
        this.validflag = validflag;
    }

    /** default constructor */
    public SmpextramidVO() {
    }

    /** minimal constructor */
    public SmpextramidVO(java.lang.Long recid) {
        this.recid = recid;
    }

    public java.lang.Long getRecid() {
        return this.recid;
    }

    public void setRecid(java.lang.Long recid) {
        this.recid = recid;
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.String getComcategory() {
        return this.comcategory;
    }

    public void setComcategory(java.lang.String comcategory) {
        this.comcategory = comcategory;
    }

    public java.lang.String getBatchno() {
        return this.batchno;
    }

    public void setBatchno(java.lang.String batchno) {
        this.batchno = batchno;
    }

    public java.lang.String getBoxnum() {
        return this.boxnum;
    }

    public void setBoxnum(java.lang.String boxnum) {
        this.boxnum = boxnum;
    }

    public java.util.Date getExtratime() {
        return this.extratime;
    }

    public void setExtratime(java.util.Date extratime) {
        this.extratime = extratime;
    }

    public java.lang.Short getValidflag() {
        return this.validflag;
    }

    public void setValidflag(java.lang.Short validflag) {
        this.validflag = validflag;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("recid", getRecid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof SmpextramidVO) ) return false;
        SmpextramidVO castOther = (SmpextramidVO) other;
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
