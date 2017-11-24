/**
* auto-generated code
* Tue Aug 21 12:28:54 CST 2012
*/
package com.sunrise.boss.business.cms.chadtdcordhis.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.chadtdcordhis.persistent.ChAdtDcordhisVO;
import com.sunrise.boss.business.cms.chadtdcordhis.persistent.ChAdtDcordhisListVO;

import java.io.Serializable;

/**
 * <p>Title: ChAdtDcordhisControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liyanling
 * @version 1.0
 */
public interface ChAdtDcordhisControl extends AbstractControl {
    public ChAdtDcordhisVO doCreate(ChAdtDcordhisVO vo, User user)
        throws Exception;

    public void doRemove(ChAdtDcordhisVO vo, User user)
        throws Exception;

    public ChAdtDcordhisVO doUpdate(ChAdtDcordhisVO vo, User user)
        throws Exception;

    public ChAdtDcordhisVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(ChAdtDcordhisListVO params, User user)
        throws Exception;

}
