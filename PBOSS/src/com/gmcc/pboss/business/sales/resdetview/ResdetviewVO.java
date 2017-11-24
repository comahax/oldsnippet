package com.gmcc.pboss.business.sales.resdetview;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class ResdetviewVO extends BaseVO implements Serializable {

    /** identifier field */
    private Long recid;

    /** persistent field */
    private String wayid;

    /** persistent field */
    private String comcategory;

    /** persistent field */
    private Short times;

    /** persistent field */
    private java.util.Date updatedate;

    /** full constructor */
    public ResdetviewVO(java.lang.Long recid, java.lang.String wayid, java.lang.String comcategory, java.lang.Short times, java.util.Date updatedate) {
        this.recid = recid;
        this.wayid = wayid;
        this.comcategory = comcategory;
        this.times = times;
        this.updatedate = updatedate;
    }

    /** default constructor */
    public ResdetviewVO() {
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

    public java.lang.Short getTimes() {
        return this.times;
    }

    public void setTimes(java.lang.Short times) {
        this.times = times;
    }

    public java.util.Date getUpdatedate() {
        return this.updatedate;
    }

    public void setUpdatedate(java.util.Date updatedate) {
        this.updatedate = updatedate;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("recid", getRecid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ResdetviewVO) ) return false;
        ResdetviewVO castOther = (ResdetviewVO) other;
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
