/**
* auto-generated code
* Fri Feb 01 14:20:31 CST 2013
*/
package com.sunrise.boss.delegate.cms.chadtclassplatformtdstd;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.chadtclassplatformtdstd.persistent.ChAdtClassplatformtdstdVO;
import com.sunrise.boss.business.cms.chadtclassplatformtdstd.persistent.ChAdtClassplatformtdstdListVO;
import com.sunrise.boss.business.cms.chadtclassplatformtdstd.control.ChAdtClassplatformtdstdControlBean;
import com.sunrise.boss.business.cms.chadtclassplatformtdstd.control.ChAdtClassplatformtdstdControl;

import java.io.Serializable;

/**
 * <p>Title: ChAdtClassplatformtdstdDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author limin
 * @version 1.0
 */
public class ChAdtClassplatformtdstdDelegate {

    private static ChAdtClassplatformtdstdControl control;

    public ChAdtClassplatformtdstdDelegate() throws Exception {
        control = (ChAdtClassplatformtdstdControl) ControlFactory.build(ChAdtClassplatformtdstdControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public ChAdtClassplatformtdstdVO doCreate(ChAdtClassplatformtdstdVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(ChAdtClassplatformtdstdVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public ChAdtClassplatformtdstdVO doUpdate(ChAdtClassplatformtdstdVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public ChAdtClassplatformtdstdVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (ChAdtClassplatformtdstdVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(ChAdtClassplatformtdstdListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
