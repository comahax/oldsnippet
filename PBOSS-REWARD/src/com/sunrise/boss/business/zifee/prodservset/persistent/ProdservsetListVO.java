/**
* auto-generated code
* Tue Mar 10 18:21:48 CST 2009
*/
package com.sunrise.boss.business.zifee.prodservset.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: ProdservsetListVO</p>
 * <p>Description: Query Params Object for ProdservsetDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
public class ProdservsetListVO extends BaseListVO {
    private String _ne_yxplanid;
    private String _ne_servelevel;
    private String _ne_busitype;
    private String _se_acctid;

    public String get_ne_yxplanid(){
        return _ne_yxplanid;
    }

    public void set_ne_yxplanid(String _ne_yxplanid){
        this._ne_yxplanid = _ne_yxplanid;
    }
    public String get_ne_servelevel(){
        return _ne_servelevel;
    }

    public void set_ne_servelevel(String _ne_servelevel){
        this._ne_servelevel = _ne_servelevel;
    }
    public String get_ne_busitype(){
        return _ne_busitype;
    }

    public void set_ne_busitype(String _ne_busitype){
        this._ne_busitype = _ne_busitype;
    }
    public String get_se_acctid(){
        return _se_acctid;
    }

    public void set_se_acctid(String _se_acctid){
        this._se_acctid = _se_acctid;
    }

}
