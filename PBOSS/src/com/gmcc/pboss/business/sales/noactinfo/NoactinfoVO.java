package com.gmcc.pboss.business.sales.noactinfo;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class NoactinfoVO extends BaseVO implements Serializable {

    /** identifier field */
    private Long recid;

    /** nullable persistent field */
    private String mobileno;

    /** nullable persistent field */
    private java.util.Date activedate;

    /** nullable persistent field */
    private java.util.Date creattime;

    /** nullable persistent field */
    private String memo;

    /** full constructor */
    public NoactinfoVO(java.lang.Long recid, java.lang.String mobileno, java.util.Date activedate, java.util.Date creattime, java.lang.String memo) {
        this.recid = recid;
        this.mobileno = mobileno;
        this.activedate = activedate;
        this.creattime = creattime;
        this.memo = memo;
    }

    /** default constructor */
    public NoactinfoVO() {
    }

    /** minimal constructor */
    public NoactinfoVO(java.lang.Long recid) {
        this.recid = recid;
    }

    public java.lang.Long getRecid() {
        return this.recid;
    }

    public void setRecid(java.lang.Long recid) {
        this.recid = recid;
    }

    public java.lang.String getMobileno() {
        return this.mobileno;
    }

    public void setMobileno(java.lang.String mobileno) {
        this.mobileno = mobileno;
    }

    public java.util.Date getActivedate() {
        return this.activedate;
    }

    public void setActivedate(java.util.Date activedate) {
        this.activedate = activedate;
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
        if ( !(other instanceof NoactinfoVO) ) return false;
        NoactinfoVO castOther = (NoactinfoVO) other;
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
