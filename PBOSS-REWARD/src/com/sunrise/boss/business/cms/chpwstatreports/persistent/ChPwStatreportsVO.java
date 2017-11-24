package com.sunrise.boss.business.cms.chpwstatreports.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class ChPwStatreportsVO implements Serializable {

    /** identifier field */
    private Long seq;

    /** nullable persistent field */
    private String cityid;

    /** nullable persistent field */
    private Byte state;

    /** nullable persistent field */
    private String filepath;

    /** nullable persistent field */
    private String filename;

    /** nullable persistent field */
    private String remark;

    /** full constructor */
    public ChPwStatreportsVO(java.lang.Long seq, java.lang.String cityid, java.lang.Byte state, java.lang.String filepath, java.lang.String filename, java.lang.String remark) {
        this.seq = seq;
        this.cityid = cityid;
        this.state = state;
        this.filepath = filepath;
        this.filename = filename;
        this.remark = remark;
    }

    /** default constructor */
    public ChPwStatreportsVO() {
    }

    /** minimal constructor */
    public ChPwStatreportsVO(java.lang.Long seq) {
        this.seq = seq;
    }

    public java.lang.Long getSeq() {
        return this.seq;
    }

    public void setSeq(java.lang.Long seq) {
        this.seq = seq;
    }

    public java.lang.String getCityid() {
        return this.cityid;
    }

    public void setCityid(java.lang.String cityid) {
        this.cityid = cityid;
    }

    public java.lang.Byte getState() {
        return this.state;
    }

    public void setState(java.lang.Byte state) {
        this.state = state;
    }

    public java.lang.String getFilepath() {
        return this.filepath;
    }

    public void setFilepath(java.lang.String filepath) {
        this.filepath = filepath;
    }

    public java.lang.String getFilename() {
        return this.filename;
    }

    public void setFilename(java.lang.String filename) {
        this.filename = filename;
    }

    public java.lang.String getRemark() {
        return this.remark;
    }

    public void setRemark(java.lang.String remark) {
        this.remark = remark;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("seq", getSeq())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ChPwStatreportsVO) ) return false;
        ChPwStatreportsVO castOther = (ChPwStatreportsVO) other;
        return new EqualsBuilder()
            .append(this.getSeq(), castOther.getSeq())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getSeq())
            .toHashCode();
    }

}
