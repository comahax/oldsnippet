package com.gmcc.pboss.business.sales.comsellmid;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class ComsellmidVO extends BaseVO implements Serializable {

    /** identifier field */
    private String orderid;

    /** identifier field */
    private Integer recid;

    /** nullable persistent field */
    private String comresid;

    /** nullable persistent field */
    private String comid;

    /** nullable persistent field */
    private String batchno;

    /** nullable persistent field */
    private String wayid;

    /** nullable persistent field */
    private Double comprice;

    /** nullable persistent field */
    private Double actprice;

    /** nullable persistent field */
    private java.util.Date createtime;
    
    private String cityid;


    public String getCityid() {
		return cityid;
	}

	public void setCityid(String cityid) {
		this.cityid = cityid;
	}

	/** full constructor */
    public ComsellmidVO(java.lang.String orderid, java.lang.Integer recid, java.lang.String comresid, java.lang.String comid, java.lang.String batchno, java.lang.String wayid, java.lang.Double comprice, java.lang.Double actprice, java.util.Date createtime) {
        this.orderid = orderid;
        this.recid = recid;
        this.comresid = comresid;
        this.comid = comid;
        this.batchno = batchno;
        this.wayid = wayid;
        this.comprice = comprice;
        this.actprice = actprice;
        this.createtime = createtime;
    }

    /** default constructor */
    public ComsellmidVO() {
    }

    /** minimal constructor */
    public ComsellmidVO(java.lang.String orderid, java.lang.Integer recid) {
        this.orderid = orderid;
        this.recid = recid;
    }

    public java.lang.String getOrderid() {
        return this.orderid;
    }

    public void setOrderid(java.lang.String orderid) {
        this.orderid = orderid;
    }

    public java.lang.Integer getRecid() {
        return this.recid;
    }

    public void setRecid(java.lang.Integer recid) {
        this.recid = recid;
    }

    public java.lang.String getComresid() {
        return this.comresid;
    }

    public void setComresid(java.lang.String comresid) {
        this.comresid = comresid;
    }

    public java.lang.String getComid() {
        return this.comid;
    }

    public void setComid(java.lang.String comid) {
        this.comid = comid;
    }

    public java.lang.String getBatchno() {
        return this.batchno;
    }

    public void setBatchno(java.lang.String batchno) {
        this.batchno = batchno;
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.Double getComprice() {
        return this.comprice;
    }

    public void setComprice(java.lang.Double comprice) {
        this.comprice = comprice;
    }

    public java.lang.Double getActprice() {
        return this.actprice;
    }

    public void setActprice(java.lang.Double actprice) {
        this.actprice = actprice;
    }

    public java.util.Date getCreatetime() {
        return this.createtime;
    }

    public void setCreatetime(java.util.Date createtime) {
        this.createtime = createtime;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("orderid", getOrderid())
            .append("recid", getRecid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ComsellmidVO) ) return false;
        ComsellmidVO castOther = (ComsellmidVO) other;
        return new EqualsBuilder()
            .append(this.getOrderid(), castOther.getOrderid())
            .append(this.getRecid(), castOther.getRecid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getOrderid())
            .append(getRecid())
            .toHashCode();
    }

}
