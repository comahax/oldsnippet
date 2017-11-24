package com.sunrise.boss.business.common.subscriber.persistent;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


public class SubscriberVO implements Serializable {

    /** identifier field */
    private Long subsid;

    /** persistent field */
    private Integer region;

    /** nullable persistent field */
    private Long custid;

    /** nullable persistent field */
    private Long userid;

    /** nullable persistent field */
    private String subsname;

    /** persistent field */
    private Long acctid;

    /** persistent field */
    private String servnumber;

    /** nullable persistent field */
    private Byte issingle;

    /** persistent field */
    private String status;

    /** nullable persistent field */
    private java.util.Date statusdate;
    
    private String creditstatus;
    private String areaid;
    private String stopkey;
    private java.util.Date startdate;
    
    /* add by xiefufeng */
    private String brand; //用户品牌
    private String proid; //产品标识
    /* add by xiefufeng */
    
    
    /** add by mys **/
    private String ownerorgid; /**归属渠道**/
    /** add by mys **/
    
    //add by wangguangying
    private Short settleday ;
    private Date invaliddate;
    //add by wangguangying
    
    private String mobiltype;
	 private String paymode;
	 private String urgetype;
	/** full constructor 
     * @param subsname 
     * @param acctid 
     * @param servnumber 
     * @param issingle */
    public SubscriberVO(java.lang.Long subsid, java.lang.Integer region, java.lang.Long custid, java.lang.Long userid, java.lang.String status, java.util.Date statusdate, String subsname, Long acctid, String servnumber, Byte issingle, String creditstatus, String brand,String ownerorgid, Short settleday, Date invaliddate ) {
        this.subsid = subsid;
        this.region = region;
        this.custid = custid;
        this.userid = userid;
        this.subsname = subsname;
        this.acctid = acctid;
        this.servnumber = servnumber;
        this.issingle = issingle;
        this.status = status;
        this.statusdate = statusdate;
        this.creditstatus = creditstatus;
        this.brand = brand;
        this.ownerorgid = ownerorgid;
        this.invaliddate = invaliddate;
        this.settleday = settleday;
    }

    /** default constructor */
    public SubscriberVO() {
    }

    /** minimal constructor */
    public SubscriberVO(java.lang.Long subsid, java.lang.Integer region, java.lang.String nettype, java.lang.Long acctid, java.lang.String servnumber, java.lang.String prodid, java.lang.String signtype, java.util.Date startdate, java.lang.String status) {
        this.subsid = subsid;
        this.region = region;
        this.acctid = acctid;
        this.servnumber = servnumber;
        this.status = status;
    }

    public java.lang.Long getSubsid() {
        return this.subsid;
    }

    public void setSubsid(java.lang.Long subsid) {
        this.subsid = subsid;
    }

    public java.lang.Integer getRegion() {
        return this.region;
    }

    public void setRegion(java.lang.Integer region) {
        this.region = region;
    }

    public java.lang.Long getCustid() {
        return this.custid;
    }

    public void setCustid(java.lang.Long custid) {
        this.custid = custid;
    }

    public java.lang.Long getUserid() {
        return this.userid;
    }

    public void setUserid(java.lang.Long userid) {
        this.userid = userid;
    }

    public java.lang.String getSubsname() {
        return this.subsname;
    }

    public void setSubsname(java.lang.String subsname) {
        this.subsname = subsname;
    }

    public java.lang.Long getAcctid() {
        return this.acctid;
    }

    public void setAcctid(java.lang.Long acctid) {
        this.acctid = acctid;
    }

    public java.lang.String getServnumber() {
        return this.servnumber;
    }

    public void setServnumber(java.lang.String servnumber) {
        this.servnumber = servnumber;
    }

    public java.lang.Byte getIssingle() {
        return this.issingle;
    }

    public void setIssingle(java.lang.Byte issingle) {
        this.issingle = issingle;
    }

    public java.lang.String getStatus() {
        return this.status;
    }

    public void setStatus(java.lang.String status) {
        this.status = status;
    }

    public java.util.Date getStatusdate() {
        return this.statusdate;
    }

    public void setStatusdate(java.util.Date statusdate) {
        this.statusdate = statusdate;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("subsid", getSubsid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof SubscriberVO) ) return false;
        SubscriberVO castOther = (SubscriberVO) other;
        return new EqualsBuilder()
            .append(this.getSubsid(), castOther.getSubsid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getSubsid())
            .toHashCode();
    }

	public String getCreditstatus() {
		return creditstatus;
	}

	public void setCreditstatus(String creditstatus) {
		this.creditstatus = creditstatus;
	}

    public String getAreaid() {
		return areaid;
	}

	public void setAreaid(String areaid) {
		this.areaid = areaid;
	}

	public String getStopkey() {
		return stopkey;
	}

	public void setStopkey(String stopkey) {
		this.stopkey = stopkey;
	}

	public java.util.Date getStartdate() {
		return startdate;
	}

	public void setStartdate(java.util.Date startdate) {
		this.startdate = startdate;
	}

	public String getMobiltype() {
		return mobiltype;
	}

	public void setMobiltype(String mobiltype) {
		this.mobiltype = mobiltype;
	}

	public String getPaymode() {
		return paymode;
	}

	public void setPaymode(String paymode) {
		this.paymode = paymode;
	}

	public String getUrgetype() {
		return urgetype;
	}

	public void setUrgetype(String urgetype) {
		this.urgetype = urgetype;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getOwnerorgid() {
		return ownerorgid;
	}

	public void setOwnerorgid(String ownerorgid) {
		this.ownerorgid = ownerorgid;
	}

	public String getProid() {
		return proid;
	}

	public void setProid(String proid) {
		this.proid = proid;
	}

	public Short getSettleday() {
		return settleday;
	}

	public void setSettleday(Short settleday) {
		this.settleday = settleday;
	}

	public Date getInvaliddate() {
		return invaliddate;
	}

	public void setInvaliddate(Date invaliddate) {
		this.invaliddate = invaliddate;
	}


}
