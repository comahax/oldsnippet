/**
 * auto-generated code
 * Mon Sep 14 14:47:12 CST 2009
 */
package com.gmcc.pboss.web.promotion.elmtinst;

import com.gmcc.pboss.business.promotion.elmtinst.ElmtinstVO;

/**
 * <p>Title: ElmtinstForm </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ElmtinstForm extends ElmtinstVO {
	
	private String _se_instid;
	
	private String _sk_instname;

  //元素实例新增类型，常规新增和选择新增，常规新增时type不设置，为null；选择新增时type="select"
	private String type;

	private String elmttmplMemo;
	
	public String get_se_instid() {
		return _se_instid;
	}

	public void set_se_instid(String _se_instid) {
		this._se_instid = _se_instid;
	}

	public String get_sk_instname() {
		return _sk_instname;
	}

	public void set_sk_instname(String _sk_instname) {
		this._sk_instname = _sk_instname;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getElmttmplMemo() {
		return elmttmplMemo;
	}

	public void setElmttmplMemo(String elmttmplMemo) {
		this.elmttmplMemo = elmttmplMemo;
	}
}
