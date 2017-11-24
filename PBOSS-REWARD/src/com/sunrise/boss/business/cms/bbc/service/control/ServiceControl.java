/**
* auto-generated code
* Sat Dec 03 10:12:28 CST 2011
*/
package com.sunrise.boss.business.cms.bbc.service.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.bbc.service.persistent.ServiceVO;
import com.sunrise.boss.business.cms.bbc.service.persistent.ServiceListVO;

import java.io.Serializable;

/**
 * <p>Title: ServiceControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
public interface ServiceControl extends AbstractControl {
    public ServiceVO doCreate(ServiceVO vo, User user)
        throws Exception;

    public void doRemove(ServiceVO vo, User user)
        throws Exception;

    public ServiceVO doUpdate(ServiceVO vo, User user)
        throws Exception;

    public ServiceVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(ServiceListVO params, User user)
        throws Exception;

}
