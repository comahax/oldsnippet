package com.sunrise.boss.business.cms.fee.bail.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.boss.business.cms.fee.baillog.persistent.BaillogVO;
import com.sunrise.boss.business.common.dblog.OperationLog;

/** @author Hibernate CodeGenerator */
public class BailVO  implements  OperationLog {

	/**
     * 返回对应的logVO类. 
     */
    public Class logVOClass() {
    	return BaillogVO.class;
    }
	
	/** identifier field */
    private Long seq;

    /** persistent field */
    private String wayid;

    /** persistent field */
    private Short bailtype;

    /** persistent field */
    private Double money;

    /** nullable persistent field */
    private java.util.Date givetime;

    /** persistent field */
    private Short opertype;

    /** nullable persistent field */
    private String recvoprcode;

    /** nullable persistent field */
    private java.util.Date recvtime;

    /** nullable persistent field */
    private String memo;

    /** full constructor */
    public BailVO(java.lang.Long seq, java.lang.String wayid, java.lang.Short bailtype, java.lang.Double money, java.util.Date givetime, java.lang.Short opertype, java.lang.String recvoprcode, java.util.Date recvtime, java.lang.String memo) {
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
    public BailVO() {
    }

    /** minimal constructor */
    public BailVO(java.lang.Long seq, java.lang.String wayid, java.lang.Short bailtype, java.lang.Double money, java.lang.Short opertype) {
        this.seq = seq;
        this.wayid = wayid;
        this.bailtype = bailtype;
        this.money = money;
        this.opertype = opertype;
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

    public java.util.Date getGivetime() {
        return this.givetime;
    }

    public void setGivetime(java.util.Date givetime) {
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

    public java.util.Date getRecvtime() {
        return this.recvtime;
    }

    public void setRecvtime(java.util.Date recvtime) {
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
            .append("seq", getSeq())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof BailVO) ) return false;
        BailVO castOther = (BailVO) other;
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
