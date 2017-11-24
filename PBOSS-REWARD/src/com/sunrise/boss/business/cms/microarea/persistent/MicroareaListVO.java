/**
* auto-generated code
* Wed Apr 11 10:59:58 CST 2007
*/
package com.sunrise.boss.business.cms.microarea.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: MicroareaListVO</p>
 * <p>Description: Query Params Object for MicroareaDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author Ye Daoe
 * @version 1.0
 */
public class MicroareaListVO extends BaseListVO {
    private String _se_macode;
    private String _se_svccode;
    private String _sk_maname;

    public String get_se_macode(){
        return _se_macode;
    }

    public void set_se_macode(String _se_macode){
        this._se_macode = _se_macode;
    }
    public String get_se_svccode(){
        return _se_svccode;
    }

    public void set_se_svccode(String _se_svccode){
        this._se_svccode = _se_svccode;
    }
    public String get_sk_maname(){
        return _sk_maname;
    }

    public void set_sk_maname(String _sk_maname){
        this._sk_maname = _sk_maname;
    }

}
