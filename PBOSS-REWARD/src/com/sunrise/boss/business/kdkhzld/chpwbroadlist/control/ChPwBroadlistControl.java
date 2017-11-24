/**
* auto-generated code
* Tue Sep 18 14:59:25 CST 2012
*/
package com.sunrise.boss.business.kdkhzld.chpwbroadlist.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.kdkhzld.chpwbroadlist.persistent.ChPwBroadlistVO;
import com.sunrise.boss.business.kdkhzld.chpwbroadlist.persistent.ChPwBroadlistListVO;

import java.io.Serializable;

/**
 * <p>Title: ChPwBroadlistControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author dengxx
 * @version 1.0
 */
public interface ChPwBroadlistControl extends AbstractControl {
    public ChPwBroadlistVO doCreate(ChPwBroadlistVO vo, User user)
        throws Exception;

    public void doRemove(ChPwBroadlistVO vo, User user)
        throws Exception;

    public ChPwBroadlistVO doUpdate(ChPwBroadlistVO vo, User user)
        throws Exception;

    public ChPwBroadlistVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(ChPwBroadlistListVO params, User user)
        throws Exception;

}
