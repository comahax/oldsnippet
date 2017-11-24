/**
* auto-generated code
* Thu May 19 16:35:37 CST 2011
*/
package com.sunrise.boss.business.cms.rewardreport.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.rewardreport.persistent.RewardreportVO;
import com.sunrise.boss.business.cms.rewardreport.persistent.RewardreportListVO;

import java.io.Serializable;

/**
 * <p>Title: RewardreportControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yangdaren
 * @version 1.0
 */
public interface RewardreportControl extends AbstractControl {
    public RewardreportVO doCreate(RewardreportVO vo, User user)
        throws Exception;

    public void doRemove(RewardreportVO vo, User user)
        throws Exception;

    public RewardreportVO doUpdate(RewardreportVO vo, User user)
        throws Exception;

    public RewardreportVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(RewardreportListVO params, User user)
        throws Exception;

    public DataPackage doQuery2(RewardreportListVO params, User user)
    	throws Exception;
}
