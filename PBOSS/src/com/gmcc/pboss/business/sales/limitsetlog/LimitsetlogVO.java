package com.gmcc.pboss.business.sales.limitsetlog;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class LimitsetlogVO extends BaseVO implements Serializable {

    /** identifier field */
    private Long logid;

    /** nullable persistent field */
    private java.util.Date optime;

    /** nullable persistent field */
    private String oprcode2;

    /** nullable persistent field */
    private String oprtype;

    /** nullable persistent field */
    private String success;

    /** nullable persistent field */
    private Long recid;

    /** nullable persistent field */
    private String cityid;

    /** nullable persistent field */
    private String countyid;

    /** nullable persistent field */
    private Short starlevel;

    /** nullable persistent field */
    private String comcategory;

    /** nullable persistent field */
    private Double stockscale;

    /** full constructor */
    public LimitsetlogVO(java.util.Date optime, java.lang.String oprcode2, java.lang.String oprtype, java.lang.String success, java.lang.Long recid, java.lang.String cityid, java.lang.String countyid, java.lang.Short starlevel, java.lang.String comcategory, java.lang.Double stockscale) {
        this.optime = optime;
        this.oprcode2 = oprcode2;
        this.oprtype = oprtype;
        this.success = success;
        this.recid = recid;
        this.cityid = cityid;
        this.countyid = countyid;
        this.starlevel = starlevel;
        this.comcategory = comcategory;
        this.stockscale = stockscale;
    }

    /** default constructor */
    public LimitsetlogVO() {
    }

    public java.lang.Long getLogid() {
        return this.logid;
    }

    public void setLogid(java.lang.Long logid) {
        this.logid = logid;
    }

    public java.util.Date getOptime() {
        return this.optime;
    }

    public void setOptime(java.util.Date optime) {
        this.optime = optime;
    }

    public java.lang.String getOprcode2() {
        return this.oprcode2;
    }

    public void setOprcode2(java.lang.String oprcode2) {
        this.oprcode2 = oprcode2;
    }

    public java.lang.String getOprtype() {
        return this.oprtype;
    }

    public void setOprtype(java.lang.String oprtype) {
        this.oprtype = oprtype;
    }

    public java.lang.String getSuccess() {
        return this.success;
    }

    public void setSuccess(java.lang.String success) {
        this.success = success;
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

    public java.lang.String getCountyid() {
        return this.countyid;
    }

    public void setCountyid(java.lang.String countyid) {
        this.countyid = countyid;
    }

    public java.lang.Short getStarlevel() {
        return this.starlevel;
    }

    public void setStarlevel(java.lang.Short starlevel) {
        this.starlevel = starlevel;
    }

    public java.lang.String getComcategory() {
        return this.comcategory;
    }

    public void setComcategory(java.lang.String comcategory) {
        this.comcategory = comcategory;
    }

    public java.lang.Double getStockscale() {
        return this.stockscale;
    }

    public void setStockscale(java.lang.Double stockscale) {
        this.stockscale = stockscale;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("logid", getLogid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof LimitsetlogVO) ) return false;
        LimitsetlogVO castOther = (LimitsetlogVO) other;
        return new EqualsBuilder()
            .append(this.getLogid(), castOther.getLogid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getLogid())
            .toHashCode();
    }

}
