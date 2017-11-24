package com.gmcc.pboss.business.channel.netsynlog;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class NetsynlogVO extends BaseVO implements Serializable {

    /** identifier field */
    private Long itemid;

    /** nullable persistent field */
    private String mobile;

    /** nullable persistent field */
    private Short opract;

    /** nullable persistent field */
    private Short synstate;

    /** nullable persistent field */
    private String synmemo;

    /** nullable persistent field */
    private Short isopen;

    /** nullable persistent field */
    private String oprcode;

    /** full constructor */
    public NetsynlogVO(java.lang.Long itemid, java.lang.String mobile, java.lang.Short opract, java.lang.Short synstate, java.lang.String synmemo, java.lang.Short isopen, java.lang.String oprcode) {
        this.itemid = itemid;
        this.mobile = mobile;
        this.opract = opract;
        this.synstate = synstate;
        this.synmemo = synmemo;
        this.isopen = isopen;
        this.oprcode = oprcode;
    }

    /** default constructor */
    public NetsynlogVO() {
    }

    /** minimal constructor */
    public NetsynlogVO(java.lang.Long itemid) {
        this.itemid = itemid;
    }

    public java.lang.Long getItemid() {
        return this.itemid;
    }

    public void setItemid(java.lang.Long itemid) {
        this.itemid = itemid;
    }

    public java.lang.String getMobile() {
        return this.mobile;
    }

    public void setMobile(java.lang.String mobile) {
        this.mobile = mobile;
    }

    public java.lang.Short getOpract() {
        return this.opract;
    }

    public void setOpract(java.lang.Short opract) {
        this.opract = opract;
    }

    public java.lang.Short getSynstate() {
        return this.synstate;
    }

    public void setSynstate(java.lang.Short synstate) {
        this.synstate = synstate;
    }

    public java.lang.String getSynmemo() {
        return this.synmemo;
    }

    public void setSynmemo(java.lang.String synmemo) {
        this.synmemo = synmemo;
    }

    public java.lang.Short getIsopen() {
        return this.isopen;
    }

    public void setIsopen(java.lang.Short isopen) {
        this.isopen = isopen;
    }

    public java.lang.String getOprcode() {
        return this.oprcode;
    }

    public void setOprcode(java.lang.String oprcode) {
        this.oprcode = oprcode;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("itemid", getItemid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof NetsynlogVO) ) return false;
        NetsynlogVO castOther = (NetsynlogVO) other;
        return new EqualsBuilder()
            .append(this.getItemid(), castOther.getItemid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getItemid())
            .toHashCode();
    }

}
