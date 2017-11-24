package com.gmcc.pboss.business.resource.comressmp;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.gmcc.pboss.business.resource.comressmplog.ComressmplogVO;
import com.sunrise.jop.infrastructure.db.BaseVO;
import com.sunrise.jop.infrastructure.sysadmin.BusinessRepointLog;

/** @author Hibernate CodeGenerator */
public class ComressmpVO extends BaseVO implements Serializable,BusinessRepointLog {

    /** identifier field */
    private Long comid;

    /** identifier field */
    private String comresid;

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

    /** full constructor */
    public ComressmpVO(java.lang.Long comid, java.lang.String comresid, java.lang.String batchno, java.lang.Short comstate, java.lang.String wayid, java.lang.String oprcode, java.util.Date starttime, java.util.Date validperiod, java.util.Date comkeep, java.lang.Long comdisc, java.lang.Long price, java.util.Date comactive, java.lang.Integer comsource, java.lang.Long stockprice, java.lang.Long simprice, java.lang.Short isopen, java.lang.String iccid, java.lang.String brand, java.lang.String boxnum, java.util.Date entertime, java.lang.String numbertype,Integer insideseq,Date saletime) {
        this.comid = comid;
        this.comresid = comresid;
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
        this.insideseq=insideseq;
        this.saletime=saletime;
//        this.resuse = resuse;
//        this.storarea = storarea;
    }

    /** default constructor */
    public ComressmpVO() {
    }

    /** minimal constructor */
    public ComressmpVO(java.lang.Long comid, java.lang.String comresid, java.lang.Short comstate, java.lang.String wayid) {
        this.comid = comid;
        this.comresid = comresid;
        this.comstate = comstate;
        this.wayid = wayid;
    }

    public java.lang.Long getComid() {
        return this.comid;
    }

    public void setComid(java.lang.Long comid) {
        this.comid = comid;
    }

    public java.lang.String getComresid() {
        return this.comresid;
    }

    public void setComresid(java.lang.String comresid) {
        this.comresid = comresid;
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
            .append("comid", getComid())
            .append("comresid", getComresid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ComressmpVO) ) return false;
        ComressmpVO castOther = (ComressmpVO) other;
        return new EqualsBuilder()
            .append(this.getComid(), castOther.getComid())
            .append(this.getComresid(), castOther.getComresid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getComid())
            .append(getComresid())
            .toHashCode();
    }

	public Class logVOClass() {
		// TODO Auto-generated method stub
		return ComressmplogVO.class;
	}

	public String[] repointLogProperites() {
		// TODO Auto-generated method stub
		return new String[]{"logid","optime","oprcode2","oprtype","success"};
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
