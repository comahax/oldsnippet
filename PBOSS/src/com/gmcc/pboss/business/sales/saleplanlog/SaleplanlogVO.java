package com.gmcc.pboss.business.sales.saleplanlog;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class SaleplanlogVO extends BaseVO implements Serializable {

    /** identifier field */
    private Long logid;

    /** nullable persistent field */
    private java.util.Date optime;

    /** nullable persistent field */
    private String oprcode;

    /** nullable persistent field */
    private String oprtype;

    /** nullable persistent field */
    private String success;

    /** nullable persistent field */
    private Long recid;

    /** nullable persistent field */
    private String cityid;

    /** nullable persistent field */
    private String plancode;

    /** nullable persistent field */
    private String planname;

    /** nullable persistent field */
    private java.util.Date begindate;

    /** nullable persistent field */
    private java.util.Date enddate;

    /** nullable persistent field */
    private String comcategory;

    /** nullable persistent field */
    private String premode;

    /** nullable persistent field */
    private Double prevalue;

    /** nullable persistent field */
    private String memo;

    /** full constructor */
    public SaleplanlogVO(java.lang.Long logid, java.util.Date optime, java.lang.String oprcode, java.lang.String oprtype, java.lang.String success, java.lang.Long recid, java.lang.String cityid, java.lang.String plancode, java.lang.String planname, java.util.Date begindate, java.util.Date enddate, java.lang.String comcategory, java.lang.String premode, java.lang.Double prevalue, java.lang.String memo) {
        this.logid = logid;
        this.optime = optime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
        this.success = success;
        this.recid = recid;
        this.cityid = cityid;
        this.plancode = plancode;
        this.planname = planname;
        this.begindate = begindate;
        this.enddate = enddate;
        this.comcategory = comcategory;
        this.premode = premode;
        this.prevalue = prevalue;
        this.memo = memo;
    }

    /** default constructor */
    public SaleplanlogVO() {
    }

    /** minimal constructor */
    public SaleplanlogVO(java.lang.Long logid) {
        this.logid = logid;
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

    public java.lang.String getOprcode() {
        return this.oprcode;
    }

    public void setOprcode(java.lang.String oprcode) {
        this.oprcode = oprcode;
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

    public java.lang.String getPlancode() {
        return this.plancode;
    }

    public void setPlancode(java.lang.String plancode) {
        this.plancode = plancode;
    }

    public java.lang.String getPlanname() {
        return this.planname;
    }

    public void setPlanname(java.lang.String planname) {
        this.planname = planname;
    }

    public java.util.Date getBegindate() {
        return this.begindate;
    }

    public void setBegindate(java.util.Date begindate) {
        this.begindate = begindate;
    }

    public java.util.Date getEnddate() {
        return this.enddate;
    }

    public void setEnddate(java.util.Date enddate) {
        this.enddate = enddate;
    }

    public java.lang.String getComcategory() {
        return this.comcategory;
    }

    public void setComcategory(java.lang.String comcategory) {
        this.comcategory = comcategory;
    }

    public java.lang.String getPremode() {
        return this.premode;
    }

    public void setPremode(java.lang.String premode) {
        this.premode = premode;
    }

    public java.lang.Double getPrevalue() {
        return this.prevalue;
    }

    public void setPrevalue(java.lang.Double prevalue) {
        this.prevalue = prevalue;
    }

    public java.lang.String getMemo() {
        return this.memo;
    }

    public void setMemo(java.lang.String memo) {
        this.memo = memo;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("logid", getLogid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof SaleplanlogVO) ) return false;
        SaleplanlogVO castOther = (SaleplanlogVO) other;
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
