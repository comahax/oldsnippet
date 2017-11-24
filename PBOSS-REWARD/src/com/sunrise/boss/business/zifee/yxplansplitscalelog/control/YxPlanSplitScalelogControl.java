/**
* auto-generated code
* Thu Oct 26 10:38:36 CST 2006
*/
package com.sunrise.boss.business.zifee.yxplansplitscalelog.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.zifee.yxplansplitscalelog.persistent.YxPlanSplitScalelogVO;
import com.sunrise.boss.business.zifee.yxplansplitscalelog.persistent.YxPlanSplitScalelogListVO;

import java.io.Serializable;

/**
 * <p>Title: YxPlanSplitScalelogControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Danny(luozhoujie)
 * @version 1.0
 */
public interface YxPlanSplitScalelogControl extends AbstractControl {
    public YxPlanSplitScalelogVO doCreate(YxPlanSplitScalelogVO vo, User user)
        throws Exception;

    public void doRemove(YxPlanSplitScalelogVO vo, User user)
        throws Exception;

    public YxPlanSplitScalelogVO doUpdate(YxPlanSplitScalelogVO vo, User user)
        throws Exception;

    public YxPlanSplitScalelogVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(YxPlanSplitScalelogListVO params, User user)
        throws Exception;

}
