/**
* auto-generated code
* Mon Sep 15 18:12:26 CST 2008
*/
package com.sunrise.boss.delegate.cms.reward.rewardpoolywlog;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.rewardpoolywlog.control.RewardpoolywlogControl;
import com.sunrise.boss.business.cms.reward.rewardpoolywlog.control.RewardpoolywlogControlBean;
import com.sunrise.boss.business.cms.reward.rewardpoolywlog.persistent.RewardpoolywlogVO;
import com.sunrise.boss.business.cms.reward.rewardpoolywlog.persistent.RewardpoolywlogListVO;

import java.io.Serializable;

/**
 * <p>Title: RewardpoolywlogDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class RewardpoolywlogDelegate {

    private static RewardpoolywlogControl control;

    public RewardpoolywlogDelegate() throws Exception {
        control = (RewardpoolywlogControl) ControlFactory.build(RewardpoolywlogControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public RewardpoolywlogVO doCreate(RewardpoolywlogVO vo, User user )
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(RewardpoolywlogVO vo, User user )
        throws Exception {
        control.doRemove(vo, user);
    }
    public RewardpoolywlogVO doUpdate(RewardpoolywlogVO vo, User user )
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public RewardpoolywlogVO doFindByPk(Serializable pk, User user )
        throws Exception {
        return (RewardpoolywlogVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(RewardpoolywlogListVO params, User user )
        throws Exception {
        return control.doQuery(params, user);
    }
}
