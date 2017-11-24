/**
* auto-generated code
* Wed May 15 11:11:32 CST 2013
*/
package com.sunrise.boss.delegate.cms.et.chzdetsaleinfo;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.et.chzdetsaleinfo.persistent.ChZdEtsaleinfoVO;
import com.sunrise.boss.business.cms.et.chzdetsaleinfo.persistent.ChZdEtsaleinfoListVO;
import com.sunrise.boss.business.cms.et.chzdetsaleinfo.control.ChZdEtsaleinfoControlBean;
import com.sunrise.boss.business.cms.et.chzdetsaleinfo.control.ChZdEtsaleinfoControl;

import java.io.Serializable;

/**
 * <p>Title: ChZdEtsaleinfoDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Qiu Zhi
 * @version 1.0
 */
public class ChZdEtsaleinfoDelegate {

    private static ChZdEtsaleinfoControl control;

    public ChZdEtsaleinfoDelegate() throws Exception {
        control = (ChZdEtsaleinfoControl) ControlFactory.build(ChZdEtsaleinfoControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public ChZdEtsaleinfoVO doCreate(ChZdEtsaleinfoVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(ChZdEtsaleinfoVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public ChZdEtsaleinfoVO doUpdate(ChZdEtsaleinfoVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public ChZdEtsaleinfoVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (ChZdEtsaleinfoVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(ChZdEtsaleinfoListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
