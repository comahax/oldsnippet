package com.gmcc.pboss.business.sales.comdisscale;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.gmcc.pboss.business.sales.comdisscalelog.ComdisscalelogVO;
import com.sunrise.jop.infrastructure.db.BaseVO;
import com.sunrise.jop.infrastructure.sysadmin.BusinessLog;

/** @author Hibernate CodeGenerator */
public class ComdisscaleVO extends BaseVO implements BusinessLog {
	
    /** identifier field */
    private Long recid;

    /** nullable persistent field */
    private String countyid;

    /** nullable persistent field */
    private String mareacode;

    /** nullable persistent field */
    private Short starlevel;
	
    /** identifier field */
    private String comcategory;

    /** nullable persistent field */
    private String brand;

    /** nullable persistent field */
    private Double disscale;

    public ComdisscaleVO(Long recid, String countyid, String mareacode,
			Short starlevel, String comcategory, String brand, Double disscale) {
		super();
		this.recid = recid;
		this.countyid = countyid;
		this.mareacode = mareacode;
		this.starlevel = starlevel;
		this.comcategory = comcategory;
		this.brand = brand;
		this.disscale = disscale;
	}

	/** default constructor */
    public ComdisscaleVO() {
    }

    /** minimal constructor */
    public ComdisscaleVO(java.lang.String comcategory) {
        this.comcategory = comcategory;
    }

    public java.lang.String getComcategory() {
        return this.comcategory;
    }

    public void setComcategory(java.lang.String comcategory) {
        this.comcategory = comcategory;
    }

    public java.lang.String getBrand() {
        return this.brand;
    }

    public void setBrand(java.lang.String brand) {
        this.brand = brand;
    }

    public java.lang.Double getDisscale() {
        return this.disscale;
    }

    public void setDisscale(java.lang.Double disscale) {
        this.disscale = disscale;
    }
    
	public Class logVOClass() {
		// TODO Auto-generated method stub
		return ComdisscalelogVO.class;
	}

	public Long getRecid() {
		return recid;
	}

	public void setRecid(Long recid) {
		this.recid = recid;
	}

	public String getCountyid() {
		return countyid;
	}

	public void setCountyid(String countyid) {
		this.countyid = countyid;
	}

	public String getMareacode() {
		return mareacode;
	}

	public void setMareacode(String mareacode) {
		this.mareacode = mareacode;
	}

	public Short getStarlevel() {
		return starlevel;
	}

	public void setStarlevel(Short starlevel) {
		this.starlevel = starlevel;
	}

}
