/**
* auto-generated code
* Sat Feb 02 14:33:50 CST 2008
*/
package com.sunrise.boss.business.cms.reward.rewardrecord.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.rewardrecord.persistent.RewardrecordVO;
import com.sunrise.boss.business.cms.reward.rewardrecord.persistent.RewardrecordListVO;

import java.io.Serializable;


/**
 * <p>Title: RewardrecordControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface RewardrecordControl extends AbstractControl {
    public RewardrecordVO doCreate(RewardrecordVO vo, User user)
        throws Exception;

    public void doRemove(RewardrecordVO vo, User user)
        throws Exception;

    public RewardrecordVO doUpdate(RewardrecordVO vo, User user)
        throws Exception;

    public RewardrecordVO doFindByPk(Serializable pk, User user)
        throws Exception;
    public DataPackage doQuery(RewardrecordListVO params, User user,String purview,String countyid)
    	throws Exception;
    
    public DataPackage doQuery2(RewardrecordListVO params, User user)
		throws Exception;

    public DataPackage doQuery3(RewardrecordListVO params, User user)
	throws Exception;
    public DataPackage doQuery4ThreadTotal(RewardrecordListVO params, User user)
	throws Exception ;
}
