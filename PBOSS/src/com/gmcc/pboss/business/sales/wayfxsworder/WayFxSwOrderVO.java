package com.gmcc.pboss.business.sales.wayfxsworder;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class WayFxSwOrderVO extends BaseVO implements Serializable {

    /** identifier field */
//    private String wayid;
	
	private Long rowcountid;

    /** nullable persistent field */
    private String countyid;

    /** nullable persistent field */
    private String svccode;

    /** nullable persistent field */
    private String mareacode;

    /** nullable persistent field */
    private Short starlevel;

    /** nullable persistent field */
    private String paytype;

    private Double sumrecamt;
    
    private Double sumactamt;
    
    //总计的格式化
    private String sumrecamtFormat;
    private String sumactamtFormat;
  
    
    
    public String getSumrecamtFormat() {
		return sumrecamtFormat;
	}

	public void setSumrecamtFormat(String sumrecamtFormat) {
		this.sumrecamtFormat = sumrecamtFormat;
	}

	public String getSumactamtFormat() {
		return sumactamtFormat;
	}

	public void setSumactamtFormat(String sumactamtFormat) {
		this.sumactamtFormat = sumactamtFormat;
	}

	public Double getSumrecamt() {
		return sumrecamt;
	}

	public void setSumrecamt(Double sumrecamt) {
		this.sumrecamt = sumrecamt;
	}

	public Double getSumactamt() {
		return sumactamt;
	}

	public void setSumactamt(Double sumactamt) {
		this.sumactamt = sumactamt;
	}

	/** full constructor */
    public WayFxSwOrderVO(java.lang.Long rowcountid,java.lang.String countyid, java.lang.String svccode, java.lang.String mareacode, java.lang.Short starlevel, java.lang.String paytype,java.lang.Double sumrecamt,java.lang.Double sumactamt) {
//        this.wayid = wayid;java.lang.String wayid, 
    	this.rowcountid=rowcountid;
        this.countyid = countyid;
        this.svccode = svccode;
        this.mareacode = mareacode;
        this.starlevel = starlevel;
        this.paytype = paytype;
        this.sumactamt=sumactamt;
        this.sumrecamt=sumrecamt;
       
    }

    /** default constructor */
    public WayFxSwOrderVO() {
    }

    /** minimal constructor */
    public WayFxSwOrderVO(java.lang.String countyid, java.lang.String svccode) {
//        this.wayid = wayid;java.lang.String wayid, 
    	 this.countyid = countyid;
         this.svccode = svccode;
    }

   

    public String getCountyid() {
		return countyid;
	}

	public void setCountyid(String countyid) {
		this.countyid = countyid;
	}

	public String getSvccode() {
		return svccode;
	}

	public void setSvccode(String svccode) {
		this.svccode = svccode;
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

	public String getPaytype() {
		return paytype;
	}

	public void setPaytype(String paytype) {
		this.paytype = paytype;
	}

	public Long getRowcountid() {
		return rowcountid;
	}

	public void setRowcountid(Long rowcountid) {
		this.rowcountid = rowcountid;
	}

	public String toString() {
        return new ToStringBuilder(this)
            .append("rowcountid",getRowcountid() )
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof WayFxSwOrderVO) ) return false;
        WayFxSwOrderVO castOther = (WayFxSwOrderVO) other;
        return new EqualsBuilder()
            .append(this.getRowcountid(), castOther.getRowcountid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getRowcountid())
            .toHashCode();
    }

}
