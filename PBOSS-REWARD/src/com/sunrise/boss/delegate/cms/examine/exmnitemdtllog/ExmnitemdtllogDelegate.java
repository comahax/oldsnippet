/**
* auto-generated code
* Wed Nov 25 11:17:17 CST 2009
*/
package com.sunrise.boss.delegate.cms.examine.exmnitemdtllog;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.examine.exmnitemdtllog.persistent.ExmnitemdtllogVO;
import com.sunrise.boss.business.cms.examine.exmnitemdtllog.persistent.ExmnitemdtllogListVO;
import com.sunrise.boss.business.cms.examine.exmnitemdtllog.control.ExmnitemdtllogControlBean;
import com.sunrise.boss.business.cms.examine.exmnitemdtllog.control.ExmnitemdtllogControl;

import java.io.Serializable;

/**
 * <p>Title: ExmnitemdtllogDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ExmnitemdtllogDelegate {

    private static ExmnitemdtllogControl control;

    public ExmnitemdtllogDelegate() throws Exception {
        control = (ExmnitemdtllogControl) ControlFactory.build(ExmnitemdtllogControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public ExmnitemdtllogVO doCreate(ExmnitemdtllogVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(ExmnitemdtllogVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public ExmnitemdtllogVO doUpdate(ExmnitemdtllogVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public ExmnitemdtllogVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (ExmnitemdtllogVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(ExmnitemdtllogListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
