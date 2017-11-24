/**
* auto-generated code
* Fri May 27 12:04:23 CST 2011
*/
package com.sunrise.boss.business.cms.reward.tax.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: TaxListVO</p>
 * <p>Description: Query Params Object for TaxDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yangdaren
 * @version 1.0
 */
public class TaxListVO extends BaseListVO {
    private String _ne_cityid;
    private String _ne_taxtype;
    private String _se_parameter;

    public String get_ne_cityid(){
        return _ne_cityid;
    }

    public void set_ne_cityid(String _ne_cityid){
        this._ne_cityid = _ne_cityid;
    }
    public String get_ne_taxtype(){
        return _ne_taxtype;
    }

    public void set_ne_taxtype(String _ne_taxtype){
        this._ne_taxtype = _ne_taxtype;
    }
    public String get_se_parameter(){
        return _se_parameter;
    }

    public void set_se_parameter(String _se_parameter){
        this._se_parameter = _se_parameter;
    }

}
