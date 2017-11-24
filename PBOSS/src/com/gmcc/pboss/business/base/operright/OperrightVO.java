package com.gmcc.pboss.business.base.operright;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.gmcc.pboss.business.base.operrightlog.OperrightlogVO;
import com.sunrise.jop.infrastructure.db.BaseVO;
import com.sunrise.jop.infrastructure.sysadmin.BusinessLog;

/** @author Hibernate CodeGenerator */
public class OperrightVO extends BaseVO implements Serializable,BusinessLog {

    /** identifier field */
    private String operid;

    /** identifier field */
    private String rightid;

    /** nullable persistent field */
    private Byte status;

    /** nullable persistent field */
    private java.util.Date createdate;

    /** nullable persistent field */
    private Short sortorder;

    /** nullable persistent field */
    private Byte flag;

    /** nullable persistent field */
    private java.util.Date statusdate;

    /** full constructor */
    public OperrightVO(java.lang.String operid, java.lang.String rightid, java.lang.Byte status, java.util.Date createdate, java.lang.Short sortorder, java.lang.Byte flag, java.util.Date statusdate) {
        this.operid = operid;
        this.rightid = rightid;
        this.status = status;
        this.createdate = createdate;
        this.sortorder = sortorder;
        this.flag = flag;
        this.statusdate = statusdate;
    }

    /** default constructor */
    public OperrightVO() {
    }

    /** minimal constructor */
    public OperrightVO(java.lang.String operid, java.lang.String rightid) {
        this.operid = operid;
        this.rightid = rightid;
    }

    public java.lang.String getOperid() {
        return this.operid;
    }

    public void setOperid(java.lang.String operid) {
        this.operid = operid;
    }

    public java.lang.String getRightid() {
        return this.rightid;
    }

    public void setRightid(java.lang.String rightid) {
        this.rightid = rightid;
    }

    public java.lang.Byte getStatus() {
        return this.status;
    }

    public void setStatus(java.lang.Byte status) {
        this.status = status;
    }

    public java.util.Date getCreatedate() {
        return this.createdate;
    }

    public void setCreatedate(java.util.Date createdate) {
        this.createdate = createdate;
    }

    public java.lang.Short getSortorder() {
        return this.sortorder;
    }

    public void setSortorder(java.lang.Short sortorder) {
        this.sortorder = sortorder;
    }

    public java.lang.Byte getFlag() {
        return this.flag;
    }

    public void setFlag(java.lang.Byte flag) {
        this.flag = flag;
    }

    public java.util.Date getStatusdate() {
        return this.statusdate;
    }

    public void setStatusdate(java.util.Date statusdate) {
        this.statusdate = statusdate;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("operid", getOperid())
            .append("rightid", getRightid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof OperrightVO) ) return false;
        OperrightVO castOther = (OperrightVO) other;
        return new EqualsBuilder()
            .append(this.getOperid(), castOther.getOperid())
            .append(this.getRightid(), castOther.getRightid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getOperid())
            .append(getRightid())
            .toHashCode();
    }
    
    public Class logVOClass(){
    	return OperrightlogVO.class;
    }

}
