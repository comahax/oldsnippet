/**
* auto-generated code
* Thu Aug 20 16:16:59 CST 2009
*/
package com.sunrise.boss.business.cms.reward.montask.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: MontaskListVO</p>
 * <p>Description: Query Params Object for MontaskDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public class MontaskListVO extends BaseListVO {
	private String _se_ownertaskid;
	private String _se_taskid;
	private String _sql_taskid;
	
	public String get_sql_taskid() {
		return _sql_taskid;
	}
	public void set_sql_taskid(String _sql_taskid) {
		this._sql_taskid = _sql_taskid;
	}
	public String get_se_ownertaskid() {
		return _se_ownertaskid;
	}
	public void set_se_ownertaskid(String _se_ownertaskid) {
		this._se_ownertaskid = _se_ownertaskid;
	}
	public String get_se_taskid() {
		return _se_taskid;
	}
	public void set_se_taskid(String _se_taskid) {
		this._se_taskid = _se_taskid;
	}
	

}
