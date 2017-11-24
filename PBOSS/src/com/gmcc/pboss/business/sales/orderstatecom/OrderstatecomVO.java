package com.gmcc.pboss.business.sales.orderstatecom;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class OrderstatecomVO extends BaseVO implements Serializable {

	/** nullable persistent field */
    private String cntid;
    
    /** identifier field */
    private String countyid;

    /** nullable persistent field */
    private String svccode;

    /** nullable persistent field */
    private String mareacode;

    /** nullable persistent field */
    private Short starlevel;

    /** nullable persistent field */
    private String orderave;

    /** nullable persistent field */
    private String orderstate;

    /** nullable persistent field */
    private String comcategory;

    /** nullable persistent field */
    private Long ordercount;

    /** nullable persistent field */
    private Long orderamt;

    /** nullable persistent field */
    private java.util.Date createtime;

    /** full constructor */
    public OrderstatecomVO(java.lang.String cntid, java.lang.String countyid, java.lang.String svccode, java.lang.String mareacode, java.lang.Short starlevel, java.lang.String orderave, java.lang.String orderstate, java.lang.String comcategory, java.lang.Long ordercount, java.lang.Long orderamt, java.util.Date createtime) {
    	this.cntid = cntid;
    	this.countyid = countyid;
        this.svccode = svccode;
        this.mareacode = mareacode;
        this.starlevel = starlevel;
        this.orderave = orderave;
        this.orderstate = orderstate;
        this.comcategory = comcategory;
        this.ordercount = ordercount;
        this.orderamt = orderamt;
        this.createtime = createtime;
    }

    /** default constructor */
    public OrderstatecomVO() {
    }

    /** minimal constructor */
    public OrderstatecomVO(java.lang.String countyid) {
        this.countyid = countyid;
    }

    public java.lang.String getCountyid() {
        return this.countyid;
    }

    public void setCountyid(java.lang.String countyid) {
        this.countyid = countyid;
    }

    public java.lang.String getSvccode() {
        return this.svccode;
    }

    public void setSvccode(java.lang.String svccode) {
        this.svccode = svccode;
    }

    public java.lang.String getMareacode() {
        return this.mareacode;
    }

    public void setMareacode(java.lang.String mareacode) {
        this.mareacode = mareacode;
    }

    public java.lang.Short getStarlevel() {
        return this.starlevel;
    }

    public void setStarlevel(java.lang.Short starlevel) {
        this.starlevel = starlevel;
    }

    public java.lang.String getOrderave() {
        return this.orderave;
    }

    public void setOrderave(java.lang.String orderave) {
        this.orderave = orderave;
    }

    public java.lang.String getOrderstate() {
        return this.orderstate;
    }

    public void setOrderstate(java.lang.String orderstate) {
        this.orderstate = orderstate;
    }

    public java.lang.String getComcategory() {
        return this.comcategory;
    }

    public void setComcategory(java.lang.String comcategory) {
        this.comcategory = comcategory;
    }

    public java.lang.Long getOrdercount() {
        return this.ordercount;
    }

    public void setOrdercount(java.lang.Long ordercount) {
        this.ordercount = ordercount;
    }

    public java.lang.Long getOrderamt() {
        return this.orderamt;
    }

    public void setOrderamt(java.lang.Long orderamt) {
        this.orderamt = orderamt;
    }

    public String toString() {
        return new ToStringBuilder(this)
        	.append("cntid", getCntid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof OrderstatecomVO) ) return false;
        OrderstatecomVO castOther = (OrderstatecomVO) other;
        return new EqualsBuilder()
        	.append(this.getCntid(), castOther.getCntid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
        	.append(getCntid())
            .toHashCode();
    }

    public java.util.Date getCreatetime() {
        return this.createtime;
    }

    public void setCreatetime(java.util.Date createtime) {
        this.createtime = createtime;
    }

	public String getCntid() {
		return cntid;
	}

	public void setCntid(String cntid) {
		this.cntid = cntid;
	}
}
