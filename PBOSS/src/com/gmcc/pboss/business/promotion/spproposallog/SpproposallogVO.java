package com.gmcc.pboss.business.promotion.spproposallog;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class SpproposallogVO extends BaseVO implements Serializable {

    /** identifier field */
    private Long logid;

    /** nullable persistent field */
    private java.util.Date optime;

    /** nullable persistent field */
    private String oprcode;

    /** nullable persistent field */
    private String oprtype;

    /** nullable persistent field */
    private String success;

    /** nullable persistent field */
    private Integer pid;

    /** nullable persistent field */
    private String pname;

    /** nullable persistent field */
    private String ptype;

    /** nullable persistent field */
    private java.util.Date pstarttime;

    /** nullable persistent field */
    private java.util.Date pendtime;

    /** nullable persistent field */
    private String pfrtmode;

    /** nullable persistent field */
    private String memo;

    /** full constructor */
    public SpproposallogVO(java.util.Date optime, java.lang.String oprcode, java.lang.String oprtype, java.lang.String success, java.lang.Integer pid, java.lang.String pname, java.lang.String ptype, java.util.Date pstarttime, java.util.Date pendtime, java.lang.String pfrtmode, java.lang.String memo) {
        this.optime = optime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
        this.success = success;
        this.pid = pid;
        this.pname = pname;
        this.ptype = ptype;
        this.pstarttime = pstarttime;
        this.pendtime = pendtime;
        this.pfrtmode = pfrtmode;
        this.memo = memo;
    }

    /** default constructor */
    public SpproposallogVO() {
    }

    public java.lang.Long getLogid() {
        return this.logid;
    }

    public void setLogid(java.lang.Long logid) {
        this.logid = logid;
    }

    public java.util.Date getOptime() {
        return this.optime;
    }

    public void setOptime(java.util.Date optime) {
        this.optime = optime;
    }

    public java.lang.String getOprcode() {
        return this.oprcode;
    }

    public void setOprcode(java.lang.String oprcode) {
        this.oprcode = oprcode;
    }

    public java.lang.String getOprtype() {
        return this.oprtype;
    }

    public void setOprtype(java.lang.String oprtype) {
        this.oprtype = oprtype;
    }

    public java.lang.String getSuccess() {
        return this.success;
    }

    public void setSuccess(java.lang.String success) {
        this.success = success;
    }

    public java.lang.Integer getPid() {
        return this.pid;
    }

    public void setPid(java.lang.Integer pid) {
        this.pid = pid;
    }

    public java.lang.String getPname() {
        return this.pname;
    }

    public void setPname(java.lang.String pname) {
        this.pname = pname;
    }

    public java.lang.String getPtype() {
        return this.ptype;
    }

    public void setPtype(java.lang.String ptype) {
        this.ptype = ptype;
    }

    public java.util.Date getPstarttime() {
        return this.pstarttime;
    }

    public void setPstarttime(java.util.Date pstarttime) {
        this.pstarttime = pstarttime;
    }

    public java.util.Date getPendtime() {
        return this.pendtime;
    }

    public void setPendtime(java.util.Date pendtime) {
        this.pendtime = pendtime;
    }

    public java.lang.String getPfrtmode() {
        return this.pfrtmode;
    }

    public void setPfrtmode(java.lang.String pfrtmode) {
        this.pfrtmode = pfrtmode;
    }

    public java.lang.String getMemo() {
        return this.memo;
    }

    public void setMemo(java.lang.String memo) {
        this.memo = memo;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("logid", getLogid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof SpproposallogVO) ) return false;
        SpproposallogVO castOther = (SpproposallogVO) other;
        return new EqualsBuilder()
            .append(this.getLogid(), castOther.getLogid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getLogid())
            .toHashCode();
    }

}
