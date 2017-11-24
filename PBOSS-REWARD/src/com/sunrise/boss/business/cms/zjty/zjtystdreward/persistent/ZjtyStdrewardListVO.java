/**
* auto-generated code
* Fri Dec 30 15:15:14 CST 2011
*/
package com.sunrise.boss.business.cms.zjty.zjtystdreward.persistent;

import java.util.List;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: ZjtyStdrewardListVO</p>
 * <p>Description: Query Params Object for ZjtyStdrewardDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author qiuzhi
 * @version 1.0
 */
public class ZjtyStdrewardListVO extends BaseListVO {
    private String _ne_seq;
    private String _se_opnid;
    private String _ne_cityid;
    private List _nin_cityid;

    public String get_ne_seq(){
        return _ne_seq;
    }

    public void set_ne_seq(String _ne_seq){
        this._ne_seq = _ne_seq;
    }
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

	public void set_nin_cityid(List ninCityid) {
		_nin_cityid = ninCityid;
	}

}
