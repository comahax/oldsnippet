/**
* auto-generated code
* Thu Nov 19 11:08:41 CST 2009
*/
package com.sunrise.boss.business.cms.empmodel.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: EmpmodelListVO</p>
 * <p>Description: Query Params Object for EmpmodelDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
public class EmpmodelListVO extends BaseListVO {

	private String _se_employeeid;
	private String _se_model;
	private String _ne_state;
	
	public String get_ne_state() {
		return _ne_state;
	}
	public void set_ne_state(String _ne_state) {
		this._ne_state = _ne_state;
	}
	public String get_se_employeeid() {
		return _se_employeeid;
	}
	public void set_se_employeeid(String _se_employeeid) {
		this._se_employeeid = _se_employeeid;
	}
	public String get_se_model() {
		return _se_model;
	}
	public void set_se_model(String _se_model) {
		this._se_model = _se_model;
	}
	

}
