/**
* auto-generated code
* Thu Aug 20 16:16:16 CST 2009
*/
package com.sunrise.boss.ui.cms.reward.taskstate;

import com.sunrise.boss.ui.base.BaseActionForm;

/**
 * <p>Title: TaskstateForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public class TaskstateForm extends BaseActionForm {

    private java.lang.String taskid;
    private java.lang.String ownertaskid;
    private java.lang.String rewardmonth;
    private java.lang.String cityid;
    private java.util.Date starttime;
    private java.util.Date endtime;
    private java.lang.Short state;
    private String regiongroup;
    private String year ;
	
	private String month;
	
    private String _se_cityid;

    /** identifier field */
    private Long _se_ownertaskid;

    /** identifier field */
    private String _se_rewardmonth;

    /** identifier field */
    private Long _se_taskid;

    public java.lang.String getOwnertaskid() {
		return ownertaskid;
	}

	public void setOwnertaskid(java.lang.String ownertaskid) {
		this.ownertaskid = ownertaskid;
	}

	public java.lang.String getTaskid() {
		return taskid;
	}

	public void setTaskid(java.lang.String taskid) {
		this.taskid = taskid;
	}

	public java.lang.String getRewardmonth(){
        return rewardmonth;
    }

    public void setRewardmonth(java.lang.String rewardmonth){
        this.rewardmonth = rewardmonth;
    }
    public java.lang.String getCityid(){
        return cityid;
    }

    public void setCityid(java.lang.String cityid){
        this.cityid = cityid;
    }
    public java.util.Date getStarttime(){
        return starttime;
    }

    public void setStarttime(java.util.Date starttime){
        this.starttime = starttime;
    }
    public java.util.Date getEndtime(){
        return endtime;
    }

    public void setEndtime(java.util.Date endtime){
        this.endtime = endtime;
    }
  

	public java.lang.Short getState() {
		return state;
	}

	public void setState(java.lang.Short state) {
		this.state = state;
	}

	public String get_se_cityid() {
		return _se_cityid;
	}

	public void set_se_cityid(String _se_cityid) {
		this._se_cityid = _se_cityid;
	}

	public Long get_se_ownertaskid() {
		return _se_ownertaskid;
	}

	public void set_se_ownertaskid(Long _se_ownertaskid) {
		this._se_ownertaskid = _se_ownertaskid;
	}

	public String get_se_rewardmonth() {
		return _se_rewardmonth;
	}

	public void set_se_rewardmonth(String _se_rewardmonth) {
		this._se_rewardmonth = _se_rewardmonth;
	}

	public Long get_se_taskid() {
		return _se_taskid;
	}

	public void set_se_taskid(Long _se_taskid) {
		this._se_taskid = _se_taskid;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getRegiongroup() {
		return regiongroup;
	}

	public void setRegiongroup(String regiongroup) {
		this.regiongroup = regiongroup;
	}


}
