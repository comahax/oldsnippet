/**
* auto-generated code
* Fri Aug 28 11:17:48 CST 2009
*/
package com.sunrise.boss.delegate.cms.reward.busitocom;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.busitocom.persistent.BusitocomVO;
import com.sunrise.boss.business.cms.reward.busitocom.persistent.BusitocomListVO;
import com.sunrise.boss.business.cms.reward.busitocom.control.BusitocomControlBean;
import com.sunrise.boss.business.cms.reward.busitocom.control.BusitocomControl;

import java.io.Serializable;

/**
 * <p>Title: BusitocomDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
public class BusitocomDelegate {

    private static BusitocomControl control;

    public BusitocomDelegate() throws Exception {
        control = (BusitocomControl) ControlFactory.build(BusitocomControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public BusitocomVO doCreate(BusitocomVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(BusitocomVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public BusitocomVO doUpdate(BusitocomVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public BusitocomVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (BusitocomVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(BusitocomListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
