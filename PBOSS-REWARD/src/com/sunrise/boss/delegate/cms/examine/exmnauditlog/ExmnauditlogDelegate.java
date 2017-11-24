/**
* auto-generated code
* Sat Nov 28 17:58:40 CST 2009
*/
package com.sunrise.boss.delegate.cms.examine.exmnauditlog;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.examine.exmnauditlog.persistent.ExmnauditlogVO;
import com.sunrise.boss.business.cms.examine.exmnauditlog.persistent.ExmnauditlogListVO;
import com.sunrise.boss.business.cms.examine.exmnauditlog.control.ExmnauditlogControlBean;
import com.sunrise.boss.business.cms.examine.exmnauditlog.control.ExmnauditlogControl;

import java.io.Serializable;

/**
 * <p>Title: ExmnauditlogDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ExmnauditlogDelegate {

    private static ExmnauditlogControl control;

    public ExmnauditlogDelegate() throws Exception {
        control = (ExmnauditlogControl) ControlFactory.build(ExmnauditlogControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public ExmnauditlogVO doCreate(ExmnauditlogVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(ExmnauditlogVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public ExmnauditlogVO doUpdate(ExmnauditlogVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public ExmnauditlogVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (ExmnauditlogVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(ExmnauditlogListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
