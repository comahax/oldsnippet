package com.sunrise.boss.business.resmanage.nosect.persistent;

import java.util.List;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>
 * Title: NosectListVO
 * </p>
 * <p>
 * Description: Query Params Object for NosectDAO
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author WODEN
 * @version 1.0
 */
public class NosectListVO extends BaseListVO {
	
	private String _snm_beginno;

	private String _ne_nogroupid;
	
	private String _snl_endno;
	
	private String _ne_nosectid;
	
	private String _snl_beginno;
	
	private String _snm_endno;
	
	private String _se_bossarea;
	
	private List _sin_bossarea;
	
	private String _sql_nolength;

	public String get_sql_nolength() {
		return _sql_nolength;
	}

	public void set_sql_nolength(String _sql_nolength) {
		this._sql_nolength = _sql_nolength;
	}

	public List get_sin_bossarea() {
		return _sin_bossarea;
	}

	public void set_sin_bossarea(List _sin_bossarea) {
		this._sin_bossarea = _sin_bossarea;
	}

	public String get_ne_nosectid() {
		return _ne_nosectid;
	}

	public void set_ne_nosectid(String _ne_nosectid) {
		this._ne_nosectid = _ne_nosectid;
	}

	public String get_snl_endno() {
		return _snl_endno;
	}

	public void set_snl_endno(String _snl_endno) {
		this._snl_endno = _snl_endno;
	}

	public String get_snm_beginno() {
		return _snm_beginno;
	}

	public void set_snm_beginno(String _snm_beginno) {
		this._snm_beginno = _snm_beginno;
	}

	public String get_snl_beginno() {
		return _snl_beginno;
	}

	public void set_snl_beginno(String _snl_beginno) {
		this._snl_beginno = _snl_beginno;
	}

	public String get_snm_endno() {
		return _snm_endno;
	}

	public void set_snm_endno(String _snm_endno) {
		this._snm_endno = _snm_endno;
	}

	public String get_ne_nogroupid() {
		return _ne_nogroupid;
	}

	public void set_ne_nogroupid(String _ne_nogroupid) {
		this._ne_nogroupid = _ne_nogroupid;
	}

	public String get_se_bossarea() {
		return _se_bossarea;
	}

	public void set_se_bossarea(String _se_bossarea) {
		this._se_bossarea = _se_bossarea;
	}

}
