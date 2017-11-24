/**
* auto-generated code
* Thu Jul 03 15:10:27 CST 2014
*/
package com.sunrise.boss.business.cms.chpwfiletransfer.persistent;

import java.util.ArrayList;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: ChPwStatreportsListVO</p>
 * <p>Description: Query Params Object for ChPwStatreportsDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liyanling
 * @version 1.0
 */
public class ChPwFiletransferListVO extends BaseListVO {
	 
	 private ArrayList _sin_cityid;
	 private String _ne_state; 
	 
	 private String _dnm_datadate;//
	 private String _dnl_datadate;//
	 
	public String get_ne_state() {
		return _ne_state;
	}

	public void set_ne_state(String _ne_state) {
		this._ne_state = _ne_state;
	}

	public ArrayList get_sin_cityid() {
		return _sin_cityid;
	}

	public void set_sin_cityid(ArrayList _sin_cityid) {
		this._sin_cityid = _sin_cityid;
	}

	public String get_dnm_datadate() {
		return _dnm_datadate;
	}

	public void set_dnm_datadate(String dnmDatadate) {
		_dnm_datadate = dnmDatadate;
	}

	public String get_dnl_datadate() {
		return _dnl_datadate;
	}

	public void set_dnl_datadate(String dnlDatadate) {
		_dnl_datadate = dnlDatadate;
	}
	 

}
