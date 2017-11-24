/**
* auto-generated code
* Tue Sep 03 21:23:23 CST 2013
*/
package com.sunrise.boss.business.cms.provagent.chpdsubscription.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: ChPdSubscriptionListVO</p>
 * <p>Description: Query Params Object for ChPdSubscriptionDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Qiu Zhi
 * @version 1.0
 */
public class ChPdSubscriptionListVO extends BaseListVO {
    private String _se_provagentid;
    private String _se_prodno;
    private String _se_prodid;
    private String _se_cityid;

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
    public String get_se_prodid(){
        return _se_prodid;
    }

    public void set_se_prodid(String _se_prodid){
        this._se_prodid = _se_prodid;
    }
    public String get_se_cityid(){
        return _se_cityid;
    }

    public void set_se_cityid(String _se_cityid){
        this._se_cityid = _se_cityid;
    }

}
