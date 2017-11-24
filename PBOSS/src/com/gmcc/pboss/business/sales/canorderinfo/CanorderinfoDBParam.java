/**
 * auto-generated code
 * Wed Aug 10 10:50:17 CST 2011
 */
package com.gmcc.pboss.business.sales.canorderinfo;

import java.util.Date;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: canorderinfoDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author dengxingxin
 * @version 1.0
 */
public class CanorderinfoDBParam extends DBQueryParam {
	private String _se_wayid;
	private String wayid;
	private Date begintime;
	private Date endtime;

	public String get_se_wayid() {
		return _se_wayid;
	}

	public void set_se_wayid(String _se_wayid) {
		this._se_wayid = _se_wayid;
	}

	public String getWayid() {
		return wayid;
	}

	public void setWayid(String wayid) {
		this.wayid = wayid;
	}

	public Date getBegintime() {
		return begintime;
	}

	public void setBegintime(Date begintime) {
		this.begintime = begintime;
	}

	public Date getEndtime() {
		return endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}
}
