/**
* auto-generated code
* Tue Aug 26 20:17:18 CST 2008
*/
package com.sunrise.boss.business.cms.bbc.stdrewardbj.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: BBCstdrewardbjListVO</p>
 * <p>Description: Query Params Object for BBCstdrewardbjDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 	Linli
 * @version 1.0
 */
public class BBCstdrewardbjListVO extends BaseListVO {
	private Long _ne_rewardid;
	private String _se_opnid;
	private String _se_region;
	private Short _ne_ossrc;
	
	public Short get_ne_ossrc() {
		return _ne_ossrc;
	}
	public void set_ne_ossrc(Short _ne_ossrc) {
		this._ne_ossrc = _ne_ossrc;
	}
	public String get_se_opnid() {
		return _se_opnid;
	}
	public void set_se_opnid(String _se_opnid) {
		this._se_opnid = _se_opnid;
	}
	public String get_se_region() {
		return _se_region;
	}
	public void set_se_region(String _se_region) {
		this._se_region = _se_region;
	}
	public Long get_ne_rewardid() {
		return _ne_rewardid;
	}
	public void set_ne_rewardid(Long _ne_rewardid) {
		this._ne_rewardid = _ne_rewardid;
	}
}
