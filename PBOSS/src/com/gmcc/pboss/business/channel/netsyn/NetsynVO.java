package com.gmcc.pboss.business.channel.netsyn;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class NetsynVO extends BaseVO implements Serializable {

    /** identifier field */
    private Long itemid;

    /** nullable persistent field */
    private String mobile;

    /** nullable persistent field */
    private Short opract;

    /** nullable persistent field */
    private String oprcode;

    /** nullable persistent field */
    private java.util.Date oprtime;

    /** full constructor */
    public NetsynVO(java.lang.Long itemid, java.lang.String mobile, java.lang.Short opract, java.lang.String oprcode, java.util.Date oprtime) {
        this.itemid = itemid;
        this.mobile = mobile;
        this.opract = opract;
        this.oprcode = oprcode;
        this.oprtime = oprtime;
    }

    /** default constructor */
    public NetsynVO() {
    }

    /** minimal constructor */
    public NetsynVO(java.lang.Long itemid) {
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

    public java.lang.String getOprcode() {
        return this.oprcode;
    }

    public void setOprcode(java.lang.String oprcode) {
        this.oprcode = oprcode;
    }

    public java.util.Date getOprtime() {
        return this.oprtime;
    }

    public void setOprtime(java.util.Date oprtime) {
        this.oprtime = oprtime;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("itemid", getItemid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof NetsynVO) ) return false;
        NetsynVO castOther = (NetsynVO) other;
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
