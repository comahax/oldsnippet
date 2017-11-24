package com.sunrise.boss.business.fee.qsmanage.acctincome.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;
/**
 * 
 * @author wangguangying 20080910
 *
 */
public class AcctIncomeBakListVO extends BaseListVO {
	
	private String _ne_acctid ;
	private String _se_acctcode;
	private String _ne_type;
	private String startindex;
	private String endindex;
	public String getEndindex() {
		return endindex;
	}
	public void setEndindex(String endindex) {
		this.endindex = endindex;
	}
	public String getStartindex() {
		return startindex;
	}
	public void setStartindex(String startindex) {
		this.startindex = startindex;
	}
	public String get_se_acctcode() {
		return _se_acctcode;
	}
	public void set_se_acctcode(String _se_acctcode) {
		this._se_acctcode = _se_acctcode;
	}
	public String get_ne_acctid() {
		return _ne_acctid;
	}
	public void set_ne_acctid(String _ne_acctid) {
		this._ne_acctid = _ne_acctid;
	}
	public String get_ne_type() {
		return _ne_type;
	}
	public void set_ne_type(String _ne_type) {
		this._ne_type = _ne_type;
	}
}
