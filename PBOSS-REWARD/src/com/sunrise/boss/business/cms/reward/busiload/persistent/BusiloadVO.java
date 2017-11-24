package com.sunrise.boss.business.cms.reward.busiload.persistent;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.boss.business.cms.reward.busiloadlog.persistent.BusiloadlogVO;
import com.sunrise.boss.business.common.dblog.OperationLog;

/** @author Hibernate CodeGenerator */
public class BusiloadVO implements OperationLog {

    /** identifier field */
    private String loadinfo;

    /** identifier field */
    private String loadtype;

    /** identifier field */
    private String opnid;

    /** full constructor */
    public BusiloadVO(java.lang.String loadinfo, java.lang.String loadtype, java.lang.String opnid) {
        this.loadinfo = loadinfo;
        this.loadtype = loadtype;
        this.opnid = opnid;
    }

    /** default constructor */
    public BusiloadVO() {
    }

    public java.lang.String getLoadinfo() {
        return this.loadinfo;
    }

    public void setLoadinfo(java.lang.String loadinfo) {
        this.loadinfo = loadinfo;
    }

    public java.lang.String getLoadtype() {
        return this.loadtype;
    }

    public void setLoadtype(java.lang.String loadtype) {
        this.loadtype = loadtype;
    }

    public java.lang.String getOpnid() {
        return this.opnid;
    }

    public void setOpnid(java.lang.String opnid) {
        this.opnid = opnid;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("loadinfo", getLoadinfo())
            .append("loadtype", getLoadtype())
            .append("opnid", getOpnid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof BusiloadVO) ) return false;
        BusiloadVO castOther = (BusiloadVO) other;
        return new EqualsBuilder()
            .append(this.getLoadinfo(), castOther.getLoadinfo())
            .append(this.getLoadtype(), castOther.getLoadtype())
            .append(this.getOpnid(), castOther.getOpnid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getLoadinfo())
            .append(getLoadtype())
            .append(getOpnid())
            .toHashCode();
    }
    public Class logVOClass() {
		return BusiloadlogVO.class;
	}

}
