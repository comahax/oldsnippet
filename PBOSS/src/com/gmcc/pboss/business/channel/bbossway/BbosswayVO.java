package com.gmcc.pboss.business.channel.bbossway;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class BbosswayVO extends BaseVO implements Serializable {

    /** identifier field */
    private String wayid;

    /** nullable persistent field */
    private String bbosswayid;

    /** nullable persistent field */
    private String cityid;

    /** nullable persistent field */
    private java.util.Date createtime;

    /** full constructor */
    public BbosswayVO(java.lang.String wayid, java.lang.String bbosswayid, java.lang.String cityid, java.util.Date createtime) {
        this.wayid = wayid;
        this.bbosswayid = bbosswayid;
        this.cityid = cityid;
        this.createtime = createtime;
    }

    /** default constructor */
    public BbosswayVO() {
    }

    /** minimal constructor */
    public BbosswayVO(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.String getBbosswayid() {
        return this.bbosswayid;
    }

    public void setBbosswayid(java.lang.String bbosswayid) {
        this.bbosswayid = bbosswayid;
    }

    public java.lang.String getCityid() {
        return this.cityid;
    }

    public void setCityid(java.lang.String cityid) {
        this.cityid = cityid;
    }

    public java.util.Date getCreatetime() {
        return this.createtime;
    }

    public void setCreatetime(java.util.Date createtime) {
        this.createtime = createtime;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("wayid", getWayid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof BbosswayVO) ) return false;
        BbosswayVO castOther = (BbosswayVO) other;
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
