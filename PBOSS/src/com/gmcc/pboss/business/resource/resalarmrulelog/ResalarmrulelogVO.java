package com.gmcc.pboss.business.resource.resalarmrulelog;


import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class ResalarmrulelogVO extends BaseVO implements Serializable {

    /** identifier field */
    private Long logid;

    /** nullable persistent field */
    private java.util.Date optime;

    /** nullable persistent field */
    private String oprcode2;

    /** nullable persistent field */
    private String oprtype;

    /** nullable persistent field */
    private String success;

    /** nullable persistent field */
    private Long recid;

    /** nullable persistent field */
    private String cityid;

    /** nullable persistent field */
    private String countyid;

    /** nullable persistent field */
    private String comcategory;

    /** nullable persistent field */
    private Long lowstock;

    /** nullable persistent field */
    private Double upactrate;

    /** nullable persistent field */
    private String handlercode;

    /** full constructor */
    public ResalarmrulelogVO(java.util.Date optime, java.lang.String oprcode2, java.lang.String oprtype, java.lang.String success, java.lang.Long recid, java.lang.String cityid, java.lang.String countyid, java.lang.String comcategory, java.lang.Long lowstock, java.lang.Double upactrate, java.lang.String handlercode) {
        this.optime = optime;
        this.oprcode2 = oprcode2;
        this.oprtype = oprtype;
        this.success = success;
        this.recid = recid;
        this.cityid = cityid;
        this.countyid = countyid;
        this.comcategory = comcategory;
        this.lowstock = lowstock;
        this.upactrate = upactrate;
        this.handlercode = handlercode;
    }

    /** default constructor */
    public ResalarmrulelogVO() {
    }

    public java.lang.Long getLogid() {
        return this.logid;
    }

    public void setLogid(java.lang.Long logid) {
        this.logid = logid;
    }

    public java.util.Date getOptime() {
        return this.optime;
    }

    public void setOptime(java.util.Date optime) {
        this.optime = optime;
    }

    public java.lang.String getOprcode2() {
        return this.oprcode2;
    }

    public void setOprcode2(java.lang.String oprcode2) {
        this.oprcode2 = oprcode2;
    }

    public java.lang.String getOprtype() {
        return this.oprtype;
    }

    public void setOprtype(java.lang.String oprtype) {
        this.oprtype = oprtype;
    }

    public java.lang.String getSuccess() {
        return this.success;
    }

    public void setSuccess(java.lang.String success) {
        this.success = success;
    }

    public java.lang.Long getRecid() {
        return this.recid;
    }

    public void setRecid(java.lang.Long recid) {
        this.recid = recid;
    }

    public java.lang.String getCityid() {
        return this.cityid;
    }

    public void setCityid(java.lang.String cityid) {
        this.cityid = cityid;
    }

    public java.lang.String getCountyid() {
        return this.countyid;
    }

    public void setCountyid(java.lang.String countyid) {
        this.countyid = countyid;
    }

    public java.lang.String getComcategory() {
        return this.comcategory;
    }

    public void setComcategory(java.lang.String comcategory) {
        this.comcategory = comcategory;
    }

    public java.lang.Long getLowstock() {
        return this.lowstock;
    }

    public void setLowstock(java.lang.Long lowstock) {
        this.lowstock = lowstock;
    }

    public java.lang.Double getUpactrate() {
        return this.upactrate;
    }

    public void setUpactrate(java.lang.Double upactrate) {
        this.upactrate = upactrate;
    }

    public java.lang.String getHandlercode() {
        return this.handlercode;
    }

    public void setHandlercode(java.lang.String handlercode) {
        this.handlercode = handlercode;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("logid", getLogid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ResalarmrulelogVO) ) return false;
        ResalarmrulelogVO castOther = (ResalarmrulelogVO) other;
        return new EqualsBuilder()
            .append(this.getLogid(), castOther.getLogid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getLogid())
            .toHashCode();
    }

}
