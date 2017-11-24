/**
* auto-generated code
* Thu Oct 26 21:50:00 CST 2006
*/
package com.sunrise.boss.business.zifee.yxplankindlog.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.zifee.yxplankindlog.persistent.YxPlanKindlogVO;
import com.sunrise.boss.business.zifee.yxplankindlog.persistent.YxPlanKindlogListVO;

import java.io.Serializable;

/**
 * <p>Title: YxPlanKindlogControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Danny(luozhoujie)
 * @version 1.0
 */
public interface YxPlanKindlogControl extends AbstractControl {
    public YxPlanKindlogVO doCreate(YxPlanKindlogVO vo, User user)
        throws Exception;

    public void doRemove(YxPlanKindlogVO vo, User user)
        throws Exception;

    public YxPlanKindlogVO doUpdate(YxPlanKindlogVO vo, User user)
        throws Exception;

    public YxPlanKindlogVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(YxPlanKindlogListVO params, User user)
        throws Exception;

}
