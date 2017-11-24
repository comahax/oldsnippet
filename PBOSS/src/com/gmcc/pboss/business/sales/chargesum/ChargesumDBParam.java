/**
 * auto-generated code
 * Tue Oct 13 09:23:32 CST 2009
 */
package com.gmcc.pboss.business.sales.chargesum;

import org.apache.commons.lang.StringUtils;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: BaseorderamtDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ChargesumDBParam extends DBQueryParam {
	private String wayid;
	private String starttimeStr;
	private String endtimeStr;
	public String getWayid() {
		return wayid;
	}
	public void setWayid(String wayid) {
		this.wayid = wayid;
	}
	public String getStarttimeStr() {
		return starttimeStr;
	}
	public void setStarttimeStr(String starttimeStr) {
		this.starttimeStr = starttimeStr;
	}
	public String getEndtimeStr() {
		return endtimeStr;
	}
	public void setEndtimeStr(String endtimeStr) {
		this.endtimeStr = endtimeStr;
	}

}
