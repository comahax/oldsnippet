/**
* auto-generated code
* Sat Jan 13 18:51:44 CST 2007
*/
package com.sunrise.boss.business.zifee.yxplancplog.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.zifee.yxplancplog.persistent.YxplancplogVO;
import com.sunrise.boss.business.zifee.yxplancplog.persistent.YxplancplogListVO;

import java.io.Serializable;

/**
 * <p>Title: YxplancplogControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author Cai Jianhui
 * @version 1.0
 */
public interface YxplancplogControl extends AbstractControl {
    public YxplancplogVO doCreate(YxplancplogVO vo, User user)
        throws Exception;

    public void doRemove(YxplancplogVO vo, User user)
        throws Exception;

    public YxplancplogVO doUpdate(YxplancplogVO vo, User user)
        throws Exception;

    public YxplancplogVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(YxplancplogListVO params, User user)
        throws Exception;

}
