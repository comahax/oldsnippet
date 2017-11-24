package com.sunrise.boss.business.cms.groupopr.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class GroupoprVO implements Serializable {

    /** identifier field */
    private Long seq;

    /** persistent field */
    private Long groupseq;

    /** persistent field */
    private String oprseq;

    /** persistent field */
    private String bossarea;

    /** full constructor */
    public GroupoprVO(java.lang.Long seq, java.lang.Long groupseq, java.lang.String oprseq, java.lang.String bossarea) {
        this.seq = seq;
        this.groupseq = groupseq;
        this.oprseq = oprseq;
        this.bossarea = bossarea;
    }

    /** default constructor */
    public GroupoprVO() {
    }

    public java.lang.Long getSeq() {
        return this.seq;
    }

    public void setSeq(java.lang.Long seq) {
        this.seq = seq;
    }

    public java.lang.Long getGroupseq() {
        return this.groupseq;
    }

    public void setGroupseq(java.lang.Long groupseq) {
        this.groupseq = groupseq;
    }

    public java.lang.String getOprseq() {
        return this.oprseq;
    }

    public void setOprseq(java.lang.String oprseq) {
        this.oprseq = oprseq;
    }

    public java.lang.String getBossarea() {
        return this.bossarea;
    }

    public void setBossarea(java.lang.String bossarea) {
        this.bossarea = bossarea;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("seq", getSeq())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof GroupoprVO) ) return false;
        GroupoprVO castOther = (GroupoprVO) other;
        return new EqualsBuilder()
            .append(this.getSeq(), castOther.getSeq())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getSeq())
            .toHashCode();
    }

}
