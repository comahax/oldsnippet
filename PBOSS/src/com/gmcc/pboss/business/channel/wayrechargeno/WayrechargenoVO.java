package com.gmcc.pboss.business.channel.wayrechargeno;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class WayrechargenoVO extends BaseVO implements Serializable {

    /** identifier field */
    private Long seq;

    /** nullable persistent field */
    private String wayid;

    /** nullable persistent field */
    private Short cityid;

    /** nullable persistent field */
    private String mobile;

    /** nullable persistent field */
    private String opercode;

    /** nullable persistent field */
    private String opertype;

    /** nullable persistent field */
    private java.util.Date opertime;

    /** full constructor */
    public WayrechargenoVO(java.lang.String wayid, java.lang.Short cityid, java.lang.String mobile, java.lang.String opercode, java.lang.String opertype, java.util.Date opertime) {
        this.wayid = wayid;
        this.cityid = cityid;
        this.mobile = mobile;
        this.opercode = opercode;
        this.opertype = opertype;
        this.opertime = opertime;
    }

    /** default constructor */
    public WayrechargenoVO() {
    }

    public java.lang.Long getSeq() {
        return this.seq;
    }

    public void setSeq(java.lang.Long seq) {
        this.seq = seq;
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.Short getCityid() {
        return this.cityid;
    }

    public void setCityid(java.lang.Short cityid) {
        this.cityid = cityid;
    }

    public java.lang.String getMobile() {
        return this.mobile;
    }

    public void setMobile(java.lang.String mobile) {
        this.mobile = mobile;
    }

    public java.lang.String getOpercode() {
        return this.opercode;
    }

    public void setOpercode(java.lang.String opercode) {
        this.opercode = opercode;
    }

    public java.lang.String getOpertype() {
        return this.opertype;
    }

    public void setOpertype(java.lang.String opertype) {
        this.opertype = opertype;
    }

    public java.util.Date getOpertime() {
        return this.opertime;
    }

    public void setOpertime(java.util.Date opertime) {
        this.opertime = opertime;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("seq", getSeq())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof WayrechargenoVO) ) return false;
        WayrechargenoVO castOther = (WayrechargenoVO) other;
        return new EqualsBuilder()
            .append(this.getSeq(), castOther.getSeq())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getSeq())
            .toHashCode();
    }

}
