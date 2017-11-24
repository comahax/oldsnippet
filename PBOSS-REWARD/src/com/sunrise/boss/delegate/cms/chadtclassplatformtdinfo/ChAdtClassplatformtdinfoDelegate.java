/**
* auto-generated code
* Fri Feb 01 12:08:34 CST 2013
*/
package com.sunrise.boss.delegate.cms.chadtclassplatformtdinfo;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.chadtclassplatformtdinfo.persistent.ChAdtClassplatformtdinfoVO;
import com.sunrise.boss.business.cms.chadtclassplatformtdinfo.persistent.ChAdtClassplatformtdinfoListVO;
import com.sunrise.boss.business.cms.chadtclassplatformtdinfo.control.ChAdtClassplatformtdinfoControlBean;
import com.sunrise.boss.business.cms.chadtclassplatformtdinfo.control.ChAdtClassplatformtdinfoControl;

import java.io.Serializable;

/**
 * <p>Title: ChAdtClassplatformtdinfoDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author limin
 * @version 1.0
 */
public class ChAdtClassplatformtdinfoDelegate {

    private static ChAdtClassplatformtdinfoControl control;

    public ChAdtClassplatformtdinfoDelegate() throws Exception {
        control = (ChAdtClassplatformtdinfoControl) ControlFactory.build(ChAdtClassplatformtdinfoControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public ChAdtClassplatformtdinfoVO doCreate(ChAdtClassplatformtdinfoVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(ChAdtClassplatformtdinfoVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public ChAdtClassplatformtdinfoVO doUpdate(ChAdtClassplatformtdinfoVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public ChAdtClassplatformtdinfoVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (ChAdtClassplatformtdinfoVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(ChAdtClassplatformtdinfoListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
