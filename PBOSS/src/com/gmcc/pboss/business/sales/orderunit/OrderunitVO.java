package com.gmcc.pboss.business.sales.orderunit;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class OrderunitVO extends BaseVO implements Serializable {

    /** identifier field */
    private Long recid;

    /** persistent field */
    private String cityid;

    /** persistent field */
    private String comcategory;

    /** persistent field */
    private String unitagemode;

    /** persistent field */
    private String unitage;

    /** full constructor */
    public OrderunitVO(java.lang.String cityid, java.lang.String comcategory, java.lang.String unitagemode, java.lang.String unitage) {
        this.cityid = cityid;
        this.comcategory = comcategory;
        this.unitagemode = unitagemode;
        this.unitage = unitage;
    }

    /** default constructor */
    public OrderunitVO() {
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

    public java.lang.String getComcategory() {
        return this.comcategory;
    }

    public void setComcategory(java.lang.String comcategory) {
        this.comcategory = comcategory;
    }

    public java.lang.String getUnitagemode() {
        return this.unitagemode;
    }

    public void setUnitagemode(java.lang.String unitagemode) {
        this.unitagemode = unitagemode;
    }

    public java.lang.String getUnitage() {
        return this.unitage;
    }

    public void setUnitage(java.lang.String unitage) {
        this.unitage = unitage;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("recid", getRecid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof OrderunitVO) ) return false;
        OrderunitVO castOther = (OrderunitVO) other;
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
