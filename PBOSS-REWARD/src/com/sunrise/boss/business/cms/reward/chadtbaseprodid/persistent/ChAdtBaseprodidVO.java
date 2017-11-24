package com.sunrise.boss.business.cms.reward.chadtbaseprodid.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class ChAdtBaseprodidVO implements Serializable {

    /** identifier field */
    private String cityid;

    /** identifier field */
    private String prodid;

    /** persistent field */
    private String type;

    /** nullable persistent field */
    private String prodname;

    /** persistent field */
    private String oprtype;

    /** nullable persistent field */
    private String tertype;

    /** persistent field */
    private Double wrapfee;

    /** nullable persistent field */
    private java.util.Date createtime;

    /** nullable persistent field */
    private String adtremark;

    /** full constructor */
    public ChAdtBaseprodidVO(java.lang.String cityid, java.lang.String prodid, java.lang.String type, java.lang.String prodname, java.lang.String oprtype, java.lang.String tertype, java.lang.Double wrapfee, java.util.Date createtime, java.lang.String adtremark) {
        this.cityid = cityid;
        this.prodid = prodid;
        this.type = type;
        this.prodname = prodname;
        this.oprtype = oprtype;
        this.tertype = tertype;
        this.wrapfee = wrapfee;
        this.createtime = createtime;
        this.adtremark = adtremark;
    }

    /** default constructor */
    public ChAdtBaseprodidVO() {
    }

    /** minimal constructor */
    public ChAdtBaseprodidVO(java.lang.String cityid, java.lang.String prodid, java.lang.String type, java.lang.String oprtype, java.lang.Double wrapfee) {
        this.cityid = cityid;
        this.prodid = prodid;
        this.type = type;
        this.oprtype = oprtype;
        this.wrapfee = wrapfee;
    }

    public java.lang.String getCityid() {
        return this.cityid;
    }

    public void setCityid(java.lang.String cityid) {
        this.cityid = cityid;
    }

    public java.lang.String getProdid() {
        return this.prodid;
    }

    public void setProdid(java.lang.String prodid) {
        this.prodid = prodid;
    }

    public java.lang.String getType() {
        return this.type;
    }

    public void setType(java.lang.String type) {
        this.type = type;
    }

    public java.lang.String getProdname() {
        return this.prodname;
    }

    public void setProdname(java.lang.String prodname) {
        this.prodname = prodname;
    }

    public java.lang.String getOprtype() {
        return this.oprtype;
    }

    public void setOprtype(java.lang.String oprtype) {
        this.oprtype = oprtype;
    }

    public java.lang.String getTertype() {
        return this.tertype;
    }

    public void setTertype(java.lang.String tertype) {
        this.tertype = tertype;
    }

    public java.lang.Double getWrapfee() {
        return this.wrapfee;
    }

    public void setWrapfee(java.lang.Double wrapfee) {
        this.wrapfee = wrapfee;
    }

    public java.util.Date getCreatetime() {
        return this.createtime;
    }

    public void setCreatetime(java.util.Date createtime) {
        this.createtime = createtime;
    }

    public java.lang.String getAdtremark() {
        return this.adtremark;
    }

    public void setAdtremark(java.lang.String adtremark) {
        this.adtremark = adtremark;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("cityid", getCityid())
            .append("prodid", getProdid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ChAdtBaseprodidVO) ) return false;
        ChAdtBaseprodidVO castOther = (ChAdtBaseprodidVO) other;
        return new EqualsBuilder()
            .append(this.getCityid(), castOther.getCityid())
            .append(this.getProdid(), castOther.getProdid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCityid())
            .append(getProdid())
            .toHashCode();
    }

}
