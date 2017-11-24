/**
* auto-generated code
* Fri Jul 08 09:50:15 CST 2011
*/
package com.sunrise.boss.business.cms.salereward.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.salereward.persistent.SalerewardVO;
import com.sunrise.boss.business.cms.salereward.persistent.SalerewardListVO;

import java.io.Serializable;

/**
 * <p>Title: SalerewardControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
public interface SalerewardControl extends AbstractControl {
    public SalerewardVO doCreate(SalerewardVO vo, User user)
        throws Exception;

    public void doRemove(SalerewardVO vo, User user)
        throws Exception;

    public SalerewardVO doUpdate(SalerewardVO vo, User user)
        throws Exception;

    public SalerewardVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(SalerewardListVO params, User user)
        throws Exception;

}
