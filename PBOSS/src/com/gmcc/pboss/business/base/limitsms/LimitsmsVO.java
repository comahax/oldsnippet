package com.gmcc.pboss.business.base.limitsms;

import com.gmcc.pboss.business.base.limitsmslog.LimitsmslogVO;
import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import com.sunrise.jop.infrastructure.sysadmin.BusinessLog;

/** @author Hibernate CodeGenerator */
public class LimitsmsVO extends BaseVO implements Serializable,BusinessLog {

    /** identifier field */
    private Long seq;

    /** persistent field */
    private String sms;

    /** full constructor */
    public LimitsmsVO(java.lang.String sms) {
        this.sms = sms;
    }

    /** default constructor */
    public LimitsmsVO() {
    }

    public java.lang.Long getSeq() {
        return this.seq;
    }

    public void setSeq(java.lang.Long seq) {
        this.seq = seq;
    }

    public java.lang.String getSms() {
        return this.sms;
    }

    public void setSms(java.lang.String sms) {
        this.sms = sms;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("seq", getSeq())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof LimitsmsVO) ) return false;
        LimitsmsVO castOther = (LimitsmsVO) other;
        return new EqualsBuilder()
            .append(this.getSeq(), castOther.getSeq())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getSeq())
            .toHashCode();
    }

    public Class logVOClass(){
    	return LimitsmslogVO.class;
    }
}
