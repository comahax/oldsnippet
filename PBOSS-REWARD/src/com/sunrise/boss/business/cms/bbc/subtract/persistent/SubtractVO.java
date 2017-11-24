package com.sunrise.boss.business.cms.bbc.subtract.persistent;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import com.sunrise.boss.business.cms.bbc.subtractlog.persistent.SubtractlogVO;
import com.sunrise.boss.business.common.dblog.OperationLog;

/** @author Hibernate CodeGenerator */
public class SubtractVO implements OperationLog {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** identifier field */
    private Long seq;

    /** nullable persistent field */
    private String onceopnid;

    /** nullable persistent field */
    private String intvopnid;

    /** nullable persistent field */
    private String empmobile;

    /** nullable persistent field */
    private String blackmobile;

    /** nullable persistent field */
    private String calcmonth;

    /** full constructor */
    public SubtractVO(java.lang.Long seq, java.lang.String onceopnid, java.lang.String intvopnid, java.lang.String empmobile, java.lang.String blackmobile, java.lang.String calcmonth) {
        this.seq = seq;
        this.onceopnid = onceopnid;
        this.intvopnid = intvopnid;
        this.empmobile = empmobile;
        this.blackmobile = blackmobile;
        this.calcmonth = calcmonth;
    }

    /** default constructor */
    public SubtractVO() {
    }

    /** minimal constructor */
    public SubtractVO(java.lang.Long seq) {
        this.seq = seq;
    }

    public java.lang.Long getSeq() {
        return this.seq;
    }

    public void setSeq(java.lang.Long seq) {
        this.seq = seq;
    }

    public java.lang.String getOnceopnid() {
        return this.onceopnid;
    }

    public void setOnceopnid(java.lang.String onceopnid) {
        this.onceopnid = onceopnid;
    }

    public java.lang.String getIntvopnid() {
        return this.intvopnid;
    }

    public void setIntvopnid(java.lang.String intvopnid) {
        this.intvopnid = intvopnid;
    }

    public java.lang.String getEmpmobile() {
        return this.empmobile;
    }

    public void setEmpmobile(java.lang.String empmobile) {
        this.empmobile = empmobile;
    }

    public java.lang.String getBlackmobile() {
        return this.blackmobile;
    }

    public void setBlackmobile(java.lang.String blackmobile) {
        this.blackmobile = blackmobile;
    }

    public java.lang.String getCalcmonth() {
        return this.calcmonth;
    }

    public void setCalcmonth(java.lang.String calcmonth) {
        this.calcmonth = calcmonth;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("seq", getSeq())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof SubtractVO) ) return false;
        SubtractVO castOther = (SubtractVO) other;
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
		return SubtractlogVO.class;
	}

}
