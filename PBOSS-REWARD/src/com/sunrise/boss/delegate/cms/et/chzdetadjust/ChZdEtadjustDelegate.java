/**
* auto-generated code
* Thu May 09 16:24:13 CST 2013
*/
package com.sunrise.boss.delegate.cms.et.chzdetadjust;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.et.chzdetadjust.persistent.ChZdEtadjustVO;
import com.sunrise.boss.business.cms.et.chzdetadjust.persistent.ChZdEtadjustListVO;
import com.sunrise.boss.business.cms.et.chzdetadjust.control.ChZdEtadjustControlBean;
import com.sunrise.boss.business.cms.et.chzdetadjust.control.ChZdEtadjustControl;

import java.io.Serializable;

/**
 * <p>Title: ChZdEtadjustDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Qiu Zhi
 * @version 1.0
 */
public class ChZdEtadjustDelegate {

    private static ChZdEtadjustControl control;

    public ChZdEtadjustDelegate() throws Exception {
        control = (ChZdEtadjustControl) ControlFactory.build(ChZdEtadjustControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public ChZdEtadjustVO doCreate(ChZdEtadjustVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(ChZdEtadjustVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public ChZdEtadjustVO doUpdate(ChZdEtadjustVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public ChZdEtadjustVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (ChZdEtadjustVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(ChZdEtadjustListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
