package com.sunrise.boss.business.cms.distribute.cpexamlog.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class CpexamlogVO implements Serializable {

    /** identifier field */
    private Integer logid;

    /** persistent field */
    private String oprcode;

    /** persistent field */
    private java.util.Date optime;

    /** persistent field */
    private String oprtype;

    /** nullable persistent field */
    private String success;

    /** persistent field */
    private Long examid;

    /** persistent field */
    private String cooperauid;

    /** persistent field */
    private Integer comtype;

    /** persistent field */
    private Short examtype;

    /** persistent field */
    private Double examresult;

    /** persistent field */
    private Integer basenum;

    /** persistent field */
    private Integer realnum;

    /** full constructor */
    public CpexamlogVO(java.lang.Integer logid, java.lang.String oprcode, java.util.Date optime, java.lang.String oprtype, java.lang.String success, java.lang.Long examid, java.lang.String cooperauid, java.lang.Integer comtype, java.lang.Short examtype, java.lang.Double examresult, java.lang.Integer basenum, java.lang.Integer realnum) {
        this.logid = logid;
        this.oprcode = oprcode;
        this.optime = optime;
        this.oprtype = oprtype;
        this.success = success;
        this.examid = examid;
        this.cooperauid = cooperauid;
        this.comtype = comtype;
        this.examtype = examtype;
        this.examresult = examresult;
        this.basenum = basenum;
        this.realnum = realnum;
    }

    /** default constructor */
    public CpexamlogVO() {
    }

    /** minimal constructor */
    public CpexamlogVO(java.lang.Integer logid, java.lang.String oprcode, java.util.Date optime, java.lang.String oprtype, java.lang.Long examid, java.lang.String cooperauid, java.lang.Integer comtype, java.lang.Short examtype, java.lang.Double examresult, java.lang.Integer basenum, java.lang.Integer realnum) {
        this.logid = logid;
        this.oprcode = oprcode;
        this.optime = optime;
        this.oprtype = oprtype;
        this.examid = examid;
        this.cooperauid = cooperauid;
        this.comtype = comtype;
        this.examtype = examtype;
        this.examresult = examresult;
        this.basenum = basenum;
        this.realnum = realnum;
    }

    public java.lang.Integer getLogid() {
        return this.logid;
    }

    public void setLogid(java.lang.Integer logid) {
        this.logid = logid;
    }

    public java.lang.String getOprcode() {
        return this.oprcode;
    }

    public void setOprcode(java.lang.String oprcode) {
        this.oprcode = oprcode;
    }

    public java.util.Date getOptime() {
        return this.optime;
    }

    public void setOptime(java.util.Date optime) {
        this.optime = optime;
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

    public java.lang.Long getExamid() {
        return this.examid;
    }

    public void setExamid(java.lang.Long examid) {
        this.examid = examid;
    }

    public java.lang.String getCooperauid() {
        return this.cooperauid;
    }

    public void setCooperauid(java.lang.String cooperauid) {
        this.cooperauid = cooperauid;
    }

    public java.lang.Integer getComtype() {
        return this.comtype;
    }

    public void setComtype(java.lang.Integer comtype) {
        this.comtype = comtype;
    }

    public java.lang.Short getExamtype() {
        return this.examtype;
    }

    public void setExamtype(java.lang.Short examtype) {
        this.examtype = examtype;
    }

    public java.lang.Double getExamresult() {
        return this.examresult;
    }

    public void setExamresult(java.lang.Double examresult) {
        this.examresult = examresult;
    }

    public java.lang.Integer getBasenum() {
        return this.basenum;
    }

    public void setBasenum(java.lang.Integer basenum) {
        this.basenum = basenum;
    }

    public java.lang.Integer getRealnum() {
        return this.realnum;
    }

    public void setRealnum(java.lang.Integer realnum) {
        this.realnum = realnum;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("logid", getLogid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CpexamlogVO) ) return false;
        CpexamlogVO castOther = (CpexamlogVO) other;
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
