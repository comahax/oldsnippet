/**
* auto-generated code
* Thu Oct 26 21:47:46 CST 2006
*/
package com.sunrise.boss.business.zifee.yxplantypelog.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.zifee.yxplantypelog.persistent.YxPlanTypelogVO;
import com.sunrise.boss.business.zifee.yxplantypelog.persistent.YxPlanTypelogListVO;

import java.io.Serializable;

/**
 * <p>Title: YxPlanTypelogControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Danny(luozhoujie)
 * @version 1.0
 */
public interface YxPlanTypelogControl extends AbstractControl {
    public YxPlanTypelogVO doCreate(YxPlanTypelogVO vo, User user)
        throws Exception;

    public void doRemove(YxPlanTypelogVO vo, User user)
        throws Exception;

    public YxPlanTypelogVO doUpdate(YxPlanTypelogVO vo, User user)
        throws Exception;

    public YxPlanTypelogVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(YxPlanTypelogListVO params, User user)
        throws Exception;

}
