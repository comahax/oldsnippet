package com.sunrise.boss.business.cms.zjty.zjtystdrewardbj.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.boss.business.cms.zjty.zjtystdrewardbjlog.persistent.ZjtyStdrewardbjlogVO;
import com.sunrise.boss.business.common.dblog.OperationLog;

/** @author Hibernate CodeGenerator */
public class ZjtyStdrewardbjVO implements OperationLog {

    /** identifier field */
    private String region;

    /** identifier field */
    private Long rewardid;

    /** persistent field */
    private String wayid;
    
    /** persistent field */
    private String opnid;

    /** nullable persistent field */
    private Short acctype;

    /** nullable persistent field */
    private Double rewardstd;

    /** nullable persistent field */
    private Integer intvmonth;

    /** nullable persistent field */
    private String ruleid;
    
	//extend fields
	private String rewardname; //酬金名称
	private Short rewardtype; //酬金类型
	private java.util.Date startdate; //启用日期
	private java.util.Date stopdate; //停用日期
    private Short rewardproj; // 酬金项目
    private boolean deletefalg; //删除标识
    private Long temprewardid; //临时酬金标识

	public boolean isDeletefalg() {
		return deletefalg;
	}

	public void setDeletefalg(boolean deletefalg) {
		this.deletefalg = deletefalg;
	}

	public String getRewardname() {
		return rewardname;
	}

	public void setRewardname(String rewardname) {
		this.rewardname = rewardname;
	}

	public Short getRewardproj() {
		return rewardproj;
	}

	public void setRewardproj(Short rewardproj) {
		this.rewardproj = rewardproj;
	}

	public Short getRewardtype() {
		return rewardtype;
	}

	public void setRewardtype(Short rewardtype) {
		this.rewardtype = rewardtype;
	}

	public java.util.Date getStartdate() {
		return startdate;
	}

	public void setStartdate(java.util.Date startdate) {
		this.startdate = startdate;
	}

	public java.util.Date getStopdate() {
		return stopdate;
	}

	public void setStopdate(java.util.Date stopdate) {
		this.stopdate = stopdate;
	}

	public Long getTemprewardid() {
		return temprewardid;
	}

	public void setTemprewardid(Long temprewardid) {
		this.temprewardid = temprewardid;
	}

	/** full constructor */
    public ZjtyStdrewardbjVO(java.lang.String region, java.lang.Long rewardid, java.lang.String opnid, java.lang.Short acctype, java.lang.Double rewardstd, java.lang.Integer intvmonth, java.lang.String ruleid, java.lang.String wayid) {
        this.region = region;
        this.rewardid = rewardid;
        this.opnid = opnid;
        this.acctype = acctype;
        this.rewardstd = rewardstd;
        this.intvmonth = intvmonth;
        this.ruleid = ruleid;
        this.wayid = wayid;
    }

    /** default constructor */
    public ZjtyStdrewardbjVO() {
    }

    /** minimal constructor */
    public ZjtyStdrewardbjVO(java.lang.String region, java.lang.Long rewardid, java.lang.String wayid) {
        this.region = region;
        this.rewardid = rewardid;
        this.wayid = wayid;
    }

    public String getWayid() {
		return wayid;
	}

	public void setWayid(String wayid) {
		this.wayid = wayid;
	}
    
    public java.lang.String getRegion() {
        return this.region;
    }

    public void setRegion(java.lang.String region) {
        this.region = region;
    }

    public java.lang.Long getRewardid() {
        return this.rewardid;
    }

    public void setRewardid(java.lang.Long rewardid) {
        this.rewardid = rewardid;
    }

    public java.lang.String getOpnid() {
        return this.opnid;
    }

    public void setOpnid(java.lang.String opnid) {
        this.opnid = opnid;
    }

    public java.lang.Short getAcctype() {
        return this.acctype;
    }

    public void setAcctype(java.lang.Short acctype) {
        this.acctype = acctype;
    }

    public java.lang.Double getRewardstd() {
        return this.rewardstd;
    }

    public void setRewardstd(java.lang.Double rewardstd) {
        this.rewardstd = rewardstd;
    }

    public java.lang.Integer getIntvmonth() {
        return this.intvmonth;
    }

    public void setIntvmonth(java.lang.Integer intvmonth) {
        this.intvmonth = intvmonth;
    }

    public java.lang.String getRuleid() {
        return this.ruleid;
    }

    public void setRuleid(java.lang.String ruleid) {
        this.ruleid = ruleid;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("region", getRegion())
            .append("rewardid", getRewardid())
            .append("wayid", getWayid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ZjtyStdrewardbjVO) ) return false;
        ZjtyStdrewardbjVO castOther = (ZjtyStdrewardbjVO) other;
        return new EqualsBuilder()
            .append(this.getRegion(), castOther.getRegion())
            .append(this.getRewardid(), castOther.getRewardid())
            .append(this.getWayid(), castOther.getWayid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getRegion())
            .append(getRewardid())
            .append(getWayid())
            .toHashCode();
    }

	public Class logVOClass() {
		// TODO Auto-generated method stub
		return ZjtyStdrewardbjlogVO.class;
	}

}
