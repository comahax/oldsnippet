package com.gmcc.pboss.business.channel.waitchange;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class WaitchangeVO extends BaseVO implements Serializable {

    /** identifier field */
    private Long streamno;

    /** nullable persistent field */
    private java.util.Date creattime;

    /** nullable persistent field */
    private java.util.Date dealtime;

    /** nullable persistent field */
    private String message;

    /** nullable persistent field */
    private String sendno;

    /** nullable persistent field */
    private String recno;

    /** nullable persistent field */
    private Short issuccess;

    /** nullable persistent field */
    private String resultcode;

    /** nullable persistent field */
    private String resultdesc;

    /** nullable persistent field */
    private java.util.Date senttime;

    /** full constructor */
    public WaitchangeVO(java.util.Date creattime, java.util.Date dealtime, java.lang.String message, java.lang.String sendno, java.lang.String recno, java.lang.Short issuccess, java.lang.String resultcode, java.lang.String resultdesc, java.util.Date senttime) {
        this.creattime = creattime;
        this.dealtime = dealtime;
        this.message = message;
        this.sendno = sendno;
        this.recno = recno;
        this.issuccess = issuccess;
        this.resultcode = resultcode;
        this.resultdesc = resultdesc;
        this.senttime = senttime;
    }

    /** default constructor */
    public WaitchangeVO() {
    }

    public java.lang.Long getStreamno() {
        return this.streamno;
    }

    public void setStreamno(java.lang.Long streamno) {
        this.streamno = streamno;
    }

    public java.util.Date getCreattime() {
        return this.creattime;
    }

    public void setCreattime(java.util.Date creattime) {
        this.creattime = creattime;
    }

    public java.util.Date getDealtime() {
        return this.dealtime;
    }

    public void setDealtime(java.util.Date dealtime) {
        this.dealtime = dealtime;
    }

    public java.lang.String getMessage() {
        return this.message;
    }

    public void setMessage(java.lang.String message) {
        this.message = message;
    }

    public java.lang.String getSendno() {
        return this.sendno;
    }

    public void setSendno(java.lang.String sendno) {
        this.sendno = sendno;
    }

    public java.lang.String getRecno() {
        return this.recno;
    }

    public void setRecno(java.lang.String recno) {
        this.recno = recno;
    }

    public java.lang.Short getIssuccess() {
        return this.issuccess;
    }

    public void setIssuccess(java.lang.Short issuccess) {
        this.issuccess = issuccess;
    }

    public java.lang.String getResultcode() {
        return this.resultcode;
    }

    public void setResultcode(java.lang.String resultcode) {
        this.resultcode = resultcode;
    }

    public java.lang.String getResultdesc() {
        return this.resultdesc;
    }

    public void setResultdesc(java.lang.String resultdesc) {
        this.resultdesc = resultdesc;
    }

    public java.util.Date getSenttime() {
        return this.senttime;
    }

    public void setSenttime(java.util.Date senttime) {
        this.senttime = senttime;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("streamno", getStreamno())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof WaitchangeVO) ) return false;
        WaitchangeVO castOther = (WaitchangeVO) other;
        return new EqualsBuilder()
            .append(this.getStreamno(), castOther.getStreamno())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getStreamno())
            .toHashCode();
    }

}
