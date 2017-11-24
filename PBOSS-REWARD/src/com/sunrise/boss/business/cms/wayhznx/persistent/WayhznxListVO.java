/**
* auto-generated code
* Thu Feb 12 09:35:58 CST 2009
*/
package com.sunrise.boss.business.cms.wayhznx.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: WayhznxListVO</p>
 * <p>Description: Query Params Object for WayhznxDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public class WayhznxListVO extends BaseListVO {
	
	private String _se_wayid;
	
	private String _ne_starlevel;

	public String get_ne_starlevel() {
		return _ne_starlevel;
	}

	public void set_ne_starlevel(String _ne_starlevel) {
		this._ne_starlevel = _ne_starlevel;
	}

	public String get_se_wayid() {
		return _se_wayid;
	}

	public void set_se_wayid(String _se_wayid) {
		this._se_wayid = _se_wayid;
	}

}
