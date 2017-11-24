/**
* auto-generated code
* Sat Jan 13 14:53:14 CST 2007
*/
package com.sunrise.boss.business.zifee.yxplangpinf.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: YxplangpinfListVO</p>
 * <p>Description: Query Params Object for YxplangpinfDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Danny(luozhoujie)
 * @version 1.0
 */
public class YxplangpinfListVO extends BaseListVO {

	private String _ne_yxplanid;
	private String _sk_yxplanname;
	private String _se_areacode;
	private String _sql_areacode;

	public String get_ne_yxplanid() {
		return _ne_yxplanid;
	}
	public void set_ne_yxplanid(String _ne_yxplanid) {
		this._ne_yxplanid = _ne_yxplanid;
	}
	public String get_sk_yxplanname() {
		return _sk_yxplanname;
	}
	public void set_sk_yxplanname(String _sk_yxplanname) {
		this._sk_yxplanname = _sk_yxplanname;
	}
	public String get_se_areacode() {
		return _se_areacode;
	}

	public void set_se_areacode(String _se_areacode) {
		this._se_areacode = _se_areacode;
	}
	public String get_sql_areacode() {
		return _sql_areacode;
	}
	public void set_sql_areacode(String _sql_areacode) {
		this._sql_areacode = _sql_areacode;
	}
}
