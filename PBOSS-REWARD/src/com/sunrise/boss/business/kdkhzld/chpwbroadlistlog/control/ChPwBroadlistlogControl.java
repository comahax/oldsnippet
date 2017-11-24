/**
* auto-generated code
* Tue Sep 18 15:04:18 CST 2012
*/
package com.sunrise.boss.business.kdkhzld.chpwbroadlistlog.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.kdkhzld.chpwbroadlistlog.persistent.ChPwBroadlistlogVO;
import com.sunrise.boss.business.kdkhzld.chpwbroadlistlog.persistent.ChPwBroadlistlogListVO;

import java.io.Serializable;

/**
 * <p>Title: ChPwBroadlistlogControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author dengxx
 * @version 1.0
 */
public interface ChPwBroadlistlogControl extends AbstractControl {
    public ChPwBroadlistlogVO doCreate(ChPwBroadlistlogVO vo, User user)
        throws Exception;

    public void doRemove(ChPwBroadlistlogVO vo, User user)
        throws Exception;

    public ChPwBroadlistlogVO doUpdate(ChPwBroadlistlogVO vo, User user)
        throws Exception;

    public ChPwBroadlistlogVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(ChPwBroadlistlogListVO params, User user)
        throws Exception;

}
