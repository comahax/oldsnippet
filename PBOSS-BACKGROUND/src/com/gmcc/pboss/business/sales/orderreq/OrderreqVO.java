package com.gmcc.pboss.business.sales.orderreq;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.jop.infrastructure.db.BaseVO;

/** @author Hibernate CodeGenerator */
public class OrderreqVO extends BaseVO implements Serializable {

    /** identifier field */
    private String reqid;

    /** persistent field */
    private String cityid;

    /** persistent field */
    private String wayid;

    /** nullable persistent field */
    private String mobileno;

    /** nullable persistent field */
    private String orderave;

    /** nullable persistent field */
    private java.util.Date reqtime;

    /** nullable persistent field */
    private Short state;

    /** nullable persistent field */
    private String memo;

    /** full constructor */
    public OrderreqVO(java.lang.String cityid, java.lang.String wayid, java.lang.String mobileno, java.lang.String orderave, java.util.Date reqtime, java.lang.Short state, java.lang.String memo) {
        this.cityid = cityid;
        this.wayid = wayid;
        this.mobileno = mobileno;
        this.orderave = orderave;
        this.reqtime = reqtime;
        this.state = state;
        this.memo = memo;
    }

    /** default constructor */
    public OrderreqVO() {
    }

    /** minimal constructor */
    public OrderreqVO(java.lang.String cityid, java.lang.String wayid) {
        this.cityid = cityid;
        this.wayid = wayid;
    }

    public java.lang.String getReqid() {
        return this.reqid;
    }

    public void setReqid(java.lang.String reqid) {
        this.reqid = reqid;
    }

    public java.lang.String getCityid() {
        return this.cityid;
    }

    public void setCityid(java.lang.String cityid) {
        this.cityid = cityid;
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.String getMobileno() {
        return this.mobileno;
    }

    public void setMobileno(java.lang.String mobileno) {
        this.mobileno = mobileno;
    }

    public java.lang.String getOrderave() {
        return this.orderave;
    }

    public void setOrderave(java.lang.String orderave) {
        this.orderave = orderave;
    }

    public java.util.Date getReqtime() {
        return this.reqtime;
    }

    public void setReqtime(java.util.Date reqtime) {
        this.reqtime = reqtime;
    }

    public java.lang.Short getState() {
        return this.state;
    }

    public void setState(java.lang.Short state) {
        this.state = state;
    }

    public java.lang.String getMemo() {
        return this.memo;
    }

    public void setMemo(java.lang.String memo) {
        this.memo = memo;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("reqid", getReqid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof OrderreqVO) ) return false;
        OrderreqVO castOther = (OrderreqVO) other;
        return new EqualsBuilder()
            .append(this.getReqid(), castOther.getReqid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getReqid())
            .toHashCode();
    }

}
