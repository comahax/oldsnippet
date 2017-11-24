/**
* auto-generated code
* Mon Jan 14 14:13:07 CST 2013
*/
package com.sunrise.boss.delegate.cms.chadtsales;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.chadtsales.persistent.ChAdtSalesVO;
import com.sunrise.boss.business.cms.chadtsales.persistent.ChAdtSalesListVO;
import com.sunrise.boss.business.cms.chadtsales.control.ChAdtSalesControlBean;
import com.sunrise.boss.business.cms.chadtsales.control.ChAdtSalesControl;

import java.io.Serializable;

/**
 * <p>Title: ChAdtSalesDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author limin
 * @version 1.0
 */
public class ChAdtSalesDelegate {

    private static ChAdtSalesControl control;

    public ChAdtSalesDelegate() throws Exception {
        control = (ChAdtSalesControl) ControlFactory.build(ChAdtSalesControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public ChAdtSalesVO doCreate(ChAdtSalesVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(ChAdtSalesVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public ChAdtSalesVO doUpdate(ChAdtSalesVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public ChAdtSalesVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (ChAdtSalesVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(ChAdtSalesListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
