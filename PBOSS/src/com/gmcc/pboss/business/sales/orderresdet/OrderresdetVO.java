package com.gmcc.pboss.business.sales.orderresdet;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class OrderresdetVO extends BaseVO implements Serializable {

    /** identifier field */
    private Long detid;

    /** persistent field */
    private String orderid;

    /** nullable persistent field */
    private String ordercomtype;

    /** nullable persistent field */
    private String comcategory;

    /** nullable persistent field */
    private String restype;

    /** nullable persistent field */
    private Long comid;

    /** nullable persistent field */
    private String batchno;

    /** nullable persistent field */
    private String boxnum;

    /** nullable persistent field */
    private String comresid;

    /** nullable persistent field */
    private String brand;
    
    private String wayid;//分销1.23版本新加 
    
    private String emptyno;
    
    private Double comprice;
    
    private Double actprice;

   

	public String getWayid() {
		return wayid;
	}

	public void setWayid(String wayid) {
		this.wayid = wayid;
	}

	

    /** default constructor */
    public OrderresdetVO() {
    }

    /** full constructor */
    
    public OrderresdetVO(Long detid, String orderid, String ordercomtype,
			String comcategory, String restype, Long comid, String batchno,
			String boxnum, String comresid, String brand, String wayid,
			Double comprice, Double actprice, String emptyno) {
		super();
		this.detid = detid;
		this.orderid = orderid;
		this.ordercomtype = ordercomtype;
		this.comcategory = comcategory;
		this.restype = restype;
		this.comid = comid;
		this.batchno = batchno;
		this.boxnum = boxnum;
		this.comresid = comresid;
		this.brand = brand;
		this.wayid = wayid;
		this.comprice = comprice;
		this.actprice = actprice;
		this.emptyno = emptyno;
	}

	/** minimal constructor */
    public OrderresdetVO(java.lang.String orderid) {
        this.orderid = orderid;
    }

    public java.lang.Long getDetid() {
        return this.detid;
    }

    public void setDetid(java.lang.Long detid) {
        this.detid = detid;
    }

    public java.lang.String getOrderid() {
        return this.orderid;
    }

    public void setOrderid(java.lang.String orderid) {
        this.orderid = orderid;
    }

    public java.lang.String getOrdercomtype() {
        return this.ordercomtype;
    }

    public void setOrdercomtype(java.lang.String ordercomtype) {
        this.ordercomtype = ordercomtype;
    }

    public java.lang.String getComcategory() {
        return this.comcategory;
    }

    public void setComcategory(java.lang.String comcategory) {
        this.comcategory = comcategory;
    }

    public java.lang.String getRestype() {
        return this.restype;
    }

    public void setRestype(java.lang.String restype) {
        this.restype = restype;
    }

    public java.lang.Long getComid() {
        return this.comid;
    }

    public void setComid(java.lang.Long comid) {
        this.comid = comid;
    }

    public java.lang.String getBatchno() {
        return this.batchno;
    }

    public void setBatchno(java.lang.String batchno) {
        this.batchno = batchno;
    }

    public java.lang.String getBoxnum() {
        return this.boxnum;
    }

    public void setBoxnum(java.lang.String boxnum) {
        this.boxnum = boxnum;
    }

    public java.lang.String getComresid() {
        return this.comresid;
    }

    public void setComresid(java.lang.String comresid) {
        this.comresid = comresid;
    }

    public java.lang.String getBrand() {
        return this.brand;
    }

    public void setBrand(java.lang.String brand) {
        this.brand = brand;
    }
    
    public Double getComprice() {
		return comprice;
	}

	public void setComprice(Double comprice) {
		this.comprice = comprice;
	}

	public Double getActprice() {
		return actprice;
	}

	public void setActprice(Double actprice) {
		this.actprice = actprice;
	}
	
	public String getEmptyno() {
		return emptyno;
	}

	public void setEmptyno(String emptyno) {
		this.emptyno = emptyno;
	}

	public String toString() {
        return new ToStringBuilder(this)
            .append("detid", getDetid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof OrderresdetVO) ) return false;
        OrderresdetVO castOther = (OrderresdetVO) other;
        return new EqualsBuilder()
            .append(this.getDetid(), castOther.getDetid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getDetid())
            .toHashCode();
    }

}
