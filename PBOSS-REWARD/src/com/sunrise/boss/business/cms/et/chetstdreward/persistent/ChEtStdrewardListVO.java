/**
* auto-generated code
* Tue Jul 17 16:46:57 CST 2012
*/
package com.sunrise.boss.business.cms.et.chetstdreward.persistent;

import java.util.List;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: ChEtStdrewardListVO</p>
 * <p>Description: Query Params Object for ChEtStdrewardDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liyanling
 * @version 1.0
 */
public class ChEtStdrewardListVO extends BaseListVO {
    private String _se_opnid;
    private String _ne_cityid;
    private List _nin_cityid;
    public String get_se_opnid(){
        return _se_opnid;
    }

    public void set_se_opnid(String _se_opnid){
        this._se_opnid = _se_opnid;
    }
    public String get_ne_cityid(){
        return _ne_cityid;
    }

    public void set_ne_cityid(String _ne_cityid){
        this._ne_cityid = _ne_cityid;
    }

	public List get_nin_cityid() {
		return _nin_cityid;
	}

	public void set_nin_cityid(List _nin_cityid) {
		this._nin_cityid = _nin_cityid;
	}

}
