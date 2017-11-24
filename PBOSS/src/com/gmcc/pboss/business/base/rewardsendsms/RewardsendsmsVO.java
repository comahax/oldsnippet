package com.gmcc.pboss.business.base.rewardsendsms;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class RewardsendsmsVO extends BaseVO implements Serializable {

    /** identifier field */
    private String seqid;

    /** nullable persistent field */
    private String cityid;

    /** nullable persistent field */
    private String sendtel;

    /** nullable persistent field */
    private Short type;

    /** nullable persistent field */
    private java.util.Date createtime;

    /** full constructor */
    public RewardsendsmsVO(java.lang.String seqid, java.lang.String cityid, java.lang.String sendtel, java.lang.Short type, java.util.Date createtime) {
        this.seqid = seqid;
        this.cityid = cityid;
        this.sendtel = sendtel;
        this.type = type;
        this.createtime = createtime;
    }

    /** default constructor */
    public RewardsendsmsVO() {
    }

    /** minimal constructor */
    public RewardsendsmsVO(java.lang.String seqid) {
        this.seqid = seqid;
    }

    public java.lang.String getSeqid() {
        return this.seqid;
    }

    public void setSeqid(java.lang.String seqid) {
        this.seqid = seqid;
    }

    public java.lang.String getCityid() {
        return this.cityid;
    }

    public void setCityid(java.lang.String cityid) {
        this.cityid = cityid;
    }

    public java.lang.String getSendtel() {
        return this.sendtel;
    }

    public void setSendtel(java.lang.String sendtel) {
        this.sendtel = sendtel;
    }

    public java.lang.Short getType() {
        return this.type;
    }

    public void setType(java.lang.Short type) {
        this.type = type;
    }

    public java.util.Date getCreatetime() {
        return this.createtime;
    }

    public void setCreatetime(java.util.Date createtime) {
        this.createtime = createtime;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("seqid", getSeqid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof RewardsendsmsVO) ) return false;
        RewardsendsmsVO castOther = (RewardsendsmsVO) other;
        return new EqualsBuilder()
            .append(this.getSeqid(), castOther.getSeqid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getSeqid())
            .toHashCode();
    }

}
