/**
 * auto-generated code
 * Tue Sep 29 10:11:13 CST 2009
 */
package com.gmcc.pboss.business.communication.advinfo;

import com.gmcc.pboss.business.communication.advinfo.AdvinfoVO;

/**
 * <p>Title: AdvinfoForm </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class AdvinfoVOHelper extends AdvinfoVO {
	private Short appState;
    private String appContent;
    private String objinfo;
	public Short getAppState() {
		return appState;
	}
	public void setAppState(Short appState) {
		this.appState = appState;
	}
	public String getAppContent() {
		return appContent;
	}
	public void setAppContent(String appContent) {
		this.appContent = appContent;
	}
	public String getObjinfo() {
		return objinfo;
	}
	public void setObjinfo(String objinfo) {
		this.objinfo = objinfo;
	}
}
