package com.gmcc.pboss.business.sales.orderpackdet;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class OrderpackdetVO extends BaseVO implements Serializable {

    /** identifier field */
    private Long detid;

    /** persistent field */
    private String orderid;

    /** nullable persistent field */
    private String comcategory;

    /** nullable persistent field */
    private String batchno;

    /** nullable persistent field */
    private String boxnum;

    /** full constructor */
    public OrderpackdetVO(java.lang.String orderid, java.lang.String comcategory, java.lang.String batchno, java.lang.String boxnum) {
        this.orderid = orderid;
        this.comcategory = comcategory;
        this.batchno = batchno;
        this.boxnum = boxnum;
    }

    /** default constructor */
    public OrderpackdetVO() {
    }

    /** minimal constructor */
    public OrderpackdetVO(java.lang.String orderid) {
        this.orderid = orderid;
    }

    public java.lang.Long getDetid() {
        return this.detid;
    }

    public void setDetid(java.lang.Long detid) {
        this.detid = detid;
    }

    public java.lang.String getOrderid() {
        return this.orderid;
    }

    public void setOrderid(java.lang.String orderid) {
        this.orderid = orderid;
    }

    public java.lang.String getComcategory() {
        return this.comcategory;
    }

    public void setComcategory(java.lang.String comcategory) {
        this.comcategory = comcategory;
    }

    public java.lang.String getBatchno() {
        return this.batchno;
    }

    public void setBatchno(java.lang.String batchno) {
        this.batchno = batchno;
    }

    public java.lang.String getBoxnum() {
        return this.boxnum;
    }

    public void setBoxnum(java.lang.String boxnum) {
        this.boxnum = boxnum;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("detid", getDetid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof OrderpackdetVO) ) return false;
        OrderpackdetVO castOther = (OrderpackdetVO) other;
        return new EqualsBuilder()
            .append(this.getDetid(), castOther.getDetid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getDetid())
            .toHashCode();
    }

}
