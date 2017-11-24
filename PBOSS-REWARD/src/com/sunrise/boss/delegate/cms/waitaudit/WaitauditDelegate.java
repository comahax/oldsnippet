/**
* auto-generated code
* Fri Sep 12 10:00:33 CST 2008
*/
package com.sunrise.boss.delegate.cms.waitaudit;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.waitaudit.control.WaitauditControl;
import com.sunrise.boss.business.cms.waitaudit.control.WaitauditControlBean;
import com.sunrise.boss.business.cms.waitaudit.persistent.WaitauditVO;
import com.sunrise.boss.business.cms.waitaudit.persistent.WaitauditListVO;

import java.io.Serializable;

/**
 * <p>Title: WaitauditDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class WaitauditDelegate {

    private static WaitauditControl control;

    public WaitauditDelegate() throws Exception {
        control = (WaitauditControl) ControlFactory.build(WaitauditControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public WaitauditVO doCreate(WaitauditVO vo, User user )
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(WaitauditVO vo, User user )
        throws Exception {
        control.doRemove(vo, user);
    }
    public WaitauditVO doUpdate(WaitauditVO vo, User user )
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public WaitauditVO doFindByPk(Serializable pk, User user )
        throws Exception {
        return (WaitauditVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(WaitauditListVO params, User user )
        throws Exception {
        return control.doQuery(params, user);
    }
}
