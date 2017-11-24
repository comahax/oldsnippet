package com.sunrise.boss.business.cms.reward.registersimcnt.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class RegistersimcntVO implements Serializable {

    /** identifier field */
    private String countyid;

    /** identifier field */
    private Short starlevel;

    /** identifier field */
    private String wayid;

    /** nullable persistent field */
    private String wayname;

    /** nullable persistent field */
    private Long cnt;
    
    private Long seqid;

    /** full constructor */
    public RegistersimcntVO(java.lang.String countyid, java.lang.Short starlevel, java.lang.String wayid, java.lang.String wayname, java.lang.Long cnt) {
        this.countyid = countyid;
        this.starlevel = starlevel;
        this.wayid = wayid;
        this.wayname = wayname;
        this.cnt = cnt;
    }

    /** default constructor */
    public RegistersimcntVO() {
    }

    /** minimal constructor */
    public RegistersimcntVO(java.lang.String countyid, java.lang.Short starlevel, java.lang.String wayid) {
        this.countyid = countyid;
        this.starlevel = starlevel;
        this.wayid = wayid;
    }

    public java.lang.String getCountyid() {
        return this.countyid;
    }

    public void setCountyid(java.lang.String countyid) {
        this.countyid = countyid;
    }

    public java.lang.Short getStarlevel() {
        return this.starlevel;
    }

    public void setStarlevel(java.lang.Short starlevel) {
        this.starlevel = starlevel;
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.String getWayname() {
        return this.wayname;
    }

    public void setWayname(java.lang.String wayname) {
        this.wayname = wayname;
    }

    public java.lang.Long getCnt() {
        return this.cnt;
    }

    public void setCnt(java.lang.Long cnt) {
        this.cnt = cnt;
    }

    public String toString() {
        return new ToStringBuilder(this)
        	.append("seqid", getSeqid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof RegistersimcntVO) ) return false;
        RegistersimcntVO castOther = (RegistersimcntVO) other;
        return new EqualsBuilder()
            .append(this.getSeqid(), castOther.getSeqid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getSeqid())
            .toHashCode();
    }

	public Long getSeqid() {
		return seqid;
	}

	public void setSeqid(Long seqid) {
		this.seqid = seqid;
	}

}
