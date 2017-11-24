package com.gmcc.pboss.business.resource.comressmplog;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class ComressmplogVO extends BaseVO implements Serializable {

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
    private String comresid;

    /** nullable persistent field */
    private Long comid;

    /** nullable persistent field */
    private String batchno;

    /** nullable persistent field */
    private Short comstate;

    /** nullable persistent field */
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
    private Long simprice;

    /** nullable persistent field */
    private Short isopen;

    /** nullable persistent field */
    private String iccid;

    /** nullable persistent field */
    private String brand;

    /** nullable persistent field */
    private String boxnum;

    /** nullable persistent field */
    private java.util.Date entertime;

    /** nullable persistent field */
    private String numbertype;
    private Integer insideseq;
    private Date saletime;

//    /** nullable persistent field */
//    private String resuse;
//
//    /** nullable persistent field */
//    private String storarea;

   

    public ComressmplogVO(Long logid, Date optime, String oprcode2,
			String oprtype, String success, String comresid, Long comid,
			String batchno, Short comstate, String wayid, String oprcode,
			Date starttime, Date validperiod, Date comkeep, Long comdisc,
			Long price, Date comactive, Integer comsource, Long stockprice,
			Long simprice, Short isopen, String iccid, String brand,
			String boxnum, Date entertime, String numbertype,
			Integer insideseq, Date saletime) {
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
		this.simprice = simprice;
		this.isopen = isopen;
		this.iccid = iccid;
		this.brand = brand;
		this.boxnum = boxnum;
		this.entertime = entertime;
		this.numbertype = numbertype;
		this.insideseq = insideseq;
		this.saletime = saletime;
	}

	/** default constructor */
    public ComressmplogVO() {
    }

    /** minimal constructor */
    public ComressmplogVO(java.lang.Long logid) {
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

    public java.lang.Long getSimprice() {
        return this.simprice;
    }

    public void setSimprice(java.lang.Long simprice) {
        this.simprice = simprice;
    }

    public java.lang.Short getIsopen() {
        return this.isopen;
    }

    public void setIsopen(java.lang.Short isopen) {
        this.isopen = isopen;
    }

    public java.lang.String getIccid() {
        return this.iccid;
    }

    public void setIccid(java.lang.String iccid) {
        this.iccid = iccid;
    }

    public java.lang.String getBrand() {
        return this.brand;
    }

    public void setBrand(java.lang.String brand) {
        this.brand = brand;
    }

    public java.lang.String getBoxnum() {
        return this.boxnum;
    }

    public void setBoxnum(java.lang.String boxnum) {
        this.boxnum = boxnum;
    }

    public java.util.Date getEntertime() {
        return this.entertime;
    }

    public void setEntertime(java.util.Date entertime) {
        this.entertime = entertime;
    }

    public java.lang.String getNumbertype() {
        return this.numbertype;
    }

    public void setNumbertype(java.lang.String numbertype) {
        this.numbertype = numbertype;
    }

//    public java.lang.String getResuse() {
//        return this.resuse;
//    }
//
//    public void setResuse(java.lang.String resuse) {
//        this.resuse = resuse;
//    }
//
//    public java.lang.String getStorarea() {
//        return this.storarea;
//    }
//
//    public void setStorarea(java.lang.String storarea) {
//        this.storarea = storarea;
//    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("logid", getLogid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ComressmplogVO) ) return false;
        ComressmplogVO castOther = (ComressmplogVO) other;
        return new EqualsBuilder()
            .append(this.getLogid(), castOther.getLogid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getLogid())
            .toHashCode();
    }

	public Integer getInsideseq() {
		return insideseq;
	}

	public void setInsideseq(Integer insideseq) {
		this.insideseq = insideseq;
	}

	public Date getSaletime() {
		return saletime;
	}

	public void setSaletime(Date saletime) {
		this.saletime = saletime;
	}

}
