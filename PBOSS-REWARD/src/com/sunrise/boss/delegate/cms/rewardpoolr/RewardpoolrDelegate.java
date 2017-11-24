/**
* auto-generated code
* Fri Feb 01 18:16:01 CST 2008
*/
package com.sunrise.boss.delegate.cms.rewardpoolr;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.rewardpoolr.control.RewardpoolrControl;
import com.sunrise.boss.business.cms.rewardpoolr.control.RewardpoolrControlBean;
import com.sunrise.boss.business.cms.rewardpoolr.persistent.RewardpoolrVO;
import com.sunrise.boss.business.cms.rewardpoolr.persistent.RewardpoolrListVO;

import java.io.Serializable;

/**
 * <p>Title: RewardpoolrDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class RewardpoolrDelegate {

    private static RewardpoolrControl control;

    public RewardpoolrDelegate() throws Exception {
        control = (RewardpoolrControl) ControlFactory.build(RewardpoolrControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public RewardpoolrVO doCreate(RewardpoolrVO vo, User user )
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(RewardpoolrVO vo, User user )
        throws Exception {
        control.doRemove(vo, user);
    }
    public RewardpoolrVO doUpdate(RewardpoolrVO vo, User user )
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public RewardpoolrVO doFindByPk(Serializable pk, User user )
        throws Exception {
        return (RewardpoolrVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(RewardpoolrListVO params, User user )
        throws Exception {
        return control.doQuery(params, user);
    }
}
