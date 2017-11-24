package com.gmcc.pboss.business.reward.rewardlocal;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.gmcc.pboss.business.reward.rewardlocalvalue.RewardlocalvalueVO;
import com.sunrise.jop.infrastructure.db.BaseVO;

/** @author Hibernate CodeGenerator */
public class RewardlocalVO extends BaseVO implements Serializable {

    /** identifier field */
    private Long rewardid;

    /** persistent field */
    private String rewardmonth;

    /** persistent field */
    private String rpttype;

    /** nullable persistent field */
    private String cityname;

    /** nullable persistent field */
    private String localname;

    /** nullable persistent field */
    private String wayidCus;

    /** nullable persistent field */
    private String wayid;

    /** nullable persistent field */
    private String wayname;

    /** nullable persistent field */
    private Short starlevel;
    
    private List<RewardlocalvalueVO>  listRewardlocalvalue;
    
    /** full constructor */
    public RewardlocalVO(java.lang.String rewardmonth, java.lang.String rpttype, java.lang.String cityname, java.lang.String localname, java.lang.String wayidCus, java.lang.String wayid, java.lang.String wayname, java.lang.Short starlevel) {
        this.rewardmonth = rewardmonth;
        this.rpttype = rpttype;
        this.cityname = cityname;
        this.localname = localname;
        this.wayidCus = wayidCus;
        this.wayid = wayid;
        this.wayname = wayname;
        this.starlevel = starlevel;
    }

    /** default constructor */
    public RewardlocalVO() {
    }

    /** minimal constructor */
    public RewardlocalVO(java.lang.String rewardmonth, java.lang.String rpttype) {
        this.rewardmonth = rewardmonth;
        this.rpttype = rpttype;
    }

    public java.lang.Long getRewardid() {
        return this.rewardid;
    }

    public void setRewardid(java.lang.Long rewardid) {
        this.rewardid = rewardid;
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

    public java.lang.String getCityname() {
        return this.cityname;
    }

    public void setCityname(java.lang.String cityname) {
        this.cityname = cityname;
    }

    public java.lang.String getLocalname() {
        return this.localname;
    }

    public void setLocalname(java.lang.String localname) {
        this.localname = localname;
    }

    public java.lang.String getWayidCus() {
        return this.wayidCus;
    }

    public void setWayidCus(java.lang.String wayidCus) {
        this.wayidCus = wayidCus;
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

    public String toString() {
        return new ToStringBuilder(this)
            .append("rewardid", getRewardid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof RewardlocalVO) ) return false;
        RewardlocalVO castOther = (RewardlocalVO) other;
        return new EqualsBuilder()
            .append(this.getRewardid(), castOther.getRewardid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getRewardid())
            .toHashCode();
    }

	public List<RewardlocalvalueVO> getListRewardlocalvalue() {
		return listRewardlocalvalue;
	}

	public void setListRewardlocalvalue(
			List<RewardlocalvalueVO> listRewardlocalvalue) {
		this.listRewardlocalvalue = listRewardlocalvalue;
	}
}
