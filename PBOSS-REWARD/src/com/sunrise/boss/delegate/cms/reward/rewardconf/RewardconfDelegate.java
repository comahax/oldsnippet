/**
* auto-generated code
* Thu Mar 05 16:13:38 CST 2009
*/
package com.sunrise.boss.delegate.cms.reward.rewardconf;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.rewardconf.persistent.RewardconfVO;
import com.sunrise.boss.business.cms.reward.rewardconf.persistent.RewardconfListVO;
import com.sunrise.boss.business.cms.reward.rewardconf.control.RewardconfControlBean;
import com.sunrise.boss.business.cms.reward.rewardconf.control.RewardconfControl;

import java.io.Serializable;
import java.util.List;

/**
 * <p>Title: RewardconfDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
public class RewardconfDelegate {

    private static RewardconfControl control;

    public RewardconfDelegate() throws Exception {
        control = (RewardconfControl) ControlFactory.build(RewardconfControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public RewardconfVO doCreate(RewardconfVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(RewardconfVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public RewardconfVO doUpdate(RewardconfVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public RewardconfVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (RewardconfVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(RewardconfListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }
    
    public List doCheckRewardconf(String rewardmonth,
			String rewardkind, User user) throws Exception{
    	return control.doCheckRewardconf(rewardmonth,rewardkind, user);
    }
    
    public List doCheckUnRewardconf(String rewardmonth,
			String rewardkind, User user) throws Exception{
    	return control.doCheckUnRewardconf(rewardmonth,rewardkind, user);
    }

}
