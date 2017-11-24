package com.gmcc.pboss.business.channel.flowname;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class FlownameVO extends BaseVO implements Serializable {

    /** identifier field */
    private String stepid;

    /** nullable persistent field */
    private String stepname;

    /** nullable persistent field */
    private String oprcode;

    /** nullable persistent field */
    private Short issms;

    /** nullable persistent field */
    private String sendtime;

    /** nullable persistent field */
    private String nextstepid;

    /** full constructor */
    public FlownameVO(java.lang.String stepid, java.lang.String stepname, java.lang.String oprcode, java.lang.Short issms, java.lang.String sendtime, java.lang.String nextstepid) {
        this.stepid = stepid;
        this.stepname = stepname;
        this.oprcode = oprcode;
        this.issms = issms;
        this.sendtime = sendtime;
        this.nextstepid = nextstepid;
    }

    /** default constructor */
    public FlownameVO() {
    }

    /** minimal constructor */
    public FlownameVO(java.lang.String stepid) {
        this.stepid = stepid;
    }

    public java.lang.String getStepid() {
        return this.stepid;
    }

    public void setStepid(java.lang.String stepid) {
        this.stepid = stepid;
    }

    public java.lang.String getStepname() {
        return this.stepname;
    }

    public void setStepname(java.lang.String stepname) {
        this.stepname = stepname;
    }

    public java.lang.String getOprcode() {
        return this.oprcode;
    }

    public void setOprcode(java.lang.String oprcode) {
        this.oprcode = oprcode;
    }

    public java.lang.Short getIssms() {
        return this.issms;
    }

    public void setIssms(java.lang.Short issms) {
        this.issms = issms;
    }

    public java.lang.String getSendtime() {
        return this.sendtime;
    }

    public void setSendtime(java.lang.String sendtime) {
        this.sendtime = sendtime;
    }

    public java.lang.String getNextstepid() {
        return this.nextstepid;
    }

    public void setNextstepid(java.lang.String nextstepid) {
        this.nextstepid = nextstepid;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("stepid", getStepid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof FlownameVO) ) return false;
        FlownameVO castOther = (FlownameVO) other;
        return new EqualsBuilder()
            .append(this.getStepid(), castOther.getStepid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getStepid())
            .toHashCode();
    }

}
