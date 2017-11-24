package com.sunrise.boss.business.cms.provagent.chpdagent.persistent;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.boss.business.cms.provagent.chpdagentlog.persistent.ChPdAgentlogVO;
import com.sunrise.boss.business.common.dblog.OperationLog;

/** @author Hibernate CodeGenerator */
public class ChPdAgentVO implements OperationLog {

    /** identifier field */
    private String provagentid;

    /** nullable persistent field */
    private String provagentname;

    /** full constructor */
    public ChPdAgentVO(java.lang.String provagentid, java.lang.String provagentname) {
        this.provagentid = provagentid;
        this.provagentname = provagentname;
    }

    /** default constructor */
    public ChPdAgentVO() {
    }

    /** minimal constructor */
    public ChPdAgentVO(java.lang.String provagentid) {
        this.provagentid = provagentid;
    }

    public java.lang.String getProvagentid() {
        return this.provagentid;
    }

    public void setProvagentid(java.lang.String provagentid) {
        this.provagentid = provagentid;
    }

    public java.lang.String getProvagentname() {
        return this.provagentname;
    }

    public void setProvagentname(java.lang.String provagentname) {
        this.provagentname = provagentname;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("provagentid", getProvagentid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ChPdAgentVO) ) return false;
        ChPdAgentVO castOther = (ChPdAgentVO) other;
        return new EqualsBuilder()
            .append(this.getProvagentid(), castOther.getProvagentid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getProvagentid())
            .toHashCode();
    }
    
    public Class logVOClass() {
		return ChPdAgentlogVO.class;
	}

}
