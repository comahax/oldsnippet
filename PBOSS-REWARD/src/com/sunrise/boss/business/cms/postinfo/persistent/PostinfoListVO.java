/**
* auto-generated code
* Sun Aug 27 12:00:09 CST 2006
*/
package com.sunrise.boss.business.cms.postinfo.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: PostinfoListVO</p>
 * <p>Description: Query Params Object for PostinfoDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author yjr
 * @version 1.0
 */
public class PostinfoListVO extends BaseListVO {

	private String _ne_postid;
	
	private String _sk_postname;
	
	private String _ne_waykind;
	
	private String _sk_way;
	
	private String _ne_parentpost;
	
	private String _sne_postkind;
	
	private String _ne_postkind;

	private String _se_postkind;
	
	
	public String get_se_postkind() {
		return _se_postkind;
	}

	public void set_se_postkind(String _se_postkind) {
		this._se_postkind = _se_postkind;
	}

	public String get_ne_postkind() {
		return _ne_postkind;
	}

	public void set_ne_postkind(String _ne_postkind) {
		this._ne_postkind = _ne_postkind;
	}

	public String get_ne_parentpost() {
		return _ne_parentpost;
	}

	public void set_ne_parentpost(String _ne_parentpost) {
		this._ne_parentpost = _ne_parentpost;
	}

	public String get_ne_waykind() {
		return _ne_waykind;
	}

	public void set_ne_waykind(String _ne_waykind) {
		this._ne_waykind = _ne_waykind;
	}

	public String get_sk_way() {
		return _sk_way;
	}

	public void set_sk_way(String _sk_way) {
		this._sk_way = _sk_way;
	}

	public String get_ne_postid() {
		return _ne_postid;
	}

	public void set_ne_postid(String _ne_postid) {
		this._ne_postid = _ne_postid;
	}

	public String get_sk_postname() {
		return _sk_postname;
	}

	public void set_sk_postname(String _sk_postname) {
		this._sk_postname = _sk_postname;
	}

	public String get_sne_postkind() {
		return _sne_postkind;
	}

	public void set_sne_postkind(String _sne_postkind) {
		this._sne_postkind = _sne_postkind;
	}
	
}
