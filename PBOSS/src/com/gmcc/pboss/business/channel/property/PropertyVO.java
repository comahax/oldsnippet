package com.gmcc.pboss.business.channel.property;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class PropertyVO extends BaseVO implements Serializable {

    /** identifier field */
    private String wayid;

    /** nullable persistent field */
    private Short netwaylevel;

    /** full constructor */
    public PropertyVO(java.lang.String wayid, java.lang.Short netwaylevel) {
        this.wayid = wayid;
        this.netwaylevel = netwaylevel;
    }

    /** default constructor */
    public PropertyVO() {
    }

    /** minimal constructor */
    public PropertyVO(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.Short getNetwaylevel() {
        return this.netwaylevel;
    }

    public void setNetwaylevel(java.lang.Short netwaylevel) {
        this.netwaylevel = netwaylevel;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("wayid", getWayid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof PropertyVO) ) return false;
        PropertyVO castOther = (PropertyVO) other;
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
