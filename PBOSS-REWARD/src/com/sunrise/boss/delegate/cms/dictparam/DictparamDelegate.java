/**
* auto-generated code
* Wed Feb 23 10:33:30 CST 2011
*/
package com.sunrise.boss.delegate.cms.dictparam;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.dictparam.persistent.DictparamVO;
import com.sunrise.boss.business.cms.dictparam.persistent.DictparamListVO;
import com.sunrise.boss.business.cms.dictparam.control.DictparamControlBean;
import com.sunrise.boss.business.cms.dictparam.control.DictparamControl;

import java.io.Serializable;

/**
 * <p>Title: DictparamDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jemy
 * @version 1.0
 */
public class DictparamDelegate {

    private static DictparamControl control;

    public DictparamDelegate() throws Exception {
        control = (DictparamControl) ControlFactory.build(DictparamControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public DictparamVO doCreate(DictparamVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(DictparamVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public DictparamVO doUpdate(DictparamVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public DictparamVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (DictparamVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(DictparamListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
