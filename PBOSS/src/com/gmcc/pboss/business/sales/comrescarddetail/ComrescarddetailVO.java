package com.gmcc.pboss.business.sales.comrescarddetail;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class ComrescarddetailVO extends BaseVO implements Serializable {

    /** identifier field */
    private Long sid;

    /** nullable persistent field */
    private String countyid;

    /** nullable persistent field */
    private String svccode;

    /** nullable persistent field */
    private String mareacode;

    /** nullable persistent field */
    private String orderid;

    /** nullable persistent field */
    private String wayid;

    /** nullable persistent field */
    private String wayname;

    /** nullable persistent field */
    private Short starlevel;

    /** nullable persistent field */
    private String comresid;

    /** nullable persistent field */
    private java.util.Date stocktime;

    /** nullable persistent field */
    private String comcategory;

    /** nullable persistent field */
    private String waymagcode;

    /** nullable persistent field */
    private String upperwayid;

    /** nullable persistent field */
    private String acttime;

    /** nullable persistent field */
    private String brand;

    /** nullable persistent field */
    private java.util.Date createtime;

    /** nullable persistent field */
    private java.util.Date statisticstime;

    /** full constructor */
    public ComrescarddetailVO(java.lang.Long sid, java.lang.String countyid, java.lang.String svccode, java.lang.String mareacode, java.lang.String orderid, java.lang.String wayid, java.lang.String wayname, java.lang.Short starlevel, java.lang.String comresid, java.util.Date stocktime, java.lang.String comcategory, java.lang.String waymagcode, java.lang.String upperwayid, java.lang.String acttime, java.lang.String brand, java.util.Date createtime, java.util.Date statisticstime) {
        this.sid = sid;
        this.countyid = countyid;
        this.svccode = svccode;
        this.mareacode = mareacode;
        this.orderid = orderid;
        this.wayid = wayid;
        this.wayname = wayname;
        this.starlevel = starlevel;
        this.comresid = comresid;
        this.stocktime = stocktime;
        this.comcategory = comcategory;
        this.waymagcode = waymagcode;
        this.upperwayid = upperwayid;
        this.acttime = acttime;
        this.brand = brand;
        this.createtime = createtime;
        this.statisticstime = statisticstime;
    }

    /** default constructor */
    public ComrescarddetailVO() {
    }

    /** minimal constructor */
    public ComrescarddetailVO(java.lang.Long sid) {
        this.sid = sid;
    }

    public java.lang.Long getSid() {
        return this.sid;
    }

    public void setSid(java.lang.Long sid) {
        this.sid = sid;
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

    public java.lang.String getOrderid() {
        return this.orderid;
    }

    public void setOrderid(java.lang.String orderid) {
        this.orderid = orderid;
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.String getWayname() {
        return this.wayname;
    }

    public void setWayname(java.lang.String wayname) {
        this.wayname = wayname;
    }

    public java.lang.Short getStarlevel() {
        return this.starlevel;
    }

    public void setStarlevel(java.lang.Short starlevel) {
        this.starlevel = starlevel;
    }

    public java.lang.String getComresid() {
        return this.comresid;
    }

    public void setComresid(java.lang.String comresid) {
        this.comresid = comresid;
    }

    public java.util.Date getStocktime() {
        return this.stocktime;
    }

    public void setStocktime(java.util.Date stocktime) {
        this.stocktime = stocktime;
    }

    public java.lang.String getComcategory() {
        return this.comcategory;
    }

    public void setComcategory(java.lang.String comcategory) {
        this.comcategory = comcategory;
    }

    public java.lang.String getWaymagcode() {
        return this.waymagcode;
    }

    public void setWaymagcode(java.lang.String waymagcode) {
        this.waymagcode = waymagcode;
    }

    public java.lang.String getUpperwayid() {
        return this.upperwayid;
    }

    public void setUpperwayid(java.lang.String upperwayid) {
        this.upperwayid = upperwayid;
    }

    public java.lang.String getActtime() {
        return this.acttime;
    }

    public void setActtime(java.lang.String acttime) {
        this.acttime = acttime;
    }

    public java.lang.String getBrand() {
        return this.brand;
    }

    public void setBrand(java.lang.String brand) {
        this.brand = brand;
    }

    public java.util.Date getCreatetime() {
        return this.createtime;
    }

    public void setCreatetime(java.util.Date createtime) {
        this.createtime = createtime;
    }

    public java.util.Date getStatisticstime() {
        return this.statisticstime;
    }

    public void setStatisticstime(java.util.Date statisticstime) {
        this.statisticstime = statisticstime;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("sid", getSid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ComrescarddetailVO) ) return false;
        ComrescarddetailVO castOther = (ComrescarddetailVO) other;
        return new EqualsBuilder()
            .append(this.getSid(), castOther.getSid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getSid())
            .toHashCode();
    }

}
