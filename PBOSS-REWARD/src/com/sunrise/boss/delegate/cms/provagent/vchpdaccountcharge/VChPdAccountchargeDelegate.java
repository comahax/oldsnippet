/**
* auto-generated code
* Wed Sep 04 20:56:32 CST 2013
*/
package com.sunrise.boss.delegate.cms.provagent.vchpdaccountcharge;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.provagent.vchpdaccountcharge.persistent.VChPdAccountchargeVO;
import com.sunrise.boss.business.cms.provagent.vchpdaccountcharge.persistent.VChPdAccountchargeListVO;
import com.sunrise.boss.business.cms.provagent.vchpdaccountcharge.control.VChPdAccountchargeControlBean;
import com.sunrise.boss.business.cms.provagent.vchpdaccountcharge.control.VChPdAccountchargeControl;

import java.io.Serializable;

/**
 * <p>Title: VChPdAccountchargeDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Qiu Zhi
 * @version 1.0
 */
public class VChPdAccountchargeDelegate {

    private static VChPdAccountchargeControl control;

    public VChPdAccountchargeDelegate() throws Exception {
        control = (VChPdAccountchargeControl) ControlFactory.build(VChPdAccountchargeControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public VChPdAccountchargeVO doCreate(VChPdAccountchargeVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(VChPdAccountchargeVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public VChPdAccountchargeVO doUpdate(VChPdAccountchargeVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public VChPdAccountchargeVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (VChPdAccountchargeVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(VChPdAccountchargeListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
