package com.gmcc.pboss.business.base.smsobject;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import com.gmcc.pboss.business.base.smsobjectlog.SmsobjectlogVO;
import com.sunrise.jop.infrastructure.db.BaseVO;
import com.sunrise.jop.infrastructure.sysadmin.BusinessLog;

/** @author Hibernate CodeGenerator */
public class SmsobjectVO extends BaseVO implements BusinessLog, Serializable {

    /** identifier field */
    private Long seqid;

    /** nullable persistent field */
    private String countyid;

    /** nullable persistent field */
    private String objecttype;

    /** nullable persistent field */
    private String name;

    /** nullable persistent field */
    private String mobile;

    /** nullable persistent field */
    private String busitype;

    /** full constructor */
    public SmsobjectVO(java.lang.String countyid, java.lang.String objecttype, java.lang.String name, java.lang.String mobile, java.lang.String busitype) {
        this.countyid = countyid;
        this.objecttype = objecttype;
        this.name = name;
        this.mobile = mobile;
        this.busitype = busitype;
    }

    /** default constructor */
    public SmsobjectVO() {
    }

    public java.lang.Long getSeqid() {
        return this.seqid;
    }

    public void setSeqid(java.lang.Long seqid) {
        this.seqid = seqid;
    }

    public java.lang.String getCountyid() {
        return this.countyid;
    }

    public void setCountyid(java.lang.String countyid) {
        this.countyid = countyid;
    }

    public java.lang.String getObjecttype() {
        return this.objecttype;
    }

    public void setObjecttype(java.lang.String objecttype) {
        this.objecttype = objecttype;
    }

    public java.lang.String getName() {
        return this.name;
    }

    public void setName(java.lang.String name) {
        this.name = name;
    }

    public java.lang.String getMobile() {
        return this.mobile;
    }

    public void setMobile(java.lang.String mobile) {
        this.mobile = mobile;
    }

    public java.lang.String getBusitype() {
        return this.busitype;
    }

    public void setBusitype(java.lang.String busitype) {
        this.busitype = busitype;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("seqid", getSeqid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof SmsobjectVO) ) return false;
        SmsobjectVO castOther = (SmsobjectVO) other;
        return new EqualsBuilder()
            .append(this.getSeqid(), castOther.getSeqid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getSeqid())
            .toHashCode();
    }
    
    public Class logVOClass(){
    	return SmsobjectlogVO.class;
    }

}
