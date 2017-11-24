/**
* auto-generated code
* Fri Feb 15 15:21:19 CST 2008
*/
package com.sunrise.boss.business.cms.reward.busiload.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: BusiloadListVO</p>
 * <p>Description: Query Params Object for BusiloadDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author zeng jianxin
 * @version 1.0
 */
public class BusiloadListVO extends BaseListVO {
    private String _se_loadinfo;
    private String _se_loadtype;    
    private String _se_opnid;

    public String get_se_loadinfo(){
        return _se_loadinfo;
    }

    public void set_se_loadinfo(String _se_loadinfo){
        this._se_loadinfo = _se_loadinfo;
    }
    public String get_se_loadtype(){
        return _se_loadtype;
    }

    public void set_se_loadtype(String _se_loadtype){
        this._se_loadtype = _se_loadtype;
    }

	public String get_se_opnid() {
		return _se_opnid;
	}

	public void set_se_opnid(String _se_opnid) {
		this._se_opnid = _se_opnid;
	}

}
