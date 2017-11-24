/**
* auto-generated code
* Sat Aug 26 10:44:13 CST 2006
*/
package com.sunrise.boss.business.cms.wayaccount.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: WayaccountListVO</p>
 * <p>Description: Query Params Object for WayaccountDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author He Kun
 * @version 1.0
 */
public class WayaccountListVO extends BaseListVO {

    private Integer _ne_accid;
   
    private String _se_wayid;
    
    private String subtype;
    
    private String _se_acctno; //add by ydr 20110714

	public String getSubtype() {
		return subtype;
	}

	public void setSubtype(String subtype) {
		this.subtype = subtype;
	}

	/**
	 * @return Returns the _ne_accid.
	 */
	public Integer get_ne_accid() {
		return _ne_accid;
	}

	/**
	 * @param _ne_accid The _ne_accid to set.
	 */
	public void set_ne_accid(Integer _ne_accid) {
		this._ne_accid = _ne_accid;
	}

	/**
	 * @return Returns the _se_wayid.
	 */
	public String get_se_wayid() {
		return _se_wayid;
	}

	/**
	 * @param _se_wayid The _se_wayid to set.
	 */
	public void set_se_wayid(String _se_wayid) {
		this._se_wayid = _se_wayid;
	}

	public String get_se_acctno() {
		return _se_acctno;
	}

	public void set_se_acctno(String _se_acctno) {
		this._se_acctno = _se_acctno;
	}
}
