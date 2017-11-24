package com.gmcc.pboss.business.sales.orderresdetwayorder;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class OrderresdetWayOrderVO extends BaseVO implements Serializable {

	private Long rowcountid;
	
    /** identifier field */
    private String countyid;

    /** nullable persistent field */
    private String svccode;

    /** nullable persistent field */
    private String mareacode;

    /** nullable persistent field */
    private Short starlevel;
    
    private String comname;

//    /** nullable persistent field */
//    private String restype;
//
//    /** nullable persistent field */
//    private String comcategory;
//
    /** nullable persistent field */
    private Long comid;

    /** nullable persistent field */
    private Double comprice;//应收单价

    /** nullable persistent field */
    private Double actprice;//实收单价

    /** nullable persistent field */
    private Long countvalue;

    private Double comcamt;//应收总和(一行)
    private Double actamt;//实收总和(一行)

    private String comcamtFormat;//应收总和(一行)
    private String actamtFormat;//实收总和(一行)
    private String compriceFormat;//应收单价
    private String actpriceFormat;//实收单价
    public Double getComcamt() {
		return comcamt;
	}

	public void setComcamt(Double comcamt) {
		this.comcamt = comcamt;
	}

	public Double getActamt() {
		return actamt;
	}

	public void setActamt(Double actamt) {
		this.actamt = actamt;
	}

	public String getComcamtFormat() {
		return comcamtFormat;
	}

	public void setComcamtFormat(String comcamtFormat) {
		this.comcamtFormat = comcamtFormat;
	}

	public String getActamtFormat() {
		return actamtFormat;
	}

	public void setActamtFormat(String actamtFormat) {
		this.actamtFormat = actamtFormat;
	}

	public String getCompriceFormat() {
		return compriceFormat;
	}

	public void setCompriceFormat(String compriceFormat) {
		this.compriceFormat = compriceFormat;
	}

	public String getActpriceFormat() {
		return actpriceFormat;
	}

	public void setActpriceFormat(String actpriceFormat) {
		this.actpriceFormat = actpriceFormat;
	}

	/** full constructor */
    public OrderresdetWayOrderVO(java.lang.Long rowcountid,java.lang.String countyid, 
    		java.lang.String svccode,java.lang.String mareacode, java.lang.Short starlevel,
//    		java.lang.String restype,java.lang.String comcategory, java.lang.Long comid,
    		java.lang.String comname,
    		java.lang.Double comprice, java.lang.Double actprice, java.lang.Long countvalue) {
    	this.rowcountid=rowcountid;
    	this.countyid = countyid;
        this.svccode = svccode;
        this.mareacode = mareacode;
        this.starlevel = starlevel;
//        this.restype = restype;
//        this.comcategory = comcategory;
//        this.comid = comid;
        this.comname=comname;
        this.comprice = comprice;
        this.actprice = actprice;
        this.countvalue = countvalue;
//        this.recordtime = recordtime;
    }

    /** default constructor */
    public OrderresdetWayOrderVO() {
    }

    /** minimal constructor */
    public OrderresdetWayOrderVO(java.lang.String countyid) {
        this.countyid = countyid;
    }

    public java.lang.String getCountyid() {
        return this.countyid;
    }

    public void setCountyid(java.lang.String countyid) {
        this.countyid = countyid;
    }

    public java.lang.String getSvccode() {
        return this.svccode;
    }

    public void setSvccode(java.lang.String svccode) {
        this.svccode = svccode;
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

//    public java.lang.String getRestype() {
//        return this.restype;
//    }
//
//    public void setRestype(java.lang.String restype) {
//        this.restype = restype;
//    }
//
//    public java.lang.String getComcategory() {
//        return this.comcategory;
//    }
//
//    public void setComcategory(java.lang.String comcategory) {
//        this.comcategory = comcategory;
//    }
//
    public java.lang.Long getComid() {
        return this.comid;
    }

    public void setComid(java.lang.Long comid) {
        this.comid = comid;
    }

    public java.lang.Double getComprice() {
        return this.comprice;
    }

    public void setComprice(java.lang.Double comprice) {
        this.comprice = comprice;
    }

    public java.lang.Double getActprice() {
        return this.actprice;
    }

    public void setActprice(java.lang.Double actprice) {
        this.actprice = actprice;
    }

    public java.lang.Long getCountvalue() {
        return this.countvalue;
    }

    public void setCountvalue(java.lang.Long countvalue) {
        this.countvalue = countvalue;
    }

//    public java.util.Date getRecordtime() {
//        return this.recordtime;
//    }
//
//    public void setRecordtime(java.util.Date recordtime) {
//        this.recordtime = recordtime;
//    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("rowcountid", getRowcountid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof OrderresdetWayOrderVO) ) return false;
        OrderresdetWayOrderVO castOther = (OrderresdetWayOrderVO) other;
        return new EqualsBuilder()
            .append(this.getRowcountid(), castOther.getRowcountid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getRowcountid())
            .toHashCode();
    }

	public Long getRowcountid() {
		return rowcountid;
	}

	public void setRowcountid(Long rowcountid) {
		this.rowcountid = rowcountid;
	}

	public String getComname() {
		return comname;
	}

	public void setComname(String comname) {
		this.comname = comname;
	}

}
