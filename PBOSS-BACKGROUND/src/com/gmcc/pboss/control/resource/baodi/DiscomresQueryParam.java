package com.gmcc.pboss.control.resource.baodi;

import com.gmcc.pboss.business.resource.discomres.DiscomresDBParam;

public class DiscomresQueryParam extends DiscomresDBParam {
	private String _se_batchno;
    private String _se_boxnum;
    
	public String get_se_batchno() {
		return _se_batchno;
	}
	public void set_se_batchno(String _se_batchno) {
		this._se_batchno = _se_batchno;
	}
	public String get_se_boxnum() {
		return _se_boxnum;
	}
	public void set_se_boxnum(String _se_boxnum) {
		this._se_boxnum = _se_boxnum;
	}
    
}
