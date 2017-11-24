package com.sunrise.boss.business.cms.coststatrelative.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class CoststatrelativeVO implements Serializable {

    /** identifier field */
    private Short fnlcostitem;

    /** identifier field */
    private Long recid;

    /** nullable persistent field */
    private Short statmode;

    /** full constructor */
    public CoststatrelativeVO(java.lang.Short fnlcostitem, java.lang.Long id, java.lang.Short statmode) {
        this.fnlcostitem = fnlcostitem;
        this.recid = id;
        this.statmode = statmode;
    }

    /** default constructor */
    public CoststatrelativeVO() {
    }

    /** minimal constructor */
    public CoststatrelativeVO(java.lang.Short fnlcostitem, java.lang.Long id) {
        this.fnlcostitem = fnlcostitem;
        this.recid = id;
    }

    public java.lang.Short getFnlcostitem() {
        return this.fnlcostitem;
    }

    public void setFnlcostitem(java.lang.Short fnlcostitem) {
        this.fnlcostitem = fnlcostitem;
    }

    public java.lang.Long getRecid() {
        return this.recid;
    }

    public void setRecid(java.lang.Long id) {
        this.recid = id;
    }

    public java.lang.Short getStatmode() {
        return this.statmode;
    }

    public void setStatmode(java.lang.Short statmode) {
        this.statmode = statmode;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("fnlcostitem", getFnlcostitem())
            .append("id", getRecid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CoststatrelativeVO) ) return false;
        CoststatrelativeVO castOther = (CoststatrelativeVO) other;
        return new EqualsBuilder()
            .append(this.getFnlcostitem(), castOther.getFnlcostitem())
            .append(this.getRecid(), castOther.getRecid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getFnlcostitem())
            .append(getRecid())
            .toHashCode();
    }

}
