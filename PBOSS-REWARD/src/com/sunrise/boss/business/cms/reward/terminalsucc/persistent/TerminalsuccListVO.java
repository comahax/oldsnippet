/**
* auto-generated code
* Fri Apr 09 12:40:50 CST 2010
*/
package com.sunrise.boss.business.cms.reward.terminalsucc.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: TerminalsuccListVO</p>
 * <p>Description: Query Params Object for TerminalsuccDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public class TerminalsuccListVO extends BaseListVO {

	private String _se_cityid;
	
	private String _se_comid;
	
	private String _se_wayid;
	
	private String _se_calcmonth;
	
	private String _se_chainhead;

	public String get_se_calcmonth() {
		return _se_calcmonth;
	}

	public void set_se_calcmonth(String _se_calcmonth) {
		this._se_calcmonth = _se_calcmonth;
	}

	public String get_se_chainhead() {
		return _se_chainhead;
	}

	public void set_se_chainhead(String _se_chainhead) {
		this._se_chainhead = _se_chainhead;
	}

	public String get_se_cityid() {
		return _se_cityid;
	}

	public void set_se_cityid(String _se_cityid) {
		this._se_cityid = _se_cityid;
	}

	public String get_se_comid() {
		return _se_comid;
	}

	public void set_se_comid(String _se_comid) {
		this._se_comid = _se_comid;
	}

	public String get_se_wayid() {
		return _se_wayid;
	}

	public void set_se_wayid(String _se_wayid) {
		this._se_wayid = _se_wayid;
	}
	
}
