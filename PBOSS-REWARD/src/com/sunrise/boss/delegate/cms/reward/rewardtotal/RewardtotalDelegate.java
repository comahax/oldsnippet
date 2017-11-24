/**
* auto-generated code
* Tue Aug 29 11:32:31 CST 2006
*/
package com.sunrise.boss.delegate.cms.reward.rewardtotal;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.rewardtotal.control.RewardtotalControl;
import com.sunrise.boss.business.cms.reward.rewardtotal.control.RewardtotalControlBean;
import com.sunrise.boss.business.cms.reward.rewardtotal.persistent.RewardtotalListVO;
import com.sunrise.boss.business.cms.reward.rewardtotal.persistent.RewardtotalVO;

import java.io.Serializable;

/**
 * <p>Title: ResoprdataDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author yjr
 * @version 1.0
 */
public class RewardtotalDelegate {

    private static RewardtotalControl control;

    public RewardtotalDelegate() throws Exception {
        control = (RewardtotalControl) ControlFactory.build(RewardtotalControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public RewardtotalVO doFindByPk(Serializable pk, User user )
        throws Exception {
        return (RewardtotalVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(RewardtotalListVO params, User user )
        throws Exception {
        return control.doQuery(params, user);
    }
}
