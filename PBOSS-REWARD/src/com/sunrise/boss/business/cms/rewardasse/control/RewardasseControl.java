/**
* auto-generated code
* Thu Jan 31 15:08:13 CST 2008
*/
package com.sunrise.boss.business.cms.rewardasse.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.rewardasse.persistent.RewardasseDAO;
import com.sunrise.boss.business.cms.rewardasse.persistent.RewardasseVO;
import com.sunrise.boss.business.cms.rewardasse.persistent.RewardasseListVO;

import java.io.Serializable;

/**
 * <p>Title: RewardasseControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author xiangyin
 * @version 1.0
 */
public interface RewardasseControl extends AbstractControl {
    public RewardasseVO doCreate(RewardasseVO vo, User user)
        throws Exception;

    public void doRemove(RewardasseVO vo, User user)
        throws Exception;

    public RewardasseVO doUpdate(RewardasseVO vo, User user)
        throws Exception;

    public RewardasseVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(RewardasseListVO params, User user)
        throws Exception;

    public boolean doQueryRewardtype(Integer rewardtype, User user)
	throws Exception;
    
    public DataPackage doQuery4Syn(RewardasseListVO params, User user)
    throws Exception ;
    
}
