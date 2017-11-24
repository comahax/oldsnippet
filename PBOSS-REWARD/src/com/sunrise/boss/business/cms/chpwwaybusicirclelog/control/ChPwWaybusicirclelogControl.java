/**
* auto-generated code
* Sat Jan 12 11:20:42 CST 2013
*/
package com.sunrise.boss.business.cms.chpwwaybusicirclelog.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.chpwwaybusicirclelog.persistent.ChPwWaybusicirclelogVO;
import com.sunrise.boss.business.cms.chpwwaybusicirclelog.persistent.ChPwWaybusicirclelogListVO;

import java.io.Serializable;

/**
 * <p>Title: ChPwWaybusicirclelogControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author hejw
 * @version 1.0
 */
public interface ChPwWaybusicirclelogControl extends AbstractControl {
    public ChPwWaybusicirclelogVO doCreate(ChPwWaybusicirclelogVO vo, User user)
        throws Exception;

    public void doRemove(ChPwWaybusicirclelogVO vo, User user)
        throws Exception;

    public ChPwWaybusicirclelogVO doUpdate(ChPwWaybusicirclelogVO vo, User user)
        throws Exception;

    public ChPwWaybusicirclelogVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(ChPwWaybusicirclelogListVO params, User user)
        throws Exception;

}
