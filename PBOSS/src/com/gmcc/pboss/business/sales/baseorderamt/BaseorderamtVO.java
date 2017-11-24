package com.gmcc.pboss.business.sales.baseorderamt;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class BaseorderamtVO extends BaseVO implements Serializable {

    /** identifier field */
    private Long recid;

    /** persistent field */
    private String cityid;

    /** persistent field */
    private Short starlevel;

    /** persistent field */
    private Long baseamt;

    /** full constructor */
    public BaseorderamtVO(java.lang.String cityid, java.lang.Short starlevel, java.lang.Long baseamt) {
        this.cityid = cityid;
        this.starlevel = starlevel;
        this.baseamt = baseamt;
    }

    /** default constructor */
    public BaseorderamtVO() {
    }

    public java.lang.Long getRecid() {
        return this.recid;
    }

    public void setRecid(java.lang.Long recid) {
        this.recid = recid;
    }

    public java.lang.String getCityid() {
        return this.cityid;
    }

    public void setCityid(java.lang.String cityid) {
        this.cityid = cityid;
    }

    public java.lang.Short getStarlevel() {
        return this.starlevel;
    }

    public void setStarlevel(java.lang.Short starlevel) {
        this.starlevel = starlevel;
    }

    public java.lang.Long getBaseamt() {
        return this.baseamt;
    }

    public void setBaseamt(java.lang.Long baseamt) {
        this.baseamt = baseamt;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("recid", getRecid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof BaseorderamtVO) ) return false;
        BaseorderamtVO castOther = (BaseorderamtVO) other;
        return new EqualsBuilder()
            .append(this.getRecid(), castOther.getRecid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getRecid())
            .toHashCode();
    }

}
