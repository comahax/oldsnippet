/**
* auto-generated code
* Wed Sep 13 09:14:51 CST 2006
*/
package com.sunrise.boss.business.cms.groupopr.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: GroupoprListVO</p>
 * <p>Description: Query Params Object for GroupoprDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author yjr
 * @version 1.0
 */
public class GroupoprListVO extends BaseListVO {
	
    private String _ne_groupseq;

    private String _se_oprseq;
    
    private String _se_bossarea;

	public String get_se_bossarea() {
		return _se_bossarea;
	}

	public void set_se_bossarea(String _se_bossarea) {
		this._se_bossarea = _se_bossarea;
	}

	public String get_ne_groupseq() {
		return _ne_groupseq;
	}

	public void set_ne_groupseq(String _ne_groupseq) {
		this._ne_groupseq = _ne_groupseq;
	}

	public String get_se_oprseq() {
		return _se_oprseq;
	}

	public void set_se_oprseq(String _se_oprseq) {
		this._se_oprseq = _se_oprseq;
	}

}
