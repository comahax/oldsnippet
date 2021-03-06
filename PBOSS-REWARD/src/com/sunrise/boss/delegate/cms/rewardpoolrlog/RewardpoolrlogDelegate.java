/**
* auto-generated code
* Fri Feb 01 18:20:26 CST 2008
*/
package com.sunrise.boss.delegate.cms.rewardpoolrlog;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.rewardpoolrlog.control.RewardpoolrlogControl;
import com.sunrise.boss.business.cms.rewardpoolrlog.control.RewardpoolrlogControlBean;
import com.sunrise.boss.business.cms.rewardpoolrlog.persistent.RewardpoolrlogVO;
import com.sunrise.boss.business.cms.rewardpoolrlog.persistent.RewardpoolrlogListVO;

import java.io.Serializable;

/**
 * <p>Title: RewardpoolrlogDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class RewardpoolrlogDelegate {

    private static RewardpoolrlogControl control;

    public RewardpoolrlogDelegate() throws Exception {
        control = (RewardpoolrlogControl) ControlFactory.build(RewardpoolrlogControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public RewardpoolrlogVO doCreate(RewardpoolrlogVO vo, User user )
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(RewardpoolrlogVO vo, User user )
        throws Exception {
        control.doRemove(vo, user);
    }
    public RewardpoolrlogVO doUpdate(RewardpoolrlogVO vo, User user )
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public RewardpoolrlogVO doFindByPk(Serializable pk, User user )
        throws Exception {
        return (RewardpoolrlogVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(RewardpoolrlogListVO params, User user )
        throws Exception {
        return control.doQuery(params, user);
    }
}
