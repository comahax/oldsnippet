/**
* auto-generated code
* Mon Jan 14 11:41:04 CST 2013
*/
package com.sunrise.boss.delegate.cms.chadtsaleslog;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.chadtsaleslog.persistent.ChAdtSaleslogVO;
import com.sunrise.boss.business.cms.chadtsaleslog.persistent.ChAdtSaleslogListVO;
import com.sunrise.boss.business.cms.chadtsaleslog.control.ChAdtSaleslogControlBean;
import com.sunrise.boss.business.cms.chadtsaleslog.control.ChAdtSaleslogControl;

import java.io.Serializable;

/**
 * <p>Title: ChAdtSaleslogDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author limin
 * @version 1.0
 */
public class ChAdtSaleslogDelegate {

    private static ChAdtSaleslogControl control;

    public ChAdtSaleslogDelegate() throws Exception {
        control = (ChAdtSaleslogControl) ControlFactory.build(ChAdtSaleslogControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public ChAdtSaleslogVO doCreate(ChAdtSaleslogVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(ChAdtSaleslogVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public ChAdtSaleslogVO doUpdate(ChAdtSaleslogVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public ChAdtSaleslogVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (ChAdtSaleslogVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(ChAdtSaleslogListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
