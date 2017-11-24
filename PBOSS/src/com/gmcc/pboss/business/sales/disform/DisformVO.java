package com.gmcc.pboss.business.sales.disform;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class DisformVO extends BaseVO implements Serializable {

    /** identifier field */
    private Long recid;

    /** persistent field */
    private String orderid;

    /** persistent field */
    private String recewayid;

    /** persistent field */
    private String recename;

    /** persistent field */
    private String recetel;

    /** persistent field */
    private String receadd;

    /** persistent field */
    private String discomcode;

    /** persistent field */
    private java.util.Date createtime;

    /** persistent field */
    private java.util.Date arrivetime;

    /** persistent field */
    private String disstate;

    /** nullable persistent field */
    private String memo;
    
    private Long detid;

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
    
    private String storesman;
    
    private java.util.Date outtime;
    
    private  java.lang.String logisticsno;

    /** full constructor */
    public DisformVO(java.lang.String orderid, java.lang.String recewayid, java.lang.String recename, java.lang.String recetel, java.lang.String receadd, java.lang.String discomcode, java.util.Date createtime, java.util.Date arrivetime, java.lang.String disstate, java.lang.String memo, java.lang.String storesman, java.util.Date outtime) {
        this.orderid = orderid;
        this.recewayid = recewayid;
        this.recename = recename;
        this.recetel = recetel;
        this.receadd = receadd;
        this.discomcode = discomcode;
        this.createtime = createtime;
        this.arrivetime = arrivetime;
        this.disstate = disstate;
        this.memo = memo;
        this.storesman = storesman;
        this.outtime = outtime;
    }
    
    public DisformVO(java.lang.String orderid, java.lang.String recewayid, java.lang.String recename, java.lang.String recetel, java.lang.String receadd, java.lang.String discomcode, java.util.Date createtime, java.util.Date arrivetime, java.lang.String disstate, java.lang.String memo, java.lang.String storesman, java.util.Date outtime,java.lang.String logisticsno) {
        this.orderid = orderid;
        this.recewayid = recewayid;
        this.recename = recename;
        this.recetel = recetel;
        this.receadd = receadd;
        this.discomcode = discomcode;
        this.createtime = createtime;
        this.arrivetime = arrivetime;
        this.disstate = disstate;
        this.memo = memo;
        this.storesman = storesman;
        this.outtime = outtime;
        this.logisticsno = logisticsno;
    }

    /** default constructor */
    public DisformVO() {
    }

    /** minimal constructor */
    public DisformVO(java.lang.String orderid, java.lang.String recewayid, java.lang.String recename, java.lang.String recetel, java.lang.String receadd, java.lang.String discomcode, java.util.Date createtime, java.util.Date arrivetime, java.lang.String disstate) {
        this.orderid = orderid;
        this.recewayid = recewayid;
        this.recename = recename;
        this.recetel = recetel;
        this.receadd = receadd;
        this.discomcode = discomcode;
        this.createtime = createtime;
        this.arrivetime = arrivetime;
        this.disstate = disstate;
    }

    public java.lang.Long getRecid() {
        return this.recid;
    }

    public void setRecid(java.lang.Long recid) {
        this.recid = recid;
    }

    public java.lang.String getOrderid() {
        return this.orderid;
    }

    public void setOrderid(java.lang.String orderid) {
        this.orderid = orderid;
    }

    public java.lang.String getRecewayid() {
        return this.recewayid;
    }

    public void setRecewayid(java.lang.String recewayid) {
        this.recewayid = recewayid;
    }

    public java.lang.String getRecename() {
        return this.recename;
    }

    public void setRecename(java.lang.String recename) {
        this.recename = recename;
    }

    public java.lang.String getRecetel() {
        return this.recetel;
    }

    public void setRecetel(java.lang.String recetel) {
        this.recetel = recetel;
    }

    public java.lang.String getReceadd() {
        return this.receadd;
    }

    public void setReceadd(java.lang.String receadd) {
        this.receadd = receadd;
    }

    public java.lang.String getDiscomcode() {
        return this.discomcode;
    }

    public void setDiscomcode(java.lang.String discomcode) {
        this.discomcode = discomcode;
    }

    public java.util.Date getCreatetime() {
        return this.createtime;
    }

    public void setCreatetime(java.util.Date createtime) {
        this.createtime = createtime;
    }

    public java.util.Date getArrivetime() {
        return this.arrivetime;
    }

    public void setArrivetime(java.util.Date arrivetime) {
        this.arrivetime = arrivetime;
    }

    public java.lang.String getDisstate() {
        return this.disstate;
    }

    public void setDisstate(java.lang.String disstate) {
        this.disstate = disstate;
    }

    public java.lang.String getMemo() {
        return this.memo;
    }

    public void setMemo(java.lang.String memo) {
        this.memo = memo;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("recid", getRecid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof DisformVO) ) return false;
        DisformVO castOther = (DisformVO) other;
        return new EqualsBuilder()
            .append(this.getRecid(), castOther.getRecid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getRecid())
            .toHashCode();
    }

	public String getBatchno() {
		return batchno;
	}

	public void setBatchno(String batchno) {
		this.batchno = batchno;
	}

	public String getBoxnum() {
		return boxnum;
	}

	public void setBoxnum(String boxnum) {
		this.boxnum = boxnum;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getComcategory() {
		return comcategory;
	}

	public void setComcategory(String comcategory) {
		this.comcategory = comcategory;
	}

	public Long getComid() {
		return comid;
	}

	public void setComid(Long comid) {
		this.comid = comid;
	}

	public String getComresid() {
		return comresid;
	}

	public void setComresid(String comresid) {
		this.comresid = comresid;
	}

	public Long getDetid() {
		return detid;
	}

	public void setDetid(Long detid) {
		this.detid = detid;
	}

	public String getOrdercomtype() {
		return ordercomtype;
	}

	public void setOrdercomtype(String ordercomtype) {
		this.ordercomtype = ordercomtype;
	}

	public String getRestype() {
		return restype;
	}

	public void setRestype(String restype) {
		this.restype = restype;
	}

	public java.util.Date getOuttime() {
		return outtime;
	}

	public void setOuttime(java.util.Date outtime) {
		this.outtime = outtime;
	}

	public String getStoresman() {
		return storesman;
	}

	public void setStoresman(String storesman) {
		this.storesman = storesman;
	}

	public java.lang.String getLogisticsno() {
		return logisticsno;
	}

	public void setLogisticsno(java.lang.String logisticsno) {
		this.logisticsno = logisticsno;
	}

}
