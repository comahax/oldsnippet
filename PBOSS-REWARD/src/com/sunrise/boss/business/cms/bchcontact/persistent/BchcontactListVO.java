/**
* auto-generated code
* Fri Aug 25 11:28:40 CST 2006
*/
package com.sunrise.boss.business.cms.bchcontact.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: BchcontactListVO</p>
 * <p>Description: Query Params Object for BchcontactDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author yjr
 * @version 1.0
 */
public class BchcontactListVO extends BaseListVO {

	private String _se_wayid;
	
	private String _sk_linkman;
	
	private String _sk_principal;
	
	private String _sk_principaltel;

	private String _sk_principalemail;
	
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

	public String get_sk_linkman() {
		return _sk_linkman;
	}

	public void set_sk_linkman(String _sk_linkman) {
		this._sk_linkman = _sk_linkman;
	}

	public String get_sk_principal() {
		return _sk_principal;
	}

	public void set_sk_principal(String _sk_principal) {
		this._sk_principal = _sk_principal;
	}

	public String get_sk_principalemail() {
		return _sk_principalemail;
	}

	public void set_sk_principalemail(String _sk_principalemail) {
		this._sk_principalemail = _sk_principalemail;
	}

	public String get_sk_principaltel() {
		return _sk_principaltel;
	}

	public void set_sk_principaltel(String _sk_principaltel) {
		this._sk_principaltel = _sk_principaltel;
	}

}
