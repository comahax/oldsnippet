/**
* auto-generated code
* Mon Dec 19 14:58:12 CST 2011
*/
package com.sunrise.boss.ui.cms.chadtdictidname;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.chadtdictidname.persistent.ChAdtDictidnameVO;

/**
 * <p>Title: ChAdtDictidnameForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author limin
 * @version 1.0
 */
public class ChAdtDictidnameForm extends BaseActionForm {

    private java.lang.String groupid;
    private java.lang.String dictid;
    private java.lang.String dictname;
    private java.util.Date optime;
    private java.lang.String oprcode;

    private String _se_dictid;
    private String _sk_description;

    
    
    
    
	private String _se_groupid;
    private String dictitemdictid;
    private String _sne_dictid;
    /** identifier field */
    private String dictitemgroupid;

    /** nullable persistent field */
    private String dictitemdictname;

    /** nullable persistent field */
    private String description;

    /** nullable persistent field */
    private Short sortorder;

    /** nullable persistent field */
    private Short status;

    /** nullable persistent field */
    private java.sql.Timestamp statusdate;
    
    
    
    public java.lang.String getGroupid(){
        return groupid;
    }

    public void setGroupid(java.lang.String groupid){
        this.groupid = groupid;
    }
    public java.lang.String getDictid(){
        return dictid;
    }

    public void setDictid(java.lang.String dictid){
        this.dictid = dictid;
    }
    public java.lang.String getDictname(){
        return dictname;
    }

    public void setDictname(java.lang.String dictname){
        this.dictname = dictname;
    }
    public java.util.Date getOptime(){
        return optime;
    }

    public void setOptime(java.util.Date optime){
        this.optime = optime;
    }
    public java.lang.String getOprcode(){
        return oprcode;
    }

    public void setOprcode(java.lang.String oprcode){
        this.oprcode = oprcode;
    }

    public String get_se_dictid(){
        return _se_dictid;
    }

    public void set_se_dictid(String _se_dictid){
        this._se_dictid = _se_dictid;
    }



	public String get_sk_description() {
		return _sk_description;
	}

	public void set_sk_description(String _sk_description) {
		this._sk_description = _sk_description;
	}

	public String get_se_groupid() {
		return _se_groupid;
	}

	public void set_se_groupid(String _se_groupid) {
		this._se_groupid = _se_groupid;
	}

	public String getDictitemdictid() {
		return dictitemdictid;
	}

	public void setDictitemdictid(String dictitemdictid) {
		this.dictitemdictid = dictitemdictid;
	}

	public String get_sne_dictid() {
		return _sne_dictid;
	}

	public void set_sne_dictid(String _sne_dictid) {
		this._sne_dictid = _sne_dictid;
	}

	public String getDictitemgroupid() {
		return dictitemgroupid;
	}

	public void setDictitemgroupid(String dictitemgroupid) {
		this.dictitemgroupid = dictitemgroupid;
	}

	public String getDictitemdictname() {
		return dictitemdictname;
	}

	public void setDictitemdictname(String dictitemdictname) {
		this.dictitemdictname = dictitemdictname;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

}
