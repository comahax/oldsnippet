package com.sunrise.boss.business.cms.bbc.bbcwaylevel.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class BbcWaylevelVO implements Serializable {

    /** identifier field */
    private String wayid;

    /** nullable persistent field */
    private String waylevel;

    /** nullable persistent field */
    private java.util.Date chagtime;

    /** full constructor */
    public BbcWaylevelVO(java.lang.String wayid, java.lang.String waylevel, java.util.Date chagtime) {
        this.wayid = wayid;
        this.waylevel = waylevel;
        this.chagtime = chagtime;
    }

    /** default constructor */
    public BbcWaylevelVO() {
    }

    /** minimal constructor */
    public BbcWaylevelVO(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.String getWaylevel() {
        return this.waylevel;
    }

    public void setWaylevel(java.lang.String waylevel) {
        this.waylevel = waylevel;
    }

    public java.util.Date getChagtime() {
        return this.chagtime;
    }

    public void setChagtime(java.util.Date chagtime) {
        this.chagtime = chagtime;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("wayid", getWayid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof BbcWaylevelVO) ) return false;
        BbcWaylevelVO castOther = (BbcWaylevelVO) other;
        return new EqualsBuilder()
            .append(this.getWayid(), castOther.getWayid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getWayid())
            .toHashCode();
    }

}
