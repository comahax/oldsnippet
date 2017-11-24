/**
* auto-generated code
* Wed Aug 23 16:41:06 CST 2006
*/
package com.sunrise.boss.business.zifee.feedisc.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: FeediscListVO</p>
 * <p>Description: Query Params Object for FeediscDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author feedisc
 * @version 1.0
 */
public class FeediscListVO extends BaseListVO {
	private String _ne_feediscid;
	private String _ne_yxplanid;
	private String _se_disckind;
	private String _sk_remark;
	
	public String get_se_disckind() {
		return _se_disckind;
	}
	public void set_se_disckind(String _se_disckind) {
		this._se_disckind = _se_disckind;
	}
	public String get_sk_remark() {
		return _sk_remark;
	}
	public void set_sk_remark(String _sk_remark) {
		this._sk_remark = _sk_remark;
	}
	public String get_ne_feediscid() {
		return _ne_feediscid;
	}
	public void set_ne_feediscid(String _ne_feediscid) {
		this._ne_feediscid = _ne_feediscid;
	}
	public String get_ne_yxplanid() {
		return _ne_yxplanid;
	}
	public void set_ne_yxplanid(String _ne_yxplanid) {
		this._ne_yxplanid = _ne_yxplanid;
	}


}
