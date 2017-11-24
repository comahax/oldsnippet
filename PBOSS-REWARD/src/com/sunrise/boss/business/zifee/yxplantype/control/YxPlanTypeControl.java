/**
* auto-generated code
* Fri Aug 25 10:29:42 CST 2006
*/
package com.sunrise.boss.business.zifee.yxplantype.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.business.zifee.yxplantype.persistent.YxPlanTypeVO;
import com.sunrise.boss.business.zifee.yxplantype.persistent.YxPlanTypeListVO;
import com.sunrise.boss.ui.commons.User;
import java.io.Serializable;


/**
 * <p>Title: YxPlanTypeControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Danny(luozhoujie)
 * @version 1.0
 */
public interface YxPlanTypeControl extends AbstractControl {
    public YxPlanTypeVO doCreate(YxPlanTypeVO vo, User user)
        throws Exception;

    public YxPlanTypeVO doUpdate(YxPlanTypeVO vo, User user)
        throws Exception;

    public YxPlanTypeVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(YxPlanTypeListVO params, User user)
        throws Exception;
    
    public void doRemoveByVO(YxPlanTypeVO vo, User user) throws Exception;

    public void doRemoveByPK(Serializable pk, User user) throws Exception;

}
