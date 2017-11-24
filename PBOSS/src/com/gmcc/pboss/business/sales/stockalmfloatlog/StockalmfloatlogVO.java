package com.gmcc.pboss.business.sales.stockalmfloatlog;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class StockalmfloatlogVO extends BaseVO implements Serializable {

    /** identifier field */
    private Long logid;

    /** nullable persistent field */
    private java.util.Date optime;

    /** nullable persistent field */
    private String oprcode;

    /** nullable persistent field */
    private String oprtype;

    /** nullable persistent field */
    private String success;

    /** identifier field */
    private Long recid;
    
    /** nullable persistent field */
    private Short starlevel;

    /** nullable persistent field */
    private String brand;

    /** nullable persistent field */
    private Double maxstockquotiety;

    /** nullable persistent field */
    private Double yellowquotiety;

    /** nullable persistent field */
    private Double redquotiety;
    
    private Double actquotiety;//平均激活量系数 add by liyanling



    public StockalmfloatlogVO(Long logid, Date optime, String oprcode,
			String oprtype, String success, Long recid, Short starlevel,
			String brand, Double maxstockquotiety, Double yellowquotiety,
			Double redquotiety, Double actquotiety) {
		super();
		this.logid = logid;
		this.optime = optime;
		this.oprcode = oprcode;
		this.oprtype = oprtype;
		this.success = success;
		this.recid = recid;
		this.starlevel = starlevel;
		this.brand = brand;
		this.maxstockquotiety = maxstockquotiety;
		this.yellowquotiety = yellowquotiety;
		this.redquotiety = redquotiety;
		this.actquotiety = actquotiety;
	}

	/** default constructor */
    public StockalmfloatlogVO() {
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

    public java.lang.String getOprcode() {
        return this.oprcode;
    }

    public void setOprcode(java.lang.String oprcode) {
        this.oprcode = oprcode;
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


    public java.lang.String getBrand() {
        return this.brand;
    }

    public void setBrand(java.lang.String brand) {
        this.brand = brand;
    }

    public java.lang.Double getMaxstockquotiety() {
        return this.maxstockquotiety;
    }

    public void setMaxstockquotiety(java.lang.Double maxstockquotiety) {
        this.maxstockquotiety = maxstockquotiety;
    }

    public java.lang.Double getYellowquotiety() {
        return this.yellowquotiety;
    }

    public void setYellowquotiety(java.lang.Double yellowquotiety) {
        this.yellowquotiety = yellowquotiety;
    }

    public java.lang.Double getRedquotiety() {
        return this.redquotiety;
    }

    public void setRedquotiety(java.lang.Double redquotiety) {
        this.redquotiety = redquotiety;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("logid", getLogid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof StockalmfloatlogVO) ) return false;
        StockalmfloatlogVO castOther = (StockalmfloatlogVO) other;
        return new EqualsBuilder()
            .append(this.getLogid(), castOther.getLogid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getLogid())
            .toHashCode();
    }

	public Double getActquotiety() {
		return actquotiety;
	}

	public void setActquotiety(Double actquotiety) {
		this.actquotiety = actquotiety;
	}

	public Long getRecid() {
		return recid;
	}

	public void setRecid(Long recid) {
		this.recid = recid;
	}

	public Short getStarlevel() {
		return starlevel;
	}

	public void setStarlevel(Short starlevel) {
		this.starlevel = starlevel;
	}

}
