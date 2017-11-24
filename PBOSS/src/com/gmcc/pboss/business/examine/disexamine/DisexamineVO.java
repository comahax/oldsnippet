package com.gmcc.pboss.business.examine.disexamine;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class DisexamineVO extends BaseVO implements Serializable {

    /** identifier field */
    private Long seqid;

    /** nullable persistent field */
    private String discomcode;

    /** nullable persistent field */
    private String exmnperiod;

    /** nullable persistent field */
    private Double penalamt;

    /** nullable persistent field */
    private String createcode;

    /** nullable persistent field */
    private java.util.Date createtime;

    /** nullable persistent field */
    private String memo;

    /** full constructor */
    public DisexamineVO(java.lang.Long seqid, java.lang.String discomcode, java.lang.String exmnperiod, java.lang.Double penalamt, java.lang.String createcode, java.util.Date createtime, java.lang.String memo) {
        this.seqid = seqid;
        this.discomcode = discomcode;
        this.exmnperiod = exmnperiod;
        this.penalamt = penalamt;
        this.createcode = createcode;
        this.createtime = createtime;
        this.memo = memo;
    }

    /** default constructor */
    public DisexamineVO() {
    }

    /** minimal constructor */
    public DisexamineVO(java.lang.Long seqid) {
        this.seqid = seqid;
    }

    public java.lang.Long getSeqid() {
        return this.seqid;
    }

    public void setSeqid(java.lang.Long seqid) {
        this.seqid = seqid;
    }

    public java.lang.String getDiscomcode() {
        return this.discomcode;
    }

    public void setDiscomcode(java.lang.String discomcode) {
        this.discomcode = discomcode;
    }

    public java.lang.String getExmnperiod() {
        return this.exmnperiod;
    }

    public void setExmnperiod(java.lang.String exmnperiod) {
        this.exmnperiod = exmnperiod;
    }

    public java.lang.Double getPenalamt() {
        return this.penalamt;
    }

    public void setPenalamt(java.lang.Double penalamt) {
        this.penalamt = penalamt;
    }

    public java.lang.String getCreatecode() {
        return this.createcode;
    }

    public void setCreatecode(java.lang.String createcode) {
        this.createcode = createcode;
    }

    public java.util.Date getCreatetime() {
        return this.createtime;
    }

    public void setCreatetime(java.util.Date createtime) {
        this.createtime = createtime;
    }

    public java.lang.String getMemo() {
        return this.memo;
    }

    public void setMemo(java.lang.String memo) {
        this.memo = memo;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("seqid", getSeqid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof DisexamineVO) ) return false;
        DisexamineVO castOther = (DisexamineVO) other;
        return new EqualsBuilder()
            .append(this.getSeqid(), castOther.getSeqid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getSeqid())
            .toHashCode();
    }

}
