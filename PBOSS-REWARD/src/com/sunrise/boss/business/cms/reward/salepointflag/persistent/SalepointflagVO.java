package com.sunrise.boss.business.cms.reward.salepointflag.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class SalepointflagVO implements Serializable {

    /** identifier field */
    private String cityid;

    /** persistent field */
    private String flag;

    /** persistent field */
    private String flagname;

    /** full constructor */
    public SalepointflagVO(java.lang.String flag, java.lang.String flagname) {
        this.flag = flag;
        this.flagname = flagname;
    }

    /** default constructor */
    public SalepointflagVO() {
    }

    public java.lang.String getCityid() {
        return this.cityid;
    }

    public void setCityid(java.lang.String cityid) {
        this.cityid = cityid;
    }

    public java.lang.String getFlag() {
        return this.flag;
    }

    public void setFlag(java.lang.String flag) {
        this.flag = flag;
    }

    public java.lang.String getFlagname() {
        return this.flagname;
    }

    public void setFlagname(java.lang.String flagname) {
        this.flagname = flagname;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("cityid", getCityid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof SalepointflagVO) ) return false;
        SalepointflagVO castOther = (SalepointflagVO) other;
        return new EqualsBuilder()
            .append(this.getCityid(), castOther.getCityid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCityid())
            .toHashCode();
    }

}
