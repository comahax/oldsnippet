/**
* auto-generated code
* Sat Jan 12 11:13:01 CST 2013
*/
package com.sunrise.boss.business.cms.chpwwaybusicircle.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.chpwwaybusicircle.persistent.ChPwWaybusicircleVO;
import com.sunrise.boss.business.cms.chpwwaybusicircle.persistent.ChPwWaybusicircleListVO;

import java.io.Serializable;

/**
 * <p>Title: ChPwWaybusicircleControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author hejw
 * @version 1.0
 */
public interface ChPwWaybusicircleControl extends AbstractControl {
    public ChPwWaybusicircleVO doCreate(ChPwWaybusicircleVO vo, User user)
        throws Exception;

    public void doRemove(ChPwWaybusicircleVO vo, User user)
        throws Exception;

    public ChPwWaybusicircleVO doUpdate(ChPwWaybusicircleVO vo, User user)
        throws Exception;

    public ChPwWaybusicircleVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(ChPwWaybusicircleListVO params, User user)
        throws Exception;

}
