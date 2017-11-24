/**
* auto-generated code
* Thu Aug 31 16:01:07 CST 2006
*/
package com.sunrise.boss.business.zifee.yxplansplitvalue.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.zifee.yxplansplitvalue.persistent.YxPlanSplitValueVO;
import com.sunrise.boss.business.zifee.yxplansplitvalue.persistent.YxPlanSplitValueListVO;

import java.io.Serializable;


/**
 * <p>Title: YxPlanSplitValueControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface YxPlanSplitValueControl extends AbstractControl {
    public YxPlanSplitValueVO doCreate(YxPlanSplitValueVO vo, User user)
        throws Exception;

    public YxPlanSplitValueVO doUpdate(YxPlanSplitValueVO vo, User user)
        throws Exception;

    public YxPlanSplitValueVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(YxPlanSplitValueListVO params, User user)
        throws Exception;
    public void doRemoveByVO(YxPlanSplitValueVO vo, User user) throws Exception;

    public void doRemoveByPK(Serializable pk, User user) throws Exception;

}
