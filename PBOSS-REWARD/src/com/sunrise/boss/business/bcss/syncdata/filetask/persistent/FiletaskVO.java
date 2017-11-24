package com.sunrise.boss.business.bcss.syncdata.filetask.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class FiletaskVO implements Serializable {

    /** identifier field */
    private Long serialno;

    /** nullable persistent field */
    private String filecode;

    /** nullable persistent field */
    private String filename;

    /** nullable persistent field */
    private String begdate;

    /** nullable persistent field */
    private String enddate;

    /** nullable persistent field */
    private Long totalcount;

    /** nullable persistent field */
    private Long currcount;

    /** nullable persistent field */
    private Byte success;

    /** full constructor */
    public FiletaskVO(java.lang.String filecode, java.lang.String filename, java.lang.String begdate, java.lang.String enddate, java.lang.Long totalcount, java.lang.Long currcount, java.lang.Byte success) {
        this.filecode = filecode;
        this.filename = filename;
        this.begdate = begdate;
        this.enddate = enddate;
        this.totalcount = totalcount;
        this.currcount = currcount;
        this.success = success;
    }

    /** default constructor */
    public FiletaskVO() {
    }

    public java.lang.Long getSerialno() {
        return this.serialno;
    }

    public void setSerialno(java.lang.Long serialno) {
        this.serialno = serialno;
    }

    public java.lang.String getFilecode() {
        return this.filecode;
    }

    public void setFilecode(java.lang.String filecode) {
        this.filecode = filecode;
    }

    public java.lang.String getFilename() {
        return this.filename;
    }

    public void setFilename(java.lang.String filename) {
        this.filename = filename;
    }

    public java.lang.String getBegdate() {
        return this.begdate;
    }

    public void setBegdate(java.lang.String begdate) {
        this.begdate = begdate;
    }

    public java.lang.String getEnddate() {
        return this.enddate;
    }

    public void setEnddate(java.lang.String enddate) {
        this.enddate = enddate;
    }

    public java.lang.Long getTotalcount() {
        return this.totalcount;
    }

    public void setTotalcount(java.lang.Long totalcount) {
        this.totalcount = totalcount;
    }

    public java.lang.Long getCurrcount() {
        return this.currcount;
    }

    public void setCurrcount(java.lang.Long currcount) {
        this.currcount = currcount;
    }

    public java.lang.Byte getSuccess() {
        return this.success;
    }

    public void setSuccess(java.lang.Byte success) {
        this.success = success;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("serialno", getSerialno())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof FiletaskVO) ) return false;
        FiletaskVO castOther = (FiletaskVO) other;
        return new EqualsBuilder()
            .append(this.getSerialno(), castOther.getSerialno())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getSerialno())
            .toHashCode();
    }

}
