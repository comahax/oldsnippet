package com.gmcc.pboss.business.sales.salesstd;

import com.gmcc.pboss.business.resource.resloadparamlog.ResloadparamlogVO;
import com.gmcc.pboss.business.sales.salesstdlog.SalesstdlogVO;
import com.sunrise.jop.infrastructure.db.BaseVO;
import com.sunrise.jop.infrastructure.sysadmin.BusinessLog;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class SalesstdVO extends BaseVO implements Serializable,BusinessLog {

    /** identifier field */
    private Long recid;

    /** persistent field */
    private String cityid;

    /** nullable persistent field */
    private String countyid;

    /** nullable persistent field */
    private String mareacode;

    /** nullable persistent field */
    private Short starlevel;

    /** nullable persistent field */
    private String brand;

    /** nullable persistent field */
    private Long salesstd;

    
    private String wayid;
    
    private String wayname;
    
    private Long salescount;
    
    public SalesstdVO(Long recid, String cityid, String countyid,
			String mareacode, Short starlevel, String brand, Long salesstd,
			String wayid, String wayname, Long salescount) {
		super();
		this.recid = recid;
		this.cityid = cityid;
		this.countyid = countyid;
		this.mareacode = mareacode;
		this.starlevel = starlevel;
		this.brand = brand;
		this.salesstd = salesstd;
		this.wayid = wayid;
		this.wayname = wayname;
		this.salescount = salescount;
	}

	public String getWayid() {
		return wayid;
	}

	public void setWayid(String wayid) {
		this.wayid = wayid;
	}

	public String getWayname() {
		return wayname;
	}

	public void setWayname(String wayname) {
		this.wayname = wayname;
	}

	public Long getSalescount() {
		return salescount;
	}

	public void setSalescount(Long salescount) {
		this.salescount = salescount;
	}

	/** full constructor */


    /** default constructor */
    public SalesstdVO() {
    }

    /** minimal constructor */
    public SalesstdVO(java.lang.Long recid, java.lang.String cityid) {
        this.recid = recid;
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

    public java.lang.String getBrand() {
        return this.brand;
    }

    public void setBrand(java.lang.String brand) {
        this.brand = brand;
    }

    public java.lang.Long getSalesstd() {
        return this.salesstd;
    }

    public void setSalesstd(java.lang.Long salesstd) {
        this.salesstd = salesstd;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("recid", getRecid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof SalesstdVO) ) return false;
        SalesstdVO castOther = (SalesstdVO) other;
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
		return SalesstdlogVO.class;
	}

}
