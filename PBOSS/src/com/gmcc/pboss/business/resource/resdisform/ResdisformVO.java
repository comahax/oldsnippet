package com.gmcc.pboss.business.resource.resdisform;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class ResdisformVO extends BaseVO implements Serializable {

    /** identifier field */
    private String discomcode;

    /** identifier field */
    private String disid;

    /** nullable persistent field */
    private Long resamt;

    /** nullable persistent field */
    private String storarea;

    /** nullable persistent field */
    private String discode;

    /** nullable persistent field */
    private java.util.Date distime;

    /** nullable persistent field */
    private String signcode;

    /** nullable persistent field */
    private java.util.Date signtime;

    /** nullable persistent field */
    private String issuecode;

    /** nullable persistent field */
    private java.util.Date issutime;


    /** nullable persistent field */
    private String smscontent;


    /** nullable persistent field */
    private String disformstate;

    /** nullable persistent field */
    private String statinfo;

    /** full constructor */
    public ResdisformVO(java.lang.String discomcode, java.lang.String disid, java.lang.Long resamt, java.lang.String storarea, java.lang.String discode, java.util.Date distime, java.lang.String signcode, java.util.Date signtime, java.lang.String issuecode, java.util.Date issutime, java.lang.String smscontent, java.lang.String disformstate, java.lang.String statinfo) {
        this.discomcode = discomcode;
        this.disid = disid;
        this.resamt = resamt;
        this.storarea = storarea;
        this.discode = discode;
        this.distime = distime;
        this.signcode = signcode;
        this.signtime = signtime;
        this.issuecode = issuecode;
        this.issutime = issutime;
        this.smscontent = smscontent;
        this.disformstate = disformstate;
        this.statinfo = statinfo;
    }

    /** default constructor */
    public ResdisformVO() {
    }

    /** minimal constructor */
    public ResdisformVO(java.lang.String discomcode, java.lang.String disid) {
        this.discomcode = discomcode;
        this.disid = disid;
    }

    public java.lang.String getDiscomcode() {
        return this.discomcode;
    }

    public void setDiscomcode(java.lang.String discomcode) {
        this.discomcode = discomcode;
    }

    public java.lang.String getDisid() {
        return this.disid;
    }

    public void setDisid(java.lang.String disid) {
        this.disid = disid;
    }

    public java.lang.Long getResamt() {
        return this.resamt;
    }

    public void setResamt(java.lang.Long resamt) {
        this.resamt = resamt;
    }

    public java.lang.String getStorarea() {
        return this.storarea;
    }

    public void setStorarea(java.lang.String storarea) {
        this.storarea = storarea;
    }

    public java.lang.String getDiscode() {
        return this.discode;
    }

    public void setDiscode(java.lang.String discode) {
        this.discode = discode;
    }

    public java.util.Date getDistime() {
        return this.distime;
    }

    public void setDistime(java.util.Date distime) {
        this.distime = distime;
    }

    public java.lang.String getSigncode() {
        return this.signcode;
    }

    public void setSigncode(java.lang.String signcode) {
        this.signcode = signcode;
    }

    public java.util.Date getSigntime() {
        return this.signtime;
    }

    public void setSigntime(java.util.Date signtime) {
        this.signtime = signtime;
    }

    public java.lang.String getIssuecode() {
        return this.issuecode;
    }

    public void setIssuecode(java.lang.String issuecode) {
        this.issuecode = issuecode;
    }

    public java.util.Date getIssutime() {
        return this.issutime;
    }

    public void setIssutime(java.util.Date issutime) {
        this.issutime = issutime;
    }


    public java.lang.String getSmscontent() {
        return this.smscontent;
    }

    public void setSmscontent(java.lang.String smscontent) {
        this.smscontent = smscontent;
    }


    public java.lang.String getDisformstate() {
        return this.disformstate;
    }

    public void setDisformstate(java.lang.String disformstate) {
        this.disformstate = disformstate;
    }

    public java.lang.String getStatinfo() {
        return this.statinfo;
    }

    public void setStatinfo(java.lang.String statinfo) {
        this.statinfo = statinfo;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("discomcode", getDiscomcode())
            .append("disid", getDisid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ResdisformVO) ) return false;
        ResdisformVO castOther = (ResdisformVO) other;
        return new EqualsBuilder()
            .append(this.getDiscomcode(), castOther.getDiscomcode())
            .append(this.getDisid(), castOther.getDisid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getDiscomcode())
            .append(getDisid())
            .toHashCode();
    }

}
