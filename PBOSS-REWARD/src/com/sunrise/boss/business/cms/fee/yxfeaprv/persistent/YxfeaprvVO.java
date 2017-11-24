package com.sunrise.boss.business.cms.fee.yxfeaprv.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.boss.business.common.dblog.OperationLog;
import com.sunrise.boss.business.cms.fee.yxfeaprvlog.persistent.YxfeaprvlogVO;

/** @author Hibernate CodeGenerator */
public class YxfeaprvVO  implements OperationLog {

	/**
     * 返回对应的logVO类. 
     */
    public Class logVOClass() {
    	return YxfeaprvlogVO.class;
    }
	/** identifier field */
    private Long seq;

    /** persistent field */
    private String wayid;

    /** persistent field */
    private java.sql.Timestamp apptime;

    /** persistent field */
    private String appoprcode;

    /** persistent field */
    private Double appfee;

    /** nullable persistent field */
    private java.sql.Timestamp extime;

    /** nullable persistent field */
    private String exoprcode;

    /** nullable persistent field */
    private Double exfee;

    /** nullable persistent field */
    private String opinion;

    /** nullable persistent field */
    private Double recvfee;

    /** nullable persistent field */
    private String recvoprcode;

    /** nullable persistent field */
    private java.sql.Timestamp recvtime;

    /** persistent field */
    private String yxfeeuse;

    /** persistent field */
    private Short state;

    /** full constructor */
    public YxfeaprvVO(java.lang.Long seq, java.lang.String wayid, java.sql.Timestamp apptime, java.lang.String appoprcode, java.lang.Double appfee, java.sql.Timestamp extime, java.lang.String exoprcode, java.lang.Double exfee, java.lang.String opinion, java.lang.Double recvfee, java.lang.String recvoprcode, java.sql.Timestamp recvtime, java.lang.String yxfeeuse, java.lang.Short state) {
        this.seq = seq;
        this.wayid = wayid;
        this.apptime = apptime;
        this.appoprcode = appoprcode;
        this.appfee = appfee;
        this.extime = extime;
        this.exoprcode = exoprcode;
        this.exfee = exfee;
        this.opinion = opinion;
        this.recvfee = recvfee;
        this.recvoprcode = recvoprcode;
        this.recvtime = recvtime;
        this.yxfeeuse = yxfeeuse;
        this.state = state;
    }

    /** default constructor */
    public YxfeaprvVO() {
    }

    /** minimal constructor */
    public YxfeaprvVO(java.lang.Long seq, java.lang.String wayid, java.sql.Timestamp apptime, java.lang.String appoprcode, java.lang.Double appfee, java.lang.String yxfeeuse, java.lang.Short state) {
        this.seq = seq;
        this.wayid = wayid;
        this.apptime = apptime;
        this.appoprcode = appoprcode;
        this.appfee = appfee;
        this.yxfeeuse = yxfeeuse;
        this.state = state;
    }

    public java.lang.Long getSeq() {
        return this.seq;
    }

    public void setSeq(java.lang.Long seq) {
        this.seq = seq;
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.sql.Timestamp getApptime() {
        return this.apptime;
    }

    public void setApptime(java.sql.Timestamp apptime) {
        this.apptime = apptime;
    }

    public java.lang.String getAppoprcode() {
        return this.appoprcode;
    }

    public void setAppoprcode(java.lang.String appoprcode) {
        this.appoprcode = appoprcode;
    }

    public java.lang.Double getAppfee() {
        return this.appfee;
    }

    public void setAppfee(java.lang.Double appfee) {
        this.appfee = appfee;
    }

    public java.sql.Timestamp getExtime() {
        return this.extime;
    }

    public void setExtime(java.sql.Timestamp extime) {
        this.extime = extime;
    }

    public java.lang.String getExoprcode() {
        return this.exoprcode;
    }

    public void setExoprcode(java.lang.String exoprcode) {
        this.exoprcode = exoprcode;
    }

    public java.lang.Double getExfee() {
        return this.exfee;
    }

    public void setExfee(java.lang.Double exfee) {
        this.exfee = exfee;
    }

    public java.lang.String getOpinion() {
        return this.opinion;
    }

    public void setOpinion(java.lang.String opinion) {
        this.opinion = opinion;
    }

    public java.lang.Double getRecvfee() {
        return this.recvfee;
    }

    public void setRecvfee(java.lang.Double recvfee) {
        this.recvfee = recvfee;
    }

    public java.lang.String getRecvoprcode() {
        return this.recvoprcode;
    }

    public void setRecvoprcode(java.lang.String recvoprcode) {
        this.recvoprcode = recvoprcode;
    }

    public java.sql.Timestamp getRecvtime() {
        return this.recvtime;
    }

    public void setRecvtime(java.sql.Timestamp recvtime) {
        this.recvtime = recvtime;
    }

    public java.lang.String getYxfeeuse() {
        return this.yxfeeuse;
    }

    public void setYxfeeuse(java.lang.String yxfeeuse) {
        this.yxfeeuse = yxfeeuse;
    }

    public java.lang.Short getState() {
        return this.state;
    }

    public void setState(java.lang.Short state) {
        this.state = state;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("seq", getSeq())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof YxfeaprvVO) ) return false;
        YxfeaprvVO castOther = (YxfeaprvVO) other;
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
