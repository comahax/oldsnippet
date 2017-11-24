/**
* auto-generated code
* Mon Sep 15 18:11:42 CST 2008
*/
package com.sunrise.boss.delegate.cms.reward.rewardpoolyw;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.rewardpoolyw.control.RewardpoolywControl;
import com.sunrise.boss.business.cms.reward.rewardpoolyw.control.RewardpoolywControlBean;
import com.sunrise.boss.business.cms.reward.rewardpoolyw.persistent.RewardpoolywVO;
import com.sunrise.boss.business.cms.reward.rewardpoolyw.persistent.RewardpoolywListVO;

import java.io.Serializable;

/**
 * <p>Title: RewardpoolywDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class RewardpoolywDelegate {

    private static RewardpoolywControl control;

    public RewardpoolywDelegate() throws Exception {
        control = (RewardpoolywControl) ControlFactory.build(RewardpoolywControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public RewardpoolywVO doCreate(RewardpoolywVO vo, User user )
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(RewardpoolywVO vo, User user )
        throws Exception {
        control.doRemove(vo, user);
    }
    public RewardpoolywVO doUpdate(RewardpoolywVO vo, User user )
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public RewardpoolywVO doFindByPk(Serializable pk, User user )
        throws Exception {
        return (RewardpoolywVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(RewardpoolywListVO params, User user )
        throws Exception {
        return control.doQuery(params, user);
    }
}
