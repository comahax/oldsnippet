/**
* auto-generated code
* Sat Feb 02 14:33:50 CST 2008
*/
package com.sunrise.boss.delegate.cms.reward.rewardrecord;

import com.sunrise.boss.business.cms.reward.rewardrecord.control.RewardrecordControl;
import com.sunrise.boss.business.cms.reward.rewardrecord.control.RewardrecordControlBean;
import com.sunrise.boss.business.cms.reward.rewardrecord.persistent.RewardrecordListVO;
import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;


/**
 * <p>Title: RewardrecordDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class RewardrecordDelegate {

    private static RewardrecordControl control;

    public RewardrecordDelegate() throws Exception {
        control = (RewardrecordControl) ControlFactory.build(RewardrecordControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public DataPackage doQuery(RewardrecordListVO params, User user,String purview,String countyid)
        throws Exception {
        return control.doQuery(params, user,purview,countyid);
    }
}
