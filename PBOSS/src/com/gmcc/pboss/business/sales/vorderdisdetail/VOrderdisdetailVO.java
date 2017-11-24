package com.gmcc.pboss.business.sales.vorderdisdetail;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class VOrderdisdetailVO extends BaseVO implements Serializable {

    /** identifier field */
    private String orderid;

    /** nullable persistent field */
    private String countyid;

    /** nullable persistent field */
    private String mareacode;

    /** nullable persistent field */
    private Short starlevel;

    /** nullable persistent field */
    private java.util.Date createtime;

    /** nullable persistent field */
    private Long recid;

    /** nullable persistent field */
    private java.util.Date disovertime;

    /** nullable persistent field */
    private String intervaltime;

    /** full constructor */
    public VOrderdisdetailVO(java.lang.String orderid, java.lang.String countyid, java.lang.String mareacode, java.lang.Short starlevel, java.util.Date createtime, java.lang.Long recid, java.util.Date disovertime, java.lang.String intervaltime) {
        this.orderid = orderid;
        this.countyid = countyid;
        this.mareacode = mareacode;
        this.starlevel = starlevel;
        this.createtime = createtime;
        this.recid = recid;
        this.disovertime = disovertime;
        this.intervaltime = intervaltime;
    }

    /** default constructor */
    public VOrderdisdetailVO() {
    }

    /** minimal constructor */
    public VOrderdisdetailVO(java.lang.String orderid) {
        this.orderid = orderid;
    }

    public java.lang.String getOrderid() {
        return this.orderid;
    }

    public void setOrderid(java.lang.String orderid) {
        this.orderid = orderid;
    }

    public java.lang.String getCountyid() {
        return this.countyid;
    }

    public void setCountyid(java.lang.String countyid) {
        this.countyid = countyid;
    }

    public java.lang.String getMareacode() {
        return this.mareacode;
    }

    public void setMareacode(java.lang.String mareacode) {
        this.mareacode = mareacode;
    }

    public java.lang.Short getStarlevel() {
        return this.starlevel;
    }

    public void setStarlevel(java.lang.Short starlevel) {
        this.starlevel = starlevel;
    }

    public java.util.Date getCreatetime() {
        return this.createtime;
    }

    public void setCreatetime(java.util.Date createtime) {
        this.createtime = createtime;
    }

    public java.lang.Long getRecid() {
        return this.recid;
    }

    public void setRecid(java.lang.Long recid) {
        this.recid = recid;
    }

    public java.util.Date getDisovertime() {
        return this.disovertime;
    }

    public void setDisovertime(java.util.Date disovertime) {
        this.disovertime = disovertime;
    }

    public java.lang.String getIntervaltime() {
        return this.intervaltime;
    }

    public void setIntervaltime(java.lang.String intervaltime) {
        this.intervaltime = intervaltime;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("orderid", getOrderid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof VOrderdisdetailVO) ) return false;
        VOrderdisdetailVO castOther = (VOrderdisdetailVO) other;
        return new EqualsBuilder()
            .append(this.getOrderid(), castOther.getOrderid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getOrderid())
            .toHashCode();
    }

}
