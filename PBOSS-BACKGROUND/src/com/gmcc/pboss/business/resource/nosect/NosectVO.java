package com.gmcc.pboss.business.resource.nosect;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class NosectVO extends BaseVO implements Serializable {

    /** identifier field */
    private Integer nosectid;

    /** nullable persistent field */
    private java.util.Date starttime;

    /** nullable persistent field */
    private java.util.Date intime;

    /** nullable persistent field */
    private String beginno;

    /** nullable persistent field */
    private String endno;

    /** nullable persistent field */
    private Short nosectstate;

    /** nullable persistent field */
    private Integer imsisectid;

    /** nullable persistent field */
    private Integer nogroupid;

    /** nullable persistent field */
    private Integer scpid;

    /** nullable persistent field */
    private String bossarea;

    /** nullable persistent field */
    private String originbrandid;

    /** nullable persistent field */
    private Integer vpmnid;

    /** nullable persistent field */
    private String platformtype;

    /** full constructor */
    public NosectVO(java.lang.Integer nosectid, java.util.Date starttime, java.util.Date intime, java.lang.String beginno, java.lang.String endno, java.lang.Short nosectstate, java.lang.Integer imsisectid, java.lang.Integer nogroupid, java.lang.Integer scpid, java.lang.String bossarea, java.lang.String originbrandid, java.lang.Integer vpmnid, java.lang.String platformtype) {
        this.nosectid = nosectid;
        this.starttime = starttime;
        this.intime = intime;
        this.beginno = beginno;
        this.endno = endno;
        this.nosectstate = nosectstate;
        this.imsisectid = imsisectid;
        this.nogroupid = nogroupid;
        this.scpid = scpid;
        this.bossarea = bossarea;
        this.originbrandid = originbrandid;
        this.vpmnid = vpmnid;
        this.platformtype = platformtype;
    }

    /** default constructor */
    public NosectVO() {
    }

    /** minimal constructor */
    public NosectVO(java.lang.Integer nosectid) {
        this.nosectid = nosectid;
    }

    public java.lang.Integer getNosectid() {
        return this.nosectid;
    }

    public void setNosectid(java.lang.Integer nosectid) {
        this.nosectid = nosectid;
    }

    public java.util.Date getStarttime() {
        return this.starttime;
    }

    public void setStarttime(java.util.Date starttime) {
        this.starttime = starttime;
    }

    public java.util.Date getIntime() {
        return this.intime;
    }

    public void setIntime(java.util.Date intime) {
        this.intime = intime;
    }

    public java.lang.String getBeginno() {
        return this.beginno;
    }

    public void setBeginno(java.lang.String beginno) {
        this.beginno = beginno;
    }

    public java.lang.String getEndno() {
        return this.endno;
    }

    public void setEndno(java.lang.String endno) {
        this.endno = endno;
    }

    public java.lang.Short getNosectstate() {
        return this.nosectstate;
    }

    public void setNosectstate(java.lang.Short nosectstate) {
        this.nosectstate = nosectstate;
    }

    public java.lang.Integer getImsisectid() {
        return this.imsisectid;
    }

    public void setImsisectid(java.lang.Integer imsisectid) {
        this.imsisectid = imsisectid;
    }

    public java.lang.Integer getNogroupid() {
        return this.nogroupid;
    }

    public void setNogroupid(java.lang.Integer nogroupid) {
        this.nogroupid = nogroupid;
    }

    public java.lang.Integer getScpid() {
        return this.scpid;
    }

    public void setScpid(java.lang.Integer scpid) {
        this.scpid = scpid;
    }

    public java.lang.String getBossarea() {
        return this.bossarea;
    }

    public void setBossarea(java.lang.String bossarea) {
        this.bossarea = bossarea;
    }

    public java.lang.String getOriginbrandid() {
        return this.originbrandid;
    }

    public void setOriginbrandid(java.lang.String originbrandid) {
        this.originbrandid = originbrandid;
    }

    public java.lang.Integer getVpmnid() {
        return this.vpmnid;
    }

    public void setVpmnid(java.lang.Integer vpmnid) {
        this.vpmnid = vpmnid;
    }

    public java.lang.String getPlatformtype() {
        return this.platformtype;
    }

    public void setPlatformtype(java.lang.String platformtype) {
        this.platformtype = platformtype;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("nosectid", getNosectid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof NosectVO) ) return false;
        NosectVO castOther = (NosectVO) other;
        return new EqualsBuilder()
            .append(this.getNosectid(), castOther.getNosectid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getNosectid())
            .toHashCode();
    }

}
