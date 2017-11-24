/**
* auto-generated code
* Tue Aug 21 08:42:57 CST 2012
*/
package com.sunrise.boss.ui.cms.monitor;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.monitor.persistent.MonitorVO;

/**
 * <p>Title: MonitorForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Shi Xiaolong
 * @version 1.0
 */
public class MonitorForm extends BaseActionForm {

	private java.lang.String abatchno;
    private java.lang.Short cityid;
    private java.lang.String rewardmonth;
    private java.lang.String countyid;
    private java.lang.String upperopnid;
    private java.util.Date lastdate;
    private java.lang.Short status;
    private java.lang.String conoprcode;
    private java.util.Date conoptime;
    private String paymonth;

    private String _ne_cityid;
    private String _dnm_conoptime;
    private String _dnl_conoptime;
    private String _se_countyid;
    //判断是否有令牌CH_ADT_MONITOR_VIEW的结果，由此令牌的工号允许查询所有地市的出帐情况
    //0表示无，只能查看工号所属地市；1表示有令牌，可以查看全省
    //-1为默认值，表示尚未检查令牌权限
    private Integer provpermited = -1;
    //判断是否具有令牌CH_ADT_MONITOR_CON，有则可以看到整个分公司下拉框
    private Integer citypermited = -1;
    //p判断是否具有令牌CH_ADT_ADJUST_COUNTY，有则分公司下拉框只能看到登录工号所属分公司
    private Integer countypermited = -1;
    private String _rewardmonth;
    private String _countyid;
    private String _upperopnid;
    private String _lastdate2;
    
    private boolean supportPaymonth = false;
    
    private String _paymonth;
		
	public String getPaymonth() {
		return paymonth;
	}

	public void setPaymonth(String paymonth) {
		this.paymonth = paymonth;
	}

	public String get_paymonth() {
		return _paymonth;
	}

	public void set_paymonth(String _paymonth) {
		this._paymonth = _paymonth;
	}

	public boolean isSupportPaymonth() {
		return supportPaymonth;
	}

	public void setSupportPaymonth(boolean supportPaymonth) {
		this.supportPaymonth = supportPaymonth;
	}
    
	public String get_se_countyid() {
		return _se_countyid;
	}

	public void set_se_countyid(String _se_countyid) {
		this._se_countyid = _se_countyid;
	}

	public String get_lastdate2() {
		return _lastdate2;
	}

	public Integer getCitypermited() {
		return citypermited;
	}

	public void setCitypermited(Integer citypermited) {
		this.citypermited = citypermited;
	}

	public Integer getCountypermited() {
		return countypermited;
	}

	public void setCountypermited(Integer countypermited) {
		this.countypermited = countypermited;
	}

	public void set_lastdate2(String _lastdate2) {
		this._lastdate2 = _lastdate2;
	}

	public String get_rewardmonth() {
		return _rewardmonth;
	}

	public void set_rewardmonth(String _rewardmonth) {
		this._rewardmonth = _rewardmonth;
	}

	public String get_countyid() {
		return _countyid;
	}

	public void set_countyid(String _countyid) {
		this._countyid = _countyid;
	}

	public String get_upperopnid() {
		return _upperopnid;
	}

	public void set_upperopnid(String _upperopnid) {
		this._upperopnid = _upperopnid;
	}

	public Integer getProvpermited() {
		return provpermited;
	}

	public void setProvpermited(Integer provpermited) {
		this.provpermited = provpermited;
	}

	public java.lang.String getAbatchno() {
		return abatchno;
	}

	public void setAbatchno(java.lang.String abatchno) {
		this.abatchno = abatchno;
	}

	public java.lang.Short getCityid() {
		return cityid;
	}

	public void setCityid(java.lang.Short cityid) {
		this.cityid = cityid;
	}

	public java.lang.String getRewardmonth() {
		return rewardmonth;
	}

	public void setRewardmonth(java.lang.String rewardmonth) {
		this.rewardmonth = rewardmonth;
	}

	public java.lang.String getCountyid() {
		return countyid;
	}

	public void setCountyid(java.lang.String countyid) {
		this.countyid = countyid;
	}

	public java.lang.String getUpperopnid() {
		return upperopnid;
	}

	public void setUpperopnid(java.lang.String upperopnid) {
		this.upperopnid = upperopnid;
	}

	public java.util.Date getLastdate() {
		return lastdate;
	}

	public void setLastdate(java.util.Date lastdate) {
		this.lastdate = lastdate;
	}

	public java.lang.Short getStatus() {
		return status;
	}

	public void setStatus(java.lang.Short status) {
		this.status = status;
	}

	public java.lang.String getConoprcode() {
		return conoprcode;
	}

	public void setConoprcode(java.lang.String conoprcode) {
		this.conoprcode = conoprcode;
	}

	public java.util.Date getConoptime() {
		return conoptime;
	}

	public void setConoptime(java.util.Date conoptime) {
		this.conoptime = conoptime;
	}

	public String get_ne_cityid() {
		return _ne_cityid;
	}

	public void set_ne_cityid(String _ne_cityid) {
		this._ne_cityid = _ne_cityid;
	}

	public String get_dnm_conoptime() {
		return _dnm_conoptime;
	}

	public void set_dnm_conoptime(String _dnm_conoptime) {
		this._dnm_conoptime = _dnm_conoptime;
	}

	public String get_dnl_conoptime() {
		return _dnl_conoptime;
	}

	public void set_dnl_conoptime(String _dnl_conoptime) {
		this._dnl_conoptime = _dnl_conoptime;
	}
}
