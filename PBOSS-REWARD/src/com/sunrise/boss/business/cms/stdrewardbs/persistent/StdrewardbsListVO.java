/**
* auto-generated code
* Fri Feb 01 18:12:16 CST 2008
*/
package com.sunrise.boss.business.cms.stdrewardbs.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: StdrewardbsListVO</p>
 * <p>Description: Query Params Object for StdrewardbsDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0 
 */
public class StdrewardbsListVO extends BaseListVO {
    private String _ne_rewardid;
    private String _se_region;
    private String _ne_islimt;
    private String _se_slv;
    private String _ne_citystd;
    private String _ne_countrystd;
    private String _snk_rewardid;
    
    public String get_snk_rewardid() {
		return _snk_rewardid;
	}

	public void set_snk_rewardid(String _snk_rewardid) {
		this._snk_rewardid = _snk_rewardid;
	}

	public String get_ne_rewardid(){
        return _ne_rewardid;
    }

    public void set_ne_rewardid(String _ne_rewardid){
        this._ne_rewardid = _ne_rewardid;
    }
    public String get_se_region(){
        return _se_region;
    }

    public void set_se_region(String _se_region){
        this._se_region = _se_region;
    }
    public String get_ne_islimt(){
        return _ne_islimt;
    }

    public void set_ne_islimt(String _ne_islimt){
        this._ne_islimt = _ne_islimt;
    }
    public String get_se_slv(){
        return _se_slv;
    }

    public void set_se_slv(String _se_slv){
        this._se_slv = _se_slv;
    }
    public String get_ne_citystd(){
        return _ne_citystd;
    }

    public void set_ne_citystd(String _ne_citystd){
        this._ne_citystd = _ne_citystd;
    }
    public String get_ne_countrystd(){
        return _ne_countrystd;
    }

    public void set_ne_countrystd(String _ne_countrystd){
        this._ne_countrystd = _ne_countrystd;
    }

}
