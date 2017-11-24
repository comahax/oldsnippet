package com.sunrise.boss.business.zifee.log.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class YxPlanFeeLogVO implements Serializable {

    /** identifier field */
    private Long logid;

    /** nullable persistent field */
    private java.util.Date oprtime;

    /** nullable persistent field */
    private String oprcode;

    /** nullable persistent field */
    private String oprtype;

    /** nullable persistent field */
    private String oprobject;

    /** nullable persistent field */
    private String oprresult;

    /** full constructor */
    public YxPlanFeeLogVO(java.util.Date oprtime, java.lang.String oprcode, java.lang.String oprtype, java.lang.String oprobject, java.lang.String oprresult) {
        this.oprtime = oprtime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
        this.oprobject = oprobject;
        this.oprresult = oprresult;
    }

    /** default constructor */
    public YxPlanFeeLogVO() {
    }

    public java.lang.Long getLogid() {
        return this.logid;
    }

    public void setLogid(java.lang.Long logid) {
        this.logid = logid;
    }

    public java.util.Date getOprtime() {
        return this.oprtime;
    }

    public void setOprtime(java.util.Date oprtime) {
        this.oprtime = oprtime;
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

    public java.lang.String getOprobject() {
        return this.oprobject;
    }

    public void setOprobject(java.lang.String oprobject) {
        this.oprobject = oprobject;
    }

    public java.lang.String getOprresult() {
        return this.oprresult;
    }

    public void setOprresult(java.lang.String oprresult) {
        this.oprresult = oprresult;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("logid", getLogid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof YxPlanFeeLogVO) ) return false;
        YxPlanFeeLogVO castOther = (YxPlanFeeLogVO) other;
        return new EqualsBuilder()
            .append(this.getLogid(), castOther.getLogid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getLogid())
            .toHashCode();
    }

}
