/**
 * auto-generated code
 * Mon Sep 14 14:51:11 CST 2009
 */
package com.gmcc.pboss.web.promotion.spproposal;

import java.util.Date;
import java.util.Map;

import org.apache.commons.collections.map.LinkedMap;

import com.gmcc.pboss.business.promotion.spproposal.SpproposalVO;

/**
 * <p>Title: SpproposalForm </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class SpproposalForm extends SpproposalVO {

	private String forMode;
	private String[] forWeeks;
	private String[] forDays;
	private Date nowDate;
	
	private Map dayMap = new LinkedMap();

	public String[] getForWeeks() {
		return forWeeks;
	}

	public void setForWeeks(String[] forWeeks) {
		this.forWeeks = forWeeks;
	}

	public String[] getForDays() {
		return forDays;
	}

	public void setForDays(String[] forDays) {
		this.forDays = forDays;
	}

	public String getForMode() {
		return forMode;
	}

	public void setForMode(String forMode) {
		this.forMode = forMode;
	}

	public Map getDayMap() {
		return dayMap;
	}

	public void setDayMap(Map dayMap) {
		this.dayMap = dayMap;
	}

	public Date getNowDate() {
		return nowDate;
	}

	public void setNowDate(Date nowDate) {
		this.nowDate = nowDate;
	}

	
}
