package com.gmcc.pboss.business.sales.comprice;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.gmcc.pboss.business.sales.compricelog.CompricelogVO;
import com.sunrise.jop.infrastructure.db.BaseVO;
import com.sunrise.jop.infrastructure.sysadmin.BusinessLog;

/** @author Hibernate CodeGenerator */
public class CompriceVO extends BaseVO implements BusinessLog {

    /** identifier field */
    private Long recid;

    /** persistent field */
    private String cityid;

    /** persistent field */
    private String countyid;

    /** persistent field */
    private Short starlevel;
    
    /** persistent field */
    private String cooptype;
    
    private String coopname;

    /** persistent field */
    private String comcategory;

    /** persistent field */
    private String pricediftype;

    /** persistent field */
    private Double price1;

    /** nullable persistent field */
    private Double price2;
    
    private Double price3;
	private Double price4;
	private Double price5;
	
   
    /** full constructor */
    public CompriceVO(java.lang.String cityid, java.lang.String countyid, java.lang.String cooptype, java.lang.String comcategory, java.lang.String pricediftype, java.lang.Double price1, java.lang.Double price2) {
        this.cityid = cityid;
        this.countyid = countyid;
        this.cooptype = cooptype;
        this.comcategory = comcategory;
        this.pricediftype = pricediftype;
        this.price1 = price1;
        this.price2 = price2;
    }

    /** default constructor */
    public CompriceVO() {
    }

    /** minimal constructor */
    public CompriceVO(java.lang.String cityid, java.lang.String countyid, java.lang.String cooptype, java.lang.String comcategory, java.lang.String pricediftype, java.lang.Double price1) {
        this.cityid = cityid;
        this.countyid = countyid;
        this.cooptype = cooptype;
        this.comcategory = comcategory;
        this.pricediftype = pricediftype;
        this.price1 = price1;
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
    
    public java.lang.String getCooptype() {
        return this.cooptype;
    }

    public void setCooptype(java.lang.String cooptype) {
        this.cooptype = cooptype;
    }

    public java.lang.String getComcategory() {
        return this.comcategory;
    }

    public void setComcategory(java.lang.String comcategory) {
        this.comcategory = comcategory;
    }

    public java.lang.String getPricediftype() {
        return this.pricediftype;
    }

    public void setPricediftype(java.lang.String pricediftype) {
        this.pricediftype = pricediftype;
    }

    public java.lang.Double getPrice1() {
        return this.price1;
    }

    public void setPrice1(java.lang.Double price1) {
        this.price1 = price1;
    }

    public java.lang.Double getPrice2() {
        return this.price2;
    }

    public void setPrice2(java.lang.Double price2) {
        this.price2 = price2;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("recid", getRecid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CompriceVO) ) return false;
        CompriceVO castOther = (CompriceVO) other;
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
		return CompricelogVO.class;
	}

	public Double getPrice3() {
		return price3;
	}

	public void setPrice3(Double price3) {
		this.price3 = price3;
	}

	public Double getPrice4() {
		return price4;
	}

	public void setPrice4(Double price4) {
		this.price4 = price4;
	}

	public Double getPrice5() {
		return price5;
	}

	public void setPrice5(Double price5) {
		this.price5 = price5;
	}

	public String getCoopname() {
		return coopname;
	}

	public void setCoopname(String coopname) {
		this.coopname = coopname;
	}
}
