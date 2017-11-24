/**
 * auto-generated code
 * Fri Feb 01 18:09:59 CST 2008
 */
package com.sunrise.boss.ui.cms.stdrewardbp;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.stdrewardbp.persistent.StdrewardbpVO;

/**
 * <p>
 * Title: StdrewardbpForm
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
public class StdrewardbpForm extends BaseActionForm {
	private String _ne_rewardid;

	private String _se_region;

	private String _se_slv;

	private String _ne_rewardstd;

	// private String _ne_rewardid;
	private String _sk_rewardname;

	private String _dnl_startdate;

	private String _dnm_stopdate;

	private Long rewardid;

	private String region;

	// private String slv;

	private Double rewardstd;

	// private Long rewardid;
	private String rewardname;

	private Short rewardproj;

	private Short rewardtype;

	private java.util.Date startdate;

	private java.util.Date stopdate;

	private String memo;

	private String star[] = { "1", "2", "3", "4", "5", "6" };

	private String[] seleteSlv = {};

	public String[] getSeleteSlv() {
		return seleteSlv;
	}

	public void setSeleteSlv(String[] seleteSlv) {
		this.seleteSlv = seleteSlv;
	}

	public String[] getStar() {
		return star;
	}

	public void setStar(String[] star) {
		this.star = star;
	}

	public String get_ne_rewardid() {
		return _ne_rewardid;
	}

	public void set_ne_rewardid(String _ne_rewardid) {
		this._ne_rewardid = _ne_rewardid;
	}

	public String get_se_region() {
		return _se_region;
	}

	public void set_se_region(String _se_region) {
		this._se_region = _se_region;
	}

	public String get_se_slv() {
		return _se_slv;
	}

	public void set_se_slv(String _se_slv) {
		this._se_slv = _se_slv;
	}

	public String get_ne_rewardstd() {
		return _ne_rewardstd;
	}

	public void set_ne_rewardstd(String _ne_rewardstd) {
		this._ne_rewardstd = _ne_rewardstd;
	}

	public Long getRewardid() {
		return rewardid;
	}

	public void setRewardid(Long rewardid) {
		this.rewardid = rewardid;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public Double getRewardstd() {
		return rewardstd;
	}

	public void setRewardstd(Double rewardstd) {
		this.rewardstd = rewardstd;
	}

	public String get_dnl_startdate() {
		return _dnl_startdate;
	}

	public void set_dnl_startdate(String _dnl_startdate) {
		this._dnl_startdate = _dnl_startdate;
	}

	public String get_dnm_stopdate() {
		return _dnm_stopdate;
	}

	public void set_dnm_stopdate(String _dnm_stopdate) {
		this._dnm_stopdate = _dnm_stopdate;
	}

	public String get_sk_rewardname() {
		return _sk_rewardname;
	}

	public void set_sk_rewardname(String _sk_rewardname) {
		this._sk_rewardname = _sk_rewardname;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getRewardname() {
		return rewardname;
	}

	public void setRewardname(String rewardname) {
		this.rewardname = rewardname;
	}

	public Short getRewardproj() {
		return rewardproj;
	}

	public void setRewardproj(Short rewardproj) {
		this.rewardproj = rewardproj;
	}

	public Short getRewardtype() {
		return rewardtype;
	}

	public void setRewardtype(Short rewardtype) {
		this.rewardtype = rewardtype;
	}

	public java.util.Date getStartdate() {
		return startdate;
	}

	public void setStartdate(java.util.Date startdate) {
		this.startdate = startdate;
	}

	public java.util.Date getStopdate() {
		return stopdate;
	}

	public void setStopdate(java.util.Date stopdate) {
		this.stopdate = stopdate;
	}

	public void setSlv(String slv) {
		if (slv != null && slv.length() != 0) {
			seleteSlv = new String[6];
			for (int i = 0; i < 6; i++) {
				if (i >= slv.length())
					return;
				seleteSlv[i] = slv.substring(i, i + 1).equals("0") ? ""
						: star[i];
			}
		}

	}

	public String getSlv() {
		String[] star = getStar();
		String[] seleteSlv = getSeleteSlv();
		StringBuffer slv = new StringBuffer();
		for (int i = 0; i < star.length; i++) {
			boolean equal = false;
			for (int j = 0; j < seleteSlv.length; j++) {
				if (star[i].equals(seleteSlv[j])) {
					slv.append("1");
					equal = true;
					break;
				}
			}
			if (!equal)
				slv.append("0");
		}
		return slv.toString();
	}
}
