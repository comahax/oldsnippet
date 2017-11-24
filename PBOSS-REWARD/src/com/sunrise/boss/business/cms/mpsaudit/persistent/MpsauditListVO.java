/**
* auto-generated code
* Thu Oct 09 16:10:24 CST 2008
*/
package com.sunrise.boss.business.cms.mpsaudit.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: MpsauditListVO</p>
 * <p>Description: Query Params Object for MpsauditDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
public class MpsauditListVO extends BaseListVO {
    private String _snl_adtdate;
    private String _snm_adtdate;

    public String get_snl_adtdate(){
        return _snl_adtdate;
    }

    public void set_snl_adtdate(String _snl_adtdate){
        this._snl_adtdate = _snl_adtdate;
    }
    public String get_snm_adtdate(){
        return _snm_adtdate;
    }

    public void set_snm_adtdate(String _snm_adtdate){
        this._snm_adtdate = _snm_adtdate;
    }

}
