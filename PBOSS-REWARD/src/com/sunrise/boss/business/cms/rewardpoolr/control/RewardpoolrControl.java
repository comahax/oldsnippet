/**
* auto-generated code
* Fri Feb 01 18:16:01 CST 2008
*/
package com.sunrise.boss.business.cms.rewardpoolr.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.rewardpoolr.persistent.RewardpoolrVO;
import com.sunrise.boss.business.cms.rewardpoolr.persistent.RewardpoolrListVO;

import java.io.Serializable;

/**
 * <p>Title: RewardpoolrControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface RewardpoolrControl extends AbstractControl {
    public RewardpoolrVO doCreate(RewardpoolrVO vo, User user)
        throws Exception;

    public void doRemove(RewardpoolrVO vo, User user)
        throws Exception;

    public RewardpoolrVO doUpdate(RewardpoolrVO vo, User user)
        throws Exception;

    public RewardpoolrVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(RewardpoolrListVO params, User user)
        throws Exception;

}
