/**
* auto-generated code
* Mon Dec 19 14:58:11 CST 2011
*/
package com.sunrise.boss.business.cms.chadtdictidname.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: ChAdtDictidnameListVO</p>
 * <p>Description: Query Params Object for ChAdtDictidnameDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author limin
 * @version 1.0
 */
public class ChAdtDictidnameListVO extends BaseListVO {
    private String _se_dictid;
    private String _sk_description;
	private String _se_groupid;
    public String get_se_groupid() {
		return _se_groupid;
	}

	public void set_se_groupid(String _se_groupid) {
		this._se_groupid = _se_groupid;
	}

	public String get_se_dictid(){
        return _se_dictid;
    }

    public void set_se_dictid(String _se_dictid){
        this._se_dictid = _se_dictid;
    }

	public String get_sk_description() {
		return _sk_description;
	}

	public void set_sk_description(String _sk_description) {
		this._sk_description = _sk_description;
	}


}
