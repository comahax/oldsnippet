/**
* auto-generated code
* Sat Dec 03 10:12:28 CST 2011
*/
package com.sunrise.boss.delegate.cms.bbc.service;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.bbc.service.persistent.ServiceVO;
import com.sunrise.boss.business.cms.bbc.service.persistent.ServiceListVO;
import com.sunrise.boss.business.cms.bbc.service.control.ServiceControlBean;
import com.sunrise.boss.business.cms.bbc.service.control.ServiceControl;

import java.io.Serializable;

/**
 * <p>Title: ServiceDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
public class ServiceDelegate {

    private static ServiceControl control;

    public ServiceDelegate() throws Exception {
        control = (ServiceControl) ControlFactory.build(ServiceControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public ServiceVO doCreate(ServiceVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(ServiceVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public ServiceVO doUpdate(ServiceVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public ServiceVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (ServiceVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(ServiceListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

}
