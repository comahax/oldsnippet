package com.gmcc.pboss.business.base.webfunctionitemlog;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class WebfunctionitemlogVO extends BaseVO implements Serializable {

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
    private String funcid;

    /** nullable persistent field */
    private String funcname;

    /** nullable persistent field */
    private String parentid;

    /** nullable persistent field */
    private String guiobject;

    /** nullable persistent field */
    private String tiptext;

    /** nullable persistent field */
    private Short sortorder;

    /** nullable persistent field */
    private java.util.Date createdate;

    /** nullable persistent field */
    private Byte status;

    /** nullable persistent field */
    private java.util.Date statusdate;
    
    private Byte type;

    /** full constructor */
    public WebfunctionitemlogVO(java.util.Date optime, java.lang.String oprcode, java.lang.String oprtype, java.lang.String success, java.lang.String funcid, java.lang.String funcname, java.lang.String parentid, java.lang.String guiobject, java.lang.String tiptext, java.lang.Short sortorder, java.util.Date createdate, java.lang.Byte status, java.util.Date statusdate, java.lang.Byte type) {
        this.optime = optime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
        this.success = success;
        this.funcid = funcid;
        this.funcname = funcname;
        this.parentid = parentid;
        this.guiobject = guiobject;
        this.tiptext = tiptext;
        this.sortorder = sortorder;
        this.createdate = createdate;
        this.status = status;
        this.statusdate = statusdate;
        this.type = type;
    }

    /** default constructor */
    public WebfunctionitemlogVO() {
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

    public java.lang.String getTiptext() {
        return this.tiptext;
    }

    public void setTiptext(java.lang.String tiptext) {
        this.tiptext = tiptext;
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
    
    public Byte getType() {
		return type;
	}

	public void setType(Byte type) {
		this.type = type;
	}

    public String toString() {
        return new ToStringBuilder(this)
            .append("logid", getLogid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof WebfunctionitemlogVO) ) return false;
        WebfunctionitemlogVO castOther = (WebfunctionitemlogVO) other;
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
