package com.gmcc.pboss.business.sales.orderproce;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class OrderproceVO extends BaseVO implements Serializable {

    /** identifier field */
    private Long recid;

    /** persistent field */
    private Long flowid;

    /** persistent field */
    private Long processid;

    /** persistent field */
    private String dismode;

    /** nullable persistent field */
    private String instate;

    /** nullable persistent field */
    private String outstate;

    /** full constructor */
    public OrderproceVO(java.lang.Long flowid, java.lang.Long processid, java.lang.String dismode, java.lang.String instate, java.lang.String outstate) {
        this.flowid = flowid;
        this.processid = processid;
        this.dismode = dismode;
        this.instate = instate;
        this.outstate = outstate;
    }

    /** default constructor */
    public OrderproceVO() {
    }

    /** minimal constructor */
    public OrderproceVO(java.lang.Long flowid, java.lang.Long processid, java.lang.String dismode) {
        this.flowid = flowid;
        this.processid = processid;
        this.dismode = dismode;
    }

    public java.lang.Long getRecid() {
        return this.recid;
    }

    public void setRecid(java.lang.Long recid) {
        this.recid = recid;
    }

    public java.lang.Long getFlowid() {
        return this.flowid;
    }

    public void setFlowid(java.lang.Long flowid) {
        this.flowid = flowid;
    }

    public java.lang.Long getProcessid() {
        return this.processid;
    }

    public void setProcessid(java.lang.Long processid) {
        this.processid = processid;
    }

    public java.lang.String getDismode() {
        return this.dismode;
    }

    public void setDismode(java.lang.String dismode) {
        this.dismode = dismode;
    }

    public java.lang.String getInstate() {
        return this.instate;
    }

    public void setInstate(java.lang.String instate) {
        this.instate = instate;
    }

    public java.lang.String getOutstate() {
        return this.outstate;
    }

    public void setOutstate(java.lang.String outstate) {
        this.outstate = outstate;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("recid", getRecid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof OrderproceVO) ) return false;
        OrderproceVO castOther = (OrderproceVO) other;
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
