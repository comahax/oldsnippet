/**
* auto-generated code
* Thu Jan 31 17:14:30 CST 2008
*/
package com.sunrise.boss.business.cms.rewardasselog.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.rewardasselog.persistent.RewardasselogVO;
import com.sunrise.boss.business.cms.rewardasselog.persistent.RewardasselogListVO;

import java.io.Serializable;

/**
 * <p>Title: RewardasselogControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author xiangyin
 * @version 1.0
 */
public interface RewardasselogControl extends AbstractControl {
    public RewardasselogVO doCreate(RewardasselogVO vo, User user)
        throws Exception;

    public void doRemove(RewardasselogVO vo, User user)
        throws Exception;

    public RewardasselogVO doUpdate(RewardasselogVO vo, User user)
        throws Exception;

    public RewardasselogVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(RewardasselogListVO params, User user)
        throws Exception;

}
