/**
* auto-generated code
* Tue Dec 20 12:00:28 CST 2011
*/
package com.sunrise.boss.ui.cms.chadtbusitoapprove;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.chadtbusitoapprove.persistent.ChAdtBusitoapproveVO;

/**
 * <p>Title: ChAdtBusitoapproveForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author limin
 * @version 1.0
 */
public class ChAdtBusitoapproveForm extends BaseActionForm {

    private java.lang.String approveid;
    private java.lang.String batchid;
    private java.lang.String opnid;
    private java.lang.String opnname;
    private java.lang.String rewardtype;
    private java.lang.String region;
    private java.lang.String isslv;
    private java.lang.String slv;
    private java.util.Date startdate;
    private java.util.Date enddate;
    private java.lang.String acctype;
    private java.lang.Double rewardstd;
    private java.lang.Integer intvmonth;
    private java.lang.String isprov;
    private java.lang.String ruleinfo;
    private java.lang.String ruledesc;
    private java.lang.Short isslvlev;
    private java.lang.Short slvlev;
    private java.lang.Double citystd;
    private java.lang.Double countrystd;
    private java.lang.Double cityaccountlimit;
    private java.lang.Double countyaccountlimit;
    private java.lang.Double citycorelimit;
    private java.lang.Double countycorelimit;
    private java.lang.Short percentage;
    private java.lang.Short years;
    private java.util.Date apptime;
    private java.util.Date systemdate;
    private java.util.Date addopntime;

    private String _se_approveid;
    private String _se_batchid;
    private String _se_opnid;
    private String _se_rewardtype;
    private String _se_region;
    private String _dnm_apptime;
    private String _dnl_apptime;


    private String currentbatchid;
    public String getCurrentbatchid() {
		return currentbatchid;
	}

	public void setCurrentbatchid(String currentbatchid) {
		this.currentbatchid = currentbatchid;
	}

	public java.lang.String getApproveid(){
        return approveid;
    }

    public void setApproveid(java.lang.String approveid){
        this.approveid = approveid;
    }
    public java.lang.String getBatchid(){
        return batchid;
    }

    public void setBatchid(java.lang.String batchid){
        this.batchid = batchid;
    }
    public java.lang.String getOpnid(){
        return opnid;
    }

    public void setOpnid(java.lang.String opnid){
        this.opnid = opnid;
    }
    public java.lang.String getOpnname(){
        return opnname;
    }

    public void setOpnname(java.lang.String opnname){
        this.opnname = opnname;
    }
    public java.lang.String getRewardtype(){
        return rewardtype;
    }

    public void setRewardtype(java.lang.String rewardtype){
        this.rewardtype = rewardtype;
    }
    public java.lang.String getRegion(){
        return region;
    }

    public void setRegion(java.lang.String region){
        this.region = region;
    }
    public java.lang.String getIsslv(){
        return isslv;
    }

    public void setIsslv(java.lang.String isslv){
        this.isslv = isslv;
    }
    public java.lang.String getSlv(){
        return slv;
    }

    public void setSlv(java.lang.String slv){
        this.slv = slv;
    }
    public java.util.Date getStartdate(){
        return startdate;
    }

    public void setStartdate(java.util.Date startdate){
        this.startdate = startdate;
    }
    public java.util.Date getEnddate(){
        return enddate;
    }

    public void setEnddate(java.util.Date enddate){
        this.enddate = enddate;
    }
    public java.lang.String getAcctype(){
        return acctype;
    }

    public void setAcctype(java.lang.String acctype){
        this.acctype = acctype;
    }
    public java.lang.Double getRewardstd(){
        return rewardstd;
    }

    public void setRewardstd(java.lang.Double rewardstd){
        this.rewardstd = rewardstd;
    }
    public java.lang.Integer getIntvmonth(){
        return intvmonth;
    }

    public void setIntvmonth(java.lang.Integer intvmonth){
        this.intvmonth = intvmonth;
    }
    public java.lang.String getIsprov(){
        return isprov;
    }

    public void setIsprov(java.lang.String isprov){
        this.isprov = isprov;
    }
    public java.lang.String getRuleinfo(){
        return ruleinfo;
    }

    public void setRuleinfo(java.lang.String ruleinfo){
        this.ruleinfo = ruleinfo;
    }
    public java.lang.String getRuledesc(){
        return ruledesc;
    }

    public void setRuledesc(java.lang.String ruledesc){
        this.ruledesc = ruledesc;
    }
    public java.lang.Short getIsslvlev(){
        return isslvlev;
    }

    public void setIsslvlev(java.lang.Short isslvlev){
        this.isslvlev = isslvlev;
    }
    public java.lang.Short getSlvlev(){
        return slvlev;
    }

    public void setSlvlev(java.lang.Short slvlev){
        this.slvlev = slvlev;
    }
    public java.lang.Double getCitystd(){
        return citystd;
    }

    public void setCitystd(java.lang.Double citystd){
        this.citystd = citystd;
    }
    public java.lang.Double getCountrystd(){
        return countrystd;
    }

    public void setCountrystd(java.lang.Double countrystd){
        this.countrystd = countrystd;
    }
    public java.lang.Double getCityaccountlimit(){
        return cityaccountlimit;
    }

    public void setCityaccountlimit(java.lang.Double cityaccountlimit){
        this.cityaccountlimit = cityaccountlimit;
    }
    public java.lang.Double getCountyaccountlimit(){
        return countyaccountlimit;
    }

    public void setCountyaccountlimit(java.lang.Double countyaccountlimit){
        this.countyaccountlimit = countyaccountlimit;
    }
    public java.lang.Double getCitycorelimit(){
        return citycorelimit;
    }

    public void setCitycorelimit(java.lang.Double citycorelimit){
        this.citycorelimit = citycorelimit;
    }
    public java.lang.Double getCountycorelimit(){
        return countycorelimit;
    }

    public void setCountycorelimit(java.lang.Double countycorelimit){
        this.countycorelimit = countycorelimit;
    }
    public java.lang.Short getPercentage(){
        return percentage;
    }

    public void setPercentage(java.lang.Short percentage){
        this.percentage = percentage;
    }
    public java.lang.Short getYears(){
        return years;
    }

    public void setYears(java.lang.Short years){
        this.years = years;
    }
    public java.util.Date getApptime(){
        return apptime;
    }

    public void setApptime(java.util.Date apptime){
        this.apptime = apptime;
    }
    public java.util.Date getSystemdate(){
        return systemdate;
    }

    public void setSystemdate(java.util.Date systemdate){
        this.systemdate = systemdate;
    }
    public java.util.Date getAddopntime(){
        return addopntime;
    }

    public void setAddopntime(java.util.Date addopntime){
        this.addopntime = addopntime;
    }

   
    public String get_se_approveid() {
		return _se_approveid;
	}

	public void set_se_approveid(String _se_approveid) {
		this._se_approveid = _se_approveid;
	}

	public String get_se_batchid(){
        return _se_batchid;
    }

    public void set_se_batchid(String _se_batchid){
        this._se_batchid = _se_batchid;
    }
    public String get_se_opnid(){
        return _se_opnid;
    }

    public void set_se_opnid(String _se_opnid){
        this._se_opnid = _se_opnid;
    }
    public String get_se_rewardtype(){
        return _se_rewardtype;
    }

    public void set_se_rewardtype(String _se_rewardtype){
        this._se_rewardtype = _se_rewardtype;
    }
    public String get_se_region(){
        return _se_region;
    }

    public void set_se_region(String _se_region){
        this._se_region = _se_region;
    }
    public String get_dnm_apptime(){
        return _dnm_apptime;
    }

    public void set_dnm_apptime(String _dnm_apptime){
        this._dnm_apptime = _dnm_apptime;
    }
    public String get_dnl_apptime(){
        return _dnl_apptime;
    }

    public void set_dnl_apptime(String _dnl_apptime){
        this._dnl_apptime = _dnl_apptime;
    }

}
