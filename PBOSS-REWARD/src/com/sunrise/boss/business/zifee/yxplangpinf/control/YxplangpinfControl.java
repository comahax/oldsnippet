/**
* auto-generated code
* Sat Jan 13 14:53:14 CST 2007
*/
package com.sunrise.boss.business.zifee.yxplangpinf.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.zifee.yxplangpinf.persistent.YxplangpinfVO;
import com.sunrise.boss.business.zifee.yxplangpinf.persistent.YxplangpinfListVO;

import java.io.Serializable;

/**
 * <p>Title: YxplangpinfControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Danny(luozhoujie)
 * @version 1.0
 */
public interface YxplangpinfControl extends AbstractControl {
    public YxplangpinfVO doCreate(YxplangpinfVO vo, User user)
        throws Exception;

    public void doRemove(YxplangpinfVO vo, User user)
        throws Exception;

    public YxplangpinfVO doUpdate(YxplangpinfVO vo, User user)
        throws Exception;

    public YxplangpinfVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(YxplangpinfListVO params, User user)
        throws Exception;

}
