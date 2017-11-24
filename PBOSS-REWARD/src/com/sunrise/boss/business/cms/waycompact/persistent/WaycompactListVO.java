/**
 * auto-generated code
 * Fri Aug 25 11:29:29 CST 2006
 */
package com.sunrise.boss.business.cms.waycompact.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>
 * Title: WaycompactListVO
 * </p>
 * <p>
 * Description: Query Params Object for WaycompactDAO
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: Maywide Tech Ltd.
 * </p>
 * 
 * @author yjr
 * @version 1.0
 */
public class WaycompactListVO extends BaseListVO {
	
	
	private String _se_wayid;

	private String _sk_compactno;

	private String _sk_compactname;
	
	private Short _ne_isunpb;
	//ÐÂÔö
	private String subtype;
	

	public String getSubtype() {
		return subtype;
	}

	public void setSubtype(String subtype) {
		this.subtype = subtype;
	}

	public String get_se_wayid() {
		return _se_wayid;
	}

	public void set_se_wayid(String _se_wayid) {
		this._se_wayid = _se_wayid;
	}

	public String get_sk_compactname() {
		return _sk_compactname;
	}

	public void set_sk_compactname(String _sk_compactname) {
		this._sk_compactname = _sk_compactname;
	}

	public String get_sk_compactno() {
		return _sk_compactno;
	}

	public void set_sk_compactno(String _sk_compactno) {
		this._sk_compactno = _sk_compactno;
	}

	public Short get_ne_isunpb() {
		return _ne_isunpb;
	}

	public void set_ne_isunpb(Short _ne_isunpb) {
		this._ne_isunpb = _ne_isunpb;
	}
}
