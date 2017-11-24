/**
* auto-generated code
* Wed Dec 31 13:51:34 CST 2008
*/
package com.sunrise.boss.ui.cms.opntree;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.opntree.persistent.OpnTreeVO;

/**
 * <p>Title: OpnTreeForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
public class OpnTreeForm extends BaseActionForm {
    
	private String _se_opnid;
    private String _sk_name;
	private String showdisabled;
	private String treetype;
	private String rootid;
    
	public String getRootid() {
		return rootid;
	}
	public void setRootid(String rootid) {
		this.rootid = rootid;
	}
	public String getShowdisabled() {
		return showdisabled;
	}
	public void setShowdisabled(String showdisabled) {
		this.showdisabled = showdisabled;
	}
	public String getTreetype() {
		return treetype;
	}
	public void setTreetype(String treetype) {
		this.treetype = treetype;
	}
	public String get_se_opnid() {
		return _se_opnid;
	}
	public void set_se_opnid(String _se_opnid) {
		this._se_opnid = _se_opnid;
	}
	public String get_sk_name() {
		return _sk_name;
	}
	public void set_sk_name(String _sk_name) {
		this._sk_name = _sk_name;
	}

}
