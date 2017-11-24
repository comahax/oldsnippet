/**
* auto-generated code
* Thu Jul 28 10:25:58 CST 2011
*/
package com.sunrise.boss.business.cms.rewardsms.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.rewardsms.persistent.RewardsmsVO;
import com.sunrise.boss.business.cms.rewardsms.persistent.RewardsmsListVO;

import java.io.Serializable;

/**
 * <p>Title: RewardsmsControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yangdaren
 * @version 1.0
 */
public interface RewardsmsControl extends AbstractControl {
    public RewardsmsVO doCreate(RewardsmsVO vo, User user)
        throws Exception;

    public void doRemove(RewardsmsVO vo, User user)
        throws Exception;

    public RewardsmsVO doUpdate(RewardsmsVO vo, User user)
        throws Exception;

    public RewardsmsVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(RewardsmsListVO params, User user)
        throws Exception;
    
    public RewardsmsVO doCreate1(RewardsmsVO vo, User user)
    	throws Exception;
}
