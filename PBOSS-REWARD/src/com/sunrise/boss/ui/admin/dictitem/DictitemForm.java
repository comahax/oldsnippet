/**
* auto-generated code
* Thu Sep 21 16:09:09 CST 2006
*/
package com.sunrise.boss.ui.admin.dictitem;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.admin.dictitem.persistent.DictitemVO;

/**
 * <p>Title: DictitemForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author eboxdisc
 * @version 1.0
 */
public class DictitemForm extends BaseActionForm {
	  /** identifier field */
	
	private String _se_dictid;
	private String _se_groupid;
    private String dictid;
    private String _sne_dictid;
    /** identifier field */
    private String groupid;

    /** nullable persistent field */
    private String dictname;

    /** nullable persistent field */
    private String description;

    /** nullable persistent field */
    private Short sortorder;

    /** nullable persistent field */
    private Short status;

    /** nullable persistent field */
    private java.sql.Timestamp statusdate;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDictid() {
		return dictid;
	}

	public void setDictid(String dictid) {
		this.dictid = dictid;
	}

	public String getDictname() {
		return dictname;
	}

	public void setDictname(String dictname) {
		this.dictname = dictname;
	}

	public String getGroupid() {
		return groupid;
	}

	public void setGroupid(String groupid) {
		this.groupid = groupid;
	}

	public Short getSortorder() {
		return sortorder;
	}

	public void setSortorder(Short sortorder) {
		this.sortorder = sortorder;
	}

	public Short getStatus() {
		return status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	public java.sql.Timestamp getStatusdate() {
		return statusdate;
	}

	public void setStatusdate(java.sql.Timestamp statusdate) {
		this.statusdate = statusdate;
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

	public String get_sne_dictid() {
		return _sne_dictid;
	}

	public void set_sne_dictid(String _sne_dictid) {
		this._sne_dictid = _sne_dictid;
	}
}
