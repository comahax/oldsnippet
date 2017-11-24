/**
* auto-generated code
* Fri Jul 20 19:05:15 CST 2007
*/
package com.sunrise.boss.business.fee.qsmanage.fixfeesettle.persistent;

import java.util.List;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: FixFeeSettleListVO</p>
 * <p>Description: Query Params Object for FixFeeSettleDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author lmq
 * @version 1.0
 */
public class FixFeeSettleBakListVO extends BaseListVO {
	
	private String _ne_acctid;
	private String _se_settletype;
	private String _ne_region ;
	private String _se_prodid;
	private List _nin_region ;

	public String get_se_prodid() {
		return _se_prodid;
	}
	public void set_se_prodid(String _se_prodid) {
		this._se_prodid = _se_prodid;
	}
	public String get_ne_region() {
		return _ne_region;
	}
	public void set_ne_region(String _ne_region) {
		this._ne_region = _ne_region;
	}
	public String get_ne_acctid() {
		return _ne_acctid;
	}
	public void set_ne_acctid(String _se_acctid) {
		this._ne_acctid = _se_acctid;
	}
	public String get_se_settletype() {
		return _se_settletype;
	}
	public void set_se_settletype(String _se_settletype) {
		this._se_settletype = _se_settletype;
	}
	public List get_nin_region() {
		return _nin_region;
	}
	public void set_nin_region(List _nin_region) {
		this._nin_region = _nin_region;
	}	
}
