/**
* auto-generated code
* Tue May 01 15:19:40 CST 2007
*/
package com.sunrise.boss.delegate.cms.operationlog;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.operationlog.control.OperationlogControl;
import com.sunrise.boss.business.cms.operationlog.control.OperationlogControlBean;
import com.sunrise.boss.business.cms.operationlog.persistent.OperationlogVO;
import com.sunrise.boss.business.cms.operationlog.persistent.OperationlogListVO;

import java.io.Serializable;

/**
 * <p>Title: OperationlogDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class OperationlogDelegate {

    private static OperationlogControl control;

    public OperationlogDelegate() throws Exception {
        control = (OperationlogControl) ControlFactory.build(OperationlogControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public OperationlogVO doCreate(OperationlogVO vo, User user )
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(OperationlogVO vo, User user )
        throws Exception {
        control.doRemove(vo, user);
    }
    public OperationlogVO doUpdate(OperationlogVO vo, User user )
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public OperationlogVO doFindByPk(Serializable pk, User user )
        throws Exception {
        return (OperationlogVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(OperationlogListVO params, User user )
        throws Exception {
        return control.doQuery(params, user);
    }
}
