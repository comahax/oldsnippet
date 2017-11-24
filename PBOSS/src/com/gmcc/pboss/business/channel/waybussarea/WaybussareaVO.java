package com.gmcc.pboss.business.channel.waybussarea;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class WaybussareaVO extends BaseVO implements Serializable {

    /** identifier field */
    private String wayid;

    /** nullable persistent field */
    private Double totalarea;

    /** nullable persistent field */
    private Double consultarea;

    /** nullable persistent field */
    private Double busarea;

    /** nullable persistent field */
    private Double newbusarea;

    /** nullable persistent field */
    private Double termarea;

    /** nullable persistent field */
    private Double selfservarea;

    /** nullable persistent field */
    private Double custarea;

    /** nullable persistent field */
    private Double viparea;

    /** nullable persistent field */
    private Double bgdarea;

    /** nullable persistent field */
    private String bossarea;

    /** nullable persistent field */
    private Long publisharea;

    /** nullable persistent field */
    private Long shopwinarea;

    /** nullable persistent field */
    private Double doorheight;

    /** nullable persistent field */
    private Double doorlength;

    /** nullable persistent field */
    private Double backheight;

    /** nullable persistent field */
    private Double backlength;

    /** full constructor */
    public WaybussareaVO(java.lang.String wayid, java.lang.Double totalarea, java.lang.Double consultarea, java.lang.Double busarea, java.lang.Double newbusarea, java.lang.Double termarea, java.lang.Double selfservarea, java.lang.Double custarea, java.lang.Double viparea, java.lang.Double bgdarea, java.lang.String bossarea, java.lang.Long publisharea, java.lang.Long shopwinarea, java.lang.Double doorheight, java.lang.Double doorlength, java.lang.Double backheight, java.lang.Double backlength) {
        this.wayid = wayid;
        this.totalarea = totalarea;
        this.consultarea = consultarea;
        this.busarea = busarea;
        this.newbusarea = newbusarea;
        this.termarea = termarea;
        this.selfservarea = selfservarea;
        this.custarea = custarea;
        this.viparea = viparea;
        this.bgdarea = bgdarea;
        this.bossarea = bossarea;
        this.publisharea = publisharea;
        this.shopwinarea = shopwinarea;
        this.doorheight = doorheight;
        this.doorlength = doorlength;
        this.backheight = backheight;
        this.backlength = backlength;
    }

    /** default constructor */
    public WaybussareaVO() {
    }

    /** minimal constructor */
    public WaybussareaVO(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.Double getTotalarea() {
        return this.totalarea;
    }

    public void setTotalarea(java.lang.Double totalarea) {
        this.totalarea = totalarea;
    }

    public java.lang.Double getConsultarea() {
        return this.consultarea;
    }

    public void setConsultarea(java.lang.Double consultarea) {
        this.consultarea = consultarea;
    }

    public java.lang.Double getBusarea() {
        return this.busarea;
    }

    public void setBusarea(java.lang.Double busarea) {
        this.busarea = busarea;
    }

    public java.lang.Double getNewbusarea() {
        return this.newbusarea;
    }

    public void setNewbusarea(java.lang.Double newbusarea) {
        this.newbusarea = newbusarea;
    }

    public java.lang.Double getTermarea() {
        return this.termarea;
    }

    public void setTermarea(java.lang.Double termarea) {
        this.termarea = termarea;
    }

    public java.lang.Double getSelfservarea() {
        return this.selfservarea;
    }

    public void setSelfservarea(java.lang.Double selfservarea) {
        this.selfservarea = selfservarea;
    }

    public java.lang.Double getCustarea() {
        return this.custarea;
    }

    public void setCustarea(java.lang.Double custarea) {
        this.custarea = custarea;
    }

    public java.lang.Double getViparea() {
        return this.viparea;
    }

    public void setViparea(java.lang.Double viparea) {
        this.viparea = viparea;
    }

    public java.lang.Double getBgdarea() {
        return this.bgdarea;
    }

    public void setBgdarea(java.lang.Double bgdarea) {
        this.bgdarea = bgdarea;
    }

    public java.lang.String getBossarea() {
        return this.bossarea;
    }

    public void setBossarea(java.lang.String bossarea) {
        this.bossarea = bossarea;
    }

    public java.lang.Long getPublisharea() {
        return this.publisharea;
    }

    public void setPublisharea(java.lang.Long publisharea) {
        this.publisharea = publisharea;
    }

    public java.lang.Long getShopwinarea() {
        return this.shopwinarea;
    }

    public void setShopwinarea(java.lang.Long shopwinarea) {
        this.shopwinarea = shopwinarea;
    }

    public java.lang.Double getDoorheight() {
        return this.doorheight;
    }

    public void setDoorheight(java.lang.Double doorheight) {
        this.doorheight = doorheight;
    }

    public java.lang.Double getDoorlength() {
        return this.doorlength;
    }

    public void setDoorlength(java.lang.Double doorlength) {
        this.doorlength = doorlength;
    }

    public java.lang.Double getBackheight() {
        return this.backheight;
    }

    public void setBackheight(java.lang.Double backheight) {
        this.backheight = backheight;
    }

    public java.lang.Double getBacklength() {
        return this.backlength;
    }

    public void setBacklength(java.lang.Double backlength) {
        this.backlength = backlength;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("wayid", getWayid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof WaybussareaVO) ) return false;
        WaybussareaVO castOther = (WaybussareaVO) other;
        return new EqualsBuilder()
            .append(this.getWayid(), castOther.getWayid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getWayid())
            .toHashCode();
    }

}
