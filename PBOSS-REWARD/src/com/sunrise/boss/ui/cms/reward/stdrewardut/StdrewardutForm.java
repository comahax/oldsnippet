package com.sunrise.boss.ui.cms.reward.stdrewardut;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.cms.commons.CMSUtils;

/**
 * <p>
 * Title: StdrewardutForm
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2007
 * </p>
 * <p>
 * Company: SUNRISE Tech Ltd.
 * </p>
 * 
 * @author LiZhaoLiang
 * @version 1.0
 */
public class StdrewardutForm extends BaseActionForm {
	
	private String region;

    private Long rewardid;
    
    private Long rewardid_51;
    
    private Long rewardid_52;
    
    private Long rewardid_53;
    
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
    
    private Long integralnum_51;
    
    private Long integralnum_52;
    
    private Long integralnum_53;
    
    private Long integralnumcity_51;
    
    private Long integralnumcity_52;
    
    private Long integralnumcity_53;

    private Double unitprice_51;
    
    private Double unitprice_52;
    
    private Double unitprice_53;
    
    private Double unitpricecity_51;
    
    private Double unitpricecity_52;
    
    private Double unitpricecity_53;
    
    private Short rewardtype_51;
    
    private Short rewardtype_52;
    
    private Short rewardtype_53;
    
	private String[] citys = CMSUtils.getIDorname("region", "name");

	private String[] cityvalues = CMSUtils.getIDorname("region", "id");

	private String[] selectcity;

    private String wayid;

    private Short islimt;

    private Double rewardstd;

    private Long intvmonth;

    private Long integralnum;

    private Double unitprice;

    private String relateitem;
    
    private String _se_wayid;
	
	private String _sk_rewardname;
	
	private String _ne_rewardid;
	
	private String _se_region;
	
	private String _ne_rewardtype;
	
	private String _dnl_startdate;
	
	private String _dnm_startdate;
	
	private String _dnl_stopdate;
	
	private String _dnm_stopdate;
	
	private String _ne_islimt;
	
	private String _sk_wayname;
	
	private String _snl_uniformtime;
	
	private String _snm_uniformtime;

	private String _se_cityid;
	
	private String uniformtime;
	
	private String calcumode;
	
	private String wayname;
	
	
	private String ruleitemids[];
    private String paramervalues[];
    
	
	public String[] getRuleitemids() {
		return ruleitemids;
	}

	public void setRuleitemids(String[] ruleitemids) {
		this.ruleitemids = ruleitemids;
	}

	public String[] getParamervalues() {
		return paramervalues;
	}

	public void setParamervalues(String[] paramervalues) {
		this.paramervalues = paramervalues;
	}

	public String getWayname() {
		return wayname;
	}

	public void setWayname(String wayname) {
		this.wayname = wayname;
	}

	public String getCalcumode() {
		return calcumode;
	}

	public void setCalcumode(String calcumode) {
		this.calcumode = calcumode;
	}

	public String getUniformtime() {
		return uniformtime;
	}

	public void setUniformtime(String uniformtime) {
		this.uniformtime = uniformtime;
	}

	public Long getIntegralnum() {
		return integralnum;
	}

	public void setIntegralnum(Long integralnum) {
		this.integralnum = integralnum;
	}

	public Long getIntvmonth() {
		return intvmonth;
	}

	public void setIntvmonth(Long intvmonth) {
		this.intvmonth = intvmonth;
	}

	public Short getIslimt() {
		return islimt;
	}

	public void setIslimt(Short islimt) {
		this.islimt = islimt;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getRelateitem() {
		return relateitem;
	}

	public void setRelateitem(String relateitem) {
		this.relateitem = relateitem;
	}

	public Long getRewardid() {
		return rewardid;
	}

	public void setRewardid(Long rewardid) {
		this.rewardid = rewardid;
	}

	public Double getRewardstd() {
		return rewardstd;
	}

	public void setRewardstd(Double rewardstd) {
		this.rewardstd = rewardstd;
	}

	public Double getUnitprice() {
		return unitprice;
	}

	public void setUnitprice(Double unitprice) {
		this.unitprice = unitprice;
	}

	public String getWayid() {
		return wayid;
	}

	public void setWayid(String wayid) {
		this.wayid = wayid;
	}

	public String get_dnm_startdate() {
		return _dnm_startdate;
	}

	public void set_dnm_startdate(String _dnm_startdate) {
		this._dnm_startdate = _dnm_startdate;
	}

	public String get_dnm_stopdate() {
		return _dnm_stopdate;
	}

	public void set_dnm_stopdate(String _dnm_stopdate) {
		this._dnm_stopdate = _dnm_stopdate;
	}

	public String get_dnl_startdate() {
		return _dnl_startdate;
	}

	public void set_dnl_startdate(String _dnl_startdate) {
		this._dnl_startdate = _dnl_startdate;
	}

	public String get_dnl_stopdate() {
		return _dnl_stopdate;
	}

	public void set_dnl_stopdate(String _dnl_stopdate) {
		this._dnl_stopdate = _dnl_stopdate;
	}

	public String get_ne_rewardid() {
		return _ne_rewardid;
	}

	public void set_ne_rewardid(String _ne_rewardid) {
		this._ne_rewardid = _ne_rewardid;
	}

	public String get_ne_rewardtype() {
		return _ne_rewardtype;
	}

	public void set_ne_rewardtype(String _ne_rewardtype) {
		this._ne_rewardtype = _ne_rewardtype;
	}

	public String get_se_region() {
		return _se_region;
	}

	public void set_se_region(String _se_region) {
		this._se_region = _se_region;
	}

	public String get_se_wayid() {
		return _se_wayid;
	}

	public void set_se_wayid(String _se_wayid) {
		this._se_wayid = _se_wayid;
	}

	public String get_sk_rewardname() {
		return _sk_rewardname;
	}

	public void set_sk_rewardname(String _sk_rewardname) {
		this._sk_rewardname = _sk_rewardname;
	}

	public Long getIntegralnum_51() {
		return integralnum_51;
	}

	public void setIntegralnum_51(Long integralnum_51) {
		this.integralnum_51 = integralnum_51;
	}

	public Long getIntegralnum_52() {
		return integralnum_52;
	}

	public void setIntegralnum_52(Long integralnum_52) {
		this.integralnum_52 = integralnum_52;
	}

	public Long getIntegralnum_53() {
		return integralnum_53;
	}

	public void setIntegralnum_53(Long integralnum_53) {
		this.integralnum_53 = integralnum_53;
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

	public Double getUnitprice_51() {
		return unitprice_51;
	}

	public void setUnitprice_51(Double unitprice_51) {
		this.unitprice_51 = unitprice_51;
	}

	public Double getUnitprice_52() {
		return unitprice_52;
	}

	public void setUnitprice_52(Double unitprice_52) {
		this.unitprice_52 = unitprice_52;
	}

	public Double getUnitprice_53() {
		return unitprice_53;
	}

	public void setUnitprice_53(Double unitprice_53) {
		this.unitprice_53 = unitprice_53;
	}

	public String[] getCitys() {
		return citys;
	}

	public void setCitys(String[] citys) {
		this.citys = citys;
	}

	public String[] getCityvalues() {
		return cityvalues;
	}

	public void setCityvalues(String[] cityvalues) {
		this.cityvalues = cityvalues;
	}

	public String[] getSelectcity() {
		return selectcity;
	}

	public void setSelectcity(String[] selectcity) {
		this.selectcity = selectcity;
	}

	public String get_ne_islimt() {
		return _ne_islimt;
	}

	public void set_ne_islimt(String _ne_islimt) {
		this._ne_islimt = _ne_islimt;
	}

	public String get_sk_wayname() {
		return _sk_wayname;
	}

	public void set_sk_wayname(String _sk_wayname) {
		this._sk_wayname = _sk_wayname;
	}

	public String get_snl_uniformtime() {
		return _snl_uniformtime;
	}

	public void set_snl_uniformtime(String _snl_uniformtime) {
		this._snl_uniformtime = _snl_uniformtime;
	}

	public String get_snm_uniformtime() {
		return _snm_uniformtime;
	}

	public void set_snm_uniformtime(String _snm_uniformtime) {
		this._snm_uniformtime = _snm_uniformtime;
	}

	public String get_se_cityid() {
		return _se_cityid;
	}

	public void set_se_cityid(String _se_cityid) {
		this._se_cityid = _se_cityid;
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

	public Long getIntegralnumcity_51() {
		return integralnumcity_51;
	}

	public void setIntegralnumcity_51(Long integralnumcity_51) {
		this.integralnumcity_51 = integralnumcity_51;
	}

	public Long getIntegralnumcity_52() {
		return integralnumcity_52;
	}

	public void setIntegralnumcity_52(Long integralnumcity_52) {
		this.integralnumcity_52 = integralnumcity_52;
	}

	public Long getIntegralnumcity_53() {
		return integralnumcity_53;
	}

	public void setIntegralnumcity_53(Long integralnumcity_53) {
		this.integralnumcity_53 = integralnumcity_53;
	}

	public Double getUnitpricecity_51() {
		return unitpricecity_51;
	}

	public void setUnitpricecity_51(Double unitpricecity_51) {
		this.unitpricecity_51 = unitpricecity_51;
	}

	public Double getUnitpricecity_52() {
		return unitpricecity_52;
	}

	public void setUnitpricecity_52(Double unitpricecity_52) {
		this.unitpricecity_52 = unitpricecity_52;
	}

	public Double getUnitpricecity_53() {
		return unitpricecity_53;
	}

	public void setUnitpricecity_53(Double unitpricecity_53) {
		this.unitpricecity_53 = unitpricecity_53;
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
