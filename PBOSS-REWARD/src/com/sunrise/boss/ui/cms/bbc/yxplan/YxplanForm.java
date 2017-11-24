/**
 * auto-generated code
 * Tue May 05 11:03:52 CST 2009
 */
package com.sunrise.boss.ui.cms.bbc.yxplan;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.bbc.yxplan.persistent.YxplanVO;

/**
 * <p>
 * Title: YxplanForm
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
 * @author Jerimy
 * @version 1.0
 */
public class YxplanForm extends BaseActionForm {
	private String _se_opnid;

	private String _ne_yxplanid;

	private String _sk_yxplanname;

	private String _sk_opnname;

	private String opnid;

	private Long yxplanid;

	private Double wrapfee;

	private String cityid;

	public String get_se_opnid() {
		return _se_opnid;
	}

	public void set_se_opnid(String _se_opnid) {
		this._se_opnid = _se_opnid;
	}

	public String get_ne_yxplanid() {
		return _ne_yxplanid;
	}

	public void set_ne_yxplanid(String _ne_yxplanid) {
		this._ne_yxplanid = _ne_yxplanid;
	}

	public String getOpnid() {
		return opnid;
	}

	public void setOpnid(String opnid) {
		this.opnid = opnid;
	}

	public Long getYxplanid() {
		return yxplanid;
	}

	public void setYxplanid(Long yxplanid) {
		this.yxplanid = yxplanid;
	}

	public Double getWrapfee() {
		return wrapfee;
	}

	public void setWrapfee(Double wrapfee) {
		this.wrapfee = wrapfee;
	}

	public String getCityid() {
		return cityid;
	}

	public void setCityid(String cityid) {
		this.cityid = cityid;
	}

	public String get_sk_opnname() {
		return _sk_opnname;
	}

	public void set_sk_opnname(String _sk_opnname) {
		this._sk_opnname = _sk_opnname;
	}

	public String get_sk_yxplanname() {
		return _sk_yxplanname;
	}

	public void set_sk_yxplanname(String _sk_yxplanname) {
		this._sk_yxplanname = _sk_yxplanname;
	}

}
