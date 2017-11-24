package com.gmcc.pboss.business.reward.setcardlog;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>
 * Title: PaywaylogDBParam
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2010
 * </p>
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author lej
 * @version 1.0
 */
public class SetcardlogDBParam extends DBQueryParam {

	private String _se_cityid;
	private String _se_wayid;

	private String _ne_seq;

	public String get_se_cityid() {
		return _se_cityid;
	}

	public void set_se_cityid(String _se_cityid) {
		this._se_cityid = _se_cityid;
	}

	public String get_se_wayid() {
		return _se_wayid;
	}

	public void set_se_wayid(String _se_wayid) {
		this._se_wayid = _se_wayid;
	}

	public String get_ne_seq() {
		return _ne_seq;
	}

	public void set_ne_seq(String _ne_seq) {
		this._ne_seq = _ne_seq;
	}

}
