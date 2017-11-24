package com.sunrise.boss.business.zifee.areagroupscalelog.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class AreaGroupScalelogVO implements Serializable {

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
    private Long areagroupid;

    /** nullable persistent field */
    private String areacode;

    /** nullable persistent field */
    private java.util.Date effdate;

    /** nullable persistent field */
    private java.util.Date expdate;

    /** full constructor */
    public AreaGroupScalelogVO(java.lang.Long logid, java.sql.Timestamp optime, java.lang.String oprcode, java.lang.String oprtype, java.lang.String success, java.lang.Long areagroupid, java.lang.String areacode, java.util.Date effdate, java.util.Date expdate) {
        this.logid = logid;
        this.optime = optime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
        this.success = success;
        this.areagroupid = areagroupid;
        this.areacode = areacode;
        this.effdate = effdate;
        this.expdate = expdate;
    }

    /** default constructor */
    public AreaGroupScalelogVO() {
    }

    /** minimal constructor */
    public AreaGroupScalelogVO(java.lang.Long logid, java.sql.Timestamp optime, java.lang.String oprcode, java.lang.String oprtype) {
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

    public java.lang.Long getAreagroupid() {
        return this.areagroupid;
    }

    public void setAreagroupid(java.lang.Long areagroupid) {
        this.areagroupid = areagroupid;
    }

    public java.lang.String getAreacode() {
        return this.areacode;
    }

    public void setAreacode(java.lang.String areacode) {
        this.areacode = areacode;
    }

    public java.util.Date getEffdate() {
        return this.effdate;
    }

    public void setEffdate(java.util.Date effdate) {
        this.effdate = effdate;
    }

    public java.util.Date getExpdate() {
        return this.expdate;
    }

    public void setExpdate(java.util.Date expdate) {
        this.expdate = expdate;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("logid", getLogid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof AreaGroupScalelogVO) ) return false;
        AreaGroupScalelogVO castOther = (AreaGroupScalelogVO) other;
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
