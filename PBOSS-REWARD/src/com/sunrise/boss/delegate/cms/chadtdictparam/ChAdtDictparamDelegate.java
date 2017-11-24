/**
* auto-generated code
* Tue Feb 22 09:29:17 CST 2011
*/
package com.sunrise.boss.delegate.cms.chadtdictparam;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.chadtdictparam.persistent.ChAdtDictparamVO;
import com.sunrise.boss.business.cms.chadtdictparam.persistent.ChAdtDictparamListVO;
import com.sunrise.boss.business.cms.chadtdictparam.control.ChAdtDictparamControlBean;
import com.sunrise.boss.business.cms.chadtdictparam.control.ChAdtDictparamControl;

import java.io.Serializable;

/**
 * <p>Title: ChAdtDictparamDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
public class ChAdtDictparamDelegate {

    private static ChAdtDictparamControl control;

    public ChAdtDictparamDelegate() throws Exception {
        control = (ChAdtDictparamControl) ControlFactory.build(ChAdtDictparamControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public ChAdtDictparamVO doCreate(ChAdtDictparamVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(ChAdtDictparamVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public ChAdtDictparamVO doUpdate(ChAdtDictparamVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public ChAdtDictparamVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (ChAdtDictparamVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(ChAdtDictparamListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
