package com.sunrise.boss.ui.resmanage.task;

import com.sunrise.boss.ui.base.BaseActionForm;

public class TaskForm extends BaseActionForm {

	private String _se_taskid;
	
	private String _se_filecode;

	private String _se_subsystem;

	private String _ne_taskstate;

	private String _dnl_createtime;

	private String _dnm_createtime;
	
	private String _dnl_exectime;

	private String _dnm_exectime;
	
	private String _dnl_endtime;

	private String _dnm_endtime;

	private String _se_oprcode;

	private String _se_wayid;
	
	/** identifier field */
    private Long taskid;

    /** nullable persistent field */
    private String filecode;

    /** persistent field */
    private String subsystem;

    /** nullable persistent field */
    private Integer taskstate;

    /** nullable persistent field */
    private java.util.Date createtime;

    /** nullable persistent field */
    private java.util.Date exectime;

    /** nullable persistent field */
    private java.util.Date endtime;

    /** nullable persistent field */
    private String oprcode;

    /** nullable persistent field */
    private String wayid;

    /** nullable persistent field */
    private Short taskfilecount;

    /** nullable persistent field */
    private Integer totalcount;

    /** nullable persistent field */
    private Integer currentcount;

    /** nullable persistent field */
    private Integer successcount;

    /** nullable persistent field */
    private String resultfile;

    /** nullable persistent field */
    private String memo;

    /** nullable persistent field */
    private String logfile;
    
    private Integer sysflag;

	public String get_se_filecode() {
		return _se_filecode;
	}

	public void set_se_filecode(String _se_filecode) {
		this._se_filecode = _se_filecode;
	}

	public String get_se_subsystem() {
		return _se_subsystem;
	}

	public void set_se_subsystem(String _se_subsystem) {
		this._se_subsystem = _se_subsystem;
	}

	public String get_ne_taskstate() {
		return _ne_taskstate;
	}

	public void set_ne_taskstate(String _ne_taskstate) {
		this._ne_taskstate = _ne_taskstate;
	}

	public String get_dnl_createtime() {
		return _dnl_createtime;
	}

	public void set_dnl_createtime(String _dnl_createtime) {
		this._dnl_createtime = _dnl_createtime;
	}

	public String get_dnm_createtime() {
		return _dnm_createtime;
	}

	public void set_dnm_createtime(String _dnm_createtime) {
		this._dnm_createtime = _dnm_createtime;
	}

	public String get_se_oprcode() {
		return _se_oprcode;
	}

	public void set_se_oprcode(String _se_oprcode) {
		this._se_oprcode = _se_oprcode;
	}

	public String get_se_wayid() {
		return _se_wayid;
	}

	public void set_se_wayid(String _se_wayid) {
		this._se_wayid = _se_wayid;
	}

	public String get_se_taskid() {
		return _se_taskid;
	}

	public void set_se_taskid(String _se_taskid) {
		this._se_taskid = _se_taskid;
	}

	public String get_dnl_endtime() {
		return _dnl_endtime;
	}

	public void set_dnl_endtime(String _dnl_endtime) {
		this._dnl_endtime = _dnl_endtime;
	}

	public String get_dnl_exectime() {
		return _dnl_exectime;
	}

	public void set_dnl_exectime(String _dnl_exectime) {
		this._dnl_exectime = _dnl_exectime;
	}

	public String get_dnm_endtime() {
		return _dnm_endtime;
	}

	public void set_dnm_endtime(String _dnm_endtime) {
		this._dnm_endtime = _dnm_endtime;
	}

	public String get_dnm_exectime() {
		return _dnm_exectime;
	}

	public void set_dnm_exectime(String _dnm_exectime) {
		this._dnm_exectime = _dnm_exectime;
	}

	public java.util.Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(java.util.Date createtime) {
		this.createtime = createtime;
	}

	public Integer getCurrentcount() {
		return currentcount;
	}

	public void setCurrentcount(Integer currentcount) {
		this.currentcount = currentcount;
	}

	public java.util.Date getEndtime() {
		return endtime;
	}

	public void setEndtime(java.util.Date endtime) {
		this.endtime = endtime;
	}

	public java.util.Date getExectime() {
		return exectime;
	}

	public void setExectime(java.util.Date exectime) {
		this.exectime = exectime;
	}

	public String getFilecode() {
		return filecode;
	}

	public void setFilecode(String filecode) {
		this.filecode = filecode;
	}

	public String getLogfile() {
		return logfile;
	}

	public void setLogfile(String logfile) {
		this.logfile = logfile;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getOprcode() {
		return oprcode;
	}

	public void setOprcode(String oprcode) {
		this.oprcode = oprcode;
	}

	public String getResultfile() {
		return resultfile;
	}

	public void setResultfile(String resultfile) {
		this.resultfile = resultfile;
	}

	public String getSubsystem() {
		return subsystem;
	}

	public void setSubsystem(String subsystem) {
		this.subsystem = subsystem;
	}

	public Integer getSuccesscount() {
		return successcount;
	}

	public void setSuccesscount(Integer successcount) {
		this.successcount = successcount;
	}

	public Integer getSysflag() {
		return sysflag;
	}

	public void setSysflag(Integer sysflag) {
		this.sysflag = sysflag;
	}

	public Short getTaskfilecount() {
		return taskfilecount;
	}

	public void setTaskfilecount(Short taskfilecount) {
		this.taskfilecount = taskfilecount;
	}

	public Long getTaskid() {
		return taskid;
	}

	public void setTaskid(Long taskid) {
		this.taskid = taskid;
	}

	public Integer getTaskstate() {
		return taskstate;
	}

	public void setTaskstate(Integer taskstate) {
		this.taskstate = taskstate;
	}

	public Integer getTotalcount() {
		return totalcount;
	}

	public void setTotalcount(Integer totalcount) {
		this.totalcount = totalcount;
	}

	public String getWayid() {
		return wayid;
	}

	public void setWayid(String wayid) {
		this.wayid = wayid;
	}
}
