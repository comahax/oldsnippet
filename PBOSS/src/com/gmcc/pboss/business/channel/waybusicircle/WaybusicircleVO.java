package com.gmcc.pboss.business.channel.waybusicircle;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.gmcc.pboss.business.channel.waybusicirclelog.WaybusicirclelogVO;
import com.sunrise.jop.infrastructure.db.BaseVO;
import com.sunrise.jop.infrastructure.sysadmin.BusinessLog;

/** @author Hibernate CodeGenerator */
public class WaybusicircleVO extends BaseVO implements Serializable,BusinessLog {

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
    
    private String wayattr;

    /** nullable persistent field */
    private java.util.Date createtime;

    /** full constructor */
    public WaybusicircleVO(java.lang.Long seq, java.lang.String buscno, java.lang.String wayid, java.lang.Float waymod, java.lang.Short rewardkind, java.util.Date createtime) {
        this.seq = seq;
        this.buscno = buscno;
        this.wayid = wayid;
        this.waymod = waymod;
        this.rewardkind = rewardkind;
        this.createtime = createtime;
    }

    /** default constructor */
    public WaybusicircleVO() {
    }

    /** minimal constructor */
    public WaybusicircleVO(java.lang.Long seq) {
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

    public String toString() {
        return new ToStringBuilder(this)
            .append("seq", getSeq())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof WaybusicircleVO) ) return false;
        WaybusicircleVO castOther = (WaybusicircleVO) other;
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
		// TODO Auto-generated method stub
		return WaybusicirclelogVO.class;
	}

	public String getWayattr() {
		return wayattr;
	}

	public void setWayattr(String wayattr) {
		this.wayattr = wayattr;
	}

}
