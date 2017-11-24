/**
* auto-generated code
* Mon Jan 29 11:36:20 CST 2007
*/
package com.sunrise.boss.business.cms.distribute.cpexamhistory.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: CpexamhistoryListVO</p>
 * <p>Description: Query Params Object for CpexamhistoryDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author Cai Jianhui
 * @version 1.0
 */
public class CpexamhistoryListVO extends BaseListVO {
    private String _se_cooperauid;
    private String _se_cooperalevel;
    private String _ne_fxtype;
    private String _ne_comtype;
    private String _dnl_optime;
    private String _dnm_optime;

    public String get_se_cooperauid(){
        return _se_cooperauid;
    }

    public void set_se_cooperauid(String _se_cooperauid){
        this._se_cooperauid = _se_cooperauid;
    }
    public String get_se_cooperalevel(){
        return _se_cooperalevel;
    }

    public void set_se_cooperalevel(String _se_cooperalevel){
        this._se_cooperalevel = _se_cooperalevel;
    }
    public String get_ne_fxtype(){
        return _ne_fxtype;
    }

    public void set_ne_fxtype(String _ne_fxtype){
        this._ne_fxtype = _ne_fxtype;
    }
    public String get_ne_comtype(){
        return _ne_comtype;
    }

    public void set_ne_comtype(String _ne_comtype){
        this._ne_comtype = _ne_comtype;
    }
    public String get_dnl_optime(){
        return _dnl_optime;
    }

    public void set_dnl_optime(String _dnl_optime){
        this._dnl_optime = _dnl_optime;
    }
    public String get_dnm_optime(){
        return _dnm_optime;
    }

    public void set_dnm_optime(String _dnm_optime){
        this._dnm_optime = _dnm_optime;
    }

}
