package com.gmcc.pboss.business.resource.compack;

import com.gmcc.pboss.business.resource.compacklog.CompacklogVO;
import com.sunrise.jop.infrastructure.db.BaseVO;
import com.sunrise.jop.infrastructure.sysadmin.BusinessLog;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class CompackVO extends BaseVO implements Serializable ,BusinessLog {

    /** identifier field */
    private String batchno;

    /** identifier field */
    private String boxnum;

    /** nullable persistent field */
    private Short amount;

    /** nullable persistent field */
    private String comcategory;

    /** nullable persistent field */
    private String packstate;

    /** nullable persistent field */
    private String resuse;

    /** nullable persistent field */
    private String storarea;

    /** nullable persistent field */
    private String nosect;

    /** nullable persistent field */
    private String wayid;

    /** nullable persistent field */
    private String discomcode;

    /** nullable persistent field */
    private java.util.Date packtime;

    /** full constructor */
    public CompackVO(java.lang.String batchno, java.lang.String boxnum, java.lang.Short amount, java.lang.String comcategory, java.lang.String packstate, java.lang.String resuse, java.lang.String storarea, java.lang.String nosect, java.lang.String wayid, java.lang.String discomcode, java.util.Date packtime) {
        this.batchno = batchno;
        this.boxnum = boxnum;
        this.amount = amount;
        this.comcategory = comcategory;
        this.packstate = packstate;
        this.resuse = resuse;
        this.storarea = storarea;
        this.nosect = nosect;
        this.wayid = wayid;
        this.discomcode = discomcode;
        this.packtime = packtime;
    }

    /** default constructor */
    public CompackVO() {
    }

    /** minimal constructor */
    public CompackVO(java.lang.String batchno, java.lang.String boxnum) {
        this.batchno = batchno;
        this.boxnum = boxnum;
    }

    public java.lang.String getBatchno() {
        return this.batchno;
    }

    public void setBatchno(java.lang.String batchno) {
        this.batchno = batchno;
    }

    public java.lang.String getBoxnum() {
        return this.boxnum;
    }

    public void setBoxnum(java.lang.String boxnum) {
        this.boxnum = boxnum;
    }

    public java.lang.Short getAmount() {
        return this.amount;
    }

    public void setAmount(java.lang.Short amount) {
        this.amount = amount;
    }

    public java.lang.String getComcategory() {
        return this.comcategory;
    }

    public void setComcategory(java.lang.String comcategory) {
        this.comcategory = comcategory;
    }

    public java.lang.String getPackstate() {
        return this.packstate;
    }

    public void setPackstate(java.lang.String packstate) {
        this.packstate = packstate;
    }

    public java.lang.String getResuse() {
        return this.resuse;
    }

    public void setResuse(java.lang.String resuse) {
        this.resuse = resuse;
    }

    public java.lang.String getStorarea() {
        return this.storarea;
    }

    public void setStorarea(java.lang.String storarea) {
        this.storarea = storarea;
    }

    public java.lang.String getNosect() {
        return this.nosect;
    }

    public void setNosect(java.lang.String nosect) {
        this.nosect = nosect;
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.String getDiscomcode() {
        return this.discomcode;
    }

    public void setDiscomcode(java.lang.String discomcode) {
        this.discomcode = discomcode;
    }

    public java.util.Date getPacktime() {
        return this.packtime;
    }

    public void setPacktime(java.util.Date packtime) {
        this.packtime = packtime;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("batchno", getBatchno())
            .append("boxnum", getBoxnum())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CompackVO) ) return false;
        CompackVO castOther = (CompackVO) other;
        return new EqualsBuilder()
            .append(this.getBatchno(), castOther.getBatchno())
            .append(this.getBoxnum(), castOther.getBoxnum())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getBatchno())
            .append(getBoxnum())
            .toHashCode();
    }

	public Class logVOClass() {
		// TODO Auto-generated method stub
		return CompacklogVO.class;
	}

}
