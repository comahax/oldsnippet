package com.gmcc.pboss.business.sales.orderplan;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class OrderplanVO extends BaseVO implements Serializable {

    /** identifier field */
    private Long recid;

    /** persistent field */
    private String orderid;

    /** persistent field */
    private Long saleplan;

    /** nullable persistent field */
    private Long ruleid;

    /** full constructor */
    public OrderplanVO(java.lang.Long recid, java.lang.String orderid,Long saleplan,Long ruleid) {
        this.recid = recid;
        this.orderid = orderid;
        this.saleplan = saleplan;
        this.ruleid = ruleid;
    }

    /** default constructor */
    public OrderplanVO() {
    }

    /** minimal constructor */
    public OrderplanVO(java.lang.Long recid, java.lang.String orderid, Long saleplan) {
        this.recid = recid;
        this.orderid = orderid;
        this.saleplan = saleplan;
    }

    public java.lang.Long getRecid() {
        return this.recid;
    }

    public void setRecid(java.lang.Long recid) {
        this.recid = recid;
    }

    public java.lang.String getOrderid() {
        return this.orderid;
    }

    public void setOrderid(java.lang.String orderid) {
        this.orderid = orderid;
    }

    public Long getSaleplan() {
        return this.saleplan;
    }

    public void setSaleplan(Long saleplan) {
        this.saleplan = saleplan;
    }

    public Long getRuleid() {
        return this.ruleid;
    }

    public void setRuleid(Long ruleid) {
        this.ruleid = ruleid;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("recid", getRecid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof OrderplanVO) ) return false;
        OrderplanVO castOther = (OrderplanVO) other;
        return new EqualsBuilder()
            .append(this.getRecid(), castOther.getRecid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getRecid())
            .toHashCode();
    }

}
