package com.sunrise.boss.business.cms.reward.stdrewardut.persistent;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.boss.business.cms.reward.stdrewardutlog.persistent.StdrewardutlogVO;
import com.sunrise.boss.business.common.dblog.OperationLog;
import com.sunrise.boss.ui.cms.commons.CMSUtils;

/** @author Hibernate CodeGenerator */
public class StdrewardutVO implements OperationLog {

    /** identifier field */
    private String region;

    /** identifier field */
    private Long rewardid;
    
    private Long rewardid_51;
    
    private Long rewardid_52;
    
    private Long rewardid_53;

    /** identifier field */
    private String wayid;

    /** nullable persistent field */
    private Short islimt;

    /** nullable persistent field */
    private Double rewardstd;

    /** nullable persistent field */
    private Long intvmonth;

    /** nullable persistent field */
    private Long integralnum;

    /** nullable persistent field */
    private Double unitprice;

    /** nullable persistent field */
    private String relateitem;

    /** identifier field */
    private String cityid;

    /** nullable persistent field */
    private String wayname;

    /** nullable persistent field */
    private Short calcumode;

    /** nullable persistent field */
    private String uniformtime;

    /** nullable persistent field */
    private String setflag;
    
    private String rewardname_51; //51 - 专营补贴酬金
    
    private String rewardname_52; //52 - 销售达标酬金
    
    private String rewardname_53; //53 - 销售超额酬金  下同
    
    private String startdate_51;
    
    private String startdate_52;
    
    private String startdate_53;
    
    private String stopdate_51;
    
    private String stopdate_52;
    
    private String stopdate_53;
    
    private Double rewardstd_51;
    
    private Double rewardstd_52;
    
    private Double rewardstd_53;
    
  //xxcity_51 地市
    private Double rewardstdcity_51;

    private Double rewardstdcity_52;
    
    private Double rewardstdcity_53;
    //
    private Long intvmonth_51;
    
    private Long intvmonth_52;
    
    private Long intvmonth_53;
    
    private Long intvmonthcity_51;
    
    private Long intvmonthcity_52;
    
    private Long intvmonthcity_53;
    
    private Long integralnum_52;
    
    private Long integralnumcity_52;
    
    private Double unitprice_53;
    
    private Double unitpricecity_53;
    
    private Short rewardtype_51;
    
    private Short rewardtype_52;
    
    private Short rewardtype_53;
    
    
    /** full constructor */
    public StdrewardutVO(java.lang.String region, java.lang.Long rewardid, java.lang.String wayid, java.lang.Short islimt, java.lang.Double rewardstd, java.lang.Long intvmonth, java.lang.Long integralnum, java.lang.Double unitprice, java.lang.String relateitem) {
        this.region = region;
        this.rewardid = rewardid;
        this.wayid = wayid;
        this.islimt = islimt;
        this.rewardstd = rewardstd;
        this.intvmonth = intvmonth;
        this.integralnum = integralnum;
        this.unitprice = unitprice;
        this.relateitem = relateitem;
    }

    /** default constructor */
    public StdrewardutVO() {
    }

    /** minimal constructor */
    public StdrewardutVO(java.lang.String region, java.lang.Long rewardid, java.lang.String wayid) {
        this.region = region;
        this.rewardid = rewardid;
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

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.Short getIslimt() {
        return this.islimt;
    }

    public void setIslimt(java.lang.Short islimt) {
        this.islimt = islimt;
    }

    public java.lang.Double getRewardstd() {
        return this.rewardstd;
    }

    public void setRewardstd(java.lang.Double rewardstd) {
        this.rewardstd = rewardstd;
    }

    public java.lang.Long getIntvmonth() {
        return this.intvmonth;
    }

    public void setIntvmonth(java.lang.Long intvmonth) {
        this.intvmonth = intvmonth;
    }

    public java.lang.Long getIntegralnum() {
        return this.integralnum;
    }

    public void setIntegralnum(java.lang.Long integralnum) {
        this.integralnum = integralnum;
    }

    public java.lang.Double getUnitprice() {
        return this.unitprice;
    }

    public void setUnitprice(java.lang.Double unitprice) {
        this.unitprice = unitprice;
    }

    public java.lang.String getRelateitem() {
        return this.relateitem;
    }

    public void setRelateitem(java.lang.String relateitem) {
        this.relateitem = relateitem;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("region", getRegion())
            .append("rewardid", getRewardid())
            .append("wayid", getWayid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof StdrewardutVO) ) return false;
        StdrewardutVO castOther = (StdrewardutVO) other;
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
		return StdrewardutlogVO.class;
	}

	public String getCityid() {
		return cityid;
	}

	public void setCityid(String cityid) {
		this.cityid = cityid;
	}

	public String getWayname() {
		return wayname;
	}

	public void setWayname(String wayname) {
		this.wayname = wayname;
	}

	public Short getCalcumode() {
		return calcumode;
	}

	public void setCalcumode(Short calcumode) {
		this.calcumode = calcumode;
	}

	public String getUniformtime() {
		return uniformtime;
	}

	public void setUniformtime(String uniformtime) {
		this.uniformtime = uniformtime;
	}

	public String getSetflag() {
		return setflag;
	}

	public void setSetflag(String setflag) {
		this.setflag = setflag;
	}

	public String getRewardname_51() {
		return rewardname_51;
	}

	public void setRewardname_51(String rewardname_51) {
		this.rewardname_51 = rewardname_51;
	}

	public String getRewardname_52() {
		return rewardname_52;
	}

	public void setRewardname_52(String rewardname_52) {
		this.rewardname_52 = rewardname_52;
	}

	public String getRewardname_53() {
		return rewardname_53;
	}

	public void setRewardname_53(String rewardname_53) {
		this.rewardname_53 = rewardname_53;
	}

	public String getStartdate_51() {
		return startdate_51;
	}

	public void setStartdate_51(String startdate_51) {
		this.startdate_51 = startdate_51;
	}

	public String getStartdate_52() {
		return startdate_52;
	}

	public void setStartdate_52(String startdate_52) {
		this.startdate_52 = startdate_52;
	}

	public String getStartdate_53() {
		return startdate_53;
	}

	public void setStartdate_53(String startdate_53) {
		this.startdate_53 = startdate_53;
	}

	public String getStopdate_51() {
		return stopdate_51;
	}

	public void setStopdate_51(String stopdate_51) {
		this.stopdate_51 = stopdate_51;
	}

	public String getStopdate_52() {
		return stopdate_52;
	}

	public void setStopdate_52(String stopdate_52) {
		this.stopdate_52 = stopdate_52;
	}

	public String getStopdate_53() {
		return stopdate_53;
	}

	public void setStopdate_53(String stopdate_53) {
		this.stopdate_53 = stopdate_53;
	}

	public Double getRewardstd_51() {
		return rewardstd_51;
	}

	public void setRewardstd_51(Double rewardstd_51) {
		this.rewardstd_51 = rewardstd_51;
	}

	public Double getRewardstd_52() {
		return rewardstd_52;
	}

	public void setRewardstd_52(Double rewardstd_52) {
		this.rewardstd_52 = rewardstd_52;
	}

	public Double getRewardstd_53() {
		return rewardstd_53;
	}

	public void setRewardstd_53(Double rewardstd_53) {
		this.rewardstd_53 = rewardstd_53;
	}

	public Double getRewardstdcity_51() {
		return rewardstdcity_51;
	}

	public void setRewardstdcity_51(Double rewardstdcity_51) {
		this.rewardstdcity_51 = rewardstdcity_51;
	}

	public Double getRewardstdcity_52() {
		return rewardstdcity_52;
	}

	public void setRewardstdcity_52(Double rewardstdcity_52) {
		this.rewardstdcity_52 = rewardstdcity_52;
	}

	public Double getRewardstdcity_53() {
		return rewardstdcity_53;
	}

	public void setRewardstdcity_53(Double rewardstdcity_53) {
		this.rewardstdcity_53 = rewardstdcity_53;
	}

	public Long getIntvmonth_51() {
		return intvmonth_51;
	}

	public void setIntvmonth_51(Long intvmonth_51) {
		this.intvmonth_51 = intvmonth_51;
	}

	public Long getIntvmonth_52() {
		return intvmonth_52;
	}

	public void setIntvmonth_52(Long intvmonth_52) {
		this.intvmonth_52 = intvmonth_52;
	}

	public Long getIntvmonth_53() {
		return intvmonth_53;
	}

	public void setIntvmonth_53(Long intvmonth_53) {
		this.intvmonth_53 = intvmonth_53;
	}

	public Long getIntvmonthcity_51() {
		return intvmonthcity_51;
	}

	public void setIntvmonthcity_51(Long intvmonthcity_51) {
		this.intvmonthcity_51 = intvmonthcity_51;
	}

	public Long getIntvmonthcity_52() {
		return intvmonthcity_52;
	}

	public void setIntvmonthcity_52(Long intvmonthcity_52) {
		this.intvmonthcity_52 = intvmonthcity_52;
	}

	public Long getIntvmonthcity_53() {
		return intvmonthcity_53;
	}

	public void setIntvmonthcity_53(Long intvmonthcity_53) {
		this.intvmonthcity_53 = intvmonthcity_53;
	}

	public Long getIntegralnum_52() {
		return integralnum_52;
	}

	public void setIntegralnum_52(Long integralnum_52) {
		this.integralnum_52 = integralnum_52;
	}

	public Long getIntegralnumcity_52() {
		return integralnumcity_52;
	}

	public void setIntegralnumcity_52(Long integralnumcity_52) {
		this.integralnumcity_52 = integralnumcity_52;
	}

	public Double getUnitprice_53() {
		return unitprice_53;
	}

	public void setUnitprice_53(Double unitprice_53) {
		this.unitprice_53 = unitprice_53;
	}

	public Double getUnitpricecity_53() {
		return unitpricecity_53;
	}

	public void setUnitpricecity_53(Double unitpricecity_53) {
		this.unitpricecity_53 = unitpricecity_53;
	}

	public Short getRewardtype_51() {
		return rewardtype_51;
	}

	public void setRewardtype_51(Short rewardtype_51) {
		this.rewardtype_51 = rewardtype_51;
	}

	public Short getRewardtype_52() {
		return rewardtype_52;
	}

	public void setRewardtype_52(Short rewardtype_52) {
		this.rewardtype_52 = rewardtype_52;
	}

	public Short getRewardtype_53() {
		return rewardtype_53;
	}

	public void setRewardtype_53(Short rewardtype_53) {
		this.rewardtype_53 = rewardtype_53;
	}

	public Long getRewardid_51() {
		return rewardid_51;
	}

	public void setRewardid_51(Long rewardid_51) {
		this.rewardid_51 = rewardid_51;
	}

	public Long getRewardid_52() {
		return rewardid_52;
	}

	public void setRewardid_52(Long rewardid_52) {
		this.rewardid_52 = rewardid_52;
	}

	public Long getRewardid_53() {
		return rewardid_53;
	}

	public void setRewardid_53(Long rewardid_53) {
		this.rewardid_53 = rewardid_53;
	}

}
