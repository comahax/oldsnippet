package com.gmcc.pboss.business.cms.examine.exmnstddetail.persistent;


import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: ExmnstddetailDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ExmnstddetailDBParam extends DBQueryParam {
	 private String _se_exmnperiod;

	public String get_se_exmnperiod() {
		return _se_exmnperiod;
	}

	public void set_se_exmnperiod(String _se_exmnperiod) {
		this._se_exmnperiod = _se_exmnperiod;
	}
	 

}
