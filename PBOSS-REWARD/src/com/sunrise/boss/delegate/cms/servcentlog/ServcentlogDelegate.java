/**
* auto-generated code
* Mon Apr 16 17:14:45 CST 2007
*/
package com.sunrise.boss.delegate.cms.servcentlog;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.servcentlog.control.ServcentlogControl;
import com.sunrise.boss.business.cms.servcentlog.control.ServcentlogControlBean;
import com.sunrise.boss.business.cms.servcentlog.persistent.ServcentlogVO;
import com.sunrise.boss.business.cms.servcentlog.persistent.ServcentlogListVO;

import java.io.Serializable;

/**
 * <p>Title: ServcentlogDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author Ye Daoe
 * @version 1.0
 */
public class ServcentlogDelegate {

    private static ServcentlogControl control;

    public ServcentlogDelegate() throws Exception {
        control = (ServcentlogControl) ControlFactory.build(ServcentlogControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public ServcentlogVO doCreate(ServcentlogVO vo, User user )
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(ServcentlogVO vo, User user )
        throws Exception {
        control.doRemove(vo, user);
    }
    public ServcentlogVO doUpdate(ServcentlogVO vo, User user )
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public ServcentlogVO doFindByPk(Serializable pk, User user )
        throws Exception {
        return (ServcentlogVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(ServcentlogListVO params, User user )
        throws Exception {
        return control.doQuery(params, user);
    }
}
