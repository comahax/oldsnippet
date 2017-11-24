package com.gmcc.pboss.business.cms.examine.exmnstddetail.persistent;


import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class ExmnstddetailVO extends BaseVO implements Serializable {

    /** identifier field */
    private Integer exmnid;

    /** identifier field */
    private String exmnperiod;

    /** identifier field */
    private Integer exmnstdid;

    /** identifier field */
    private String wayid;

    /** nullable persistent field */
    private String exmnname;

    /** nullable persistent field */
    private String exmnstdname;

    /** nullable persistent field */
    private Double exmnmark;

    /** full constructor */
    public ExmnstddetailVO(java.lang.Integer exmnid, java.lang.String exmnperiod, java.lang.Integer exmnstdid, java.lang.String wayid, java.lang.String exmnname, java.lang.String exmnstdname, java.lang.Double exmnmark) {
        this.exmnid = exmnid;
        this.exmnperiod = exmnperiod;
        this.exmnstdid = exmnstdid;
        this.wayid = wayid;
        this.exmnname = exmnname;
        this.exmnstdname = exmnstdname;
        this.exmnmark = exmnmark;
    }

    /** default constructor */
    public ExmnstddetailVO() {
    }

    /** minimal constructor */
    public ExmnstddetailVO(java.lang.Integer exmnid, java.lang.String exmnperiod, java.lang.Integer exmnstdid, java.lang.String wayid) {
        this.exmnid = exmnid;
        this.exmnperiod = exmnperiod;
        this.exmnstdid = exmnstdid;
        this.wayid = wayid;
    }

    public java.lang.Integer getExmnid() {
        return this.exmnid;
    }

    public void setExmnid(java.lang.Integer exmnid) {
        this.exmnid = exmnid;
    }

    public java.lang.String getExmnperiod() {
        return this.exmnperiod;
    }

    public void setExmnperiod(java.lang.String exmnperiod) {
        this.exmnperiod = exmnperiod;
    }

    public java.lang.Integer getExmnstdid() {
        return this.exmnstdid;
    }

    public void setExmnstdid(java.lang.Integer exmnstdid) {
        this.exmnstdid = exmnstdid;
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.String getExmnname() {
        return this.exmnname;
    }

    public void setExmnname(java.lang.String exmnname) {
        this.exmnname = exmnname;
    }

    public java.lang.String getExmnstdname() {
        return this.exmnstdname;
    }

    public void setExmnstdname(java.lang.String exmnstdname) {
        this.exmnstdname = exmnstdname;
    }

    public java.lang.Double getExmnmark() {
        return this.exmnmark;
    }

    public void setExmnmark(java.lang.Double exmnmark) {
        this.exmnmark = exmnmark;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("exmnid", getExmnid())
            .append("exmnperiod", getExmnperiod())
            .append("exmnstdid", getExmnstdid())
            .append("wayid", getWayid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ExmnstddetailVO) ) return false;
        ExmnstddetailVO castOther = (ExmnstddetailVO) other;
        return new EqualsBuilder()
            .append(this.getExmnid(), castOther.getExmnid())
            .append(this.getExmnperiod(), castOther.getExmnperiod())
            .append(this.getExmnstdid(), castOther.getExmnstdid())
            .append(this.getWayid(), castOther.getWayid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getExmnid())
            .append(getExmnperiod())
            .append(getExmnstdid())
            .append(getWayid())
            .toHashCode();
    }

}
