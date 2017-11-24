package com.sunrise.boss.business.cms.provagent.chpdentproduct.persistent;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.boss.business.cms.provagent.chpdentproductlog.persistent.ChPdEntproductlogVO;
import com.sunrise.boss.business.common.dblog.OperationLog;

/** @author Hibernate CodeGenerator */
public class ChPdEntproductVO implements OperationLog {

    /** identifier field */
    private String prodid;

    /** nullable persistent field */
    private String prodname;

    /** nullable persistent field */
    private String category;

    /** nullable persistent field */
    private String subcategory;

    /** full constructor */
    public ChPdEntproductVO(java.lang.String prodid, java.lang.String prodname, java.lang.String category, java.lang.String subcategory) {
        this.prodid = prodid;
        this.prodname = prodname;
        this.category = category;
        this.subcategory = subcategory;
    }

    /** default constructor */
    public ChPdEntproductVO() {
    }

    /** minimal constructor */
    public ChPdEntproductVO(java.lang.String prodid) {
        this.prodid = prodid;
    }

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

    public java.lang.String getCategory() {
        return this.category;
    }

    public void setCategory(java.lang.String category) {
        this.category = category;
    }

    public java.lang.String getSubcategory() {
        return this.subcategory;
    }

    public void setSubcategory(java.lang.String subcategory) {
        this.subcategory = subcategory;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("prodid", getProdid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ChPdEntproductVO) ) return false;
        ChPdEntproductVO castOther = (ChPdEntproductVO) other;
        return new EqualsBuilder()
            .append(this.getProdid(), castOther.getProdid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getProdid())
            .toHashCode();
    }
    
    public Class logVOClass() {
		return ChPdEntproductlogVO.class;
	}

}
