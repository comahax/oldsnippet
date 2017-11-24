package com.gmcc.pboss.business.resource.com;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class ComVO extends BaseVO implements Serializable {

    /** identifier field */
    private Long comid;

    /** persistent field */
    private Long comprice;

    /** persistent field */
    private Integer comclassid;

    /** persistent field */
    private Integer comtype;

    /** nullable persistent field */
    private java.util.Date comfreeze;

    /** nullable persistent field */
    private Integer comkeep;

    /** nullable persistent field */
    private java.util.Date comvalid;

    /** nullable persistent field */
    private String comname;

    /** nullable persistent field */
    private String comsource;

    /** nullable persistent field */
    private String colordes;

    /** nullable persistent field */
    private String accessory;

    /** nullable persistent field */
    private String presentdes;

    /** nullable persistent field */
    private Short active;

    /** nullable persistent field */
    private Short comlength;

    /** nullable persistent field */
    private String item;

    /** nullable persistent field */
    private String cityid;

    /** nullable persistent field */
    private String comcode;

    /** nullable persistent field */
    private Integer comstate;

    /** full constructor */
    public ComVO(java.lang.Long comid, java.lang.Long comprice, java.lang.Integer comclassid, java.lang.Integer comtype, java.util.Date comfreeze, java.lang.Integer comkeep, java.util.Date comvalid, java.lang.String comname, java.lang.String comsource, java.lang.String colordes, java.lang.String accessory, java.lang.String presentdes, java.lang.Short active, java.lang.Short comlength, java.lang.String item, java.lang.String cityid, java.lang.String comcode, java.lang.Integer comstate) {
        this.comid = comid;
        this.comprice = comprice;
        this.comclassid = comclassid;
        this.comtype = comtype;
        this.comfreeze = comfreeze;
        this.comkeep = comkeep;
        this.comvalid = comvalid;
        this.comname = comname;
        this.comsource = comsource;
        this.colordes = colordes;
        this.accessory = accessory;
        this.presentdes = presentdes;
        this.active = active;
        this.comlength = comlength;
        this.item = item;
        this.cityid = cityid;
        this.comcode = comcode;
        this.comstate = comstate;
    }

    /** default constructor */
    public ComVO() {
    }

    /** minimal constructor */
    public ComVO(java.lang.Long comid, java.lang.Long comprice, java.lang.Integer comclassid, java.lang.Integer comtype) {
        this.comid = comid;
        this.comprice = comprice;
        this.comclassid = comclassid;
        this.comtype = comtype;
    }

    public java.lang.Long getComid() {
        return this.comid;
    }

    public void setComid(java.lang.Long comid) {
        this.comid = comid;
    }

    public java.lang.Long getComprice() {
        return this.comprice;
    }

    public void setComprice(java.lang.Long comprice) {
        this.comprice = comprice;
    }

    public java.lang.Integer getComclassid() {
        return this.comclassid;
    }

    public void setComclassid(java.lang.Integer comclassid) {
        this.comclassid = comclassid;
    }

    public java.lang.Integer getComtype() {
        return this.comtype;
    }

    public void setComtype(java.lang.Integer comtype) {
        this.comtype = comtype;
    }

    public java.util.Date getComfreeze() {
        return this.comfreeze;
    }

    public void setComfreeze(java.util.Date comfreeze) {
        this.comfreeze = comfreeze;
    }

    public java.lang.Integer getComkeep() {
        return this.comkeep;
    }

    public void setComkeep(java.lang.Integer comkeep) {
        this.comkeep = comkeep;
    }

    public java.util.Date getComvalid() {
        return this.comvalid;
    }

    public void setComvalid(java.util.Date comvalid) {
        this.comvalid = comvalid;
    }

    public java.lang.String getComname() {
        return this.comname;
    }

    public void setComname(java.lang.String comname) {
        this.comname = comname;
    }

    public java.lang.String getComsource() {
        return this.comsource;
    }

    public void setComsource(java.lang.String comsource) {
        this.comsource = comsource;
    }

    public java.lang.String getColordes() {
        return this.colordes;
    }

    public void setColordes(java.lang.String colordes) {
        this.colordes = colordes;
    }

    public java.lang.String getAccessory() {
        return this.accessory;
    }

    public void setAccessory(java.lang.String accessory) {
        this.accessory = accessory;
    }

    public java.lang.String getPresentdes() {
        return this.presentdes;
    }

    public void setPresentdes(java.lang.String presentdes) {
        this.presentdes = presentdes;
    }

    public java.lang.Short getActive() {
        return this.active;
    }

    public void setActive(java.lang.Short active) {
        this.active = active;
    }

    public java.lang.Short getComlength() {
        return this.comlength;
    }

    public void setComlength(java.lang.Short comlength) {
        this.comlength = comlength;
    }

    public java.lang.String getItem() {
        return this.item;
    }

    public void setItem(java.lang.String item) {
        this.item = item;
    }

    public java.lang.String getCityid() {
        return this.cityid;
    }

    public void setCityid(java.lang.String cityid) {
        this.cityid = cityid;
    }

    public java.lang.String getComcode() {
        return this.comcode;
    }

    public void setComcode(java.lang.String comcode) {
        this.comcode = comcode;
    }

    public java.lang.Integer getComstate() {
        return this.comstate;
    }

    public void setComstate(java.lang.Integer comstate) {
        this.comstate = comstate;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("comid", getComid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ComVO) ) return false;
        ComVO castOther = (ComVO) other;
        return new EqualsBuilder()
            .append(this.getComid(), castOther.getComid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getComid())
            .toHashCode();
    }

}
