package com.gmcc.pboss.business.base.rightitem;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class RightitemVO extends BaseVO implements Serializable {

    /** identifier field */
    private String rightid;

    /** nullable persistent field */
    private Integer region;

    /** nullable persistent field */
    private String rightname;

    /** nullable persistent field */
    private String rightgroup;

    /** nullable persistent field */
    private Byte ispublic;

    /** nullable persistent field */
    private String notes;

    /** nullable persistent field */
    private String orgid;

    /** nullable persistent field */
    private String operid;

    /** nullable persistent field */
    private java.util.Date createdate;

    /** nullable persistent field */
    private Byte status;

    /** nullable persistent field */
    private java.util.Date statusdate;

    /** full constructor */
    public RightitemVO(java.lang.String rightid, java.lang.Integer region, java.lang.String rightname, java.lang.String rightgroup, java.lang.Byte ispublic, java.lang.String notes, java.lang.String orgid, java.lang.String operid, java.util.Date createdate, java.lang.Byte status, java.util.Date statusdate) {
        this.rightid = rightid;
        this.region = region;
        this.rightname = rightname;
        this.rightgroup = rightgroup;
        this.ispublic = ispublic;
        this.notes = notes;
        this.orgid = orgid;
        this.operid = operid;
        this.createdate = createdate;
        this.status = status;
        this.statusdate = statusdate;
    }

    /** default constructor */
    public RightitemVO() {
    }

    /** minimal constructor */
    public RightitemVO(java.lang.String rightid) {
        this.rightid = rightid;
    }

    public java.lang.String getRightid() {
        return this.rightid;
    }

    public void setRightid(java.lang.String rightid) {
        this.rightid = rightid;
    }

    public java.lang.Integer getRegion() {
        return this.region;
    }

    public void setRegion(java.lang.Integer region) {
        this.region = region;
    }

    public java.lang.String getRightname() {
        return this.rightname;
    }

    public void setRightname(java.lang.String rightname) {
        this.rightname = rightname;
    }

    public java.lang.String getRightgroup() {
        return this.rightgroup;
    }

    public void setRightgroup(java.lang.String rightgroup) {
        this.rightgroup = rightgroup;
    }

    public java.lang.Byte getIspublic() {
        return this.ispublic;
    }

    public void setIspublic(java.lang.Byte ispublic) {
        this.ispublic = ispublic;
    }

    public java.lang.String getNotes() {
        return this.notes;
    }

    public void setNotes(java.lang.String notes) {
        this.notes = notes;
    }

    public java.lang.String getOrgid() {
        return this.orgid;
    }

    public void setOrgid(java.lang.String orgid) {
        this.orgid = orgid;
    }

    public java.lang.String getOperid() {
        return this.operid;
    }

    public void setOperid(java.lang.String operid) {
        this.operid = operid;
    }

    public java.util.Date getCreatedate() {
        return this.createdate;
    }

    public void setCreatedate(java.util.Date createdate) {
        this.createdate = createdate;
    }

    public java.lang.Byte getStatus() {
        return this.status;
    }

    public void setStatus(java.lang.Byte status) {
        this.status = status;
    }

    public java.util.Date getStatusdate() {
        return this.statusdate;
    }

    public void setStatusdate(java.util.Date statusdate) {
        this.statusdate = statusdate;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("rightid", getRightid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof RightitemVO) ) return false;
        RightitemVO castOther = (RightitemVO) other;
        return new EqualsBuilder()
            .append(this.getRightid(), castOther.getRightid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getRightid())
            .toHashCode();
    }

}
