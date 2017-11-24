/**
* auto-generated code
* Mon Sep 15 18:12:26 CST 2008
*/
package com.sunrise.boss.business.cms.reward.rewardpoolywlog.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.rewardpoolywlog.persistent.RewardpoolywlogVO;
import com.sunrise.boss.business.cms.reward.rewardpoolywlog.persistent.RewardpoolywlogListVO;

import java.io.Serializable;

/**
 * <p>Title: RewardpoolywlogControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface RewardpoolywlogControl extends AbstractControl {
    public RewardpoolywlogVO doCreate(RewardpoolywlogVO vo, User user)
        throws Exception;

    public void doRemove(RewardpoolywlogVO vo, User user)
        throws Exception;

    public RewardpoolywlogVO doUpdate(RewardpoolywlogVO vo, User user)
        throws Exception;

    public RewardpoolywlogVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(RewardpoolywlogListVO params, User user)
        throws Exception;

}
