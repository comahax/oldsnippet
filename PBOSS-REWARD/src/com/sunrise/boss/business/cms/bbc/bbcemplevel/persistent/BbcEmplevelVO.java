package com.sunrise.boss.business.cms.bbc.bbcemplevel.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class BbcEmplevelVO implements Serializable {

    /** identifier field */
    private String employeeid;

    /** nullable persistent field */
    private String emplevel;

    /** nullable persistent field */
    private java.util.Date chagtime;

    /** full constructor */
    public BbcEmplevelVO(java.lang.String employeeid, java.lang.String emplevel, java.util.Date chagtime) {
        this.employeeid = employeeid;
        this.emplevel = emplevel;
        this.chagtime = chagtime;
    }

    /** default constructor */
    public BbcEmplevelVO() {
    }

    /** minimal constructor */
    public BbcEmplevelVO(java.lang.String employeeid) {
        this.employeeid = employeeid;
    }

    public java.lang.String getEmployeeid() {
        return this.employeeid;
    }

    public void setEmployeeid(java.lang.String employeeid) {
        this.employeeid = employeeid;
    }

    public java.lang.String getEmplevel() {
        return this.emplevel;
    }

    public void setEmplevel(java.lang.String emplevel) {
        this.emplevel = emplevel;
    }

    public java.util.Date getChagtime() {
        return this.chagtime;
    }

    public void setChagtime(java.util.Date chagtime) {
        this.chagtime = chagtime;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("employeeid", getEmployeeid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof BbcEmplevelVO) ) return false;
        BbcEmplevelVO castOther = (BbcEmplevelVO) other;
        return new EqualsBuilder()
            .append(this.getEmployeeid(), castOther.getEmployeeid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getEmployeeid())
            .toHashCode();
    }

}
