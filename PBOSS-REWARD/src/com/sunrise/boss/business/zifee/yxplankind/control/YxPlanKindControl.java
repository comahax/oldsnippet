/**
* auto-generated code
* Fri Aug 25 10:34:46 CST 2006
*/
package com.sunrise.boss.business.zifee.yxplankind.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.zifee.yxplankind.persistent.YxPlanKindVO;
import com.sunrise.boss.business.zifee.yxplankind.persistent.YxPlanKindListVO;

import java.io.Serializable;


/**
 * <p>Title: YxPlanKindControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Danny(luozhoujie)
 * @version 1.0
 */
public interface YxPlanKindControl extends AbstractControl {
    public YxPlanKindVO doCreate(YxPlanKindVO vo, User user)
        throws Exception;


    public YxPlanKindVO doUpdate(YxPlanKindVO vo, User user)
        throws Exception;

    public YxPlanKindVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(YxPlanKindListVO params, User user)
        throws Exception;
    
    public void doRemoveByVO(YxPlanKindVO vo, User user) throws Exception;

    public void doRemoveByPK(Serializable pk, User user) throws Exception;

}
