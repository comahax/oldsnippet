package com.gmcc.pboss.business.sales.stockalmfloat;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.stockalmfloatlog.StockalmfloatlogVO;
import com.sunrise.jop.infrastructure.db.BaseVO;
import com.sunrise.jop.infrastructure.sysadmin.BusinessLog;

/** @author Hibernate CodeGenerator */
public class StockalmfloatVO extends BaseVO implements Serializable ,BusinessLog {

	
    /** identifier field */
    private Long recid;
    
    /** nullable persistent field */
    private Short starlevel;
	
    /** identifier field */
    private String brand;

    /** nullable persistent field */
    private Double maxstockquotiety;

    /** nullable persistent field */
    private Double yellowquotiety;

    /** nullable persistent field */
    private Double redquotiety;
    
    private Double actquotiety;//平均激活量系数 add by panyonghui

    /** full constructor */



	/** default constructor */
    public StockalmfloatVO() {
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

    public Double getActquotiety() {
		return actquotiety;
	}

	public void setActquotiety(Double actquotiety) {
		this.actquotiety = actquotiety;
	}
    
    public Class logVOClass(){
    	return StockalmfloatlogVO.class;
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
	
	public StockalmfloatVO(Long recid, Short starlevel, String brand,
			Double maxstockquotiety, Double yellowquotiety, Double redquotiety,
			Double actquotiety) {
		super();
		this.recid = recid;
		this.starlevel = starlevel;
		this.brand = brand;
		this.maxstockquotiety = maxstockquotiety;
		this.yellowquotiety = yellowquotiety;
		this.redquotiety = redquotiety;
		this.actquotiety = actquotiety;
	}

}
