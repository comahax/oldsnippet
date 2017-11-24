/**
* auto-generated code
* Tue Dec 09 14:05:03 CST 2008
*/
package com.sunrise.boss.business.cms.rewardpunishlog.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.rewardpunishlog.persistent.RewardpunishlogVO;
import com.sunrise.boss.business.cms.rewardpunishlog.persistent.RewardpunishlogListVO;

import java.io.Serializable;

/**
 * <p>Title: RewardpunishlogControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public interface RewardpunishlogControl extends AbstractControl {
    public RewardpunishlogVO doCreate(RewardpunishlogVO vo, User user)
        throws Exception;

    public void doRemove(RewardpunishlogVO vo, User user)
        throws Exception;

    public RewardpunishlogVO doUpdate(RewardpunishlogVO vo, User user)
        throws Exception;

    public RewardpunishlogVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(RewardpunishlogListVO params, User user)
        throws Exception;

}
