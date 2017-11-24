/**
* auto-generated code
* Sat Dec 03 10:15:10 CST 2011
*/
package com.sunrise.boss.delegate.cms.bbc.servicelog;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.bbc.servicelog.persistent.ServicelogVO;
import com.sunrise.boss.business.cms.bbc.servicelog.persistent.ServicelogListVO;
import com.sunrise.boss.business.cms.bbc.servicelog.control.ServicelogControlBean;
import com.sunrise.boss.business.cms.bbc.servicelog.control.ServicelogControl;

import java.io.Serializable;

/**
 * <p>Title: ServicelogDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
public class ServicelogDelegate {

    private static ServicelogControl control;

    public ServicelogDelegate() throws Exception {
        control = (ServicelogControl) ControlFactory.build(ServicelogControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public ServicelogVO doCreate(ServicelogVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(ServicelogVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public ServicelogVO doUpdate(ServicelogVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public ServicelogVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (ServicelogVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(ServicelogListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
