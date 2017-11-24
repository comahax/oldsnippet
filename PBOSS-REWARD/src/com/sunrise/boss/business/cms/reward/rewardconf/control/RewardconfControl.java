/**
* auto-generated code
* Fri Mar 06 14:15:03 CST 2009
*/
package com.sunrise.boss.business.cms.reward.rewardconf.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.rewardconf.persistent.RewardconfVO;
import com.sunrise.boss.business.cms.reward.rewardconf.persistent.RewardconfListVO;

import java.io.Serializable;
import java.util.List;

/**
 * <p>Title: RewardconfControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
public interface RewardconfControl extends AbstractControl {
    public RewardconfVO doCreate(RewardconfVO vo, User user)
        throws Exception;

    public void doRemove(RewardconfVO vo, User user)
        throws Exception;

    public RewardconfVO doUpdate(RewardconfVO vo, User user)
        throws Exception;

    public RewardconfVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(RewardconfListVO params, User user)
        throws Exception;
    
    public List doCheckRewardconf(String rewardmonth,
			String rewardkind, User user) throws Exception;

    public List doCheckUnRewardconf(String rewardmonth,
			String rewardkind, User user) throws Exception;
}
