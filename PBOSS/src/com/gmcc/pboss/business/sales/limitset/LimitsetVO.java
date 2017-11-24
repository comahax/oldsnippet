package com.gmcc.pboss.business.sales.limitset;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.gmcc.pboss.business.sales.limitsetlog.LimitsetlogVO;
import com.sunrise.jop.infrastructure.db.BaseVO;
import com.sunrise.jop.infrastructure.sysadmin.BusinessLog;

/** @author Hibernate CodeGenerator */
public class LimitsetVO extends BaseVO implements BusinessLog {

    /** identifier field */
    private Long recid;

    /** persistent field */
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
    public LimitsetVO(java.lang.String cityid, java.lang.String countyid, java.lang.Short starlevel, java.lang.String comcategory, java.lang.Double stockscale) {
        this.cityid = cityid;
        this.countyid = countyid;
        this.starlevel = starlevel;
        this.comcategory = comcategory;
        this.stockscale = stockscale;
    }

    /** default constructor */
    public LimitsetVO() {
    }

    /** minimal constructor */
    public LimitsetVO(java.lang.String cityid) {
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
            .append("recid", getRecid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof LimitsetVO) ) return false;
        LimitsetVO castOther = (LimitsetVO) other;
        return new EqualsBuilder()
            .append(this.getRecid(), castOther.getRecid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getRecid())
            .toHashCode();
    }

	public Class logVOClass() {
		// TODO Auto-generated method stub
		return LimitsetlogVO.class;
	}
}
