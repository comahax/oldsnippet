/**
* auto-generated code
* Fri Feb 01 11:50:09 CST 2013
*/
package com.sunrise.boss.delegate.cms.chadtclassplatformbrandinfo;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.chadtclassplatformbrandinfo.persistent.ChAdtClassplatformbrandinfoVO;
import com.sunrise.boss.business.cms.chadtclassplatformbrandinfo.persistent.ChAdtClassplatformbrandinfoListVO;
import com.sunrise.boss.business.cms.chadtclassplatformbrandinfo.control.ChAdtClassplatformbrandinfoControlBean;
import com.sunrise.boss.business.cms.chadtclassplatformbrandinfo.control.ChAdtClassplatformbrandinfoControl;

import java.io.Serializable;

/**
 * <p>Title: ChAdtClassplatformbrandinfoDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author limin
 * @version 1.0
 */
public class ChAdtClassplatformbrandinfoDelegate {

    private static ChAdtClassplatformbrandinfoControl control;

    public ChAdtClassplatformbrandinfoDelegate() throws Exception {
        control = (ChAdtClassplatformbrandinfoControl) ControlFactory.build(ChAdtClassplatformbrandinfoControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public ChAdtClassplatformbrandinfoVO doCreate(ChAdtClassplatformbrandinfoVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(ChAdtClassplatformbrandinfoVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public ChAdtClassplatformbrandinfoVO doUpdate(ChAdtClassplatformbrandinfoVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public ChAdtClassplatformbrandinfoVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (ChAdtClassplatformbrandinfoVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(ChAdtClassplatformbrandinfoListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
