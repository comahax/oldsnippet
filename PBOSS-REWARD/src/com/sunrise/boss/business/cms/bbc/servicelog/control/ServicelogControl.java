/**
* auto-generated code
* Sat Dec 03 10:15:10 CST 2011
*/
package com.sunrise.boss.business.cms.bbc.servicelog.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.bbc.servicelog.persistent.ServicelogVO;
import com.sunrise.boss.business.cms.bbc.servicelog.persistent.ServicelogListVO;

import java.io.Serializable;

/**
 * <p>Title: ServicelogControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
public interface ServicelogControl extends AbstractControl {
    public ServicelogVO doCreate(ServicelogVO vo, User user)
        throws Exception;

    public void doRemove(ServicelogVO vo, User user)
        throws Exception;

    public ServicelogVO doUpdate(ServicelogVO vo, User user)
        throws Exception;

    public ServicelogVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(ServicelogListVO params, User user)
        throws Exception;

}
