package com.sunrise.boss.business.cms.chpwwaybusicircle.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.boss.business.cms.chpwwaybusicirclelog.persistent.ChPwWaybusicirclelogVO;
import com.sunrise.boss.business.common.dblog.OperationLog;

/** @author Hibernate CodeGenerator */
public class ChPwWaybusicircleVO implements OperationLog {

    /** identifier field */
    private Long seq;

    /** nullable persistent field */
    private String buscno;

    /** nullable persistent field */
    private String wayid;

    /** nullable persistent field */
    private Float waymod;

    /** nullable persistent field */
    private Short rewardkind;

    /** nullable persistent field */
    private java.util.Date createtime;

    /** nullable persistent field */
    private String wayattr;

    /** full constructor */
    public ChPwWaybusicircleVO(java.lang.Long seq, java.lang.String buscno, java.lang.String wayid, java.lang.Float waymod, java.lang.Short rewardkind, java.util.Date createtime, java.lang.String wayattr) {
        this.seq = seq;
        this.buscno = buscno;
        this.wayid = wayid;
        this.waymod = waymod;
        this.rewardkind = rewardkind;
        this.createtime = createtime;
        this.wayattr = wayattr;
    }

    /** default constructor */
    public ChPwWaybusicircleVO() {
    }

    /** minimal constructor */
    public ChPwWaybusicircleVO(java.lang.Long seq) {
        this.seq = seq;
    }

    public java.lang.Long getSeq() {
        return this.seq;
    }

    public void setSeq(java.lang.Long seq) {
        this.seq = seq;
    }

    public java.lang.String getBuscno() {
        return this.buscno;
    }

    public void setBuscno(java.lang.String buscno) {
        this.buscno = buscno;
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.Float getWaymod() {
        return this.waymod;
    }

    public void setWaymod(java.lang.Float waymod) {
        this.waymod = waymod;
    }

    public java.lang.Short getRewardkind() {
        return this.rewardkind;
    }

    public void setRewardkind(java.lang.Short rewardkind) {
        this.rewardkind = rewardkind;
    }

    public java.util.Date getCreatetime() {
        return this.createtime;
    }

    public void setCreatetime(java.util.Date createtime) {
        this.createtime = createtime;
    }

    public java.lang.String getWayattr() {
        return this.wayattr;
    }

    public void setWayattr(java.lang.String wayattr) {
        this.wayattr = wayattr;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("seq", getSeq())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ChPwWaybusicircleVO) ) return false;
        ChPwWaybusicircleVO castOther = (ChPwWaybusicircleVO) other;
        return new EqualsBuilder()
            .append(this.getSeq(), castOther.getSeq())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getSeq())
            .toHashCode();
    }

	public Class logVOClass() {
		return ChPwWaybusicirclelogVO.class;
	}

}
