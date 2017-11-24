/**
 * auto-generated code
 * Fri Feb 15 15:25:15 CST 2008
 */
package com.sunrise.boss.ui.cms.reward.busiwayrel;

import com.sunrise.boss.ui.base.BaseActionForm;

/**
 * <p>
 * Title: BusiwayrelForm
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2009
 * </p>
 * <p>
 * Company: Maywide Tech Ltd.
 * </p>
 * 
 * @author li zhaoliang
 * @version 1.0
 */
public class BusiwayrelForm extends BaseActionForm {

	// VO
	private String opnid;

	private String wayid;

	// ListVO
	private String _se_opnid;

	private String _se_wayid;

	private String oprType;

	public String get_se_opnid() {
		return _se_opnid;
	}

	public void set_se_opnid(String _se_opnid) {
		this._se_opnid = _se_opnid;
	}

	public String get_se_wayid() {
		return _se_wayid;
	}

	public void set_se_wayid(String _se_wayid) {
		this._se_wayid = _se_wayid;
	}

	public String getOpnid() {
		return opnid;
	}

	public void setOpnid(String opnid) {
		this.opnid = opnid;
	}

	public String getWayid() {
		return wayid;
	}

	public void setWayid(String wayid) {
		this.wayid = wayid;
	}

	public String getOprType() {
		return oprType;
	}

	public void setOprType(String oprType) {
		this.oprType = oprType;
	}

}
