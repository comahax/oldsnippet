package com.gmcc.pboss.business.resource.comcatebrand;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class ComcatebrandVO extends BaseVO implements Serializable {

    /** identifier field */
    private String comcategory;

    /** nullable persistent field */
    private String brand;
    
    private Double parValue;

    /** full constructor */
    public ComcatebrandVO(java.lang.String comcategory, java.lang.String brand) {
        this.comcategory = comcategory;
        this.brand = brand;
    }

    /** default constructor */
    public ComcatebrandVO() {
    }

    /** minimal constructor */
    public ComcatebrandVO(java.lang.String comcategory) {
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

    public String toString() {
        return new ToStringBuilder(this)
            .append("comcategory", getComcategory())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ComcatebrandVO) ) return false;
        ComcatebrandVO castOther = (ComcatebrandVO) other;
        return new EqualsBuilder()
            .append(this.getComcategory(), castOther.getComcategory())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getComcategory())
            .toHashCode();
    }

	public Double getParValue() {
		return parValue;
	}

	public void setParValue(Double parValue) {
		this.parValue = parValue;
	}

}
