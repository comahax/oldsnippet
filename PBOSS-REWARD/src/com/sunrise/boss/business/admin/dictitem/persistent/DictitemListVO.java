/**
* auto-generated code
* Thu Sep 21 16:09:09 CST 2006
*/
package com.sunrise.boss.business.admin.dictitem.persistent;

import java.util.List;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: DictitemListVO</p>
 * <p>Description: Query Params Object for DictitemDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author eboxdisc
 * @version 1.0
 */
public class DictitemListVO extends BaseListVO {
	private String _se_dictid;
	private String _se_groupid;
	
	private String _se_dictname ;
	private String _sk_dictid;
	
	private String _sk_dictname ;
	private String _sne_dictid;
	private String _ssw_description;
	private String _sk_description;
	
	
	private List _snin_dictid;
	
	public String get_ssw_description() {
		return _ssw_description;
	}
	public void set_ssw_description(String _ssw_description) {
		this._ssw_description = _ssw_description;
	}
	public String get_se_dictname() {
		return _se_dictname;
	}
	public void set_se_dictname(String _se_dictname) {
		this._se_dictname = _se_dictname;
	}
	public String get_se_dictid() {
		return _se_dictid;
	}
	public void set_se_dictid(String _se_dictid) {
		this._se_dictid = _se_dictid;
	}
	public String get_se_groupid() {
		return _se_groupid;
	}
	public void set_se_groupid(String _se_groupid) {
		this._se_groupid = _se_groupid;
	}
	public String get_sk_dictname() {
		return _sk_dictname;
	}
	public void set_sk_dictname(String _sk_dictname) {
		this._sk_dictname = _sk_dictname;
	}
	public String get_sne_dictid() {
		return _sne_dictid;
	}
	public void set_sne_dictid(String _sne_dictid) {
		this._sne_dictid = _sne_dictid;
	}
	public List get_snin_dictid() {
		return _snin_dictid;
	}
	public void set_snin_dictid(List _snin_dictid) {
		this._snin_dictid = _snin_dictid;
	}
	public String get_sk_dictid() {
		return _sk_dictid;
	}
	public void set_sk_dictid(String _sk_dictid) {
		this._sk_dictid = _sk_dictid;
	}
	public String get_sk_description() {
		return _sk_description;
	}
	public void set_sk_description(String _sk_description) {
		this._sk_description = _sk_description;
	}
	

}
