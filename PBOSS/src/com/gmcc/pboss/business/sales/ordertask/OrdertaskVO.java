package com.gmcc.pboss.business.sales.ordertask;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class OrdertaskVO extends BaseVO implements Serializable {

    /** identifier field */
    private Long recid;

    /** persistent field */
    private String cityid;

    /** nullable persistent field */
    private String orderid;

    /** nullable persistent field */
    private Short effective;

    /** nullable persistent field */
    private java.util.Date createtime;

    /** nullable persistent field */
    private String memo;

    /** full constructor */
    public OrdertaskVO(java.lang.String cityid, java.lang.String orderid, java.lang.Short effective, java.util.Date createtime, java.lang.String memo) {
        this.cityid = cityid;
        this.orderid = orderid;
        this.effective = effective;
        this.createtime = createtime;
        this.memo = memo;
    }

    /** default constructor */
    public OrdertaskVO() {
    }

    /** minimal constructor */
    public OrdertaskVO(java.lang.String cityid) {
        this.cityid = cityid;
    }

    public java.lang.Long getRecid() {
        return this.recid;
    }

    public void setRecid(java.lang.Long recid) {
        this.recid = recid;
    }

    public java.lang.String getCityid() {
        return this.cityid;
    }

    public void setCityid(java.lang.String cityid) {
        this.cityid = cityid;
    }

    public java.lang.String getOrderid() {
        return this.orderid;
    }

    public void setOrderid(java.lang.String orderid) {
        this.orderid = orderid;
    }

    public java.lang.Short getEffective() {
        return this.effective;
    }

    public void setEffective(java.lang.Short effective) {
        this.effective = effective;
    }

    public java.util.Date getCreatetime() {
        return this.createtime;
    }

    public void setCreatetime(java.util.Date createtime) {
        this.createtime = createtime;
    }

    public java.lang.String getMemo() {
        return this.memo;
    }

    public void setMemo(java.lang.String memo) {
        this.memo = memo;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("recid", getRecid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof OrdertaskVO) ) return false;
        OrdertaskVO castOther = (OrdertaskVO) other;
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
