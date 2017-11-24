package com.gmcc.pboss.business.resource.simnoactinfo;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class SimnoactinfoVO extends BaseVO implements Serializable {

    /** identifier field */
    private Long recid;

    /** nullable persistent field */
    private String emptyno;

    /** nullable persistent field */
    private String state;

    /** nullable persistent field */
    private java.util.Date changetime;

    /** nullable persistent field */
    private java.util.Date creattime;

    /** nullable persistent field */
    private String memo;

    /** full constructor */
    public SimnoactinfoVO(java.lang.String emptyno, java.lang.String state, java.util.Date changetime, java.util.Date creattime, java.lang.String memo) {
        this.emptyno = emptyno;
        this.state = state;
        this.changetime = changetime;
        this.creattime = creattime;
        this.memo = memo;
    }

    /** default constructor */
    public SimnoactinfoVO() {
    }

    public java.lang.Long getRecid() {
        return this.recid;
    }

    public void setRecid(java.lang.Long recid) {
        this.recid = recid;
    }

    public java.lang.String getEmptyno() {
        return this.emptyno;
    }

    public void setEmptyno(java.lang.String emptyno) {
        this.emptyno = emptyno;
    }

    public java.lang.String getState() {
        return this.state;
    }

    public void setState(java.lang.String state) {
        this.state = state;
    }

    public java.util.Date getChangetime() {
        return this.changetime;
    }

    public void setChangetime(java.util.Date changetime) {
        this.changetime = changetime;
    }

    public java.util.Date getCreattime() {
        return this.creattime;
    }

    public void setCreattime(java.util.Date creattime) {
        this.creattime = creattime;
    }

    public java.lang.String getMemo() {
        return this.memo;
    }

    public void setMemo(java.lang.String memo) {
        this.memo = memo;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("recid", getRecid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof SimnoactinfoVO) ) return false;
        SimnoactinfoVO castOther = (SimnoactinfoVO) other;
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
