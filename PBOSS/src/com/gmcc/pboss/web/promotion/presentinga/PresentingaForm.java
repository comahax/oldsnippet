/**
 * auto-generated code
 * Mon Sep 14 17:09:30 CST 2009
 */
package com.gmcc.pboss.web.promotion.presentinga;

import com.gmcc.pboss.business.promotion.presentinga.PresentingaVO;

/**
 * <p>Title: PresentingaForm </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class PresentingaForm extends PresentingaVO {
	
	private Long pid;
	
	private String ptype;
	
	private String rulename;
	
	private String pfrtmode;
	
	private String isEnabled;
	
	public String getIsEnabled() {
		return isEnabled;
	}
	public void setIsEnabled(String isEnabled) {
		this.isEnabled = isEnabled;
	}
	public Long getPid() {
		return pid;
	}
	public void setPid(Long pid) {
		this.pid = pid;
	}
	public String getPtype() {
		return ptype;
	}
	public void setPtype(String ptype) {
		this.ptype = ptype;
	}
	public String getRulename() {
		return rulename;
	}
	public void setRulename(String rulename) {
		this.rulename = rulename;
	}
	public String getPfrtmode() {
		return pfrtmode;
	}
	public void setPfrtmode(String pfrtmode) {
		this.pfrtmode = pfrtmode;
	}
}
