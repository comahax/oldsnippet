package com.sunrise.boss.business.cms.distribute.cpexamhistory.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class CpexamhistoryVO implements Serializable {

    /** persistent field */
    private String cooperauid;

    /** nullable persistent field */
    private String cooperaname;

    /** nullable persistent field */
    private String smsmobileno;

    /** nullable persistent field */
    private String cooperalevel;

    /** nullable persistent field */
    private Short fxtype;

    /** nullable persistent field */
    private Integer comtype;

    /** nullable persistent field */
    private Short examtype;

    /** nullable persistent field */
    private Double examresult;

    /** nullable persistent field */
    private Integer basenum;

    /** nullable persistent field */
    private Integer realnum;

    /** nullable persistent field */
    private Integer odrdablenum;

    /** nullable persistent field */
    private java.util.Date optime;

    /** full constructor */
    public CpexamhistoryVO(java.lang.String cooperauid, java.lang.String cooperaname, java.lang.String smsmobileno, java.lang.String cooperalevel, java.lang.Short fxtype, java.lang.Integer comtype, java.lang.Short examtype, java.lang.Double examresult, java.lang.Integer basenum, java.lang.Integer realnum, java.lang.Integer odrdablenum, java.util.Date optime) {
        this.cooperauid = cooperauid;
        this.cooperaname = cooperaname;
        this.smsmobileno = smsmobileno;
        this.cooperalevel = cooperalevel;
        this.fxtype = fxtype;
        this.comtype = comtype;
        this.examtype = examtype;
        this.examresult = examresult;
        this.basenum = basenum;
        this.realnum = realnum;
        this.odrdablenum = odrdablenum;
        this.optime = optime;
    }

    /** default constructor */
    public CpexamhistoryVO() {
    }

    public java.lang.String getCooperauid() {
        return this.cooperauid;
    }

    public void setCooperauid(java.lang.String cooperauid) {
        this.cooperauid = cooperauid;
    }

    public java.lang.String getCooperaname() {
        return this.cooperaname;
    }

    public void setCooperaname(java.lang.String cooperaname) {
        this.cooperaname = cooperaname;
    }

    public java.lang.String getSmsmobileno() {
        return this.smsmobileno;
    }

    public void setSmsmobileno(java.lang.String smsmobileno) {
        this.smsmobileno = smsmobileno;
    }

    public java.lang.String getCooperalevel() {
        return this.cooperalevel;
    }

    public void setCooperalevel(java.lang.String cooperalevel) {
        this.cooperalevel = cooperalevel;
    }

    public java.lang.Short getFxtype() {
        return this.fxtype;
    }

    public void setFxtype(java.lang.Short fxtype) {
        this.fxtype = fxtype;
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

    public java.lang.Integer getOdrdablenum() {
        return this.odrdablenum;
    }

    public void setOdrdablenum(java.lang.Integer odrdablenum) {
        this.odrdablenum = odrdablenum;
    }

    public java.util.Date getOptime() {
        return this.optime;
    }

    public void setOptime(java.util.Date optime) {
        this.optime = optime;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .toString();
    }

}
