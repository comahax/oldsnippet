/**
 * auto-generated code
 * Thu Sep 17 14:50:45 CST 2009
 */
package com.gmcc.pboss.web.promotion.rule;

import com.gmcc.pboss.business.promotion.rule.RuleVO;

/**
 * <p>Title: RuleForm </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class RuleForm extends RuleVO {
	
	  /** identifier field */
    private Long ruleid;

    /** persistent field */
    private String rulename;

    /** persistent field */
    private String pri;

    /** nullable persistent field */
    private String memo;

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
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
