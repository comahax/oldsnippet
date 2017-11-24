/**
 * auto-generated code
 * Sat Jun 09 10:21:12 CST 2012
 */
package com.gmcc.pboss.web.channel.waychecked;

import com.gmcc.pboss.business.channel.checkedapply.CheckedapplyVO;

/**
 * <p>Title: CheckedapplyForm </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class WaycheckedForm extends CheckedapplyVO {
	
	private boolean CH_CHECKED_PROVINCE;
	
	private boolean CH_CHECKED_CITY;
	
	private boolean APPSTATUS_MULTI;
	
	private boolean hasCH_CHECKED_MIDCITY;

	private String oprname;
	
	private boolean cbFlag;//复选框是否可用

	public String getOprname() {
		return oprname;
	}

	public void setOprname(String oprname) {
		this.oprname = oprname;
	}

	public boolean getCH_CHECKED_PROVINCE() {
		return CH_CHECKED_PROVINCE;
	}

	public void setCH_CHECKED_PROVINCE(boolean ch_checked_province) {
		CH_CHECKED_PROVINCE = ch_checked_province;
	}

	public boolean isCH_CHECKED_CITY() {
		return CH_CHECKED_CITY;
	}

	public void setCH_CHECKED_CITY(boolean ch_checked_city) {
		CH_CHECKED_CITY = ch_checked_city;
	}

	public boolean isCbFlag() {
		return cbFlag;
	}

	public void setCbFlag(boolean cbFlag) {
		this.cbFlag = cbFlag;
	}

	public boolean isAPPSTATUS_MULTI() {
		return APPSTATUS_MULTI;
	}

	public void setAPPSTATUS_MULTI(boolean appstatus_multi) {
		APPSTATUS_MULTI = appstatus_multi;
	}	
	
	public boolean isHasCH_CHECKED_MIDCITY() {
		return hasCH_CHECKED_MIDCITY;
	}

	public void setHasCH_CHECKED_MIDCITY(boolean hasCH_CHECKED_MIDCITY) {
		this.hasCH_CHECKED_MIDCITY = hasCH_CHECKED_MIDCITY;
	}

}
