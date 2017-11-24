package com.gmcc.pboss.business.resource.cityrescode;


import com.gmcc.pboss.business.resource.cityrescodelog.CityrescodelogVO;
import com.sunrise.jop.infrastructure.db.BaseVO;
import com.sunrise.jop.infrastructure.sysadmin.BusinessLog;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class CityrescodeVO extends BaseVO implements BusinessLog,Serializable {

    /** identifier field */
    private Long id;

    /** persistent field */
    private String cityid;

    /** nullable persistent field */
    private String cityrescode;

    /** nullable persistent field */
    private String comcategory;

    /** full constructor */
    public CityrescodeVO(java.lang.String cityid, java.lang.String cityrescode, java.lang.String comcategory) {
        this.cityid = cityid;
        this.cityrescode = cityrescode;
        this.comcategory = comcategory;
    }

    /** default constructor */
    public CityrescodeVO() {
    }

    /** minimal constructor */
    public CityrescodeVO(java.lang.String cityid) {
        this.cityid = cityid;
    }

    public java.lang.Long getId() {
        return this.id;
    }

    public void setId(java.lang.Long id) {
        this.id = id;
    }

    public java.lang.String getCityid() {
        return this.cityid;
    }

    public void setCityid(java.lang.String cityid) {
        this.cityid = cityid;
    }

    public java.lang.String getCityrescode() {
        return this.cityrescode;
    }

    public void setCityrescode(java.lang.String cityrescode) {
        this.cityrescode = cityrescode;
    }

    public java.lang.String getComcategory() {
        return this.comcategory;
    }

    public void setComcategory(java.lang.String comcategory) {
        this.comcategory = comcategory;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("id", getId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CityrescodeVO) ) return false;
        CityrescodeVO castOther = (CityrescodeVO) other;
        return new EqualsBuilder()
            .append(this.getId(), castOther.getId())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getId())
            .toHashCode();
    }
    public Class logVOClass(){
    	return CityrescodelogVO.class;
    }
}
