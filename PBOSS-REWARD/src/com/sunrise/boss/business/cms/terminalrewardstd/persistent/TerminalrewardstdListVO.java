/**
* auto-generated code
* Sat Jan 05 17:17:55 CST 2013
*/
package com.sunrise.boss.business.cms.terminalrewardstd.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: TerminalrewardstdListVO</p>
 * <p>Description: Query Params Object for TerminalrewardstdDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author lc
 * @version 1.0
 */
public class TerminalrewardstdListVO extends BaseListVO {
    private String _ne_rewardtype;
    private String _ne_citycode;
    private String _se_comid;

	public String get_se_comid() {
		return _se_comid;
	}

	public void set_se_comid(String _se_comid) {
		this._se_comid = _se_comid;
	}

	public String get_ne_citycode() {
		return _ne_citycode;
	}

	public void set_ne_citycode(String _ne_citycode) {
		this._ne_citycode = _ne_citycode;
	}

	public String get_ne_rewardtype(){
        return _ne_rewardtype;
    }

    public void set_ne_rewardtype(String _ne_rewardtype){
        this._ne_rewardtype = _ne_rewardtype;
    }

}
