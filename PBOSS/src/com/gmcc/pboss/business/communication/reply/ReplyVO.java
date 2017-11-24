package com.gmcc.pboss.business.communication.reply;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class ReplyVO extends BaseVO implements Serializable {

    /** identifier field */
    private Long replyid;

    /** nullable persistent field */
    private Long advinfoid;

    /** nullable persistent field */
    private java.sql.Timestamp replytime;

    /** nullable persistent field */
    private String replycontent;

    /** nullable persistent field */
    private String affix;

    /** nullable persistent field */
    private String oid;

    /** full constructor */
    public ReplyVO(java.lang.Long advinfoid, java.sql.Timestamp replytime, java.lang.String replycontent, java.lang.String affix, java.lang.String oid) {
        this.advinfoid = advinfoid;
        this.replytime = replytime;
        this.replycontent = replycontent;
        this.affix = affix;
        this.oid = oid;
    }

    /** default constructor */
    public ReplyVO() {
    }

    public java.lang.Long getReplyid() {
        return this.replyid;
    }

    public void setReplyid(java.lang.Long replyid) {
        this.replyid = replyid;
    }

    public java.lang.Long getAdvinfoid() {
        return this.advinfoid;
    }

    public void setAdvinfoid(java.lang.Long advinfoid) {
        this.advinfoid = advinfoid;
    }

    public java.sql.Timestamp getReplytime() {
        return this.replytime;
    }

    public void setReplytime(java.sql.Timestamp replytime) {
        this.replytime = replytime;
    }

    public java.lang.String getReplycontent() {
        return this.replycontent;
    }

    public void setReplycontent(java.lang.String replycontent) {
        this.replycontent = replycontent;
    }

    public java.lang.String getAffix() {
        return this.affix;
    }

    public void setAffix(java.lang.String affix) {
        this.affix = affix;
    }

    public java.lang.String getOid() {
        return this.oid;
    }

    public void setOid(java.lang.String oid) {
        this.oid = oid;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("replyid", getReplyid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ReplyVO) ) return false;
        ReplyVO castOther = (ReplyVO) other;
        return new EqualsBuilder()
            .append(this.getReplyid(), castOther.getReplyid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getReplyid())
            .toHashCode();
    }

}
