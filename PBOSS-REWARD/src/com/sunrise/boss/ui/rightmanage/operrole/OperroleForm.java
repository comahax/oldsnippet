/**
 * auto-generated code
 * Fri Oct 20 20:20:06 CST 2006
 */
package com.sunrise.boss.ui.rightmanage.operrole;

import java.util.Date;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.rightmanage.operrole.persistent.OperroleVO;
import com.sunrise.pub.tools.PublicUtils;

/**
 * <p>
 * Title: OperroleForm
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author
 * @version 1.0
 */
public class OperroleForm extends BaseActionForm {
	private String operid;

	private String roleid;

	private java.util.Date createdate;

	 private String createdate2;

	private Byte status;

	private java.util.Date statusdate;

	 private String statusdate2;

	private String _se_operid;

	private String _se_roleid;

	private String _dnl_createdate;

	private String _dnm_createdate;

	private Byte _ne_status;

	public String get_dnl_createdate() {
		return _dnl_createdate;
	}

	public void set_dnl_createdate(String _dnl_createdate) {
		this._dnl_createdate = _dnl_createdate;
	}

	public String get_dnm_createdate() {
		return _dnm_createdate;
	}

	public void set_dnm_createdate(String _dnm_createdate) {
		this._dnm_createdate = _dnm_createdate;
	}

	public Byte get_ne_status() {
		return _ne_status;
	}

	public void set_ne_status(Byte _ne_status) {
		this._ne_status = _ne_status;
	}

	public String get_se_operid() {
		return _se_operid;
	}

	public void set_se_operid(String _se_operid) {
		this._se_operid = _se_operid;
	}

	public String get_se_roleid() {
		return _se_roleid;
	}

	public void set_se_roleid(String _se_roleid) {
		this._se_roleid = _se_roleid;
	}

	public java.util.Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(java.util.Date createdate) {
		this.createdate = createdate;
	}

	public String getOperid() {
		return operid;
	}

	public void setOperid(String operid) {
		this.operid = operid;
	}

	public String getRoleid() {
		return roleid;
	}

	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public java.util.Date getStatusdate() {
		return statusdate;
	}

	public void setStatusdate(java.util.Date statusdate) {
		this.statusdate = statusdate;
	}

	public String getStatusdate2() {
		String str = PublicUtils.formatUtilDate(this.statusdate, "yyyy-MM-dd");
		if (str == null || str.equals("")) {
			return statusdate2;
		} else
			return str;
	}

	public void setStatusdate2(String statusdate2) {
		try {
			this.statusdate = PublicUtils.UtilStrToDate(statusdate2,
					"yyyy-MM-dd");
		} catch (Exception e) {
			this.statusdate = new Date();
		}
	}

	public String getCreatedate2() {
		String str = PublicUtils.formatUtilDate(this.createdate, "yyyy-MM-dd");
		if (str == null || str.equals("")) {
			return createdate2;
		} else
			return str;
	}

	public void setCreatedate2(String createdate2) {
		try {
			this.createdate = PublicUtils.UtilStrToDate(createdate2,
					"yyyy-MM-dd");
		} catch (Exception e) {
			this.createdate = new Date();
		}
	}

}
