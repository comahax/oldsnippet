package com.sunrise.boss.business.bcss.syncdata.wydataitem.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class WydataitemVO implements Serializable {

    /** identifier field */
    private String filecode;

    /** identifier field */
    private Integer itemid;

    /** nullable persistent field */
    private String itemcode;

    /** nullable persistent field */
    private String itemname;

    /** nullable persistent field */
    private Short itemtype;

    /** nullable persistent field */
    private String itemformat;

    /** full constructor */
    public WydataitemVO(java.lang.String filecode, java.lang.Integer itemid, java.lang.String itemcode, java.lang.String itemname, java.lang.Short itemtype, java.lang.String itemformat) {
        this.filecode = filecode;
        this.itemid = itemid;
        this.itemcode = itemcode;
        this.itemname = itemname;
        this.itemtype = itemtype;
        this.itemformat = itemformat;
    }

    /** default constructor */
    public WydataitemVO() {
    }

    /** minimal constructor */
    public WydataitemVO(java.lang.String filecode, java.lang.Integer itemid) {
        this.filecode = filecode;
        this.itemid = itemid;
    }

    public java.lang.String getFilecode() {
        return this.filecode;
    }

    public void setFilecode(java.lang.String filecode) {
        this.filecode = filecode;
    }

    public java.lang.Integer getItemid() {
        return this.itemid;
    }

    public void setItemid(java.lang.Integer itemid) {
        this.itemid = itemid;
    }

    public java.lang.String getItemcode() {
        return this.itemcode;
    }

    public void setItemcode(java.lang.String itemcode) {
        this.itemcode = itemcode;
    }

    public java.lang.String getItemname() {
        return this.itemname;
    }

    public void setItemname(java.lang.String itemname) {
        this.itemname = itemname;
    }

    public java.lang.Short getItemtype() {
        return this.itemtype;
    }

    public void setItemtype(java.lang.Short itemtype) {
        this.itemtype = itemtype;
    }

    public java.lang.String getItemformat() {
        return this.itemformat;
    }

    public void setItemformat(java.lang.String itemformat) {
        this.itemformat = itemformat;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("filecode", getFilecode())
            .append("itemid", getItemid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof WydataitemVO) ) return false;
        WydataitemVO castOther = (WydataitemVO) other;
        return new EqualsBuilder()
            .append(this.getFilecode(), castOther.getFilecode())
            .append(this.getItemid(), castOther.getItemid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getFilecode())
            .append(getItemid())
            .toHashCode();
    }

}
