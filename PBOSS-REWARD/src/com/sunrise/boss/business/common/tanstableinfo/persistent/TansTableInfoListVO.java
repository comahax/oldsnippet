
package com.sunrise.boss.business.common.tanstableinfo.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * @author mys
 * @version 1.0
 */
public class TansTableInfoListVO extends BaseListVO {
	private String _se_tablename;

	public String get_se_tablename() {
		return _se_tablename;
	}

	public void set_se_tablename(String _se_tablename) {
		this._se_tablename = _se_tablename;
	}

	
}
