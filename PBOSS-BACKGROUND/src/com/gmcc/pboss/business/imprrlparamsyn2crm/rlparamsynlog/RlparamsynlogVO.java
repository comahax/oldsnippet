package com.gmcc.pboss.business.imprrlparamsyn2crm.rlparamsynlog;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class RlparamsynlogVO extends BaseVO implements Serializable {

	private Long logid;
	
    /** identifier field */
    private Long itemid;

    /** persistent field */
    private String oprtype;

    /** persistent field */
    private java.util.Date oprtime;

    /** persistent field */
    private Short opract;

    /** nullable persistent field */
    private Long id;

    /** nullable persistent field */
    private String cityid;

    /** nullable persistent field */
    private String restype;

    /** nullable persistent field */
    private String receiveway;

    /** nullable persistent field */
    private Short synstate;

    /** nullable persistent field */
    private String synmemo;

    /** full constructor */
    public RlparamsynlogVO(java.lang.Long itemid, java.lang.String oprtype, java.util.Date oprtime, java.lang.Short opract, java.lang.Long id, java.lang.String cityid, java.lang.String restype, java.lang.String receiveway, java.lang.Short synstate, java.lang.String synmemo) {
        this.itemid = itemid;
        this.oprtype = oprtype;
        this.oprtime = oprtime;
        this.opract = opract;
        this.id = id;
        this.cityid = cityid;
        this.restype = restype;
        this.receiveway = receiveway;
        this.synstate = synstate;
        this.synmemo = synmemo;
    }

    /** default constructor */
    public RlparamsynlogVO() {
    }

    /** minimal constructor */
    public RlparamsynlogVO(java.lang.Long itemid, java.lang.String oprtype, java.util.Date oprtime, java.lang.Short opract) {
        this.itemid = itemid;
        this.oprtype = oprtype;
        this.oprtime = oprtime;
        this.opract = opract;
    }

    public java.lang.Long getItemid() {
        return this.itemid;
    }

    public void setItemid(java.lang.Long itemid) {
        this.itemid = itemid;
    }

    public java.lang.String getOprtype() {
        return this.oprtype;
    }

    public void setOprtype(java.lang.String oprtype) {
        this.oprtype = oprtype;
    }

    public java.util.Date getOprtime() {
        return this.oprtime;
    }

    public void setOprtime(java.util.Date oprtime) {
        this.oprtime = oprtime;
    }

    public java.lang.Short getOpract() {
        return this.opract;
    }

    public void setOpract(java.lang.Short opract) {
        this.opract = opract;
    }

    public java.lang.Long getId() {
        return this.id;
    }

    public void setId(java.lang.Long id) {
        this.id = id;
    }

    public java.lang.String getCityid() {
        return this.cityid;
    }

    public void setCityid(java.lang.String cityid) {
        this.cityid = cityid;
    }

    public java.lang.String getRestype() {
        return this.restype;
    }

    public void setRestype(java.lang.String restype) {
        this.restype = restype;
    }

    public java.lang.String getReceiveway() {
        return this.receiveway;
    }

    public void setReceiveway(java.lang.String receiveway) {
        this.receiveway = receiveway;
    }

    public java.lang.Short getSynstate() {
        return this.synstate;
    }

    public void setSynstate(java.lang.Short synstate) {
        this.synstate = synstate;
    }

    public java.lang.String getSynmemo() {
        return this.synmemo;
    }

    public void setSynmemo(java.lang.String synmemo) {
        this.synmemo = synmemo;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("itemid", getItemid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof RlparamsynlogVO) ) return false;
        RlparamsynlogVO castOther = (RlparamsynlogVO) other;
        return new EqualsBuilder()
            .append(this.getItemid(), castOther.getItemid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getItemid())
            .toHashCode();
    }

	public Long getLogid() {
		return logid;
	}

	public void setLogid(Long logid) {
		this.logid = logid;
	}

}
