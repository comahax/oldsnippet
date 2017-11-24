/**
 * auto-generated code
 * Fri Oct 20 01:01:43 CST 2006
 */
package com.sunrise.boss.ui.rightmanage.operright;

import java.util.Date;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.pub.tools.PublicUtils;

/**
 * <p>
 * Title: SaSrOperrightForm
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
public class OperrightForm extends BaseActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5419890495536810258L;

	private String operid;

	private String rightid;

	private java.util.Date createdate;

	private String createdate2;

	private Byte status;

	private java.util.Date statusdate;

	private String statusdate2;

	private Byte flag;

	private Short sortorder;

	private String _se_operid;

	private String _se_rightid;

	private String _dnl_createdate;

	private String _dnm_createdate;

	private String _ne_status;

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

	public String get_ne_status() {
		return _ne_status;
	}

	public void set_ne_status(String _ne_status) {
		this._ne_status = _ne_status;
	}

	public String get_se_operid() {
		return _se_operid;
	}

	public void set_se_operid(String _se_operid) {
		this._se_operid = _se_operid;
	}

	public String get_se_rightid() {
		return _se_rightid;
	}

	public void set_se_rightid(String _se_rightid) {
		this._se_rightid = _se_rightid;
	}

	public java.util.Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(java.util.Date createdate) {
		this.createdate = createdate;
	}

	public Byte getFlag() {
		return flag;
	}

	public void setFlag(Byte flag) {
		this.flag = flag;
	}

	public String getOperid() {
		return operid;
	}

	public void setOperid(String operid) {
		this.operid = operid;
	}

	public String getRightid() {
		return rightid;
	}

	public void setRightid(String rightid) {
		this.rightid = rightid;
	}

	public Short getSortorder() {
		return sortorder;
	}

	public void setSortorder(Short sortorder) {
		this.sortorder = sortorder;
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
			this.createdate = PublicUtils.UtilStrToDate(createdate2, "yyyy-MM-dd");
		} catch (Exception e) {
			this.createdate = new Date();
		}
	}

}
