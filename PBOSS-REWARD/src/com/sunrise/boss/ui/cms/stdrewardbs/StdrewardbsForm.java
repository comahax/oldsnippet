/**
 * auto-generated code
 * Fri Feb 01 18:12:16 CST 2008
 */
package com.sunrise.boss.ui.cms.stdrewardbs;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.cms.commons.CMSUtils;
import com.sunrise.boss.business.cms.stdrewardbs.persistent.StdrewardbsVO;

/**
 * <p>
 * Title: StdrewardbsForm
 * </p> 
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: Maywide Tech Ltd.
 * </p>
 * 
 * @author
 * @version 1.0
 */
public class StdrewardbsForm extends BaseActionForm { 
	private String _ne_rewardid;

	private String _se_region;

	private String _ne_islimt;

	private String _se_slv;

	private String _ne_citystd;

	private String _ne_countrystd;

	// private String _ne_rewardid;
	private String _sk_rewardname;

	private String _dnl_startdate;

	private String _dnm_stopdate;
	
	private String _snk_rewardid;

	private Long rewardid;

	private String region;

	private Short islimt;

	//private String slv;
	
	private String slvtc;
	
	private String starnum;
	
	private String star[] = { "1", "2", "3", "4", "5", "6" };

	private String[] seleteSlv = {};

	private Double citystd;

	private Double countrystd;
	
	private Double citystd2;

	private Double countrystd2;

	// private Long rewardid;
	private String rewardname;

	private Short rewardproj;

	private Short rewardtype;

	private java.util.Date startdate;

	private java.util.Date stopdate;

	private String memo;
	
	private String delstatus;
	
	private String neworedit;
	
	private Short checkacctype;
	private String[] acctypes = CMSUtils.getIDorname("CH_BSACCTYPE", "name");
	private String[] acctypevalues = CMSUtils.getIDorname("CH_BSACCTYPE", "id");
    private Short acctype;
    private Long basicsalenum;
    private Long topsalenum;
    private Double citystdlow;
    private Double countrystdlow;
    private Double citystdmid;
    private Double countrystdmid;
    private Double citystdtop;
    private Double countrystdtop;
	
	//用于页面做省级上限js展现
	private Double procitystd;
	private Double procountrystd;
	
	private Long probasicsalenum; 
	private Long protopsalenum;   
	private Double procitystdlow;   
	private Double procountrystdlow;
	private Double procitystdmid;   
	private Double procountrystdmid;
	private Double procitystdtop;   
	private Double procountrystdtop;
	
	private Double ttcitystd;
    private Double ttcountrystd;
    
    private Short intvmonth;
    
    // 新增字段 2011.4.23
    private Double mpcitystd;
    private Double mpcountrystd;
    private Double secitystd;
    private Double secountrystd;
    private String mpintvmonth;
    private String seintvmonth;
    
    //20110727添加
    private String ruleitemids[];
    private String paramervalues[];
    //20110921 add by liuchao
    private String ruleitemids0[];
    
    //add by liuchao 20111029
    private Long citycorelimit;
    private Long countycorelimit;
    private Long cityaccountlimit;
    private Long countyaccountlimit;
    
	public Long getCitycorelimit() {
		return citycorelimit;
	}

	public void setCitycorelimit(Long citycorelimit) {
		this.citycorelimit = citycorelimit;
	}

	public Long getCountycorelimit() {
		return countycorelimit;
	}

	public void setCountycorelimit(Long countycorelimit) {
		this.countycorelimit = countycorelimit;
	}

	public Long getCityaccountlimit() {
		return cityaccountlimit;
	}

	public void setCityaccountlimit(Long cityaccountlimit) {
		this.cityaccountlimit = cityaccountlimit;
	}

	public Long getCountyaccountlimit() {
		return countyaccountlimit;
	}

	public void setCountyaccountlimit(Long countyaccountlimit) {
		this.countyaccountlimit = countyaccountlimit;
	}

	public String[] getRuleitemids0() {
		return ruleitemids0;
	}

	public void setRuleitemids0(String[] ruleitemids0) {
		this.ruleitemids0 = ruleitemids0;
	}

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

	public String getDelstatus() {
		return delstatus;
	}

	public void setDelstatus(String delstatus) {
		this.delstatus = delstatus;
	}

	public String get_ne_rewardid() {
		return _ne_rewardid;
	}

	public void set_ne_rewardid(String _ne_rewardid) {
		this._ne_rewardid = _ne_rewardid;
	}

	public String get_se_region() {
		return _se_region;
	}

	public void set_se_region(String _se_region) {
		this._se_region = _se_region;
	}

	public String get_ne_islimt() {
		return _ne_islimt;
	}

	public void set_ne_islimt(String _ne_islimt) {
		this._ne_islimt = _ne_islimt;
	}

	public String get_se_slv() {
		return _se_slv;
	}

	public void set_se_slv(String _se_slv) {
		this._se_slv = _se_slv;
	}

	public String get_ne_citystd() {
		return _ne_citystd;
	}

	public void set_ne_citystd(String _ne_citystd) {
		this._ne_citystd = _ne_citystd;
	}

	public String get_ne_countrystd() {
		return _ne_countrystd;
	}

	public void set_ne_countrystd(String _ne_countrystd) {
		this._ne_countrystd = _ne_countrystd;
	}

	public Long getRewardid() {
		return rewardid;
	}

	public void setRewardid(Long rewardid) {
		this.rewardid = rewardid;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public Short getIslimt() {
		return islimt;
	}

	public void setIslimt(Short islimt) {
		this.islimt = islimt;
	}

	public Double getCitystd() {
		return citystd;
	}

	public void setCitystd(Double citystd) {
		this.citystd = citystd;
	}

	public Double getCountrystd() {
		return countrystd;
	}

	public void setCountrystd(Double countrystd) {
		this.countrystd = countrystd;
	}

	public String get_dnl_startdate() {
		return _dnl_startdate;
	}

	public void set_dnl_startdate(String _dnl_startdate) {
		this._dnl_startdate = _dnl_startdate;
	}

	public String get_dnm_stopdate() {
		return _dnm_stopdate;
	}

	public void set_dnm_stopdate(String _dnm_stopdate) {
		this._dnm_stopdate = _dnm_stopdate;
	}

	public String get_sk_rewardname() {
		return _sk_rewardname;
	}

	public void set_sk_rewardname(String _sk_rewardname) {
		this._sk_rewardname = _sk_rewardname;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
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

	public String[] getSeleteSlv() {
		return seleteSlv;
	}

	public void setSeleteSlv(String[] seleteSlv) {
		this.seleteSlv = seleteSlv;
	}

	public String[] getStar() {
		return star;
	}

	public void setStar(String[] star) {
		this.star = star;
	}
	public void setSlv(String slv) {
		if (slv != null && slv.length() != 0) {
			seleteSlv = new String[6];
			for (int i = 0; i < 6; i++) {
				if (i >= slv.length())
					return;
				seleteSlv[i] = slv.substring(i, i + 1).equals("0") ? ""
						: star[i];
			}
		}

	}

	public String getSlv() {
		String[] star = getStar();
		String[] seleteSlv = getSeleteSlv();
		StringBuffer slv = new StringBuffer();
		for (int i = 0; i < star.length; i++) {
			boolean equal = false;
			for (int j = 0; j < seleteSlv.length; j++) {
				if (star[i].equals(seleteSlv[j])) {
					slv.append("1");
					equal = true;
					break;
				}
			}
			if (!equal)
				slv.append("0");
		}
		return slv.toString();
	}

	public String getStarnum() {
		return starnum;
	}

	public void setStarnum(String starnum) {
		this.starnum = starnum;
	}

	public String getSlvtc() {
		return slvtc;
	}

	public void setSlvtc(String slvtc) {
		this.slvtc = slvtc;
	}

	public Double getCitystd2() {
		return citystd2;
	}

	public void setCitystd2(Double citystd2) {
		this.citystd2 = citystd2;
	}

	public Double getCountrystd2() {
		return countrystd2;
	}

	public void setCountrystd2(Double countrystd2) {
		this.countrystd2 = countrystd2;
	}

	public String getNeworedit() {
		return neworedit;
	}

	public void setNeworedit(String neworedit) {
		this.neworedit = neworedit;
	}

	public String get_snk_rewardid() {
		return _snk_rewardid;
	}

	public void set_snk_rewardid(String _snk_rewardid) {
		this._snk_rewardid = _snk_rewardid;
	}

	public Short getAcctype() {
		return acctype;
	}

	public void setAcctype(Short acctype) {
		this.acctype = acctype;
	}

	public Double getProcitystd() {
		return procitystd;
	}

	public void setProcitystd(Double procitystd) {
		this.procitystd = procitystd;
	}

	public Double getProcountrystd() {
		return procountrystd;
	}

	public void setProcountrystd(Double procountrystd) {
		this.procountrystd = procountrystd;
	}

	public Long getBasicsalenum() {
		return basicsalenum;
	}

	public void setBasicsalenum(Long basicsalenum) {
		this.basicsalenum = basicsalenum;
	}

	public Long getTopsalenum() {
		return topsalenum;
	}

	public void setTopsalenum(Long topsalenum) {
		this.topsalenum = topsalenum;
	}

	public Double getCitystdlow() {
		return citystdlow;
	}

	public void setCitystdlow(Double citystdlow) {
		this.citystdlow = citystdlow;
	}

	public Double getCountrystdlow() {
		return countrystdlow;
	}

	public void setCountrystdlow(Double countrystdlow) {
		this.countrystdlow = countrystdlow;
	}

	public Double getCitystdmid() {
		return citystdmid;
	}

	public void setCitystdmid(Double citystdmid) {
		this.citystdmid = citystdmid;
	}

	public Double getCountrystdmid() {
		return countrystdmid;
	}

	public void setCountrystdmid(Double countrystdmid) {
		this.countrystdmid = countrystdmid;
	}

	public Double getCitystdtop() {
		return citystdtop;
	}

	public void setCitystdtop(Double citystdtop) {
		this.citystdtop = citystdtop;
	}

	public Double getCountrystdtop() {
		return countrystdtop;
	}

	public void setCountrystdtop(Double countrystdtop) {
		this.countrystdtop = countrystdtop;
	}

	public String[] getAcctypes() {
		return acctypes;
	}

	public void setAcctypes(String[] acctypes) {
		this.acctypes = acctypes;
	}

	public String[] getAcctypevalues() {
		return acctypevalues;
	}

	public void setAcctypevalues(String[] acctypevalues) {
		this.acctypevalues = acctypevalues;
	}

	public Short getCheckacctype() {
		return acctype;
	}

	public void setCheckacctype(Short checkacctype) {
		this.checkacctype = checkacctype;
	}

	public Long getProbasicsalenum() {
		return probasicsalenum;
	}

	public void setProbasicsalenum(Long probasicsalenum) {
		this.probasicsalenum = probasicsalenum;
	}

	public Long getProtopsalenum() {
		return protopsalenum;
	}

	public void setProtopsalenum(Long protopsalenum) {
		this.protopsalenum = protopsalenum;
	}

	public Double getProcitystdlow() {
		return procitystdlow;
	}

	public void setProcitystdlow(Double procitystdlow) {
		this.procitystdlow = procitystdlow;
	}

	public Double getProcountrystdlow() {
		return procountrystdlow;
	}

	public void setProcountrystdlow(Double procountrystdlow) {
		this.procountrystdlow = procountrystdlow;
	}

	public Double getProcitystdmid() {
		return procitystdmid;
	}

	public void setProcitystdmid(Double procitystdmid) {
		this.procitystdmid = procitystdmid;
	}

	public Double getProcountrystdmid() {
		return procountrystdmid;
	}

	public void setProcountrystdmid(Double procountrystdmid) {
		this.procountrystdmid = procountrystdmid;
	}

	public Double getProcitystdtop() {
		return procitystdtop;
	}

	public void setProcitystdtop(Double procitystdtop) {
		this.procitystdtop = procitystdtop;
	}

	public Double getProcountrystdtop() {
		return procountrystdtop;
	}

	public void setProcountrystdtop(Double procountrystdtop) {
		this.procountrystdtop = procountrystdtop;
	}

	public Double getTtcitystd() {
		return ttcitystd;
	}

	public void setTtcitystd(Double ttcitystd) {
		this.ttcitystd = ttcitystd;
	}

	public Double getTtcountrystd() {
		return ttcountrystd;
	}

	public void setTtcountrystd(Double ttcountrystd) {
		this.ttcountrystd = ttcountrystd;
	}

	public Short getIntvmonth() {
		return intvmonth;
	}

	public void setIntvmonth(Short intvmonth) {
		this.intvmonth = intvmonth;
	}

	public Double getMpcitystd() {
		return mpcitystd;
	}

	public void setMpcitystd(Double mpcitystd) {
		this.mpcitystd = mpcitystd;
	}

	public Double getMpcountrystd() {
		return mpcountrystd;
	}

	public void setMpcountrystd(Double mpcountrystd) {
		this.mpcountrystd = mpcountrystd;
	}

	public Double getSecitystd() {
		return secitystd;
	}

	public void setSecitystd(Double secitystd) {
		this.secitystd = secitystd;
	}

	public Double getSecountrystd() {
		return secountrystd;
	}

	public void setSecountrystd(Double secountrystd) {
		this.secountrystd = secountrystd;
	}

	public String getMpintvmonth() {
		return mpintvmonth;
	}

	public void setMpintvmonth(String mpintvmonth) {
		this.mpintvmonth = mpintvmonth;
	}

	public String getSeintvmonth() {
		return seintvmonth;
	}

	public void setSeintvmonth(String seintvmonth) {
		this.seintvmonth = seintvmonth;
	}

}
