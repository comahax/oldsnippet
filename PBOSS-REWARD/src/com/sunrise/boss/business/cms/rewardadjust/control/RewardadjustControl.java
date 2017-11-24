/**
* auto-generated code
* Wed Dec 24 11:06:41 CST 2008
*/
package com.sunrise.boss.business.cms.rewardadjust.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.rewardadjust.persistent.RewardadjustVO;
import com.sunrise.boss.business.cms.rewardadjust.persistent.RewardadjustListVO;

import java.io.Serializable;

/**
 * <p>Title: RewardadjustControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface RewardadjustControl extends AbstractControl {
    public RewardadjustVO doCreate(RewardadjustVO vo, User user)
        throws Exception;

    public void doRemove(RewardadjustVO vo, User user)
        throws Exception;

    public RewardadjustVO doUpdate(RewardadjustVO vo, User user)
        throws Exception;

    public RewardadjustVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(RewardadjustListVO params, User user)
        throws Exception;

}
