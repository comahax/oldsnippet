/**
* auto-generated code
* Thu Oct 26 17:56:48 CST 2006
*/
package com.sunrise.boss.business.zifee.yxplangrouplog.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.zifee.yxplangrouplog.persistent.YxPlanGrouplogVO;
import com.sunrise.boss.business.zifee.yxplangrouplog.persistent.YxPlanGrouplogListVO;

import java.io.Serializable;

/**
 * <p>Title: YxPlanGrouplogControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Danny(luozhoujie)
 * @version 1.0
 */
public interface YxPlanGrouplogControl extends AbstractControl {
    public YxPlanGrouplogVO doCreate(YxPlanGrouplogVO vo, User user)
        throws Exception;

    public void doRemove(YxPlanGrouplogVO vo, User user)
        throws Exception;

    public YxPlanGrouplogVO doUpdate(YxPlanGrouplogVO vo, User user)
        throws Exception;

    public YxPlanGrouplogVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(YxPlanGrouplogListVO params, User user)
        throws Exception;

}
