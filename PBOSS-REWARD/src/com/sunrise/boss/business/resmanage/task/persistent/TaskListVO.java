package com.sunrise.boss.business.resmanage.task.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

public class TaskListVO extends BaseListVO {

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
}
