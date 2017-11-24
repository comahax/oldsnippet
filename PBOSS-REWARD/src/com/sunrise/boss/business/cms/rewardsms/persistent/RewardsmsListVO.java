/**
* auto-generated code
* Thu Jul 28 10:25:58 CST 2011
*/
package com.sunrise.boss.business.cms.rewardsms.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: RewardsmsListVO</p>
 * <p>Description: Query Params Object for RewardsmsDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yangdaren
 * @version 1.0
 */
public class RewardsmsListVO extends BaseListVO {
    private String _se_countyid;
    private String _se_calcmonth;
    private String _se_opercode;
    private String _se_opertype;

    public String get_se_countyid(){
        return _se_countyid;
    }

    public void set_se_countyid(String _se_countyid){
        this._se_countyid = _se_countyid;
    }
    public String get_se_calcmonth(){
        return _se_calcmonth;
    }

    public void set_se_calcmonth(String _se_calcmonth){
        this._se_calcmonth = _se_calcmonth;
    }
    public String get_se_opercode(){
        return _se_opercode;
    }

    public void set_se_opercode(String _se_opercode){
        this._se_opercode = _se_opercode;
    }
    public String get_se_opertype(){
        return _se_opertype;
    }

    public void set_se_opertype(String _se_opertype){
        this._se_opertype = _se_opertype;
    }

}
