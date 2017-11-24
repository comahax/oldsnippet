package com.sunrise.boss.business.cms.reward.typeinfo.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TypeinfoVO implements Serializable {

    /** identifier field */
    private String cityid;

    /** identifier field */
    private Short facetype;

    /** identifier field */
    private String type;

    /** nullable persistent field */
    private String facename;

    /** nullable persistent field */
    private String typename;

    /** full constructor */
    public TypeinfoVO(java.lang.String cityid, java.lang.Short facetype, java.lang.String type, java.lang.String facename, java.lang.String typename) {
        this.cityid = cityid;
        this.facetype = facetype;
        this.type = type;
        this.facename = facename;
        this.typename = typename;
    }

    /** default constructor */
    public TypeinfoVO() {
    }

    /** minimal constructor */
    public TypeinfoVO(java.lang.String cityid, java.lang.Short facetype, java.lang.String type) {
        this.cityid = cityid;
        this.facetype = facetype;
        this.type = type;
    }

    public java.lang.String getCityid() {
        return this.cityid;
    }

    public void setCityid(java.lang.String cityid) {
        this.cityid = cityid;
    }

    public java.lang.Short getFacetype() {
        return this.facetype;
    }

    public void setFacetype(java.lang.Short facetype) {
        this.facetype = facetype;
    }

    public java.lang.String getType() {
        return this.type;
    }

    public void setType(java.lang.String type) {
        this.type = type;
    }

    public java.lang.String getFacename() {
        return this.facename;
    }

    public void setFacename(java.lang.String facename) {
        this.facename = facename;
    }

    public java.lang.String getTypename() {
        return this.typename;
    }

    public void setTypename(java.lang.String typename) {
        this.typename = typename;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("cityid", getCityid())
            .append("facetype", getFacetype())
            .append("type", getType())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TypeinfoVO) ) return false;
        TypeinfoVO castOther = (TypeinfoVO) other;
        return new EqualsBuilder()
            .append(this.getCityid(), castOther.getCityid())
            .append(this.getFacetype(), castOther.getFacetype())
            .append(this.getType(), castOther.getType())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCityid())
            .append(getFacetype())
            .append(getType())
            .toHashCode();
    }

}
