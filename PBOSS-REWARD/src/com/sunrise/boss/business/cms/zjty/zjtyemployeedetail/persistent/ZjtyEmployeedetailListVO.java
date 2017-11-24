/**
* auto-generated code
* Fri Feb 13 09:03:29 CST 2009
*/
package com.sunrise.boss.business.cms.zjty.zjtyemployeedetail.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: EmployeedetailListVO</p>
 * <p>Description: Query Params Object for ZjtyEmployeedetailDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public class ZjtyEmployeedetailListVO extends BaseListVO {
	private String _se_chainhead;
	
	private String _se_wayid;
	
	private String _se_oprcode;
	
	private String _se_station;

	public String get_se_station() {
		return _se_station;
	}

	public void set_se_station(String _se_station) {
		this._se_station = _se_station;
	}

	public String get_se_chainhead() {
		return _se_chainhead;
	}

	public void set_se_chainhead(String _se_chainhead) {
		this._se_chainhead = _se_chainhead;
	}

	public String get_se_oprcode() {
		return _se_oprcode;
	}

	public void set_se_oprcode(String _se_oprcode) {
		this._se_oprcode = _se_oprcode;
	}

	public String get_se_wayid() {
		return _se_wayid;
	}

	public void set_se_wayid(String _se_wayid) {
		this._se_wayid = _se_wayid;
	}

}
