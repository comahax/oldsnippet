package com.gmcc.pboss.business.cms.examine.itemgradedlog.persistent;


import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.jop.infrastructure.db.BaseVO;

/** @author Hibernate CodeGenerator */
public class ItemgradedlogVO  extends BaseVO implements Serializable {

    /** identifier field */
    private Long logid;

    /** nullable persistent field */
    private java.util.Date optime;

    /** nullable persistent field */
    private String oprcode;

    /** nullable persistent field */
    private String oprtype;

    /** nullable persistent field */
    private String success;

    /** nullable persistent field */
    private Long seqid;

    /** nullable persistent field */
    private String wayid;

    /** nullable persistent field */
    private Integer exmnid;

    /** nullable persistent field */
    private Integer exmnstdid;

    /** nullable persistent field */
    private String exmnperiod;

    /** nullable persistent field */
    private Float penalmark;

    /** nullable persistent field */
    private String memo;

    /** nullable persistent field */
    private String registercode;

    /** nullable persistent field */
    private String state;

    /** nullable persistent field */
    private String curauditor;

    /** full constructor */
    public ItemgradedlogVO(java.lang.Long logid, java.util.Date optime, java.lang.String oprcode, java.lang.String oprtype, java.lang.String success, java.lang.Long seqid, java.lang.String wayid, java.lang.Integer exmnid, java.lang.Integer exmnstdid, java.lang.String exmnperiod, java.lang.Float penalmark, java.lang.String memo, java.lang.String registercode, java.lang.String state, java.lang.String curauditor) {
        this.logid = logid;
        this.optime = optime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
        this.success = success;
        this.seqid = seqid;
        this.wayid = wayid;
        this.exmnid = exmnid;
        this.exmnstdid = exmnstdid;
        this.exmnperiod = exmnperiod;
        this.penalmark = penalmark;
        this.memo = memo;
        this.registercode = registercode;
        this.state = state;
        this.curauditor = curauditor;
    }

    /** default constructor */
    public ItemgradedlogVO() {
    }

    /** minimal constructor */
    public ItemgradedlogVO(java.lang.Long logid) {
        this.logid = logid;
    }

    public java.lang.Long getLogid() {
        return this.logid;
    }

    public void setLogid(java.lang.Long logid) {
        this.logid = logid;
    }

    public java.util.Date getOptime() {
        return this.optime;
    }

    public void setOptime(java.util.Date optime) {
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

    public java.lang.Long getSeqid() {
        return this.seqid;
    }

    public void setSeqid(java.lang.Long seqid) {
        this.seqid = seqid;
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.Integer getExmnid() {
        return this.exmnid;
    }

    public void setExmnid(java.lang.Integer exmnid) {
        this.exmnid = exmnid;
    }

    public java.lang.Integer getExmnstdid() {
        return this.exmnstdid;
    }

    public void setExmnstdid(java.lang.Integer exmnstdid) {
        this.exmnstdid = exmnstdid;
    }

    public java.lang.String getExmnperiod() {
        return this.exmnperiod;
    }

    public void setExmnperiod(java.lang.String exmnperiod) {
        this.exmnperiod = exmnperiod;
    }

    public java.lang.Float getPenalmark() {
        return this.penalmark;
    }

    public void setPenalmark(java.lang.Float penalmark) {
        this.penalmark = penalmark;
    }

    public java.lang.String getMemo() {
        return this.memo;
    }

    public void setMemo(java.lang.String memo) {
        this.memo = memo;
    }

    public java.lang.String getRegistercode() {
        return this.registercode;
    }

    public void setRegistercode(java.lang.String registercode) {
        this.registercode = registercode;
    }

    public java.lang.String getState() {
        return this.state;
    }

    public void setState(java.lang.String state) {
        this.state = state;
    }

    public java.lang.String getCurauditor() {
        return this.curauditor;
    }

    public void setCurauditor(java.lang.String curauditor) {
        this.curauditor = curauditor;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("logid", getLogid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ItemgradedlogVO) ) return false;
        ItemgradedlogVO castOther = (ItemgradedlogVO) other;
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
