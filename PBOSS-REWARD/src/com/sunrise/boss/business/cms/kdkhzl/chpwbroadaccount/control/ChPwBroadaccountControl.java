/**
* auto-generated code
* Tue Aug 21 10:45:16 CST 2012
*/
package com.sunrise.boss.business.cms.kdkhzl.chpwbroadaccount.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.kdkhzl.chpwbroadaccount.persistent.ChPwBroadaccountVO;
import com.sunrise.boss.business.cms.kdkhzl.chpwbroadaccount.persistent.ChPwBroadaccountListVO;

import java.io.Serializable;

/**
 * <p>Title: ChPwBroadaccountControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author dengxx
 * @version 1.0
 */
public interface ChPwBroadaccountControl extends AbstractControl {
    public ChPwBroadaccountVO doCreate(ChPwBroadaccountVO vo, User user)
        throws Exception;

    public void doRemove(ChPwBroadaccountVO vo, User user)
        throws Exception;

    public ChPwBroadaccountVO doUpdate(ChPwBroadaccountVO vo, User user)
        throws Exception;

    public ChPwBroadaccountVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(ChPwBroadaccountListVO params, User user)
        throws Exception;

}
