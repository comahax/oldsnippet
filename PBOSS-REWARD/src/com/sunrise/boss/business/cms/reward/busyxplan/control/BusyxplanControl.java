/**
* auto-generated code
* Sat Feb 02 15:13:27 CST 2008
*/
package com.sunrise.boss.business.cms.reward.busyxplan.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.busyxplan.persistent.BusyxplanVO;
import com.sunrise.boss.business.cms.reward.busyxplan.persistent.BusyxplanListVO;

import java.io.Serializable;

/**
 * <p>Title: BusyxplanControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface BusyxplanControl extends AbstractControl {
    public BusyxplanVO doCreate(BusyxplanVO vo, User user)
        throws Exception;

    public void doRemove(BusyxplanVO vo, User user)
        throws Exception;

    public BusyxplanVO doUpdate(BusyxplanVO vo, User user)
        throws Exception;

    public BusyxplanVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(BusyxplanListVO params, User user)
        throws Exception;
    public DataPackage queryBusyxplan(BusyxplanListVO params,User user) throws Exception;
}
