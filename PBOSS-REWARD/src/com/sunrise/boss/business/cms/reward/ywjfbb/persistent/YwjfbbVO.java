package com.sunrise.boss.business.cms.reward.ywjfbb.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class YwjfbbVO implements Serializable {

    /** identifier field */
    private String wayid;

    /** nullable persistent field */
    private String countycompid;

    /** nullable persistent field */
    private String wayname;

    /** nullable persistent field */
    private String chainhead;

    /** nullable persistent field */
    private String countycompname;

    /** nullable persistent field */
    private Short starlevel;

    /** nullable persistent field */
    private String calcmonth;

    /** nullable persistent field */
    private Double dzzd;

    /** nullable persistent field */
    private Double sr;

    /** nullable persistent field */
    private Double fsr;

    /** nullable persistent field */
    private Double czjf;

    /** nullable persistent field */
    private Double yckb;

    /** nullable persistent field */
    private Double jtdh;

    /** nullable persistent field */
    private Double dhjq;

    /** nullable persistent field */
    private Double lxw;

    /** nullable persistent field */
    private Double ajh;
    
    private String flag;
    
    private Double busivalue;
    
    private String cityid;
   
    public String getCityid() {
		return cityid;
	}

	public void setCityid(String cityid) {
		this.cityid = cityid;
	}

	public Double getBusivalue() {
		return busivalue;
	}

	public void setBusivalue(Double busivalue) {
		this.busivalue = busivalue;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	/** full constructor */
    public YwjfbbVO(java.lang.String wayid, java.lang.String countycompid, java.lang.String wayname, java.lang.String chainhead, java.lang.String countycompname, java.lang.Short starlevel, java.lang.String calcmonth, java.lang.Double dzzd, java.lang.Double sr, java.lang.Double fsr, java.lang.Double czjf, java.lang.Double yckb, java.lang.Double jtdh, java.lang.Double dhjq, java.lang.Double lxw, java.lang.Double ajh) {
        this.wayid = wayid;
        this.countycompid = countycompid;
        this.wayname = wayname;
        this.chainhead = chainhead;
        this.countycompname = countycompname;
        this.starlevel = starlevel;
        this.calcmonth = calcmonth;
        this.dzzd = dzzd;
        this.sr = sr;
        this.fsr = fsr;
        this.czjf = czjf;
        this.yckb = yckb;
        this.jtdh = jtdh;
        this.dhjq = dhjq;
        this.lxw = lxw;
        this.ajh = ajh;
    }

    /** default constructor */
    public YwjfbbVO() {
    }

    /** minimal constructor */
    public YwjfbbVO(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public String getCountycompid() {
		return countycompid;
	}

	public void setCountycompid(String countycompid) {
		this.countycompid = countycompid;
	}

	public java.lang.String getWayname() {
        return this.wayname;
    }

    public void setWayname(java.lang.String wayname) {
        this.wayname = wayname;
    }

    public java.lang.String getChainhead() {
        return this.chainhead;
    }

    public void setChainhead(java.lang.String chainhead) {
        this.chainhead = chainhead;
    }

    public java.lang.String getCountycompname() {
        return this.countycompname;
    }

    public void setCountycompname(java.lang.String countycompname) {
        this.countycompname = countycompname;
    }

    public java.lang.Short getStarlevel() {
        return this.starlevel;
    }

    public void setStarlevel(java.lang.Short starlevel) {
        this.starlevel = starlevel;
    }

    public java.lang.String getCalcmonth() {
        return this.calcmonth;
    }

    public void setCalcmonth(java.lang.String calcmonth) {
        this.calcmonth = calcmonth;
    }

    public java.lang.Double getDzzd() {
        return this.dzzd;
    }

    public void setDzzd(java.lang.Double dzzd) {
        this.dzzd = dzzd;
    }

    public java.lang.Double getSr() {
        return this.sr;
    }

    public void setSr(java.lang.Double sr) {
        this.sr = sr;
    }

    public java.lang.Double getFsr() {
        return this.fsr;
    }

    public void setFsr(java.lang.Double fsr) {
        this.fsr = fsr;
    }

    public java.lang.Double getCzjf() {
        return this.czjf;
    }

    public void setCzjf(java.lang.Double czjf) {
        this.czjf = czjf;
    }

    public java.lang.Double getYckb() {
        return this.yckb;
    }

    public void setYckb(java.lang.Double yckb) {
        this.yckb = yckb;
    }

    public java.lang.Double getJtdh() {
        return this.jtdh;
    }

    public void setJtdh(java.lang.Double jtdh) {
        this.jtdh = jtdh;
    }

    public java.lang.Double getDhjq() {
        return this.dhjq;
    }

    public void setDhjq(java.lang.Double dhjq) {
        this.dhjq = dhjq;
    }

    public java.lang.Double getLxw() {
        return this.lxw;
    }

    public void setLxw(java.lang.Double lxw) {
        this.lxw = lxw;
    }

    public java.lang.Double getAjh() {
        return this.ajh;
    }

    public void setAjh(java.lang.Double ajh) {
        this.ajh = ajh;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("wayid", getWayid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof YwjfbbVO) ) return false;
        YwjfbbVO castOther = (YwjfbbVO) other;
        return new EqualsBuilder()
            .append(this.getWayid(), castOther.getWayid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getWayid())
            .toHashCode();
    }

}
