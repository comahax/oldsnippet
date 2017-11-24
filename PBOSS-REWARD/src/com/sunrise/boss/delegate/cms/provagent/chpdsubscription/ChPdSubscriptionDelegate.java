/**
* auto-generated code
* Tue Sep 03 21:23:23 CST 2013
*/
package com.sunrise.boss.delegate.cms.provagent.chpdsubscription;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.provagent.chpdsubscription.control.ChPdSubscriptionControl;
import com.sunrise.boss.business.cms.provagent.chpdsubscription.control.ChPdSubscriptionControlBean;
import com.sunrise.boss.business.cms.provagent.chpdsubscription.persistent.ChPdSubscriptionListVO;
import com.sunrise.boss.business.cms.provagent.chpdsubscription.persistent.ChPdSubscriptionVO;

import java.io.Serializable;

/**
 * <p>Title: ChPdSubscriptionDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Qiu Zhi
 * @version 1.0
 */
public class ChPdSubscriptionDelegate {

    private static ChPdSubscriptionControl control;

    public ChPdSubscriptionDelegate() throws Exception {
        control = (ChPdSubscriptionControl) ControlFactory.build(ChPdSubscriptionControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public ChPdSubscriptionVO doCreate(ChPdSubscriptionVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(ChPdSubscriptionVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public ChPdSubscriptionVO doUpdate(ChPdSubscriptionVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public ChPdSubscriptionVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (ChPdSubscriptionVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(ChPdSubscriptionListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
