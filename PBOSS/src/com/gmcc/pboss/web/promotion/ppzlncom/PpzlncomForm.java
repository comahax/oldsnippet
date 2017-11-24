/**
 * auto-generated code
 * Thu Sep 17 15:16:11 CST 2009
 */
package com.gmcc.pboss.web.promotion.ppzlncom;

import com.gmcc.pboss.business.promotion.ppzlncom.PpzlncomVO;

/**
 * <p>Title: PpzlncomForm </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class PpzlncomForm extends PpzlncomVO {
	
	private String forMode;

	private Long pid;

	private String comcategory;
	
	private String isEnabled;

	public String getIsEnabled() {
		return isEnabled;
	}

	public void setIsEnabled(String isEnabled) {
		this.isEnabled = isEnabled;
	}

	public String getForMode() {
		return forMode;
	}

	public void setForMode(String forMode) {
		this.forMode = forMode;
	}

	public String getComcategory() {
		return comcategory;
	}

	public void setComcategory(String comcategory) {
		this.comcategory = comcategory;
	}

	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}
}
