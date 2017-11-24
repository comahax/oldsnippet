/**
* auto-generated code
* Wed Sep 04 21:16:54 CST 2013
*/
package com.sunrise.boss.business.cms.provagent.vchpdrprewardrecord.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: ChPdRprewardrecordListVO</p>
 * <p>Description: Query Params Object for ChPdRprewardrecordDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liyanling
 * @version 1.0
 */
public class VChPdRprewardrecordListVO extends BaseListVO {
    private String _se_provagentid;
    private String _se_prodno;
    private String _se_rewardmonth;
    private String _se_cityid;
    private String _se_prodid;
    public String get_se_provagentid(){
        return _se_provagentid;
    }

    public void set_se_provagentid(String _se_provagentid){
        this._se_provagentid = _se_provagentid;
    }
    public String get_se_prodno(){
        return _se_prodno;
    }

    public void set_se_prodno(String _se_prodno){
        this._se_prodno = _se_prodno;
    }
    public String get_se_rewardmonth(){
        return _se_rewardmonth;
    }

    public void set_se_rewardmonth(String _se_rewardmonth){
        this._se_rewardmonth = _se_rewardmonth;
    }
    public String get_se_cityid(){
        return _se_cityid;
    }

    public void set_se_cityid(String _se_cityid){
        this._se_cityid = _se_cityid;
    }

	public String get_se_prodid() {
		return _se_prodid;
	}

	public void set_se_prodid(String _se_prodid) {
		this._se_prodid = _se_prodid;
	}

}
