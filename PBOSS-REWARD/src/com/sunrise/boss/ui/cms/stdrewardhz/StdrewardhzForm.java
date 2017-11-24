/**
* auto-generated code
* Sun Feb 01 17:08:50 CST 2009
*/
package com.sunrise.boss.ui.cms.stdrewardhz;

import java.util.ArrayList;
import java.util.List;

import com.sunrise.boss.ui.base.BaseActionForm;

/**
 * <p>Title: StdrewardhzForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
public class StdrewardhzForm extends BaseActionForm {

	//stdrewardhz
    private java.lang.Long rewardid;
    private java.lang.String region;
    private java.lang.Short slv;
    private java.lang.Short years;
    private java.lang.Double lmtstd;
    private java.lang.Double citystd;
    private java.lang.String relateitem;
    
    //stdreward
    private String rewardname;
    private Short rewardproj;
    private Short rewardtype;
    private java.util.Date startdate;
    private java.util.Date stopdate;
    private String memo;
    private java.lang.Double health;
    
    //stdrewardlistvo
    private String _ne_rewardid;
    private String _sk_rewardname;
    private String _dnl_startdate;
    private String _dnm_startdate;
    private String _dnl_stopdate;
    private String _dnm_stopdate;
    private String _ne_rewardtype;

    //星级酬金列表缓存
	private List oldstarlist = new ArrayList();
	private List newstarlist = new ArrayList();
	private boolean isCity = false;
	private boolean isRelateitem = false;
	private boolean isHealth = false;
	
	// add by liuchao 20111029
	private int intvmonth;
    
    public int getIntvmonth() {
		return intvmonth;
	}

	public void setIntvmonth(int intvmonth) {
		this.intvmonth = intvmonth;
	}

	public String get_ne_rewardid() {
		return _ne_rewardid;
	}

	public void set_ne_rewardid(String _ne_rewardid) {
		this._ne_rewardid = _ne_rewardid;
	}

	public String get_sk_rewardname() {
		return _sk_rewardname;
	}

	public void set_sk_rewardname(String _sk_rewardname) {
		this._sk_rewardname = _sk_rewardname;
	}

	public String get_dnl_startdate() {
		return _dnl_startdate;
	}

	public void set_dnl_startdate(String _dnl_startdate) {
		this._dnl_startdate = _dnl_startdate;
	}

	public String get_dnm_startdate() {
		return _dnm_startdate;
	}

	public void set_dnm_startdate(String _dnm_startdate) {
		this._dnm_startdate = _dnm_startdate;
	}

	public String get_dnl_stopdate() {
		return _dnl_stopdate;
	}

	public void set_dnl_stopdate(String _dnl_stopdate) {
		this._dnl_stopdate = _dnl_stopdate;
	}

	public String get_dnm_stopdate() {
		return _dnm_stopdate;
	}

	public void set_dnm_stopdate(String _dnm_stopdate) {
		this._dnm_stopdate = _dnm_stopdate;
	}

	public String get_ne_rewardtype() {
		return _ne_rewardtype;
	}

	public void set_ne_rewardtype(String _ne_rewardtype) {
		this._ne_rewardtype = _ne_rewardtype;
	}

	public java.lang.Long getRewardid(){
        return rewardid;
    }

    public void setRewardid(java.lang.Long rewardid){
        this.rewardid = rewardid;
    }
    public java.lang.String getRegion(){
        return region;
    }

    public void setRegion(java.lang.String region){
        this.region = region;
    }
    public java.lang.Short getSlv(){
        return slv;
    }

    public void setSlv(java.lang.Short slv){
        this.slv = slv;
    }
    public java.lang.Short getYears(){
        return years;
    }

    public void setYears(java.lang.Short years){
        this.years = years;
    }
    public java.lang.Double getLmtstd(){
        return lmtstd;
    }

    public void setLmtstd(java.lang.Double lmtstd){
        this.lmtstd = lmtstd;
    }
    public java.lang.Double getCitystd(){
        return citystd;
    }

    public void setCitystd(java.lang.Double citystd){
        this.citystd = citystd;
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

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public List getOldstarlist() {
		return oldstarlist;
	}

	public void setOldstarlist(List oldstarlist) {
		this.oldstarlist = oldstarlist;
	}

	public List getNewstarlist() {
		return newstarlist;
	}

	public void setNewstarlist(List newstarlist) {
		this.newstarlist = newstarlist;
	}

	public boolean isCity() {
		return isCity;
	}

	public void setCity(boolean isCity) {
		this.isCity = isCity;
	}

	public boolean getIsRelateitem() {
		return isRelateitem;
	}

	public void setIsRelateitem(boolean isRelateitem) {
		this.isRelateitem = isRelateitem;
	}

	public java.lang.String getRelateitem() {
		return relateitem;
	}

	public void setRelateitem(java.lang.String relateitem) {
		this.relateitem = relateitem;
	}

	public void setIsHealth(boolean isHealth) {
		this.isHealth = isHealth;
	}
	
	public boolean getIsHealth() {
		return isHealth;
	}

	public java.lang.Double getHealth() {
		return health;
	}

	public void setHealth(java.lang.Double health) {
		this.health = health;
	}

	public void setRelateitem(boolean isRelateitem) {
		this.isRelateitem = isRelateitem;
	}

}
