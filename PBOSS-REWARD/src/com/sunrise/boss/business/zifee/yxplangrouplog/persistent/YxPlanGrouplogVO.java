package com.sunrise.boss.business.zifee.yxplangrouplog.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class YxPlanGrouplogVO implements Serializable {

    /** identifier field */
    private Long logid;

    /** persistent field */
    private java.sql.Timestamp optime;

    /** persistent field */
    private String oprcode;

    /** persistent field */
    private String oprtype;

    /** nullable persistent field */
    private String success;

    /** persistent field */
    private Long memyxplan;

    /** persistent field */
    private Long groupyxplan;

    /** full constructor */
    public YxPlanGrouplogVO(java.lang.Long logid, java.sql.Timestamp optime, java.lang.String oprcode, java.lang.String oprtype, java.lang.String success, java.lang.Long memyxplan, java.lang.Long groupyxplan) {
        this.logid = logid;
        this.optime = optime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
        this.success = success;
        this.memyxplan = memyxplan;
        this.groupyxplan = groupyxplan;
    }

    /** default constructor */
    public YxPlanGrouplogVO() {
    }

    /** minimal constructor */
    public YxPlanGrouplogVO(java.lang.Long logid, java.sql.Timestamp optime, java.lang.String oprcode, java.lang.String oprtype, java.lang.Long memyxplan, java.lang.Long groupyxplan) {
        this.logid = logid;
        this.optime = optime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
        this.memyxplan = memyxplan;
        this.groupyxplan = groupyxplan;
    }

    public java.lang.Long getLogid() {
        return this.logid;
    }

    public void setLogid(java.lang.Long logid) {
        this.logid = logid;
    }

    public java.sql.Timestamp getOptime() {
        return this.optime;
    }

    public void setOptime(java.sql.Timestamp optime) {
        this.optime = optime;
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

    public java.lang.String getSuccess() {
        return this.success;
    }

    public void setSuccess(java.lang.String success) {
        this.success = success;
    }

    public java.lang.Long getMemyxplan() {
        return this.memyxplan;
    }

    public void setMemyxplan(java.lang.Long memyxplan) {
        this.memyxplan = memyxplan;
    }

    public java.lang.Long getGroupyxplan() {
        return this.groupyxplan;
    }

    public void setGroupyxplan(java.lang.Long groupyxplan) {
        this.groupyxplan = groupyxplan;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("logid", getLogid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof YxPlanGrouplogVO) ) return false;
        YxPlanGrouplogVO castOther = (YxPlanGrouplogVO) other;
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
