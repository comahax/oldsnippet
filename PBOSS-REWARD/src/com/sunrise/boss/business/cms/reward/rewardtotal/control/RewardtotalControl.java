/**
* auto-generated code
* Wed Apr 04 10:31:36 CST 2007
*/
package com.sunrise.boss.business.cms.reward.rewardtotal.control;

import com.sunrise.boss.business.cms.reward.rewardtotal.persistent.RewardtotalListVO;
import com.sunrise.boss.business.cms.reward.rewardtotal.persistent.RewardtotalVO;
import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;

import java.io.Serializable;

/**
 * <p>Title: RvwaycntControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author yuanweihai
 * @version 1.0
 */
public interface RewardtotalControl extends AbstractControl {

    public RewardtotalVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(RewardtotalListVO params, User user)
        throws Exception;
}
