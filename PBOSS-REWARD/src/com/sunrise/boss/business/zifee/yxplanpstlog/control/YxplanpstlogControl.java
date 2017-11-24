/**
* auto-generated code
* Tue Sep 18 16:17:01 CST 2007
*/
package com.sunrise.boss.business.zifee.yxplanpstlog.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.zifee.yxplanpstlog.persistent.YxplanpstlogVO;
import com.sunrise.boss.business.zifee.yxplanpstlog.persistent.YxplanpstlogListVO;

import java.io.Serializable;

/**
 * <p>Title: YxplanpstlogControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface YxplanpstlogControl extends AbstractControl {
    public YxplanpstlogVO doCreate(YxplanpstlogVO vo, User user)
        throws Exception;

    public void doRemove(YxplanpstlogVO vo, User user)
        throws Exception;

    public YxplanpstlogVO doUpdate(YxplanpstlogVO vo, User user)
        throws Exception;

    public YxplanpstlogVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(YxplanpstlogListVO params, User user)
        throws Exception;

}
