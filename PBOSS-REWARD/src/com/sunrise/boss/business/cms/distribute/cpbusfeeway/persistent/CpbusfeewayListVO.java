/**
* auto-generated code
* Wed Dec 27 14:04:18 CST 2006
*/
package com.sunrise.boss.business.cms.distribute.cpbusfeeway.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: CpbusfeewayListVO</p>
 * <p>Description: Query Params Object for CpbusfeewayDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Danny(luozhoujie)
 * @version 1.0
 */
public class CpbusfeewayListVO extends BaseListVO {

	String _se_cpbusid;
	String _se_cooperauid;
	String _se_fxtype;
	String _se_busfeeway;
	

    public java.lang.String get_se_cooperauid() {
        return this._se_cooperauid;
    }

    public void set_se_cooperauid(java.lang.String _se_cooperauid) {
        this._se_cooperauid = _se_cooperauid;
    }

    public java.lang.String get_se_fxtype() {
        return this._se_fxtype;
    }

    public void set_se_fxtype(java.lang.String _se_fxtype) {
        this._se_fxtype = _se_fxtype;
    }

    public java.lang.String get_se_busfeeway() {
        return this._se_busfeeway;
    }

    public void set_se_busfeeway(java.lang.String _se_busfeeway) {
        this._se_busfeeway = _se_busfeeway;
    }
}
