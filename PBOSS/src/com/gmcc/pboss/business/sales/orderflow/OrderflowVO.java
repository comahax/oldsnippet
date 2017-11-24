package com.gmcc.pboss.business.sales.orderflow;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class OrderflowVO extends BaseVO implements Serializable {

    /** identifier field */
    private Long flowid;

    /** persistent field */
    private String flowname;

    /** persistent field */
    private String cityid;

    /** persistent field */
    private String orderave;

    /** persistent field */
    private String paytype;

    /** persistent field */
    private String delitype;

    /** persistent field */
    private Short effective;

    /** nullable persistent field */
    private String memo;

    /** full constructor */
    public OrderflowVO(java.lang.String flowname, java.lang.String cityid, java.lang.String orderave, java.lang.String paytype, java.lang.String delitype, java.lang.Short effective, java.lang.String memo) {
        this.flowname = flowname;
        this.cityid = cityid;
        this.orderave = orderave;
        this.paytype = paytype;
        this.delitype = delitype;
        this.effective = effective;
        this.memo = memo;
    }

    /** default constructor */
    public OrderflowVO() {
    }

    /** minimal constructor */
    public OrderflowVO(java.lang.String flowname, java.lang.String cityid, java.lang.String orderave, java.lang.String paytype, java.lang.String delitype, java.lang.Short effective) {
        this.flowname = flowname;
        this.cityid = cityid;
        this.orderave = orderave;
        this.paytype = paytype;
        this.delitype = delitype;
        this.effective = effective;
    }

    public java.lang.Long getFlowid() {
        return this.flowid;
    }

    public void setFlowid(java.lang.Long flowid) {
        this.flowid = flowid;
    }

    public java.lang.String getFlowname() {
        return this.flowname;
    }

    public void setFlowname(java.lang.String flowname) {
        this.flowname = flowname;
    }

    public java.lang.String getCityid() {
        return this.cityid;
    }

    public void setCityid(java.lang.String cityid) {
        this.cityid = cityid;
    }

    public java.lang.String getOrderave() {
        return this.orderave;
    }

    public void setOrderave(java.lang.String orderave) {
        this.orderave = orderave;
    }

    public java.lang.String getPaytype() {
        return this.paytype;
    }

    public void setPaytype(java.lang.String paytype) {
        this.paytype = paytype;
    }

    public java.lang.String getDelitype() {
        return this.delitype;
    }

    public void setDelitype(java.lang.String delitype) {
        this.delitype = delitype;
    }

    public java.lang.Short getEffective() {
        return this.effective;
    }

    public void setEffective(java.lang.Short effective) {
        this.effective = effective;
    }

    public java.lang.String getMemo() {
        return this.memo;
    }

    public void setMemo(java.lang.String memo) {
        this.memo = memo;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("flowid", getFlowid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof OrderflowVO) ) return false;
        OrderflowVO castOther = (OrderflowVO) other;
        return new EqualsBuilder()
            .append(this.getFlowid(), castOther.getFlowid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getFlowid())
            .toHashCode();
    }

}
