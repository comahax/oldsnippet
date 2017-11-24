/**
 * auto-generated code
 * Sat Mar 31 10:28:57 CST 2012
 */
package com.gmcc.pboss.web.sales.simstockalarm;

import com.gmcc.pboss.business.sales.simstockalarm.SimstockalarmVO;

/**
 * <p>Title: SimstockalarmForm </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Qiu Zhi
 * @version 1.0
 */
public class SimstockalarmForm extends SimstockalarmVO {
	
	private String redalarm;	
	private String yellowalarm;
	
	public String getRedalarm() {
		return redalarm;
	}
	public void setRedalarm(String redalarm) {
		this.redalarm = redalarm;
	}
	public String getYellowalarm() {
		return yellowalarm;
	}
	public void setYellowalarm(String yellowalarm) {
		this.yellowalarm = yellowalarm;
	}
}
