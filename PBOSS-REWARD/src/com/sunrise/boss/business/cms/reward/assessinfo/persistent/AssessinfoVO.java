package com.sunrise.boss.business.cms.reward.assessinfo.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class AssessinfoVO implements Serializable {

    /** identifier field */
    private Long seqid;

    /** nullable persistent field */
    private String cityid;

    /** nullable persistent field */
    private String asseremark;

    /** nullable persistent field */
    private Short type;

    /** full constructor */
    public AssessinfoVO(java.lang.String cityid, java.lang.String asseremark, java.lang.Short type) {
        this.cityid = cityid;
        this.asseremark = asseremark;
        this.type = type;
    }

    /** default constructor */
    public AssessinfoVO() {
    }

    public java.lang.Long getSeqid() {
        return this.seqid;
    }

    public void setSeqid(java.lang.Long seqid) {
        this.seqid = seqid;
    }

    public java.lang.String getCityid() {
        return this.cityid;
    }

    public void setCityid(java.lang.String cityid) {
        this.cityid = cityid;
    }

    public java.lang.String getAsseremark() {
        return this.asseremark;
    }

    public void setAsseremark(java.lang.String asseremark) {
        this.asseremark = asseremark;
    }

    public java.lang.Short getType() {
        return this.type;
    }

    public void setType(java.lang.Short type) {
        this.type = type;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("seqid", getSeqid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof AssessinfoVO) ) return false;
        AssessinfoVO castOther = (AssessinfoVO) other;
        return new EqualsBuilder()
            .append(this.getSeqid(), castOther.getSeqid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getSeqid())
            .toHashCode();
    }

}
