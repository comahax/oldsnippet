package com.sunrise.boss.business.cms.layoutlog.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class LayoutlogVO implements Serializable {

    /** identifier field */
    private Long logid;

    /** nullable persistent field */
    private java.sql.Timestamp optime;

    /** nullable persistent field */
    private String oprcode;

    /** nullable persistent field */
    private String oprtype;

    /** nullable persistent field */
    private String success;

    /** persistent field */
    private String layoutid;

    /** persistent field */
    private String layoutname;

    /** persistent field */
    private String layoutcompany;

    /** persistent field */
    private java.sql.Timestamp layouttime;

    /** nullable persistent field */
    private String wayname;

    /** nullable persistent field */
    private String mareacode;

    /** nullable persistent field */
    private String waytype;

    /** nullable persistent field */
    private String waykind;

    /** nullable persistent field */
    private String latitude;

    /** nullable persistent field */
    private String longtitude;

    /** nullable persistent field */
    private Short centerlevel;

    /** nullable persistent field */
    private Short waylevel;

    /** nullable persistent field */
    private Short iscenter;

    /** nullable persistent field */
    private String borough;

    /** nullable persistent field */
    private Short runmode;

    /** nullable persistent field */
    private Short pt;

    /** nullable persistent field */
    private Short isconnected;

    /** nullable persistent field */
    private Short connecttype;

    /** nullable persistent field */
    private Short prtsource;

    /** nullable persistent field */
    private String auditcompany;

    /** nullable persistent field */
    private java.sql.Timestamp audittime;

    /** nullable persistent field */
    private String auditcode;

    /** nullable persistent field */
    private String auditidea;

    /** nullable persistent field */
    private String planrequire;

    /** nullable persistent field */
    private String remark;

    /** nullable persistent field */
    private Short auditstate;

    /** full constructor */
    public LayoutlogVO(java.lang.Long logid, java.sql.Timestamp optime, java.lang.String oprcode, java.lang.String oprtype, java.lang.String success, java.lang.String layoutid, java.lang.String layoutname, java.lang.String layoutcompany, java.sql.Timestamp layouttime, java.lang.String wayname, java.lang.String mareacode, java.lang.String waytype, java.lang.String waykind, java.lang.String latitude, java.lang.String longtitude, java.lang.Short centerlevel, java.lang.Short waylevel, java.lang.Short iscenter, java.lang.String borough, java.lang.Short runmode, java.lang.Short pt, java.lang.Short isconnected, java.lang.Short connecttype, java.lang.Short prtsource, java.lang.String auditcompany, java.sql.Timestamp audittime, java.lang.String auditcode, java.lang.String auditidea, java.lang.String planrequire, java.lang.String remark, java.lang.Short auditstate) {
        this.logid = logid;
        this.optime = optime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
        this.success = success;
        this.layoutid = layoutid;
        this.layoutname = layoutname;
        this.layoutcompany = layoutcompany;
        this.layouttime = layouttime;
        this.wayname = wayname;
        this.mareacode = mareacode;
        this.waytype = waytype;
        this.waykind = waykind;
        this.latitude = latitude;
        this.longtitude = longtitude;
        this.centerlevel = centerlevel;
        this.waylevel = waylevel;
        this.iscenter = iscenter;
        this.borough = borough;
        this.runmode = runmode;
        this.pt = pt;
        this.isconnected = isconnected;
        this.connecttype = connecttype;
        this.prtsource = prtsource;
        this.auditcompany = auditcompany;
        this.audittime = audittime;
        this.auditcode = auditcode;
        this.auditidea = auditidea;
        this.planrequire = planrequire;
        this.remark = remark;
        this.auditstate = auditstate;
    }

    /** default constructor */
    public LayoutlogVO() {
    }

    /** minimal constructor */
    public LayoutlogVO(java.lang.Long logid, java.lang.String layoutid, java.lang.String layoutname, java.lang.String layoutcompany, java.sql.Timestamp layouttime) {
        this.logid = logid;
        this.layoutid = layoutid;
        this.layoutname = layoutname;
        this.layoutcompany = layoutcompany;
        this.layouttime = layouttime;
    }

    public java.lang.Long getLogid() {
        return this.logid;
    }

    public void setLogid(java.lang.Long logid) {
        this.logid = logid;
    }

    public java.sql.Timestamp getOptime() {
        return this.optime;
    }

    public void setOptime(java.sql.Timestamp optime) {
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

    public java.lang.String getLayoutid() {
        return this.layoutid;
    }

    public void setLayoutid(java.lang.String layoutid) {
        this.layoutid = layoutid;
    }

    public java.lang.String getLayoutname() {
        return this.layoutname;
    }

    public void setLayoutname(java.lang.String layoutname) {
        this.layoutname = layoutname;
    }

    public java.lang.String getLayoutcompany() {
        return this.layoutcompany;
    }

    public void setLayoutcompany(java.lang.String layoutcompany) {
        this.layoutcompany = layoutcompany;
    }

    public java.sql.Timestamp getLayouttime() {
        return this.layouttime;
    }

    public void setLayouttime(java.sql.Timestamp layouttime) {
        this.layouttime = layouttime;
    }

    public java.lang.String getWayname() {
        return this.wayname;
    }

    public void setWayname(java.lang.String wayname) {
        this.wayname = wayname;
    }

    public java.lang.String getMareacode() {
        return this.mareacode;
    }

    public void setMareacode(java.lang.String mareacode) {
        this.mareacode = mareacode;
    }

    public java.lang.String getWaytype() {
        return this.waytype;
    }

    public void setWaytype(java.lang.String waytype) {
        this.waytype = waytype;
    }

    public java.lang.String getWaykind() {
        return this.waykind;
    }

    public void setWaykind(java.lang.String waykind) {
        this.waykind = waykind;
    }

    public java.lang.String getLatitude() {
        return this.latitude;
    }

    public void setLatitude(java.lang.String latitude) {
        this.latitude = latitude;
    }

    public java.lang.String getLongtitude() {
        return this.longtitude;
    }

    public void setLongtitude(java.lang.String longtitude) {
        this.longtitude = longtitude;
    }

    public java.lang.Short getCenterlevel() {
        return this.centerlevel;
    }

    public void setCenterlevel(java.lang.Short centerlevel) {
        this.centerlevel = centerlevel;
    }

    public java.lang.Short getWaylevel() {
        return this.waylevel;
    }

    public void setWaylevel(java.lang.Short waylevel) {
        this.waylevel = waylevel;
    }

    public java.lang.Short getIscenter() {
        return this.iscenter;
    }

    public void setIscenter(java.lang.Short iscenter) {
        this.iscenter = iscenter;
    }

    public java.lang.String getBorough() {
        return this.borough;
    }

    public void setBorough(java.lang.String borough) {
        this.borough = borough;
    }

    public java.lang.Short getRunmode() {
        return this.runmode;
    }

    public void setRunmode(java.lang.Short runmode) {
        this.runmode = runmode;
    }

    public java.lang.Short getPt() {
        return this.pt;
    }

    public void setPt(java.lang.Short pt) {
        this.pt = pt;
    }

    public java.lang.Short getIsconnected() {
        return this.isconnected;
    }

    public void setIsconnected(java.lang.Short isconnected) {
        this.isconnected = isconnected;
    }

    public java.lang.Short getConnecttype() {
        return this.connecttype;
    }

    public void setConnecttype(java.lang.Short connecttype) {
        this.connecttype = connecttype;
    }

    public java.lang.Short getPrtsource() {
        return this.prtsource;
    }

    public void setPrtsource(java.lang.Short prtsource) {
        this.prtsource = prtsource;
    }

    public java.lang.String getAuditcompany() {
        return this.auditcompany;
    }

    public void setAuditcompany(java.lang.String auditcompany) {
        this.auditcompany = auditcompany;
    }

    public java.sql.Timestamp getAudittime() {
        return this.audittime;
    }

    public void setAudittime(java.sql.Timestamp audittime) {
        this.audittime = audittime;
    }

    public java.lang.String getAuditcode() {
        return this.auditcode;
    }

    public void setAuditcode(java.lang.String auditcode) {
        this.auditcode = auditcode;
    }

    public java.lang.String getAuditidea() {
        return this.auditidea;
    }

    public void setAuditidea(java.lang.String auditidea) {
        this.auditidea = auditidea;
    }

    public java.lang.String getPlanrequire() {
        return this.planrequire;
    }

    public void setPlanrequire(java.lang.String planrequire) {
        this.planrequire = planrequire;
    }

    public java.lang.String getRemark() {
        return this.remark;
    }

    public void setRemark(java.lang.String remark) {
        this.remark = remark;
    }

    public java.lang.Short getAuditstate() {
        return this.auditstate;
    }

    public void setAuditstate(java.lang.Short auditstate) {
        this.auditstate = auditstate;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("logid", getLogid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof LayoutlogVO) ) return false;
        LayoutlogVO castOther = (LayoutlogVO) other;
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
