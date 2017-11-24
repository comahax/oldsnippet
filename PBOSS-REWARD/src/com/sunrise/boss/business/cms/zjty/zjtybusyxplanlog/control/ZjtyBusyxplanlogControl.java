/**
* auto-generated code
* Tue Jan 12 09:53:03 CST 2010
*/
package com.sunrise.boss.business.cms.zjty.zjtybusyxplanlog.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.zjtybusyxplanlog.persistent.ZjtyBusyxplanlogVO;
import com.sunrise.boss.business.cms.zjty.zjtybusyxplanlog.persistent.ZjtyBusyxplanlogListVO;

import java.io.Serializable;

/**
 * <p>Title: ZjtyBusyxplanlogControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public interface ZjtyBusyxplanlogControl extends AbstractControl {
    public ZjtyBusyxplanlogVO doCreate(ZjtyBusyxplanlogVO vo, User user)
        throws Exception;

    public void doRemove(ZjtyBusyxplanlogVO vo, User user)
        throws Exception;

    public ZjtyBusyxplanlogVO doUpdate(ZjtyBusyxplanlogVO vo, User user)
        throws Exception;

    public ZjtyBusyxplanlogVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(ZjtyBusyxplanlogListVO params, User user)
        throws Exception;

}
