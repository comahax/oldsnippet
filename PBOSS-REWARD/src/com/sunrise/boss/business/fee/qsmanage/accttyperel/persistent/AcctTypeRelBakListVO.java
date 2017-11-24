package com.sunrise.boss.business.fee.qsmanage.accttyperel.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;
/**
 * 
 * @author wangguangying 20080916
 *
 */
public class AcctTypeRelBakListVO extends BaseListVO {
	
	private String _se_acctid ;
	private String _ne_accttype;
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
	public String get_ne_accttype() {
		return _ne_accttype;
	}
	public void set_ne_accttype(String _ne_accttype) {
		this._ne_accttype = _ne_accttype;
	}
	public String get_se_acctid() {
		return _se_acctid;
	}
	public void set_se_acctid(String _se_acctid) {
		this._se_acctid = _se_acctid;
	}
}
