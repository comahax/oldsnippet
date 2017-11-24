/**
* auto-generated code
* Mon Jan 04 14:36:51 CST 2010
*/
package com.sunrise.boss.business.cms.bbc.mmopn.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: MmopnListVO</p>
 * <p>Description: Query Params Object for MmopnDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimyy
 * @version 1.0
 */
public class MmopnListVO extends BaseListVO {
    private String _se_opnid;
    private String _sk_name;
    private String _snl_opnid;
    private String _snm_opnid;
    public String get_snl_opnid() {
		return _snl_opnid;
	}

	public void set_snl_opnid(String _snl_opnid) {
		this._snl_opnid = _snl_opnid;
	}

	public String get_snm_opnid() {
		return _snm_opnid;
	}

	public void set_snm_opnid(String _snm_opnid) {
		this._snm_opnid = _snm_opnid;
	}

	public String get_se_opnid(){
        return _se_opnid;
    }

    public void set_se_opnid(String _se_opnid){
        this._se_opnid = _se_opnid;
    }
    public String get_sk_name(){
        return _sk_name;
    }

    public void set_sk_name(String _sk_name){
        this._sk_name = _sk_name;
    }

}
