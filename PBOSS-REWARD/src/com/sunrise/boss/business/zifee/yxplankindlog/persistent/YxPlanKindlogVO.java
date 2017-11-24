package com.sunrise.boss.business.zifee.yxplankindlog.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class YxPlanKindlogVO implements Serializable {

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

    /** nullable persistent field */
    private Long yxplankindid;

    /** nullable persistent field */
    private String yxplankindname;

    /** full constructor */
    public YxPlanKindlogVO(java.lang.Long logid, java.sql.Timestamp optime, java.lang.String oprcode, java.lang.String oprtype, java.lang.String success, java.lang.Long yxplankindid, java.lang.String yxplankindname) {
        this.logid = logid;
        this.optime = optime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
        this.success = success;
        this.yxplankindid = yxplankindid;
        this.yxplankindname = yxplankindname;
    }

    /** default constructor */
    public YxPlanKindlogVO() {
    }

    /** minimal constructor */
    public YxPlanKindlogVO(java.lang.Long logid, java.sql.Timestamp optime, java.lang.String oprcode, java.lang.String oprtype) {
        this.logid = logid;
        this.optime = optime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
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

    public java.lang.Long getYxplankindid() {
        return this.yxplankindid;
    }

    public void setYxplankindid(java.lang.Long yxplankindid) {
        this.yxplankindid = yxplankindid;
    }

    public java.lang.String getYxplankindname() {
        return this.yxplankindname;
    }

    public void setYxplankindname(java.lang.String yxplankindname) {
        this.yxplankindname = yxplankindname;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("logid", getLogid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof YxPlanKindlogVO) ) return false;
        YxPlanKindlogVO castOther = (YxPlanKindlogVO) other;
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
