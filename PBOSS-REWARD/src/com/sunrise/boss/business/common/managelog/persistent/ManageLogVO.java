package com.sunrise.boss.business.common.managelog.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class ManageLogVO implements Serializable {

    /** identifier field */
    private Long logid;

    /** persistent field */
    private java.util.Date oprtime;

    /** persistent field */
    private String oprcode;

    /** persistent field */
    private String oprtype;

    /** persistent field */
    private String opraction;

    /** persistent field */
    private String oprcon1;

    private String oprcon2;
    /** persistent field */
    private Integer oprstate;

    /** full constructor */
    public ManageLogVO(java.lang.Long logid, java.util.Date oprtime, java.lang.String oprcode, java.lang.String oprtype, java.lang.String opraction, java.lang.String oprcon1, java.lang.String oprcon2, Integer oprstate) {
        this.logid = logid;
        this.oprtime = oprtime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
        this.opraction = opraction;
        this.oprcon1 = oprcon1;
        this.oprcon2 = oprcon2;        
        this.oprstate = oprstate;
    }

    /** default constructor */
    public ManageLogVO() {
    }

    public java.lang.Long getLogid() {
        return this.logid;
    }

    public void setLogid(java.lang.Long logid) {
        this.logid = logid;
    }

    public java.util.Date getOprtime() {
        return this.oprtime;
    }

    public void setOprtime(java.util.Date oprtime) {
        this.oprtime = oprtime;
    }

    public java.lang.String getOprcode() {
        return this.oprcode;
    }

    public void setOprcode(java.lang.String oprcode) {
        this.oprcode = oprcode;
    }

    public java.lang.String getOprtype() {
        return this.oprtype;
    }

    public void setOprtype(java.lang.String oprtype) {
        this.oprtype = oprtype;
    }

    public java.lang.String getOpraction() {
        return this.opraction;
    }

    public void setOpraction(java.lang.String opraction) {
        this.opraction = opraction;
    }

    public String getOprcon1() {
		return oprcon1;
	}

    public void setOprcon1(String oprcon1) {
		this.oprcon1 = oprcon1;
	}

    public String getOprcon2() {
		return oprcon2;
	}

    public void setOprcon2(String oprcon2) {
		this.oprcon2 = oprcon2;
	}

    public Integer getOprstate() {
        return this.oprstate;
    }

    public void setOprstate(Integer oprstate) {
        this.oprstate = oprstate;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("logid", getLogid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ManageLogVO) ) return false;
        ManageLogVO castOther = (ManageLogVO) other;
        return new EqualsBuilder()
            .append(this.getLogid(), castOther.getLogid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getLogid())
            .toHashCode();
    }



}
