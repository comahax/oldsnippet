/**
* auto-generated code
* Sun Nov 29 14:15:38 CST 2009
*/
package com.sunrise.boss.delegate.cms.examine.coefficient;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.examine.coefficient.persistent.CoefficientVO;
import com.sunrise.boss.business.cms.examine.coefficient.persistent.CoefficientListVO;
import com.sunrise.boss.business.cms.examine.coefficient.control.CoefficientControlBean;
import com.sunrise.boss.business.cms.examine.coefficient.control.CoefficientControl;

import java.io.Serializable;

/**
 * <p>Title: CoefficientDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class CoefficientDelegate {

    private static CoefficientControl control;

    public CoefficientDelegate() throws Exception {
        control = (CoefficientControl) ControlFactory.build(CoefficientControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public CoefficientVO doCreate(CoefficientVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(CoefficientVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public CoefficientVO doUpdate(CoefficientVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public CoefficientVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (CoefficientVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(CoefficientListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
