package com.sunrise.boss.business.resmanage.resparams.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


public class ResparamsVO implements Serializable {

    private Long logid;

    private String tablename;

    private String oprcode;

    private java.util.Date logdate;

    private Long oprtype;
    
    private String bufstr;

    private String newbuf;

    private String oldbuf;

    public ResparamsVO() {
    }

    public java.lang.Long getLogid() {
        return this.logid;
    }

    public void setLogid(java.lang.Long logid) {
        this.logid = logid;
    }

    public java.lang.String getTablename() {
        return this.tablename;
    }

    public void setTablename(java.lang.String tablename) {
        this.tablename = tablename;
    }

    public java.lang.String getOprcode() {
        return this.oprcode;
    }

    public void setOprcode(java.lang.String oprcode) {
        this.oprcode = oprcode;
    }

    public java.util.Date getLogdate() {
        return this.logdate;
    }

    public void setLogdate(java.util.Date logdate) {
        this.logdate = logdate;
    }

    public java.lang.Long getOprtype() {
        return this.oprtype;
    }

    public void setOprtype(java.lang.Long oprtype) {
        this.oprtype = oprtype;
    }

    public java.lang.String getNewbuf() {
        return this.newbuf;
    }

    public void setNewbuf(java.lang.String newbuf) {
        this.newbuf = newbuf;
    }

    public java.lang.String getOldbuf() {
        return this.oldbuf;
    }

    public void setOldbuf(java.lang.String oldbuf) {
        this.oldbuf = oldbuf;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("logid", getLogid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ResparamsVO) ) return false;
        ResparamsVO castOther = (ResparamsVO) other;
        return new EqualsBuilder()
            .append(this.getLogid(), castOther.getLogid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getLogid())
            .toHashCode();
    }

	public String getBufstr() {
		return bufstr;
	}

	public void setBufstr(String bufstr) {
		this.bufstr = bufstr;
	}

}
