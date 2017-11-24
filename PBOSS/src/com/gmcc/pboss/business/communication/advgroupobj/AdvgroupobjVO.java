package com.gmcc.pboss.business.communication.advgroupobj;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class AdvgroupobjVO extends BaseVO implements Serializable {

    /** identifier field */
    private Long groupoid;

    /** nullable persistent field */
    private Long groupid;

    /** nullable persistent field */
    private String oid;

    /** full constructor */
    public AdvgroupobjVO(java.lang.Long groupid, java.lang.String oid) {
        this.groupid = groupid;
        this.oid = oid;
    }

    /** default constructor */
    public AdvgroupobjVO() {
    }

    public java.lang.Long getGroupoid() {
        return this.groupoid;
    }

    public void setGroupoid(java.lang.Long groupoid) {
        this.groupoid = groupoid;
    }

    public java.lang.Long getGroupid() {
        return this.groupid;
    }

    public void setGroupid(java.lang.Long groupid) {
        this.groupid = groupid;
    }

    public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public String toString() {
        return new ToStringBuilder(this)
            .append("groupoid", getGroupoid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof AdvgroupobjVO) ) return false;
        AdvgroupobjVO castOther = (AdvgroupobjVO) other;
        return new EqualsBuilder()
            .append(this.getGroupoid(), castOther.getGroupoid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getGroupoid())
            .toHashCode();
    }

}
