package com.gmcc.pboss.business.channel.wayhierarchy;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class WayhierarchyVO extends BaseVO implements Serializable {

    /** identifier field */
    private String parwayid;

    /** identifier field */
    private String subwayid;

    /** persistent field */
    private Short hichyoffset;

    /** nullable persistent field */
    private java.util.Date createtime;

    /** full constructor */
    public WayhierarchyVO(java.lang.String parwayid, java.lang.String subwayid, java.lang.Short hichyoffset, java.util.Date createtime) {
        this.parwayid = parwayid;
        this.subwayid = subwayid;
        this.hichyoffset = hichyoffset;
        this.createtime = createtime;
    }

    /** default constructor */
    public WayhierarchyVO() {
    }

    /** minimal constructor */
    public WayhierarchyVO(java.lang.String parwayid, java.lang.String subwayid, java.lang.Short hichyoffset) {
        this.parwayid = parwayid;
        this.subwayid = subwayid;
        this.hichyoffset = hichyoffset;
    }

    public java.lang.String getParwayid() {
        return this.parwayid;
    }

    public void setParwayid(java.lang.String parwayid) {
        this.parwayid = parwayid;
    }

    public java.lang.String getSubwayid() {
        return this.subwayid;
    }

    public void setSubwayid(java.lang.String subwayid) {
        this.subwayid = subwayid;
    }

    public java.lang.Short getHichyoffset() {
        return this.hichyoffset;
    }

    public void setHichyoffset(java.lang.Short hichyoffset) {
        this.hichyoffset = hichyoffset;
    }

    public java.util.Date getCreatetime() {
        return this.createtime;
    }

    public void setCreatetime(java.util.Date createtime) {
        this.createtime = createtime;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("parwayid", getParwayid())
            .append("subwayid", getSubwayid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof WayhierarchyVO) ) return false;
        WayhierarchyVO castOther = (WayhierarchyVO) other;
        return new EqualsBuilder()
            .append(this.getParwayid(), castOther.getParwayid())
            .append(this.getSubwayid(), castOther.getSubwayid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getParwayid())
            .append(getSubwayid())
            .toHashCode();
    }

}
