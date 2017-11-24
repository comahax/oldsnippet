package com.gmcc.pboss.business.resource.simnoactinfofile;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class SimnoactinfofileVO extends BaseVO implements Serializable {

    /** persistent field */
    private Long recid;

    /** persistent field */
    private String filename;

    /** nullable persistent field */
    private java.util.Date begintime;

    /** nullable persistent field */
    private java.util.Date overtime;

    /** nullable persistent field */
    private Long totalamt;

    /** nullable persistent field */
    private Long actualamt;

    /** nullable persistent field */
    private Long successamt;

    /** nullable persistent field */
    private Long failamt;

    /** full constructor */
    public SimnoactinfofileVO(java.lang.Long recid, java.lang.String filename, java.util.Date begintime, java.util.Date overtime, java.lang.Long totalamt, java.lang.Long actualamt, java.lang.Long successamt, java.lang.Long failamt) {
        this.recid = recid;
        this.filename = filename;
        this.begintime = begintime;
        this.overtime = overtime;
        this.totalamt = totalamt;
        this.actualamt = actualamt;
        this.successamt = successamt;
        this.failamt = failamt;
    }

    /** default constructor */
    public SimnoactinfofileVO() {
    }

    /** minimal constructor */
    public SimnoactinfofileVO(java.lang.Long recid, java.lang.String filename) {
        this.recid = recid;
        this.filename = filename;
    }

    public java.lang.Long getRecid() {
        return this.recid;
    }

    public void setRecid(java.lang.Long recid) {
        this.recid = recid;
    }

    public java.lang.String getFilename() {
        return this.filename;
    }

    public void setFilename(java.lang.String filename) {
        this.filename = filename;
    }

    public java.util.Date getBegintime() {
        return this.begintime;
    }

    public void setBegintime(java.util.Date begintime) {
        this.begintime = begintime;
    }

    public java.util.Date getOvertime() {
        return this.overtime;
    }

    public void setOvertime(java.util.Date overtime) {
        this.overtime = overtime;
    }

    public java.lang.Long getTotalamt() {
        return this.totalamt;
    }

    public void setTotalamt(java.lang.Long totalamt) {
        this.totalamt = totalamt;
    }

    public java.lang.Long getActualamt() {
        return this.actualamt;
    }

    public void setActualamt(java.lang.Long actualamt) {
        this.actualamt = actualamt;
    }

    public java.lang.Long getSuccessamt() {
        return this.successamt;
    }

    public void setSuccessamt(java.lang.Long successamt) {
        this.successamt = successamt;
    }

    public java.lang.Long getFailamt() {
        return this.failamt;
    }

    public void setFailamt(java.lang.Long failamt) {
        this.failamt = failamt;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .toString();
    }

}
