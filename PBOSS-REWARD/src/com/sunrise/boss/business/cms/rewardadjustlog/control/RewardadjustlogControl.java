/**
* auto-generated code
* Wed Dec 24 11:06:41 CST 2008
*/
package com.sunrise.boss.business.cms.rewardadjustlog.control;

import java.io.Serializable;

import com.sunrise.boss.business.cms.rewardadjustlog.persistent.RewardadjustlogListVO;
import com.sunrise.boss.business.cms.rewardadjustlog.persistent.RewardadjustlogVO;
import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: RewardadjustlogControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface RewardadjustlogControl extends AbstractControl {
    public RewardadjustlogVO doCreate(RewardadjustlogVO vo, User user)
        throws Exception;

    public void doRemove(RewardadjustlogVO vo, User user)
        throws Exception;

    public RewardadjustlogVO doUpdate(RewardadjustlogVO vo, User user)
        throws Exception;

    public RewardadjustlogVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(RewardadjustlogListVO params, User user)
        throws Exception;

}
