/**
* auto-generated code
* Fri May 02 07:02:06 CST 2008
*/
package com.sunrise.boss.business.cms.costcard.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: CostcardListVO</p>
 * <p>Description: Query Params Object for CostcardDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class CostcardListVO extends BaseListVO {
    private String _se_wayid;
    private String _se_calcmonth;
    private String _se_opnid;
    
    public String get_se_wayid(){
        return _se_wayid;
    }

    public void set_se_wayid(String _se_wayid){
        this._se_wayid = _se_wayid;
    }
    public String get_se_calcmonth(){
        return _se_calcmonth;
    }

    public void set_se_calcmonth(String _se_calcmonth){
        this._se_calcmonth = _se_calcmonth;
    }
    public String get_se_opnid(){
        return _se_opnid;
    }

    public void set_se_opnid(String _se_opnid){
        this._se_opnid = _se_opnid;
    }

}
