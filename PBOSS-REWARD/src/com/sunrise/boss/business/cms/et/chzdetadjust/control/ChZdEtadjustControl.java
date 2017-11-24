/**
* auto-generated code
* Thu May 09 16:24:13 CST 2013
*/
package com.sunrise.boss.business.cms.et.chzdetadjust.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.et.chzdetadjust.persistent.ChZdEtadjustVO;
import com.sunrise.boss.business.cms.et.chzdetadjust.persistent.ChZdEtadjustListVO;

import java.io.Serializable;

/**
 * <p>Title: ChZdEtadjustControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Qiu Zhi
 * @version 1.0
 */
public interface ChZdEtadjustControl extends AbstractControl {
    public ChZdEtadjustVO doCreate(ChZdEtadjustVO vo, User user)
        throws Exception;

    public void doRemove(ChZdEtadjustVO vo, User user)
        throws Exception;

    public ChZdEtadjustVO doUpdate(ChZdEtadjustVO vo, User user)
        throws Exception;

    public ChZdEtadjustVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(ChZdEtadjustListVO params, User user)
        throws Exception;

}
