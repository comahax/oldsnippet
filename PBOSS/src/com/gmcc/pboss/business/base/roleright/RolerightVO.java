package com.gmcc.pboss.business.base.roleright;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.gmcc.pboss.business.base.rolerightlog.RolerightlogVO;
import com.sunrise.jop.infrastructure.db.BaseVO;
import com.sunrise.jop.infrastructure.sysadmin.BusinessLog;

/** @author Hibernate CodeGenerator */
public class RolerightVO extends BaseVO implements Serializable,BusinessLog {

    /** identifier field */
    private String itemid;

    /** identifier field */
    private String rightid;

    /** nullable persistent field */
    private java.util.Date createdate;

    /** nullable persistent field */
    private Byte status;

    /** nullable persistent field */
    private java.util.Date statusdate;

    /** full constructor */
    public RolerightVO(java.lang.String itemid, java.lang.String rightid, java.util.Date createdate, java.lang.Byte status, java.util.Date statusdate) {
        this.itemid = itemid;
        this.rightid = rightid;
        this.createdate = createdate;
        this.status = status;
        this.statusdate = statusdate;
    }

    /** default constructor */
    public RolerightVO() {
    }

    /** minimal constructor */
    public RolerightVO(java.lang.String itemid, java.lang.String rightid) {
        this.itemid = itemid;
        this.rightid = rightid;
    }

    public java.lang.String getItemid() {
        return this.itemid;
    }

    public void setItemid(java.lang.String itemid) {
        this.itemid = itemid;
    }

    public java.lang.String getRightid() {
        return this.rightid;
    }

    public void setRightid(java.lang.String rightid) {
        this.rightid = rightid;
    }

    public java.util.Date getCreatedate() {
        return this.createdate;
    }

    public void setCreatedate(java.util.Date createdate) {
        this.createdate = createdate;
    }

    public java.lang.Byte getStatus() {
        return this.status;
    }

    public void setStatus(java.lang.Byte status) {
        this.status = status;
    }

    public java.util.Date getStatusdate() {
        return this.statusdate;
    }

    public void setStatusdate(java.util.Date statusdate) {
        this.statusdate = statusdate;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("itemid", getItemid())
            .append("rightid", getRightid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof RolerightVO) ) return false;
        RolerightVO castOther = (RolerightVO) other;
        return new EqualsBuilder()
            .append(this.getItemid(), castOther.getItemid())
            .append(this.getRightid(), castOther.getRightid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getItemid())
            .append(getRightid())
            .toHashCode();
    }
    
    public Class logVOClass(){
    	return RolerightlogVO.class;
    }

}
