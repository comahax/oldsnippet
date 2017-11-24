package com.gmcc.pboss.business.resource.comcategoryrela;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.gmcc.pboss.business.resource.comcategoryrelalog.ComcategoryrelalogVO;
import com.sunrise.jop.infrastructure.db.BaseVO;
import com.sunrise.jop.infrastructure.sysadmin.BusinessLog;

/** @author Hibernate CodeGenerator */
public class ComcategoryrelaVO extends BaseVO implements Serializable ,BusinessLog{

    /** identifier field */
    private Long relaid;

    /** persistent field */
    private String comcategory;

    /** persistent field */
    private Long comid;

    /** persistent field */
    private String restype;
    
    private String brand;

    /** full constructor */
    public ComcategoryrelaVO(java.lang.Long relaid, java.lang.String comcategory, java.lang.Long comid, java.lang.String restype,String brand) {
        this.relaid = relaid;
        this.comcategory = comcategory;
        this.comid = comid;
        this.restype = restype;
        this.brand=brand;
    }

    /** default constructor */
    public ComcategoryrelaVO() {
    }

    public java.lang.Long getRelaid() {
        return this.relaid;
    }

    public void setRelaid(java.lang.Long relaid) {
        this.relaid = relaid;
    }

    public java.lang.String getComcategory() {
        return this.comcategory;
    }

    public void setComcategory(java.lang.String comcategory) {
        this.comcategory = comcategory;
    }

    public java.lang.Long getComid() {
        return this.comid;
    }

    public void setComid(java.lang.Long comid) {
        this.comid = comid;
    }

    public java.lang.String getRestype() {
        return this.restype;
    }

    public void setRestype(java.lang.String restype) {
        this.restype = restype;
    }
    

    public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String toString() {
        return new ToStringBuilder(this)
            .append("relaid", getRelaid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ComcategoryrelaVO) ) return false;
        ComcategoryrelaVO castOther = (ComcategoryrelaVO) other;
        return new EqualsBuilder()
            .append(this.getRelaid(), castOther.getRelaid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getRelaid())
            .toHashCode();
    }

	public Class logVOClass() {
		// TODO Auto-generated method stub
		return ComcategoryrelalogVO.class;
	}

}
