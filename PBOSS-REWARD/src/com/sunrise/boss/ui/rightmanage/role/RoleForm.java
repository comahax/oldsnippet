/**
 * auto-generated code
 * Fri Oct 20 22:27:37 CST 2006
 */
package com.sunrise.boss.ui.rightmanage.role;

import java.util.Date;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.rightmanage.role.persistent.RoleVO;
import com.sunrise.pub.tools.PublicUtils;

/**
 * <p>
 * Title: RoleForm
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
public class RoleForm extends BaseActionForm {

	private String roleid;

	private String operid;

	private String rolename;

	private java.util.Date createdate;

	private String createdate2;

	private Byte status;

	private java.util.Date statusdate;

	private String statusdate2;

	private Boolean ispublic;

	private String orgid;

	private String _se_roleid;

	private String _se_operid;

	private String _se_rolename;

	private String _se_orgid;

	private String _dnl_createdate;

	private String _dnm_createdate;

	private Byte _ne_status;

	public Boolean getIspublic() {
		return ispublic;
	}

	public void setIspublic(Boolean ispublic) {
		this.ispublic = ispublic;
	}

	public String getOperid() {
		return operid;
	}

	public void setOperid(String operid) {
		this.operid = operid;
	}

	public String getOrgid() {
		return orgid;
	}

	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}

	public String getRoleid() {
		return roleid;
	}

	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public java.util.Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(java.util.Date createdate) {
		this.createdate = createdate;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

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

	public String get_se_operid() {
		return _se_operid;
	}

	public void set_se_operid(String _se_operid) {
		this._se_operid = _se_operid;
	}

	public String get_se_orgid() {
		return _se_orgid;
	}

	public void set_se_orgid(String _se_orgid) {
		this._se_orgid = _se_orgid;
	}

	public String get_se_roleid() {
		return _se_roleid;
	}

	public void set_se_roleid(String _se_roleid) {
		this._se_roleid = _se_roleid;
	}

	public String get_se_rolename() {
		return _se_rolename;
	}

	public void set_se_rolename(String _se_rolename) {
		this._se_rolename = _se_rolename;
	}

}
