package com.gmcc.pboss.business.channel.svwaycnstr;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class SvwaycnstrVO extends BaseVO implements Serializable {

    /** identifier field */
    private String wayid;

    /** nullable persistent field */
    private java.util.Date cntstarttime;

    /** nullable persistent field */
    private Short runstatus;

    /** nullable persistent field */
    private java.util.Date completetime;

    /** nullable persistent field */
    private java.util.Date runtime;

    /** nullable persistent field */
    private java.util.Date closestarttime;

    /** nullable persistent field */
    private java.util.Date closestoptime;

    /** nullable persistent field */
    private java.util.Date closetime;

    /** nullable persistent field */
    private Integer staffstd;

    /** nullable persistent field */
    private Long cntarea;

    /** nullable persistent field */
    private Long bizarea;

    /** nullable persistent field */
    private Long doorarea;

    /** nullable persistent field */
    private Long windowarea;

    /** nullable persistent field */
    private Integer seatnum;

    /** nullable persistent field */
    private Integer actseatnum;

    /** nullable persistent field */
    private Integer flexseatnum;

    /** nullable persistent field */
    private String cntcontractpath;

    /** nullable persistent field */
    private String datatablepath;

    /** nullable persistent field */
    private Long dataarea;

    /** nullable persistent field */
    private Double datanum;

    /** nullable persistent field */
    private Double datacost;

    /** nullable persistent field */
    private Double signcost;

    /** nullable persistent field */
    private Long signarea;

    /** nullable persistent field */
    private Long backarea;

    /** nullable persistent field */
    private Double backcost;

    /** nullable persistent field */
    private Double lampcost;

    /** nullable persistent field */
    private Double vicost;

    /** nullable persistent field */
    private String waytype;

    /** full constructor */
    public SvwaycnstrVO(java.lang.String wayid, java.util.Date cntstarttime, java.lang.Short runstatus, java.util.Date completetime, java.util.Date runtime, java.util.Date closestarttime, java.util.Date closestoptime, java.util.Date closetime, java.lang.Integer staffstd, java.lang.Long cntarea, java.lang.Long bizarea, java.lang.Long doorarea, java.lang.Long windowarea, java.lang.Integer seatnum, java.lang.Integer actseatnum, java.lang.Integer flexseatnum, java.lang.String cntcontractpath, java.lang.String datatablepath, java.lang.Long dataarea, java.lang.Double datanum, java.lang.Double datacost, java.lang.Double signcost, java.lang.Long signarea, java.lang.Long backarea, java.lang.Double backcost, java.lang.Double lampcost, java.lang.Double vicost, java.lang.String waytype) {
        this.wayid = wayid;
        this.cntstarttime = cntstarttime;
        this.runstatus = runstatus;
        this.completetime = completetime;
        this.runtime = runtime;
        this.closestarttime = closestarttime;
        this.closestoptime = closestoptime;
        this.closetime = closetime;
        this.staffstd = staffstd;
        this.cntarea = cntarea;
        this.bizarea = bizarea;
        this.doorarea = doorarea;
        this.windowarea = windowarea;
        this.seatnum = seatnum;
        this.actseatnum = actseatnum;
        this.flexseatnum = flexseatnum;
        this.cntcontractpath = cntcontractpath;
        this.datatablepath = datatablepath;
        this.dataarea = dataarea;
        this.datanum = datanum;
        this.datacost = datacost;
        this.signcost = signcost;
        this.signarea = signarea;
        this.backarea = backarea;
        this.backcost = backcost;
        this.lampcost = lampcost;
        this.vicost = vicost;
        this.waytype = waytype;
    }

    /** default constructor */
    public SvwaycnstrVO() {
    }

    /** minimal constructor */
    public SvwaycnstrVO(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.util.Date getCntstarttime() {
        return this.cntstarttime;
    }

    public void setCntstarttime(java.util.Date cntstarttime) {
        this.cntstarttime = cntstarttime;
    }

    public java.lang.Short getRunstatus() {
        return this.runstatus;
    }

    public void setRunstatus(java.lang.Short runstatus) {
        this.runstatus = runstatus;
    }

    public java.util.Date getCompletetime() {
        return this.completetime;
    }

    public void setCompletetime(java.util.Date completetime) {
        this.completetime = completetime;
    }

    public java.util.Date getRuntime() {
        return this.runtime;
    }

    public void setRuntime(java.util.Date runtime) {
        this.runtime = runtime;
    }

    public java.util.Date getClosestarttime() {
        return this.closestarttime;
    }

    public void setClosestarttime(java.util.Date closestarttime) {
        this.closestarttime = closestarttime;
    }

    public java.util.Date getClosestoptime() {
        return this.closestoptime;
    }

    public void setClosestoptime(java.util.Date closestoptime) {
        this.closestoptime = closestoptime;
    }

    public java.util.Date getClosetime() {
        return this.closetime;
    }

    public void setClosetime(java.util.Date closetime) {
        this.closetime = closetime;
    }

    public java.lang.Integer getStaffstd() {
        return this.staffstd;
    }

    public void setStaffstd(java.lang.Integer staffstd) {
        this.staffstd = staffstd;
    }

    public java.lang.Long getCntarea() {
        return this.cntarea;
    }

    public void setCntarea(java.lang.Long cntarea) {
        this.cntarea = cntarea;
    }

    public java.lang.Long getBizarea() {
        return this.bizarea;
    }

    public void setBizarea(java.lang.Long bizarea) {
        this.bizarea = bizarea;
    }

    public java.lang.Long getDoorarea() {
        return this.doorarea;
    }

    public void setDoorarea(java.lang.Long doorarea) {
        this.doorarea = doorarea;
    }

    public java.lang.Long getWindowarea() {
        return this.windowarea;
    }

    public void setWindowarea(java.lang.Long windowarea) {
        this.windowarea = windowarea;
    }

    public java.lang.Integer getSeatnum() {
        return this.seatnum;
    }

    public void setSeatnum(java.lang.Integer seatnum) {
        this.seatnum = seatnum;
    }

    public java.lang.Integer getActseatnum() {
        return this.actseatnum;
    }

    public void setActseatnum(java.lang.Integer actseatnum) {
        this.actseatnum = actseatnum;
    }

    public java.lang.Integer getFlexseatnum() {
        return this.flexseatnum;
    }

    public void setFlexseatnum(java.lang.Integer flexseatnum) {
        this.flexseatnum = flexseatnum;
    }

    public java.lang.String getCntcontractpath() {
        return this.cntcontractpath;
    }

    public void setCntcontractpath(java.lang.String cntcontractpath) {
        this.cntcontractpath = cntcontractpath;
    }

    public java.lang.String getDatatablepath() {
        return this.datatablepath;
    }

    public void setDatatablepath(java.lang.String datatablepath) {
        this.datatablepath = datatablepath;
    }

    public java.lang.Long getDataarea() {
        return this.dataarea;
    }

    public void setDataarea(java.lang.Long dataarea) {
        this.dataarea = dataarea;
    }

    public java.lang.Double getDatanum() {
        return this.datanum;
    }

    public void setDatanum(java.lang.Double datanum) {
        this.datanum = datanum;
    }

    public java.lang.Double getDatacost() {
        return this.datacost;
    }

    public void setDatacost(java.lang.Double datacost) {
        this.datacost = datacost;
    }

    public java.lang.Double getSigncost() {
        return this.signcost;
    }

    public void setSigncost(java.lang.Double signcost) {
        this.signcost = signcost;
    }

    public java.lang.Long getSignarea() {
        return this.signarea;
    }

    public void setSignarea(java.lang.Long signarea) {
        this.signarea = signarea;
    }

    public java.lang.Long getBackarea() {
        return this.backarea;
    }

    public void setBackarea(java.lang.Long backarea) {
        this.backarea = backarea;
    }

    public java.lang.Double getBackcost() {
        return this.backcost;
    }

    public void setBackcost(java.lang.Double backcost) {
        this.backcost = backcost;
    }

    public java.lang.Double getLampcost() {
        return this.lampcost;
    }

    public void setLampcost(java.lang.Double lampcost) {
        this.lampcost = lampcost;
    }

    public java.lang.Double getVicost() {
        return this.vicost;
    }

    public void setVicost(java.lang.Double vicost) {
        this.vicost = vicost;
    }

    public java.lang.String getWaytype() {
        return this.waytype;
    }

    public void setWaytype(java.lang.String waytype) {
        this.waytype = waytype;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("wayid", getWayid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof SvwaycnstrVO) ) return false;
        SvwaycnstrVO castOther = (SvwaycnstrVO) other;
        return new EqualsBuilder()
            .append(this.getWayid(), castOther.getWayid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getWayid())
            .toHashCode();
    }

}
