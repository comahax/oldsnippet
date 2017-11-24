package com.gmcc.pboss.business.sales.disformprint;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class DisformprintVO extends BaseVO implements Serializable {

    /** identifier field */
    private Long recid;

    /** nullable persistent field */
    private java.util.Date createtime;

    /** nullable persistent field */
    private String recewayid;

    /** nullable persistent field */
    private String discomcode;

    /** nullable persistent field */
    private String disstate;

    /** nullable persistent field */
    private String orderid;

    /** nullable persistent field */
    private java.util.Date ordcreatetime;

    /** nullable persistent field */
    private String countyid;

    /** nullable persistent field */
    private String orderstate;

    /** full constructor */
    public DisformprintVO(java.util.Date createtime, java.lang.String recewayid, java.lang.String discomcode, java.lang.String disstate, java.lang.String orderid, java.util.Date ordcreatetime, java.lang.String countyid, java.lang.String orderstate) {
        this.createtime = createtime;
        this.recewayid = recewayid;
        this.discomcode = discomcode;
        this.disstate = disstate;
        this.orderid = orderid;
        this.ordcreatetime = ordcreatetime;
        this.countyid = countyid;
        this.orderstate = orderstate;
    }

    /** default constructor */
    public DisformprintVO() {
    }

    public java.lang.Long getRecid() {
        return this.recid;
    }

    public void setRecid(java.lang.Long recid) {
        this.recid = recid;
    }

    public java.util.Date getCreatetime() {
        return this.createtime;
    }

    public void setCreatetime(java.util.Date createtime) {
        this.createtime = createtime;
    }

    public java.lang.String getRecewayid() {
        return this.recewayid;
    }

    public void setRecewayid(java.lang.String recewayid) {
        this.recewayid = recewayid;
    }

    public java.lang.String getDiscomcode() {
        return this.discomcode;
    }

    public void setDiscomcode(java.lang.String discomcode) {
        this.discomcode = discomcode;
    }

    public java.lang.String getDisstate() {
        return this.disstate;
    }

    public void setDisstate(java.lang.String disstate) {
        this.disstate = disstate;
    }

    public java.lang.String getOrderid() {
        return this.orderid;
    }

    public void setOrderid(java.lang.String orderid) {
        this.orderid = orderid;
    }

    public java.util.Date getOrdcreatetime() {
        return this.ordcreatetime;
    }

    public void setOrdcreatetime(java.util.Date ordcreatetime) {
        this.ordcreatetime = ordcreatetime;
    }

    public java.lang.String getCountyid() {
        return this.countyid;
    }

    public void setCountyid(java.lang.String countyid) {
        this.countyid = countyid;
    }

    public java.lang.String getOrderstate() {
        return this.orderstate;
    }

    public void setOrderstate(java.lang.String orderstate) {
        this.orderstate = orderstate;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("recid", getRecid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof DisformprintVO) ) return false;
        DisformprintVO castOther = (DisformprintVO) other;
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
