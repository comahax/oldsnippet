package com.gmcc.pboss.business.resource.resalarminfo;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class ResalarminfoVO extends BaseVO implements Serializable {

    /** identifier field */
    private Long recid;

    /** nullable persistent field */
    private java.util.Date alarmdate;

    /** nullable persistent field */
    private String countyid;

    /** nullable persistent field */
    private String comcategory;

    /** nullable persistent field */
    private Long stockamt;

    /** nullable persistent field */
    private Long saledamt;

    /** nullable persistent field */
    private Long actedamt;

    /** nullable persistent field */
    private Double actrate;

    /** nullable persistent field */
    private String alarmsignal;

    /** full constructor */
    public ResalarminfoVO(java.util.Date alarmdate, java.lang.String countyid, java.lang.String comcategory, java.lang.Long stockamt, java.lang.Long saledamt, java.lang.Long actedamt, java.lang.Double actrate, java.lang.String alarmsignal) {
        this.alarmdate = alarmdate;
        this.countyid = countyid;
        this.comcategory = comcategory;
        this.stockamt = stockamt;
        this.saledamt = saledamt;
        this.actedamt = actedamt;
        this.actrate = actrate;
        this.alarmsignal = alarmsignal;
    }

    /** default constructor */
    public ResalarminfoVO() {
    }

    public java.lang.Long getRecid() {
        return this.recid;
    }

    public void setRecid(java.lang.Long recid) {
        this.recid = recid;
    }

    public java.util.Date getAlarmdate() {
        return this.alarmdate;
    }

    public void setAlarmdate(java.util.Date alarmdate) {
        this.alarmdate = alarmdate;
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

    public java.lang.Long getStockamt() {
        return this.stockamt;
    }

    public void setStockamt(java.lang.Long stockamt) {
        this.stockamt = stockamt;
    }

    public java.lang.Long getSaledamt() {
        return this.saledamt;
    }

    public void setSaledamt(java.lang.Long saledamt) {
        this.saledamt = saledamt;
    }

    public java.lang.Long getActedamt() {
        return this.actedamt;
    }

    public void setActedamt(java.lang.Long actedamt) {
        this.actedamt = actedamt;
    }

    public java.lang.Double getActrate() {
        return this.actrate;
    }

    public void setActrate(java.lang.Double actrate) {
        this.actrate = actrate;
    }

    public java.lang.String getAlarmsignal() {
        return this.alarmsignal;
    }

    public void setAlarmsignal(java.lang.String alarmsignal) {
        this.alarmsignal = alarmsignal;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("recid", getRecid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ResalarminfoVO) ) return false;
        ResalarminfoVO castOther = (ResalarminfoVO) other;
        return new EqualsBuilder()
            .append(this.getRecid(), castOther.getRecid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getRecid())
            .toHashCode();
    }

}
