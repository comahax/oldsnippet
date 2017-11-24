package com.gmcc.pboss.business.resource.comrescardlog;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class ComrescardlogVO extends BaseVO implements Serializable {

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

    /** persistent field */
    private String comresid;

    /** persistent field */
    private Long comid;

    /** nullable persistent field */
    private String batchno;

    /** persistent field */
    private Short comstate;

    /** persistent field */
    private String wayid;

    /** nullable persistent field */
    private String oprcode;

    /** nullable persistent field */
    private java.util.Date starttime;

    /** nullable persistent field */
    private java.util.Date validperiod;

    /** nullable persistent field */
    private java.util.Date comkeep;

    /** nullable persistent field */
    private Long comdisc;

    /** nullable persistent field */
    private Long price;

    /** nullable persistent field */
    private java.util.Date comactive;

    /** nullable persistent field */
    private Integer comsource;

    /** nullable persistent field */
    private Long stockprice;

    /** nullable persistent field */
    private String chargepwd;

    /** nullable persistent field */
    private Long packtype;

    /** nullable persistent field */
    private java.util.Date entertime;
    
    private Date saletime;

    

    public Date getSaletime() {
		return saletime;
	}

	public void setSaletime(Date saletime) {
		this.saletime = saletime;
	}

	public ComrescardlogVO(Long logid, Date optime, String oprcode2,
			String oprtype, String success, String comresid, Long comid,
			String batchno, Short comstate, String wayid, String oprcode,
			Date starttime, Date validperiod, Date comkeep, Long comdisc,
			Long price, Date comactive, Integer comsource, Long stockprice,
			String chargepwd, Long packtype, Date entertime, Date saletime) {
		super();
		this.logid = logid;
		this.optime = optime;
		this.oprcode2 = oprcode2;
		this.oprtype = oprtype;
		this.success = success;
		this.comresid = comresid;
		this.comid = comid;
		this.batchno = batchno;
		this.comstate = comstate;
		this.wayid = wayid;
		this.oprcode = oprcode;
		this.starttime = starttime;
		this.validperiod = validperiod;
		this.comkeep = comkeep;
		this.comdisc = comdisc;
		this.price = price;
		this.comactive = comactive;
		this.comsource = comsource;
		this.stockprice = stockprice;
		this.chargepwd = chargepwd;
		this.packtype = packtype;
		this.entertime = entertime;
		this.saletime = saletime;
	}

	/** default constructor */
    public ComrescardlogVO() {
    }

    /** minimal constructor */
    public ComrescardlogVO(java.lang.Long logid, java.lang.String comresid, java.lang.Long comid, java.lang.Short comstate, java.lang.String wayid) {
        this.logid = logid;
        this.comresid = comresid;
        this.comid = comid;
        this.comstate = comstate;
        this.wayid = wayid;
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

    public java.lang.String getComresid() {
        return this.comresid;
    }

    public void setComresid(java.lang.String comresid) {
        this.comresid = comresid;
    }

    public java.lang.Long getComid() {
        return this.comid;
    }

    public void setComid(java.lang.Long comid) {
        this.comid = comid;
    }

    public java.lang.String getBatchno() {
        return this.batchno;
    }

    public void setBatchno(java.lang.String batchno) {
        this.batchno = batchno;
    }

    public java.lang.Short getComstate() {
        return this.comstate;
    }

    public void setComstate(java.lang.Short comstate) {
        this.comstate = comstate;
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.String getOprcode() {
        return this.oprcode;
    }

    public void setOprcode(java.lang.String oprcode) {
        this.oprcode = oprcode;
    }

    public java.util.Date getStarttime() {
        return this.starttime;
    }

    public void setStarttime(java.util.Date starttime) {
        this.starttime = starttime;
    }

    public java.util.Date getValidperiod() {
        return this.validperiod;
    }

    public void setValidperiod(java.util.Date validperiod) {
        this.validperiod = validperiod;
    }

    public java.util.Date getComkeep() {
        return this.comkeep;
    }

    public void setComkeep(java.util.Date comkeep) {
        this.comkeep = comkeep;
    }

    public java.lang.Long getComdisc() {
        return this.comdisc;
    }

    public void setComdisc(java.lang.Long comdisc) {
        this.comdisc = comdisc;
    }

    public java.lang.Long getPrice() {
        return this.price;
    }

    public void setPrice(java.lang.Long price) {
        this.price = price;
    }

    public java.util.Date getComactive() {
        return this.comactive;
    }

    public void setComactive(java.util.Date comactive) {
        this.comactive = comactive;
    }

    public java.lang.Integer getComsource() {
        return this.comsource;
    }

    public void setComsource(java.lang.Integer comsource) {
        this.comsource = comsource;
    }

    public java.lang.Long getStockprice() {
        return this.stockprice;
    }

    public void setStockprice(java.lang.Long stockprice) {
        this.stockprice = stockprice;
    }

    public java.lang.String getChargepwd() {
        return this.chargepwd;
    }

    public void setChargepwd(java.lang.String chargepwd) {
        this.chargepwd = chargepwd;
    }

    public java.lang.Long getPacktype() {
        return this.packtype;
    }

    public void setPacktype(java.lang.Long packtype) {
        this.packtype = packtype;
    }

    public java.util.Date getEntertime() {
        return this.entertime;
    }

    public void setEntertime(java.util.Date entertime) {
        this.entertime = entertime;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("logid", getLogid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ComrescardlogVO) ) return false;
        ComrescardlogVO castOther = (ComrescardlogVO) other;
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
