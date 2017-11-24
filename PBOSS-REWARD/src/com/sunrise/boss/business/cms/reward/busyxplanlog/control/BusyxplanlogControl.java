/**
* auto-generated code
* Sat Feb 02 15:15:28 CST 2008
*/
package com.sunrise.boss.business.cms.reward.busyxplanlog.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.busyxplanlog.persistent.BusyxplanlogVO;
import com.sunrise.boss.business.cms.reward.busyxplanlog.persistent.BusyxplanlogListVO;

import java.io.Serializable;

/**
 * <p>Title: BusyxplanlogControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface BusyxplanlogControl extends AbstractControl {
    public BusyxplanlogVO doCreate(BusyxplanlogVO vo, User user)
        throws Exception;

    public void doRemove(BusyxplanlogVO vo, User user)
        throws Exception;

    public BusyxplanlogVO doUpdate(BusyxplanlogVO vo, User user)
        throws Exception;

    public BusyxplanlogVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(BusyxplanlogListVO params, User user)
        throws Exception;

}
