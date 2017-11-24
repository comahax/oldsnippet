package com.gmcc.pboss.business.channel.adimarea;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class AdimareaVO extends BaseVO implements Serializable {

    /** identifier field */
    private String adacode;

    /** nullable persistent field */
    private String adaname;

    /** nullable persistent field */
    private Short adatype;

    /** nullable persistent field */
    private Short adalevel;

    /** nullable persistent field */
    private String uppercode;

    /** nullable persistent field */
    private String datayear;

    /** nullable persistent field */
    private Byte status;

    /** nullable persistent field */
    private Long totalppn;

    /** nullable persistent field */
    private Long resippn;

    /** nullable persistent field */
    private Long nonresippn;

    /** nullable persistent field */
    private Long adarea;

    /** nullable persistent field */
    private Long avgincome;

    /** nullable persistent field */
    private Long gmccusers;

    /** nullable persistent field */
    private Long cucusers;

    /** nullable persistent field */
    private Long ctcusers;

    /** nullable persistent field */
    private Long handphones;

    /** nullable persistent field */
    private String orgcode;

    /** nullable persistent field */
    private Short orgtype;

    /** full constructor */
    public AdimareaVO(java.lang.String adacode, java.lang.String adaname, java.lang.Short adatype, java.lang.Short adalevel, java.lang.String uppercode, java.lang.String datayear, java.lang.Byte status, java.lang.Long totalppn, java.lang.Long resippn, java.lang.Long nonresippn, java.lang.Long adarea, java.lang.Long avgincome, java.lang.Long gmccusers, java.lang.Long cucusers, java.lang.Long ctcusers, java.lang.Long handphones, java.lang.String orgcode, java.lang.Short orgtype) {
        this.adacode = adacode;
        this.adaname = adaname;
        this.adatype = adatype;
        this.adalevel = adalevel;
        this.uppercode = uppercode;
        this.datayear = datayear;
        this.status = status;
        this.totalppn = totalppn;
        this.resippn = resippn;
        this.nonresippn = nonresippn;
        this.adarea = adarea;
        this.avgincome = avgincome;
        this.gmccusers = gmccusers;
        this.cucusers = cucusers;
        this.ctcusers = ctcusers;
        this.handphones = handphones;
        this.orgcode = orgcode;
        this.orgtype = orgtype;
    }

    /** default constructor */
    public AdimareaVO() {
    }

    /** minimal constructor */
    public AdimareaVO(java.lang.String adacode) {
        this.adacode = adacode;
    }

    public java.lang.String getAdacode() {
        return this.adacode;
    }

    public void setAdacode(java.lang.String adacode) {
        this.adacode = adacode;
    }

    public java.lang.String getAdaname() {
        return this.adaname;
    }

    public void setAdaname(java.lang.String adaname) {
        this.adaname = adaname;
    }

    public java.lang.Short getAdatype() {
        return this.adatype;
    }

    public void setAdatype(java.lang.Short adatype) {
        this.adatype = adatype;
    }

    public java.lang.Short getAdalevel() {
        return this.adalevel;
    }

    public void setAdalevel(java.lang.Short adalevel) {
        this.adalevel = adalevel;
    }

    public java.lang.String getUppercode() {
        return this.uppercode;
    }

    public void setUppercode(java.lang.String uppercode) {
        this.uppercode = uppercode;
    }

    public java.lang.String getDatayear() {
        return this.datayear;
    }

    public void setDatayear(java.lang.String datayear) {
        this.datayear = datayear;
    }

    public java.lang.Byte getStatus() {
        return this.status;
    }

    public void setStatus(java.lang.Byte status) {
        this.status = status;
    }

    public java.lang.Long getTotalppn() {
        return this.totalppn;
    }

    public void setTotalppn(java.lang.Long totalppn) {
        this.totalppn = totalppn;
    }

    public java.lang.Long getResippn() {
        return this.resippn;
    }

    public void setResippn(java.lang.Long resippn) {
        this.resippn = resippn;
    }

    public java.lang.Long getNonresippn() {
        return this.nonresippn;
    }

    public void setNonresippn(java.lang.Long nonresippn) {
        this.nonresippn = nonresippn;
    }

    public java.lang.Long getAdarea() {
        return this.adarea;
    }

    public void setAdarea(java.lang.Long adarea) {
        this.adarea = adarea;
    }

    public java.lang.Long getAvgincome() {
        return this.avgincome;
    }

    public void setAvgincome(java.lang.Long avgincome) {
        this.avgincome = avgincome;
    }

    public java.lang.Long getGmccusers() {
        return this.gmccusers;
    }

    public void setGmccusers(java.lang.Long gmccusers) {
        this.gmccusers = gmccusers;
    }

    public java.lang.Long getCucusers() {
        return this.cucusers;
    }

    public void setCucusers(java.lang.Long cucusers) {
        this.cucusers = cucusers;
    }

    public java.lang.Long getCtcusers() {
        return this.ctcusers;
    }

    public void setCtcusers(java.lang.Long ctcusers) {
        this.ctcusers = ctcusers;
    }

    public java.lang.Long getHandphones() {
        return this.handphones;
    }

    public void setHandphones(java.lang.Long handphones) {
        this.handphones = handphones;
    }

    public java.lang.String getOrgcode() {
        return this.orgcode;
    }

    public void setOrgcode(java.lang.String orgcode) {
        this.orgcode = orgcode;
    }

    public java.lang.Short getOrgtype() {
        return this.orgtype;
    }

    public void setOrgtype(java.lang.Short orgtype) {
        this.orgtype = orgtype;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("adacode", getAdacode())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof AdimareaVO) ) return false;
        AdimareaVO castOther = (AdimareaVO) other;
        return new EqualsBuilder()
            .append(this.getAdacode(), castOther.getAdacode())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getAdacode())
            .toHashCode();
    }

}
