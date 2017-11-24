/**
* auto-generated code
* Mon Aug 21 16:04:22 CST 2006
*/
package com.sunrise.boss.business.zifee.areagroupinfo.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: AreaGroupInfoListVO</p>
 * <p>Description: Query Params Object for AreaGroupInfoDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Danny(luozhoujie)
 * @version 1.0
 */
public class AreaGroupInfoListVO extends BaseListVO {

	private String _sk_remark;
	private String _ne_state;
	private String _sk_areatype;
	private String _ne_areagroupid;

	public java.lang.String get_ne_state() {
        return this._ne_state;
    }

    public void set_ne_state(java.lang.String _ne_state) {
        this._ne_state = _ne_state;
    }
    
    public java.lang.String get_sk_areatype() {
        return this._sk_areatype;
    }

    public void set_sk_areatype(java.lang.String _sk_areatype) {
        this._sk_areatype = _sk_areatype;
    }
	
	public java.lang.String get_sk_remark() {
        return this._sk_remark;
    }

    public void set_sk_remark(java.lang.String _sk_remark) {
        this._sk_remark = _sk_remark;
    }
    
    public java.lang.String get_ne_areagroupid() {
        return this._ne_areagroupid;
    }

    public void set_ne_areagroupid(java.lang.String _ne_areagroupid) {
        this._ne_areagroupid = _ne_areagroupid;
    }
}
