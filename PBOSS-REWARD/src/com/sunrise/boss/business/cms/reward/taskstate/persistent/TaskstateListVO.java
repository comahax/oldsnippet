/**
* auto-generated code
* Thu Aug 20 16:16:16 CST 2009
*/
package com.sunrise.boss.business.cms.reward.taskstate.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: TaskstateListVO</p>
 * <p>Description: Query Params Object for TaskstateDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public class TaskstateListVO extends BaseListVO {

    private String _se_cityid;

    /** identifier field */
    private String _se_ownertaskid;

    /** identifier field */
    private String _se_rewardmonth;
    
    private String regiongroup;

    /** identifier field */
    private String _se_taskid;
    
    private String _sql_taskid;

	public String get_sql_taskid() {
		return _sql_taskid;
	}

	public void set_sql_taskid(String _sql_taskid) {
		this._sql_taskid = _sql_taskid;
	}

	public String get_se_cityid() {
		return _se_cityid;
	}

	public void set_se_cityid(String _se_cityid) {
		this._se_cityid = _se_cityid;
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

	public String get_se_rewardmonth() {
		return _se_rewardmonth;
	}

	public void set_se_rewardmonth(String _se_rewardmonth) {
		this._se_rewardmonth = _se_rewardmonth;
	}

	public String getRegiongroup() {
		return regiongroup;
	}

	public void setRegiongroup(String regiongroup) {
		this.regiongroup = regiongroup;
	}

	
	
}
