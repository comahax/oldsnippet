package com.gmcc.pboss.business.promotion.elmttmpllog;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class ElmttmpllogVO extends BaseVO implements Serializable {

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
    private Integer tmplid;

    /** nullable persistent field */
    private String tmplname;

    /** nullable persistent field */
    private String gatheringmode;

    /** nullable persistent field */
    private String columnsinfo;

    /** nullable persistent field */
    private String gatheringlogic;

    /** nullable persistent field */
    private String state;

    /** nullable persistent field */
    private String memo;

    /** full constructor */
    public ElmttmpllogVO(java.lang.Long logid, java.util.Date optime, java.lang.String oprcode, java.lang.String oprtype, java.lang.String success, java.lang.Integer tmplid, java.lang.String tmplname, java.lang.String gatheringmode, java.lang.String columnsinfo, java.lang.String gatheringlogic, java.lang.String state, java.lang.String memo) {
        this.logid = logid;
        this.optime = optime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
        this.success = success;
        this.tmplid = tmplid;
        this.tmplname = tmplname;
        this.gatheringmode = gatheringmode;
        this.columnsinfo = columnsinfo;
        this.gatheringlogic = gatheringlogic;
        this.state = state;
        this.memo = memo;
    }

    /** default constructor */
    public ElmttmpllogVO() {
    }

    /** minimal constructor */
    public ElmttmpllogVO(java.lang.Long logid) {
        this.logid = logid;
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

    public java.lang.Integer getTmplid() {
        return this.tmplid;
    }

    public void setTmplid(java.lang.Integer tmplid) {
        this.tmplid = tmplid;
    }

    public java.lang.String getTmplname() {
        return this.tmplname;
    }

    public void setTmplname(java.lang.String tmplname) {
        this.tmplname = tmplname;
    }

    public java.lang.String getGatheringmode() {
        return this.gatheringmode;
    }

    public void setGatheringmode(java.lang.String gatheringmode) {
        this.gatheringmode = gatheringmode;
    }

    public java.lang.String getColumnsinfo() {
        return this.columnsinfo;
    }

    public void setColumnsinfo(java.lang.String columnsinfo) {
        this.columnsinfo = columnsinfo;
    }

    public java.lang.String getGatheringlogic() {
        return this.gatheringlogic;
    }

    public void setGatheringlogic(java.lang.String gatheringlogic) {
        this.gatheringlogic = gatheringlogic;
    }

    public java.lang.String getState() {
        return this.state;
    }

    public void setState(java.lang.String state) {
        this.state = state;
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
        if ( !(other instanceof ElmttmpllogVO) ) return false;
        ElmttmpllogVO castOther = (ElmttmpllogVO) other;
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
