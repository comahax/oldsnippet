package com.gmcc.pboss.business.sales.partnerres;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class PartnerresVO extends BaseVO implements Serializable {

    /** identifier field */
    private Long recid;

    /** persistent field */
    private String wayid;

    /** persistent field */
    private String restype;

    /** nullable persistent field */
    private String comcategory;

    /** nullable persistent field */
    private String comresid;

    /** nullable persistent field */
    private Long comid;

    /** nullable persistent field */
    private String batchno;

    /** nullable persistent field */
    private java.util.Date createtime;

    /** nullable persistent field */
    private String brand;

    /** nullable persistent field */
    private Short isactive;

    /** nullable persistent field */
    private java.util.Date acttime;
    
    private String emptyno;

    /** full constructor */
    public PartnerresVO(java.lang.String wayid, java.lang.String restype, java.lang.String comcategory, java.lang.String comresid, java.lang.Long comid, java.lang.String batchno, java.util.Date createtime, java.lang.String brand, java.lang.Short isactive, java.util.Date acttime,java.lang.String emptyno) {
        this.wayid = wayid;
        this.restype = restype;
        this.comcategory = comcategory;
        this.comresid = comresid;
        this.comid = comid;
        this.batchno = batchno;
        this.createtime = createtime;
        this.brand = brand;
        this.isactive = isactive;
        this.acttime = acttime;
        this.emptyno = emptyno;
    }

    /** default constructor */
    public PartnerresVO() {
    }

    /** minimal constructor */
    public PartnerresVO(java.lang.String wayid, java.lang.String restype) {
        this.wayid = wayid;
        this.restype = restype;
    }

    public java.lang.Long getRecid() {
        return this.recid;
    }

    public void setRecid(java.lang.Long recid) {
        this.recid = recid;
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.String getRestype() {
        return this.restype;
    }

    public void setRestype(java.lang.String restype) {
        this.restype = restype;
    }

    public java.lang.String getComcategory() {
        return this.comcategory;
    }

    public void setComcategory(java.lang.String comcategory) {
        this.comcategory = comcategory;
    }

    public java.lang.String getComresid() {
        return this.comresid;
    }

    public void setComresid(java.lang.String comresid) {
        this.comresid = comresid;
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

    public java.util.Date getCreatetime() {
        return this.createtime;
    }

    public void setCreatetime(java.util.Date createtime) {
        this.createtime = createtime;
    }

    public java.lang.String getBrand() {
        return this.brand;
    }

    public void setBrand(java.lang.String brand) {
        this.brand = brand;
    }

    public java.lang.Short getIsactive() {
        return this.isactive;
    }

    public void setIsactive(java.lang.Short isactive) {
        this.isactive = isactive;
    }

    public java.util.Date getActtime() {
        return this.acttime;
    }

    public void setActtime(java.util.Date acttime) {
        this.acttime = acttime;
    }
    
    
    public String getEmptyno() {
		return emptyno;
	}

	public void setEmptyno(String emptyno) {
		this.emptyno = emptyno;
	}

	public String toString() {
        return new ToStringBuilder(this)
            .append("recid", getRecid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof PartnerresVO) ) return false;
        PartnerresVO castOther = (PartnerresVO) other;
        return new EqualsBuilder()
            .append(this.getRecid(), castOther.getRecid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getRecid())
            .toHashCode();
    }

}
