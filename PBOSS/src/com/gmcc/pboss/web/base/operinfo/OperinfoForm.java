package com.gmcc.pboss.web.base.operinfo;

import com.gmcc.pboss.business.base.operinfo.OperinfoVO;

/**
 * <p>Title: CmpsmsconForm </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */

public class OperinfoForm extends OperinfoVO {
	
	private String _se_operid;
	private Long _se_region;
	public String get_se_operid() {
		return _se_operid;
	}
	public void set_se_operid(String _se_operid) {
		this._se_operid = _se_operid;
	}
	public Long get_se_region() {
		return _se_region;
	}
	public void set_se_region(Long _se_region) {
		this._se_region = _se_region;
	}
}
