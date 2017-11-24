package com.gmcc.pboss.business.sales.timesect;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.gmcc.pboss.business.sales.timesectlog.TimesectlogVO;
import com.sunrise.jop.infrastructure.db.BaseVO;
import com.sunrise.jop.infrastructure.sysadmin.BusinessLog;

/** @author Hibernate CodeGenerator */
public class TimesectVO extends BaseVO implements BusinessLog {

    /** identifier field */
    private Long recid;

    /** persistent field */
    private String cityid;

    /** nullable persistent field */
    private String countyid;

    /** nullable persistent field */
    private String mareacode;

    /** nullable persistent field */
    private String datetype;

    /** nullable persistent field */
    private String weekset;

    /** nullable persistent field */
    private String timesect;

    /** nullable persistent field */
    private java.util.Date begindate;

    /** nullable persistent field */
    private java.util.Date enddate;

    /** full constructor */
    public TimesectVO(java.lang.String cityid, java.lang.String countyid, java.lang.String mareacode, java.lang.String datetype, java.lang.String weekset, java.lang.String timesect, java.util.Date begindate, java.util.Date enddate) {
        this.cityid = cityid;
        this.countyid = countyid;
        this.mareacode = mareacode;
        this.datetype = datetype;
        this.weekset = weekset;
        this.timesect = timesect;
        this.begindate = begindate;
        this.enddate = enddate;
    }

    /** default constructor */
    public TimesectVO() {
    }

    /** minimal constructor */
    public TimesectVO(java.lang.String cityid) {
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

    public java.lang.String getCountyid() {
        return this.countyid;
    }

    public void setCountyid(java.lang.String countyid) {
        this.countyid = countyid;
    }

    public java.lang.String getMareacode() {
        return this.mareacode;
    }

    public void setMareacode(java.lang.String mareacode) {
        this.mareacode = mareacode;
    }

    public java.lang.String getDatetype() {
        return this.datetype;
    }

    public void setDatetype(java.lang.String datetype) {
        this.datetype = datetype;
    }

    public java.lang.String getWeekset() {
        return this.weekset;
    }

    public void setWeekset(java.lang.String weekset) {
        this.weekset = weekset;
    }

    public java.lang.String getTimesect() {
        return this.timesect;
    }

    public void setTimesect(java.lang.String timesect) {
        this.timesect = timesect;
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

    public String toString() {
        return new ToStringBuilder(this)
            .append("recid", getRecid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TimesectVO) ) return false;
        TimesectVO castOther = (TimesectVO) other;
        return new EqualsBuilder()
            .append(this.getRecid(), castOther.getRecid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getRecid())
            .toHashCode();
    }
    
    public Class logVOClass(){
    	return TimesectlogVO.class;
    }

}
