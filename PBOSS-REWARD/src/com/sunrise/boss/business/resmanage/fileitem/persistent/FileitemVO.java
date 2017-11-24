package com.sunrise.boss.business.resmanage.fileitem.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class FileitemVO implements Serializable {

    private String filecode;

    private Short itemid;

    private String itemcode;

    private Byte isnull;

    private Byte itemtype;

    private Short itemlength;

    private String itemformat;

    public FileitemVO(java.lang.String filecode, java.lang.Short itemid, java.lang.String itemcode, java.lang.Byte isnull, java.lang.Byte itemtype, java.lang.Short itemlength, java.lang.String itemformat) {
        this.filecode = filecode;
        this.itemid = itemid;
        this.itemcode = itemcode;
        this.isnull = isnull;
        this.itemtype = itemtype;
        this.itemlength = itemlength;
        this.itemformat = itemformat;
    }

    public FileitemVO() {
    }

    public FileitemVO(java.lang.String filecode, java.lang.Short itemid) {
        this.filecode = filecode;
        this.itemid = itemid;
    }

    public java.lang.String getFilecode() {
        return this.filecode;
    }

    public void setFilecode(java.lang.String filecode) {
        this.filecode = filecode;
    }

    public java.lang.Short getItemid() {
        return this.itemid;
    }

    public void setItemid(java.lang.Short itemid) {
        this.itemid = itemid;
    }

    public java.lang.String getItemcode() {
        return this.itemcode;
    }

    public void setItemcode(java.lang.String itemcode) {
        this.itemcode = itemcode;
    }

    public java.lang.Byte getIsnull() {
        return this.isnull;
    }

    public void setIsnull(java.lang.Byte isnull) {
        this.isnull = isnull;
    }

    public java.lang.Byte getItemtype() {
        return this.itemtype;
    }

    public void setItemtype(java.lang.Byte itemtype) {
        this.itemtype = itemtype;
    }

    public java.lang.Short getItemlength() {
        return this.itemlength;
    }

    public void setItemlength(java.lang.Short itemlength) {
        this.itemlength = itemlength;
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
        if ( !(other instanceof FileitemVO) ) return false;
        FileitemVO castOther = (FileitemVO) other;
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
