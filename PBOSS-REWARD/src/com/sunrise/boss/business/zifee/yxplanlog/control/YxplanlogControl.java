/**
* auto-generated code
* Fri Oct 20 10:53:27 CST 2006
*/
package com.sunrise.boss.business.zifee.yxplanlog.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.zifee.yxplanlog.persistent.YxplanlogVO;
import com.sunrise.boss.business.zifee.yxplanlog.persistent.YxplanlogListVO;

import java.io.Serializable;

/**
 * <p>Title: YxplanlogControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author eboxdisc
 * @version 1.0
 */
public interface YxplanlogControl extends AbstractControl {
    public YxplanlogVO doCreate(YxplanlogVO vo, User user)
        throws Exception;

    public void doRemove(YxplanlogVO vo, User user)
        throws Exception;

    public YxplanlogVO doUpdate(YxplanlogVO vo, User user)
        throws Exception;

    public YxplanlogVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(YxplanlogListVO params, User user)
        throws Exception;

}
