/**
 * auto-generated code
 * Thu Oct 19 17:09:08 CST 2006
 */
package com.sunrise.boss.ui.rightmanage.roleright;

import java.util.Date;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.pub.tools.PublicUtils;

/**
 * <p>
 * Title: RolerightForm
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
public class RolerightForm extends BaseActionForm {

	private String itemid;

	private String rightid;

	private java.util.Date createdate;

	private String createdate2;

	private Byte status;

	private java.util.Date statusdate;

	private String statusdate2;

	private String _se_itemid;

	private String _se_rightid;

	private String _dnl_createdate;

	private String _dnm_createdate;

	private Byte _ne_status;

	public java.util.Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(java.util.Date createdate) {
		this.createdate = createdate;
	}

	public String getItemid() {
		return itemid;
	}

	public void setItemid(String itemid) {
		this.itemid = itemid;
	}

	public String getRightid() {
		return rightid;
	}

	public void setRightid(String rightid) {
		this.rightid = rightid;
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

	public String get_se_itemid() {
		return _se_itemid;
	}

	public void set_se_itemid(String _se_itemid) {
		this._se_itemid = _se_itemid;
	}

	public String get_se_rightid() {
		return _se_rightid;
	}

	public void set_se_rightid(String _se_rightid) {
		this._se_rightid = _se_rightid;
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
