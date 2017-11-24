/**
 * auto-generated code
 * Tue Oct 31 14:19:29 CST 2006
 */
package com.sunrise.boss.ui.rightmanage.rightitem;

import java.util.Date;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.rightmanage.rightitem.persistent.RightitemVO;
import com.sunrise.pub.tools.PublicUtils;

/**
 * <p>
 * Title: RightitemForm
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
public class RightitemForm extends BaseActionForm {

	private String rightid;

	private Long region;

	private String rightgroup;

	private String operid;

	private String rightname;

	private java.util.Date createdate;

	private String createdate2;

	private Byte status;

	private java.util.Date statusdate;

	private String statusdate2;

	private String notes;

	private Byte ispublic;

	private String orgid;

	private String _se_rightid;

	private Long _ne_region;

	private String _se_operid;

	private String _se_rightname;

	private String _se_orgid;

	private String _dnl_createdate;

	private String _dnm_createdate;

	private Byte _ne_status;

	public Byte getIspublic() {
		return ispublic;
	}

	public void setIspublic(Byte ispublic) {
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

	public String get_se_rightid() {
		return _se_rightid;
	}

	public void set_se_rightid(String _se_rightid) {
		this._se_rightid = _se_rightid;
	}

	public String get_se_rightname() {
		return _se_rightname;
	}

	public void set_se_rightname(String _se_rightname) {
		this._se_rightname = _se_rightname;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Long getRegion() {
		return region;
	}

	public void setRegion(Long region) {
		this.region = region;
	}

	public String getRightgroup() {
		return rightgroup;
	}

	public void setRightgroup(String rightgroup) {
		this.rightgroup = rightgroup;
	}

	public String getRightid() {
		return rightid;
	}

	public void setRightid(String rightid) {
		this.rightid = rightid;
	}

	public String getRightname() {
		return rightname;
	}

	public void setRightname(String rightname) {
		this.rightname = rightname;
	}

	public Long get_ne_region() {
		return _ne_region;
	}

	public void set_ne_region(Long _ne_region) {
		this._ne_region = _ne_region;
	}
}
