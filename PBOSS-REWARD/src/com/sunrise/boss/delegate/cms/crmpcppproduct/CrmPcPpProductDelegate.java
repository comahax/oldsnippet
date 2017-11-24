/**
* auto-generated code
* Thu Dec 12 20:04:12 CST 2013
*/
package com.sunrise.boss.delegate.cms.crmpcppproduct;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.crmpcppproduct.persistent.CrmPcPpProductVO;
import com.sunrise.boss.business.cms.crmpcppproduct.persistent.CrmPcPpProductListVO;
import com.sunrise.boss.business.cms.crmpcppproduct.control.CrmPcPpProductControlBean;
import com.sunrise.boss.business.cms.crmpcppproduct.control.CrmPcPpProductControl;

import java.io.Serializable;

/**
 * <p>Title: CrmPcPpProductDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author hejw
 * @version 1.0
 */
public class CrmPcPpProductDelegate {

    private static CrmPcPpProductControl control;

    public CrmPcPpProductDelegate() throws Exception {
        control = (CrmPcPpProductControl) ControlFactory.build(CrmPcPpProductControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public CrmPcPpProductVO doCreate(CrmPcPpProductVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(CrmPcPpProductVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public CrmPcPpProductVO doUpdate(CrmPcPpProductVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public CrmPcPpProductVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (CrmPcPpProductVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(CrmPcPpProductListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
