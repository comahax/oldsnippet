package com.sunrise.boss.business.zifee.yxplansplitscalelog.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class YxPlanSplitScalelogVO implements Serializable {

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
    private Long yxplanid;

    /** nullable persistent field */
    private Long yxplankindid;

    /** nullable persistent field */
    private Long yxplantypeid;

    /** nullable persistent field */
    private String yxplanitemid;

    /** nullable persistent field */
    private Float scale;

    /** full constructor */
    public YxPlanSplitScalelogVO(java.lang.Long logid, java.sql.Timestamp optime, java.lang.String oprcode, java.lang.String oprtype, java.lang.String success, java.lang.Long yxplanid, java.lang.Long yxplankindid, java.lang.Long yxplantypeid, java.lang.String yxplanitemid, java.lang.Float scale) {
        this.logid = logid;
        this.optime = optime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
        this.success = success;
        this.yxplanid = yxplanid;
        this.yxplankindid = yxplankindid;
        this.yxplantypeid = yxplantypeid;
        this.yxplanitemid = yxplanitemid;
        this.scale = scale;
    }

    /** default constructor */
    public YxPlanSplitScalelogVO() {
    }

    /** minimal constructor */
    public YxPlanSplitScalelogVO(java.lang.Long logid, java.sql.Timestamp optime, java.lang.String oprcode, java.lang.String oprtype) {
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

    public java.lang.Long getYxplanid() {
        return this.yxplanid;
    }

    public void setYxplanid(java.lang.Long yxplanid) {
        this.yxplanid = yxplanid;
    }

    public java.lang.Long getYxplankindid() {
        return this.yxplankindid;
    }

    public void setYxplankindid(java.lang.Long yxplankindid) {
        this.yxplankindid = yxplankindid;
    }

    public java.lang.Long getYxplantypeid() {
        return this.yxplantypeid;
    }

    public void setYxplantypeid(java.lang.Long yxplantypeid) {
        this.yxplantypeid = yxplantypeid;
    }

    public java.lang.String getYxplanitemid() {
        return this.yxplanitemid;
    }

    public void setYxplanitemid(java.lang.String yxplanitemid) {
        this.yxplanitemid = yxplanitemid;
    }

    public java.lang.Float getScale() {
        return this.scale;
    }

    public void setScale(java.lang.Float scale) {
        this.scale = scale;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("logid", getLogid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof YxPlanSplitScalelogVO) ) return false;
        YxPlanSplitScalelogVO castOther = (YxPlanSplitScalelogVO) other;
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
