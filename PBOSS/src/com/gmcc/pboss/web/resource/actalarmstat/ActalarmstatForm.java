/**
 * auto-generated code
 * Tue Jul 27 15:41:54 CST 2010
 */
package com.gmcc.pboss.web.resource.actalarmstat;

import java.util.Map;

import com.gmcc.pboss.business.resource.actalarmstat.ActalarmstatVO;

/**
 * <p>Title: ActalarmstatForm </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ActalarmstatForm extends ActalarmstatVO {
	private String cityid;
	private Map<String,String> stattypeMap;
	private String macodeStr;
	public String getCityid() {
		return cityid;
	}

	public void setCityid(String cityid) {
		this.cityid = cityid;
	}

	public Map<String, String> getStattypeMap() {
		return stattypeMap;
	}

	public void setStattypeMap(Map<String, String> stattypeMap) {
		this.stattypeMap = stattypeMap;
	}

	public String getMacodeStr() {
		return macodeStr;
	}

	public void setMacodeStr(String macodeStr) {
		this.macodeStr = macodeStr;
	}
	
}
