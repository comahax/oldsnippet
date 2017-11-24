package com.gmcc.pboss.business.base.functionitem;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.gmcc.pboss.business.base.functionitemlog.FunctionitemlogVO;
import com.sunrise.jop.infrastructure.db.BaseVO;
import com.sunrise.jop.infrastructure.sysadmin.BusinessLog;

/** @author Hibernate CodeGenerator */
public class FunctionitemVO extends BaseVO implements Serializable,BusinessLog {

    /** identifier field */
    private String funcid;

    /** nullable persistent field */
    private String funcname;

    /** nullable persistent field */
    private String parentid;

    /** nullable persistent field */
    private String guiobject;

    /** nullable persistent field */
    private String rltguiobjid;

    /** nullable persistent field */
    private String addedinfo;

    /** nullable persistent field */
    private String tiptext;

    /** nullable persistent field */
    private String subsystemid;

    /** nullable persistent field */
    private String guitype;

    /** nullable persistent field */
    private String recdefid;

    /** nullable persistent field */
    private Short sortorder;

    /** nullable persistent field */
    private java.util.Date createdate;

    /** nullable persistent field */
    private Byte status;

    /** nullable persistent field */
    private java.util.Date statusdate;

    /** full constructor */
    public FunctionitemVO(java.lang.String funcid, java.lang.String funcname, java.lang.String parentid, java.lang.String guiobject, java.lang.String rltguiobjid, java.lang.String addedinfo, java.lang.String tiptext, java.lang.String subsystemid, java.lang.String guitype, java.lang.String recdefid, java.lang.Short sortorder, java.util.Date createdate, java.lang.Byte status, java.util.Date statusdate) {
        this.funcid = funcid;
        this.funcname = funcname;
        this.parentid = parentid;
        this.guiobject = guiobject;
        this.rltguiobjid = rltguiobjid;
        this.addedinfo = addedinfo;
        this.tiptext = tiptext;
        this.subsystemid = subsystemid;
        this.guitype = guitype;
        this.recdefid = recdefid;
        this.sortorder = sortorder;
        this.createdate = createdate;
        this.status = status;
        this.statusdate = statusdate;
    }

    /** default constructor */
    public FunctionitemVO() {
    }

    /** minimal constructor */
    public FunctionitemVO(java.lang.String funcid) {
        this.funcid = funcid;
    }

    public java.lang.String getFuncid() {
        return this.funcid;
    }

    public void setFuncid(java.lang.String funcid) {
        this.funcid = funcid;
    }

    public java.lang.String getFuncname() {
        return this.funcname;
    }

    public void setFuncname(java.lang.String funcname) {
        this.funcname = funcname;
    }

    public java.lang.String getParentid() {
        return this.parentid;
    }

    public void setParentid(java.lang.String parentid) {
        this.parentid = parentid;
    }

    public java.lang.String getGuiobject() {
        return this.guiobject;
    }

    public void setGuiobject(java.lang.String guiobject) {
        this.guiobject = guiobject;
    }

    public java.lang.String getRltguiobjid() {
        return this.rltguiobjid;
    }

    public void setRltguiobjid(java.lang.String rltguiobjid) {
        this.rltguiobjid = rltguiobjid;
    }

    public java.lang.String getAddedinfo() {
        return this.addedinfo;
    }

    public void setAddedinfo(java.lang.String addedinfo) {
        this.addedinfo = addedinfo;
    }

    public java.lang.String getTiptext() {
        return this.tiptext;
    }

    public void setTiptext(java.lang.String tiptext) {
        this.tiptext = tiptext;
    }

    public java.lang.String getSubsystemid() {
        return this.subsystemid;
    }

    public void setSubsystemid(java.lang.String subsystemid) {
        this.subsystemid = subsystemid;
    }

    public java.lang.String getGuitype() {
        return this.guitype;
    }

    public void setGuitype(java.lang.String guitype) {
        this.guitype = guitype;
    }

    public java.lang.String getRecdefid() {
        return this.recdefid;
    }

    public void setRecdefid(java.lang.String recdefid) {
        this.recdefid = recdefid;
    }

    public java.lang.Short getSortorder() {
        return this.sortorder;
    }

    public void setSortorder(java.lang.Short sortorder) {
        this.sortorder = sortorder;
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
            .append("funcid", getFuncid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof FunctionitemVO) ) return false;
        FunctionitemVO castOther = (FunctionitemVO) other;
        return new EqualsBuilder()
            .append(this.getFuncid(), castOther.getFuncid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getFuncid())
            .toHashCode();
    }
    
    public Class logVOClass(){
    	return FunctionitemlogVO.class;
    }
}
