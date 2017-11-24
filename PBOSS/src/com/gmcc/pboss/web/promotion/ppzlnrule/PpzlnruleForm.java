/**
 * auto-generated code
 * Thu Sep 17 15:12:35 CST 2009
 */
package com.gmcc.pboss.web.promotion.ppzlnrule;

import com.gmcc.pboss.business.promotion.ppzlnrule.PpzlnruleVO;

/**
 * <p>Title: PpzlnruleForm </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class PpzlnruleForm extends PpzlnruleVO {
	
	private Long pid;

    /** identifier field */
    private Long ruleid;
    
    private String rulename;
    
    private String pri;
    
    private String memo;
    
    private String ptype;
    
    private String pfrtmode;
    
    private String isEnabled;

	public String getIsEnabled() {
		return isEnabled;
	}

	public void setIsEnabled(String isEnabled) {
		this.isEnabled = isEnabled;
	}

	public String getPfrtmode() {
		return pfrtmode;
	}

	public void setPfrtmode(String pfrtmode) {
		this.pfrtmode = pfrtmode;
	}

	public String getPtype() {
		return ptype;
	}

	public void setPtype(String ptype) {
		this.ptype = ptype;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public String getPri() {
		return pri;
	}

	public void setPri(String pri) {
		this.pri = pri;
	}

	public Long getRuleid() {
		return ruleid;
	}

	public void setRuleid(Long ruleid) {
		this.ruleid = ruleid;
	}

	public String getRulename() {
		return rulename;
	}

	public void setRulename(String rulename) {
		this.rulename = rulename;
	}

}
