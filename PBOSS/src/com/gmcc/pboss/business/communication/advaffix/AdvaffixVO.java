package com.gmcc.pboss.business.communication.advaffix;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class AdvaffixVO extends BaseVO implements Serializable {

    /** identifier field */
    private Long affixid;

    /** nullable persistent field */
    private Long advinfoid;

    /** nullable persistent field */
    private String affixname;

    /** nullable persistent field */
    private String affixpath;

    /** full constructor */
    public AdvaffixVO(java.lang.Long advinfoid, java.lang.String affixname, java.lang.String affixpath) {
        this.advinfoid = advinfoid;
        this.affixname = affixname;
        this.affixpath = affixpath;
    }

    /** default constructor */
    public AdvaffixVO() {
    }

    public java.lang.Long getAffixid() {
        return this.affixid;
    }

    public void setAffixid(java.lang.Long affixid) {
        this.affixid = affixid;
    }

    public java.lang.Long getAdvinfoid() {
        return this.advinfoid;
    }

    public void setAdvinfoid(java.lang.Long advinfoid) {
        this.advinfoid = advinfoid;
    }

    public java.lang.String getAffixname() {
        return this.affixname;
    }

    public void setAffixname(java.lang.String affixname) {
        this.affixname = affixname;
    }

    public java.lang.String getAffixpath() {
        return this.affixpath;
    }

    public void setAffixpath(java.lang.String affixpath) {
        this.affixpath = affixpath;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("affixid", getAffixid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof AdvaffixVO) ) return false;
        AdvaffixVO castOther = (AdvaffixVO) other;
        return new EqualsBuilder()
            .append(this.getAffixid(), castOther.getAffixid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getAffixid())
            .toHashCode();
    }

}
