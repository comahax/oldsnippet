package com.gmcc.pboss.business.communication.advgroup;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class AdvgroupVO extends BaseVO implements Serializable {

    /** identifier field */
    private Long groupid;

    /** nullable persistent field */
    private String groupname;
    
    /** full constructor */
    public AdvgroupVO(java.lang.String groupname) {
        this.groupname = groupname;
    }

    /** default constructor */
    public AdvgroupVO() {
    }

    public java.lang.Long getGroupid() {
        return this.groupid;
    }

    public void setGroupid(java.lang.Long groupid) {
        this.groupid = groupid;
    }

    public java.lang.String getGroupname() {
        return this.groupname;
    }

    public void setGroupname(java.lang.String groupname) {
        this.groupname = groupname;
    }

	public String toString() {
        return new ToStringBuilder(this)
            .append("groupid", getGroupid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof AdvgroupVO) ) return false;
        AdvgroupVO castOther = (AdvgroupVO) other;
        return new EqualsBuilder()
            .append(this.getGroupid(), castOther.getGroupid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getGroupid())
            .toHashCode();
    }

}
