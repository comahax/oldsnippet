package com.gmcc.pboss.business.resource.emptysimbad;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class EmptysimbadVO extends BaseVO implements Serializable {

    /** identifier field */
    private String emptyno;

    /** nullable persistent field */
    private String comcategory;

    /** nullable persistent field */
    private String wayid;

    /** nullable persistent field */
    private String oprcode;

    /** nullable persistent field */
    private java.util.Date createtime;

    /** full constructor */
    public EmptysimbadVO(java.lang.String emptyno, java.lang.String comcategory, java.lang.String wayid, java.lang.String oprcode, java.util.Date createtime) {
        this.emptyno = emptyno;
        this.comcategory = comcategory;
        this.wayid = wayid;
        this.oprcode = oprcode;
        this.createtime = createtime;
    }

    /** default constructor */
    public EmptysimbadVO() {
    }

    /** minimal constructor */
    public EmptysimbadVO(java.lang.String emptyno) {
        this.emptyno = emptyno;
    }

    public java.lang.String getEmptyno() {
        return this.emptyno;
    }

    public void setEmptyno(java.lang.String emptyno) {
        this.emptyno = emptyno;
    }

    public java.lang.String getComcategory() {
        return this.comcategory;
    }

    public void setComcategory(java.lang.String comcategory) {
        this.comcategory = comcategory;
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.String getOprcode() {
        return this.oprcode;
    }

    public void setOprcode(java.lang.String oprcode) {
        this.oprcode = oprcode;
    }

    public java.util.Date getCreatetime() {
        return this.createtime;
    }

    public void setCreatetime(java.util.Date createtime) {
        this.createtime = createtime;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("emptyno", getEmptyno())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof EmptysimbadVO) ) return false;
        EmptysimbadVO castOther = (EmptysimbadVO) other;
        return new EqualsBuilder()
            .append(this.getEmptyno(), castOther.getEmptyno())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getEmptyno())
            .toHashCode();
    }

}
