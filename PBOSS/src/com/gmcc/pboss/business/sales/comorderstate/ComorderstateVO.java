package com.gmcc.pboss.business.sales.comorderstate;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class ComorderstateVO extends BaseVO implements Serializable {

    /** identifier field */
    private String recid;

    /** persistent field */
    private String cityid;

    /** persistent field */
    private String comcategory;

    /** persistent field */
    private String orderstate;

    /** nullable persistent field */
    private String msgcontent;

    /** nullable persistent field */
    private String memo;

    /** full constructor */
    public ComorderstateVO(java.lang.String cityid, java.lang.String comcategory, java.lang.String orderstate, java.lang.String msgcontent, java.lang.String memo) {
        this.cityid = cityid;
        this.comcategory = comcategory;
        this.orderstate = orderstate;
        this.msgcontent = msgcontent;
        this.memo = memo;
    }

    /** default constructor */
    public ComorderstateVO() {
    }

    /** minimal constructor */
    public ComorderstateVO(java.lang.String cityid, java.lang.String comcategory, java.lang.String orderstate) {
        this.cityid = cityid;
        this.comcategory = comcategory;
        this.orderstate = orderstate;
    }

    public java.lang.String getRecid() {
        return this.recid;
    }

    public void setRecid(java.lang.String recid) {
        this.recid = recid;
    }

    public java.lang.String getCityid() {
        return this.cityid;
    }

    public void setCityid(java.lang.String cityid) {
        this.cityid = cityid;
    }

    public java.lang.String getComcategory() {
        return this.comcategory;
    }

    public void setComcategory(java.lang.String comcategory) {
        this.comcategory = comcategory;
    }

    public java.lang.String getOrderstate() {
        return this.orderstate;
    }

    public void setOrderstate(java.lang.String orderstate) {
        this.orderstate = orderstate;
    }

    public java.lang.String getMsgcontent() {
        return this.msgcontent;
    }

    public void setMsgcontent(java.lang.String msgcontent) {
        this.msgcontent = msgcontent;
    }

    public java.lang.String getMemo() {
        return this.memo;
    }

    public void setMemo(java.lang.String memo) {
        this.memo = memo;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("recid", getRecid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ComorderstateVO) ) return false;
        ComorderstateVO castOther = (ComorderstateVO) other;
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
