package com.sunrise.boss.business.cms.fee.baillog.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class BaillogVO implements Serializable {

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
    private Long seq;

    /** persistent field */
    private String wayid;

    /** persistent field */
    private Short bailtype;

    /** persistent field */
    private Double money;

    /** nullable persistent field */
    private java.sql.Timestamp givetime;

    /** persistent field */
    private Short opertype;

    /** nullable persistent field */
    private String recvoprcode;

    /** nullable persistent field */
    private java.sql.Timestamp recvtime;

    /** nullable persistent field */
    private String memo;

    /** full constructor */
    public BaillogVO(java.lang.Long logid, java.sql.Timestamp optime, java.lang.String oprcode, java.lang.String oprtype, java.lang.String success, java.lang.Long seq, java.lang.String wayid, java.lang.Short bailtype, java.lang.Double money, java.sql.Timestamp givetime, java.lang.Short opertype, java.lang.String recvoprcode, java.sql.Timestamp recvtime, java.lang.String memo) {
        this.logid = logid;
        this.optime = optime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
        this.success = success;
        this.seq = seq;
        this.wayid = wayid;
        this.bailtype = bailtype;
        this.money = money;
        this.givetime = givetime;
        this.opertype = opertype;
        this.recvoprcode = recvoprcode;
        this.recvtime = recvtime;
        this.memo = memo;
    }

    /** default constructor */
    public BaillogVO() {
    }

    /** minimal constructor */
    public BaillogVO(java.lang.Long logid, java.sql.Timestamp optime, java.lang.String oprcode, java.lang.String oprtype, java.lang.String wayid, java.lang.Short bailtype, java.lang.Double money, java.lang.Short opertype) {
        this.logid = logid;
        this.optime = optime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
        this.wayid = wayid;
        this.bailtype = bailtype;
        this.money = money;
        this.opertype = opertype;
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

    public java.lang.Long getSeq() {
        return this.seq;
    }

    public void setSeq(java.lang.Long seq) {
        this.seq = seq;
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.Short getBailtype() {
        return this.bailtype;
    }

    public void setBailtype(java.lang.Short bailtype) {
        this.bailtype = bailtype;
    }

    public java.lang.Double getMoney() {
        return this.money;
    }

    public void setMoney(java.lang.Double money) {
        this.money = money;
    }

    public java.sql.Timestamp getGivetime() {
        return this.givetime;
    }

    public void setGivetime(java.sql.Timestamp givetime) {
        this.givetime = givetime;
    }

    public java.lang.Short getOpertype() {
        return this.opertype;
    }

    public void setOpertype(java.lang.Short opertype) {
        this.opertype = opertype;
    }

    public java.lang.String getRecvoprcode() {
        return this.recvoprcode;
    }

    public void setRecvoprcode(java.lang.String recvoprcode) {
        this.recvoprcode = recvoprcode;
    }

    public java.sql.Timestamp getRecvtime() {
        return this.recvtime;
    }

    public void setRecvtime(java.sql.Timestamp recvtime) {
        this.recvtime = recvtime;
    }

    public java.lang.String getMemo() {
        return this.memo;
    }

    public void setMemo(java.lang.String memo) {
        this.memo = memo;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("logid", getLogid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof BaillogVO) ) return false;
        BaillogVO castOther = (BaillogVO) other;
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
