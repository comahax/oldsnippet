package com.gmcc.pboss.business.sales.adpaydet;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class AdpaydetVO extends BaseVO implements Serializable {

    /** identifier field */
    private String orderid;

    /** identifier field */
    private Long sumid;

    /** full constructor */
    public AdpaydetVO(java.lang.String orderid, java.lang.Long sumid) {
        this.orderid = orderid;
        this.sumid = sumid;
    }

    /** default constructor */
    public AdpaydetVO() {
    }

    public java.lang.String getOrderid() {
        return this.orderid;
    }

    public void setOrderid(java.lang.String orderid) {
        this.orderid = orderid;
    }

    public java.lang.Long getSumid() {
        return this.sumid;
    }

    public void setSumid(java.lang.Long sumid) {
        this.sumid = sumid;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("orderid", getOrderid())
            .append("sumid", getSumid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof AdpaydetVO) ) return false;
        AdpaydetVO castOther = (AdpaydetVO) other;
        return new EqualsBuilder()
            .append(this.getOrderid(), castOther.getOrderid())
            .append(this.getSumid(), castOther.getSumid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getOrderid())
            .append(getSumid())
            .toHashCode();
    }

}
