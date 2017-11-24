package com.sunrise.boss.business.cms.kdkhzl.chpwbroadaccount.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class ChPwBroadaccountVO implements Serializable {

    /** identifier field */
    private Long broadid;

    /** nullable persistent field */
    private String account;

    /** full constructor */
    public ChPwBroadaccountVO(java.lang.Long broadid, java.lang.String account) {
        this.broadid = broadid;
        this.account = account;
    }

    /** default constructor */
    public ChPwBroadaccountVO() {
    }

    /** minimal constructor */
    public ChPwBroadaccountVO(java.lang.Long broadid) {
        this.broadid = broadid;
    }

    public java.lang.Long getBroadid() {
        return this.broadid;
    }

    public void setBroadid(java.lang.Long broadid) {
        this.broadid = broadid;
    }

    public java.lang.String getAccount() {
        return this.account;
    }

    public void setAccount(java.lang.String account) {
        this.account = account;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("broadid", getBroadid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ChPwBroadaccountVO) ) return false;
        ChPwBroadaccountVO castOther = (ChPwBroadaccountVO) other;
        return new EqualsBuilder()
            .append(this.getBroadid(), castOther.getBroadid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getBroadid())
            .toHashCode();
    }

}
