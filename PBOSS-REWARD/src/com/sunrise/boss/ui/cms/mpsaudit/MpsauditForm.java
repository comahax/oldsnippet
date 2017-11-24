/**
 * auto-generated code
 * Thu Oct 09 16:10:24 CST 2008
 */
package com.sunrise.boss.ui.cms.mpsaudit;

import com.sunrise.boss.ui.base.BaseActionForm;

/**
 * <p>
 * Title: MpsauditForm
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
public class MpsauditForm extends BaseActionForm {
	private String _snl_adtdate;

	private String _snm_adtdate;

	private String adtdate;

	private Long iodnum;

	private Long mpsnum;

	public MpsauditForm() {
		super();
		// TODO Auto-generated constructor stub
	}

	private Long mpsvalid;

	private Double percent;

	private String successFlag;

	public String getSuccessFlag() {
		return successFlag;
	}

	public void setSuccessFlag(String successFlag) {
		this.successFlag = successFlag;
	}

	public String get_snl_adtdate() {
		return _snl_adtdate;
	}

	public void set_snl_adtdate(String _snl_adtdate) {
		this._snl_adtdate = _snl_adtdate;
	}

	public String get_snm_adtdate() {
		return _snm_adtdate;
	}

	public void set_snm_adtdate(String _snm_adtdate) {
		this._snm_adtdate = _snm_adtdate;
	}

	public String getAdtdate() {
		return adtdate;
	}

	public void setAdtdate(String adtdate) {
		this.adtdate = adtdate;
	}

	public Long getIodnum() {
		return iodnum;
	}

	public void setIodnum(Long iodnum) {
		this.iodnum = iodnum;
	}

	public Long getMpsnum() {
		return mpsnum;
	}

	public void setMpsnum(Long mpsnum) {
		this.mpsnum = mpsnum;
	}

	public Long getMpsvalid() {
		return mpsvalid;
	}

	public void setMpsvalid(Long mpsvalid) {
		this.mpsvalid = mpsvalid;
	}

	public Double getPercent() {
		return percent;
	}

	public void setPercent(Double percent) {
		this.percent = percent;
	}

}
