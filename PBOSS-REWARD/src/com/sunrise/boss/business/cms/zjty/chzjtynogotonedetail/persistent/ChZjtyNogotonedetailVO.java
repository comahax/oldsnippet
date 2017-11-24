package com.sunrise.boss.business.cms.zjty.chzjtynogotonedetail.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class ChZjtyNogotonedetailVO implements Serializable {

    /** identifier field */
    private Long recid;

    /** nullable persistent field */
    private Long mark;

    /** nullable persistent field */
    private String datacontent;

    /** nullable persistent field */
    private String type;

    /** full constructor */
    public ChZjtyNogotonedetailVO(java.lang.Long mark, java.lang.String datacontent, java.lang.String type) {
        this.mark = mark;
        this.datacontent = datacontent;
        this.type = type;
    }

    /** default constructor */
    public ChZjtyNogotonedetailVO() {
    }

    public java.lang.Long getRecid() {
        return this.recid;
    }

    public void setRecid(java.lang.Long recid) {
        this.recid = recid;
    }

    public java.lang.Long getMark() {
        return this.mark;
    }

    public void setMark(java.lang.Long mark) {
        this.mark = mark;
    }

    public java.lang.String getDatacontent() {
        return this.datacontent;
    }

    public void setDatacontent(java.lang.String datacontent) {
        this.datacontent = datacontent;
    }

    public java.lang.String getType() {
        return this.type;
    }

    public void setType(java.lang.String type) {
        this.type = type;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("recid", getRecid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ChZjtyNogotonedetailVO) ) return false;
        ChZjtyNogotonedetailVO castOther = (ChZjtyNogotonedetailVO) other;
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
