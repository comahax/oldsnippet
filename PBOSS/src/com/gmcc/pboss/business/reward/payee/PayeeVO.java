package com.gmcc.pboss.business.reward.payee;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.gmcc.pboss.business.reward.payeelog.PayeelogVO;
import com.sunrise.jop.infrastructure.db.BaseVO;
import com.sunrise.jop.infrastructure.sysadmin.BusinessLog;

/** @author Hibernate CodeGenerator */
public class PayeeVO extends BaseVO implements BusinessLog {

	/** identifier field */
    private Long seq;
    /** identifier field */
    private String payee;

    /** nullable persistent field */
    private String pubpri;

    /** nullable persistent field */
    private String cityid;

    /** full constructor */
    public PayeeVO(java.lang.Long seq, java.lang.String payee, java.lang.String pubpri, java.lang.String cityid) {
    	 this.seq = seq;
    	 this.payee = payee;
        this.pubpri = pubpri;
        this.cityid = cityid;
    }

    /** default constructor */
    public PayeeVO() {
    }

    /** minimal constructor */
    public PayeeVO(java.lang.Long seq) {
        this.seq = seq;
    }

    public Long getSeq() {
		return seq;
	}

	public void setSeq(Long seq) {
		this.seq = seq;
	}

	public java.lang.String getPayee() {
        return this.payee;
    }

    public void setPayee(java.lang.String payee) {
        this.payee = payee;
    }

    public java.lang.String getPubpri() {
        return this.pubpri;
    }

    public void setPubpri(java.lang.String pubpri) {
        this.pubpri = pubpri;
    }

    public java.lang.String getCityid() {
        return this.cityid;
    }

    public void setCityid(java.lang.String cityid) {
        this.cityid = cityid;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("seq", getSeq())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof PayeeVO) ) return false;
        PayeeVO castOther = (PayeeVO) other;
        return new EqualsBuilder()
            .append(this.getSeq(), castOther.getSeq())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getSeq())
            .toHashCode();
    }

	public Class logVOClass() {
		// TODO Auto-generated method stub
		return PayeelogVO.class;
	}

}
