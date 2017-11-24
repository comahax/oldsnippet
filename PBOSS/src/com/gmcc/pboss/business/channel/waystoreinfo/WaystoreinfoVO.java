package com.gmcc.pboss.business.channel.waystoreinfo;

import com.gmcc.pboss.business.channel.waystoreinfolog.WaystoreinfologVO;
import com.sunrise.jop.infrastructure.db.BaseVO;
import com.sunrise.jop.infrastructure.sysadmin.BusinessLog;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class WaystoreinfoVO extends BaseVO   implements Serializable,BusinessLog {

    /** identifier field */
    private String wayid;

    /** nullable persistent field */
    private Double area;

    /** nullable persistent field */
    private String cityid;

    /** nullable persistent field */
    private Short zqtype;

    /** nullable persistent field */
    private String zqpic;

    /** nullable persistent field */
    private Double zqarea;

    /** nullable persistent field */
    private Short zqpanel;

    /** nullable persistent field */
    private Short zqcupboard;

    /** nullable persistent field */
    private Short zqcards;

    /** nullable persistent field */
    private Short zqpricetag;

    /** nullable persistent field */
    private Short zqrack;

    /** nullable persistent field */
    private Short zqinad;

    /** nullable persistent field */
    private Short zqoutad;

    /** nullable persistent field */
    private Short zqhead;

    /** nullable persistent field */
    private Short zqpaste;

    /** nullable persistent field */
    private Short zqtablecard;

    /** nullable persistent field */
    private Short zqdecca;

    /** nullable persistent field */
    private Short zqbill;

    /** nullable persistent field */
    private String doorpic;

    /** nullable persistent field */
    private Short doortype;

    /** nullable persistent field */
    private Double outwallad;

    /** nullable persistent field */
    private Short outwallpic;

    /** nullable persistent field */
    private Short tdmonopoly;

    /** nullable persistent field */
    private Short busimonopoly;

    /** nullable persistent field */
    private Short storeconduct;

    /** nullable persistent field */
    private Float modulus;

 

    /** nullable persistent field */
    private java.util.Date createtime;

    /** nullable persistent field */
    private String zqpicpath;
    /** nullable persistent field */
    private String doorpicpath;
    /** full constructor */
    public WaystoreinfoVO(java.lang.String wayid, java.lang.Double area, java.lang.String cityid, java.lang.Short zqtype, java.lang.String zqpic, java.lang.Double zqarea, java.lang.Short zqpanel, java.lang.Short zqcupboard, java.lang.Short zqcards, java.lang.Short zqpricetag, java.lang.Short zqrack, java.lang.Short zqinad, java.lang.Short zqoutad, java.lang.Short zqhead, java.lang.Short zqpaste, java.lang.Short zqtablecard, java.lang.Short zqdecca, java.lang.Short zqbill, java.lang.String doorpic, java.lang.Short doortype, java.lang.Double outwallad, java.lang.Short outwallpic, java.lang.Short tdmonopoly, java.lang.Short busimonopoly, java.lang.Short storeconduct, java.lang.Float modulus,  java.util.Date createtime, java.lang.String zqpicpath, java.lang.String doorpicpath) {
        this.wayid = wayid;
        this.area = area;
        this.cityid = cityid;
        this.zqtype = zqtype;
        this.zqpic = zqpic;
        this.zqarea = zqarea;
        this.zqpanel = zqpanel;
        this.zqcupboard = zqcupboard;
        this.zqcards = zqcards;
        this.zqpricetag = zqpricetag;
        this.zqrack = zqrack;
        this.zqinad = zqinad;
        this.zqoutad = zqoutad;
        this.zqhead = zqhead;
        this.zqpaste = zqpaste;
        this.zqtablecard = zqtablecard;
        this.zqdecca = zqdecca;
        this.zqbill = zqbill;
        this.doorpic = doorpic;
        this.doortype = doortype;
        this.outwallad = outwallad;
        this.outwallpic = outwallpic;
        this.tdmonopoly = tdmonopoly;
        this.busimonopoly = busimonopoly;
        this.storeconduct = storeconduct;
        this.modulus = modulus; 
        this.createtime = createtime;
        this.zqpicpath = zqpicpath; 
        this.doorpicpath = doorpicpath;
    }

    /** default constructor */
    public WaystoreinfoVO() {
    }

    /** minimal constructor */
    public WaystoreinfoVO(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.Double getArea() {
        return this.area;
    }

    public void setArea(java.lang.Double area) {
        this.area = area;
    }

    public java.lang.String getCityid() {
        return this.cityid;
    }

    public void setCityid(java.lang.String cityid) {
        this.cityid = cityid;
    }

    public java.lang.Short getZqtype() {
        return this.zqtype;
    }

    public void setZqtype(java.lang.Short zqtype) {
        this.zqtype = zqtype;
    }

    public java.lang.String getZqpic() {
        return this.zqpic;
    }

    public void setZqpic(java.lang.String zqpic) {
        this.zqpic = zqpic;
    }

    public java.lang.Double getZqarea() {
        return this.zqarea;
    }

    public void setZqarea(java.lang.Double zqarea) {
        this.zqarea = zqarea;
    }

    public java.lang.Short getZqpanel() {
        return this.zqpanel;
    }

    public void setZqpanel(java.lang.Short zqpanel) {
        this.zqpanel = zqpanel;
    }

    public java.lang.Short getZqcupboard() {
        return this.zqcupboard;
    }

    public void setZqcupboard(java.lang.Short zqcupboard) {
        this.zqcupboard = zqcupboard;
    }

    public java.lang.Short getZqcards() {
        return this.zqcards;
    }

    public void setZqcards(java.lang.Short zqcards) {
        this.zqcards = zqcards;
    }

    public java.lang.Short getZqpricetag() {
        return this.zqpricetag;
    }

    public void setZqpricetag(java.lang.Short zqpricetag) {
        this.zqpricetag = zqpricetag;
    }

    public java.lang.Short getZqrack() {
        return this.zqrack;
    }

    public void setZqrack(java.lang.Short zqrack) {
        this.zqrack = zqrack;
    }

    public java.lang.Short getZqinad() {
        return this.zqinad;
    }

    public void setZqinad(java.lang.Short zqinad) {
        this.zqinad = zqinad;
    }

    public java.lang.Short getZqoutad() {
        return this.zqoutad;
    }

    public void setZqoutad(java.lang.Short zqoutad) {
        this.zqoutad = zqoutad;
    }

    public java.lang.Short getZqhead() {
        return this.zqhead;
    }

    public void setZqhead(java.lang.Short zqhead) {
        this.zqhead = zqhead;
    }

    public java.lang.Short getZqpaste() {
        return this.zqpaste;
    }

    public void setZqpaste(java.lang.Short zqpaste) {
        this.zqpaste = zqpaste;
    }

    public java.lang.Short getZqtablecard() {
        return this.zqtablecard;
    }

    public void setZqtablecard(java.lang.Short zqtablecard) {
        this.zqtablecard = zqtablecard;
    }

    public java.lang.Short getZqdecca() {
        return this.zqdecca;
    }

    public void setZqdecca(java.lang.Short zqdecca) {
        this.zqdecca = zqdecca;
    }

    public java.lang.Short getZqbill() {
        return this.zqbill;
    }

    public void setZqbill(java.lang.Short zqbill) {
        this.zqbill = zqbill;
    }

    public java.lang.String getDoorpic() {
        return this.doorpic;
    }

    public void setDoorpic(java.lang.String doorpic) {
        this.doorpic = doorpic;
    }

    public java.lang.Short getDoortype() {
        return this.doortype;
    }

    public void setDoortype(java.lang.Short doortype) {
        this.doortype = doortype;
    }

    public java.lang.Double getOutwallad() {
        return this.outwallad;
    }

    public void setOutwallad(java.lang.Double outwallad) {
        this.outwallad = outwallad;
    }

    public java.lang.Short getOutwallpic() {
        return this.outwallpic;
    }

    public void setOutwallpic(java.lang.Short outwallpic) {
        this.outwallpic = outwallpic;
    }

    public java.lang.Short getTdmonopoly() {
        return this.tdmonopoly;
    }

    public void setTdmonopoly(java.lang.Short tdmonopoly) {
        this.tdmonopoly = tdmonopoly;
    }

    public java.lang.Short getBusimonopoly() {
        return this.busimonopoly;
    }

    public void setBusimonopoly(java.lang.Short busimonopoly) {
        this.busimonopoly = busimonopoly;
    }

    public java.lang.Short getStoreconduct() {
        return this.storeconduct;
    }

    public void setStoreconduct(java.lang.Short storeconduct) {
        this.storeconduct = storeconduct;
    }

    public java.lang.Float getModulus() {
        return this.modulus;
    }

    public void setModulus(java.lang.Float modulus) {
        this.modulus = modulus;
    } 

    public java.util.Date getCreatetime() {
        return this.createtime;
    }

    public void setCreatetime(java.util.Date createtime) {
        this.createtime = createtime;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("wayid", getWayid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof WaystoreinfoVO) ) return false;
        WaystoreinfoVO castOther = (WaystoreinfoVO) other;
        return new EqualsBuilder()
            .append(this.getWayid(), castOther.getWayid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getWayid())
            .toHashCode();
    }
	public Class logVOClass() {
		// TODO Auto-generated method stub    
		return WaystoreinfologVO.class;
	}

	public String getZqpicpath() {
		return zqpicpath;
	}

	public void setZqpicpath(String zqpicpath) {
		this.zqpicpath = zqpicpath;
	}

	public String getDoorpicpath() {
		return doorpicpath;
	}

	public void setDoorpicpath(String doorpicpath) {
		this.doorpicpath = doorpicpath;
	}

}
