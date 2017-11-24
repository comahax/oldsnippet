/**
 * auto-generated code
 * Wed Oct 28 16:03:20 CST 2009
 */
package com.gmcc.pboss.business.channel.wayapply;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: WayapplyDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
public class WayapplyDBParam extends DBQueryParam {
	private String _se_wayid;
	
	private String _sne_wayid;
	private String _se_latitude;

	private String _se_longtitude;

	public String get_se_wayid() {
		return _se_wayid;
	}

	public void set_se_wayid(String _se_wayid) {
		this._se_wayid = _se_wayid;
	}

	public String get_sne_wayid() {
		return _sne_wayid;
	}

	public void set_sne_wayid(String _sne_wayid) {
		this._sne_wayid = _sne_wayid;
	}

	public String get_se_latitude() {
		return _se_latitude;
	}

	public void set_se_latitude(String _se_latitude) {
		this._se_latitude = _se_latitude;
	}

	public String get_se_longtitude() {
		return _se_longtitude;
	}

	public void set_se_longtitude(String _se_longtitude) {
		this._se_longtitude = _se_longtitude;
	}

}
