package com.sunrise.boss.ui.cms.reward.rewardrulequery;

import java.util.Date;

import com.sunrise.boss.ui.base.BaseActionForm;

/**
 * <p>
 * Title: StdrewardbjForm
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2007
 * </p>
 * <p>
 * Company: SUNRISE Tech Ltd.
 * </p>
 * 
 * @author linli
 * @version 1.0
 */
public class RewardrulequeryForm extends BaseActionForm {
	
	private Long _ne_rewardid;
	private String _se_region;
	private Long _ne_rewardtype;
	private String _se_rewardname;
	
	private Long rewardid;
	private String rewardname;
	private Long rewardtype;
	private String region;
	private String opnid;
	private Long intvmonth;
	private Long acctype;
	private Double rewardstd;
	private Date startdate;
	private Date stopdate;
	public Long get_ne_rewardid() {
		return _ne_rewardid;
	}
	public void set_ne_rewardid(Long _ne_rewardid) {
		this._ne_rewardid = _ne_rewardid;
	}
	public Long get_ne_rewardtype() {
		return _ne_rewardtype;
	}
	public void set_ne_rewardtype(Long _ne_rewardtype) {
		this._ne_rewardtype = _ne_rewardtype;
	}
	public String get_se_region() {
		return _se_region;
	}
	public void set_se_region(String _se_region) {
		this._se_region = _se_region;
	}
	public String get_se_rewardname() {
		return _se_rewardname;
	}
	public void set_se_rewardname(String _se_rewardname) {
		this._se_rewardname = _se_rewardname;
	}
	public Long getAcctype() {
		return acctype;
	}
	public void setAcctype(Long acctype) {
		this.acctype = acctype;
	}
	public Long getIntvmonth() {
		return intvmonth;
	}
	public void setIntvmonth(Long intvmonth) {
		this.intvmonth = intvmonth;
	}
	public String getOpnid() {
		return opnid;
	}
	public void setOpnid(String opnid) {
		this.opnid = opnid;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public Long getRewardid() {
		return rewardid;
	}
	public void setRewardid(Long rewardid) {
		this.rewardid = rewardid;
	}
	public String getRewardname() {
		return rewardname;
	}
	public void setRewardname(String rewardname) {
		this.rewardname = rewardname;
	}
	public Double getRewardstd() {
		return rewardstd;
	}
	public void setRewardstd(Double rewardstd) {
		this.rewardstd = rewardstd;
	}
	public Long getRewardtype() {
		return rewardtype;
	}
	public void setRewardtype(Long rewardtype) {
		this.rewardtype = rewardtype;
	}
	public Date getStartdate() {
		return startdate;
	}
	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}
	public Date getStopdate() {
		return stopdate;
	}
	public void setStopdate(Date stopdate) {
		this.stopdate = stopdate;
	}
	
}
