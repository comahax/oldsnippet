/**
* auto-generated code
* Mon Dec 28 10:41:51 CST 2009
*/
package com.sunrise.boss.business.cms.zjty.zjtybusyxplan.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.zjtybusyxplan.persistent.ZjtyBusyxplanVO;
import com.sunrise.boss.business.cms.zjty.zjtybusyxplan.persistent.ZjtyBusyxplanListVO;

import java.io.Serializable;

/**
 * <p>Title: ZjtyBusyxplanControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
public interface ZjtyBusyxplanControl extends AbstractControl {
    public ZjtyBusyxplanVO doCreate(ZjtyBusyxplanVO vo, User user)
        throws Exception;

    public void doRemove(ZjtyBusyxplanVO vo, User user)
        throws Exception;

    public ZjtyBusyxplanVO doUpdate(ZjtyBusyxplanVO vo, User user)
        throws Exception;

    public ZjtyBusyxplanVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(ZjtyBusyxplanListVO params, User user)
        throws Exception;

}
