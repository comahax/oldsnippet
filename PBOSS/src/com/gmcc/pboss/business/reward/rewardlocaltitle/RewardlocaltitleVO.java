package com.gmcc.pboss.business.reward.rewardlocaltitle;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class RewardlocaltitleVO extends BaseVO implements Serializable {

    /** identifier field */
    private String rewardmonth;

    /** identifier field */
    private String rpttype;

    /** persistent field */
    private Integer seq;

    /** nullable persistent field */
    private Integer titleno;

    /** nullable persistent field */
    private Integer subno;

    /** nullable persistent field */
    private String titlename;

    /** nullable persistent field */
    private String subtitlename;

    /** full constructor */
    public RewardlocaltitleVO(java.lang.String rewardmonth, java.lang.String rpttype, java.lang.Integer seq, java.lang.Integer titleno, java.lang.Integer subno, java.lang.String titlename, java.lang.String subtitlename) {
        this.rewardmonth = rewardmonth;
        this.rpttype = rpttype;
        this.seq = seq;
        this.titleno = titleno;
        this.subno = subno;
        this.titlename = titlename;
        this.subtitlename = subtitlename;
    }

    /** default constructor */
    public RewardlocaltitleVO() {
    }

    /** minimal constructor */
    public RewardlocaltitleVO(java.lang.String rewardmonth, java.lang.String rpttype, java.lang.Integer seq) {
        this.rewardmonth = rewardmonth;
        this.rpttype = rpttype;
        this.seq = seq;
    }

    public java.lang.String getRewardmonth() {
        return this.rewardmonth;
    }

    public void setRewardmonth(java.lang.String rewardmonth) {
        this.rewardmonth = rewardmonth;
    }

    public java.lang.String getRpttype() {
        return this.rpttype;
    }

    public void setRpttype(java.lang.String rpttype) {
        this.rpttype = rpttype;
    }

    public java.lang.Integer getSeq() {
        return this.seq;
    }

    public void setSeq(java.lang.Integer seq) {
        this.seq = seq;
    }

    public java.lang.Integer getTitleno() {
        return this.titleno;
    }

    public void setTitleno(java.lang.Integer titleno) {
        this.titleno = titleno;
    }

    public java.lang.Integer getSubno() {
        return this.subno;
    }

    public void setSubno(java.lang.Integer subno) {
        this.subno = subno;
    }

    public java.lang.String getTitlename() {
        return this.titlename;
    }

    public void setTitlename(java.lang.String titlename) {
        this.titlename = titlename;
    }

    public java.lang.String getSubtitlename() {
        return this.subtitlename;
    }

    public void setSubtitlename(java.lang.String subtitlename) {
        this.subtitlename = subtitlename;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("rewardmonth", getRewardmonth())
            .append("rpttype", getRpttype())
            .append("seq",getSeq())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof RewardlocaltitleVO) ) return false;
        RewardlocaltitleVO castOther = (RewardlocaltitleVO) other;
        return new EqualsBuilder()
            .append(this.getRewardmonth(), castOther.getRewardmonth())
            .append(this.getRpttype(), castOther.getRpttype())
            .append(this.getSeq(), castOther.getSeq())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getRewardmonth())
            .append(getRpttype())
            .append(getSeq())
            .toHashCode();
    }

}
