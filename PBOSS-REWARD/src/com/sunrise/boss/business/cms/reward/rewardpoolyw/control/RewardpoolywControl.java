/**
* auto-generated code
* Mon Sep 15 18:11:42 CST 2008
*/
package com.sunrise.boss.business.cms.reward.rewardpoolyw.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.rewardpoolyw.persistent.RewardpoolywVO;
import com.sunrise.boss.business.cms.reward.rewardpoolyw.persistent.RewardpoolywListVO;

import java.io.Serializable;

/**
 * <p>Title: RewardpoolywControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface RewardpoolywControl extends AbstractControl {
    public RewardpoolywVO doCreate(RewardpoolywVO vo, User user)
        throws Exception;

    public void doRemove(RewardpoolywVO vo, User user)
        throws Exception;

    public RewardpoolywVO doUpdate(RewardpoolywVO vo, User user)
        throws Exception;

    public RewardpoolywVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(RewardpoolywListVO params, User user)
        throws Exception;

}
