package com.sunrise.boss.business.zifee.pcppproduct.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class PcPpProductVO implements Serializable {

    /** identifier field */
    private String prodid;

    /** nullable persistent field */
    private String prodname;
    
    
    /** nullable persistent field */
    private String producttype;

    /** nullable persistent field */
    private String nettype;


    private Short mainprod;

    /** nullable persistent field */
    private String prodclass;

    /** nullable persistent field */
    private String sourcetype;

    /** nullable persistent field */
    private Byte issolution;

    /** nullable persistent field */
    private java.util.Date availabledate;

    /** nullable persistent field */
    private java.util.Date enddate;

    /** nullable persistent field */
    private String adddata;

    /** nullable persistent field */
    private Short sortorder;

    /** nullable persistent field */
    private String description;

    /** nullable persistent field */
    private String version;

    /** nullable persistent field */
    private String notes;

    /** nullable persistent field */
    private String createorgid;

    /** nullable persistent field */
    private java.util.Date createdate;

    /** persistent field */
    private String status;

    /** nullable persistent field */
    private java.util.Date statusdate;

//    /** full constructor */
//    public PcPpProductVO(java.lang.String prodid, java.lang.String prodname, java.lang.String producttype, java.lang.String nettype, java.lang.Byte mainprod, java.lang.String prodclass, java.lang.String sourcetype, java.lang.Byte issolution, java.util.Date availabledate, java.util.Date enddate,  java.lang.String adddata, java.lang.Short sortorder, java.lang.String description, java.lang.String version, java.lang.String notes, java.lang.String createorgid, java.util.Date createdate, java.lang.String status, java.util.Date statusdate) {
//        this.prodid = prodid;
//        this.prodname = prodname;
//        this.producttype = producttype;
//        this.nettype = nettype;
//        this.mainprod = mainprod;
//        this.prodclass = prodclass;
//        this.sourcetype = sourcetype;
//        this.issolution = issolution;
//        this.availabledate = availabledate;
//        this.enddate = enddate;
//        this.adddata = adddata;
//        this.sortorder = sortorder;
//        this.description = description;
//        this.version = version;
//        this.notes = notes;
//        this.createorgid = createorgid;
//        this.createdate = createdate;
//        this.status = status;
//        this.statusdate = statusdate;
//    }
//
    /** default constructor */
    public PcPpProductVO() {
    }
//
//    /** minimal constructor */
//    public PcPpProductVO(java.lang.String prodid, java.lang.Byte mainprod, java.lang.String status) {
//        this.prodid = prodid;
//        this.mainprod = mainprod;
//        this.status = status;
//    }
//
    public java.lang.String getProdid() {
        return this.prodid;
    }

    public void setProdid(java.lang.String prodid) {
        this.prodid = prodid;
    }

    public java.lang.String getProdname() {
        return this.prodname;
    }

    public void setProdname(java.lang.String prodname) {
        this.prodname = prodname;
    }

//    public java.lang.String getProducttype() {
//        return this.producttype;
//    }
//
//    public void setProducttype(java.lang.String producttype) {
//        this.producttype = producttype;
//    }
//
//    public java.lang.String getNettype() {
//        return this.nettype;
//    }
//
//    public void setNettype(java.lang.String nettype) {
//        this.nettype = nettype;
//    }
//
//    public java.lang.Byte getMainprod() {
//        return this.mainprod;
//    }
//
//    public void setMainprod(java.lang.Byte mainprod) {
//        this.mainprod = mainprod;
//    }
//
//    public java.lang.String getProdclass() {
//        return this.prodclass;
//    }
//
//    public void setProdclass(java.lang.String prodclass) {
//        this.prodclass = prodclass;
//    }
//
//    public java.lang.String getSourcetype() {
//        return this.sourcetype;
//    }
//
//    public void setSourcetype(java.lang.String sourcetype) {
//        this.sourcetype = sourcetype;
//    }
//
//    public java.lang.Byte getIssolution() {
//        return this.issolution;
//    }
//
//    public void setIssolution(java.lang.Byte issolution) {
//        this.issolution = issolution;
//    }
//
//    public java.util.Date getAvailabledate() {
//        return this.availabledate;
//    }
//
//    public void setAvailabledate(java.util.Date availabledate) {
//        this.availabledate = availabledate;
//    }
//
//    public java.util.Date getEnddate() {
//        return this.enddate;
//    }
//
//    public void setEnddate(java.util.Date enddate) {
//        this.enddate = enddate;
//    }
//
//    public java.lang.String getAdddata() {
//        return this.adddata;
//    }
//
//    public void setAdddata(java.lang.String adddata) {
//        this.adddata = adddata;
//    }
//
//    public java.lang.Short getSortorder() {
//        return this.sortorder;
//    }
//
//    public void setSortorder(java.lang.Short sortorder) {
//        this.sortorder = sortorder;
//    }
//
//    public java.lang.String getDescription() {
//        return this.description;
//    }
//
//    public void setDescription(java.lang.String description) {
//        this.description = description;
//    }
//
//    public java.lang.String getVersion() {
//        return this.version;
//    }
//
//    public void setVersion(java.lang.String version) {
//        this.version = version;
//    }
//
//    public java.lang.String getNotes() {
//        return this.notes;
//    }
//
//    public void setNotes(java.lang.String notes) {
//        this.notes = notes;
//    }
//
//    public java.lang.String getCreateorgid() {
//        return this.createorgid;
//    }
//
//    public void setCreateorgid(java.lang.String createorgid) {
//        this.createorgid = createorgid;
//    }
//
//    public java.util.Date getCreatedate() {
//        return this.createdate;
//    }
//
//    public void setCreatedate(java.util.Date createdate) {
//        this.createdate = createdate;
//    }
//
//    public java.lang.String getStatus() {
//        return this.status;
//    }
//
//    public void setStatus(java.lang.String status) {
//        this.status = status;
//    }
//
//    public java.util.Date getStatusdate() {
//        return this.statusdate;
//    }
//
//    public void setStatusdate(java.util.Date statusdate) {
//        this.statusdate = statusdate;
//    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("prodid", getProdid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof PcPpProductVO) ) return false;
        PcPpProductVO castOther = (PcPpProductVO) other;
        return new EqualsBuilder()
            .append(this.getProdid(), castOther.getProdid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getProdid())
            .toHashCode();
    }
	public Short getMainprod() {
		return mainprod;
	}
	public void setMainprod(Short mainprod) {
		this.mainprod = mainprod;
	}
	public String getAdddata() {
		return adddata;
	}
	public void setAdddata(String adddata) {
		this.adddata = adddata;
	}
	public java.util.Date getAvailabledate() {
		return availabledate;
	}
	public void setAvailabledate(java.util.Date availabledate) {
		this.availabledate = availabledate;
	}
	public java.util.Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(java.util.Date createdate) {
		this.createdate = createdate;
	}
	public String getCreateorgid() {
		return createorgid;
	}
	public void setCreateorgid(String createorgid) {
		this.createorgid = createorgid;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public java.util.Date getEnddate() {
		return enddate;
	}
	public void setEnddate(java.util.Date enddate) {
		this.enddate = enddate;
	}
	public Byte getIssolution() {
		return issolution;
	}
	public void setIssolution(Byte issolution) {
		this.issolution = issolution;
	}
	public String getNettype() {
		return nettype;
	}
	public void setNettype(String nettype) {
		this.nettype = nettype;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public String getProdclass() {
		return prodclass;
	}
	public void setProdclass(String prodclass) {
		this.prodclass = prodclass;
	}
	public String getProducttype() {
		return producttype;
	}
	public void setProducttype(String producttype) {
		this.producttype = producttype;
	}
	public Short getSortorder() {
		return sortorder;
	}
	public void setSortorder(Short sortorder) {
		this.sortorder = sortorder;
	}
	public String getSourcetype() {
		return sourcetype;
	}
	public void setSourcetype(String sourcetype) {
		this.sourcetype = sourcetype;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public java.util.Date getStatusdate() {
		return statusdate;
	}
	public void setStatusdate(java.util.Date statusdate) {
		this.statusdate = statusdate;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}

}
