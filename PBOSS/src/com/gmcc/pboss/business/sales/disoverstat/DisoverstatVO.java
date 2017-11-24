package com.gmcc.pboss.business.sales.disoverstat;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class DisoverstatVO extends BaseVO implements Serializable {

    /** identifier field */
    private Long seqid;

    /** nullable persistent field */
    private String countyid;

    /** nullable persistent field */
    private String mareacode;

    /** nullable persistent field */
    private java.util.Date statdate;

    /** nullable persistent field */
    private Long countt1;

    /** nullable persistent field */
    private Long countt2;

    /** full constructor */
    public DisoverstatVO(java.lang.Long seqid, java.lang.String countyid, java.lang.String mareacode, java.util.Date statdate, java.lang.Long countt1, java.lang.Long countt2) {
        this.seqid = seqid;
        this.countyid = countyid;
        this.mareacode = mareacode;
        this.statdate = statdate;
        this.countt1 = countt1;
        this.countt2 = countt2;
    }

    /** default constructor */
    public DisoverstatVO() {
    }

    /** minimal constructor */
    public DisoverstatVO(java.lang.Long seqid) {
        this.seqid = seqid;
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

    public java.lang.String getMareacode() {
        return this.mareacode;
    }

    public void setMareacode(java.lang.String mareacode) {
        this.mareacode = mareacode;
    }

    public java.util.Date getStatdate() {
        return this.statdate;
    }

    public void setStatdate(java.util.Date statdate) {
        this.statdate = statdate;
    }

    public java.lang.Long getCountt1() {
        return this.countt1;
    }

    public void setCountt1(java.lang.Long countt1) {
        this.countt1 = countt1;
    }

    public java.lang.Long getCountt2() {
        return this.countt2;
    }

    public void setCountt2(java.lang.Long countt2) {
        this.countt2 = countt2;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("seqid", getSeqid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof DisoverstatVO) ) return false;
        DisoverstatVO castOther = (DisoverstatVO) other;
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
