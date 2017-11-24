package com.gmcc.pboss.web.base.dictgroup;

import com.gmcc.pboss.business.base.dictgroup.DictgroupVO;

/**
 * <p>Title: CmpsmsconForm </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */

public class DictgroupForm extends DictgroupVO {
	
	
	private String _se_groupid;
	private String _sk_groupname;
	public String get_se_groupid() {
		return _se_groupid;
	}
	public void set_se_groupid(String _se_groupid) {
		this._se_groupid = _se_groupid;
	}
	public String get_sk_groupname() {
		return _sk_groupname;
	}
	public void set_sk_groupname(String _sk_groupname) {
		this._sk_groupname = _sk_groupname;
	}
	
}
