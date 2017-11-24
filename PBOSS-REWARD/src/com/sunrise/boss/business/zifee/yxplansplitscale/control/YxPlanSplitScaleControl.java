/**
* auto-generated code
* Mon Aug 28 09:56:50 CST 2006
*/
package com.sunrise.boss.business.zifee.yxplansplitscale.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.zifee.yxplansplitscale.persistent.YxPlanSplitScaleVO;
import com.sunrise.boss.business.zifee.yxplansplitscale.persistent.YxPlanSplitScaleListVO;

import java.io.Serializable;


/**
 * <p>Title: YxPlanSplitScaleControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface YxPlanSplitScaleControl extends AbstractControl {
    public YxPlanSplitScaleVO doCreate(YxPlanSplitScaleVO vo, User user)
        throws Exception;


    public YxPlanSplitScaleVO doUpdate(YxPlanSplitScaleVO vo, User user)
        throws Exception;

    public YxPlanSplitScaleVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(YxPlanSplitScaleListVO params, User user)
        throws Exception;
    
    public void doRemoveByVO(YxPlanSplitScaleVO vo, User user) throws Exception;

    public void doRemoveByPK(Serializable pk, User user) throws Exception;

}
