package com.gmcc.pboss.business.sales.bankshop;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.gmcc.pboss.business.sales.bankshoplog.BankshoplogVO;
import com.sunrise.jop.infrastructure.db.BaseVO;
import com.sunrise.jop.infrastructure.sysadmin.BusinessLog;

/** @author Hibernate CodeGenerator */
public class BankshopVO extends BaseVO implements BusinessLog, Serializable {

    /** identifier field */
    private Long recid;

    /** persistent field */
    private String cityid;

    /** persistent field */
    private String countyid;

    /** persistent field */
    private String shopnum;

    /** persistent field */
    private String terminalnum;

    /** nullable persistent field */
    private String receivebank;

    /** full constructor */
    public BankshopVO(java.lang.Long recid, java.lang.String cityid, java.lang.String countyid, java.lang.String shopnum, java.lang.String terminalnum, java.lang.String receivebank) {
        this.recid = recid;
        this.cityid = cityid;
        this.countyid = countyid;
        this.shopnum = shopnum;
        this.terminalnum = terminalnum;
        this.receivebank = receivebank;
    }

    /** default constructor */
    public BankshopVO() {
    }

    /** minimal constructor */
    public BankshopVO(java.lang.Long recid, java.lang.String cityid, java.lang.String countyid, java.lang.String shopnum, java.lang.String terminalnum) {
        this.recid = recid;
        this.cityid = cityid;
        this.countyid = countyid;
        this.shopnum = shopnum;
        this.terminalnum = terminalnum;
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

    public java.lang.String getShopnum() {
        return this.shopnum;
    }

    public void setShopnum(java.lang.String shopnum) {
        this.shopnum = shopnum;
    }

    public java.lang.String getTerminalnum() {
        return this.terminalnum;
    }

    public void setTerminalnum(java.lang.String terminalnum) {
        this.terminalnum = terminalnum;
    }

    public java.lang.String getReceivebank() {
        return this.receivebank;
    }

    public void setReceivebank(java.lang.String receivebank) {
        this.receivebank = receivebank;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("recid", getRecid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof BankshopVO) ) return false;
        BankshopVO castOther = (BankshopVO) other;
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
    	return BankshoplogVO.class;
    }

}
