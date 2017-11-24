/**
* auto-generated code
* Tue Sep 03 21:23:23 CST 2013
*/
package com.sunrise.boss.business.cms.provagent.chpdsubscription.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.provagent.chpdsubscription.persistent.ChPdSubscriptionListVO;
import com.sunrise.boss.business.cms.provagent.chpdsubscription.persistent.ChPdSubscriptionVO;

import java.io.Serializable;

/**
 * <p>Title: ChPdSubscriptionControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Qiu Zhi
 * @version 1.0
 */
public interface ChPdSubscriptionControl extends AbstractControl {
    public ChPdSubscriptionVO doCreate(ChPdSubscriptionVO vo, User user)
        throws Exception;

    public void doRemove(ChPdSubscriptionVO vo, User user)
        throws Exception;

    public ChPdSubscriptionVO doUpdate(ChPdSubscriptionVO vo, User user)
        throws Exception;

    public ChPdSubscriptionVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(ChPdSubscriptionListVO params, User user)
        throws Exception;

}
