/**
* auto-generated code
* Sat Jan 13 14:53:15 CST 2007
*/
package com.sunrise.boss.ui.zifee.yxplangpinf;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.zifee.yxplangpinf.persistent.YxplangpinfVO;

/**
 * <p>Title: YxplangpinfForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Danny(luozhoujie)
 * @version 1.0
 */
public class YxplangpinfForm extends BaseActionForm {

	private String _ne_groupid;
	private String _sk_groupname;
	private String _se_areacode;

	public String get_ne_groupid() {
		return _ne_groupid;
	}
	public void set_ne_groupid(String _ne_groupid) {
		this._ne_groupid = _ne_groupid;
	}
	public String get_sk_groupname() {
		return _sk_groupname;
	}
	public void set_sk_groupname(String _sk_groupname) {
		this._sk_groupname = _sk_groupname;
	}
	public String get_se_areacode() {
		return _se_areacode;
	}

	public void set_se_areacode(String _se_areacode) {
		this._se_areacode = _se_areacode;
	}
	
    /** identifier field */
    private Long groupid;

    /** nullable persistent field */
    private String groupname;

    /** nullable persistent field */
    private String areacode;

    /** nullable persistent field */
    private String remark;

    /** default constructor */
    public YxplangpinfForm() {
    }


    public java.lang.Long getGroupid() {
        return this.groupid;
    }

    public void setGroupid(java.lang.Long groupid) {
        this.groupid = groupid;
    }

    public java.lang.String getGroupname() {
        return this.groupname;
    }

    public void setGroupname(java.lang.String groupname) {
        this.groupname = groupname;
    }

    public java.lang.String getAreacode() {
        return this.areacode;
    }

    public void setAreacode(java.lang.String areacode) {
        this.areacode = areacode;
    }

    public java.lang.String getRemark() {
        return this.remark;
    }

    public void setRemark(java.lang.String remark) {
        this.remark = remark;
    }


}
