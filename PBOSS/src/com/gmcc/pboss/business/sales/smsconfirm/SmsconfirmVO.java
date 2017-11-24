package com.gmcc.pboss.business.sales.smsconfirm;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class SmsconfirmVO extends BaseVO implements Serializable {

    /** identifier field */
    private Long recid;

    /** nullable persistent field */
    private String type;

    /** nullable persistent field */
    private String stream;

    /** nullable persistent field */
    private String mobileno;

    /** nullable persistent field */
    private String orderid;

    /** nullable persistent field */
    private String state;

    /** nullable persistent field */
    private java.util.Date sendtime;

    /** nullable persistent field */
    private java.util.Date reptime;

    /** nullable persistent field */
    private String repdesc;

    /** full constructor */
    public SmsconfirmVO(java.lang.String type, java.lang.String stream, java.lang.String mobileno, java.lang.String orderid, java.lang.String state, java.util.Date sendtime, java.util.Date reptime, java.lang.String repdesc) {
        this.type = type;
        this.stream = stream;
        this.mobileno = mobileno;
        this.orderid = orderid;
        this.state = state;
        this.sendtime = sendtime;
        this.reptime = reptime;
        this.repdesc = repdesc;
    }

    /** default constructor */
    public SmsconfirmVO() {
    }

    public java.lang.Long getRecid() {
        return this.recid;
    }

    public void setRecid(java.lang.Long recid) {
        this.recid = recid;
    }

    public java.lang.String getType() {
        return this.type;
    }

    public void setType(java.lang.String type) {
        this.type = type;
    }

    public java.lang.String getStream() {
        return this.stream;
    }

    public void setStream(java.lang.String stream) {
        this.stream = stream;
    }

    public java.lang.String getMobileno() {
        return this.mobileno;
    }

    public void setMobileno(java.lang.String mobileno) {
        this.mobileno = mobileno;
    }

    public java.lang.String getOrderid() {
        return this.orderid;
    }

    public void setOrderid(java.lang.String orderid) {
        this.orderid = orderid;
    }

    public java.lang.String getState() {
        return this.state;
    }

    public void setState(java.lang.String state) {
        this.state = state;
    }

    public java.util.Date getSendtime() {
        return this.sendtime;
    }

    public void setSendtime(java.util.Date sendtime) {
        this.sendtime = sendtime;
    }

    public java.util.Date getReptime() {
        return this.reptime;
    }

    public void setReptime(java.util.Date reptime) {
        this.reptime = reptime;
    }

    public java.lang.String getRepdesc() {
        return this.repdesc;
    }

    public void setRepdesc(java.lang.String repdesc) {
        this.repdesc = repdesc;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("recid", getRecid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof SmsconfirmVO) ) return false;
        SmsconfirmVO castOther = (SmsconfirmVO) other;
        return new EqualsBuilder()
            .append(this.getRecid(), castOther.getRecid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getRecid())
            .toHashCode();
    }

}
