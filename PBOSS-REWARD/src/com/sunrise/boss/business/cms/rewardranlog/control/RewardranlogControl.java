/**
* auto-generated code
* Thu Jul 28 20:52:00 CST 2011
*/
package com.sunrise.boss.business.cms.rewardranlog.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.rewardranlog.persistent.RewardranlogVO;
import com.sunrise.boss.business.cms.rewardranlog.persistent.RewardranlogListVO;

import java.io.Serializable;

/**
 * <p>Title: RewardranlogControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yangdaren
 * @version 1.0
 */
public interface RewardranlogControl extends AbstractControl {
    public RewardranlogVO doCreate(RewardranlogVO vo, User user)
        throws Exception;

    public void doRemove(RewardranlogVO vo, User user)
        throws Exception;

    public RewardranlogVO doUpdate(RewardranlogVO vo, User user)
        throws Exception;

    public RewardranlogVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(RewardranlogListVO params, User user)
        throws Exception;

}
