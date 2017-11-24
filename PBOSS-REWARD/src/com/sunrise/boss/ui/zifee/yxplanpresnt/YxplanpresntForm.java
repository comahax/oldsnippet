/**
 * auto-generated code
 * Tue Sep 18 15:52:13 CST 2007
 */
package com.sunrise.boss.ui.zifee.yxplanpresnt;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.zifee.yxplanpresnt.persistent.YxplanpresntVO;

/**
 * <p>
 * Title: YxplanpresntForm
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
 * @author
 * @version 1.0
 */
public class YxplanpresntForm extends BaseActionForm {
	/**list * */
	private String _ne_yxplanid;

	private String _ne_acctid;

	private String _ne_presentinterval;

	private String _ne_presentcycles;

	private String _ne_presentrate;

	private String _ne_eboxunitid;

	private Long yxplanid;

	private Long acctid;

	private Integer presentinterval;

	private Integer presentcycles;

	private Float presentrate;

	private Long eboxunitid;

	public Long getAcctid() {
		return acctid;
	}

	public void setAcctid(Long acctid) {
		this.acctid = acctid;
	}

	public Long getEboxunitid() {
		return eboxunitid;
	}

	public void setEboxunitid(Long eboxunitid) {
		this.eboxunitid = eboxunitid;
	}

	public Integer getPresentcycles() {
		return presentcycles;
	}

	public void setPresentcycles(Integer presentcycles) {
		this.presentcycles = presentcycles;
	}

	public Integer getPresentinterval() {
		return presentinterval;
	}

	public void setPresentinterval(Integer presentinterval) {
		this.presentinterval = presentinterval;
	}

	public Float getPresentrate() {
		return presentrate;
	}

	public void setPresentrate(Float presentrate) {
		this.presentrate = presentrate;
	}

	public Long getYxplanid() {
		return yxplanid;
	}

	public void setYxplanid(Long yxplanid) {
		this.yxplanid = yxplanid;
	}

	public String get_ne_acctid() {
		return _ne_acctid;
	}

	public void set_ne_acctid(String _ne_acctid) {
		this._ne_acctid = _ne_acctid;
	}

	public String get_ne_eboxunitid() {
		return _ne_eboxunitid;
	}

	public void set_ne_eboxunitid(String _ne_eboxunitid) {
		this._ne_eboxunitid = _ne_eboxunitid;
	}

	public String get_ne_presentcycles() {
		return _ne_presentcycles;
	}

	public void set_ne_presentcycles(String _ne_presentcycles) {
		this._ne_presentcycles = _ne_presentcycles;
	}

	public String get_ne_presentinterval() {
		return _ne_presentinterval;
	}

	public void set_ne_presentinterval(String _ne_presentinterval) {
		this._ne_presentinterval = _ne_presentinterval;
	}

	public String get_ne_presentrate() {
		return _ne_presentrate;
	}

	public void set_ne_presentrate(String _ne_presentrate) {
		this._ne_presentrate = _ne_presentrate;
	}

	public String get_ne_yxplanid() {
		return _ne_yxplanid;
	}

	public void set_ne_yxplanid(String _ne_yxplanid) {
		this._ne_yxplanid = _ne_yxplanid;
	}

}
