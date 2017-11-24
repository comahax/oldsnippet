package com.sunrise.boss.business.qsmanage.paramsmanage.chgreglog.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class ChgReglogVO implements Serializable {

    /** identifier field */
    private Long logid;

    /** nullable persistent field */
    private java.util.Date chgtime;

    /** nullable persistent field */
    private String chgcode;

    /** nullable persistent field */
    private Long reqid;

    /** nullable persistent field */
    private String tabname;

    /** nullable persistent field */
    private String oldvalue;

    /** nullable persistent field */
    private String newvalue;

    /** full constructor */
    public ChgReglogVO(java.lang.Long logid,java.util.Date chgtime, java.lang.String chgcode, java.lang.Long reqid, java.lang.String tabname, java.lang.String oldvalue, java.lang.String newvalue) {
        this.logid = logid;
        this.chgtime = chgtime;
        this.chgcode = chgcode;
        this.reqid = reqid;
        this.tabname = tabname;
        this.oldvalue = oldvalue;
        this.newvalue = newvalue;
    }

    /** default constructor */
    public ChgReglogVO() {
    }

    /** minimal constructor */
    public ChgReglogVO(java.lang.Long logid) {
        this.logid = logid;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("logid", getLogid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ChgReglogVO) ) return false;
        ChgReglogVO castOther = (ChgReglogVO) other;
        return new EqualsBuilder()
            .append(this.getLogid(), castOther.getLogid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getLogid())
            .toHashCode();
    }

	public String getChgcode() {
		return chgcode;
	}

	public void setChgcode(String chgcode) {
		this.chgcode = chgcode;
	}

	public java.util.Date getChgtime() {
		return chgtime;
	}

	public void setChgtime(java.util.Date chgtime) {
		this.chgtime = chgtime;
	}

	public Long getLogid() {
		return logid;
	}

	public void setLogid(Long logid) {
		this.logid = logid;
	}

	public String getNewvalue() {
		return newvalue;
	}

	public void setNewvalue(String newvalue) {
		this.newvalue = newvalue;
	}

	public String getOldvalue() {
		return oldvalue;
	}

	public void setOldvalue(String oldvalue) {
		this.oldvalue = oldvalue;
	}

	public Long getReqid() {
		return reqid;
	}

	public void setReqid(Long reqid) {
		this.reqid = reqid;
	}

	public String getTabname() {
		return tabname;
	}

	public void setTabname(String tabname) {
		this.tabname = tabname;
	}

}
