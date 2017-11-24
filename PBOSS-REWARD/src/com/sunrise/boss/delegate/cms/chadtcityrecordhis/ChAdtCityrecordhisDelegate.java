/**
* auto-generated code
* Mon Sep 03 20:43:09 CST 2012
*/
package com.sunrise.boss.delegate.cms.chadtcityrecordhis;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.chadtcityrecordhis.persistent.ChAdtCityrecordhisVO;
import com.sunrise.boss.business.cms.chadtcityrecordhis.persistent.ChAdtCityrecordhisListVO;
import com.sunrise.boss.business.cms.chadtcityrecordhis.control.ChAdtCityrecordhisControlBean;
import com.sunrise.boss.business.cms.chadtcityrecordhis.control.ChAdtCityrecordhisControl;

import java.io.Serializable;

/**
 * <p>Title: ChAdtCityrecordhisDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liyanling
 * @version 1.0
 */
public class ChAdtCityrecordhisDelegate {

    private static ChAdtCityrecordhisControl control;

    public ChAdtCityrecordhisDelegate() throws Exception {
        control = (ChAdtCityrecordhisControl) ControlFactory.build(ChAdtCityrecordhisControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public ChAdtCityrecordhisVO doCreate(ChAdtCityrecordhisVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(ChAdtCityrecordhisVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public ChAdtCityrecordhisVO doUpdate(ChAdtCityrecordhisVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public ChAdtCityrecordhisVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (ChAdtCityrecordhisVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(ChAdtCityrecordhisListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
