/**
 * auto-generated code
 * Fri Aug 08 14:58:15 CST 2008
 */
package com.sunrise.boss.ui.zifee.minconsume;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.zifee.minconsume.persistent.MinconsumeVO;

/**
 * <p>
 * Title: MinconsumeForm
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
public class MinconsumeForm extends BaseActionForm {

	private Long yxplanid;

	private Integer effectiveinterval;

	private Long consumecycle;

	private Integer cyclecount;

	private String effectivetype;

	private Double minconsume;

	private String _ne_yxplanid;;

	private String areacode;

	private String _nm_effectiveinterval;

	private String _se_effectivetype;

	private String _ne_minconsume;

	private String _ne_effectiveinterval;

	private String batchaction;
	
	public String getAreacode() {
		return areacode;
	}

	public void setAreacode(String areacode) {
		this.areacode = areacode;
	}

	public Long getYxplanid() {
		return yxplanid;
	}

	public void setYxplanid(Long yxplanid) {
		this.yxplanid = yxplanid;
	}

	public Integer getEffectiveinterval() {
		return effectiveinterval;
	}

	public void setEffectiveinterval(Integer effectiveinterval) {
		this.effectiveinterval = effectiveinterval;
	}

	public Long getConsumecycle() {
		return consumecycle;
	}

	public void setConsumecycle(Long consumecycle) {
		this.consumecycle = consumecycle;
	}

	public Integer getCyclecount() {
		return cyclecount;
	}

	public void setCyclecount(Integer cyclecount) {
		this.cyclecount = cyclecount;
	}

	public String getEffectivetype() {
		return effectivetype;
	}

	public void setEffectivetype(String effectivetype) {
		this.effectivetype = effectivetype;
	}

	public Double getMinconsume() {
		return minconsume;
	}

	public void setMinconsume(Double minconsume) {
		this.minconsume = minconsume;
	}

	public String get_ne_yxplanid() {
		return _ne_yxplanid;
	}

	public void set_ne_yxplanid(String _ne_yxplanid) {
		this._ne_yxplanid = _ne_yxplanid;
	}

	public String get_ne_effectiveinterval() {
		return _ne_effectiveinterval;
	}

	public void set_ne_effectiveinterval(String _ne_effectiveinterval) {
		this._ne_effectiveinterval = _ne_effectiveinterval;
	}

	public String get_ne_minconsume() {
		return _ne_minconsume;
	}

	public void set_ne_minconsume(String _ne_minconsume) {
		this._ne_minconsume = _ne_minconsume;
	}

	public String get_nm_effectiveinterval() {
		return _nm_effectiveinterval;
	}

	public void set_nm_effectiveinterval(String _nm_effectiveinterval) {
		this._nm_effectiveinterval = _nm_effectiveinterval;
	}

	public String get_se_effectivetype() {
		return _se_effectivetype;
	}

	public void set_se_effectivetype(String _se_effectivetype) {
		this._se_effectivetype = _se_effectivetype;
	}

	public String getBatchaction() {
		return batchaction;
	}

	public void setBatchaction(String batchaction) {
		this.batchaction = batchaction;
	}

}
