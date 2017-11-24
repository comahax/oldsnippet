/**
* auto-generated code
* Sat Dec 06 16:11:20 CST 2008
*/
package com.sunrise.boss.business.cms.rewardpunish.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.rewardpunish.persistent.RewardpunishVO;
import com.sunrise.boss.business.cms.rewardpunish.persistent.RewardpunishListVO;

import java.io.Serializable;

/**
 * <p>Title: RewardpunishControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public interface RewardpunishControl extends AbstractControl {
    public RewardpunishVO doCreate(RewardpunishVO vo, User user)
        throws Exception;

    public void doRemove(RewardpunishVO vo, User user)
        throws Exception;

    public RewardpunishVO doUpdate(RewardpunishVO vo, User user)
        throws Exception;

    public RewardpunishVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(RewardpunishListVO params, User user)
        throws Exception;

}
