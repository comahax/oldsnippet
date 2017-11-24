/**
* auto-generated code
* Wed Nov 02 19:11:53 CST 2011
*/
package com.sunrise.boss.business.cms.reward.rewardslvlimit.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.rewardslvlimit.persistent.RewardslvlimitVO;
import com.sunrise.boss.business.cms.reward.rewardslvlimit.persistent.RewardslvlimitListVO;

import java.io.Serializable;

/**
 * <p>Title: RewardslvlimitControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Shi Xiaolong
 * @version 1.0
 */
public interface RewardslvlimitControl extends AbstractControl {
    public RewardslvlimitVO doCreate(RewardslvlimitVO vo, User user)
        throws Exception;

    public void doRemove(RewardslvlimitVO vo, User user)
        throws Exception;

    public RewardslvlimitVO doUpdate(RewardslvlimitVO vo, User user)
        throws Exception;

    public RewardslvlimitVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(RewardslvlimitListVO params, User user)
        throws Exception;

}
