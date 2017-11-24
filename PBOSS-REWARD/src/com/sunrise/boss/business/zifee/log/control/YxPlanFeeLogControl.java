/**
* auto-generated code
* Sun Aug 20 11:47:03 CST 2006
*/
package com.sunrise.boss.business.zifee.log.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.business.zifee.log.persistent.YxPlanFeeLogVO;
import com.sunrise.boss.business.zifee.log.persistent.YxPlanFeeLogListVO;
import com.sunrise.boss.ui.commons.User;
import java.io.Serializable;

/**
 * <p>Title: YxPlanFeeLogControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Danny(luozhoujie)
 * @version 1.0
 */
public interface YxPlanFeeLogControl extends AbstractControl {
    public YxPlanFeeLogVO doCreate(YxPlanFeeLogVO vo, User user)
        throws Exception;

    public void doRemove(YxPlanFeeLogVO vo, User user)
        throws Exception;

    public YxPlanFeeLogVO doUpdate(YxPlanFeeLogVO vo, User user)
        throws Exception;

    public YxPlanFeeLogVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(YxPlanFeeLogListVO params, User user)
        throws Exception;

}
