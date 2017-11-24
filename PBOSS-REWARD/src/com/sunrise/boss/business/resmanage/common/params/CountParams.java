package com.sunrise.boss.business.resmanage.common.params;

/**
 * <p>
 * Title: CountParams
 * </p>
 * <p>
 * Description:资源查询参数类，用于计量符合特定条件的资源总数
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author Cao Wei
 * @version 1.0
 */

public class CountParams {

	private String _snl_comresid; // 起始编号

	private String _snm_comresid; // 终止编号

	private Long _ne_comstate; // 状态

	private Long _ne_comid; // 商品标志

	private String _se_batchno; // 批次

	private String _se_wayid; // 等于渠道

	private String _snki_wayid; // 不等于渠道

	private String _snl_vipcardno; // 积分卡起始编号

	private String _snm_vipcardno; // 积分卡终止编号

	private Long _ne_cardstate; // 积分卡状态

	private String _firstitems;

	public String get_firstitems() {
		return _firstitems;
	}

	public void set_firstitems(String _firstitems) {
		this._firstitems = _firstitems;
	}

	public Long get_ne_cardstate() {
		return _ne_cardstate;
	}

	public void set_ne_cardstate(Long _ne_cardstate) {
		this._ne_cardstate = _ne_cardstate;
	}

	public String get_snl_vipcardno() {
		return _snl_vipcardno;
	}

	public void set_snl_vipcardno(String _snl_vipcardno) {
		this._snl_vipcardno = _snl_vipcardno;
	}

	public String get_snm_vipcardno() {
		return _snm_vipcardno;
	}

	public void set_snm_vipcardno(String _snm_vipcardno) {
		this._snm_vipcardno = _snm_vipcardno;
	}

	public String get_snki_wayid() {
		return _snki_wayid;
	}

	public void set_snki_wayid(String _snki_wayid) {
		this._snki_wayid = _snki_wayid;
	}

	public String get_se_wayid() {
		return _se_wayid;
	}

	public void set_se_wayid(String _se_wayid) {
		this._se_wayid = _se_wayid;
	}

	public String get_se_batchno() {
		return _se_batchno;
	}

	public void set_se_batchno(String _se_batchno) {
		this._se_batchno = _se_batchno;
	}

	public Long get_ne_comid() {
		return _ne_comid;
	}

	public void set_ne_comid(Long _ne_comid) {
		this._ne_comid = _ne_comid;
	}

	public String get_snl_comresid() {
		return _snl_comresid;
	}

	public void set_snl_comresid(String _snl_comresid) {
		this._snl_comresid = _snl_comresid;
	}

	public String get_snm_comresid() {
		return _snm_comresid;
	}

	public void set_snm_comresid(String _snm_comresid) {
		this._snm_comresid = _snm_comresid;
	}

	public Long get_ne_comstate() {
		return _ne_comstate;
	}

	public void set_ne_comstate(Long _ne_comstate) {
		this._ne_comstate = _ne_comstate;
	}

}
