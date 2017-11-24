/**
* auto-generated code
* Thu Jul 28 20:52:00 CST 2011
*/
package com.sunrise.boss.delegate.cms.rewardranlog;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.rewardranlog.persistent.RewardranlogVO;
import com.sunrise.boss.business.cms.rewardranlog.persistent.RewardranlogListVO;
import com.sunrise.boss.business.cms.rewardranlog.control.RewardranlogControlBean;
import com.sunrise.boss.business.cms.rewardranlog.control.RewardranlogControl;

import java.io.Serializable;

/**
 * <p>Title: RewardranlogDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yangdaren
 * @version 1.0
 */
public class RewardranlogDelegate {

    private static RewardranlogControl control;

    public RewardranlogDelegate() throws Exception {
        control = (RewardranlogControl) ControlFactory.build(RewardranlogControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public RewardranlogVO doCreate(RewardranlogVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(RewardranlogVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public RewardranlogVO doUpdate(RewardranlogVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public RewardranlogVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (RewardranlogVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(RewardranlogListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
