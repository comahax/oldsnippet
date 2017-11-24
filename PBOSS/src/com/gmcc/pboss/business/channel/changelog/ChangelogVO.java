package com.gmcc.pboss.business.channel.changelog;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class ChangelogVO extends BaseVO implements Serializable {

    /** identifier field */
    private Long logid;

    /** nullable persistent field */
    private java.util.Date optime;

    /** nullable persistent field */
    private String oprcode;

    /** nullable persistent field */
    private String oprtype;

    /** nullable persistent field */
    private String wayid;

    /** nullable persistent field */
    private Short changetype;

    /** nullable persistent field */
    private String oldvalue;

    /** nullable persistent field */
    private String nowvalue;
    
    private String memo;

    /** full constructor */
    public ChangelogVO(java.lang.Long logid, java.util.Date optime, java.lang.String oprcode, java.lang.String oprtype, java.lang.String wayid, java.lang.Short changetype, java.lang.String oldvalue, java.lang.String nowvalue) {
        this.logid = logid;
        this.optime = optime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
        this.wayid = wayid;
        this.changetype = changetype;
        this.oldvalue = oldvalue;
        this.nowvalue = nowvalue;
    }
    
    public ChangelogVO(java.lang.Long logid, java.util.Date optime, java.lang.String oprcode, java.lang.String oprtype, java.lang.String wayid, java.lang.Short changetype, java.lang.String oldvalue, java.lang.String nowvalue,java.lang.String memo) {
        this.logid = logid;
        this.optime = optime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
        this.wayid = wayid;
        this.changetype = changetype;
        this.oldvalue = oldvalue;
        this.nowvalue = nowvalue;
        this.memo = memo;
    }

    /** default constructor */
    public ChangelogVO() {
    }

    /** minimal constructor */
    public ChangelogVO(java.lang.Long logid) {
        this.logid = logid;
    }

    public java.lang.Long getLogid() {
        return this.logid;
    }

    public void setLogid(java.lang.Long logid) {
        this.logid = logid;
    }

    public java.util.Date getOptime() {
        return this.optime;
    }

    public void setOptime(java.util.Date optime) {
        this.optime = optime;
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

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.Short getChangetype() {
        return this.changetype;
    }

    public void setChangetype(java.lang.Short changetype) {
        this.changetype = changetype;
    }

    public java.lang.String getOldvalue() {
        return this.oldvalue;
    }

    public void setOldvalue(java.lang.String oldvalue) {
        this.oldvalue = oldvalue;
    }

    public java.lang.String getNowvalue() {
        return this.nowvalue;
    }

    public void setNowvalue(java.lang.String nowvalue) {
        this.nowvalue = nowvalue;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("logid", getLogid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ChangelogVO) ) return false;
        ChangelogVO castOther = (ChangelogVO) other;
        return new EqualsBuilder()
            .append(this.getLogid(), castOther.getLogid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getLogid())
            .toHashCode();
    }

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

}
