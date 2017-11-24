package com.gmcc.pboss.business.sales.saleplan;

import com.gmcc.pboss.business.sales.saleplanlog.SaleplanlogVO;
import com.gmcc.pboss.business.sales.salesstdlog.SalesstdlogVO;
import com.sunrise.jop.infrastructure.db.BaseVO;
import com.sunrise.jop.infrastructure.sysadmin.BusinessLog;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class SaleplanVO extends BaseVO implements Serializable,BusinessLog {

    /** identifier field */
    private Long recid;

    /** persistent field */
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
    public SaleplanVO(java.lang.Long recid, java.lang.String cityid, java.lang.String plancode, java.lang.String planname, java.util.Date begindate, java.util.Date enddate, java.lang.String comcategory, java.lang.String premode, java.lang.Double prevalue, java.lang.String memo) {
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
    public SaleplanVO() {
    }

    /** minimal constructor */
    public SaleplanVO(java.lang.Long recid, java.lang.String cityid) {
        this.recid = recid;
        this.cityid = cityid;
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
            .append("recid", getRecid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof SaleplanVO) ) return false;
        SaleplanVO castOther = (SaleplanVO) other;
        return new EqualsBuilder()
            .append(this.getRecid(), castOther.getRecid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getRecid())
            .toHashCode();
    }
	public Class logVOClass() {
		// TODO Auto-generated method stub
		return SaleplanlogVO.class;
	}

}
