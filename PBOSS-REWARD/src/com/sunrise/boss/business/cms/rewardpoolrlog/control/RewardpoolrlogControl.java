/**
* auto-generated code
* Fri Feb 01 18:20:26 CST 2008
*/
package com.sunrise.boss.business.cms.rewardpoolrlog.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.rewardpoolrlog.persistent.RewardpoolrlogVO;
import com.sunrise.boss.business.cms.rewardpoolrlog.persistent.RewardpoolrlogListVO;

import java.io.Serializable;

/**
 * <p>Title: RewardpoolrlogControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface RewardpoolrlogControl extends AbstractControl {
    public RewardpoolrlogVO doCreate(RewardpoolrlogVO vo, User user)
        throws Exception;

    public void doRemove(RewardpoolrlogVO vo, User user)
        throws Exception;

    public RewardpoolrlogVO doUpdate(RewardpoolrlogVO vo, User user)
        throws Exception;

    public RewardpoolrlogVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(RewardpoolrlogListVO params, User user)
        throws Exception;

}
